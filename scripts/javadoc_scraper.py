#!/usr/bin/env python3
"""
DreamBot Javadoc Scraper

Scrapes all classes from https://dreambot.org/javadocs/allclasses.html,
follows each class link, and extracts method summaries.

Output: a JSON file containing an array of class objects with their methods.

Usage:
    python javadoc_scraper.py
    python javadoc_scraper.py --output path/to/output.json
    python javadoc_scraper.py --workers 10   # parallel workers (default: 8)
    python javadoc_scraper.py --delay 0.2    # per-worker delay between requests
"""

import sys
import json
import time
import logging
import argparse
import re
import threading
from concurrent.futures import ThreadPoolExecutor, as_completed
from pathlib import Path
from urllib.parse import urljoin, urlparse
from typing import Optional

try:
    import requests
    from bs4 import BeautifulSoup
except ImportError:
    print("Error: Required packages not installed.")
    print("Install them with: pip install requests beautifulsoup4")
    sys.exit(1)

BASE_URL = "https://dreambot.org/javadocs"
ALL_CLASSES_URL = f"{BASE_URL}/allclasses.html"
DEFAULT_OUTPUT = Path(__file__).parent.parent / "docs" / "dreambot" / "javadoc_api.json"

# Thread-local sessions so each worker has its own HTTP connection pool
_thread_local = threading.local()

logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s - %(levelname)s - %(message)s"
)
logger = logging.getLogger(__name__)


def get_session() -> requests.Session:
    """Return a thread-local requests Session, creating one if needed."""
    if not hasattr(_thread_local, "session"):
        session = requests.Session()
        session.headers.update({
            "User-Agent": "DreamBot-Javadoc-Scraper/1.0 (+https://github.com)"
        })
        _thread_local.session = session
    return _thread_local.session


def fetch(url: str, retries: int = 3) -> Optional[str]:
    """Fetch HTML content from a URL with retries using a thread-local session."""
    session = get_session()
    for attempt in range(retries):
        try:
            response = session.get(url, timeout=15)
            response.raise_for_status()
            return response.text
        except requests.RequestException as e:
            wait = 2 ** attempt
            if attempt < retries - 1:
                logger.warning(f"Attempt {attempt + 1} failed for {url}: {e}. Retrying in {wait}s...")
                time.sleep(wait)
            else:
                logger.error(f"Failed to fetch {url} after {retries} attempts: {e}")
                return None


def get_class_links(html: str) -> list[dict]:
    """
    Parse allclasses.html and return a list of {name, url} dicts
    for every class/interface link on the page.
    """
    soup = BeautifulSoup(html, "html.parser")
    entries = []

    for a in soup.find_all("a", href=True):
        href = a["href"]
        # Only follow links that look like class pages (contain org/dreambot path)
        if "org/dreambot" not in href and "org/dreambot" not in urljoin(ALL_CLASSES_URL, href):
            continue

        absolute_url = urljoin(ALL_CLASSES_URL, href)
        # Strip fragment
        absolute_url = absolute_url.split("#")[0]

        name = a.get_text(strip=True)
        if name:
            entries.append({"name": name, "url": absolute_url})

    # Deduplicate by URL
    seen = set()
    unique = []
    for entry in entries:
        if entry["url"] not in seen:
            seen.add(entry["url"])
            unique.append(entry)

    return unique


def extract_package_from_url(url: str) -> str:
    """
    Derive the Java package from a class URL.
    e.g. https://dreambot.org/javadocs/org/dreambot/api/methods/map/Tile.html
         → org.dreambot.api.methods.map
    """
    parsed = urlparse(url)
    path = parsed.path  # e.g. /javadocs/org/dreambot/api/methods/map/Tile.html
    # Strip /javadocs/ prefix
    path = re.sub(r"^/javadocs/", "", path)
    # Remove the filename
    parts = path.split("/")
    package_parts = parts[:-1]  # everything except the .html file
    return ".".join(package_parts)


def clean_text(text: str) -> str:
    """Strip whitespace and zero-width characters from text."""
    return re.sub(r"[\u200b\u200c\u200d\u200e\u200f\ufeff\xa0]", " ", text).strip()


def clean_signature(text: str) -> str:
    """Remove zero-width characters and collapse whitespace in a signature string."""
    # Remove all zero-width / invisible Unicode characters
    text = re.sub(r"[\u200b\u200c\u200d\u200e\u200f\ufeff]", "", text)
    # Replace non-breaking spaces with regular spaces
    text = text.replace("\xa0", " ")
    # Collapse multiple spaces/newlines
    text = re.sub(r"\s+", " ", text).strip()
    # Remove whitespace between method name and opening parenthesis, e.g. getY () -> getY()
    return re.sub(r"\s+\(", "(", text)


def parse_signature(method_cell) -> str:
    """
    Extract the full method signature text from the colSecond <th> cell,
    collapsing whitespace into a single readable line with no zero-width chars.
    """
    raw = method_cell.get_text(separator=" ")
    return clean_signature(raw)


def extract_return_type(modifier_and_type: str) -> str:
    """
    Extract the return type from the modifier_and_type string.
    e.g. 'static void'    → 'void'
         'default boolean' → 'boolean'
         'static Item'     → 'Item'
    The return type is always the last token.
    """
    parts = modifier_and_type.strip().split()
    return parts[-1] if parts else ""


def build_detail_map(soup) -> dict:
    """
    Build a map of method anchor id → full description text scraped from the
    method detail section (block text + Returns/Parameters/Throws dl entries).

    DreamBot Javadoc uses anchors like <a id="getLocal()"> or <a name="getLocal()">
    immediately before each detail entry.
    """
    detail_map = {}

    for anchor in soup.find_all("a", id=True):
        anchor_id = anchor.get("id", "").strip()
        if not anchor_id:
            continue

        parent_li = anchor.find_parent("li")
        if not parent_li:
            continue

        parts = []

        block = parent_li.find("div", class_="block")
        if block:
            parts.append(clean_text(block.get_text()))

        dl = parent_li.find("dl")
        if dl:
            for dt in dl.find_all("dt"):
                label = clean_text(dt.get_text())
                dd = dt.find_next_sibling("dd")
                value = clean_text(dd.get_text()) if dd else ""
                parts.append(f"{label} {value}".strip())

        if parts:
            detail_map[anchor_id] = "\n".join(parts)

    # Also handle older <a name="..."> format
    for anchor in soup.find_all("a", attrs={"name": True}):
        anchor_id = anchor.get("name", "").strip()
        if not anchor_id or anchor_id in detail_map:
            continue

        parent_li = anchor.find_parent("li")
        if not parent_li:
            continue

        parts = []

        block = parent_li.find("div", class_="block")
        if block:
            parts.append(clean_text(block.get_text()))

        dl = parent_li.find("dl")
        if dl:
            for dt in dl.find_all("dt"):
                label = clean_text(dt.get_text())
                dd = dt.find_next_sibling("dd")
                value = clean_text(dd.get_text()) if dd else ""
                parts.append(f"{label} {value}".strip())

        if parts:
            detail_map[anchor_id] = "\n".join(parts)

    return detail_map


def scrape_class_page(url: str, name: str) -> dict:
    """
    Fetch and parse a single class/interface page.
    Returns a dict with name, package, kind, url, and methods.
    """
    html = fetch(url)
    if not html:
        return {
            "name": name,
            "package": extract_package_from_url(url),
            "kind": "Unknown",
            "url": url,
            "methods": []
        }

    soup = BeautifulSoup(html, "html.parser")

    # Build detail map once for the whole page
    detail_map = build_detail_map(soup)

    # --- Kind (Class / Interface / Enum / Annotation) ---
    kind = "Class"
    type_label = soup.find(class_="typeNameLabel")
    if not type_label:
        type_label = soup.find("span", class_="typeNameLabel")

    # Also check the pre tag in the description for "interface", "enum", etc.
    description_pre = soup.find("pre")
    if description_pre:
        pre_text = description_pre.get_text()
        if "interface" in pre_text:
            kind = "Interface"
        elif "enum" in pre_text:
            kind = "Enum"
        elif "@interface" in pre_text:
            kind = "Annotation"
        elif "class" in pre_text:
            kind = "Class"

    # --- Package ---
    package = extract_package_from_url(url)

    # Try to read it from the page itself (more reliable)
    package_el = soup.find(class_="header")
    if package_el:
        pkg_text = package_el.find(class_="subTitle")
        if pkg_text:
            package = clean_text(pkg_text.get_text())

    # --- Enum values ---
    enum_values = []
    if kind == "Enum":
        for table in soup.find_all("table", class_="memberSummary"):
            caption = table.find("caption")
            if not caption or "Enum Constant" not in caption.get_text():
                continue
            for row in table.find_all("tr"):
                name_cell = row.find("th", class_="colFirst")
                if not name_cell:
                    continue
                name_link = name_cell.find(class_="memberNameLink")
                if name_link:
                    enum_values.append(clean_text(name_link.get_text()))

    # --- Methods ---
    methods = []

    # Find method summary tables - they have caption containing "Method"
    for table in soup.find_all("table", class_="memberSummary"):
        caption = table.find("caption")
        if not caption:
            continue
        caption_text = caption.get_text()
        if "Method" not in caption_text:
            continue

        # Each method row has id="i0", "i1", etc.
        for row in table.find_all("tr"):
            row_id = row.get("id", "")
            if not re.match(r"^i\d+$", row_id):
                continue

            # Modifier and Type — colFirst td
            mod_cell = row.find("td", class_="colFirst")
            modifier_and_type = clean_text(mod_cell.get_text()) if mod_cell else ""

            # Method name + signature — colSecond th
            sig_cell = row.find("th", class_="colSecond")
            if not sig_cell:
                continue

            # Method name from the memberNameLink anchor
            name_link = sig_cell.find(class_="memberNameLink")
            method_anchor = ""
            if name_link:
                method_name = clean_text(name_link.get_text())
                a_tag = name_link.find("a")
                if a_tag:
                    href = a_tag.get("href", "")
                    method_anchor = href.lstrip("#")
            else:
                # Fallback: first anchor text
                first_a = sig_cell.find("a")
                method_name = clean_text(first_a.get_text()) if first_a else ""
                if first_a:
                    method_anchor = first_a.get("href", "").lstrip("#")

            signature = parse_signature(sig_cell)

            # Description — colLast td
            desc_cell = row.find("td", class_="colLast")
            summary = ""
            deprecated = False
            if desc_cell:
                # Check for @Deprecated annotation or "Deprecated." block
                deprecated = (
                    desc_cell.find(class_="deprecatedLabel") is not None
                    or desc_cell.find(class_="deprecationBlock") is not None
                    or "Deprecated." in desc_cell.get_text()
                )
                block = desc_cell.find(class_="block")
                summary = clean_text(block.get_text()) if block else clean_text(desc_cell.get_text())

            methods.append({
                "name": method_name,
                "signature": signature,
                "modifier_and_type": modifier_and_type,
                "summary": summary,
                "description": detail_map.get(method_anchor, ""),
                "returns": extract_return_type(modifier_and_type),
                "deprecated": deprecated
            })

    result = {
        "name": name,
        "package": package,
        "kind": kind,
        "url": url,
        "methods": methods
    }

    if kind == "Enum":
        result["enum_values"] = enum_values

    return result


def scrape_with_delay(entry: dict, delay: float) -> dict:
    """Wrapper that adds a per-worker delay then scrapes a class page."""
    time.sleep(delay)
    return scrape_class_page(entry["url"], entry["name"])


def scrape(output_path: Path, delay: float = 0.2, workers: int = 8) -> None:
    """Main scrape routine — fetches classes in parallel using a thread pool."""
    logger.info(f"Fetching class list from {ALL_CLASSES_URL}")
    html = fetch(ALL_CLASSES_URL)
    if not html:
        logger.error("Failed to fetch allclasses.html — aborting.")
        sys.exit(1)

    class_links = get_class_links(html)
    total = len(class_links)
    logger.info(f"Found {total} classes to scrape using {workers} workers")

    results = [None] * total  # pre-size so we can preserve original order
    completed = 0

    with ThreadPoolExecutor(max_workers=workers) as executor:
        # Submit all jobs, keeping track of original index for ordering
        future_to_index = {
            executor.submit(scrape_with_delay, entry, delay): i
            for i, entry in enumerate(class_links)
        }

        for future in as_completed(future_to_index):
            i = future_to_index[future]
            entry = class_links[i]
            completed += 1
            try:
                results[i] = future.result()
                logger.info(f"[{completed}/{total}] Done: {entry['name']}")
            except Exception as e:
                logger.error(f"[{completed}/{total}] Failed: {entry['name']} — {e}")
                results[i] = {
                    "name": entry["name"],
                    "package": extract_package_from_url(entry["url"]),
                    "kind": "Unknown",
                    "url": entry["url"],
                    "methods": []
                }

    # Remove any None slots (shouldn't happen, but defensive)
    results = [r for r in results if r is not None]

    output_path.parent.mkdir(parents=True, exist_ok=True)
    with open(output_path, "w", encoding="utf-8") as f:
        json.dump(results, f, indent=2, ensure_ascii=False)

    logger.info("=" * 60)
    logger.info(f"Scraping complete. {len(results)} classes written to {output_path}")
    logger.info("=" * 60)


def main():
    parser = argparse.ArgumentParser(
        description="Scrape DreamBot Javadoc class/method data into a JSON file"
    )
    parser.add_argument(
        "--output",
        type=Path,
        default=DEFAULT_OUTPUT,
        help=f"Output JSON file path (default: {DEFAULT_OUTPUT})"
    )
    parser.add_argument(
        "--workers",
        type=int,
        default=8,
        help="Number of parallel worker threads (default: 8)"
    )
    parser.add_argument(
        "--delay",
        type=float,
        default=0.2,
        help="Delay in seconds per worker between requests (default: 0.2)"
    )
    args = parser.parse_args()

    scrape(args.output, delay=args.delay, workers=args.workers)


if __name__ == "__main__":
    main()


#!/usr/bin/env python3
"""
DreamBot API Lookup

Searches the local javadoc_api.json and prints a concise summary of matching
classes or methods. Intended to be called by AI coding agents instead of
reading the raw JSON directly.

Usage:
    python scripts/dreambot_lookup.py Players
    python scripts/dreambot_lookup.py Players.getLocal
    python scripts/dreambot_lookup.py getLocal
    python scripts/dreambot_lookup.py "get local player"
"""

import json
import re
import sys
from pathlib import Path

API_JSON = Path(__file__).parent.parent / "docs" / "dreambot" / "javadoc_api.json"
MAX_METHODS_IN_CLASS_VIEW = 30


def normalize_signature(text: str) -> str:
    """Normalize signatures for stable overload matching."""
    return "".join(text.split()).lower()


def tokenize_text(text: str) -> list[str]:
    """Split text into normalized lowercase tokens, including camelCase words."""
    if not text:
        return []
    camel_split = re.sub(r"([a-z0-9])([A-Z])", r"\1 \2", text)
    normalized = re.sub(r"[^a-zA-Z0-9]+", " ", camel_split).lower()
    return [token for token in normalized.split() if token]


def method_search_blob(cls: dict, method: dict) -> str:
    """Build a searchable text blob for fuzzy method matching."""
    fields = [
        cls.get("name", ""),
        cls.get("package", ""),
        method.get("name", ""),
        method.get("signature", ""),
        method.get("returns", ""),
        method.get("summary", ""),
        method.get("description", ""),
    ]
    return " ".join(fields)


def load_api() -> list:
    if not API_JSON.exists():
        print(f"Error: {API_JSON} not found. Run scripts/javadoc_scraper.py first.", file=sys.stderr)
        sys.exit(1)
    with open(API_JSON, encoding="utf-8") as f:
        return json.load(f)


def format_method(method: dict, class_name: str = "") -> str:
    parts = []
    prefix = f"{class_name}." if class_name else ""
    parts.append(f"  {prefix}{method['signature']}  →  {method['returns']}")
    if method.get("summary"):
        parts.append(f"    Summary: {method['summary']}")
    if method.get("description") and method["description"] != method.get("summary", ""):
        parts.append(f"    Detail:  {method['description']}")
    if method.get("deprecated"):
        parts.append("    ⚠ Deprecated")
    return "\n".join(parts)


def search(query: str, api: list) -> None:
    # Detect "ClassName.methodName" pattern
    if "." in query and not query.startswith("."):
        parts = query.split(".", 1)
        class_query, method_query = parts[0].lower(), parts[1].lower()
    else:
        class_query = query.lower()
        method_query = None

    signature_query = ""
    if method_query and "(" in method_query:
        signature_query = normalize_signature(method_query)

    if method_query is not None:
        matched_classes = [
            cls
            for cls in api
            if cls["name"].lower() == class_query
            or f"{cls['package']}.{cls['name']}".lower().endswith(f".{class_query}")
        ]
    else:
        matched_classes = [
            cls
            for cls in api
            if class_query in cls["name"].lower() or class_query in cls["package"].lower()
        ]

    if not matched_classes:
        print(f"No class found matching '{query}'.")
        return

    for cls in matched_classes:
        methods = cls.get("methods", [])

        # Filter to the specific method if requested
        if method_query:
            if signature_query:
                methods = [
                    m
                    for m in methods
                    if normalize_signature(m.get("signature", "")) == signature_query
                ]
            else:
                methods = [m for m in methods if method_query in m["name"].lower()]
            if not methods:
                print(f"{cls['name']} — no method matching '{method_query}'")
                continue
        else:
            # Check if query might be a standalone method name across all classes
            # (only when class_query didn't narrowly match a class name)
            pass

        print(f"\n{'='*60}")
        print(f"  {cls['kind']}: {cls['package']}.{cls['name']}")
        print(f"  {cls['url']}")
        print(f"{'='*60}")

        if not method_query and len(methods) > MAX_METHODS_IN_CLASS_VIEW:
            print(f"  {len(methods)} methods — showing first {MAX_METHODS_IN_CLASS_VIEW}. Refine with ClassName.methodName.\n")
            methods = methods[:MAX_METHODS_IN_CLASS_VIEW]

        for method in methods:
            print(format_method(method, cls["name"]))
            print()

        if cls.get("enum_values"):
            print(f"  Enum values: {', '.join(cls['enum_values'])}")


def search_method_only(query: str, api: list) -> None:
    """Search across all classes for a method name when no class prefix given."""
    query_lower = query.lower()
    signature_query = normalize_signature(query) if "(" in query else ""
    query_tokens = tokenize_text(query)
    found = []

    for cls in api:
        for method in cls.get("methods", []):
            if signature_query:
                if normalize_signature(method.get("signature", "")) == signature_query:
                    found.append((cls, method, 10_000))
            elif query_lower in method["name"].lower():
                found.append((cls, method, 5_000))
            elif query_tokens:
                blob_tokens = set(tokenize_text(method_search_blob(cls, method)))
                matched_tokens = sum(1 for token in query_tokens if token in blob_tokens)
                if matched_tokens == len(query_tokens):
                    name_tokens = set(tokenize_text(method.get("name", "")))
                    score = matched_tokens
                    if name_tokens and all(token in name_tokens for token in query_tokens):
                        score += 50
                    if " ".join(query_tokens) in " ".join(tokenize_text(method.get("summary", ""))):
                        score += 10
                    found.append((cls, method, score))

    if not found:
        print(f"No method found matching '{query}'.")
        return

    found.sort(key=lambda row: row[2], reverse=True)

    print(f"Found {len(found)} method(s) matching '{query}':\n")
    for cls, method, _ in found[:20]:
        print(format_method(method, cls["name"]))
        print()

    if len(found) > 20:
        print(f"  ... and {len(found) - 20} more. Use ClassName.methodName to narrow down.")


def main() -> None:
    if len(sys.argv) < 2:
        print(__doc__)
        sys.exit(1)

    query = " ".join(sys.argv[1:]).strip()
    api = load_api()

    # If query has a dot, treat as ClassName.method
    if "." in query and not query.startswith("."):
        search(query, api)
    else:
        # Try as class name first; if no match, fall back to method-only search
        class_matches = [cls for cls in api if query.lower() in cls["name"].lower()]
        if class_matches:
            search(query, api)
        else:
            search_method_only(query, api)


if __name__ == "__main__":
    main()


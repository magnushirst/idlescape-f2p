import json
import os
import sys
import urllib.error
import urllib.request


def read_text(path: str) -> str:
    with open(path, encoding="utf-8") as f:
        return f.read().strip()


def main() -> int:
    token = os.environ["GITHUB_TOKEN"]
    latest_tag = os.environ["LATEST_TAG"]
    last_tag = os.environ.get("LAST_RELEASE_TAG", "the beginning")

    commits = read_text("/tmp/commits.txt")
    prs = read_text("/tmp/prs.txt")

    changes_block = ""
    if commits:
        changes_block += f"Commits:\n{commits}\n"
    if prs:
        changes_block += f"\nPull Requests:\n{prs}\n"

    prompt = (
        "You are writing release notes for 'IdleScape', a collection of RuneScape automation scripts. "
        f"Summarise the following code changes between {last_tag} and {latest_tag} "
        "in a short bullet points (max 10) aimed at users of the scripts. No need to mention tha that there is a "
        "release, just have it contains the changes. Don't mention the change number. It's in the title already "
        "Do not assume the reader knows anything about the codebase internals - translate every "
        "technical change into plain English describing what the user will notice or benefit from. "
        "Don't mention specific Java classes, tanslate those into something more simple. "
        "If there was work releated to cleanup, don't mention which part of the code was changed, "
        "just say Refactored code. Don't say this more than once, even if there were multiple commits "
        "to clean up the code. Keep each line brief and and concise. "
        "Only include changes from withing the src folder, don't mention improvements to documentation "
        ", docker or anything else that the end user would see. Don't try and talk about how it could improve "
        "the user's experience, only talk about the changes made. Don't include any emotive language, just facts"
        "\n\n"
        f"{changes_block}"
    )

    payload = json.dumps(
        {
            "model": "gpt-4o-mini",
            "messages": [{"role": "user", "content": prompt}],
            "max_tokens": 400,
            "temperature": 0.7,
        }
    ).encode()

    req = urllib.request.Request(
        "https://models.inference.ai.azure.com/chat/completions",
        data=payload,
        headers={
            "Authorization": f"Bearer {token}",
            "Content-Type": "application/json",
        },
        method="POST",
    )

    try:
        with urllib.request.urlopen(req) as resp:
            data = json.load(resp)
            print(data["choices"][0]["message"]["content"].strip())
            return 0
    except urllib.error.HTTPError as e:
        try:
            body = e.read().decode()
        except Exception:
            body = e.reason if hasattr(e, "reason") else str(e)
        print(f"AI summary unavailable ({e.code}): {body}", file=sys.stderr)
        return 1
    except urllib.error.URLError as e:
        print(f"Network error: {e.reason}", file=sys.stderr)
        return 1


if __name__ == "__main__":
    sys.exit(main())


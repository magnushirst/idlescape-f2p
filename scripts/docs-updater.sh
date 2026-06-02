#!/usr/bin/env bash
python -m venv ./venv
./venv/bin/pip install -r requirements.txt
./venv/bin/python scripts/javadoc_scraper.py --workers 10

if [[ -n $(git status --porcelain) ]]; then
  echo "Changes detected, committing..."

  git add .
  git commit -m "docs: Updating Javadocs"
else
  echo "No changes to commit"
fi

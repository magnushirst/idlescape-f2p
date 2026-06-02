#!/usr/bin/env bash

# Setup script to install the pre-push hook

HOOK_SOURCE="scripts/pre-push-hook"
HOOK_DEST=".git/hooks/pre-push"

if [ ! -f "$HOOK_SOURCE" ]; then
    echo "❌ Error: $HOOK_SOURCE not found"
    exit 1
fi

# Copy the hook
cp "$HOOK_SOURCE" "$HOOK_DEST"

# Make it executable
chmod +x "$HOOK_DEST"

echo "✅ Pre-push hook installed successfully!"
echo "📝 Location: $HOOK_DEST"
echo ""
echo "The hook will now run before each push and check code formatting."
echo ""
echo "To fix any formatting issues, run:"
echo "  mvn spotless:apply"


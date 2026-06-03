$equipmentDir = "C:\Users\mango\Projects\idlescape-f2p\src\main\java\org\dreambot\gamedata\items\equipment"

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)

$files = @(
    "HandsSlotRefs.java",
    "HeadSlotRefs.java",
    "LegsSlotRefs.java",
    "NeckSlotRefs.java",
    "OneHandedSlotRefs.java",
    "RingSlotRefs.java",
    "ShieldSlotRefs.java",
    "TwoHandedSlotRefs.java"
)

foreach ($fileName in $files) {
    $filePath = Join-Path $equipmentDir $fileName

    if (Test-Path $filePath) {
        Write-Host "Fixing encoding for: $fileName"
        $content = [System.IO.File]::ReadAllText($filePath)

        if ($content.StartsWith([char]0xFEFF)) {
            $content = $content.Substring(1)
        }

        [System.IO.File]::WriteAllText($filePath, $content, $utf8NoBom)
        Write-Host "  Fixed"
    }
}

Write-Host "Encoding fixes complete"


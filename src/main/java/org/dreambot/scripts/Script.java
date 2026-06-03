package org.dreambot.scripts;

import org.dreambot.api.data.requirements.Requirement;
import org.dreambot.ui.assets.Image;
import org.dreambot.ui.launcher.ScriptCategory;
import org.dreambot.ui.launcher.ScriptPanel;
import org.dreambot.ui.paint.PaintOverlay;

public interface Script {

    String getName();

    String getDescription();

    Requirement getRequirement();

    ScriptPanel getPanel();

    ScriptCategory getCategory();

    PaintOverlay getOverlay();

    default Image getImage() {
        return Image.MINIGAME_PLACEHOLDER;
    }
}

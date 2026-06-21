package com.idlescape.scripts;

import com.idlescape.ui.assets.Image;
import com.idlescape.ui.launcher.ScriptCategory;
import com.idlescape.ui.launcher.ScriptPanel;
import com.idlescape.ui.paint.PaintOverlay;
import org.dreambot.api.data.requirements.Requirement;

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

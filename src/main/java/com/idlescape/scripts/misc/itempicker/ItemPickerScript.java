package com.idlescape.scripts.misc.itempicker;

import com.idlescape.framework.tree.ScriptBranch;
import com.idlescape.scripts.misc.itempicker.leaves.Pickup;
import com.idlescape.ui.launcher.ScriptCategory;
import com.idlescape.ui.launcher.ScriptPanel;
import com.idlescape.ui.paint.PaintOverlay;
import javax.inject.Inject;
import org.dreambot.api.data.requirements.Requirement;

public class ItemPickerScript extends ScriptBranch {
    @Inject
    public ItemPickerScript(Pickup pickup) {
        addLeaves(pickup);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String getName() {
        return "Item Picker";
    }

    @Override
    public String getDescription() {
        return "Picks up items from the ground and banks them";
    }

    @Override
    public Requirement getRequirement() {
        return null;
    }

    @Override
    public ScriptPanel getPanel() {
        return null;
    }

    @Override
    public ScriptCategory getCategory() {
        return null;
    }

    @Override
    public PaintOverlay getOverlay() {
        return null;
    }
}

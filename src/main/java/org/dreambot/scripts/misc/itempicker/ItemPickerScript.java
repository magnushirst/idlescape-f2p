package org.dreambot.scripts.misc.itempicker;

import javax.inject.Inject;
import org.dreambot.api.data.requirements.Requirement;
import org.dreambot.framework.tree.ScriptBranch;
import org.dreambot.scripts.misc.itempicker.leaves.Pickup;
import org.dreambot.ui.launcher.ScriptCategory;
import org.dreambot.ui.launcher.ScriptPanel;
import org.dreambot.ui.paint.PaintOverlay;

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

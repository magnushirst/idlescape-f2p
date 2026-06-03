package org.dreambot.scripts.misc.itempicker.leaves;

import javax.inject.Inject;
import org.dreambot.BotConfig;
import org.dreambot.framework.tree.SmartLeaf;

public class Pickup extends SmartLeaf {
    @Inject
    BotConfig botConfig;

    @Override
    protected int execute() {
        return botConfig.getLoopDelay();
    }

    @Override
    public boolean canRun() {
        return true;
    }
}

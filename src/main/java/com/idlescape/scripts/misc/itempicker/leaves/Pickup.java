package com.idlescape.scripts.misc.itempicker.leaves;

import com.idlescape.BotConfig;
import com.idlescape.framework.tree.SmartLeaf;
import javax.inject.Inject;

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

package com.idlescape.framework.tree;

import static com.idlescape.framework.log.StyledLogger.getShortClassName;
import static org.dreambot.api.utilities.Logger.LogType.INFO;

import com.google.inject.Inject;
import com.idlescape.BotConfig;
import com.idlescape.controllers.LoggerController;
import org.dreambot.api.script.frameworks.treebranch.Leaf;

public abstract class SmartLeaf extends Leaf {
    @Inject
    private BotConfig botConfig;

    @Override
    public final int onLoop() {
        LoggerController.getInstance()
                .logOnChange(INFO, "Executing leaf", "Executing leaf: " + getShortClassName(this.getClass(), 1));
        botConfig.setCurrentLeaf(getShortClassName(this.getClass(), 1));
        botConfig.setCurrentBranch(getShortClassName(this.getParent().getClass(), 1));
        return execute();
    }

    @Override
    public final boolean isValid() {
        return canRun();
    }

    protected abstract int execute();

    protected abstract boolean canRun();
}

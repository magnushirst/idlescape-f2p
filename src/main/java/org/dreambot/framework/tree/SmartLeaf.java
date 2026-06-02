package org.dreambot.framework.tree;

import static org.dreambot.api.utilities.Logger.LogType.INFO;
import static org.dreambot.framework.log.StyledLogger.getShortClassName;

import com.google.inject.Inject;
import org.dreambot.BotConfig;
import org.dreambot.api.script.frameworks.treebranch.Leaf;
import org.dreambot.controllers.LoggerController;

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

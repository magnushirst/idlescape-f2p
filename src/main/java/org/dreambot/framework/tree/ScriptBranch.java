package org.dreambot.framework.tree;

import static org.dreambot.api.utilities.Logger.LogType.INFO;
import static org.dreambot.framework.log.StyledLogger.getShortClassName;

import org.dreambot.api.script.frameworks.treebranch.Branch;
import org.dreambot.controllers.LoggerController;
import org.dreambot.scripts.Script;

public abstract class ScriptBranch extends Branch implements Script {

    @Override
    public int onLoop() {
        LoggerController.getInstance()
                .logOnChange(INFO, "Executing Script", "Executing Script: " + getShortClassName(this.getClass(), 1));
        return super.onLoop();
    }
}

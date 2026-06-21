package com.idlescape.framework.tree;

import static com.idlescape.framework.log.StyledLogger.getShortClassName;
import static org.dreambot.api.utilities.Logger.LogType.INFO;

import com.idlescape.controllers.LoggerController;
import com.idlescape.scripts.Script;
import org.dreambot.api.script.frameworks.treebranch.Branch;

public abstract class ScriptBranch extends Branch implements Script {

    @Override
    public int onLoop() {
        LoggerController.getInstance()
                .logOnChange(INFO, "Executing Script", "Executing Script: " + getShortClassName(this.getClass(), 1));
        return super.onLoop();
    }
}

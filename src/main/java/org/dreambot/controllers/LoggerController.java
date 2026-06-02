package org.dreambot.controllers;

import java.util.HashMap;
import java.util.Map;
import lombok.Setter;
import org.dreambot.api.utilities.Logger;

public class LoggerController {
    @Setter
    private static LoggerController instance;

    Map<String, String> logLines = new HashMap<>();

    public void logOnChange(Logger.LogType logType, String name, String logMessage) {
        String previousMessage = logLines.get(name);
        if (previousMessage == null || !previousMessage.equals(logMessage)) {
            Logger.log(logType, logMessage);
        }
        logLines.put(name, logMessage);
    }

    public void logOnChange(String name, String logMessage) {
        logOnChange(Logger.LogType.SCRIPT, name, logMessage);
    }

    public static synchronized LoggerController getInstance() {
        if (instance == null) {
            instance = new LoggerController();
        }
        return instance;
    }
}

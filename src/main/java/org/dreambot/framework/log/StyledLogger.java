package org.dreambot.framework.log;

import org.dreambot.api.utilities.Logger;

public class StyledLogger {
    private final String className;

    public StyledLogger(Class<?> clazz) {
        this.className = getShortClassName(clazz, 1);
    }

    public void log(Object message) {
        Logger.log(getFormattedMessage(message));
    }

    public void warn(Object message) {
        Logger.warn(getFormattedMessage(message));
    }

    public void error(Object message) {
        Logger.error(getFormattedMessage(message));
    }

    public void error(Throwable t) {
        Logger.error(getFormattedMessage(String.valueOf(t)), t);
    }

    public void error(Object message, Throwable t) {
        Logger.error(getFormattedMessage(message), t);
    }

    public void debug(Object message) {
        Logger.debug(getFormattedMessage(message));
    }

    public void info(Object message) {
        Logger.info(getFormattedMessage(message));
    }

    private String getFormattedMessage(Object message) {
        return "[" + className + "] " + message;
    }

    public static String getShortClassName(Class<?> clazz, int keepPackages) {
        String[] parts = clazz.getName().split("\\.");

        int classIndex = parts.length - 1;
        int start = Math.max(0, classIndex - keepPackages);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < start; i++) {
            result.append(parts[i].charAt(0)).append(".");
        }

        for (int i = start; i < parts.length; i++) {
            result.append(parts[i]);
            if (i < parts.length - 1) result.append(".");
        }

        return result.toString();
    }
}

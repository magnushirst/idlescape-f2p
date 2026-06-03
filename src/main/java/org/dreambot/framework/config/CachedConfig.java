package org.dreambot.framework.config;

public interface CachedConfig {
    default boolean onTaskStart() {
        return true;
    }

    default boolean isPlayerSpecific() {
        return false;
    }

    default String getConfigFileName() {
        return this.getClass().getSimpleName().toLowerCase();
    }

    default void onSave() {}
}

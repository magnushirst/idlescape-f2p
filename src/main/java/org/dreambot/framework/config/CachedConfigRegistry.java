package org.dreambot.framework.config;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.dreambot.api.script.ScriptManager;
import org.dreambot.api.utilities.Logger;

public class CachedConfigRegistry {
    @Getter
    private static final Map<String, Object> registry = new HashMap<>();

    public static <T extends CachedConfig> void register(Class<T> clazz, T instance) {
        registry.put(clazz.getName(), instance);
    }

    public static void register(String className, Object instance) {
        registry.put(className, instance);
    }

    @SuppressWarnings("unchecked")
    public static <T extends CachedConfig> T get(Class<T> clazz) {
        if (!registry.containsKey(clazz.getName())) {
            try {
                T c = clazz.getDeclaredConstructor().newInstance();
                register(clazz.getName(), c);
            } catch (IllegalAccessException | InstantiationException e) {
                Logger.error("Failed to instantiate script config class " + clazz.getName(), e);
                ScriptManager.getScriptManager().pause();
            } catch (InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        return (T) registry.get(clazz.getName());
    }
}

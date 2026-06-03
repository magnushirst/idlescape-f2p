package org.dreambot.helper;

import java.util.List;
import org.dreambot.framework.log.StyledLogger;

public class Comparisons {
    private static final StyledLogger LOGGER = new StyledLogger(Comparisons.class);

    public static boolean isIn(int base, int... matches) {
        for (int match : matches) {
            if (base == match) {
                return true;
            }
        }
        return false;
    }

    public static boolean isIn(Object base, List<Object> matches) {
        for (Object match : matches) {
            LOGGER.log(base + ":" + match);
            if (base == match) {
                return true;
            }
        }
        return false;
    }
}

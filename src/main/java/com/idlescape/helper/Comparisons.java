package com.idlescape.helper;

import com.idlescape.framework.log.StyledLogger;
import java.util.List;

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

    public static boolean isIn(Object o, Object... matches) {
        for (Object match : matches) {
            if (o == match) {
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

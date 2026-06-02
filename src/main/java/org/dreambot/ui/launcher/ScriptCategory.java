package org.dreambot.ui.launcher;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ScriptCategory {
    SKILL("Skill"),
    PVM("PvM"),
    MINI_GAME("Mini Game"),
    DAILY_TASK("Daily Task"),
    MISC("Misc");

    private final String displayName;
}

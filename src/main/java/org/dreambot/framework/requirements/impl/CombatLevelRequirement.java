package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class CombatLevelRequirement implements IRequirement {
    private final int minLevel;

    @Override
    public boolean hasMet() {
        return Combat.getCombatLevel() >= minLevel;
    }
}

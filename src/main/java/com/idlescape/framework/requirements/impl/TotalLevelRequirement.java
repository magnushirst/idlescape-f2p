package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.skills.Skills;

@Getter
@AllArgsConstructor
public final class TotalLevelRequirement implements IRequirement {
    private final int minTotalLevel;

    @Override
    public boolean hasMet() {
        return Skills.getTotalLevel() >= minTotalLevel;
    }
}

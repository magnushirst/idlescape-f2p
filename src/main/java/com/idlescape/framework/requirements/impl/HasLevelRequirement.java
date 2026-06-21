package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import java.util.Objects;
import lombok.Getter;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

@Getter
public final class HasLevelRequirement implements IRequirement {
    private final Skill skill;
    private final int minLevel;

    public HasLevelRequirement(Skill skill, int minLevel) {
        this.skill = Objects.requireNonNull(skill);
        this.minLevel = minLevel;
    }

    @Override
    public boolean hasMet() {
        return Skills.getRealLevel(skill) >= minLevel;
    }
}

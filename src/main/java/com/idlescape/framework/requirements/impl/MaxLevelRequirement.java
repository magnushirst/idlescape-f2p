package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import java.util.Arrays;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;

public final class MaxLevelRequirement implements IRequirement {
    @Override
    public boolean hasMet() {
        return Arrays.stream(Skill.values()).allMatch(skill -> Skills.getRealLevel(skill) == 99);
    }
}

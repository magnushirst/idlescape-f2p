package org.dreambot.framework.requirements.impl;

import java.util.Arrays;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.framework.requirements.IRequirement;

public final class MaxLevelRequirement implements IRequirement {
    @Override
    public boolean hasMet() {
        return Arrays.stream(Skill.values()).allMatch(skill -> Skills.getRealLevel(skill) == 99);
    }
}

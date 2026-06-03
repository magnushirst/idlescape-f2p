package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class TotalLevelRequirement implements IRequirement {
    private final int minTotalLevel;

    @Override
    public boolean hasMet() {
        return Players.getLocal().getLevel() >= minTotalLevel;
    }
}


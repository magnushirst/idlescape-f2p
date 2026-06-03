package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class VarPlayerEqualsRequirement implements IRequirement {
    private final int varPlayer;
    private final int value;

    @Override
    public boolean hasMet() {
        return PlayerSettings.getConfig(varPlayer) == value;
    }
}

package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.settings.PlayerSettings;

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

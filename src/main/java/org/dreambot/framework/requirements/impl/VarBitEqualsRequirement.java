package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.settings.PlayerSettings;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class VarBitEqualsRequirement implements IRequirement {
    private final int varbitId;
    private final int value;

    @Override
    public boolean hasMet() {
        return PlayerSettings.getBitValue(varbitId) == value;
    }
}


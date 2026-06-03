package org.dreambot.framework.requirements.impl;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class NotRequirement implements IRequirement {
    private final IRequirement requirement;

    @Override
    public boolean hasMet() {
        return !requirement.hasMet();
    }
}


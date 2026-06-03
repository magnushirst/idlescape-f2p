package org.dreambot.framework.requirements.impl;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.framework.requirements.IRequirement;

@AllArgsConstructor
public final class AndRequirement implements IRequirement {
    private final IRequirement left;
    private final IRequirement right;

    @Override
    public boolean hasMet() {
        return left.hasMet() && right.hasMet();
    }
}


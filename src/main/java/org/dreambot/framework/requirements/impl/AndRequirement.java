package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
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

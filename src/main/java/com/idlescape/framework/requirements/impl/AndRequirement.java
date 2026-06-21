package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class AndRequirement implements IRequirement {
    private final IRequirement left;
    private final IRequirement right;

    @Override
    public boolean hasMet() {
        return left.hasMet() && right.hasMet();
    }
}

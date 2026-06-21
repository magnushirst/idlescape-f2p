package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class OrRequirement implements IRequirement {
    private final IRequirement left;
    private final IRequirement right;

    @Override
    public boolean hasMet() {
        return left.hasMet() || right.hasMet();
    }
}

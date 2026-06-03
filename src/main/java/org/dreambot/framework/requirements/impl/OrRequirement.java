package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.framework.requirements.IRequirement;

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

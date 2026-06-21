package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class NotRequirement implements IRequirement {
    private final IRequirement requirement;

    @Override
    public boolean hasMet() {
        return !requirement.hasMet();
    }
}

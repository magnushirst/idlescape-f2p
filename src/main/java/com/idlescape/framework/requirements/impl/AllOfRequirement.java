package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class AllOfRequirement implements IRequirement {
    private final IRequirement[] requirements;

    @Override
    public boolean hasMet() {
        return Arrays.stream(requirements).allMatch(IRequirement::hasMet);
    }
}

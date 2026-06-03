package org.dreambot.framework.requirements.impl;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class AnyOfRequirement implements IRequirement {
    private final IRequirement[] requirements;

    @Override
    public boolean hasMet() {
        return Arrays.stream(requirements).anyMatch(IRequirement::hasMet);
    }
}

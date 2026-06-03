package org.dreambot.framework.requirements.impl;

import java.util.Objects;
import java.util.function.BooleanSupplier;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.framework.requirements.IRequirement;

@Getter
@AllArgsConstructor
public final class SupplierRequirement implements IRequirement {
    private final BooleanSupplier supplier;

    @Override
    public boolean hasMet() {
        return supplier.getAsBoolean();
    }
}


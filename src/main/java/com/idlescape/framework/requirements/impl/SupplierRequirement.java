package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import java.util.function.BooleanSupplier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class SupplierRequirement implements IRequirement {
    private final BooleanSupplier supplier;

    @Override
    public boolean hasMet() {
        return supplier.getAsBoolean();
    }
}

package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;

public final class AlwaysFalseRequirement implements IRequirement {
    @Override
    public boolean hasMet() {
        return false;
    }
}

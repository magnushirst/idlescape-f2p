package org.dreambot.framework.requirements.impl;

import org.dreambot.framework.requirements.IRequirement;

public final class AlwaysFalseRequirement implements IRequirement {
    @Override
    public boolean hasMet() {
        return false;
    }
}

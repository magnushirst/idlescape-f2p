package com.idlescape.framework.requirements;

import com.idlescape.framework.requirements.impl.AndRequirement;
import com.idlescape.framework.requirements.impl.NotRequirement;
import com.idlescape.framework.requirements.impl.OrRequirement;

@FunctionalInterface
public interface IRequirement {
    boolean hasMet();

    default IRequirement and(IRequirement other) {
        return new AndRequirement(this, other);
    }

    default IRequirement or(IRequirement other) {
        return new OrRequirement(this, other);
    }

    default IRequirement not() {
        return new NotRequirement(this);
    }
}

package org.dreambot.framework.requirements;

import org.dreambot.framework.requirements.impl.AndRequirement;
import org.dreambot.framework.requirements.impl.NotRequirement;
import org.dreambot.framework.requirements.impl.OrRequirement;

@FunctionalInterface
interface IRequirement {
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

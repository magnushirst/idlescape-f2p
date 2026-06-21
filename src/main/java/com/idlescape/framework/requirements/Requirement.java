package com.idlescape.framework.requirements;

import com.idlescape.framework.requirements.impl.NotRequirement;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.Getter;

public final class Requirement {
    @Getter
    private final IRequirement requirement;

    private final List<IRequirement> requirements;

    Requirement(IRequirement requirement, List<IRequirement> requirements) {
        this.requirement = Objects.requireNonNull(requirement);
        this.requirements = Objects.requireNonNull(requirements);
    }

    public boolean hasMet() {
        return requirement.hasMet();
    }

    public List<IRequirement> getRequirements() {
        return Collections.unmodifiableList(requirements);
    }

    public List<IRequirement> getUnmetRequirements() {
        return requirements.stream().filter(r -> !r.hasMet()).collect(Collectors.toUnmodifiableList());
    }

    public List<IRequirement> getMetRequirements() {
        return requirements.stream().filter(IRequirement::hasMet).collect(Collectors.toUnmodifiableList());
    }

    public <T extends IRequirement> List<T> getRequirementsOfType(Class<T> type) {
        return requirements.stream()
                .map(this::unwrapNegation)
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toUnmodifiableList());
    }

    public <T extends IRequirement> List<T> getUnmetRequirementsOfType(Class<T> type) {
        return requirements.stream()
                .filter(r -> !r.hasMet())
                .map(this::unwrapNegation)
                .filter(type::isInstance)
                .map(type::cast)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean isNegated(IRequirement requirement) {
        return requirement instanceof NotRequirement;
    }

    private IRequirement unwrapNegation(IRequirement requirement) {
        IRequirement current = requirement;
        while (current instanceof NotRequirement) {
            current = ((NotRequirement) current).getRequirement();
        }
        return current;
    }
}

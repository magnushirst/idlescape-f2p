package org.dreambot.framework.requirements;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IRequirementBuilderTest {

    @Test
    public void shouldSupportAndOrAndNotChaining() {
        Requirement requirement = Requirements.builder()
                .require(Requirements.alwaysTrue())
                .and()
                .require(Requirements.alwaysTrue())
                .and()
                .not()
                .require(Requirements.alwaysFalse())
                .build();

        assertTrue(requirement.hasMet());
    }

    @Test
    public void shouldSupportVarbitChecksAndOrBranches() {
        Requirement requirement = Requirements.builder()
                .require(Requirements.alwaysFalse())
                .or()
                .require(Requirements.alwaysTrue())
                .build();

        assertTrue(requirement.hasMet());
    }

    @Test
    public void shouldFailWhenAndConditionIsNotMet() {
        Requirement requirement = Requirements.builder()
                .require(Requirements.alwaysTrue())
                .and()
                .require(Requirements.alwaysFalse())
                .build();

        assertFalse(requirement.hasMet());
    }
}

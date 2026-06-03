package org.dreambot.framework.requirements;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.dreambot.api.methods.skills.Skill;
import org.dreambot.framework.requirements.impl.HasLevelRequirement;
import org.junit.jupiter.api.Test;

public class CompositeIRequirementTest {

    @Test
    public void shouldTrackIndividualRequirements() {
        RequirementBuilder builder = new RequirementBuilder()
                .require(Requirements.alwaysTrue())
                .and()
                .require(Requirements.alwaysFalse());

        Requirement composite = builder.build();

        assertEquals(2, composite.getRequirements().size());
    }

    @Test
    public void shouldFilterUnmetRequirements() {
        RequirementBuilder builder = new RequirementBuilder()
                .require(Requirements.alwaysTrue())
                .and()
                .require(Requirements.alwaysFalse())
                .and()
                .require(Requirements.alwaysFalse());

        Requirement composite = builder.build();

        assertEquals(2, composite.getUnmetRequirements().size());
        assertEquals(1, composite.getMetRequirements().size());
    }

    @Test
    public void shouldExposeIndividualComponentsForReasoningWithActions() {
        RequirementBuilder builder = new RequirementBuilder()
                .require(Requirements.alwaysTrue())
                .and()
                .require(Requirements.alwaysFalse());

        Requirement composite = builder.build();

        for (IRequirement unmet : composite.getUnmetRequirements()) {
            assertFalse(unmet.hasMet());
        }
    }

    @Test
    public void shouldExposeConcreteConditionData() {
        Requirement requirement = Requirements.builder().hasLevel(Skill.MAGIC, 55).build();

        HasLevelRequirement condition = requirement.getRequirementsOfType(HasLevelRequirement.class).get(0);
        assertEquals(Skill.MAGIC, condition.getSkill());
        assertEquals(55, condition.getMinLevel());
    }

    @Test
    public void shouldRefreshRequirementStateOnEachCheck() {
        RequirementBuilder builder = new RequirementBuilder()
                .require(Requirements.alwaysFalse())
                .and()
                .require(Requirements.alwaysFalse());

        Requirement composite = builder.build();

        assertEquals(2, composite.getUnmetRequirements().size());
        assertFalse(composite.hasMet());
    }
}

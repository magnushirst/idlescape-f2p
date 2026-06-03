package org.dreambot.gamedata.items.equipment;

import java.util.stream.Stream;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.framework.requirements.Requirement;
import org.dreambot.framework.requirements.RequirementBuilder;
import org.dreambot.gamedata.combat.AttackBonus;
import org.dreambot.gamedata.combat.DefenceBonus;
import org.dreambot.gamedata.combat.SkillsBonus;
import org.dreambot.gamedata.items.GenericItemRef;

public interface EquipmentRefs {
    GenericItemRef getItemRef();

    EquipmentSlot getSlot();

    default EquipmentSlot getEquipmentSlot() {
        return getSlot();
    }

    default Requirement getRequirement() {
        return new RequirementBuilder().build();
    }

    default boolean meetsRequirements() {
        return getRequirement().hasMet();
    }

    boolean isMembers();

    AttackBonus getAttackBonus();

    DefenceBonus getDefenceBonus();

    SkillsBonus getSkillsBonus();

    double getWeight();

    int getAttackSpeed();

    GenericItemRef[] getSimilarItems();

    static EquipmentRefs[] values() {
        return Stream.of(
                        BodySlotRefs.values(),
                        AmmunitionSlotRefs.values(),
                        CapeSlotRefs.values(),
                        FeetSlotRefs.values(),
                        HandsSlotRefs.values(),
                        HeadSlotRefs.values(),
                        LegsSlotRefs.values(),
                        NeckSlotRefs.values(),
                        RingSlotRefs.values(),
                        ShieldSlotRefs.values(),
                        TwoHandedSlotRefs.values(),
                        OneHandedSlotRefs.values())
                .flatMap(Stream::of)
                .toArray(EquipmentRefs[]::new);
    }
}

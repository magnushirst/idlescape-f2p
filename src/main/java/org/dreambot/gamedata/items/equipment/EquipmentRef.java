package org.dreambot.gamedata.items.equipment;

import java.util.stream.Stream;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.framework.requirements.Requirement;
import org.dreambot.framework.requirements.RequirementBuilder;
import org.dreambot.gamedata.combat.AttackBonus;
import org.dreambot.gamedata.combat.DefenceBonus;
import org.dreambot.gamedata.combat.SkillsBonus;
import org.dreambot.gamedata.items.GenericItemRef;

public interface EquipmentRef {
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

    static EquipmentRef[] values() {
        return Stream.of(
                        BodySlotRef.values(),
                        AmmunitionSlotRef.values(),
                        CapeSlotRef.values(),
                        FeetSlotRef.values(),
                        HandsSlotRef.values(),
                        HeadSlotRef.values(),
                        LegsSlotRef.values(),
                        NeckSlotRef.values(),
                        RingSlotRef.values(),
                        ShieldSlotRef.values(),
                        TwoHandedSlotRef.values(),
                        OneHandedSlotRef.values())
                .flatMap(Stream::of)
                .toArray(EquipmentRef[]::new);
    }
}

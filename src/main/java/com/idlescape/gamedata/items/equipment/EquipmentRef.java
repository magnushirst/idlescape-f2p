package com.idlescape.gamedata.items.equipment;

import com.idlescape.framework.requirements.Requirement;
import com.idlescape.framework.requirements.RequirementBuilder;
import com.idlescape.gamedata.combat.AttackBonus;
import com.idlescape.gamedata.combat.DefenceBonus;
import com.idlescape.gamedata.combat.SkillsBonus;
import com.idlescape.gamedata.items.GenericItemRef;
import java.util.stream.Stream;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;

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

    private static boolean matchesItem(EquipmentRef equipmentRef, int itemId) {
        if (equipmentRef.getItemRef().getId() == itemId) {
            return true;
        }

        GenericItemRef[] similarItems = equipmentRef.getSimilarItems();
        return similarItems != null
                && Stream.of(similarItems)
                        .anyMatch(similarItem -> similarItem != null && similarItem.getId() == itemId);
    }

    static boolean matchesSlot(GenericItemRef itemRef, EquipmentSlot slot) {
        if (itemRef == null || slot == null) {
            return false;
        }

        return Stream.of(values())
                .filter(equipmentRef -> equipmentRef.getSlot() == slot)
                .anyMatch(equipmentRef -> matchesItem(equipmentRef, itemRef.getId()));
    }
}

package org.dreambot.controllers.bis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.gamedata.items.equipment.EquipmentRef;
import org.dreambot.gamedata.items.equipment.OneHandedSlotRef;
import org.dreambot.gamedata.items.equipment.ShieldSlotRef;
import org.dreambot.gamedata.items.equipment.TwoHandedSlotRef;

public class BestInSlotController {

    public BisResult calculateBestInSlot(BisRequest request) {
        Map<EquipmentSlot, List<EquipmentRef>> slotItems = buildSlotItems(request);
        Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems = new EnumMap<>(EquipmentSlot.class);

        for (Map.Entry<EquipmentSlot, List<EquipmentRef>> entry : slotItems.entrySet()) {
            rankedSlotItems.put(entry.getKey(), rankSlotItems(entry.getValue(), request));
        }

        applyAmmoSelection(request, rankedSlotItems);

        return new BisResult(rankedSlotItems);
    }

    protected Map<EquipmentSlot, List<EquipmentRef>> buildSlotItems(BisRequest request) {
        Map<EquipmentSlot, List<EquipmentRef>> SlotItems = new EnumMap<>(EquipmentSlot.class);

        for (EquipmentRef equipment : EquipmentRef.values()) {
            if (!isHandCompatible(equipment, request.getHandMode())) {
                continue;
            }
            if (!passesFilters(equipment, request)) {
                continue;
            }
            SlotItems.computeIfAbsent(equipment.getEquipmentSlot(), key -> new ArrayList<>())
                    .add(equipment);
        }

        return SlotItems;
    }

    protected List<EquipmentRef> rankSlotItems(List<EquipmentRef> slotItems, BisRequest request) {
        List<EquipmentRef> ranked = new ArrayList<>();
        for (EquipmentRef item : slotItems) {
            if (getPrimaryStat(item, request) > 0
                    || item.getEquipmentSlot() == EquipmentSlot.CAPE
                    || item.getEquipmentSlot() == EquipmentSlot.RING
                    || item.getEquipmentSlot() == EquipmentSlot.AMULET) {
                ranked.add(item);
            }
        }
        ranked.sort(Comparator.comparingInt((EquipmentRef item) -> getPrimaryStat(item, request))
                .thenComparingInt(item -> getHighestDamage(item, request))
                .thenComparingInt(this::getHigestOverallStats)
                .thenComparingInt(item -> item.getItemRef().getId())
                .reversed());
        return ranked;
    }

    protected boolean passesFilters(EquipmentRef equipment, BisRequest request) {
        if (request.isFreeToPlayOnly() && equipment.isMembers()) {
            return false;
        }
        return !safeSet(request.getSkippedItems()).contains(equipment);
    }

    protected int getPrimaryStat(EquipmentRef equipment, BisRequest request) {
        switch (request.getMetric()) {
            case ATTACK_STAB:
                return equipment.getAttackBonus().getStab();
            case ATTACK_SLASH:
                return equipment.getAttackBonus().getSlash();
            case ATTACK_CRUSH:
                return equipment.getAttackBonus().getCrush();
            case ATTACK_RANGED:
                return equipment.getAttackBonus().getRanged();
            case ATTACK_MAGIC:
                return equipment.getAttackBonus().getMagic();
            case DEFENCE_STAB:
                return equipment.getDefenceBonus().getStab();
            case DEFENCE_SLASH:
                return equipment.getDefenceBonus().getSlash();
            case DEFENCE_CRUSH:
                return equipment.getDefenceBonus().getCrush();
            case DEFENCE_RANGED:
                return equipment.getDefenceBonus().getRanged();
            case DEFENCE_MAGIC:
                return equipment.getDefenceBonus().getMagic();
            case STRENGTH:
                return equipment.getSkillsBonus().getStrengthBonus();
            case RANGED_STRENGTH:
                return equipment.getSkillsBonus().getRangedStrengthBonus();
            case MAGIC_DAMAGE:
                return equipment.getSkillsBonus().getMagicDamageBonus();
            case PRAYER:
                return equipment.getSkillsBonus().getPrayerBonus();
            default:
                return 0;
        }
    }

    protected int getHigestOverallStats(EquipmentRef equipment) {
        int score = 0;
        score += positive(equipment.getAttackBonus().getStab());
        score += positive(equipment.getAttackBonus().getSlash());
        score += positive(equipment.getAttackBonus().getCrush());
        score += positive(equipment.getAttackBonus().getMagic());
        score += positive(equipment.getAttackBonus().getRanged());

        score += positive(equipment.getDefenceBonus().getStab());
        score += positive(equipment.getDefenceBonus().getSlash());
        score += positive(equipment.getDefenceBonus().getCrush());
        score += positive(equipment.getDefenceBonus().getMagic());
        score += positive(equipment.getDefenceBonus().getRanged());

        score += positive(equipment.getSkillsBonus().getStrengthBonus());
        score += positive(equipment.getSkillsBonus().getRangedStrengthBonus());
        score += positive(equipment.getSkillsBonus().getMagicDamageBonus());
        score += positive(equipment.getSkillsBonus().getPrayerBonus());

        return score;
    }

    protected int getHighestDamage(EquipmentRef equipment, BisRequest request) {
        switch (request.getMetric()) {
            case ATTACK_RANGED:
                return equipment.getSkillsBonus().getRangedStrengthBonus();
            case ATTACK_MAGIC:
                return equipment.getSkillsBonus().getMagicDamageBonus();
            case ATTACK_STAB:
            case ATTACK_SLASH:
            case ATTACK_CRUSH:
                return equipment.getSkillsBonus().getStrengthBonus();
            case RANGED_STRENGTH:
                return equipment.getAttackBonus().getRanged();
            case MAGIC_DAMAGE:
                return equipment.getAttackBonus().getMagic();
            default:
                return 0;
        }
    }

    protected void applyAmmoSelection(BisRequest request, Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems) {
        // Hook for ranged weapon ammo compatibility selection; kept as no-op for initial implementation.
    }

    private boolean isHandCompatible(EquipmentRef equipment, HandMode handMode) {
        if (handMode == HandMode.TWO_HANDED) {
            return !(equipment instanceof OneHandedSlotRef) && !(equipment instanceof ShieldSlotRef);
        }
        return !(equipment instanceof TwoHandedSlotRef);
    }

    private int positive(int value) {
        return Math.max(0, value);
    }

    private <T> Set<T> safeSet(Set<T> values) {
        return values == null ? Collections.emptySet() : values;
    }
}

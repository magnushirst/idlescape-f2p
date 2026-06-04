package org.dreambot.controllers.bis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.gamedata.items.equipment.EquipmentRef;
import org.dreambot.gamedata.items.equipment.OneHandedSlotRef;
import org.dreambot.gamedata.items.equipment.ShieldSlotRef;
import org.dreambot.gamedata.items.equipment.TwoHandedSlotRef;

public class BestInSlotController {

    public BisResult calculateBestInSlot(BisRequest request) {
        Map<EquipmentSlot, List<EquipmentRef>> slotItems = buildSlotItems(request);
        Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems = new EnumMap<>(EquipmentSlot.class);

        for (Map.Entry<EquipmentSlot, List<EquipmentRef>> entry : slotItems.entrySet()) {
            rankedSlotItems.put(entry.getKey(), rankSlotItems(entry.getKey(), entry.getValue(), request));
        }

        applyAmmoSelection(request, rankedSlotItems);

        List<BisSlot> bisSlots = rankedSlotItems.entrySet().stream()
                .sorted(Comparator.comparingInt(entry -> entry.getKey().ordinal()))
                .map(entry -> new BisSlot(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());

        return new BisResult(bisSlots);
    }

    public BisResult recalculateWithSkips(BisRequest request, Set<EquipmentRef> skippedItems) {
        Set<EquipmentRef> mergedSkips = new HashSet<>(safeSet(request.getSkippedItems()));
        mergedSkips.addAll(safeSet(skippedItems));

        BisRequest rerunRequest = new BisRequest(
                request.getMetric(),
                request.getHandMode(),
                request.isFreeToPlayOnly(),
                mergedSkips);

        return calculateBestInSlot(rerunRequest);
    }

    protected Map<EquipmentSlot, List<EquipmentRef>> buildSlotItems(BisRequest request) {
        Map<EquipmentSlot, List<EquipmentRef>> SlotItems = new EnumMap<>(EquipmentSlot.class);

        for (EquipmentRef equipment : EquipmentRef.values()) {
            if (!isHandCompatible(equipment, request.getHandMode())) {
                continue;
            }
            if (!passesFilters(equipment, request) || !meetsRequirements(equipment)) {
                continue;
            }
            SlotItems.computeIfAbsent(equipment.getEquipmentSlot(), key -> new ArrayList<>())
                    .add(equipment);
        }

        return SlotItems;
    }

    protected List<EquipmentRef> rankSlotItems(EquipmentSlot slot, List<EquipmentRef> slotItems, BisRequest request) {
        List<EquipmentRef> ranked = new ArrayList<>(slotItems);
        ranked.sort(Comparator.comparingInt((EquipmentRef item) -> primaryScore(item, request))
                .thenComparingInt(this::tieBreakerScore)
                .thenComparingInt(item -> item.getItemRef().getId())
                .reversed());
        return ranked;
    }

    protected Map<EquipmentSlot, EquipmentRef> selectTopPerSlot(
            Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems, BisRequest request) {
        Map<EquipmentSlot, EquipmentRef> topPerSlot = new EnumMap<>(EquipmentSlot.class);

        for (Map.Entry<EquipmentSlot, List<EquipmentRef>> entry : rankedSlotItems.entrySet()) {
            List<EquipmentRef> rankedItems = entry.getValue();
            if (!rankedItems.isEmpty()) {
                topPerSlot.put(entry.getKey(), rankedItems.get(0));
            }
        }

        return topPerSlot;
    }

    protected boolean passesFilters(EquipmentRef equipment, BisRequest request) {
        if (request.isFreeToPlayOnly() && equipment.isMembers()) {
            return false;
        }
        return !safeSet(request.getSkippedItems()).contains(equipment);
    }

    protected boolean meetsRequirements(EquipmentRef equipment) {
       return equipment.meetsRequirements();
    }

    protected int primaryScore(EquipmentRef equipment, BisRequest request) {
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

    protected int tieBreakerScore(EquipmentRef equipment) {
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

    protected void applyAmmoSelection(BisRequest request, Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems) {
        // Hook for ranged weapon ammo compatibility selection; kept as no-op for initial implementation.
    }

    private boolean isHandCompatible(EquipmentRef equipment, HandMode handMode) {
        if (handMode == HandMode.TWO_HANDED) {
            return !(equipment instanceof OneHandedSlotRef) && !(equipment instanceof ShieldSlotRef);
        }
        return !(equipment instanceof TwoHandedSlotRef);
    }

    private int getLevel(PlayerStats playerStats, Skill skill) {
        switch (skill) {
            case ATTACK:
                return playerStats.getAttackLvl();
            case STRENGTH:
                return playerStats.getStrengthLvl();
            case DEFENCE:
                return playerStats.getDefenceLvl();
            case HITPOINTS:
                return playerStats.getHitpointLvl();
            case MAGIC:
                return playerStats.getMagicLvl();
            case RANGED:
                return playerStats.getRangedLvl();
            case PRAYER:
                return playerStats.getPrayerLvl();
            default:
                return Integer.MAX_VALUE;
        }
    }

    private int positive(int value) {
        return Math.max(0, value);
    }

    private <T> Set<T> safeSet(Set<T> values) {
        return values == null ? Collections.emptySet() : values;
    }

}

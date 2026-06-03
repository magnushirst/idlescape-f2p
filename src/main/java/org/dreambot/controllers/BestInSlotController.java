package org.dreambot.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.gamedata.items.equipment.EquipmentRef;

public class BestInSlotController {

    public BisResult calculateBestInSlot(BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public BisResult recalculateWithSkips(BisRequest request, Set<EquipmentRef> skippedItems) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected Map<EquipmentSlot, List<EquipmentRef>> buildSlotItemPool(BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected List<EquipmentRef> rankSlotItems(
            EquipmentSlot slot, List<EquipmentRef> slotItems, BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected Map<EquipmentSlot, EquipmentRef> selectTopPerSlot(
            Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems, BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected boolean passesFilters(EquipmentRef equipment, BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected boolean meetsRequirements(EquipmentRef equipment, BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected int primaryScore(EquipmentRef equipment, BisRequest request) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected int tieBreakerScore(EquipmentRef equipment) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void applyAmmoSelection(
            BisRequest request,
            Map<EquipmentSlot, List<EquipmentRef>> rankedSlotItems) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public enum BisStat {
        ATTACK_STAB,
        ATTACK_SLASH,
        ATTACK_CRUSH,
        ATTACK_RANGED,
        ATTACK_MAGIC,
        DEFENCE_STAB,
        DEFENCE_SLASH,
        DEFENCE_CRUSH,
        DEFENCE_RANGED,
        DEFENCE_MAGIC,
        STRENGTH,
        RANGED_STRENGTH,
        MAGIC_DAMAGE,
        PRAYER
    }

    public enum HandMode {
        ONE_HANDED,
        TWO_HANDED
    }

    @Getter
    @AllArgsConstructor
    public static class PlayerStats {
        private final int attackLvl;
        private final int strengthLvl;
        private final int defenceLvl;
        private final int hitpointLvl;
        private final int magicLvl;
        private final int rangedLvl;
        private final int prayerLvl;
    }

    @Getter
    @AllArgsConstructor
    public static class BisRequest {
        private final BisStat metric;
        private final HandMode handMode;
        private final PlayerStats playerStats;
        private final boolean freeToPlayOnly;
        private final Set<String> extras;
        private final Set<EquipmentRef> skippedItems;
    }

    @Getter
    @AllArgsConstructor
    public static class BisSlot {
        private final EquipmentSlot slot;
        private final List<EquipmentRef> bisItems;
    }

    @Getter
    @AllArgsConstructor
    public static class BisResult {
        private final List<BisSlot> bisSlots;
    }
}

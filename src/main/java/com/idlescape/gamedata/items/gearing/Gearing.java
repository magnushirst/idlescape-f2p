package com.idlescape.gamedata.items.gearing;

import com.idlescape.helper.GameUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.items.Item;

public class Gearing {
    private final List<GearRequirement> gearRequirements = new ArrayList<>();

    public void addGear(GearRequirement requirement) {
        gearRequirements.add(requirement);
    }

    private List<GearItem> getBestInSlot() {
        List<GearItem> items = new ArrayList<>();

        gearRequirements.stream()
                .filter(GearRequirement::canFulfill)
                .map(GearRequirement::getGear)
                .flatMap(List::stream)
                .forEach(newGearItem -> {
                    items.removeIf(gearItem -> newGearItem.getEquipmentSlot() != null
                            && newGearItem.getEquipmentSlot().equals(gearItem.getEquipmentSlot()));
                    items.add(newGearItem.clone());
                });
        return items;
    }

    private List<GearRequirement> getDeduplicatedGearRequirements() {
        List<GearRequirement> cleanedGearRequirements = new ArrayList<>(gearRequirements);
        Collections.reverse(cleanedGearRequirements);

        Set<EquipmentSlot> seenSlots = new HashSet<>();
        return cleanedGearRequirements.stream()
                .filter(requirement -> {
                    List<EquipmentSlot> slots = requirement.getGear().stream()
                            .map(GearItem::getEquipmentSlot)
                            .filter(Objects::nonNull)
                            .collect(Collectors.toList());
                    if (slots.isEmpty() || slots.stream().noneMatch(seenSlots::contains)) {
                        seenSlots.addAll(slots);
                        return true;
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public List<GearItem> getMissing() {
        return getBestInSlot().stream()
                .filter(gearItem -> {
                    int required = gearItem.getQuantity();
                    int carried = GameUtils.countCarryingItem(gearItem.getItemRef());
                    return required - carried > 0;
                })
                .collect(Collectors.toList());
    }

    public int getMissingQuantity(GearItem gearItem) {
        return Math.max(0, gearItem.getQuantity() - GameUtils.countCarryingItem(gearItem.getItemRef()));
    }

    public List<GearItem> getEquipable() {
        return getBestInSlot().stream()
                .filter(gearItem -> gearItem.getEquipmentSlot() != null)
                .filter(gearItem -> Inventory.contains(gearItem.getItemRef().getId()))
                .filter(gearItem -> !Equipment.contains(gearItem.getItemRef().getId()))
                .collect(Collectors.toList());
    }

    public List<Item> getRedundantInventory() {
        List<GearItem> bis = getBestInSlot();
        Map<Integer, Item> redundants = new HashMap<>();
        Inventory.all().stream()
                .filter(Objects::nonNull)
                .filter(item -> GameUtils.countCarryingItem(item.getId())
                        > bis.stream()
                                .filter(gearItem -> gearItem.getItemRef().getId() == item.getId())
                                .reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum))
                .forEach(item -> {
                    boolean isInBis = bis.stream()
                            .anyMatch(gearItem -> gearItem.getItemRef().getId() == item.getId());
                    int count = isInBis ? GameUtils.countCarryingItem(item.getId()) : Inventory.count(item.getId());
                    int quantity = count
                            - bis.stream()
                                    .filter(gearItem -> gearItem.getItemRef().getId() == item.getId())
                                    .reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum);
                    redundants.put(item.getId(), new Item(item.getId(), quantity));
                });

        return new ArrayList<>(redundants.values());
    }

    public List<Item> getRedundantEquipped() {
        List<GearItem> bis = getBestInSlot();
        return Equipment.all().stream()
                .filter(Objects::nonNull)
                .filter(item ->
                        bis.stream().noneMatch(gearItem -> gearItem.getItemRef().getId() == item.getId()))
                .collect(Collectors.toList());
    }

    public boolean canFulfill() {
        return gearRequirements.stream().allMatch(gearRequirement -> {
            boolean canFulfill = gearRequirement.canFulfill();
            if (!canFulfill) {
                String name = gearRequirement.getName().isEmpty() ? "Unspecified Gear" : gearRequirement.getName();
                Logger.warn("Missing: " + name);
            }
            return canFulfill;
        });
    }

    public boolean isSatisfied() {
        return getDeduplicatedGearRequirements().stream().allMatch(GearRequirement::isSatisfied);
    }
}

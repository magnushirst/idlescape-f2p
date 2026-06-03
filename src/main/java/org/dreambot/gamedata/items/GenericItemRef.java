package org.dreambot.gamedata.items;

import static org.dreambot.helper.GameUtils.equipmentContainsAny;
import static org.dreambot.helper.GameUtils.inventoryContainsAny;
import static org.dreambot.helper.GameUtils.playerOwns;

import java.util.Arrays;
import java.util.stream.Stream;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;

public interface GenericItemRef {
    int getId();

    String getDisplayName();

    boolean getMeetsRequirements();

    int[] getIds();

    GenericItemRef[] getSimilarItems();

    default boolean isCarryingSimilar() {
        return inventoryContainsAny(this.getSimilarItems()) || equipmentContainsAny(this.getSimilarItems());
    }

    default boolean isCarrying() {
        return Inventory.contains(this.getId()) || Equipment.contains(this.getId());
    }

    default boolean isInBank() {
        return Bank.contains(this.getId());
    }

    default boolean isEquipped() {
        return equipmentContainsAny(this.getSimilarItems());
    }

    default boolean isSimilarInInventory() {
        return inventoryContainsAny(this.getSimilarItems());
    }

    default int countInInventory() {
        return Inventory.count(this.getId());
    }

    default boolean isOwned() {
        return playerOwns(this);
    }

    default boolean isInInventory() {
        return Inventory.contains(this.getId());
    }

    default boolean isSimilarOwned() {
        return playerOwns(this.getSimilarItems());
    }

    String name();

    default String getPrettyName() {
        String n = this.getDisplayName();
        if (n != null && !n.isEmpty()) return n;
        String s = this.name().toLowerCase().replace('_', ' ');
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    static GenericItemRef[] values() {
        return Stream.of(ItemRef.values(), ToolItemRef.values(), WeaponItemRef.values(), ArmourItemRef.values())
                .flatMap(Stream::of)
                .toArray(GenericItemRef[]::new);
    }

    static GenericItemRef from(int id) {
        return Arrays.stream(values())
                .filter(ref -> id == ref.getId())
                .findFirst()
                .orElse(null);
    }

    static String itemName(GenericItemRef itemRef) {
        String displayName = itemRef.getDisplayName();
        if (displayName != null && !displayName.trim().isEmpty()) {
            return displayName.trim();
        }
        return itemRef.getPrettyName();
    }
}

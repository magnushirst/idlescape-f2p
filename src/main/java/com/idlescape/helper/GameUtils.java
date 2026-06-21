package com.idlescape.helper;

import com.idlescape.framework.log.StyledLogger;
import com.idlescape.framework.playerstorage.BankCache;
import com.idlescape.gamedata.items.GenericItemRef;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lombok.NonNull;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.bank.Bank;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.wrappers.items.Item;

public class GameUtils {
    private static StyledLogger LOGGER = new StyledLogger(GameUtils.class);

    public static boolean dropItems(GenericItemRef... genericItemRefs) {
        Arrays.stream(genericItemRefs)
                .filter(GenericItemRef::isInInventory)
                .forEach(itemRef -> Inventory.dropAll(itemRef.getId()));
        return inventoryContainsAny(genericItemRefs);
    }

    public static boolean equipmentContainsAny(@NonNull GenericItemRef[] itemRefs) {
        return Arrays.stream(itemRefs).anyMatch(itemRef -> Equipment.contains(itemRef.getId()));
    }

    public static boolean inventoryContainsAny(@NonNull GenericItemRef[] itemRefs) {
        return Arrays.stream(itemRefs).anyMatch(itemRef -> Inventory.contains(itemRef.getId()));
    }

    public static boolean inventoryContainsAny(int... itemIds) {
        return Arrays.stream(itemIds).anyMatch(Inventory::contains);
    }

    public static boolean playerOwns(GenericItemRef itemRef, int quantity) {
        return countInBank(itemRef) + countCarryingItem(itemRef) >= quantity;
    }

    public static boolean playerOwns(GenericItemRef... itemRefs) {
        return Arrays.stream(itemRefs).allMatch(itemRef -> itemRef.isInBank() || itemRef.isCarrying());
    }

    public static int countCarryingItem(GenericItemRef itemRef) {
        return countCarryingItem(itemRef.getId());
    }

    public static int countCarryingItem(int itemId) {
        return Inventory.count(itemId) + Equipment.count(itemId);
    }

    public static int countOwns(GenericItemRef itemRef) {
        return countCarryingItem(itemRef) + countInBank(itemRef);
    }

    public static int countInBank(GenericItemRef itemRef) {
        List<Item> items = Bank.all();

        if (items.isEmpty()) {
            BankCache.warnBankNotCached();
            return 0;
        }

        return items.stream()
                .filter(Objects::nonNull)
                .filter(item -> item.getId() == itemRef.getId())
                .mapToInt(Item::getAmount)
                .sum();
    }
}

package com.idlescape.gamedata.items.gearing.impl;

import static com.idlescape.helper.GameUtils.countOwns;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.OptionalItem;
import com.idlescape.gamedata.items.gearing.RequiredItem;
import com.idlescape.helper.GameUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationOfRequiredItems implements GearRequirement {
    List<RequiredItem> requiredItems = new ArrayList<>();
    String name = "";
    int maxQuantity = 0;
    int minQuantity = 0;

    public CombinationOfRequiredItems(int maxQuantity, int minQuantity, List<RequiredItem> requiredItems) {
        this("", maxQuantity, minQuantity, requiredItems);
    }

    public CombinationOfRequiredItems(int maxQuantity, int minQuantity, RequiredItem... requiredItems) {
        this("", maxQuantity, minQuantity, Arrays.stream(requiredItems).collect(Collectors.toList()));
    }

    public CombinationOfRequiredItems(String name, int maxQuantity, int minQuantity, RequiredItem... requiredItems) {
        this(name, maxQuantity, minQuantity, Arrays.stream(requiredItems).collect(Collectors.toList()));
    }

    public CombinationOfRequiredItems(String name, int maxQuantity, int minQuantity, List<RequiredItem> requiredItems) {
        this.requiredItems.addAll(requiredItems);
        this.maxQuantity = maxQuantity;
        this.minQuantity = minQuantity;
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        List<GearItem> gearToReturn = new ArrayList<>();
        for (RequiredItem requiredItem : requiredItems) {
            int quantityFound = gearToReturn.stream().reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum);
            if (quantityFound == maxQuantity) {
                break;
            }
            int quantityNeeded = maxQuantity - quantityFound;
            int quantityOwned = countOwns(requiredItem.getItemRef());
            if (quantityOwned > 0) {
                gearToReturn.add(new OptionalItem(requiredItem.getItemRef(), Math.min(quantityOwned, quantityNeeded)));
            }
        }
        return gearToReturn.stream().reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum) >= minQuantity
                ? gearToReturn
                : new ArrayList<>();
    }

    @Override
    public boolean canFulfill() {
        return requiredItems.stream()
                        .mapToInt(requiredItem -> countOwns(requiredItem.getItemRef()))
                        .sum()
                >= minQuantity;
    }

    @Override
    public boolean isSatisfied() {
        return requiredItems.stream()
                        .mapToInt(requiredItem -> GameUtils.countCarryingItem(requiredItem.getItemRef()))
                        .sum()
                >= minQuantity;
    }

    @Override
    public String getName() {
        return name;
    }
}

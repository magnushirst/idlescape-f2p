package com.idlescape.gamedata.items.gearing.impl;

import static com.idlescape.helper.GameUtils.countOwns;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.OptionalItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationOfOptionalItems implements GearRequirement {
    List<OptionalItem> optionalItems = new ArrayList<>();
    String name = "";
    int maxQuantity = 0;
    int minQuantity = 0;

    public CombinationOfOptionalItems(int maxQuantity, OptionalItem... optionalItems) {
        this("", maxQuantity, Arrays.stream(optionalItems).collect(Collectors.toList()));
    }

    public CombinationOfOptionalItems(int maxQuantity, List<OptionalItem> optionalItems) {
        this("", maxQuantity, optionalItems);
    }

    public CombinationOfOptionalItems(String name, int maxQuantity, OptionalItem... optionalItems) {
        this(name, maxQuantity, Arrays.stream(optionalItems).collect(Collectors.toList()));
    }

    public CombinationOfOptionalItems(String name, int maxQuantity, List<OptionalItem> optionalItems) {
        this.optionalItems.addAll(optionalItems);
        this.maxQuantity = maxQuantity;
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        List<GearItem> gearToReturn = new ArrayList<>();
        for (OptionalItem optionalItem : optionalItems) {
            int quantityFound = gearToReturn.stream().reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum);
            if (quantityFound == maxQuantity) {
                break;
            }
            int quantityNeeded = maxQuantity - quantityFound;
            int quantityOwned = countOwns(optionalItem.getItemRef());
            if (quantityOwned > 0) {
                gearToReturn.add(new OptionalItem(optionalItem.getItemRef(), Math.min(quantityOwned, quantityNeeded)));
            }
        }
        return gearToReturn.stream().reduce(0, (a, b) -> a + b.getQuantity(), Integer::sum) >= minQuantity
                ? gearToReturn
                : new ArrayList<>();
    }

    @Override
    public boolean canFulfill() {
        return true;
    }

    @Override
    public boolean isSatisfied() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }
}

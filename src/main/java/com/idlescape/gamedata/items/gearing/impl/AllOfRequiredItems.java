package com.idlescape.gamedata.items.gearing.impl;

import static com.idlescape.helper.GameUtils.playerOwns;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.RequiredItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllOfRequiredItems implements GearRequirement {
    List<RequiredItem> requiredItems = new ArrayList<>();
    String name = "";

    public AllOfRequiredItems(RequiredItem... requiredItems) {
        this("", Arrays.stream(requiredItems).collect(Collectors.toList()));
    }

    public AllOfRequiredItems(List<RequiredItem> requiredItem) {
        this("", requiredItem);
    }

    public AllOfRequiredItems(String name, RequiredItem... requiredItem) {
        this(name, Arrays.stream(requiredItem).collect(Collectors.toList()));
    }

    public AllOfRequiredItems(String name, List<RequiredItem> requiredItem) {
        this.requiredItems.addAll(requiredItem);
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        boolean ownsAll = requiredItems.stream()
                .allMatch(optionalItem -> playerOwns(optionalItem.getItemRef(), optionalItem.getMinQuantity()));

        return !ownsAll
                ? new ArrayList<>()
                : requiredItems.stream()
                        .filter(optionalItem -> playerOwns(optionalItem.getItemRef(), optionalItem.getMinQuantity()))
                        .collect(Collectors.toList());
    }

    @Override
    public boolean canFulfill() {
        return requiredItems.stream()
                .allMatch(requiredItem -> playerOwns(requiredItem.getItemRef(), requiredItem.getMinToWithdraw()));
    }

    @Override
    public boolean isSatisfied() {
        return requiredItems.stream().allMatch(GearItem::hasItemOnPlayer);
    }

    @Override
    public String getName() {
        return name;
    }
}

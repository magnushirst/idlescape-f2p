package com.idlescape.gamedata.items.gearing.impl;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.RequiredItem;
import com.idlescape.helper.GameUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OneOfRequiredItems implements GearRequirement {
    List<RequiredItem> requiredItems = new ArrayList<>();
    String name = "";

    public OneOfRequiredItems(RequiredItem... requiredItems) {
        this("", Arrays.stream(requiredItems).collect(Collectors.toList()));
    }

    public OneOfRequiredItems(List<RequiredItem> requiredItems) {
        this("", requiredItems);
    }

    public OneOfRequiredItems(String name, RequiredItem... requiredItems) {
        this(name, Arrays.stream(requiredItems).collect(Collectors.toList()));
    }

    public OneOfRequiredItems(String name, List<RequiredItem> requiredItems) {
        this.requiredItems.addAll(requiredItems);
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        return requiredItems.stream()
                .filter(requiredItem -> GameUtils.playerOwns(requiredItem.getItemRef(), requiredItem.getMinQuantity()))
                .findFirst()
                .<List<GearItem>>map(Collections::singletonList)
                .orElseGet(ArrayList::new);
    }

    @Override
    public boolean canFulfill() {
        return requiredItems.stream()
                .anyMatch(requiredItem ->
                        GameUtils.playerOwns(requiredItem.getItemRef(), requiredItem.getMinToWithdraw()));
    }

    @Override
    public boolean isSatisfied() {
        return requiredItems.stream()
                .anyMatch(requiredItem ->
                        GameUtils.countCarryingItem(requiredItem.getItemRef()) >= requiredItem.getMinQuantity());
    }

    @Override
    public String getName() {
        return name;
    }
}

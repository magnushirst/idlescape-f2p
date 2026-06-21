package com.idlescape.gamedata.items.gearing.impl;

import static com.idlescape.helper.GameUtils.playerOwns;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.OptionalItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllOfOptionalItems implements GearRequirement {
    List<OptionalItem> optionalItems = new ArrayList<>();
    String name = "";

    public AllOfOptionalItems(List<OptionalItem> optionalItem) {
        this("", optionalItem);
    }

    public AllOfOptionalItems(String name, List<OptionalItem> optionalItem) {
        this.optionalItems.addAll(optionalItem);
        this.name = name;
    }

    public AllOfOptionalItems(String name, OptionalItem... optionalItems) {
        this.optionalItems.addAll(Arrays.stream(optionalItems).collect(Collectors.toList()));
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        boolean ownsAll = optionalItems.stream()
                .allMatch(optionalItem -> playerOwns(optionalItem.getItemRef(), optionalItem.getMinQuantity()));

        return !ownsAll
                ? new ArrayList<>()
                : optionalItems.stream()
                        .filter(optionalItem -> playerOwns(optionalItem.getItemRef(), optionalItem.getMinQuantity()))
                        .collect(Collectors.toList());
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

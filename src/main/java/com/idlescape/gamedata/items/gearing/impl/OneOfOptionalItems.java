package com.idlescape.gamedata.items.gearing.impl;

import static com.idlescape.helper.GameUtils.playerOwns;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.OptionalItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OneOfOptionalItems implements GearRequirement {
    List<OptionalItem> optionalItems = new ArrayList<>();
    String name = "";

    public OneOfOptionalItems(List<OptionalItem> optionalItems) {
        this("", optionalItems);
    }

    public OneOfOptionalItems(String name, List<OptionalItem> optionalItems) {
        this.optionalItems.addAll(optionalItems);
        this.name = name;
    }

    public OneOfOptionalItems(String name, OptionalItem... optionalItems) {
        this(name, Arrays.stream(optionalItems).collect(Collectors.toList()));
    }

    @Override
    public List<GearItem> getGear() {
        return optionalItems.stream()
                .filter(optionalItem -> playerOwns(optionalItem.getItemRef(), optionalItem.getMinQuantity()))
                .findFirst()
                .<List<GearItem>>map(Collections::singletonList)
                .orElseGet(ArrayList::new);
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

package com.idlescape.gamedata.items.gearing.impl;

import static com.idlescape.helper.GameUtils.playerOwns;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.OptionalItem;
import java.util.Collections;
import java.util.List;

public class OneOptionalItem implements GearRequirement {
    OptionalItem optionalItem;
    String name = "";

    public OneOptionalItem(OptionalItem optionalItem) {
        this("", optionalItem);
    }

    public OneOptionalItem(String name, OptionalItem optionalItem) {
        this.optionalItem = optionalItem;
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        return playerOwns(optionalItem.getItemRef(), optionalItem.getMinQuantity())
                ? Collections.singletonList(optionalItem)
                : Collections.emptyList();
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
        return "";
    }
}

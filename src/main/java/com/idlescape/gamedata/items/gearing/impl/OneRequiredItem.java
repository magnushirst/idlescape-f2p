package com.idlescape.gamedata.items.gearing.impl;

import com.idlescape.gamedata.items.gearing.GearItem;
import com.idlescape.gamedata.items.gearing.GearRequirement;
import com.idlescape.gamedata.items.gearing.RequiredItem;
import com.idlescape.helper.GameUtils;
import java.util.Collections;
import java.util.List;

public class OneRequiredItem implements GearRequirement {
    RequiredItem requiredItem;
    String name = "";

    public OneRequiredItem(RequiredItem requiredItem) {
        this("", requiredItem);
    }

    public OneRequiredItem(String name, RequiredItem requiredItem) {
        this.requiredItem = requiredItem;
        this.name = name;
    }

    @Override
    public List<GearItem> getGear() {
        return canFulfill() ? Collections.singletonList(requiredItem) : Collections.emptyList();
    }

    @Override
    public boolean canFulfill() {
        return GameUtils.playerOwns(requiredItem.getItemRef(), requiredItem.getMinToWithdraw());
    }

    @Override
    public boolean isSatisfied() {
        return GameUtils.countCarryingItem(requiredItem.getItemRef()) >= requiredItem.getMinQuantity();
    }

    @Override
    public String getName() {
        return name;
    }
}

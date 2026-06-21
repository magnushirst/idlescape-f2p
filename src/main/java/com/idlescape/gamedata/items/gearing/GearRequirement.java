package com.idlescape.gamedata.items.gearing;

import java.util.List;

public interface GearRequirement {
    List<GearItem> getGear();

    boolean canFulfill();

    boolean isSatisfied();

    String getName();
}

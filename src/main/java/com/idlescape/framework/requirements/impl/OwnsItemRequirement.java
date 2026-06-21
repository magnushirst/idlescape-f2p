package com.idlescape.framework.requirements.impl;

import com.idlescape.framework.requirements.IRequirement;
import com.idlescape.gamedata.items.GenericItemRef;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public final class OwnsItemRequirement implements IRequirement {
    private final GenericItemRef item;

    @Override
    public boolean hasMet() {
        return item.isOwned();
    }
}

package org.dreambot.framework.requirements.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.framework.requirements.IRequirement;
import org.dreambot.gamedata.items.GenericItemRef;

@Getter
@AllArgsConstructor
public final class OwnsItemRequirement implements IRequirement {
    private final GenericItemRef item;

    @Override
    public boolean hasMet() {
        return item.isOwned();
    }
}

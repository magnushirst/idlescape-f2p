package org.dreambot.controllers.bis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.gamedata.items.equipment.EquipmentRef;

import java.util.Collections;
import java.util.Set;

@Getter
@AllArgsConstructor
public class BisRequest {
    private final BisStat metric;
    private final HandMode handMode;
    private final boolean freeToPlayOnly;
    private final Set<EquipmentRef> skippedItems;

    public BisRequest(BisStat metric, HandMode handMode, boolean freeToPlayOnly) {
        this(
                metric,
                handMode,
                freeToPlayOnly,
                Collections.emptySet());
    }
}

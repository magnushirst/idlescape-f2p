package org.dreambot.controllers.bis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.gamedata.items.equipment.EquipmentRef;

import java.util.List;

@Getter
@AllArgsConstructor
public class BisSlot {
    private final EquipmentSlot slot;
    private final List<EquipmentRef> bisItems;
}

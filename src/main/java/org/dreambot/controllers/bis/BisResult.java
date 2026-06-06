package org.dreambot.controllers.bis;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.gamedata.items.equipment.EquipmentRef;

@Getter
@AllArgsConstructor
public class BisResult {
    private final Map<EquipmentSlot, List<EquipmentRef>> bisBySlot;
}

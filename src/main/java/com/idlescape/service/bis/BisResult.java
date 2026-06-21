package com.idlescape.service.bis;

import com.idlescape.gamedata.items.GenericItemRef;
import com.idlescape.gamedata.items.equipment.EquipmentRef;
import com.idlescape.gamedata.items.gearing.Gearing;
import com.idlescape.gamedata.items.gearing.OptionalItem;
import com.idlescape.gamedata.items.gearing.RequiredItem;
import com.idlescape.gamedata.items.gearing.impl.OneOfOptionalItems;
import com.idlescape.gamedata.items.gearing.impl.OneOfRequiredItems;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;

@Getter
@AllArgsConstructor
public class BisResult {
    private final Map<EquipmentSlot, List<EquipmentRef>> bisBySlot;

    public Gearing getAsRequiredItems() {
        Gearing gearing = new Gearing();
        for (Map.Entry<EquipmentSlot, List<EquipmentRef>> bis : bisBySlot.entrySet()) {
            List<RequiredItem> requiredItems = new ArrayList<>();
            for (EquipmentRef bisItem : bis.getValue()) {
                for (GenericItemRef itemRef : bisItem.getSimilarItems()) {
                    RequiredItem requiredItem = new RequiredItem(itemRef, bis.getKey());
                    requiredItem.setRequirement(bisItem.getRequirement());
                    if (!requiredItems.contains(requiredItem)) {
                        requiredItems.add(requiredItem);
                    }
                }
            }
            gearing.addGear(new OneOfRequiredItems(bis.getKey().toString().toLowerCase(), requiredItems));
        }
        return gearing;
    }

    public Gearing getAsOptionalItems() {
        Gearing gearing = new Gearing();
        for (Map.Entry<EquipmentSlot, List<EquipmentRef>> bis : bisBySlot.entrySet()) {
            List<OptionalItem> optionalItems = new ArrayList<>();
            for (EquipmentRef bisItem : bis.getValue()) {
                for (GenericItemRef itemRef : bisItem.getSimilarItems()) {
                    OptionalItem requiredItem = new OptionalItem(itemRef, bis.getKey());
                    if (!optionalItems.contains(requiredItem)) {
                        optionalItems.add(requiredItem);
                    }
                }
            }
            gearing.addGear(new OneOfOptionalItems(bis.getKey().toString().toLowerCase(), optionalItems));
        }
        return gearing;
    }
}

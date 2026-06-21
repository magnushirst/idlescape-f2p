package com.idlescape.gamedata.items.gearing;

import com.idlescape.framework.requirements.Requirement;
import com.idlescape.framework.requirements.RequirementBuilder;
import com.idlescape.gamedata.items.GenericItemRef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.utilities.Sleep;
import org.dreambot.api.wrappers.items.Item;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class GearItem implements Cloneable {
    private GenericItemRef itemRef;
    private EquipmentSlot equipmentSlot = null;
    private boolean isRequired = false;
    private int quantity = 1;
    private int minQuantity = 1;
    private int minToWithdraw = -1;
    private Requirement requirement = new RequirementBuilder().alwaysTrue().build();

    public boolean meetsRequirements() {
        return requirement.hasMet();
    }

    public boolean hasItemOnPlayer() {
        if (equipmentSlot == null) {
            return Inventory.count(itemRef.getId()) >= minQuantity || Equipment.count(itemRef.getId()) >= minQuantity;
        } else {
            return Equipment.contains(itemRef.getId()) || Inventory.contains(itemRef.getId());
        }
    }

    public boolean hasEquipped() {
        if (equipmentSlot == null) {
            return true;
        } else {
            return Equipment.contains(itemRef.getId());
        }
    }

    public boolean equip() {
        if (equipmentSlot == null) {
            return true;
        }

        if (itemRef == null) {
            return false;
        }

        int itemId = itemRef.getId();

        if (Inventory.contains(itemId)) {
            int before = Inventory.count(itemId);

            Item item = Inventory.get(itemId);
            if (item == null) {
                return false;
            }

            if (item.hasAction("Wield")) {
                Inventory.interact(itemId, "Wield");
            } else if (item.hasAction("Wear")) {
                Inventory.interact(itemId, "Wear");
            } else if (item.hasAction("Equip")) {
                Inventory.interact(itemId, "Equip");
            } else {
                return false;
            }

            Sleep.sleepUntil(() -> before != Inventory.count(itemId), 5_000);
            Sleep.sleep(100, 300);
        }

        return Equipment.slotContains(equipmentSlot, itemId);
    }

    public int getMinToWithdraw() {
        return minToWithdraw != -1 ? minToWithdraw : Math.min(minQuantity, quantity);
    }

    @Override
    public GearItem clone() {
        try {
            return (GearItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

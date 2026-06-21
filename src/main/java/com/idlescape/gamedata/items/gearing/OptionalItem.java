package com.idlescape.gamedata.items.gearing;

import com.idlescape.framework.requirements.Requirement;
import com.idlescape.gamedata.items.GenericItemRef;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;

public class OptionalItem extends GearItem {
    public OptionalItem(GenericItemRef itemRef) {
        this.setItemRef(itemRef);
    }

    public OptionalItem(GenericItemRef itemRef, Requirement condition) {
        this.setItemRef(itemRef);
        this.setRequirement(condition);
    }

    public OptionalItem(GenericItemRef itemRef, int quantity) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
    }

    public OptionalItem(GenericItemRef itemRef, int quantity, int minQuantity) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
        this.setMinQuantity(minQuantity);
    }

    public OptionalItem(GenericItemRef itemRef, EquipmentSlot equipmentSlot) {
        this.setItemRef(itemRef);
        this.setEquipmentSlot(equipmentSlot);
        this.setQuantity(1);
        this.setMinQuantity(1);
    }

    public OptionalItem(GenericItemRef itemRef, EquipmentSlot equipmentSlot, Requirement condition) {
        this.setItemRef(itemRef);
        this.setEquipmentSlot(equipmentSlot);
        this.setQuantity(1);
        this.setMinQuantity(1);
        this.setRequirement(condition);
    }
}

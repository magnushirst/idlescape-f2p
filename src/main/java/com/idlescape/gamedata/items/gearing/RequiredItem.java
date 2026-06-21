package com.idlescape.gamedata.items.gearing;

import com.idlescape.framework.requirements.Requirement;
import com.idlescape.gamedata.items.GenericItemRef;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;

public class RequiredItem extends GearItem {
    public RequiredItem(GenericItemRef itemRef) {
        this.setItemRef(itemRef);
        this.setRequired(true);
    }

    public RequiredItem(GenericItemRef itemRef, Requirement condition) {
        this.setItemRef(itemRef);
        this.setRequirement(condition);
    }

    public RequiredItem(GenericItemRef itemRef, int quantity) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
        this.setMinQuantity(quantity);
        this.setRequired(true);
    }

    public RequiredItem(GenericItemRef itemRef, EquipmentSlot equipmentSlot) {
        this.setItemRef(itemRef);
        this.setEquipmentSlot(equipmentSlot);
        this.setRequired(true);
    }

    public RequiredItem(GenericItemRef itemRef, int quantity, EquipmentSlot equipmentSlot) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
        this.setMinQuantity(quantity);
        this.setEquipmentSlot(equipmentSlot);
        this.setRequired(true);
    }

    public RequiredItem(GenericItemRef itemRef, int quantity, int minQuantity) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
        this.setMinQuantity(minQuantity);
        this.setRequired(true);
    }

    public RequiredItem(
            GenericItemRef itemRef,
            int quantity,
            EquipmentSlot equipmentSlot,
            int minQuantity,
            int minWithdrawQuantity) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
        this.setMinQuantity(minQuantity);
        this.setMinToWithdraw(minWithdrawQuantity);
        this.setEquipmentSlot(equipmentSlot);
        this.setRequired(true);
    }

    public RequiredItem(GenericItemRef itemRef, int quantity, int minQuantity, int minWithdrawQuantity) {
        this.setItemRef(itemRef);
        this.setQuantity(quantity);
        this.setMinQuantity(minQuantity);
        this.setMinToWithdraw(minWithdrawQuantity);
        this.setRequired(true);
    }
}

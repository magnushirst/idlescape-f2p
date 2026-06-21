package com.idlescape.gamedata.items.gearing;

import com.idlescape.gamedata.items.ItemRef;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;

public class RequiredEquipment extends RequiredItem {
    public RequiredEquipment(ItemRef itemRef) {
        super(itemRef);
    }

    public RequiredEquipment(ItemRef itemRef, int quantity) {
        super(itemRef, quantity);
    }

    public RequiredEquipment(ItemRef itemRef, EquipmentSlot equipmentSlot) {
        super(itemRef, equipmentSlot);
    }

    public RequiredEquipment(ItemRef itemRef, int quantity, EquipmentSlot equipmentSlot) {
        super(itemRef, quantity, equipmentSlot);
    }

    public RequiredEquipment(ItemRef itemRef, int quantity, int minQuantity) {
        super(itemRef, quantity, minQuantity);
    }

    public RequiredEquipment(ItemRef itemRef, int quantity, int minQuantity, int minWithdrawQuantity) {
        super(itemRef, quantity, minQuantity, minWithdrawQuantity);
    }
}

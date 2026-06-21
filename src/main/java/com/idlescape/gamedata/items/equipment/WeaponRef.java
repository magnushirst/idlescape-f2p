package com.idlescape.gamedata.items.equipment;

import com.idlescape.gamedata.items.equipment.ammunition.Ammo;

public interface WeaponRef extends EquipmentRef {
    boolean isTwoHanded();

    Ammo getAmmo();
}

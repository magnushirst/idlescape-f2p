package org.dreambot.gamedata.items.equipment;

import org.dreambot.gamedata.items.equipment.ammunition.Ammo;

public interface WeaponRef extends EquipmentRef {
    boolean isTwoHanded();
    Ammo getAmmo();
}

package org.dreambot.gamedata.items;

import static org.junit.jupiter.api.Assertions.*;

import org.dreambot.gamedata.items.equipment.TwoHandedSlotRef;
import org.junit.jupiter.api.Test;

public class WeaponItemRefTest {

    @Test
    public void testSandDoesNotReturnAsTwoHanded() {
        assertFalse(WeaponItemRef.isTwoHanded(ItemRef.BUCKET_OF_SAND));
    }

    @Test
    public void testOneHandedWeaponDoeNotReturnAsTwoHanded() {
        assertFalse(WeaponItemRef.isTwoHanded(WeaponItemRef._3RD_AGE_AXE));
    }

    @Test
    public void testTwoHandedWeaponReturnAsTwoHanded() {
        assertTrue(WeaponItemRef.isTwoHanded(TwoHandedSlotRef.ABYSSAL_BLUDGEON.getItemRef()));
    }
}

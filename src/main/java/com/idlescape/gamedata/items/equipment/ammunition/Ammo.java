package com.idlescape.gamedata.items.equipment.ammunition;

import static com.idlescape.helper.Comparisons.isIn;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public final class Ammo {
    private AmmoType[] ammoType;
    private AmmoTier ammoTier;

    public Ammo(AmmoTier ammoTier, AmmoType... ammoType) {
        this.ammoType = ammoType;
        this.ammoTier = ammoTier;
    }

    public Ammo(AmmoType ammoType, AmmoTier ammoTier) {
        this.ammoType = new AmmoType[] {ammoType};
        this.ammoTier = ammoTier;
    }

    public boolean isCompatibleWith(Ammo ammoToMatch) {

        return this.ammoTier.isCompatibleWith(ammoToMatch.ammoTier)
                && Arrays.stream(ammoToMatch.getAmmoType())
                        .anyMatch(ammoTypeToMatch -> isIn(ammoTypeToMatch, (Object[]) this.getAmmoType()));
    }
}

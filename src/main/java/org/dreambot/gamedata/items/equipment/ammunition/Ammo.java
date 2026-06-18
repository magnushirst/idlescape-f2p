package org.dreambot.gamedata.items.equipment.ammunition;

import static org.dreambot.helper.Comparisons.isIn;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Ammo {
    AmmoType[] ammoType;
    AmmoTier ammoTier;

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

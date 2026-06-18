package org.dreambot.gamedata.items.equipment.ammunition;

public enum AmmoTier {
    TIER_90,  //Dragon
    TIER_80,  //Amethyst
    TIER_70,  //Rune
    TIER_60,  //Adamant
    TIER_50,  //Mithril
    TIER_40,  //Steel
    TIER_30,  //Iron
    TIER_20,  //Blurite
    TIER_10,  //Bronze
    NO_TIER   //For ammo types with only 1 tier
    ;

    public boolean isCompatibleWith(AmmoTier ammoTier) {
        return this.ordinal() <= ammoTier.ordinal();
    }
}

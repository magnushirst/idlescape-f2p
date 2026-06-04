package org.dreambot.controllers.bis;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerStats {
    private final int attackLvl;
    private final int strengthLvl;
    private final int defenceLvl;
    private final int hitpointLvl;
    private final int magicLvl;
    private final int rangedLvl;
    private final int prayerLvl;
}

package com.idlescape.gamedata.combat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SkillsBonus {
    private final int strengthBonus;
    private final int rangedStrengthBonus;
    private final int magicDamageBonus;
    private final int prayerBonus;
}

package com.idlescape.gamedata.combat;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AttackBonus {
    private final int stab;
    private final int slash;
    private final int crush;
    private final int magic;
    private final int ranged;
}

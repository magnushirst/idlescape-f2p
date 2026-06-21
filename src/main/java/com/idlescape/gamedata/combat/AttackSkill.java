package com.idlescape.gamedata.combat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.prayer.Prayer;

@AllArgsConstructor
@Getter
public enum AttackSkill {
    RANGED(Prayer.PROTECT_FROM_MISSILES),
    MAGIC(Prayer.PROTECT_FROM_MAGIC),
    MELEE(Prayer.PROTECT_FROM_MELEE);

    private final Prayer prayer;
}

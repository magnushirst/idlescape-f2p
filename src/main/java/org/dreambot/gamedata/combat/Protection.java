package org.dreambot.gamedata.combat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.helper.combat.CombatHelper;

@AllArgsConstructor
@Getter
public enum Protection {
    NONE(-1, AttackSkill.MELEE),
    MELEE(0, AttackSkill.MELEE),
    RANGED(1, AttackSkill.RANGED),
    MAGIC(2, AttackSkill.MAGIC);

    private final int overheadId;
    private final AttackSkill attackSkill;

    public static Protection getProtectionFromOverheadId(int overheadId) {
        for (Protection protection : Protection.values()) {
            if (protection.overheadId == overheadId) {
                return protection;
            }
        }
        Logger.error("Unknown Protection overhead id: " + overheadId + " (treating as NONE)");
        return NONE;
    }

    public static Protection getNpcProtection(NPC npc) {
        if (npc == null) {
            return NONE;
        }

        short[] sprites = npc.getCurrentOverheadSpriteIndices();
        int overheadId = CombatHelper.getOverHeadNpcPrayer(sprites);
        return getProtectionFromOverheadId(overheadId);
    }
}

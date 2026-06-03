package org.dreambot.gamedata.combat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DefenceBonus {
    private int stab;
    private int slash;
    private int crush;
    private int magic;
    private int ranged;

    public DefenceBonus() {
        this.stab = 0;
        this.slash = 0;
        this.crush = 0;
        this.magic = 0;
        this.ranged = 0;
    }

    public void addStab(int value) {
        this.stab += value;
    }

    public void addSlash(int value) {
        this.slash += value;
    }

    public void addCrush(int value) {
        this.crush += value;
    }

    public void addMagic(int value) {
        this.magic += value;
    }

    public void addRanged(int value) {
        this.ranged += value;
    }

    public AttackSkill getWeakTo() {
        int melee = Math.max(stab, Math.max(slash, crush));

        if (melee <= ranged && melee <= magic) {
            return AttackSkill.MELEE;
        }
        if (ranged <= melee && ranged <= magic) {
            return AttackSkill.RANGED;
        }
        return AttackSkill.MAGIC;
    }

    public AttackSkill getStrongTo() {
        int melee = Math.max(stab, Math.max(slash, crush));

        if (melee >= ranged && melee >= magic) {
            return AttackSkill.MELEE;
        }
        if (ranged >= melee && ranged >= magic) {
            return AttackSkill.RANGED;
        }
        return AttackSkill.MAGIC;
    }
}

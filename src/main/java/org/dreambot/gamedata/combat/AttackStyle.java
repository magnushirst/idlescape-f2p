package org.dreambot.gamedata.combat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.combat.CombatStyle;

@AllArgsConstructor
@Getter
public enum AttackStyle {
    RANGED(Protection.RANGED, CombatStyle.RANGED, CombatStyle.RANGED_DEFENCE, CombatStyle.RANGED_RAPID),
    MAGIC(Protection.MAGIC, CombatStyle.MAGIC, CombatStyle.MAGIC_DEFENCE),
    MELEE(Protection.MELEE, CombatStyle.SHARED, CombatStyle.ATTACK, CombatStyle.STRENGTH, CombatStyle.DEFENCE);

    private final List<CombatStyle> styles;
    private final Protection protection;

    AttackStyle(Protection protection, CombatStyle... styles) {
        this.protection = protection;
        this.styles = Collections.unmodifiableList(Arrays.asList(styles));
    }

    public CombatStyle defaultStyle() {
        return styles.get(0);
    }

    public boolean supports(CombatStyle style) {
        return styles.contains(style);
    }

    public CombatStyle coerce(CombatStyle style) {
        return supports(style) ? style : defaultStyle();
    }

    public boolean isBlockedBy(Protection p) {
        return p != null && p != Protection.NONE && this.protection == p;
    }

    public static AttackStyle from(CombatStyle style) {
        if (style == null) return null;
        for (AttackStyle as : values()) {
            if (as.supports(style)) return as;
        }
        return null;
    }

    public static AttackStyle pickAllowed(AttackStyle current, Protection enemyProt) {
        if (current == null) {
            current = MELEE;
        }

        if (!current.isBlockedBy(enemyProt)) {
            return current;
        }

        for (AttackStyle as : values()) {
            if (!as.isBlockedBy(enemyProt)) return as;
        }
        return current;
    }

    @Override
    public String toString() {
        String n = name().toLowerCase();
        return Character.toUpperCase(n.charAt(0)) + n.substring(1);
    }
}

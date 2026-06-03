package org.dreambot.helper.combat;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.BooleanSupplier;
import org.dreambot.api.methods.combat.Combat;
import org.dreambot.api.methods.combat.CombatStyle;
import org.dreambot.api.methods.container.impl.Inventory;
import org.dreambot.api.methods.container.impl.equipment.Equipment;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.interactive.Players;
import org.dreambot.api.methods.prayer.Prayer;
import org.dreambot.api.methods.prayer.Prayers;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.api.methods.widget.Widgets;
import org.dreambot.api.utilities.Sleep;
import org.dreambot.api.wrappers.interactive.Character;
import org.dreambot.api.wrappers.interactive.NPC;
import org.dreambot.api.wrappers.widgets.WidgetChild;
import org.dreambot.gamedata.combat.AttackStyle;
import org.dreambot.gamedata.combat.Protection;
import org.dreambot.gamedata.items.GenericItemRef;

public class CombatHelper {
    public static int getOverHeadNpcPrayer(short[] array) {
        if (array == null) return -1;
        for (short v : array) {
            if (v >= 0) return v;
        }
        return -1;
    }

    public static CombatStyle getCombatStyle() {
        return Combat.getCombatStyle();
    }

    public static AttackStyle getAttackStyle() {
        return AttackStyle.from(getCombatStyle());
    }

    public static boolean canAttackWithCurrentStyle(NPC npc) {
        Protection p = Protection.getNpcProtection(npc);
        AttackStyle current = getAttackStyle();
        if (current == null) {
            return true;
        }
        return !current.isBlockedBy(p);
    }

    public static AttackStyle getRecommendedAttackStyle(NPC npc) {
        Protection p = Protection.getNpcProtection(npc);
        AttackStyle current = getAttackStyle();
        return AttackStyle.pickAllowed(current, p);
    }

    public static BooleanSupplier conditionalShouldEquip(Protection blockedBy) {
        return () -> {
            if (!Players.getLocal().isInCombat()) {
                return false;
            }

            Character interacting = Players.getLocal().getInteractingCharacter();
            if (!(interacting instanceof NPC)) {
                return false;
            }

            NPC npc = (NPC) interacting;

            Protection p = Protection.getNpcProtection(npc);
            if (p == null || p == Protection.NONE) {
                return false;
            }

            return p != blockedBy && !CombatHelper.canAttackWithCurrentStyle(npc);
        };
    }

    public static boolean weaponHasSpecial() {
        WidgetChild specialAttackWidget = Widgets.get(160, 36);
        return specialAttackWidget != null && specialAttackWidget.isVisible();
    }

    public static boolean canUseSpecialAttack(SpecialAttack specialAttack) {
        return specialAttack != null
                && specialAttack.meetsRequirements()
                && isCarryingSpecialAttackWeapon(specialAttack)
                && canEquipSpecialAttackWeapon(specialAttack)
                && hasSpecialAttackEnergy(specialAttack);
    }

    public static boolean hasSpecialAttackEnergy(SpecialAttack specialAttack) {
        return specialAttack != null
                && (!specialAttack.usesSpecialAttackEnergy()
                        || Combat.getSpecialPercentage() >= specialAttack.getEnergyUsed());
    }

    public static boolean isCarryingSpecialAttackWeapon(SpecialAttack specialAttack) {
        return specialAttack != null
                && Arrays.stream(specialAttack.getItemRefs())
                        .anyMatch(
                                itemRef -> Inventory.contains(itemRef.getId()) || Equipment.contains(itemRef.getId()));
    }

    public static boolean isWearingSpecialAttackWeapon(SpecialAttack specialAttack) {
        return specialAttack != null
                && Arrays.stream(specialAttack.getItemRefs()).anyMatch(itemRef -> Equipment.contains(itemRef.getId()));
    }

    public static SpecialAttack findBestUsableSpecialAttack(Collection<SpecialAttack> specialAttacks) {
        if (specialAttacks == null) {
            return null;
        }
        return specialAttacks.stream()
                .filter(CombatHelper::canUseSpecialAttack)
                .findFirst()
                .orElse(null);
    }

    public static SpecialAttack findEquippedSpecialAttack(Collection<SpecialAttack> specialAttacks) {
        if (specialAttacks == null) {
            return null;
        }
        return specialAttacks.stream()
                .filter(CombatHelper::isWearingSpecialAttackWeapon)
                .findFirst()
                .orElse(null);
    }

    public static boolean equipSpecialAttackWeapon(SpecialAttack specialAttack) {
        if (specialAttack == null) {
            return false;
        }
        if (isWearingSpecialAttackWeapon(specialAttack)) {
            return true;
        }

        for (GenericItemRef itemRef : specialAttack.getItemRefs()) {
            if (!canEquipSpecialAttackWeaponWithCurrentInventory(itemRef)) {
                continue;
            }
            if (Inventory.contains(itemRef.getId()) && Inventory.interact(itemRef.getId(), "Wield")) {
                return Sleep.sleepUntil(() -> Equipment.contains(itemRef.getId()), 1_200);
            }
        }
        return false;
    }

    public static boolean canEquipSpecialAttackWeapon(SpecialAttack specialAttack) {
        if (specialAttack == null) {
            return false;
        }
        if (isWearingSpecialAttackWeapon(specialAttack)) {
            return true;
        }

        return Arrays.stream(specialAttack.getItemRefs())
                .anyMatch(itemRef -> Inventory.contains(itemRef.getId())
                        && canEquipSpecialAttackWeaponWithCurrentInventory(itemRef));
    }

    private static boolean canEquipSpecialAttackWeaponWithCurrentInventory(GenericItemRef itemRef) {
        if (!SpecialAttack.isTwoHanded(itemRef)) {
            return true;
        }

        return !Equipment.isSlotFull(EquipmentSlot.SHIELD) || Inventory.getEmptySlots() > 0;
    }

    public static boolean activateSpecialAttack() {
        if (Combat.isSpecialActive()) {
            return true;
        }
        return Combat.toggleSpecialAttack(true) && Sleep.sleepUntil(Combat::isSpecialActive, 800);
    }

    public static int getPrayerPercent() {
        int current = Skills.getBoostedLevel(Skill.PRAYER);
        int max = Skills.getRealLevel(Skill.PRAYER);
        return max <= 0 ? 100 : (current * 100) / max;
    }

    public static int getHealthPercent() {
        int current = Skills.getBoostedLevel(Skill.HITPOINTS);

        int max = Skills.getRealLevel(Skill.HITPOINTS);

        return max <= 0 ? 100 : (current * 100) / max;
    }

    public static void turnOffProtectionPrayers() {
        if (Prayers.isActive(Prayer.PROTECT_FROM_MELEE)) {
            Prayers.toggle(false, Prayer.PROTECT_FROM_MELEE);
        }

        if (Prayers.isActive(Prayer.PROTECT_FROM_MISSILES)) {
            Prayers.toggle(false, Prayer.PROTECT_FROM_MISSILES);
        }

        if (Prayers.isActive(Prayer.PROTECT_FROM_MAGIC)) {
            Prayers.toggle(false, Prayer.PROTECT_FROM_MAGIC);
        }
    }

    public static boolean isAlive(NPC npc) {
        return npc != null && npc.exists() && npc.getHealthPercent() > 0;
    }
}

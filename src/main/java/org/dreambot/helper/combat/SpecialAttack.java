package org.dreambot.helper.combat;

import static org.dreambot.api.methods.skills.Skill.AGILITY;
import static org.dreambot.api.methods.skills.Skill.ATTACK;
import static org.dreambot.api.methods.skills.Skill.COOKING;
import static org.dreambot.api.methods.skills.Skill.DEFENCE;
import static org.dreambot.api.methods.skills.Skill.FIREMAKING;
import static org.dreambot.api.methods.skills.Skill.FISHING;
import static org.dreambot.api.methods.skills.Skill.HITPOINTS;
import static org.dreambot.api.methods.skills.Skill.MAGIC;
import static org.dreambot.api.methods.skills.Skill.MINING;
import static org.dreambot.api.methods.skills.Skill.RANGED;
import static org.dreambot.api.methods.skills.Skill.SMITHING;
import static org.dreambot.api.methods.skills.Skill.STRENGTH;
import static org.dreambot.api.methods.skills.Skill.WOODCUTTING;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.BooleanSupplier;
import lombok.Getter;
import org.dreambot.api.methods.quest.Quests;
import org.dreambot.api.methods.quest.book.FreeQuest;
import org.dreambot.api.methods.quest.book.PaidQuest;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.methods.skills.Skills;
import org.dreambot.gamedata.items.ArmourItemRef;
import org.dreambot.gamedata.items.GenericItemRef;
import org.dreambot.gamedata.items.ToolItemRef;
import org.dreambot.gamedata.items.WeaponItemRef;

@Getter
public enum SpecialAttack {
    DRAGON_AXE(
            refs(ToolItemRef.DRAGON_AXE, ToolItemRef.DRAGON_FELLING_AXE),
            "Lumber Up",
            100,
            levels(ATTACK, 60, WOODCUTTING, 1)),
    INFERNAL_AXE(
            refs(
                    ToolItemRef.INFERNAL_AXE,
                    ToolItemRef.INFERNAL_AXE_OR,
                    ToolItemRef.INFERNAL_AXE_UNCHARGED,
                    ToolItemRef.INFERNAL_AXE_OR_UNCHARGED),
            "Lumber Up",
            100,
            levels(ATTACK, 60, WOODCUTTING, 61, FIREMAKING, 85)),
    THIRD_AGE_AXE(
            refs(ToolItemRef.THIRD_AGE_AXE, ToolItemRef.THIRD_AGE_FELLING_AXE),
            "Lumber Up",
            100,
            levels(ATTACK, 65, WOODCUTTING, 1)),
    CRYSTAL_AXE(
            refs(ToolItemRef.CRYSTAL_AXE, ToolItemRef.CRYSTAL_FELLING_AXE),
            "Lumber Up",
            100,
            levels(ATTACK, 70, WOODCUTTING, 71),
            finished(PaidQuest.SONG_OF_THE_ELVES)),
    DRAGON_HARPOON(ToolItemRef.DRAGON_HARPOON, "Fishstabber", 100, levels(ATTACK, 60, FISHING, 1)),
    INFERNAL_HARPOON(ToolItemRef.INFERNAL_HARPOON, "Fishstabber", 100, levels(ATTACK, 60, FISHING, 75, COOKING, 85)),
    CRYSTAL_HARPOON(
            ToolItemRef.CRYSTAL_HARPOON,
            "Fishstabber",
            100,
            levels(ATTACK, 70, FISHING, 71),
            finished(PaidQuest.SONG_OF_THE_ELVES)),
    DRAGON_PICKAXE(ToolItemRef.DRAGON_PICKAXE, "Rock Knocker", 100, levels(ATTACK, 60, MINING, 1)),
    INFERNAL_PICKAXE(ToolItemRef.INFERNAL_PICKAXE, "Rock Knocker", 100, levels(ATTACK, 60, MINING, 1, SMITHING, 85)),
    THIRD_AGE_PICKAXE(ToolItemRef.THIRD_AGE_PICKAXE, "Rock Knocker", 100, levels(ATTACK, 65, MINING, 1)),
    CRYSTAL_PICKAXE(
            ToolItemRef.CRYSTAL_PICKAXE,
            "Rock Knocker",
            100,
            levels(ATTACK, 70, MINING, 71),
            finished(PaidQuest.SONG_OF_THE_ELVES)),
    ANCIENT_GODSWORD(WeaponItemRef.ANCIENT_GODSWORD, "Blood Sacrifice", 50, levels(ATTACK, 75)),
    ELDRITCH_NIGHTMARE_STAFF(WeaponItemRef.ELDRITCH_NIGHTMARE_STAFF, "Invocate", 55, levels(MAGIC, 75, HITPOINTS, 50)),
    KERIS_PARTISAN_OF_THE_SUN(
            WeaponItemRef.KERIS_PARTISAN_OF_THE_SUN,
            "Tumeken's Light",
            75,
            levels(ATTACK, 80),
            finished(PaidQuest.BENEATH_CURSED_SANDS),
            "Tombs of Amascut only"),
    PURGING_STAFF(
            WeaponItemRef.PURGING_STAFF,
            "Scatter ashes",
            25,
            levels(MAGIC, 77),
            finished(PaidQuest.WHILE_GUTHIX_SLEEPS),
            "Requires the Arceuus spellbook and a demonic target"),
    TOXIC_BLOWPIPE(WeaponItemRef.TOXIC_BLOWPIPE, "Toxic Siphon", 50, levels(RANGED, 75)),
    SARADOMIN_GODSWORD(WeaponItemRef.SARADOMIN_GODSWORD, "Healing Blade", 50, levels(ATTACK, 75)),
    BRINE_SABRE(WeaponItemRef.BRINE_SABRE, "Liquify", 75, levels(ATTACK, 40), always(), "Underwater only"),
    DRAGON_BATTLEAXE(
            WeaponItemRef.DRAGON_BATTLEAXE, "Rampage", 100, levels(ATTACK, 60), finished(PaidQuest.HEROES_QUEST)),
    EXCALIBUR(WeaponItemRef.EXCALIBUR, "Sanctuary", 100, levels(ATTACK, 20), finished(PaidQuest.MERLINS_CRYSTAL)),
    DINHS_BULWARK(WeaponItemRef.DINHS_BULWARK, "Shield Bash", 50, levels(ATTACK, 75, DEFENCE, 75)),
    DRAGON_CROSSBOW(WeaponItemRef.DRAGON_CROSSBOW, "Annihilate", 60, levels(RANGED, 64)),
    DRAGON_HALBERD(
            WeaponItemRef.DRAGON_HALBERD,
            "Sweep",
            30,
            levels(ATTACK, 60, STRENGTH, 30, AGILITY, 56),
            finished(PaidQuest.REGICIDE)),
    CRYSTAL_HALBERD(
            refs(WeaponItemRef.CRYSTAL_HALBERD, WeaponItemRef.CRYSTAL_HALBERD_NEW),
            "Sweep",
            30,
            levels(ATTACK, 70, STRENGTH, 35, AGILITY, 56),
            finished(PaidQuest.REGICIDE),
            "Requires Western Provinces hard diary"),
    DRAGON_2H_SWORD(WeaponItemRef.DRAGON_2H_SWORD, "Powerstab", 60, levels(ATTACK, 60)),
    RUNE_THROWNAXE(WeaponItemRef.RUNE_THROWNAXE, "Chainhit", 10, 50, levels(RANGED, 40)),
    VESTAS_SPEAR_DEADMAN(
            WeaponItemRef.VESTAS_SPEAR, "Spear Wall", 50, levels(ATTACK, 78), always(), "Deadman Mode only"),
    ABYSSAL_WHIP(WeaponItemRef.ABYSSAL_WHIP, "Energy Drain", 50, levels(ATTACK, 70)),
    ACCURSED_SCEPTRE(WeaponItemRef.ACCURSED_SCEPTRE_CHARGED.getSimilarItems(), "Condemn", 50, levels(MAGIC, 70)),
    ANCIENT_MACE(
            WeaponItemRef.ANCIENT_MACE,
            "Favour of the War God",
            100,
            levels(ATTACK, 15),
            finished(PaidQuest.ANOTHER_SLICE_OF_HAM)),
    BANDOS_GODSWORD(WeaponItemRef.BANDOS_GODSWORD, "Warstrike", 50, levels(ATTACK, 75)),
    BARRELCHEST_ANCHOR(
            WeaponItemRef.BARRELCHEST_ANCHOR,
            "Sunder",
            50,
            levels(ATTACK, 60, STRENGTH, 40),
            finished(PaidQuest.THE_GREAT_BRAIN_ROBBERY)),
    BONE_DAGGER(
            WeaponItemRef.BONE_DAGGER.getSimilarItems(),
            "Backstab",
            75,
            levels(ATTACK, 1),
            finished(PaidQuest.THE_LOST_TRIBE)),
    DARKLIGHT(WeaponItemRef.DARKLIGHT, "Weaken", 50, levels(ATTACK, 1), finished(PaidQuest.SHADOW_OF_THE_STORM)),
    ARCLIGHT(WeaponItemRef.ARCLIGHT, "Weaken", 50, levels(ATTACK, 75), finished(PaidQuest.SHADOW_OF_THE_STORM)),
    EMBERLIGHT(WeaponItemRef.EMBERLIGHT, "Weaken", 50, levels(ATTACK, 77), finished(PaidQuest.WHILE_GUTHIX_SLEEPS)),
    DORGESHUUN_CROSSBOW(
            WeaponItemRef.DORGESHUUN_CROSSBOW,
            "Snipe",
            75,
            levels(RANGED, 28),
            finished(PaidQuest.DEATH_TO_THE_DORGESHUUN)),
    DRAGON_SCIMITAR(
            WeaponItemRef.DRAGON_SCIMITAR, "Sever", 55, levels(ATTACK, 60), finished(PaidQuest.MONKEY_MADNESS_I)),
    DRAGON_WARHAMMER(WeaponItemRef.DRAGON_WARHAMMER, "Smash", 50, levels(ATTACK, 1, STRENGTH, 60)),
    STATIUSS_WARHAMMER(WeaponItemRef.STATIUSS_WARHAMMER, "Smash", 35, levels(ATTACK, 1, STRENGTH, 75)),
    ELDER_MAUL(WeaponItemRef.ELDER_MAUL, "Pulverize", 50, levels(ATTACK, 75, STRENGTH, 75)),
    EYE_OF_AYAK(WeaponItemRef.EYE_OF_AYAK, "Soul Rend", 50, levels(MAGIC, 83)),
    MORRIGANS_THROWING_AXE(WeaponItemRef.MORRIGANS_THROWING_AXE, "Hamstring", 50, levels(RANGED, 78)),
    SEERCULL(WeaponItemRef.SEERCULL, "Soulshot", 100, levels(RANGED, 50)),
    STAFF_OF_THE_DEAD(
            refs(
                    WeaponItemRef.STAFF_OF_THE_DEAD,
                    WeaponItemRef.TOXIC_STAFF_OF_THE_DEAD_CHARGED,
                    WeaponItemRef.STAFF_OF_LIGHT,
                    WeaponItemRef.STAFF_OF_BALANCE),
            "Power of Death",
            100,
            levels(ATTACK, 75, MAGIC, 75)),
    TONALZTICS_OF_RALOS(WeaponItemRef.TONALZTICS_OF_RALOS, "Division", 50, levels(RANGED, 75)),
    ABYSSAL_BLUDGEON(WeaponItemRef.ABYSSAL_BLUDGEON, "Penance", 50, levels(ATTACK, 70, STRENGTH, 70)),
    ARMADYL_CROSSBOW(WeaponItemRef.ARMADYL_CROSSBOW, "Armadyl Eye", 50, levels(RANGED, 75)),
    ARKAN_BLADE(WeaponItemRef.ARKAN_BLADE, "Flames of Ralos", 30, levels(ATTACK, 60)),
    ARMADYL_GODSWORD(WeaponItemRef.ARMADYL_GODSWORD, "The Judgement", 50, levels(ATTACK, 75)),
    BLUE_MOON_SPEAR(
            WeaponItemRef.BLUE_MOON_SPEAR,
            "Break Shackles",
            50,
            levels(ATTACK, 70, MAGIC, 75),
            always(),
            "Requires full blue moon armour and a bound target"),
    DAWNBRINGER(
            WeaponItemRef.DAWNBRINGER,
            "Pulsate",
            35,
            levels(),
            finished(PaidQuest.PRIEST_IN_PERIL),
            "Theatre of Blood only"),
    DRAGON_HASTA(WeaponItemRef.DRAGON_HASTA.getSimilarItems(), "Unleash", 5, 100, levels(ATTACK, 60)),
    DRAGON_LONGSWORD(WeaponItemRef.DRAGON_LONGSWORD, "Cleave", 25, levels(ATTACK, 60), finished(PaidQuest.LOST_CITY)),
    DRAGON_MACE(WeaponItemRef.DRAGON_MACE, "Shatter", 25, levels(ATTACK, 60), finished(PaidQuest.HEROES_QUEST)),
    DRAGON_SWORD(WeaponItemRef.DRAGON_SWORD, "Wild Stab", 40, levels(ATTACK, 60)),
    DRAGON_THROWNAXE(WeaponItemRef.DRAGON_THROWNAXE, "Momentum Throw", 25, levels(RANGED, 61)),
    DUAL_MACUAHUITL(
            WeaponItemRef.DUAL_MACUAHUITL,
            "Blood Infusion",
            25,
            levels(ATTACK, 70, STRENGTH, 75),
            always(),
            "Requires full blood moon armour"),
    ECLIPSE_ATLATL(
            WeaponItemRef.ECLIPSE_ATLATL,
            "Eclipse",
            50,
            levels(ATTACK, 50, STRENGTH, 50, RANGED, 75),
            always(),
            "Requires full eclipse moon armour and melee distance"),
    GRANITE_HAMMER(WeaponItemRef.GRANITE_HAMMER, "Hammer Blow", 60, levels(ATTACK, 50, STRENGTH, 50)),
    KERIS_PARTISAN_OF_CORRUPTION(
            WeaponItemRef.KERIS_PARTISAN_OF_CORRUPTION,
            "Wrath of Amascut",
            75,
            levels(ATTACK, 80),
            finished(PaidQuest.BENEATH_CURSED_SANDS),
            "Tombs of Amascut only"),
    LIGHT_BALLISTA(WeaponItemRef.LIGHT_BALLISTA, "Concentrated Shot", 65, levels(RANGED, 67)),
    HEAVY_BALLISTA(
            WeaponItemRef.HEAVY_BALLISTA,
            "Concentrated Shot",
            65,
            levels(RANGED, 75),
            finished(PaidQuest.MONKEY_MADNESS_II)),
    MAGIC_LONGBOW(refs(WeaponItemRef.MAGIC_LONGBOW, WeaponItemRef.MAGIC_COMP_BOW), "Powershot", 35, levels(RANGED, 50)),
    MORRIGANS_JAVELIN(WeaponItemRef.MORRIGANS_JAVELIN, "Phantom Strike", 50, levels(RANGED, 78)),
    NOXIOUS_HALBERD(WeaponItemRef.NOXIOUS_HALBERD, "Virulence", 50, levels(ATTACK, 80)),
    OSMUMTENS_FANG(WeaponItemRef.OSMUMTENS_FANG, "Eviscerate", 25, levels(ATTACK, 82)),
    RUNE_CLAWS(WeaponItemRef.RUNE_CLAWS, "Impale", 25, levels(ATTACK, 40)),
    SARADOMINS_BLESSED_SWORD(
            WeaponItemRef.SARADOMINS_BLESSED_SWORD, "Saradomin's Blessed Lightning", 65, levels(ATTACK, 75)),
    SOULFLAME_HORN(WeaponItemRef.SOULFLAME_HORN, "Entice", 25, levels(MAGIC, 80)),
    VESTAS_LONGSWORD(WeaponItemRef.VESTAS_LONGSWORD, "Feint", 25, levels(ATTACK, 75)),
    VESTAS_BLIGHTED_LONGSWORD(WeaponItemRef.VESTAS_BLIGHTED_LONGSWORD, "Feint", 25, levels(ATTACK, 78)),
    VOIDWAKER(WeaponItemRef.VOIDWAKER, "Disrupt", 50, levels(ATTACK, 75)),
    VOLATILE_NIGHTMARE_STAFF(WeaponItemRef.VOLATILE_NIGHTMARE_STAFF, "Immolate", 55, levels(MAGIC, 82, HITPOINTS, 50)),
    ZARYTE_CROSSBOW(WeaponItemRef.ZARYTE_CROSSBOW, "Evoke", 75, levels(RANGED, 80)),
    ABYSSAL_DAGGER(WeaponItemRef.ABYSSAL_DAGGER.getSimilarItems(), "Abyssal Puncture", 25, levels(ATTACK, 70)),
    BURNING_CLAWS(WeaponItemRef.BURNING_CLAWS, "Burning barrage", 30, levels(ATTACK, 60)),
    DARK_BOW(WeaponItemRef.DARK_BOW, "Descent of Darkness", 55, levels(RANGED, 60)),
    DRAGON_CLAWS(WeaponItemRef.DRAGON_CLAWS, "Slice and Dice", 50, levels(ATTACK, 60)),
    DRAGON_DAGGER(
            WeaponItemRef.DRAGON_DAGGER.getSimilarItems(),
            "Puncture",
            25,
            levels(ATTACK, 60),
            finished(PaidQuest.LOST_CITY)),
    DRAGON_KNIFE(WeaponItemRef.DRAGON_KNIFE.getSimilarItems(), "Duality", 25, levels(RANGED, 60)),
    GRANITE_MAUL(WeaponItemRef.GRANITE_MAUL, "Quick Smash", 60, levels(ATTACK, 50, STRENGTH, 50)),
    GRANITE_MAUL_ORNATE(
            WeaponItemRef.GRANITE_MAUL_ORNATE.getSimilarItems(), "Quick Smash", 50, levels(ATTACK, 50, STRENGTH, 50)),
    ROSEWOOD_BLOWPIPE(WeaponItemRef.ROSEWOOD_BLOWPIPE, "Rapid Burst", 25, levels(RANGED, 65)),
    MAGIC_SHORTBOW(WeaponItemRef.MAGIC_SHORTBOW, "Snapshot", 55, levels(RANGED, 50)),
    MAGIC_SHORTBOW_IMBUED(WeaponItemRef.MAGIC_SHORTBOW_I, "Snapshot", 50, levels(RANGED, 50)),
    SARADOMIN_SWORD(WeaponItemRef.SARADOMIN_SWORD, "Saradomin's Lightning", 100, levels(ATTACK, 70)),
    VESTAS_SPEAR_BOUNTY_HUNTER(
            WeaponItemRef.VESTAS_SPEAR_BH, "Spear Wall", 50, levels(ATTACK, 78), always(), "Bounty Hunter only"),
    WEBWEAVER_BOW(WeaponItemRef.WEBWEAVER_BOW, "Swarm", 50, levels(RANGED, 70)),
    ABYSSAL_TENTACLE(WeaponItemRef.ABYSSAL_TENTACLE, "Binding Tentacle", 50, levels(ATTACK, 75)),
    DRAGON_SPEAR(WeaponItemRef.DRAGON_SPEAR.getSimilarItems(), "Shove", 25, levels(ATTACK, 60)),
    ZAMORAKIAN_HASTA(WeaponItemRef.ZAMORAKIAN_HASTA, "Shove", 25, levels(ATTACK, 70)),
    ZAMORAKIAN_SPEAR(WeaponItemRef.ZAMORAKIAN_SPEAR, "Shove", 25, levels(ATTACK, 70)),
    ROD_OF_IVANDIS(
            WeaponItemRef.ROD_OF_IVANDIS_1.getSimilarItems(),
            "Retainer",
            10,
            levels(ATTACK, 1),
            finished(PaidQuest.IN_AID_OF_THE_MYREQUE)),
    IVANDIS_FLAIL(WeaponItemRef.IVANDIS_FLAIL, "Retainer", 10, levels(ATTACK, 40), finished(PaidQuest.A_TASTE_OF_HOPE)),
    BLISTERWOOD_FLAIL(
            WeaponItemRef.BLISTERWOOD_FLAIL,
            "Retainer",
            10,
            levels(ATTACK, 50),
            finished(PaidQuest.SINS_OF_THE_FATHER)),
    SCORCHING_BOW(
            WeaponItemRef.SCORCHING_BOW,
            "Scorching shackles",
            25,
            levels(RANGED, 77),
            finished(PaidQuest.WHILE_GUTHIX_SLEEPS)),
    URSINE_CHAINMACE(WeaponItemRef.URSINE_CHAINMACE, "Bear Down", 50, levels(ATTACK, 70)),
    ZAMORAK_GODSWORD(WeaponItemRef.ZAMORAK_GODSWORD, "Ice Cleave", 50, levels(ATTACK, 75)),
    ANCIENT_WYVERN_SHIELD(
            ArmourItemRef.ANCIENT_WYVERN_SHIELD_CHARGED.getSimilarItems(),
            "None",
            0,
            levels(MAGIC, 70, DEFENCE, 75),
            started(),
            "Operates on a two-minute cooldown instead of using special attack energy"),
    DRAGONFIRE_SHIELD(
            ArmourItemRef.DRAGONFIRE_SHIELD_CHARGED.getSimilarItems(),
            "None",
            0,
            levels(DEFENCE, 75),
            started(),
            "Operates on a two-minute cooldown instead of using special attack energy"),
    DRAGONFIRE_WARD(
            ArmourItemRef.DRAGONFIRE_WARD_CHARGED.getSimilarItems(),
            "None",
            0,
            levels(RANGED, 70, DEFENCE, 75),
            started(),
            "Operates on a two-minute cooldown instead of using special attack energy"),
    SOULREAPER_AXE(
            WeaponItemRef.SOULREAPER_AXE,
            "Behead",
            0,
            levels(ATTACK, 80, STRENGTH, 80),
            always(),
            "Consumes Soul Stacks instead of special attack energy");

    private final GenericItemRef[] itemRefs;
    private final String specialAttackName;
    private final int energyUsed;
    private final int maximumEnergyUsed;
    private final Map<Skill, Integer> skillRequirements;
    private final BooleanSupplier requirements;
    private final String restriction;

    SpecialAttack(
            GenericItemRef itemRef, String specialAttackName, int energyUsed, Map<Skill, Integer> skillRequirements) {
        this(refs(itemRef), specialAttackName, energyUsed, energyUsed, skillRequirements, always(), "");
    }

    SpecialAttack(
            GenericItemRef[] itemRefs,
            String specialAttackName,
            int energyUsed,
            Map<Skill, Integer> skillRequirements) {
        this(itemRefs, specialAttackName, energyUsed, energyUsed, skillRequirements, always(), "");
    }

    SpecialAttack(
            GenericItemRef itemRef,
            String specialAttackName,
            int energyUsed,
            Map<Skill, Integer> skillRequirements,
            BooleanSupplier requirements) {
        this(refs(itemRef), specialAttackName, energyUsed, energyUsed, skillRequirements, requirements, "");
    }

    SpecialAttack(
            GenericItemRef[] itemRefs,
            String specialAttackName,
            int energyUsed,
            Map<Skill, Integer> skillRequirements,
            BooleanSupplier requirements) {
        this(itemRefs, specialAttackName, energyUsed, energyUsed, skillRequirements, requirements, "");
    }

    SpecialAttack(
            GenericItemRef itemRef,
            String specialAttackName,
            int energyUsed,
            int maximumEnergyUsed,
            Map<Skill, Integer> skillRequirements) {
        this(refs(itemRef), specialAttackName, energyUsed, maximumEnergyUsed, skillRequirements, always(), "");
    }

    SpecialAttack(
            GenericItemRef[] itemRefs,
            String specialAttackName,
            int energyUsed,
            int maximumEnergyUsed,
            Map<Skill, Integer> skillRequirements) {
        this(itemRefs, specialAttackName, energyUsed, maximumEnergyUsed, skillRequirements, always(), "");
    }

    SpecialAttack(
            GenericItemRef itemRef,
            String specialAttackName,
            int energyUsed,
            Map<Skill, Integer> skillRequirements,
            BooleanSupplier requirements,
            String restriction) {
        this(refs(itemRef), specialAttackName, energyUsed, energyUsed, skillRequirements, requirements, restriction);
    }

    SpecialAttack(
            GenericItemRef[] itemRefs,
            String specialAttackName,
            int energyUsed,
            Map<Skill, Integer> skillRequirements,
            BooleanSupplier requirements,
            String restriction) {
        this(itemRefs, specialAttackName, energyUsed, energyUsed, skillRequirements, requirements, restriction);
    }

    SpecialAttack(
            GenericItemRef[] itemRefs,
            String specialAttackName,
            int energyUsed,
            int maximumEnergyUsed,
            Map<Skill, Integer> skillRequirements,
            BooleanSupplier requirements,
            String restriction) {
        this.itemRefs = itemRefs.clone();
        this.specialAttackName = specialAttackName;
        this.energyUsed = energyUsed;
        this.maximumEnergyUsed = maximumEnergyUsed;
        this.skillRequirements = skillRequirements;
        this.requirements = requirements;
        this.restriction = restriction;
    }

    public GenericItemRef[] getItemRefs() {
        return itemRefs.clone();
    }

    public GenericItemRef getItemRef() {
        return itemRefs.length == 0 ? null : itemRefs[0];
    }

    public int getAttackLevelRequirement() {
        return skillRequirements.getOrDefault(ATTACK, 0);
    }

    public boolean isTwoHanded() {
        return Arrays.stream(itemRefs).anyMatch(SpecialAttack::isTwoHanded);
    }

    public static boolean isTwoHanded(GenericItemRef itemRef) {
        return WeaponItemRef.isTwoHanded(itemRef);
    }

    public boolean usesSpecialAttackEnergy() {
        return maximumEnergyUsed > 0;
    }

    public boolean hasVariableEnergyCost() {
        return energyUsed != maximumEnergyUsed;
    }

    public int[] getItemIds() {
        return Arrays.stream(itemRefs).mapToInt(GenericItemRef::getId).toArray();
    }

    public boolean matchesItemId(int itemId) {
        return Arrays.stream(itemRefs).anyMatch(itemRef -> itemRef.getId() == itemId);
    }

    public boolean meetsRequirements() {
        return requirements.getAsBoolean()
                && skillRequirements.entrySet().stream()
                        .allMatch(entry -> Skills.getRealLevel(entry.getKey()) >= entry.getValue());
    }

    private static BooleanSupplier always() {
        return () -> true;
    }

    private static BooleanSupplier finished(PaidQuest quest) {
        return () -> Quests.isFinished(quest);
    }

    private static BooleanSupplier started() {
        return () -> Quests.isStarted(FreeQuest.DRAGON_SLAYER_I) || Quests.isFinished(FreeQuest.DRAGON_SLAYER_I);
    }

    private static Map<Skill, Integer> levels(Object... values) {
        EnumMap<Skill, Integer> requirements = new EnumMap<>(Skill.class);

        for (int index = 0; index < values.length; index += 2) {
            requirements.put((Skill) values[index], (Integer) values[index + 1]);
        }

        return Collections.unmodifiableMap(requirements);
    }

    private static GenericItemRef[] refs(GenericItemRef... itemRefs) {
        return itemRefs;
    }
}

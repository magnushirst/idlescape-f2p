package com.idlescape.gamedata.items.equipment;

import static org.dreambot.api.methods.skills.Skill.DEFENCE;
import static org.dreambot.api.methods.skills.Skill.MAGIC;
import static org.dreambot.api.methods.skills.Skill.PRAYER;
import static org.dreambot.api.methods.skills.Skill.RANGED;
import static org.dreambot.api.methods.skills.Skill.SLAYER;
import static org.dreambot.api.methods.skills.Skill.STRENGTH;

import com.idlescape.framework.requirements.Requirement;
import com.idlescape.framework.requirements.RequirementBuilder;
import com.idlescape.gamedata.combat.AttackBonus;
import com.idlescape.gamedata.combat.DefenceBonus;
import com.idlescape.gamedata.combat.SkillsBonus;
import com.idlescape.gamedata.items.ArmourItemRef;
import com.idlescape.gamedata.items.GenericItemRef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.quest.book.MiniQuest;
import org.dreambot.api.methods.quest.book.PaidQuest;

@Getter
@AllArgsConstructor
public enum FeetSlotRef implements EquipmentRef {
    ADAMANT_BOOTS(
            ArmourItemRef.ADAMANT_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(10, 11, 12, 0, 0),
            new SkillsBonus(1, 0, 0, 0),
            1.36,
            ArmourItemRef.ADAMANT_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    ANCIENT_CEREMONIAL_BOOTS(
            ArmourItemRef.ANCIENT_CEREMONIAL_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 1),
            0.3,
            ArmourItemRef.ANCIENT_CEREMONIAL_BOOTS.getSimilarItems()),
    ANCIENT_DHIDE_BOOTS(
            ArmourItemRef.ANCIENT_DHIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 7),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 1),
            1.4,
            ArmourItemRef.ANCIENT_DHIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    ARANEA_BOOTS(
            ArmourItemRef.ARANEA_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 5, 6),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(4, 0, 0, 1),
            1.0,
            ArmourItemRef.ARANEA_BOOTS.getSimilarItems()),
    ARMADYL_DHIDE_BOOTS(
            ArmourItemRef.ARMADYL_DHIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 7),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 1),
            1.4,
            ArmourItemRef.ARMADYL_DHIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    AVERNIC_TREADS(
            ArmourItemRef.AVERNIC_TREADS,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(4, 2, 1, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_ET(
            ArmourItemRef.AVERNIC_TREADS_ET,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(4, 2, 2, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_ET.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_MAX(
            ArmourItemRef.AVERNIC_TREADS_MAX,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(6, 3, 2, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_MAX.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_PE(
            ArmourItemRef.AVERNIC_TREADS_PE,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(4, 3, 1, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_PE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_PE_ET(
            ArmourItemRef.AVERNIC_TREADS_PE_ET,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(4, 3, 2, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_PE_ET.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_PR(
            ArmourItemRef.AVERNIC_TREADS_PR,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(6, 2, 1, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_PR.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_PR_ET(
            ArmourItemRef.AVERNIC_TREADS_PR_ET,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(6, 2, 2, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_PR_ET.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    AVERNIC_TREADS_PR_PE(
            ArmourItemRef.AVERNIC_TREADS_PR_PE,
            true,
            new AttackBonus(5, 5, 5, 11, 15),
            new DefenceBonus(21, 25, 25, 10, 10),
            new SkillsBonus(6, 3, 1, 0),
            1.814,
            ArmourItemRef.AVERNIC_TREADS_PR_PE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 80)
                    .hasLevel(STRENGTH, 80)
                    .hasLevel(RANGED, 80)
                    .hasLevel(MAGIC, 80)
                    .build()),
    BANDOS_BOOTS(
            ArmourItemRef.BANDOS_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -5, -3),
            new DefenceBonus(17, 18, 19, 0, 15),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.BANDOS_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 65).build()),
    BANDOS_DHIDE_BOOTS(
            ArmourItemRef.BANDOS_DHIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 7),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 1),
            1.4,
            ArmourItemRef.BANDOS_DHIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    BLACK_BOOTS(
            ArmourItemRef.BLACK_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 9, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.BLACK_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    BLOODBARK_BOOTS(
            ArmourItemRef.BLOODBARK_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(5, 4, 6, 5, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.BLOODBARK_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 60).hasLevel(DEFENCE, 60).build()),
    BLUE_BOOTS(
            ArmourItemRef.BLUE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.BLUE_BOOTS.getSimilarItems()),
    BOOTS_OF_BRIMSTONE(
            ArmourItemRef.BOOTS_OF_BRIMSTONE,
            true,
            new AttackBonus(3, 0, 0, 3, 5),
            new DefenceBonus(10, 10, 10, 5, 5),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.BOOTS_OF_BRIMSTONE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .hasLevel(DEFENCE, 70)
                    .hasLevel(SLAYER, 44)
                    .hasLevel(MAGIC, 70)
                    .build()),
    BOOTS_OF_DARKNESS(
            ArmourItemRef.BOOTS_OF_DARKNESS,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.BOOTS_OF_DARKNESS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 20).build()),
    BOOTS_OF_LIGHTNESS_WORN(
            ArmourItemRef.BOOTS_OF_LIGHTNESS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(1, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.535,
            ArmourItemRef.BOOTS_OF_LIGHTNESS_WORN.getSimilarItems()),
    BOOTS_OF_STONE(
            ArmourItemRef.BOOTS_OF_STONE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(1, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.BOOTS_OF_STONE.getSimilarItems(),
            new RequirementBuilder().hasLevel(SLAYER, 44).build()),
    BRONZE_BOOTS(
            ArmourItemRef.BRONZE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(1, 2, 3, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.BRONZE_BOOTS.getSimilarItems()),
    CITIZEN_SHOES(
            ArmourItemRef.CITIZEN_SHOES,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.CITIZEN_SHOES.getSimilarItems()),
    CLIMBING_BOOTS(
            ArmourItemRef.CLIMBING_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(2, 0, 0, 0),
            0.34,
            ArmourItemRef.CLIMBING_BOOTS.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.DEATH_PLATEAU).build()),
    CREAM_BOOTS(
            ArmourItemRef.CREAM_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.CREAM_BOOTS.getSimilarItems()),
    DARK_FLIPPERS(
            ArmourItemRef.DARK_FLIPPERS,
            true,
            new AttackBonus(-2, -2, -2, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.DARK_FLIPPERS.getSimilarItems()),
    DECORATIVE_BOOTS_GOLD(
            ArmourItemRef.DECORATIVE_BOOTS_GOLD,
            false,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(10, 11, 12, 0, 0),
            new SkillsBonus(1, 0, 0, 0),
            1.36,
            ArmourItemRef.DECORATIVE_BOOTS_GOLD.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    DECORATIVE_BOOTS_RED(
            ArmourItemRef.DECORATIVE_BOOTS_RED,
            false,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(5, 6, 7, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.DECORATIVE_BOOTS_RED.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    DECORATIVE_BOOTS_WHITE(
            ArmourItemRef.DECORATIVE_BOOTS_WHITE,
            false,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(8, 9, 10, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.DECORATIVE_BOOTS_WHITE.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    DEVOUT_BOOTS(
            ArmourItemRef.DEVOUT_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.5,
            ArmourItemRef.DEVOUT_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 60).build()),
    DRAGON_BOOTS(
            ArmourItemRef.DRAGON_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(16, 17, 18, 0, 0),
            new SkillsBonus(4, 0, 0, 0),
            1.0,
            ArmourItemRef.DRAGON_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 60).build()),
    DRAGON_BOOTS_G(
            ArmourItemRef.DRAGON_BOOTS_G,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(16, 17, 18, 0, 0),
            new SkillsBonus(4, 0, 0, 0),
            1.0,
            ArmourItemRef.DRAGON_BOOTS_G.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 60).build()),
    DRAGONSTONE_BOOTS(
            ArmourItemRef.DRAGONSTONE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(12, 13, 14, 0, 0),
            new SkillsBonus(2, 0, 0, 0),
            1.36,
            ArmourItemRef.DRAGONSTONE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    ECHO_BOOTS(
            ArmourItemRef.ECHO_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(32, 32, 32, -3, 24),
            new SkillsBonus(3, 0, 0, 4),
            7.0,
            ArmourItemRef.ECHO_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 75).build()),
    ETERNAL_BOOTS(
            ArmourItemRef.ETERNAL_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 8, 0),
            new DefenceBonus(5, 5, 5, 8, 5),
            new SkillsBonus(0, 0, 1, 0),
            1.814,
            ArmourItemRef.ETERNAL_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 75).hasLevel(DEFENCE, 75).build()),
    FANCIER_BOOTS(
            ArmourItemRef.FANCIER_BOOTS,
            false,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(1, 2, 3, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.FANCIER_BOOTS.getSimilarItems()),
    FANCY_BOOTS(
            ArmourItemRef.FANCY_BOOTS,
            false,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(1, 2, 3, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.FANCY_BOOTS.getSimilarItems()),
    FIGHTING_BOOTS(
            ArmourItemRef.FIGHTING_BOOTS,
            false,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(1, 2, 3, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.FIGHTING_BOOTS.getSimilarItems()),
    FLIPPERS(
            ArmourItemRef.FLIPPERS,
            true,
            new AttackBonus(-2, -2, -2, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.FLIPPERS.getSimilarItems()),
    FREMENNIK_BOOTS(
            ArmourItemRef.FREMENNIK_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.FREMENNIK_BOOTS.getSimilarItems()),
    FREMENNIK_SEA_BOOTS_1(
            ArmourItemRef.FREMENNIK_SEA_BOOTS_1,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(2, 3, 4, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.4,
            ArmourItemRef.FREMENNIK_SEA_BOOTS_1.getSimilarItems()),
    FREMENNIK_SEA_BOOTS_2(
            ArmourItemRef.FREMENNIK_SEA_BOOTS_2,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(5, 6, 7, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.4,
            ArmourItemRef.FREMENNIK_SEA_BOOTS_2.getSimilarItems()),
    FREMENNIK_SEA_BOOTS_3(
            ArmourItemRef.FREMENNIK_SEA_BOOTS_3,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 9, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.4,
            ArmourItemRef.FREMENNIK_SEA_BOOTS_3.getSimilarItems()),
    FREMENNIK_SEA_BOOTS_4(
            ArmourItemRef.FREMENNIK_SEA_BOOTS_4,
            true,
            new AttackBonus(0, 0, 0, 1, 1),
            new DefenceBonus(10, 11, 12, 0, 0),
            new SkillsBonus(1, 0, 0, 0),
            0.4,
            ArmourItemRef.FREMENNIK_SEA_BOOTS_4.getSimilarItems()),
    FROG_SLIPPERS(
            ArmourItemRef.FROG_SLIPPERS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.2,
            ArmourItemRef.FROG_SLIPPERS.getSimilarItems()),
    FROG_LEATHER_BOOTS(
            ArmourItemRef.FROG_LEATHER_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -8, 2),
            new DefenceBonus(1, 1, 1, 0, 1),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.FROG_LEATHER_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 25).hasLevel(DEFENCE, 25).build()),
    GHOSTLY_BOOTS(
            ArmourItemRef.GHOSTLY_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 2, 0),
            new DefenceBonus(0, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.001,
            ArmourItemRef.GHOSTLY_BOOTS.getSimilarItems(),
            new RequirementBuilder().started(MiniQuest.CURSE_OF_THE_EMPTY_LORD).build()),
    GILDED_BOOTS(
            ArmourItemRef.GILDED_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(12, 13, 14, 0, 0),
            new SkillsBonus(2, 0, 0, 0),
            1.36,
            ArmourItemRef.GILDED_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    GRACEFUL_BOOTS_ADVENTURER(
            ArmourItemRef.GRACEFUL_BOOTS_ADVENTURER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_ADVENTURER.getSimilarItems()),
    GRACEFUL_BOOTS_AGILITY_ARENA(
            ArmourItemRef.GRACEFUL_BOOTS_AGILITY_ARENA,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_AGILITY_ARENA.getSimilarItems()),
    GRACEFUL_BOOTS_ARCEUUS_WORN(
            ArmourItemRef.GRACEFUL_BOOTS_ARCEUUS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_ARCEUUS_WORN.getSimilarItems()),
    GRACEFUL_BOOTS_HALLOWED(
            ArmourItemRef.GRACEFUL_BOOTS_HALLOWED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_HALLOWED.getSimilarItems()),
    GRACEFUL_BOOTS_HOSIDIUS_WORN(
            ArmourItemRef.GRACEFUL_BOOTS_HOSIDIUS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_HOSIDIUS_WORN.getSimilarItems()),
    GRACEFUL_BOOTS_KOUREND_WORN(
            ArmourItemRef.GRACEFUL_BOOTS_KOUREND_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_KOUREND_WORN.getSimilarItems()),
    GRACEFUL_BOOTS_LOVAKENGJ_WORN(
            ArmourItemRef.GRACEFUL_BOOTS_LOVAKENGJ_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_LOVAKENGJ_WORN.getSimilarItems()),
    GRACEFUL_BOOTS_PISCARILIUS(
            ArmourItemRef.GRACEFUL_BOOTS_PISCARILIUS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_PISCARILIUS.getSimilarItems()),
    GRACEFUL_BOOTS_SHAYZIEN_WORN(
            ArmourItemRef.GRACEFUL_BOOTS_SHAYZIEN_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_SHAYZIEN_WORN.getSimilarItems()),
    GRACEFUL_BOOTS_TRAILBLAZER(
            ArmourItemRef.GRACEFUL_BOOTS_TRAILBLAZER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_TRAILBLAZER.getSimilarItems()),
    GRACEFUL_BOOTS_VARLAMORE_WORN(
            ArmourItemRef.GRACEFUL_BOOTS_VARLAMORE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_VARLAMORE_WORN.getSimilarItems()),
    GRACEFUL_BOOTS_EQUIPPED(
            ArmourItemRef.GRACEFUL_BOOTS_EQUIPPED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_BOOTS_EQUIPPED.getSimilarItems()),
    GRANITE_BOOTS(
            ArmourItemRef.GRANITE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(15, 16, 17, 0, 8),
            new SkillsBonus(3, 0, 0, 0),
            2.721,
            ArmourItemRef.GRANITE_BOOTS.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 50)
                    .hasLevel(STRENGTH, 50)
                    .build()),
    GREEN_BOOTS(
            ArmourItemRef.GREEN_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.GREEN_BOOTS.getSimilarItems()),
    GREY_BOOTS(
            ArmourItemRef.GREY_BOOTS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.GREY_BOOTS.getSimilarItems()),
    GUARDIAN_BOOTS(
            ArmourItemRef.GUARDIAN_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(32, 32, 32, -3, 24),
            new SkillsBonus(3, 0, 0, 2),
            7.0,
            ArmourItemRef.GUARDIAN_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 75).build()),
    GUTHIX_DHIDE_BOOTS(
            ArmourItemRef.GUTHIX_DHIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 7),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 1),
            1.4,
            ArmourItemRef.GUTHIX_DHIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    HAM_BOOTS(
            ArmourItemRef.HAM_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.HAM_BOOTS.getSimilarItems()),
    HOLY_MOLEYS(
            ArmourItemRef.HOLY_MOLEYS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 3),
            0.6,
            ArmourItemRef.HOLY_MOLEYS.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 31).build()),
    HOLY_SANDALS(
            ArmourItemRef.HOLY_SANDALS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 3),
            0.5,
            ArmourItemRef.HOLY_SANDALS.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 31).build()),
    INFINITY_BOOTS(
            ArmourItemRef.INFINITY_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 5, 0),
            new DefenceBonus(0, 0, 0, 5, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.INFINITY_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 50).hasLevel(DEFENCE, 25).build()),
    INSULATED_BOOTS(
            ArmourItemRef.INSULATED_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(1, 1, 0, 0, 1),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.INSULATED_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(SLAYER, 37).build()),
    IRON_BOOTS(
            ArmourItemRef.IRON_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(2, 3, 4, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.IRON_BOOTS.getSimilarItems()),
    LEATHER_BOOTS(
            ArmourItemRef.LEATHER_BOOTS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.LEATHER_BOOTS.getSimilarItems()),
    LUNAR_BOOTS(
            ArmourItemRef.LUNAR_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 2, -1),
            new DefenceBonus(1, 2, 2, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.LUNAR_BOOTS.getSimilarItems(),
            new RequirementBuilder()
                    .started(PaidQuest.LUNAR_DIPLOMACY)
                    .and()
                    .hasLevel(MAGIC, 65)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    MITHRIL_BOOTS(
            ArmourItemRef.MITHRIL_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(8, 9, 10, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.MITHRIL_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MIXED_HIDE_BOOTS(
            ArmourItemRef.MIXED_HIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 5),
            new DefenceBonus(4, 5, 6, 3, 3),
            new SkillsBonus(2, 0, 0, 0),
            2.0,
            ArmourItemRef.MIXED_HIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 60).hasLevel(DEFENCE, 50).build()),
    MOONCLAN_BOOTS(
            ArmourItemRef.MOONCLAN_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 2, -5),
            new DefenceBonus(2, 2, 2, 2, -5),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.MOONCLAN_BOOTS.getSimilarItems()),
    MOURNER_BOOTS(
            ArmourItemRef.MOURNER_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.MOURNER_BOOTS.getSimilarItems()),
    MUMMYS_FEET(
            ArmourItemRef.MUMMYS_FEET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.5,
            ArmourItemRef.MUMMYS_FEET.getSimilarItems()),
    MYSTIC_BOOTS(
            ArmourItemRef.MYSTIC_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.MYSTIC_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 20).build()),
    PEGASIAN_BOOTS(
            ArmourItemRef.PEGASIAN_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -12, 12),
            new DefenceBonus(5, 5, 5, 5, 5),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.PEGASIAN_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 75).hasLevel(DEFENCE, 75).build()),
    PINK_BOOTS(
            ArmourItemRef.PINK_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.PINK_BOOTS.getSimilarItems()),
    PRIMORDIAL_BOOTS(
            ArmourItemRef.PRIMORDIAL_BOOTS,
            true,
            new AttackBonus(2, 2, 2, -4, -1),
            new DefenceBonus(22, 22, 22, 0, 0),
            new SkillsBonus(5, 0, 0, 0),
            1.814,
            ArmourItemRef.PRIMORDIAL_BOOTS.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 75)
                    .hasLevel(DEFENCE, 75)
                    .build()),
    PURPLE_BOOTS(
            ArmourItemRef.PURPLE_BOOTS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.PURPLE_BOOTS.getSimilarItems()),
    RANGER_BOOTS(
            ArmourItemRef.RANGER_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 8),
            new DefenceBonus(2, 3, 4, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.283,
            ArmourItemRef.RANGER_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 40).build()),
    RED_BOOTS(
            ArmourItemRef.RED_BOOTS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.RED_BOOTS.getSimilarItems()),
    ROCKSHELL_BOOTS(
            ArmourItemRef.ROCK_SHELL_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.ROCK_SHELL_BOOTS.getSimilarItems()),
    ROGUE_BOOTS(
            ArmourItemRef.ROGUE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(2, 2, 2, 2, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ROGUE_BOOTS.getSimilarItems()),
    RUNE_BOOTS(
            ArmourItemRef.RUNE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(12, 13, 14, 0, 0),
            new SkillsBonus(2, 0, 0, 0),
            1.36,
            ArmourItemRef.RUNE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    RUNNER_BOOTS(
            ArmourItemRef.RUNNER_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 1, 1),
            new DefenceBonus(8, 8, 8, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.RUNNER_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    SAMURAI_BOOTS(
            ArmourItemRef.SAMURAI_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 13, 1, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.95,
            ArmourItemRef.SAMURAI_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 35).build()),
    SARADOMIN_DHIDE_BOOTS(
            ArmourItemRef.SARADOMIN_DHIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 7),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 1),
            1.4,
            ArmourItemRef.SARADOMIN_DHIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    SHAYZIEN_BOOTS_1(
            ArmourItemRef.SHAYZIEN_BOOTS_1,
            true,
            new AttackBonus(0, 0, 0, -2, -1),
            new DefenceBonus(1, 2, 3, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SHAYZIEN_BOOTS_1.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_BOOTS_2(
            ArmourItemRef.SHAYZIEN_BOOTS_2,
            true,
            new AttackBonus(0, 0, 0, -2, -1),
            new DefenceBonus(2, 3, 4, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SHAYZIEN_BOOTS_2.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_BOOTS_3(
            ArmourItemRef.SHAYZIEN_BOOTS_3,
            true,
            new AttackBonus(0, 0, 0, -2, -1),
            new DefenceBonus(4, 5, 6, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SHAYZIEN_BOOTS_3.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_BOOTS_4(
            ArmourItemRef.SHAYZIEN_BOOTS_4,
            true,
            new AttackBonus(0, 0, 0, -2, -1),
            new DefenceBonus(5, 6, 7, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SHAYZIEN_BOOTS_4.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_BOOTS(
            ArmourItemRef.SHAYZIEN_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -2, 4),
            new DefenceBonus(5, 7, 8, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SHAYZIEN_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SILLY_JESTER_BOOTS(
            ArmourItemRef.SILLY_JESTER_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 5, -5),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SILLY_JESTER_BOOTS.getSimilarItems()),
    SKELETAL_BOOTS(
            ArmourItemRef.SKELETAL_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.SKELETAL_BOOTS.getSimilarItems()),
    SNAKESKIN_BOOTS(
            ArmourItemRef.SNAKESKIN_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 3),
            new DefenceBonus(1, 1, 2, 1, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.SNAKESKIN_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 30).hasLevel(DEFENCE, 30).build()),
    SPIKED_BOOTS(
            ArmourItemRef.SPIKED_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(2, 0, 0, 0),
            0.34,
            ArmourItemRef.SPIKED_BOOTS.getSimilarItems()),
    SPIKED_MANACLES(
            ArmourItemRef.SPIKED_MANACLES,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(0, 0, 0, -4, 0),
            new SkillsBonus(4, 0, 0, 0),
            3.0,
            ArmourItemRef.SPIKED_MANACLES.getSimilarItems()),
    SPINED_BOOTS(
            ArmourItemRef.SPINED_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.SPINED_BOOTS.getSimilarItems()),
    SPLITBARK_BOOTS(
            ArmourItemRef.SPLITBARK_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 2, -1),
            new DefenceBonus(3, 2, 4, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.SPLITBARK_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 40).build()),
    STEEL_BOOTS(
            ArmourItemRef.STEEL_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(5, 6, 7, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.STEEL_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    SWAMPBARK_BOOTS(
            ArmourItemRef.SWAMPBARK_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(4, 3, 5, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.SWAMPBARK_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 50).build()),
    TEAL_BOOTS(
            ArmourItemRef.TEAL_BOOTS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.TEAL_BOOTS.getSimilarItems()),
    TURQUOISE_BOOTS(
            ArmourItemRef.TURQUOISE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.TURQUOISE_BOOTS.getSimilarItems()),
    VYREWATCH_SHOES(
            ArmourItemRef.VYREWATCH_SHOES,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.VYREWATCH_SHOES.getSimilarItems()),
    WHITE_BOOTS(
            ArmourItemRef.WHITE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 9, 0, 0),
            new SkillsBonus(0, 0, 0, 1),
            1.36,
            ArmourItemRef.WHITE_BOOTS.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.WANTED)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    WIZARD_BOOTS(
            ArmourItemRef.WIZARD_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.283,
            ArmourItemRef.WIZARD_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 20).build()),
    YELLOW_BOOTS(
            ArmourItemRef.YELLOW_BOOTS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.34,
            ArmourItemRef.YELLOW_BOOTS.getSimilarItems()),
    ZAMORAK_DHIDE_BOOTS(
            ArmourItemRef.ZAMORAK_DHIDE_BOOTS,
            true,
            new AttackBonus(0, 0, 0, -10, 7),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 1),
            1.4,
            ArmourItemRef.ZAMORAK_DHIDE_BOOTS.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    ZEALOT_BOOTS(
            ArmourItemRef.ZEALOT_BOOTS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 1),
            0.283,
            ArmourItemRef.ZEALOT_BOOTS.getSimilarItems());

    private final EquipmentSlot slot = EquipmentSlot.FEET;
    private final GenericItemRef itemRef;
    private final boolean members;
    private final AttackBonus attackBonus;
    private final DefenceBonus defenceBonus;
    private final SkillsBonus skillsBonus;
    private final double weight;
    private final GenericItemRef[] similarItems;
    private final Requirement requirement;

    FeetSlotRef(
            GenericItemRef itemRef,
            boolean members,
            AttackBonus attackBonus,
            DefenceBonus defenceBonus,
            SkillsBonus skillsBonus,
            double weight,
            GenericItemRef[] similarItems) {
        this.itemRef = itemRef;
        this.members = members;
        this.attackBonus = attackBonus;
        this.defenceBonus = defenceBonus;
        this.skillsBonus = skillsBonus;
        this.weight = weight;
        this.similarItems = similarItems;
        this.requirement = new RequirementBuilder().alwaysTrue().build();
    }
}

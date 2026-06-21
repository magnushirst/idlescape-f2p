package com.idlescape.gamedata.items.equipment;

import static org.dreambot.api.methods.skills.Skill.AGILITY;
import static org.dreambot.api.methods.skills.Skill.ATTACK;
import static org.dreambot.api.methods.skills.Skill.CONSTRUCTION;
import static org.dreambot.api.methods.skills.Skill.COOKING;
import static org.dreambot.api.methods.skills.Skill.CRAFTING;
import static org.dreambot.api.methods.skills.Skill.DEFENCE;
import static org.dreambot.api.methods.skills.Skill.FARMING;
import static org.dreambot.api.methods.skills.Skill.FIREMAKING;
import static org.dreambot.api.methods.skills.Skill.FISHING;
import static org.dreambot.api.methods.skills.Skill.FLETCHING;
import static org.dreambot.api.methods.skills.Skill.HERBLORE;
import static org.dreambot.api.methods.skills.Skill.HITPOINTS;
import static org.dreambot.api.methods.skills.Skill.HUNTER;
import static org.dreambot.api.methods.skills.Skill.MAGIC;
import static org.dreambot.api.methods.skills.Skill.MINING;
import static org.dreambot.api.methods.skills.Skill.PRAYER;
import static org.dreambot.api.methods.skills.Skill.RANGED;
import static org.dreambot.api.methods.skills.Skill.RUNECRAFTING;
import static org.dreambot.api.methods.skills.Skill.SAILING;
import static org.dreambot.api.methods.skills.Skill.SLAYER;
import static org.dreambot.api.methods.skills.Skill.SMITHING;
import static org.dreambot.api.methods.skills.Skill.STRENGTH;
import static org.dreambot.api.methods.skills.Skill.THIEVING;
import static org.dreambot.api.methods.skills.Skill.WOODCUTTING;

import com.idlescape.framework.requirements.Requirement;
import com.idlescape.framework.requirements.RequirementBuilder;
import com.idlescape.gamedata.combat.AttackBonus;
import com.idlescape.gamedata.combat.DefenceBonus;
import com.idlescape.gamedata.combat.SkillsBonus;
import com.idlescape.gamedata.diary.DiaryDifficulty;
import com.idlescape.gamedata.items.ArmourItemRef;
import com.idlescape.gamedata.items.GenericItemRef;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.diary.ArdougneDiary;
import org.dreambot.api.methods.quest.book.MiniQuest;
import org.dreambot.api.methods.quest.book.PaidQuest;

@Getter
@AllArgsConstructor
public enum CapeSlotRef implements EquipmentRef {
    _3RD_AGE_CLOAK(
            ArmourItemRef._3RD_AGE_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 5),
            0.005,
            ArmourItemRef._3RD_AGE_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 65).build()),
    _3RD_AGE_DRUIDIC_CLOAK(
            ArmourItemRef._3RD_AGE_DRUIDIC_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.4,
            ArmourItemRef._3RD_AGE_DRUIDIC_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 65).build()),
    ACCUMULATOR_MAX_CAPE(
            ArmourItemRef.ACCUMULATOR_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 4),
            new DefenceBonus(0, 1, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ACCUMULATOR_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    ACHIEVEMENT_DIARY_CAPE_TRIMMED(
            ArmourItemRef.ACHIEVEMENT_DIARY_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.ACHIEVEMENT_DIARY_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().completedAll(DiaryDifficulty.ELITE).build()),
    ACHIEVEMENT_DIARY_CAPE(
            ArmourItemRef.ACHIEVEMENT_DIARY_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.ACHIEVEMENT_DIARY_CAPE.getSimilarItems(),
            new RequirementBuilder().completedAll(DiaryDifficulty.ELITE).build()),
    AGILITY_CAPE_TRIMMED_WORN(
            ArmourItemRef.AGILITY_CAPE_TRIMMED_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.AGILITY_CAPE_TRIMMED_WORN.getSimilarItems(),
            new RequirementBuilder().hasLevel(AGILITY, 99).build()),
    AGILITY_CAPE_TRIMMED_INVENTORY(
            ArmourItemRef.AGILITY_CAPE_TRIMMED_INVENTORY,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            -4.0,
            ArmourItemRef.AGILITY_CAPE_TRIMMED_INVENTORY.getSimilarItems(),
            new RequirementBuilder().hasLevel(AGILITY, 99).build()),
    AGILITY_CAPE_WORN(
            ArmourItemRef.AGILITY_CAPE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.AGILITY_CAPE_WORN.getSimilarItems(),
            new RequirementBuilder().hasLevel(AGILITY, 99).build()),
    AGILITY_CAPE_INVENTORY(
            ArmourItemRef.AGILITY_CAPE_INVENTORY,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.AGILITY_CAPE_INVENTORY.getSimilarItems(),
            new RequirementBuilder().hasLevel(AGILITY, 99).build()),
    ANCIENT_CLOAK(
            ArmourItemRef.ANCIENT_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.003,
            ArmourItemRef.ANCIENT_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 40).build()),
    ARDOUGNE_CLOAK_1(
            ArmourItemRef.ARDOUGNE_CLOAK_1,
            true,
            new AttackBonus(2, 0, 0, 2, 0),
            new DefenceBonus(2, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 2),
            0.453,
            ArmourItemRef.ARDOUGNE_CLOAK_1.getSimilarItems(),
            new RequirementBuilder()
                    .completed(new ArdougneDiary(), DiaryDifficulty.EASY)
                    .build()),
    ARDOUGNE_CLOAK_2(
            ArmourItemRef.ARDOUGNE_CLOAK_2,
            true,
            new AttackBonus(4, 0, 0, 4, 0),
            new DefenceBonus(4, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.ARDOUGNE_CLOAK_2.getSimilarItems(),
            new RequirementBuilder()
                    .completed(new ArdougneDiary(), DiaryDifficulty.MEDIUM)
                    .build()),
    ARDOUGNE_CLOAK_3(
            ArmourItemRef.ARDOUGNE_CLOAK_3,
            true,
            new AttackBonus(5, 0, 0, 5, 0),
            new DefenceBonus(5, 0, 0, 5, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.453,
            ArmourItemRef.ARDOUGNE_CLOAK_3.getSimilarItems(),
            new RequirementBuilder()
                    .completed(new ArdougneDiary(), DiaryDifficulty.HARD)
                    .build()),
    ARDOUGNE_CLOAK_4(
            ArmourItemRef.ARDOUGNE_CLOAK_4,
            true,
            new AttackBonus(6, 0, 0, 6, 0),
            new DefenceBonus(6, 0, 0, 6, 0),
            new SkillsBonus(0, 0, 0, 6),
            0.453,
            ArmourItemRef.ARDOUGNE_CLOAK_4.getSimilarItems(),
            new RequirementBuilder()
                    .completed(new ArdougneDiary(), DiaryDifficulty.ELITE)
                    .build()),
    ARDOUGNE_MAX_CAPE(
            ArmourItemRef.ARDOUGNE_MAX_CAPE,
            true,
            new AttackBonus(6, 0, 0, 6, 0),
            new DefenceBonus(6, 0, 0, 6, 0),
            new SkillsBonus(0, 0, 0, 6),
            0.453,
            ArmourItemRef.ARDOUGNE_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .completed(new ArdougneDiary(), DiaryDifficulty.ELITE)
                    .build()),
    ARMADYL_CLOAK(
            ArmourItemRef.ARMADYL_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.4,
            ArmourItemRef.ARMADYL_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 40).build()),
    ASSEMBLER_MAX_CAPE(
            ArmourItemRef.ASSEMBLER_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 8),
            new DefenceBonus(1, 1, 1, 8, 2),
            new SkillsBonus(0, 2, 0, 0),
            0.453,
            ArmourItemRef.ASSEMBLER_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    ATTACK_CAPE_TRIMMED(
            ArmourItemRef.ATTACK_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.ATTACK_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(ATTACK, 99).build()),
    ATTACK_CAPE(
            ArmourItemRef.ATTACK_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ATTACK_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(ATTACK, 99).build()),
    AVAS_ACCUMULATOR(
            ArmourItemRef.AVAS_ACCUMULATOR,
            true,
            new AttackBonus(0, 0, 0, 0, 4),
            new DefenceBonus(0, 1, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.AVAS_ACCUMULATOR.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.ANIMAL_MAGNETISM)
                    .and()
                    .hasLevel(RANGED, 50)
                    .build()),
    AVAS_ASSEMBLER(
            ArmourItemRef.AVAS_ASSEMBLER,
            true,
            new AttackBonus(0, 0, 0, 0, 8),
            new DefenceBonus(1, 1, 1, 8, 2),
            new SkillsBonus(0, 2, 0, 0),
            5.896,
            ArmourItemRef.AVAS_ASSEMBLER.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).build()),
    AVAS_ATTRACTOR(
            ArmourItemRef.AVAS_ATTRACTOR,
            true,
            new AttackBonus(0, 0, 0, 0, 2),
            new DefenceBonus(0, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.AVAS_ATTRACTOR.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.ANIMAL_MAGNETISM)
                    .and()
                    .hasLevel(RANGED, 30)
                    .build()),
    BANDOS_CLOAK(
            ArmourItemRef.BANDOS_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.4,
            ArmourItemRef.BANDOS_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 40).build()),
    BLACK_CAPE(
            ArmourItemRef.BLACK_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.BLACK_CAPE.getSimilarItems()),
    BLESSED_DIZANAS_QUIVER(
            ArmourItemRef.BLESSED_DIZANAS_QUIVER,
            true,
            new AttackBonus(0, 0, 0, 0, 18),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 3, 0, 0),
            0.453,
            ArmourItemRef.BLESSED_DIZANAS_QUIVER.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 75).build()),
    BLUE_CAPE(
            ArmourItemRef.BLUE_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.BLUE_CAPE.getSimilarItems()),
    BONESACK(
            ArmourItemRef.BONESACK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.003,
            ArmourItemRef.BONESACK.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.RAG_AND_BONE_MAN_II).build()),
    CABBAGE_CAPE(
            ArmourItemRef.CABBAGE_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CABBAGE_CAPE.getSimilarItems()),
    LEGENDS_CAPE(
            ArmourItemRef.LEGENDS_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(7, 7, 7, 7, 7),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.LEGENDS_CAPE.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.LEGENDS_QUEST).build()),
    CAPE_OF_SKULLS(
            ArmourItemRef.CAPE_OF_SKULLS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CAPE_OF_SKULLS.getSimilarItems()),
    CASTLEWARS_CLOAK_SARADOMIN(
            ArmourItemRef.CASTLEWARS_CLOAK_SARADOMIN,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CASTLEWARS_CLOAK_SARADOMIN.getSimilarItems()),
    CASTLEWARS_CLOAK_ZAMORAK(
            ArmourItemRef.CASTLEWARS_CLOAK_ZAMORAK,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CASTLEWARS_CLOAK_ZAMORAK.getSimilarItems()),
    CONSTRUCTION_CAPE_TRIMMED(
            ArmourItemRef.CONSTRUCTION_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.CONSTRUCTION_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(CONSTRUCTION, 99).build()),
    CONSTRUCTION_CAPE(
            ArmourItemRef.CONSTRUCTION_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CONSTRUCTION_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(CONSTRUCTION, 99).build()),
    COOKING_CAPE_TRIMMED(
            ArmourItemRef.COOKING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.COOKING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(COOKING, 99).build()),
    COOKING_CAPE(
            ArmourItemRef.COOKING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.COOKING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(COOKING, 99).build()),
    CRAFTING_CAPE_TRIMMED(
            ArmourItemRef.CRAFTING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.CRAFTING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(CRAFTING, 99).build()),
    CRAFTING_CAPE(
            ArmourItemRef.CRAFTING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CRAFTING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(CRAFTING, 99).build()),
    DECORATIVE_ARMOUR_QUIVER(
            ArmourItemRef.DECORATIVE_ARMOUR_QUIVER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 0),
            8.164,
            ArmourItemRef.DECORATIVE_ARMOUR_QUIVER.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 30).build()),
    DEFENCE_CAPE_TRIMMED(
            ArmourItemRef.DEFENCE_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.DEFENCE_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 99).build()),
    DEFENCE_CAPE(
            ArmourItemRef.DEFENCE_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.DEFENCE_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 99).build()),
    DIZANAS_MAX_CAPE(
            ArmourItemRef.DIZANAS_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 18),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 3, 0, 0),
            0.453,
            ArmourItemRef.DIZANAS_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    DIZANAS_QUIVER_CHARGED(
            ArmourItemRef.DIZANAS_QUIVER_CHARGED,
            true,
            new AttackBonus(0, 0, 0, 0, 18),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 3, 0, 0),
            0.453,
            ArmourItemRef.DIZANAS_QUIVER_CHARGED.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 99).build()),
    FARMING_CAPE_TRIMMED(
            ArmourItemRef.FARMING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.FARMING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(FARMING, 99).build()),
    FARMING_CAPE(
            ArmourItemRef.FARMING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FARMING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(FARMING, 99).build()),
    FIRE_CAPE(
            ArmourItemRef.FIRE_CAPE,
            true,
            new AttackBonus(1, 1, 1, 1, 1),
            new DefenceBonus(11, 11, 11, 11, 11),
            new SkillsBonus(4, 0, 0, 2),
            1.814,
            ArmourItemRef.FIRE_CAPE.getSimilarItems()),
    FIRE_MAX_CAPE(
            ArmourItemRef.FIRE_MAX_CAPE,
            true,
            new AttackBonus(1, 1, 1, 1, 1),
            new DefenceBonus(11, 11, 11, 11, 11),
            new SkillsBonus(4, 0, 0, 2),
            0.453,
            ArmourItemRef.FIRE_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    FIREMAKING_CAPE_TRIMMED(
            ArmourItemRef.FIREMAKING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.FIREMAKING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(FIREMAKING, 99).build()),
    FIREMAKING_CAPE(
            ArmourItemRef.FIREMAKING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FIREMAKING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(FIREMAKING, 99).build()),
    FISH_SACK(
            ArmourItemRef.FISH_SACK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.FISH_SACK.getSimilarItems()),
    FISH_SACK_BARREL_CLOSED(
            ArmourItemRef.FISH_SACK_BARREL_CLOSED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.FISH_SACK_BARREL_CLOSED.getSimilarItems()),
    FISHING_CAPE_TRIMMED(
            ArmourItemRef.FISHING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.FISHING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(FISHING, 99).build()),
    FISHING_CAPE(
            ArmourItemRef.FISHING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FISHING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(FISHING, 99).build()),
    FLETCHING_CAPE_TRIMMED(
            ArmourItemRef.FLETCHING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.FLETCHING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(FLETCHING, 99).build()),
    FLETCHING_CAPE(
            ArmourItemRef.FLETCHING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FLETCHING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(FLETCHING, 99).build()),
    FREMENNIK_BLACK_CLOAK(
            ArmourItemRef.FREMENNIK_BLACK_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_BLACK_CLOAK.getSimilarItems()),
    FREMENNIK_BLUE_CLOAK(
            ArmourItemRef.FREMENNIK_BLUE_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_BLUE_CLOAK.getSimilarItems()),
    FREMENNIK_BROWN_CLOAK(
            ArmourItemRef.FREMENNIK_BROWN_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_BROWN_CLOAK.getSimilarItems()),
    FREMENNIK_CYAN_CLOAK(
            ArmourItemRef.FREMENNIK_CYAN_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_CYAN_CLOAK.getSimilarItems()),
    FREMENNIK_GREEN_CLOAK(
            ArmourItemRef.FREMENNIK_GREEN_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_GREEN_CLOAK.getSimilarItems()),
    FREMENNIK_GREY_CLOAK(
            ArmourItemRef.FREMENNIK_GREY_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_GREY_CLOAK.getSimilarItems()),
    FREMENNIK_PINK_CLOAK(
            ArmourItemRef.FREMENNIK_PINK_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_PINK_CLOAK.getSimilarItems()),
    FREMENNIK_PURPLE_CLOAK(
            ArmourItemRef.FREMENNIK_PURPLE_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_PURPLE_CLOAK.getSimilarItems()),
    FREMENNIK_RED_CLOAK(
            ArmourItemRef.FREMENNIK_RED_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_RED_CLOAK.getSimilarItems()),
    FREMENNIK_TEAL_CLOAK(
            ArmourItemRef.FREMENNIK_TEAL_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_TEAL_CLOAK.getSimilarItems()),
    FREMENNIK_YELLOW_CLOAK(
            ArmourItemRef.FREMENNIK_YELLOW_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_YELLOW_CLOAK.getSimilarItems()),
    GHOSTLY_CAPE(
            ArmourItemRef.GHOSTLY_CAPE,
            true,
            new AttackBonus(0, 0, 0, 5, 0),
            new DefenceBonus(0, 0, 0, 5, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.001,
            ArmourItemRef.GHOSTLY_CAPE.getSimilarItems()),
    GRACEFUL_CAPE_ADVENTURER(
            ArmourItemRef.GRACEFUL_CAPE_ADVENTURER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_ADVENTURER.getSimilarItems()),
    GRACEFUL_CAPE_AGILITY_ARENA(
            ArmourItemRef.GRACEFUL_CAPE_AGILITY_ARENA,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_AGILITY_ARENA.getSimilarItems()),
    GRACEFUL_CAPE_ARCEUUS(
            ArmourItemRef.GRACEFUL_CAPE_ARCEUUS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_ARCEUUS.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.THE_ASCENT_OF_ARCEUUS).build()),
    GRACEFUL_CAPE_HALLOWED(
            ArmourItemRef.GRACEFUL_CAPE_HALLOWED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_HALLOWED.getSimilarItems()),
    GRACEFUL_CAPE_HOSIDIUS(
            ArmourItemRef.GRACEFUL_CAPE_HOSIDIUS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_HOSIDIUS.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.THE_DEPTHS_OF_DESPAIR).build()),
    GRACEFUL_CAPE_KOUREND(
            ArmourItemRef.GRACEFUL_CAPE_KOUREND,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_KOUREND.getSimilarItems(),
            new RequirementBuilder()
                    .finished(
                            PaidQuest.THE_ASCENT_OF_ARCEUUS,
                            PaidQuest.THE_DEPTHS_OF_DESPAIR,
                            PaidQuest.THE_FORSAKEN_TOWER,
                            PaidQuest.THE_QUEEN_OF_THIEVES,
                            PaidQuest.TALE_OF_THE_RIGHTEOUS)
                    .build()),
    GRACEFUL_CAPE_LOVAKENGJ(
            ArmourItemRef.GRACEFUL_CAPE_LOVAKENGJ,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_LOVAKENGJ.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.THE_DEPTHS_OF_DESPAIR).build()),
    GRACEFUL_CAPE_PISCARILIUS(
            ArmourItemRef.GRACEFUL_CAPE_PISCARILIUS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_PISCARILIUS.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.THE_QUEEN_OF_THIEVES).build()),
    GRACEFUL_CAPE_SHAYZIEN(
            ArmourItemRef.GRACEFUL_CAPE_SHAYZIEN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_SHAYZIEN.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.TALE_OF_THE_RIGHTEOUS).build()),
    GRACEFUL_CAPE_TRAILBLAZER(
            ArmourItemRef.GRACEFUL_CAPE_TRAILBLAZER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_TRAILBLAZER.getSimilarItems()),
    GRACEFUL_CAPE_VARLAMORE(
            ArmourItemRef.GRACEFUL_CAPE_VARLAMORE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CAPE_VARLAMORE.getSimilarItems()),
    GRACEFUL_CLOAK_EQUIPPED(
            ArmourItemRef.GRACEFUL_CLOAK_EQUIPPED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -4.0,
            ArmourItemRef.GRACEFUL_CLOAK_EQUIPPED.getSimilarItems()),
    GREEN_CAPE(
            ArmourItemRef.GREEN_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.GREEN_CAPE.getSimilarItems()),
    GUTHIX_CAPE(
            ArmourItemRef.GUTHIX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(1, 1, 2, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.GUTHIX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .finished(MiniQuest.MAGE_ARENA_I)
                    .and()
                    .hasLevel(MAGIC, 60)
                    .build()),
    GUTHIX_CLOAK(
            ArmourItemRef.GUTHIX_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.4,
            ArmourItemRef.GUTHIX_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 40).build()),
    GUTHIX_MAX_CAPE(
            ArmourItemRef.GUTHIX_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(1, 1, 2, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.GUTHIX_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_I)
                    .build()),
    HAM_CLOAK(
            ArmourItemRef.HAM_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.HAM_CLOAK.getSimilarItems()),
    HERBLORE_CAPE_TRIMMED(
            ArmourItemRef.HERBLORE_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.HERBLORE_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(HERBLORE, 99).build()),
    HERBLORE_CAPE(
            ArmourItemRef.HERBLORE_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.HERBLORE_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(HERBLORE, 99).build()),
    HITPOINTS_CAPE_TRIMMED(
            ArmourItemRef.HITPOINTS_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.HITPOINTS_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(HITPOINTS, 99).build()),
    HITPOINTS_CAPE_UNTRIMMED(
            ArmourItemRef.HITPOINTS_CAPE_UNTRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.HITPOINTS_CAPE_UNTRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(HITPOINTS, 99).build()),
    HUNTER_CAPE_TRIMMED(
            ArmourItemRef.HUNTER_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.HUNTER_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 99).build()),
    HUNTER_CAPE(
            ArmourItemRef.HUNTER_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.HUNTER_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 99).build()),
    IMBUED_GUTHIX_CAPE(
            ArmourItemRef.IMBUED_GUTHIX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(3, 3, 3, 15, 0),
            new SkillsBonus(0, 0, 2, 0),
            0.453,
            ArmourItemRef.IMBUED_GUTHIX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_II)
                    .build()),
    IMBUED_GUTHIX_MAX_CAPE(
            ArmourItemRef.IMBUED_GUTHIX_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(3, 3, 3, 15, 0),
            new SkillsBonus(0, 0, 2, 0),
            0.453,
            ArmourItemRef.IMBUED_GUTHIX_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_II)
                    .build()),
    IMBUED_SARADOMIN_CAPE(
            ArmourItemRef.IMBUED_SARADOMIN_CAPE,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(3, 3, 3, 15, 0),
            new SkillsBonus(0, 0, 2, 0),
            0.453,
            ArmourItemRef.IMBUED_SARADOMIN_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_II)
                    .build()),
    IMBUED_SARADOMIN_MAX_CAPE(
            ArmourItemRef.IMBUED_SARADOMIN_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(3, 3, 3, 15, 0),
            new SkillsBonus(0, 0, 2, 0),
            0.453,
            ArmourItemRef.IMBUED_SARADOMIN_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_II)
                    .build()),
    IMBUED_ZAMORAK_CAPE(
            ArmourItemRef.IMBUED_ZAMORAK_CAPE,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(3, 3, 3, 15, 0),
            new SkillsBonus(0, 0, 2, 0),
            0.453,
            ArmourItemRef.IMBUED_ZAMORAK_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_II)
                    .build()),
    IMBUED_ZAMORAK_MAX_CAPE(
            ArmourItemRef.IMBUED_ZAMORAK_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(3, 3, 3, 15, 0),
            new SkillsBonus(0, 0, 2, 0),
            0.453,
            ArmourItemRef.IMBUED_ZAMORAK_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_II)
                    .build()),
    INFERNAL_CAPE(
            ArmourItemRef.INFERNAL_CAPE,
            true,
            new AttackBonus(4, 4, 4, 1, 1),
            new DefenceBonus(12, 12, 12, 12, 12),
            new SkillsBonus(8, 0, 0, 2),
            1.814,
            ArmourItemRef.INFERNAL_CAPE.getSimilarItems()),
    INFERNAL_MAX_CAPE(
            ArmourItemRef.INFERNAL_MAX_CAPE,
            true,
            new AttackBonus(4, 4, 4, 1, 1),
            new DefenceBonus(12, 12, 12, 12, 12),
            new SkillsBonus(8, 0, 0, 2),
            0.453,
            ArmourItemRef.INFERNAL_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    LUNAR_CAPE(
            ArmourItemRef.LUNAR_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.LUNAR_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .started(PaidQuest.LUNAR_DIPLOMACY)
                    .and()
                    .hasLevel(MAGIC, 65)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    MAGIC_CAPE_TRIMMED(
            ArmourItemRef.MAGIC_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.MAGIC_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 99).build()),
    MAGIC_CAPE(
            ArmourItemRef.MAGIC_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.MAGIC_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 99).build()),
    MASORI_ASSEMBLER_MAX_CAPE(
            ArmourItemRef.MASORI_ASSEMBLER_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 8),
            new DefenceBonus(1, 1, 1, 8, 2),
            new SkillsBonus(0, 2, 0, 0),
            0.453,
            ArmourItemRef.MASORI_ASSEMBLER_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    MASORI_ASSEMBLER_NORMAL(
            ArmourItemRef.MASORI_ASSEMBLER_NORMAL,
            true,
            new AttackBonus(0, 0, 0, 0, 8),
            new DefenceBonus(1, 1, 1, 8, 2),
            new SkillsBonus(0, 2, 0, 0),
            5.896,
            ArmourItemRef.MASORI_ASSEMBLER_NORMAL.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.DRAGON_SLAYER_II)
                    .and()
                    .hasLevel(RANGED, 70)
                    .build()),
    MAX_CAPE_WORN(
            ArmourItemRef.MAX_CAPE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            -4.0,
            ArmourItemRef.MAX_CAPE_WORN.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    MINING_CAPE_TRIMMED(
            ArmourItemRef.MINING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.MINING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(MINING, 99).build()),
    MINING_CAPE(
            ArmourItemRef.MINING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.MINING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(MINING, 99).build()),
    MIXED_HIDE_CAPE(
            ArmourItemRef.MIXED_HIDE_CAPE,
            true,
            new AttackBonus(0, 0, 0, -15, 5),
            new DefenceBonus(2, 2, 2, 5, 1),
            new SkillsBonus(1, 0, 0, 0),
            3.0,
            ArmourItemRef.MIXED_HIDE_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 60)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    MOONCLAN_CAPE(
            ArmourItemRef.MOONCLAN_CAPE,
            true,
            new AttackBonus(0, 0, 0, 2, -2),
            new DefenceBonus(0, 1, 1, 2, -2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.MOONCLAN_CAPE.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.LUNAR_DIPLOMACY).build()),
    MUSIC_CAPE_TRIMMED(
            ArmourItemRef.MUSIC_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.MUSIC_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    MUSIC_CAPE(
            ArmourItemRef.MUSIC_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.MUSIC_CAPE.getSimilarItems(),
            new RequirementBuilder().maxLevel().build()),
    MYTHICAL_CAPE(
            ArmourItemRef.MYTHICAL_CAPE,
            true,
            new AttackBonus(0, 0, 6, 0, 0),
            new DefenceBonus(8, 8, 8, 8, 8),
            new SkillsBonus(1, 0, 0, 1),
            1.814,
            ArmourItemRef.MYTHICAL_CAPE.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.DRAGON_SLAYER_II).build()),
    MYTHICAL_MAX_CAPE(
            ArmourItemRef.MYTHICAL_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 6, 0, 0),
            new DefenceBonus(8, 8, 8, 8, 8),
            new SkillsBonus(1, 0, 0, 1),
            0.453,
            ArmourItemRef.MYTHICAL_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .finished(PaidQuest.DRAGON_SLAYER_II)
                    .build()),
    OBSIDIAN_CAPE(
            ArmourItemRef.OBSIDIAN_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.OBSIDIAN_CAPE.getSimilarItems()),
    OBSIDIAN_CAPE_R(
            ArmourItemRef.OBSIDIAN_CAPE_R,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.OBSIDIAN_CAPE_R.getSimilarItems()),
    ORANGE_CAPE(
            ArmourItemRef.ORANGE_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ORANGE_CAPE.getSimilarItems()),
    PINK_CAPE(
            ArmourItemRef.PINK_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.PINK_CAPE.getSimilarItems()),
    PRAYER_CAPE_TRIMMED(
            ArmourItemRef.PRAYER_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.PRAYER_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 99).build()),
    PRAYER_CAPE(
            ArmourItemRef.PRAYER_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.PRAYER_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 99).build()),
    PURPLE_CAPE(
            ArmourItemRef.PURPLE_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.PURPLE_CAPE.getSimilarItems()),
    QUEST_CAPE_TRIMMED(
            ArmourItemRef.QUEST_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.QUEST_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder()
                    .completedAll(DiaryDifficulty.ELITE)
                    .and()
                    .maxQuestPoints()
                    .build()),
    QUEST_CAPE(
            ArmourItemRef.QUEST_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.QUEST_CAPE.getSimilarItems(),
            new RequirementBuilder().maxQuestPoints().build()),
    RANGING_CAPE_TRIMMED(
            ArmourItemRef.RANGING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.RANGING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 99).build()),
    RANGING_CAPE(
            ArmourItemRef.RANGING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.RANGING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 99).build()),
    RED_CAPE(
            ArmourItemRef.RED_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.RED_CAPE.getSimilarItems()),
    RUNECRAFT_CAPE_TRIMMED(
            ArmourItemRef.RUNECRAFT_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.RUNECRAFT_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(RUNECRAFTING, 99).build()),
    RUNECRAFT_CAPE(
            ArmourItemRef.RUNECRAFT_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.RUNECRAFT_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(RUNECRAFTING, 99).build()),
    SAILING_CAPE_TRIMMED(
            ArmourItemRef.SAILING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.SAILING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(SAILING, 99).build()),
    SAILING_CAPE(
            ArmourItemRef.SAILING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.SAILING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(SAILING, 99).build()),
    SARADOMIN_CAPE(
            ArmourItemRef.SARADOMIN_CAPE,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(1, 1, 2, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.SARADOMIN_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 60)
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_I)
                    .build()),
    SARADOMIN_CLOAK(
            ArmourItemRef.SARADOMIN_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.4,
            ArmourItemRef.SARADOMIN_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 99).build()),
    SARADOMIN_CLOAK_CASTLE_WARS(
            ArmourItemRef.SARADOMIN_CLOAK_CASTLE_WARS,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.001,
            ArmourItemRef.SARADOMIN_CLOAK_CASTLE_WARS.getSimilarItems()),
    SARADOMIN_MAX_CAPE(
            ArmourItemRef.SARADOMIN_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(1, 1, 2, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.SARADOMIN_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .maxLevel()
                    .and()
                    .finished(MiniQuest.MAGE_ARENA_I)
                    .build()),
    SLAYER_CAPE_TRIMMED(
            ArmourItemRef.SLAYER_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.SLAYER_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(SLAYER, 99).build()),
    SLAYER_CAPE(
            ArmourItemRef.SLAYER_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.SLAYER_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(SLAYER, 99).build()),
    SMITHING_CAPE_TRIMMED(
            ArmourItemRef.SMITHING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.SMITHING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(SMITHING, 99).build()),
    SMITHING_CAPE(
            ArmourItemRef.SMITHING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.SMITHING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(SMITHING, 99).build()),
    SOUL_CAPE_RED(
            ArmourItemRef.SOUL_CAPE_RED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 8),
            0.453,
            ArmourItemRef.SOUL_CAPE_RED.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 70).build()),
    SPOTTED_CAPE_WORN(
            ArmourItemRef.SPOTTED_CAPE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            -2.267,
            ArmourItemRef.SPOTTED_CAPE_WORN.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 40).build()),
    SPOTTIER_CAPE_WORN(
            ArmourItemRef.SPOTTIER_CAPE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            -4.535,
            ArmourItemRef.SPOTTIER_CAPE_WORN.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 66).build()),
    STRENGTH_CAPE_TRIMMED(
            ArmourItemRef.STRENGTH_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.STRENGTH_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(STRENGTH, 99).build()),
    STRENGTH_CAPE(
            ArmourItemRef.STRENGTH_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.STRENGTH_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(STRENGTH, 99).build()),
    TEAM_CAPE_ZERO(
            ArmourItemRef.TEAM_CAPE_ZERO,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.TEAM_CAPE_ZERO.getSimilarItems()),
    THIEVING_CAPE_TRIMMED(
            ArmourItemRef.THIEVING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.THIEVING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(THIEVING, 99).build()),
    THIEVING_CAPE(
            ArmourItemRef.THIEVING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.THIEVING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(THIEVING, 99).build()),
    TORTUGAN_SHIELD(
            ArmourItemRef.TORTUGAN_SHIELD,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(8, 8, 6, 0, 8),
            new SkillsBonus(0, 0, 0, 0),
            10.0,
            ArmourItemRef.TORTUGAN_SHIELD.getSimilarItems(),
            new RequirementBuilder().started(PaidQuest.TROUBLED_TORTUGANS).build()),
    WOODCUTTING_CAPE_TRIMMED(
            ArmourItemRef.WOODCUTTING_CAPE_TRIMMED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 4),
            0.453,
            ArmourItemRef.WOODCUTTING_CAPE_TRIMMED.getSimilarItems(),
            new RequirementBuilder().hasLevel(WOODCUTTING, 99).build()),
    WOODCUTTING_CAPE(
            ArmourItemRef.WOODCUTTING_CAPE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 9, 9, 9, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.WOODCUTTING_CAPE.getSimilarItems(),
            new RequirementBuilder().hasLevel(WOODCUTTING, 99).build()),
    YELLOW_CAPE(
            ArmourItemRef.YELLOW_CAPE,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 1, 0, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.YELLOW_CAPE.getSimilarItems()),
    ZAMORAK_CAPE(
            ArmourItemRef.ZAMORAK_CAPE,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(1, 1, 2, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ZAMORAK_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .finished(MiniQuest.MAGE_ARENA_I)
                    .and()
                    .hasLevel(MAGIC, 60)
                    .build()),
    ZAMORAK_CLOAK(
            ArmourItemRef.ZAMORAK_CLOAK,
            true,
            new AttackBonus(0, 0, 0, 1, 0),
            new DefenceBonus(3, 3, 3, 3, 3),
            new SkillsBonus(0, 0, 0, 3),
            0.4,
            ArmourItemRef.ZAMORAK_CLOAK.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 40).build()),
    ZAMORAK_MAX_CAPE(
            ArmourItemRef.ZAMORAK_MAX_CAPE,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(1, 1, 2, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ZAMORAK_MAX_CAPE.getSimilarItems(),
            new RequirementBuilder()
                    .finished(MiniQuest.MAGE_ARENA_I)
                    .and()
                    .maxLevel()
                    .build());

    private final EquipmentSlot slot = EquipmentSlot.CAPE;
    private final GenericItemRef itemRef;
    private final boolean members;
    private final AttackBonus attackBonus;
    private final DefenceBonus defenceBonus;
    private final SkillsBonus skillsBonus;
    private final double weight;
    private final GenericItemRef[] similarItems;
    private final Requirement IRequirement;

    CapeSlotRef(
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
        this.IRequirement = new RequirementBuilder().alwaysTrue().build();
    }
}

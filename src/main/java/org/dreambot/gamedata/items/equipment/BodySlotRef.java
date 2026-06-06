package org.dreambot.gamedata.items.equipment;

import static org.dreambot.api.methods.skills.Skill.AGILITY;
import static org.dreambot.api.methods.skills.Skill.ATTACK;
import static org.dreambot.api.methods.skills.Skill.DEFENCE;
import static org.dreambot.api.methods.skills.Skill.HITPOINTS;
import static org.dreambot.api.methods.skills.Skill.HUNTER;
import static org.dreambot.api.methods.skills.Skill.MAGIC;
import static org.dreambot.api.methods.skills.Skill.PRAYER;
import static org.dreambot.api.methods.skills.Skill.RANGED;
import static org.dreambot.api.methods.skills.Skill.STRENGTH;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.dreambot.api.methods.container.impl.equipment.EquipmentSlot;
import org.dreambot.api.methods.diary.WesternProvincesDiary;
import org.dreambot.api.methods.quest.book.FreeQuest;
import org.dreambot.api.methods.quest.book.MiniQuest;
import org.dreambot.api.methods.quest.book.PaidQuest;
import org.dreambot.framework.requirements.Requirement;
import org.dreambot.framework.requirements.RequirementBuilder;
import org.dreambot.gamedata.combat.AttackBonus;
import org.dreambot.gamedata.combat.DefenceBonus;
import org.dreambot.gamedata.combat.SkillsBonus;
import org.dreambot.gamedata.diary.DiaryDifficulty;
import org.dreambot.gamedata.items.ArmourItemRef;
import org.dreambot.gamedata.items.GenericItemRef;

@Getter
@AllArgsConstructor
public enum BodySlotRef implements EquipmentRef {
    _3RD_AGE_DRUIDIC_ROBE_TOP(
            ArmourItemRef._3RD_AGE_DRUIDIC_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 8),
            1.5,
            ArmourItemRef._3RD_AGE_DRUIDIC_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 65).build()),
    _3RD_AGE_PLATEBODY(
            ArmourItemRef._3RD_AGE_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -20, 0),
            new DefenceBonus(96, 108, 113, -4, 97),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef._3RD_AGE_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 65).build()),
    _3RD_AGE_RANGE_TOP(
            ArmourItemRef._3RD_AGE_RANGE_TOP,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 60, 55),
            new SkillsBonus(0, 0, 0, 0),
            4.0,
            ArmourItemRef._3RD_AGE_RANGE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 65)
                    .and()
                    .hasLevel(DEFENCE, 45)
                    .build()),
    _3RD_AGE_ROBE_TOP(
            ArmourItemRef._3RD_AGE_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 24, 0),
            new DefenceBonus(0, 0, 0, 24, 0),
            new SkillsBonus(0, 0, 1, 0),
            2.7,
            ArmourItemRef._3RD_AGE_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 65)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    ADAMANT_CHAINBODY(
            ArmourItemRef.ADAMANT_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(36, 50, 61, -3, 38),
            new SkillsBonus(0, 0, 0, 0),
            7.711,
            ArmourItemRef.ADAMANT_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    ADAMANT_PLATEBODY(
            ArmourItemRef.ADAMANT_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(65, 63, 55, -6, 63),
            new SkillsBonus(0, 0, 0, 0),
            11.339,
            ArmourItemRef.ADAMANT_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    AHRIMS_ROBETOP_UNDAMAGED(
            ArmourItemRef.AHRIMS_ROBETOP_UNDAMAGED,
            true,
            new AttackBonus(0, 0, 0, 30, -10),
            new DefenceBonus(52, 37, 63, 30, 0),
            new SkillsBonus(0, 0, 1, 0),
            4.535,
            ArmourItemRef.AHRIMS_ROBETOP_UNDAMAGED.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 70)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    ANCESTRAL_ROBE_TOP(
            ArmourItemRef.ANCESTRAL_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 35, -8),
            new DefenceBonus(42, 31, 51, 28, 0),
            new SkillsBonus(0, 0, 3, 0),
            2.721,
            ArmourItemRef.ANCESTRAL_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .hasLevel(DEFENCE, 65)
                    .build()),
    ANCIENT_CEREMONIAL_TOP(
            ArmourItemRef.ANCIENT_CEREMONIAL_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 6),
            0.9,
            ArmourItemRef.ANCIENT_CEREMONIAL_TOP.getSimilarItems()),
    ANCIENT_DHIDE_BODY(
            ArmourItemRef.ANCIENT_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 50, 55),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.ANCIENT_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ANCIENT_PLATEBODY(
            ArmourItemRef.ANCIENT_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.ANCIENT_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    ANCIENT_ROBE_TOP(
            ArmourItemRef.ANCIENT_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 6),
            0.005,
            ArmourItemRef.ANCIENT_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 20).build()),
    ARDOUGNE_KNIGHT_PLATEBODY(
            ArmourItemRef.ARDOUGNE_KNIGHT_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.ARDOUGNE_KNIGHT_PLATEBODY.getSimilarItems()),
    ARMADYL_CHESTPLATE(
            ArmourItemRef.ARMADYL_CHESTPLATE,
            true,
            new AttackBonus(-7, -7, -7, -15, 33),
            new DefenceBonus(56, 48, 61, 70, 57),
            new SkillsBonus(0, 0, 0, 1),
            4.0,
            ArmourItemRef.ARMADYL_CHESTPLATE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    ARMADYL_DHIDE_BODY(
            ArmourItemRef.ARMADYL_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 50, 55),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.ARMADYL_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ARMADYL_PLATEBODY(
            ArmourItemRef.ARMADYL_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.ARMADYL_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    ARMADYL_ROBE_TOP(
            ArmourItemRef.ARMADYL_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 6),
            1.8,
            ArmourItemRef.ARMADYL_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 20).build()),
    BANDOS_CHESTPLATE(
            ArmourItemRef.BANDOS_CHESTPLATE,
            true,
            new AttackBonus(0, 0, 0, -15, -10),
            new DefenceBonus(98, 93, 105, -6, 133),
            new SkillsBonus(4, 0, 0, 1),
            12.0,
            ArmourItemRef.BANDOS_CHESTPLATE.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 65).build()),
    BANDOS_DHIDE_BODY(
            ArmourItemRef.BANDOS_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 50, 55),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.BANDOS_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    BANDOS_PLATEBODY(
            ArmourItemRef.BANDOS_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.BANDOS_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    BANDOS_ROBE_TOP(
            ArmourItemRef.BANDOS_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 6),
            1.8,
            ArmourItemRef.BANDOS_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 20).build()),
    BLACK_CHAINBODY(
            ArmourItemRef.BLACK_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(22, 32, 39, -3, 24),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.BLACK_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    BLACK_DHIDE_BODY(
            ArmourItemRef.BLACK_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(30, 38, 45, 45, 50),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.BLACK_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    BLACK_ELEGANT_SHIRT(
            ArmourItemRef.BLACK_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.BLACK_ELEGANT_SHIRT.getSimilarItems()),
    BLACK_PLATEBODY(
            ArmourItemRef.BLACK_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(41, 40, 30, -6, 40),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.BLACK_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    BLACK_ROBE(
            ArmourItemRef.BLACK_ROBE,
            false,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.BLACK_ROBE.getSimilarItems()),
    BLOOD_MOON_BODY(
            ArmourItemRef.BLOOD_MOON_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, -10),
            new DefenceBonus(60, 80, 80, 40, 79),
            new SkillsBonus(4, 0, 0, 0),
            5.443,
            ArmourItemRef.BLOOD_MOON_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 75)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    BLOOD_BARK_BODY(
            ArmourItemRef.BLOOD_BARK_BODY,
            true,
            new AttackBonus(0, 0, 0, 21, 0),
            new DefenceBonus(53, 39, 64, 24, 0),
            new SkillsBonus(0, 0, 1, 0),
            4.535,
            ArmourItemRef.BLOOD_BARK_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 60)
                    .and()
                    .hasLevel(DEFENCE, 60)
                    .build()),
    BLUE_DHIDE_BODY(
            ArmourItemRef.BLUE_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 20),
            new DefenceBonus(23, 30, 30, 28, 40),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.BLUE_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 50)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    BLUE_ELEGANT_BLOUSE(
            ArmourItemRef.BLUE_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.BLUE_ELEGANT_BLOUSE.getSimilarItems()),
    BLUE_ELEGANT_SHIRT(
            ArmourItemRef.BLUE_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.BLUE_ELEGANT_SHIRT.getSimilarItems()),
    BLUE_MOON_CHESTPLATE_NEW(
            ArmourItemRef.BLUE_MOON_CHESTPLATE_NEW,
            true,
            new AttackBonus(0, 0, 0, 30, 0),
            new DefenceBonus(0, 0, 51, 28, 0),
            new SkillsBonus(2, 0, 1, 0),
            3.175,
            ArmourItemRef.BLUE_MOON_CHESTPLATE_NEW.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    BLUE_ROBE_TOP(
            ArmourItemRef.BLUE_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.BLUE_ROBE_TOP.getSimilarItems()),
    BLUE_WIZARD_ROBE(
            ArmourItemRef.BLUE_WIZARD_ROBE,
            false,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.BLUE_WIZARD_ROBE.getSimilarItems()),
    BRONZE_CHAINBODY(
            ArmourItemRef.BRONZE_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(7, 11, 13, -3, 9),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.BRONZE_CHAINBODY.getSimilarItems()),
    BRONZE_PLATEBODY(
            ArmourItemRef.BRONZE_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(15, 14, 9, -6, 14),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.BRONZE_PLATEBODY.getSimilarItems()),
    CARNILLEAN_ARMOUR(
            ArmourItemRef.CARNILLEAN_ARMOUR,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(20, 14, 8, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            9.071,
            ArmourItemRef.CARNILLEAN_ARMOUR.getSimilarItems()),
    CITIZEN_TOP(
            ArmourItemRef.CITIZEN_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.CITIZEN_TOP.getSimilarItems()),
    CREAM_ROBE_TOP(
            ArmourItemRef.CREAM_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.CREAM_ROBE_TOP.getSimilarItems()),
    CRYSTAL_BODY(
            ArmourItemRef.CRYSTAL_BODY,
            true,
            new AttackBonus(0, 0, 0, -18, 31),
            new DefenceBonus(46, 38, 48, 44, 68),
            new SkillsBonus(0, 0, 0, 3),
            2.0,
            ArmourItemRef.CRYSTAL_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(AGILITY, 50)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    DRAGONHAI_ROBE_TOP(
            ArmourItemRef.DRAGONHAI_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 25, 0),
            new DefenceBonus(0, 0, 0, 21, 0),
            new SkillsBonus(0, 0, 1, 2),
            2.267,
            ArmourItemRef.DRAGONHAI_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    DARK_SQUALL_ROBE_TOP(
            ArmourItemRef.DARK_SQUALL_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.DARK_SQUALL_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().started(PaidQuest.WHILE_GUTHIX_SLEEPS).build()),
    DARK_TUXEDO_JACKET(
            ArmourItemRef.DARK_TUXEDO_JACKET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.DARK_TUXEDO_JACKET.getSimilarItems()),
    DECORATIVE_ARMOUR_GOLD_PLATEBODY(
            ArmourItemRef.DECORATIVE_ARMOUR_GOLD_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(65, 63, 55, -6, 63),
            new SkillsBonus(0, 0, 0, 0),
            8.618,
            ArmourItemRef.DECORATIVE_ARMOUR_GOLD_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    DECORATIVE_ARMOUR_MAGIC_TOP(
            ArmourItemRef.DECORATIVE_ARMOUR_MAGIC_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(20, 20, 20, 20, 20),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.DECORATIVE_ARMOUR_MAGIC_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 20).build()),
    DECORATIVE_ARMOUR_RANGED_TOP(
            ArmourItemRef.DECORATIVE_ARMOUR_RANGED_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(20, 20, 20, 20, 20),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.DECORATIVE_ARMOUR_RANGED_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 30).build()),
    DECORATIVE_ARMOUR_RED_PLATEBODY(
            ArmourItemRef.DECORATIVE_ARMOUR_RED_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(32, 31, 24, -6, 31),
            new SkillsBonus(0, 0, 0, 0),
            8.618,
            ArmourItemRef.DECORATIVE_ARMOUR_RED_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    DECORATIVE_ARMOUR_WHITE_PLATEBODY(
            ArmourItemRef.DECORATIVE_ARMOUR_WHITE_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(46, 44, 38, -6, 44),
            new SkillsBonus(0, 0, 0, 0),
            8.618,
            ArmourItemRef.DECORATIVE_ARMOUR_WHITE_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    DHAROKS_PLATEBODY(
            ArmourItemRef.DHAROKS_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(122, 120, 107, -6, 132),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.DHAROKS_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    DRAGON_CHAINBODY(
            ArmourItemRef.DRAGON_CHAINBODY,
            true,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(81, 93, 98, -3, 82),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.DRAGON_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 60).build()),
    DRAGON_PLATEBODY(
            ArmourItemRef.DRAGON_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(109, 107, 97, -6, 106),
            new SkillsBonus(0, 0, 0, 0),
            11.339,
            ArmourItemRef.DRAGON_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 60)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    DRUIDS_ROBE_TOP(
            ArmourItemRef.DRUIDS_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 4),
            0.907,
            ArmourItemRef.DRUIDS_ROBE_TOP.getSimilarItems()),
    ECLIPSE_MOON_CHESTPLATE_NEW(
            ArmourItemRef.ECLIPSE_MOON_CHESTPLATE_NEW,
            true,
            new AttackBonus(0, 0, 0, -15, 31),
            new DefenceBonus(15, 18, 57, 55, 32),
            new SkillsBonus(3, 0, 0, 0),
            3.0,
            ArmourItemRef.ECLIPSE_MOON_CHESTPLATE_NEW.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 75)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    ELDER_CHAOS_TOP(
            ArmourItemRef.ELDER_CHAOS_TOP,
            true,
            new AttackBonus(0, 0, 0, 10, 0),
            new DefenceBonus(0, 0, 0, 8, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.2,
            ArmourItemRef.ELDER_CHAOS_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).build()),
    ELITE_BLACK_PLATEBODY(
            ArmourItemRef.ELITE_BLACK_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(46, 44, 38, -6, 44),
            new SkillsBonus(0, 0, 0, 8),
            9.979,
            ArmourItemRef.ELITE_BLACK_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .started(PaidQuest.WHILE_GUTHIX_SLEEPS)
                    .build()),
    ELITE_VOID_TOP_OR(
            ArmourItemRef.ELITE_VOID_TOP_OR,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(45, 45, 45, 45, 45),
            new SkillsBonus(0, 0, 0, 3),
            6.803,
            ArmourItemRef.ELITE_VOID_TOP_OR.getSimilarItems(),
            new RequirementBuilder()
                    .completed(new WesternProvincesDiary(), DiaryDifficulty.HARD)
                    .and()
                    .hasLevel(ATTACK, 42)
                    .and()
                    .hasLevel(STRENGTH, 42)
                    .and()
                    .hasLevel(DEFENCE, 42)
                    .and()
                    .hasLevel(HITPOINTS, 42)
                    .and()
                    .hasLevel(RANGED, 42)
                    .and()
                    .hasLevel(MAGIC, 42)
                    .and()
                    .hasLevel(PRAYER, 22)
                    .build()),
    ELITE_VOID_TOP(
            ArmourItemRef.ELITE_VOID_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(45, 45, 45, 45, 45),
            new SkillsBonus(0, 0, 0, 3),
            6.803,
            ArmourItemRef.ELITE_VOID_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .completed(new WesternProvincesDiary(), DiaryDifficulty.HARD)
                    .and()
                    .hasLevel(ATTACK, 42)
                    .and()
                    .hasLevel(STRENGTH, 42)
                    .and()
                    .hasLevel(DEFENCE, 42)
                    .and()
                    .hasLevel(HITPOINTS, 42)
                    .and()
                    .hasLevel(RANGED, 42)
                    .and()
                    .hasLevel(MAGIC, 42)
                    .and()
                    .hasLevel(PRAYER, 22)
                    .build()),
    ENCHANTED_TOP(
            ArmourItemRef.ENCHANTED_TOP,
            true,
            new AttackBonus(0, 0, 0, 20, 0),
            new DefenceBonus(0, 0, 0, 20, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.ENCHANTED_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 20)
                    .build()),
    FIGHTER_TORSO(
            ArmourItemRef.FIGHTER_TORSO,
            true,
            new AttackBonus(0, 0, 0, -40, 0),
            new DefenceBonus(62, 85, 62, -10, 67),
            new SkillsBonus(4, 0, 0, 0),
            4.0,
            ArmourItemRef.FIGHTER_TORSO.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    FREMENNIK_BEIGE_SHIRT(
            ArmourItemRef.FREMENNIK_BEIGE_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.FREMENNIK_BEIGE_SHIRT.getSimilarItems()),
    FREMENNIK_BLUE_SHIRT(
            ArmourItemRef.FREMENNIK_BLUE_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.FREMENNIK_BLUE_SHIRT.getSimilarItems()),
    FREMENNIK_BROWN_SHIRT(
            ArmourItemRef.FREMENNIK_BROWN_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.FREMENNIK_BROWN_SHIRT.getSimilarItems()),
    FREMENNIK_GREY_SHIRT(
            ArmourItemRef.FREMENNIK_GREY_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.FREMENNIK_GREY_SHIRT.getSimilarItems()),
    FREMENNIK_RED_SHIRT(
            ArmourItemRef.FREMENNIK_RED_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.FREMENNIK_RED_SHIRT.getSimilarItems()),
    FREMENNIK_ROBE(
            ArmourItemRef.FREMENNIK_ROBE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.FREMENNIK_ROBE.getSimilarItems()),
    FROG_LEATHER_BODY(
            ArmourItemRef.FROG_LEATHER_BODY,
            true,
            new AttackBonus(0, 0, 0, -5, 10),
            new DefenceBonus(23, 26, 30, 15, 32),
            new SkillsBonus(0, 0, 0, 0),
            5.0,
            ArmourItemRef.FROG_LEATHER_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 25)
                    .and()
                    .hasLevel(DEFENCE, 25)
                    .build()),
    GHOSTLY_ROBE_TOP(
            ArmourItemRef.GHOSTLY_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 5, 0),
            new DefenceBonus(0, 0, 0, 5, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.001,
            ArmourItemRef.GHOSTLY_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().started(MiniQuest.CURSE_OF_THE_EMPTY_LORD).build()),
    GILDED_CHAINBODY(
            ArmourItemRef.GILDED_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(63, 72, 78, -3, 65),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.GILDED_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    GILDED_DHIDE_BODY(
            ArmourItemRef.GILDED_DHIDE_BODY,
            false,
            new AttackBonus(0, 0, 0, -15, 15),
            new DefenceBonus(40, 32, 45, 20, 40),
            new SkillsBonus(0, 0, 0, 0),
            6.0,
            ArmourItemRef.GILDED_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .hasLevel(RANGED, 40)
                    .build()),
    GILDED_PLATEBODY(
            ArmourItemRef.GILDED_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.GILDED_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    GOLD_ELEGANT_BLOUSE(
            ArmourItemRef.GOLD_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.1,
            ArmourItemRef.GOLD_ELEGANT_BLOUSE.getSimilarItems()),
    GOLD_ELEGANT_SHIRT(
            ArmourItemRef.GOLD_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.1,
            ArmourItemRef.GOLD_ELEGANT_SHIRT.getSimilarItems()),
    GOLDEN_APRON(
            ArmourItemRef.GOLDEN_APRON,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.GOLDEN_APRON.getSimilarItems()),
    GRAAHK_TOP(
            ArmourItemRef.GRAAHK_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(10, 15, 19, 0, 12),
            new SkillsBonus(0, 0, 0, 0),
            0.226,
            ArmourItemRef.GRAAHK_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 38).build()),
    GRACEFUL_TOP_ADVENTURER(
            ArmourItemRef.GRACEFUL_TOP_ADVENTURER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_ADVENTURER.getSimilarItems()),
    GRACEFUL_TOP_AGILITY_ARENA(
            ArmourItemRef.GRACEFUL_TOP_AGILITY_ARENA,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_AGILITY_ARENA.getSimilarItems()),
    GRACEFUL_TOP_ARCEUUS_WORN(
            ArmourItemRef.GRACEFUL_TOP_ARCEUUS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_ARCEUUS_WORN.getSimilarItems()),
    GRACEFUL_TOP_HALLOWED(
            ArmourItemRef.GRACEFUL_TOP_HALLOWED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_HALLOWED.getSimilarItems()),
    GRACEFUL_TOP_HOSIDIUS_WORN(
            ArmourItemRef.GRACEFUL_TOP_HOSIDIUS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_HOSIDIUS_WORN.getSimilarItems()),
    GRACEFUL_TOP_KOUREND_WORN(
            ArmourItemRef.GRACEFUL_TOP_KOUREND_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_KOUREND_WORN.getSimilarItems()),
    GRACEFUL_TOP_LOVAKENGJ_WORN(
            ArmourItemRef.GRACEFUL_TOP_LOVAKENGJ_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_LOVAKENGJ_WORN.getSimilarItems()),
    GRACEFUL_TOP_PISCARILIUS(
            ArmourItemRef.GRACEFUL_TOP_PISCARILIUS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_PISCARILIUS.getSimilarItems()),
    GRACEFUL_TOP_SHAYZIEN_WORN(
            ArmourItemRef.GRACEFUL_TOP_SHAYZIEN_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_SHAYZIEN_WORN.getSimilarItems()),
    GRACEFUL_TOP_TRAILBLAZER(
            ArmourItemRef.GRACEFUL_TOP_TRAILBLAZER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_TRAILBLAZER.getSimilarItems()),
    GRACEFUL_TOP_VARLAMORE_WORN(
            ArmourItemRef.GRACEFUL_TOP_VARLAMORE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_VARLAMORE_WORN.getSimilarItems()),
    GRACEFUL_TOP_EQUIPPED(
            ArmourItemRef.GRACEFUL_TOP_EQUIPPED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -5.0,
            ArmourItemRef.GRACEFUL_TOP_EQUIPPED.getSimilarItems()),
    GRANITE_BODY(
            ArmourItemRef.GRANITE_BODY,
            true,
            new AttackBonus(0, 0, 0, -22, -5),
            new DefenceBonus(87, 84, 79, -6, 97),
            new SkillsBonus(0, 0, 0, 0),
            22.679,
            ArmourItemRef.GRANITE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 50)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    GREEN_DHIDE_BODY(
            ArmourItemRef.GREEN_DHIDE_BODY,
            false,
            new AttackBonus(0, 0, 0, -15, 15),
            new DefenceBonus(18, 27, 24, 20, 35),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.GREEN_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .and()
                    .hasLevel(RANGED, 40)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    GREEN_ELEGANT_BLOUSE(
            ArmourItemRef.GREEN_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.GREEN_ELEGANT_BLOUSE.getSimilarItems()),
    GREEN_ELEGANT_SHIRT(
            ArmourItemRef.GREEN_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.GREEN_ELEGANT_SHIRT.getSimilarItems()),
    GREEN_ROBE_TOP(
            ArmourItemRef.GREEN_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.GREEN_ROBE_TOP.getSimilarItems()),
    GREY_ROBE_TOP(
            ArmourItemRef.GREY_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.GREY_ROBE_TOP.getSimilarItems()),
    GROUP_IRONMAN_PLATEBODY_UNRANKED_II(
            ArmourItemRef.GROUP_IRONMAN_PLATEBODY_UNRANKED_II,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.GROUP_IRONMAN_PLATEBODY_UNRANKED_II.getSimilarItems()),
    GROUP_IRONMAN_PLATEBODY_II(
            ArmourItemRef.GROUP_IRONMAN_PLATEBODY_II,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.GROUP_IRONMAN_PLATEBODY_II.getSimilarItems()),
    GUTHANS_PLATEBODY(
            ArmourItemRef.GUTHANS_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(122, 120, 107, -6, 132),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.GUTHANS_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    GUTHIX_DHIDE_BODY(
            ArmourItemRef.GUTHIX_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 50, 55),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.GUTHIX_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    GUTHIX_PLATEBODY(
            ArmourItemRef.GUTHIX_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.GUTHIX_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    GUTHIX_ROBE_TOP(
            ArmourItemRef.GUTHIX_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 6),
            1.8,
            ArmourItemRef.GUTHIX_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 20).build()),
    HAM_SHIRT(
            ArmourItemRef.HAM_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.HAM_SHIRT.getSimilarItems()),
    HARDCORE_GROUP_IRONMAN_PLATEBODY_II(
            ArmourItemRef.HARDCORE_GROUP_IRONMAN_PLATEBODY_II,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.HARDCORE_GROUP_IRONMAN_PLATEBODY_II.getSimilarItems()),
    HARDCORE_IRONMAN_PLATEBODY(
            ArmourItemRef.HARDCORE_IRONMAN_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.HARDCORE_IRONMAN_PLATEBODY.getSimilarItems()),
    HARDLEATHER_BODY(
            ArmourItemRef.HARDLEATHER_BODY,
            false,
            new AttackBonus(0, 0, 0, -4, 8),
            new DefenceBonus(12, 15, 18, 6, 15),
            new SkillsBonus(0, 0, 0, 0),
            3.628,
            ArmourItemRef.HARDLEATHER_BODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    HUEYCOATL_HIDE_BODY(
            ArmourItemRef.HUEYCOATL_HIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 56, 55),
            new SkillsBonus(0, 0, 0, 3),
            6.803,
            ArmourItemRef.HUEYCOATL_HIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    INFINITY_BODY(
            ArmourItemRef.INFINITY_BODY,
            true,
            new AttackBonus(0, 0, 0, 22, 0),
            new DefenceBonus(0, 0, 0, 22, 0),
            new SkillsBonus(0, 0, 1, 0),
            2.267,
            ArmourItemRef.INFINITY_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 50)
                    .and()
                    .hasLevel(DEFENCE, 25)
                    .build()),
    INITIATE_HAUBERK(
            ArmourItemRef.INITIATE_HAUBERK,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(46, 44, 38, -6, 44),
            new SkillsBonus(0, 0, 0, 6),
            8.618,
            ArmourItemRef.INITIATE_HAUBERK.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.RECRUITMENT_DRIVE)
                    .and()
                    .hasLevel(PRAYER, 10)
                    .and()
                    .hasLevel(DEFENCE, 20)
                    .build()),
    INQUISITORS_HAUBERK(
            ArmourItemRef.INQUISITORS_HAUBERK,
            true,
            new AttackBonus(-3, -3, 12, -11, -10),
            new DefenceBonus(67, 55, 71, 0, 35),
            new SkillsBonus(4, 0, 0, 2),
            9.979,
            ArmourItemRef.INQUISITORS_HAUBERK.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 70)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    IRON_CHAINBODY(
            ArmourItemRef.IRON_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(10, 15, 19, -3, 12),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.IRON_CHAINBODY.getSimilarItems()),
    IRON_PLATEBODY(
            ArmourItemRef.IRON_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.IRON_PLATEBODY.getSimilarItems()),
    IRONMAN_PLATEBODY(
            ArmourItemRef.IRONMAN_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.IRONMAN_PLATEBODY.getSimilarItems()),
    JUSTICIAR_CHESTGUARD(
            ArmourItemRef.JUSTICIAR_CHESTGUARD,
            true,
            new AttackBonus(0, 0, 0, -40, -20),
            new DefenceBonus(132, 130, 117, -16, 142),
            new SkillsBonus(0, 0, 0, 4),
            9.979,
            ArmourItemRef.JUSTICIAR_CHESTGUARD.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 75).build()),
    KARILS_LEATHER_TOP(
            ArmourItemRef.KARILS_LEATHER_TOP,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(47, 42, 50, 65, 57),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.KARILS_LEATHER_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    KHAZARD_ARMOUR(
            ArmourItemRef.KHAZARD_ARMOUR,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 11, 10, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.566,
            ArmourItemRef.KHAZARD_ARMOUR.getSimilarItems()),
    KYATT_TOP(
            ArmourItemRef.KYATT_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(10, 15, 19, 0, 12),
            new SkillsBonus(0, 0, 0, 0),
            0.226,
            ArmourItemRef.KYATT_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 52).build()),
    LARUPIA_TOP(
            ArmourItemRef.LARUPIA_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(10, 15, 19, 0, 12),
            new SkillsBonus(0, 0, 0, 0),
            0.226,
            ArmourItemRef.LARUPIA_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 28).build()),
    LEATHER_BODY(
            ArmourItemRef.LEATHER_BODY,
            false,
            new AttackBonus(0, 0, 0, -2, 2),
            new DefenceBonus(8, 9, 10, 4, 9),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.LEATHER_BODY.getSimilarItems()),
    LIGHT_INFINITY_TOP(
            ArmourItemRef.LIGHT_INFINITY_TOP,
            true,
            new AttackBonus(0, 0, 0, 22, 0),
            new DefenceBonus(0, 0, 0, 22, 0),
            new SkillsBonus(0, 0, 1, 0),
            2.267,
            ArmourItemRef.LIGHT_INFINITY_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 50)
                    .and()
                    .hasLevel(DEFENCE, 25)
                    .build()),
    LUNAR_TORSO(
            ArmourItemRef.LUNAR_TORSO,
            true,
            new AttackBonus(0, 0, 0, 10, -10),
            new DefenceBonus(34, 22, 40, 12, 0),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.LUNAR_TORSO.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.LUNAR_DIPLOMACY)
                    .and()
                    .hasLevel(MAGIC, 65)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    MASORI_BODY(
            ArmourItemRef.MASORI_BODY,
            true,
            new AttackBonus(0, 0, 0, -4, 43),
            new DefenceBonus(37, 35, 38, 25, 33),
            new SkillsBonus(0, 4, 0, 0),
            8.0,
            ArmourItemRef.MASORI_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 80)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    MASORI_BODY_F(
            ArmourItemRef.MASORI_BODY_F,
            true,
            new AttackBonus(0, 0, 0, -4, 43),
            new DefenceBonus(59, 52, 64, 74, 60),
            new SkillsBonus(0, 4, 0, 1),
            10.0,
            ArmourItemRef.MASORI_BODY_F.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 80)
                    .and()
                    .hasLevel(DEFENCE, 80)
                    .build()),
    MITHRIL_CHAINBODY(
            ArmourItemRef.MITHRIL_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(25, 35, 42, -3, 27),
            new SkillsBonus(0, 0, 0, 0),
            5.896,
            ArmourItemRef.MITHRIL_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MITHRIL_PLATEBODY(
            ArmourItemRef.MITHRIL_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(46, 44, 38, -6, 44),
            new SkillsBonus(0, 0, 0, 0),
            8.618,
            ArmourItemRef.MITHRIL_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MIXED_HIDE_TOP(
            ArmourItemRef.MIXED_HIDE_TOP,
            true,
            new AttackBonus(4, -2, -3, -15, 27),
            new DefenceBonus(33, 39, 43, 30, 32),
            new SkillsBonus(2, 0, 0, 0),
            3.0,
            ArmourItemRef.MIXED_HIDE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 60)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    MONKS_ROBE_TOP(
            ArmourItemRef.MONKS_ROBE_TOP,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 6),
            0.907,
            ArmourItemRef.MONKS_ROBE_TOP.getSimilarItems()),
    MOONCLAN_ARMOUR(
            ArmourItemRef.MOONCLAN_ARMOUR,
            true,
            new AttackBonus(0, 0, 0, 5, -10),
            new DefenceBonus(5, 5, 5, 5, -10),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.MOONCLAN_ARMOUR.getSimilarItems()),
    MYSTIC_ROBE_TOP(
            ArmourItemRef.MYSTIC_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 20, 0),
            new DefenceBonus(0, 0, 0, 20, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.MYSTIC_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 20)
                    .build()),
    OATHPLATE_CHEST(
            ArmourItemRef.OATHPLATE_CHEST,
            true,
            new AttackBonus(0, 16, 0, -16, -18),
            new DefenceBonus(105, 128, 100, -5, 112),
            new SkillsBonus(4, 0, 0, 0),
            9.979,
            ArmourItemRef.OATHPLATE_CHEST.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 78).build()),
    OBSIDIAN_PLATEBODY(
            ArmourItemRef.OBSIDIAN_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(55, 78, 56, -15, 60),
            new SkillsBonus(3, 0, 0, 0),
            9.979,
            ArmourItemRef.OBSIDIAN_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 60).build()),
    PINK_ELEGANT_BLOUSE(
            ArmourItemRef.PINK_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.1,
            ArmourItemRef.PINK_ELEGANT_BLOUSE.getSimilarItems()),
    PINK_ELEGANT_SHIRT(
            ArmourItemRef.PINK_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.1,
            ArmourItemRef.PINK_ELEGANT_SHIRT.getSimilarItems()),
    PINK_ROBE_TOP(
            ArmourItemRef.PINK_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.PINK_ROBE_TOP.getSimilarItems()),
    PRIEST_GOWN_TOP(
            ArmourItemRef.PRIEST_GOWN_TOP,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 3),
            1.814,
            ArmourItemRef.PRIEST_GOWN_TOP.getSimilarItems()),
    PROSELYTE_HAUBERK(
            ArmourItemRef.PROSELYTE_HAUBERK,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(65, 63, 55, -6, 63),
            new SkillsBonus(0, 0, 0, 8),
            8.618,
            ArmourItemRef.PROSELYTE_HAUBERK.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_SLUG_MENACE)
                    .and()
                    .hasLevel(PRAYER, 20)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    PURPLE_ELEGANT_BLOUSE(
            ArmourItemRef.PURPLE_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.PURPLE_ELEGANT_BLOUSE.getSimilarItems()),
    PURPLE_ELEGANT_SHIRT(
            ArmourItemRef.PURPLE_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.PURPLE_ELEGANT_SHIRT.getSimilarItems()),
    PURPLE_ROBE_TOP(
            ArmourItemRef.PURPLE_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.PURPLE_ROBE_TOP.getSimilarItems()),
    RADIANT_OATHPLATE_CHEST(
            ArmourItemRef.RADIANT_OATHPLATE_CHEST,
            true,
            new AttackBonus(0, 16, 0, -16, -18),
            new DefenceBonus(105, 128, 100, -5, 112),
            new SkillsBonus(4, 0, 0, 0),
            9.979,
            ArmourItemRef.RADIANT_OATHPLATE_CHEST.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 78).build()),
    RANGERS_TUNIC(
            ArmourItemRef.RANGERS_TUNIC,
            true,
            new AttackBonus(0, 0, 0, -15, 15),
            new DefenceBonus(6, 9, 12, 6, 6),
            new SkillsBonus(0, 0, 0, 0),
            3.0,
            ArmourItemRef.RANGERS_TUNIC.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 40).build()),
    RED_DHIDE_BODY(
            ArmourItemRef.RED_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 25),
            new DefenceBonus(26, 34, 36, 36, 45),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.RED_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 60)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    RED_ELEGANT_BLOUSE(
            ArmourItemRef.RED_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.RED_ELEGANT_BLOUSE.getSimilarItems()),
    RED_ELEGANT_SHIRT(
            ArmourItemRef.RED_ELEGANT_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.RED_ELEGANT_SHIRT.getSimilarItems()),
    RED_ROBE_TOP(
            ArmourItemRef.RED_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.RED_ROBE_TOP.getSimilarItems()),
    ROBE_OF_ELIDINIS_TOP(
            ArmourItemRef.ROBE_OF_ELIDINIS_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.005,
            ArmourItemRef.ROBE_OF_ELIDINIS_TOP.getSimilarItems()),
    ROBE_TOP_OF_DARKNESS(
            ArmourItemRef.ROBE_TOP_OF_DARKNESS,
            true,
            new AttackBonus(0, 0, 0, 20, 0),
            new DefenceBonus(0, 0, 0, 20, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.ROBE_TOP_OF_DARKNESS.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 20)
                    .build()),
    ROCKSHELL_PLATE(
            ArmourItemRef.ROCKSHELL_PLATE,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.ROCKSHELL_PLATE.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ROGUE_TOP(
            ArmourItemRef.ROGUE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(10, 10, 10, 10, 10),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ROGUE_TOP.getSimilarItems()),
    RUNE_CHAINBODY(
            ArmourItemRef.RUNE_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(63, 72, 78, -3, 65),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.RUNE_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    RUNE_PLATEBODY(
            ArmourItemRef.RUNE_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.RUNE_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SAMURAI_SHIRT(
            ArmourItemRef.SAMURAI_SHIRT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(69, 67, 59, 10, 67),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.SAMURAI_SHIRT.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 35).build()),
    SANGUINE_TORVA_PLATEBODY(
            ArmourItemRef.SANGUINE_TORVA_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -18, -14),
            new DefenceBonus(117, 111, 117, -11, 142),
            new SkillsBonus(6, 0, 0, 1),
            9.979,
            ArmourItemRef.SANGUINE_TORVA_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 80).build()),
    SARADOMIN_DHIDE_BODY(
            ArmourItemRef.SARADOMIN_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 50, 55),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.SARADOMIN_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SARADOMIN_PLATEBODY(
            ArmourItemRef.SARADOMIN_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.SARADOMIN_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    SARADOMIN_ROBE_TOP(
            ArmourItemRef.SARADOMIN_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 6),
            1.8,
            ArmourItemRef.SARADOMIN_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 20).build()),
    SHADE_ROBE_TOP(
            ArmourItemRef.SHADE_ROBE_TOP,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.907,
            ArmourItemRef.SHADE_ROBE_TOP.getSimilarItems()),
    SHAYZIEN_BODY(
            ArmourItemRef.SHAYZIEN_BODY,
            true,
            new AttackBonus(0, 0, 0, -10, 10),
            new DefenceBonus(20, 24, 28, -4, 27),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.SHAYZIEN_BODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_PLATEBODY_1(
            ArmourItemRef.SHAYZIEN_PLATEBODY_1,
            true,
            new AttackBonus(0, 0, 0, -5, 0),
            new DefenceBonus(16, 20, 22, -2, 16),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.SHAYZIEN_PLATEBODY_1.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_PLATEBODY_2(
            ArmourItemRef.SHAYZIEN_PLATEBODY_2,
            true,
            new AttackBonus(0, 0, 0, -7, 0),
            new DefenceBonus(20, 25, 30, -3, 20),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.SHAYZIEN_PLATEBODY_2.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_PLATEBODY_3(
            ArmourItemRef.SHAYZIEN_PLATEBODY_3,
            true,
            new AttackBonus(0, 0, 0, -8, 0),
            new DefenceBonus(25, 32, 35, -3, 22),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.SHAYZIEN_PLATEBODY_3.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_PLATEBODY_4(
            ArmourItemRef.SHAYZIEN_PLATEBODY_4,
            true,
            new AttackBonus(0, 0, 0, -9, 0),
            new DefenceBonus(28, 35, 37, -4, 25),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.SHAYZIEN_PLATEBODY_4.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SILLY_JESTER_TOP(
            ArmourItemRef.SILLY_JESTER_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 5, -5),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.SILLY_JESTER_TOP.getSimilarItems()),
    SKELETAL_TOP(
            ArmourItemRef.SKELETAL_TOP,
            true,
            new AttackBonus(0, 0, 0, 8, -10),
            new DefenceBonus(35, 25, 42, 15, 0),
            new SkillsBonus(0, 0, 0, 0),
            4.989,
            ArmourItemRef.SKELETAL_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SNAKESKIN_BODY(
            ArmourItemRef.SNAKESKIN_BODY,
            true,
            new AttackBonus(0, 0, 0, -5, 12),
            new DefenceBonus(25, 28, 32, 15, 35),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.SNAKESKIN_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 30)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    SPINED_BODY(
            ArmourItemRef.SPINED_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 15),
            new DefenceBonus(40, 32, 45, 20, 40),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.SPINED_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .hasLevel(RANGED, 40)
                    .build()),
    SPLITBARK_BODY(
            ArmourItemRef.SPLITBARK_BODY,
            true,
            new AttackBonus(0, 0, 0, 10, -10),
            new DefenceBonus(36, 26, 42, 15, 0),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.SPLITBARK_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    STEEL_CHAINBODY(
            ArmourItemRef.STEEL_CHAINBODY,
            false,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(17, 25, 30, -3, 19),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.STEEL_CHAINBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    STEEL_PLATEBODY(
            ArmourItemRef.STEEL_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(32, 31, 24, -6, 31),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.STEEL_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    STUDDED_BODY(
            ArmourItemRef.STUDDED_BODY,
            false,
            new AttackBonus(0, 0, 0, -4, 8),
            new DefenceBonus(18, 25, 22, 8, 25),
            new SkillsBonus(0, 0, 0, 0),
            5.443,
            ArmourItemRef.STUDDED_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 20)
                    .and()
                    .hasLevel(DEFENCE, 20)
                    .build()),
    SUNFIRE_FANATIC_CUIRASS(
            ArmourItemRef.SUNFIRE_FANATIC_CUIRASS,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 10),
            8.618,
            ArmourItemRef.SUNFIRE_FANATIC_CUIRASS.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(PRAYER, 60)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SWAMPBARK_BODY(
            ArmourItemRef.SWAMPBARK_BODY,
            true,
            new AttackBonus(0, 0, 0, 15, 0),
            new DefenceBonus(38, 44, 48, 21, 0),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.SWAMPBARK_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(PRAYER, 60)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    TEAL_ROBE_TOP(
            ArmourItemRef.TEAL_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.TEAL_ROBE_TOP.getSimilarItems()),
    TORAGS_PLATEBODY(
            ArmourItemRef.TORAGS_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(122, 120, 107, -6, 132),
            new SkillsBonus(0, 0, 0, 0),
            9.979,
            ArmourItemRef.TORAGS_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    TORVA_PLATEBODY(
            ArmourItemRef.TORVA_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -18, -14),
            new DefenceBonus(117, 111, 117, -11, 142),
            new SkillsBonus(6, 0, 0, 1),
            9.979,
            ArmourItemRef.TORVA_PLATEBODY.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 80).build()),
    TURQUOISE_ROBE_TOP(
            ArmourItemRef.TURQUOISE_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.TURQUOISE_ROBE_TOP.getSimilarItems()),
    TWISTED_ANCESTRAL_ROBE_TOP(
            ArmourItemRef.TWISTED_ANCESTRAL_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 35, -8),
            new DefenceBonus(42, 31, 51, 28, 0),
            new SkillsBonus(0, 0, 3, 0),
            2.721,
            ArmourItemRef.TWISTED_ANCESTRAL_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .hasLevel(DEFENCE, 65)
                    .build()),
    ULTIMATE_IRONMAN_PLATEBODY(
            ArmourItemRef.ULTIMATE_IRONMAN_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(21, 20, 12, -6, 20),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.ULTIMATE_IRONMAN_PLATEBODY.getSimilarItems()),
    VARROCK_ARMOUR_1(
            ArmourItemRef.VARROCK_ARMOUR_1,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(32, 31, 24, -6, 31),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.VARROCK_ARMOUR_1.getSimilarItems()),
    VARROCK_ARMOUR_2(
            ArmourItemRef.VARROCK_ARMOUR_2,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(41, 40, 30, -6, 40),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.VARROCK_ARMOUR_2.getSimilarItems()),
    VARROCK_ARMOUR_3(
            ArmourItemRef.VARROCK_ARMOUR_3,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(46, 44, 38, -6, 44),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.VARROCK_ARMOUR_3.getSimilarItems()),
    VARROCK_ARMOUR_4(
            ArmourItemRef.VARROCK_ARMOUR_4,
            true,
            new AttackBonus(0, 0, 0, -30, -10),
            new DefenceBonus(65, 63, 55, -6, 63),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.VARROCK_ARMOUR_4.getSimilarItems()),
    VERACS_BRASSARD(
            ArmourItemRef.VERACS_BRASSARD,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(81, 95, 85, 0, 81),
            new SkillsBonus(0, 0, 0, 5),
            4.989,
            ArmourItemRef.VERACS_BRASSARD.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    VIRTUS_ROBE_TOP(
            ArmourItemRef.VIRTUS_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 35, -11),
            new DefenceBonus(47, 36, 56, 31, 0),
            new SkillsBonus(0, 0, 2, 2),
            2.895,
            ArmourItemRef.VIRTUS_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 78)
                    .and()
                    .hasLevel(DEFENCE, 75)
                    .build()),
    VOID_KNIGHT_TOP_OR(
            ArmourItemRef.VOID_KNIGHT_TOP_OR,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(45, 45, 45, 45, 45),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.VOID_KNIGHT_TOP_OR.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(ATTACK, 42)
                    .and()
                    .hasLevel(STRENGTH, 42)
                    .and()
                    .hasLevel(DEFENCE, 42)
                    .and()
                    .hasLevel(HITPOINTS, 42)
                    .and()
                    .hasLevel(RANGED, 42)
                    .and()
                    .hasLevel(MAGIC, 42)
                    .and()
                    .hasLevel(PRAYER, 42)
                    .build()),
    VOID_KNIGHT_TOP(
            ArmourItemRef.VOID_KNIGHT_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(45, 45, 45, 45, 45),
            new SkillsBonus(0, 0, 0, 0),
            6.803,
            ArmourItemRef.VOID_KNIGHT_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(ATTACK, 42)
                    .and()
                    .hasLevel(STRENGTH, 42)
                    .and()
                    .hasLevel(DEFENCE, 42)
                    .and()
                    .hasLevel(HITPOINTS, 42)
                    .and()
                    .hasLevel(RANGED, 42)
                    .and()
                    .hasLevel(MAGIC, 42)
                    .and()
                    .hasLevel(PRAYER, 42)
                    .build()),
    VYREWATCH_TOP(
            ArmourItemRef.VYREWATCH_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.VYREWATCH_TOP.getSimilarItems()),
    WHITE_CHAINBODY(
            ArmourItemRef.WHITE_CHAINBODY,
            true,
            new AttackBonus(0, 0, 0, -15, 0),
            new DefenceBonus(22, 32, 39, -3, 24),
            new SkillsBonus(0, 0, 0, 1),
            6.803,
            ArmourItemRef.WHITE_CHAINBODY.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.WANTED)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    WHITE_ELEGANT_BLOUSE(
            ArmourItemRef.WHITE_ELEGANT_BLOUSE,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.WHITE_ELEGANT_BLOUSE.getSimilarItems()),
    WHITE_PLATEBODY(
            ArmourItemRef.WHITE_PLATEBODY,
            true,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(41, 40, 30, -6, 40),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.WHITE_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.WANTED)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    XERICIAN_TOP(
            ArmourItemRef.XERICIAN_TOP,
            true,
            new AttackBonus(0, 0, 0, 6, 0),
            new DefenceBonus(0, 0, 0, 10, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.2,
            ArmourItemRef.XERICIAN_TOP.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 20)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    YAK_HIDE_ARMOUR_TOP(
            ArmourItemRef.YAK_HIDE_ARMOUR_TOP,
            true,
            new AttackBonus(0, 0, 0, -5, 0),
            new DefenceBonus(25, 20, 15, -2, 25),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.YAK_HIDE_ARMOUR_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    YELLOW_ROBE_TOP(
            ArmourItemRef.YELLOW_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 2, 2, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.YELLOW_ROBE_TOP.getSimilarItems()),
    ZAMORAK_DHIDE_BODY(
            ArmourItemRef.ZAMORAK_DHIDE_BODY,
            true,
            new AttackBonus(0, 0, 0, -15, 30),
            new DefenceBonus(55, 47, 60, 50, 55),
            new SkillsBonus(0, 0, 0, 1),
            6.0,
            ArmourItemRef.ZAMORAK_DHIDE_BODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ZAMORACK_MONK_TOP(
            ArmourItemRef.ZAMORACK_MONK_TOP,
            false,
            new AttackBonus(0, 0, 0, 2, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 3),
            0.907,
            ArmourItemRef.ZAMORACK_MONK_TOP.getSimilarItems()),
    ZAMORAK_PLATEBODY(
            ArmourItemRef.ZAMORAK_PLATEBODY,
            false,
            new AttackBonus(0, 0, 0, -30, -15),
            new DefenceBonus(82, 80, 72, -6, 80),
            new SkillsBonus(0, 0, 0, 1),
            9.979,
            ArmourItemRef.ZAMORAK_PLATEBODY.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(FreeQuest.DRAGON_SLAYER_I)
                    .build()),
    ZAMORAK_ROBE_TOP(
            ArmourItemRef.ZAMORAK_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 6),
            1.8,
            ArmourItemRef.ZAMORAK_ROBE_TOP.getSimilarItems(),
            new RequirementBuilder().hasLevel(PRAYER, 20).build()),
    ZEALOTS_ROBE_TOP(
            ArmourItemRef.ZEALOTS_ROBE_TOP,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 7),
            0.907,
            ArmourItemRef.ZEALOTS_ROBE_TOP.getSimilarItems());

    private final EquipmentSlot slot = EquipmentSlot.CHEST;
    private final GenericItemRef itemRef;
    private final boolean members;
    private final AttackBonus attackBonus;
    private final DefenceBonus defenceBonus;
    private final SkillsBonus skillsBonus;
    private final double weight;
    private final GenericItemRef[] similarItems;
    private final Requirement requirement;

    BodySlotRef(
            GenericItemRef itemRef,
            boolean members,
            AttackBonus attackBonus,
            DefenceBonus defenceBonus,
            SkillsBonus skillsBonus,
            double weight,
            GenericItemRef[] similarItems) {
        this(
                itemRef,
                members,
                attackBonus,
                defenceBonus,
                skillsBonus,
                weight,
                similarItems,
                new RequirementBuilder().build());
    }
}

package com.idlescape.gamedata.items.equipment;

import static org.dreambot.api.methods.skills.Skill.AGILITY;
import static org.dreambot.api.methods.skills.Skill.ATTACK;
import static org.dreambot.api.methods.skills.Skill.DEFENCE;
import static org.dreambot.api.methods.skills.Skill.HITPOINTS;
import static org.dreambot.api.methods.skills.Skill.HUNTER;
import static org.dreambot.api.methods.skills.Skill.MAGIC;
import static org.dreambot.api.methods.skills.Skill.PRAYER;
import static org.dreambot.api.methods.skills.Skill.RANGED;
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
public enum HeadSlotRef implements EquipmentRef {
    _3RD_AGE_FULL_HELMET(
            ArmourItemRef._3RD_AGE_FULL_HELMET,
            true,
            new AttackBonus(0, 0, 0, -5, -2),
            new DefenceBonus(47, 49, 43, -3, 48),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef._3RD_AGE_FULL_HELMET.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 65).build()),
    _3RD_AGE_MAGE_HAT(
            ArmourItemRef._3RD_AGE_MAGE_HAT,
            true,
            new AttackBonus(0, 0, 0, 8, 0),
            new DefenceBonus(0, 0, 0, 8, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.4,
            ArmourItemRef._3RD_AGE_MAGE_HAT.getSimilarItems(),
            new RequirementBuilder()
                    .and()
                    .hasLevel(MAGIC, 65)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    _3RD_AGE_RANGE_COIF(
            ArmourItemRef._3RD_AGE_RANGE_COIF,
            true,
            new AttackBonus(0, 0, 0, -2, 9),
            new DefenceBonus(4, 7, 10, 5, 8),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef._3RD_AGE_RANGE_COIF.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 65)
                    .and()
                    .hasLevel(DEFENCE, 45)
                    .build()),
    ADAMANT_FULL_HELM(
            ArmourItemRef.ADAMANT_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(19, 21, 16, -1, 19),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.ADAMANT_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    ADAMANT_MED_HELM(
            ArmourItemRef.ADAMANT_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(14, 15, 13, -1, 14),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.ADAMANT_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    AHRIMS_HOOD_UNDAMAGED(
            ArmourItemRef.AHRIMS_HOOD_UNDAMAGED,
            true,
            new AttackBonus(0, 0, 0, 6, -2),
            new DefenceBonus(15, 13, 16, 6, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.907,
            ArmourItemRef.AHRIMS_HOOD_UNDAMAGED.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 70)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    ANCESTRAL_HAT(
            ArmourItemRef.ANCESTRAL_HAT,
            true,
            new AttackBonus(0, 0, 0, 8, -2),
            new DefenceBonus(12, 11, 13, 5, 0),
            new SkillsBonus(0, 0, 3, 0),
            0.453,
            ArmourItemRef.ANCESTRAL_HAT.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .hasLevel(DEFENCE, 65)
                    .build()),
    ANCIENT_CEREMONIAL_MASK(
            ArmourItemRef.ANCIENT_CEREMONIAL_MASK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 2),
            0.3,
            ArmourItemRef.ANCIENT_CEREMONIAL_MASK.getSimilarItems()),
    ANCIENT_COIF(
            ArmourItemRef.ANCIENT_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 4, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.9,
            ArmourItemRef.ANCIENT_COIF.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ANCIENT_FULL_HELM(
            ArmourItemRef.ANCIENT_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.ANCIENT_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    ANCIENT_HALO(
            ArmourItemRef.ANCIENT_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.ANCIENT_HALO.getSimilarItems()),
    ANCIENT_MITRE(
            ArmourItemRef.ANCIENT_MITRE,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.3,
            ArmourItemRef.ANCIENT_MITRE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(PRAYER, 40)
                    .build()),
    ARCHER_HELM(
            ArmourItemRef.ARCHER_HELM,
            true,
            new AttackBonus(-5, -5, -5, -5, 6),
            new DefenceBonus(6, 8, 10, 6, 6),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.ARCHER_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 45)
                    .build()),
    ARDOUGNE_KNIGHT_HELM(
            ArmourItemRef.ARDOUGNE_KNIGHT_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.ARDOUGNE_KNIGHT_HELM.getSimilarItems()),
    ARMADYL_COIF(
            ArmourItemRef.ARMADYL_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 4, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.9,
            ArmourItemRef.ARMADYL_COIF.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ARMADYL_FULL_HELM(
            ArmourItemRef.ARMADYL_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.ARMADYL_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    ARMADYL_HALO(
            ArmourItemRef.ARMADYL_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.ARMADYL_HALO.getSimilarItems()),
    ARMADYL_HELMET(
            ArmourItemRef.ARMADYL_HELMET,
            true,
            new AttackBonus(-5, -5, -5, -5, 10),
            new DefenceBonus(6, 8, 10, 10, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.5,
            ArmourItemRef.ARMADYL_HELMET.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    ARMADYL_MITRE(
            ArmourItemRef.ARMADYL_MITRE,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.3,
            ArmourItemRef.ARMADYL_MITRE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(PRAYER, 40)
                    .build()),
    BANDOS_COIF(
            ArmourItemRef.BANDOS_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 4, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.9,
            ArmourItemRef.BANDOS_COIF.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    BANDOS_FULL_HELM(
            ArmourItemRef.BANDOS_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.BANDOS_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    BANDOS_HALO(
            ArmourItemRef.BANDOS_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.BANDOS_HALO.getSimilarItems()),
    BANDOS_MITRE(
            ArmourItemRef.BANDOS_MITRE,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.3,
            ArmourItemRef.BANDOS_MITRE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(PRAYER, 40)
                    .build()),
    BEAR_HEAD(
            ArmourItemRef.BEAR_HEAD,
            true,
            new AttackBonus(0, 0, 0, -3, -3),
            new DefenceBonus(12, 14, 10, 7, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.BEAR_HEAD.getSimilarItems()),
    BERET_MASK(
            ArmourItemRef.BERET_MASK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.BERET_MASK.getSimilarItems()),
    BERSERKER_HELM(
            ArmourItemRef.BERSERKER_HELM,
            true,
            new AttackBonus(0, 0, 0, -5, -5),
            new DefenceBonus(31, 29, 33, 0, 30),
            new SkillsBonus(3, 0, 0, 0),
            2.721,
            ArmourItemRef.BERSERKER_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 45)
                    .build()),
    BLACK_FULL_HELM(
            ArmourItemRef.BLACK_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(12, 13, 10, -1, 12),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.BLACK_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    BLACK_HEADBAND(
            ArmourItemRef.BLACK_HEADBAND,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.04,
            ArmourItemRef.BLACK_HEADBAND.getSimilarItems()),
    BLACK_MASK_I_UNCHARGED_SOUL_WARS(
            ArmourItemRef.BLACK_MASK_I_UNCHARGED_SOUL_WARS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            10.0,
            ArmourItemRef.BLACK_MASK_I_UNCHARGED_SOUL_WARS.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 20)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .and()
                    .combatLevel(40)
                    .build()),
    BLACK_MASK_I_UNCHARGED_NMZ(
            ArmourItemRef.BLACK_MASK_I_UNCHARGED_NMZ,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            10.0,
            ArmourItemRef.BLACK_MASK_I_UNCHARGED_NMZ.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 20)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .and()
                    .combatLevel(40)
                    .build()),
    BLACK_MASK_I_UNCHARGED_EMIR(
            ArmourItemRef.BLACK_MASK_I_UNCHARGED_EMIR,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            10.0,
            ArmourItemRef.BLACK_MASK_I_UNCHARGED_EMIR.getSimilarItems()),
    BLACK_MASK_UNCHARGED(
            ArmourItemRef.BLACK_MASK_UNCHARGED,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            10.0,
            ArmourItemRef.BLACK_MASK_UNCHARGED.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 20)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .and()
                    .combatLevel(40)
                    .build()),
    BLACK_MED_HELM(
            ArmourItemRef.BLACK_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.BLACK_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    BLACKSMITHS_HELM(
            ArmourItemRef.BLACKSMITHS_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.BLACKSMITHS_HELM.getSimilarItems()),
    BLOOD_MOON_HELM(
            ArmourItemRef.BLOOD_MOON_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(20, 31, 34, 7, 29),
            new SkillsBonus(4, 0, 0, 0),
            1.0,
            ArmourItemRef.BLOOD_MOON_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 50)
                    .hasLevel(STRENGTH, 75)
                    .build()),
    BLOODNTAR_SNELM(
            ArmourItemRef.BLOODNTAR_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.BLOODNTAR_SNELM.getSimilarItems()),
    BLOOD_BARK_HELM(
            ArmourItemRef.BLOOD_BARK_HELM,
            true,
            new AttackBonus(0, 0, 0, 5, 0),
            new DefenceBonus(16, 14, 17, 6, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.907,
            ArmourItemRef.BLOOD_BARK_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 60)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    BLUE_HAT(
            ArmourItemRef.BLUE_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.BLUE_HAT.getSimilarItems()),
    BLUE_HEADBAND(
            ArmourItemRef.BLUE_HEADBAND,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.04,
            ArmourItemRef.BLUE_HEADBAND.getSimilarItems()),
    BLUE_MOON_HELM_NEW(
            ArmourItemRef.BLUE_MOON_HELM_NEW,
            true,
            new AttackBonus(0, 0, 0, 6, 0),
            new DefenceBonus(0, 0, 10, 6, 0),
            new SkillsBonus(3, 0, 1, 0),
            0.453,
            ArmourItemRef.BLUE_MOON_HELM_NEW.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 75)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    BLUE_WIZARD_HAT(
            ArmourItemRef.BLUE_WIZARD_HAT,
            false,
            new AttackBonus(0, 0, 0, 2, 0),
            new DefenceBonus(0, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.BLUE_WIZARD_HAT.getSimilarItems()),
    BRASSICA_HALO(
            ArmourItemRef.BRASSICA_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.BRASSICA_HALO.getSimilarItems()),
    BROKEN_BARK_SNELM(
            ArmourItemRef.BROKEN_BARK_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.BROKEN_BARK_SNELM.getSimilarItems()),
    BRONZE_FULL_HELM(
            ArmourItemRef.BRONZE_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(4, 5, 3, -1, 4),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.BRONZE_FULL_HELM.getSimilarItems()),
    BRONZE_MED_HELM(
            ArmourItemRef.BRONZE_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(3, 4, 2, -1, 3),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.BRONZE_MED_HELM.getSimilarItems()),
    BRUISE_BLUE_SNELM(
            ArmourItemRef.BRUISE_BLUE_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.BRUISE_BLUE_SNELM.getSimilarItems()),
    CASTLEWARS_HOOD_SARADOMIN(
            ArmourItemRef.CASTLEWARS_HOOD_SARADOMIN,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 2, 0, 1),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CASTLEWARS_HOOD_SARADOMIN.getSimilarItems()),
    CASTLEWARS_HOOD_ZAMORAK(
            ArmourItemRef.CASTLEWARS_HOOD_ZAMORAK,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 2, 0, 1),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CASTLEWARS_HOOD_ZAMORAK.getSimilarItems()),
    COIF(
            ArmourItemRef.COIF,
            false,
            new AttackBonus(0, 0, 0, -1, 2),
            new DefenceBonus(4, 6, 8, 4, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.COIF.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 20).build()),
    CRAB_HELMET(
            ArmourItemRef.CRAB_HELMET,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(5, 4, 3, -1, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.CRAB_HELMET.getSimilarItems()),
    CREAM_HAT(
            ArmourItemRef.CREAM_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.CREAM_HAT.getSimilarItems()),
    CRYSTAL_HELM(
            ArmourItemRef.CRYSTAL_HELM,
            true,
            new AttackBonus(0, 0, 0, -10, 9),
            new DefenceBonus(12, 8, 14, 10, 18),
            new SkillsBonus(0, 0, 0, 2),
            0.5,
            ArmourItemRef.CRYSTAL_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(AGILITY, 50)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    DAGONHAI_HAT(
            ArmourItemRef.DAGONHAI_HAT,
            true,
            new AttackBonus(0, 0, 0, 5, 0),
            new DefenceBonus(0, 0, 0, 5, 0),
            new SkillsBonus(0, 0, 1, 2),
            0.453,
            ArmourItemRef.DAGONHAI_HAT.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    DARK_CAVALIER(
            ArmourItemRef.DARK_CAVALIER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.001,
            ArmourItemRef.DARK_CAVALIER.getSimilarItems()),
    DARK_INFINITY_HAT(
            ArmourItemRef.DARK_INFINITY_HAT,
            true,
            new AttackBonus(0, 0, 0, 6, 0),
            new DefenceBonus(0, 0, 0, 6, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.453,
            ArmourItemRef.DARK_INFINITY_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 50).hasLevel(DEFENCE, 25).build()),
    DARK_SQUALL_HOOD(
            ArmourItemRef.DARK_SQUALL_HOOD,
            true,
            new AttackBonus(0, 0, 0, 2, 0),
            new DefenceBonus(0, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.25,
            ArmourItemRef.DARK_SQUALL_HOOD.getSimilarItems()),
    DECORATIVE_ARMOUR_MAGIC_HAT(
            ArmourItemRef.DECORATIVE_ARMOUR_MAGIC_HAT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(4, 4, 4, 4, 4),
            new SkillsBonus(0, 0, 0, 0),
            8.164,
            ArmourItemRef.DECORATIVE_ARMOUR_MAGIC_HAT.getSimilarItems()),
    DECORATIVE_FULL_HELM_GOLD(
            ArmourItemRef.DECORATIVE_FULL_HELM_GOLD,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(19, 21, 16, -1, 19),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.DECORATIVE_FULL_HELM_GOLD.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    DECORATIVE_FULL_HELM_RED(
            ArmourItemRef.DECORATIVE_FULL_HELM_RED,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(9, 10, 7, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.DECORATIVE_FULL_HELM_RED.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    DECORATIVE_FULL_HELM_WHITE(
            ArmourItemRef.DECORATIVE_FULL_HELM_WHITE,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(13, 14, 11, -1, 13),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.DECORATIVE_FULL_HELM_WHITE.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    DECORATIVE_HELM_GOLD(
            ArmourItemRef.DECORATIVE_HELM_GOLD,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(14, 15, 13, -1, 14),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.DECORATIVE_HELM_GOLD.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    DECORATIVE_HELM_RED(
            ArmourItemRef.DECORATIVE_HELM_RED,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.DECORATIVE_HELM_RED.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    DECORATIVE_HELM_WHITE(
            ArmourItemRef.DECORATIVE_HELM_WHITE,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(10, 11, 9, -1, 10),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.DECORATIVE_HELM_WHITE.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    DHAROKS_HELM(
            ArmourItemRef.DHAROKS_HELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(45, 48, 44, -1, 51),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.DHAROKS_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    DRAGON_FULL_HELM(
            ArmourItemRef.DRAGON_FULL_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(45, 48, 41, -1, 46),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.DRAGON_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    DRAGON_MED_HELM(
            ArmourItemRef.DRAGON_MED_HELM,
            true,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(33, 35, 32, -1, 34),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.DRAGON_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 60).build()),
    DWARVEN_HELMET(
            ArmourItemRef.DWARVEN_HELMET,
            true,
            new AttackBonus(0, 0, 6, -2, -2),
            new DefenceBonus(27, 28, 31, 5, 24),
            new SkillsBonus(0, 0, 0, 0),
            1.9,
            ArmourItemRef.DWARVEN_HELMET.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 50)
                    .and()
                    .finished(PaidQuest.GRIM_TALES)
                    .build()),
    ECLIPSE_MOON_HELM(
            ArmourItemRef.ECLIPSE_MOON_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, 8),
            new DefenceBonus(2, 3, 14, 10, 4),
            new SkillsBonus(3, 0, 0, 0),
            0.907,
            ArmourItemRef.ECLIPSE_MOON_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 75)
                    .and()
                    .hasLevel(DEFENCE, 50)
                    .build()),
    ELDER_CHAOS_HOOD(
            ArmourItemRef.ELDER_CHAOS_HOOD,
            true,
            new AttackBonus(0, 0, 0, 5, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.18,
            ArmourItemRef.ELDER_CHAOS_HOOD.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).build()),
    ELEMENTAL_HELMET(
            ArmourItemRef.ELEMENTAL_HELMET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.113,
            ArmourItemRef.ELEMENTAL_HELMET.getSimilarItems(),
            new RequirementBuilder().finished(PaidQuest.ELEMENTAL_WORKSHOP_II).build()),
    ELITE_BLACK_FULL_HELM(
            ArmourItemRef.ELITE_BLACK_FULL_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(13, 14, 11, -1, 13),
            new SkillsBonus(0, 0, 0, 4),
            2.721,
            ArmourItemRef.ELITE_BLACK_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    ENCHANTED_HAT(
            ArmourItemRef.ENCHANTED_HAT,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ENCHANTED_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 20).build()),
    FARSEER_HELM(
            ArmourItemRef.FARSEER_HELM,
            true,
            new AttackBonus(-5, -5, -5, 6, -5),
            new DefenceBonus(8, 10, 12, 6, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.FARSEER_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 45)
                    .build()),
    FIGHTER_HAT(
            ArmourItemRef.FIGHTER_HAT,
            true,
            new AttackBonus(5, 5, 5, -7, -7),
            new DefenceBonus(27, 29, 26, -3, 28),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.FIGHTER_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 45).build()),
    FREMENNIK_HAT(
            ArmourItemRef.FREMENNIK_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.FREMENNIK_HAT.getSimilarItems()),
    FREMENNIK_HELM(
            ArmourItemRef.FREMENNIK_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(19, 21, 16, -1, 19),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.FREMENNIK_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    GHOSTLY_HOOD(
            ArmourItemRef.GHOSTLY_HOOD,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.001,
            ArmourItemRef.GHOSTLY_HOOD.getSimilarItems(),
            new RequirementBuilder().finished(MiniQuest.CURSE_OF_THE_EMPTY_LORD).build()),
    GILDED_COIF(
            ArmourItemRef.GILDED_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 4),
            new DefenceBonus(4, 7, 8, 4, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.9,
            ArmourItemRef.GILDED_COIF.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 40).build()),
    GILDED_FULL_HELM(
            ArmourItemRef.GILDED_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.GILDED_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    GILDED_MED_HELM(
            ArmourItemRef.GILDED_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(22, 23, 21, -1, 22),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.GILDED_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    GOLD_HELMET(
            ArmourItemRef.GOLD_HELMET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 10, 20, 0, 10),
            new SkillsBonus(0, 0, 0, 0),
            31.751,
            ArmourItemRef.GOLD_HELMET.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 30).build()),
    GOLDEN_CHEFS_HAT(
            ArmourItemRef.GOLDEN_CHEFS_HAT,
            false,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.GOLDEN_CHEFS_HAT.getSimilarItems()),
    GRAAHK_HEADDRESS(
            ArmourItemRef.GRAAHK_HEADDRESS,
            true,
            new AttackBonus(0, 0, 0, 0, -1),
            new DefenceBonus(4, 5, 3, 0, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.226,
            ArmourItemRef.GRAAHK_HEADDRESS.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 38).build()),
    GRACEFUL_HOOD_ADVENTURER(
            ArmourItemRef.GRACEFUL_HOOD_ADVENTURER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_ADVENTURER.getSimilarItems()),
    GRACEFUL_HOOD_AGILITY_ARENA(
            ArmourItemRef.GRACEFUL_HOOD_AGILITY_ARENA,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_AGILITY_ARENA.getSimilarItems()),
    GRACEFUL_HOOD_ARCEUUS_WORN(
            ArmourItemRef.GRACEFUL_HOOD_ARCEUUS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_ARCEUUS_WORN.getSimilarItems()),
    GRACEFUL_HOOD_HALLOWED(
            ArmourItemRef.GRACEFUL_HOOD_HALLOWED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_HALLOWED.getSimilarItems()),
    GRACEFUL_HOOD_HOSIDIUS_WORN(
            ArmourItemRef.GRACEFUL_HOOD_HOSIDIUS_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_HOSIDIUS_WORN.getSimilarItems()),
    GRACEFUL_HOOD_KOUREND_WORN(
            ArmourItemRef.GRACEFUL_HOOD_KOUREND_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_KOUREND_WORN.getSimilarItems()),
    GRACEFUL_HOOD_LOVAKENGJ_WORN(
            ArmourItemRef.GRACEFUL_HOOD_LOVAKENGJ_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_LOVAKENGJ_WORN.getSimilarItems()),
    GRACEFUL_HOOD_PISCARILIUS(
            ArmourItemRef.GRACEFUL_HOOD_PISCARILIUS,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_PISCARILIUS.getSimilarItems()),
    GRACEFUL_HOOD_SHAYZIEN_WORN(
            ArmourItemRef.GRACEFUL_HOOD_SHAYZIEN_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_SHAYZIEN_WORN.getSimilarItems()),
    GRACEFUL_HOOD_TRAILBLAZER(
            ArmourItemRef.GRACEFUL_HOOD_TRAILBLAZER,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_TRAILBLAZER.getSimilarItems()),
    GRACEFUL_HOOD_VARLAMORE_WORN(
            ArmourItemRef.GRACEFUL_HOOD_VARLAMORE_WORN,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_VARLAMORE_WORN.getSimilarItems()),
    GRACEFUL_HOOD_EQUIPPED(
            ArmourItemRef.GRACEFUL_HOOD_EQUIPPED,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            -3.0,
            ArmourItemRef.GRACEFUL_HOOD_EQUIPPED.getSimilarItems()),
    GRANITE_HELM(
            ArmourItemRef.GRANITE_HELM,
            true,
            new AttackBonus(0, 0, 0, -9, -7),
            new DefenceBonus(31, 33, 29, -1, 39),
            new SkillsBonus(0, 0, 0, 0),
            4.535,
            ArmourItemRef.GRANITE_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 50)
                    .hasLevel(STRENGTH, 50)
                    .build()),
    GREEN_HAT(
            ArmourItemRef.GREEN_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.GREEN_HAT.getSimilarItems()),
    GREY_HAT(
            ArmourItemRef.GREY_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.GREY_HAT.getSimilarItems()),
    GROUP_IRONMAN_HELM(
            ArmourItemRef.GROUP_IRONMAN_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.GROUP_IRONMAN_HELM.getSimilarItems()),
    GROUP_IRONMAN_HELM_UNRANKED(
            ArmourItemRef.GROUP_IRONMAN_HELM_UNRANKED,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.GROUP_IRONMAN_HELM_UNRANKED.getSimilarItems()),
    GUTHANS_HELM(
            ArmourItemRef.GUTHANS_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(55, 58, 54, -1, 62),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.GUTHANS_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    GUTHIX_COIF(
            ArmourItemRef.GUTHIX_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 4, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.9,
            ArmourItemRef.GUTHIX_COIF.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    GUTHIX_FULL_HELM(
            ArmourItemRef.GUTHIX_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.GUTHIX_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    GUTHIX_HALO(
            ArmourItemRef.GUTHIX_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.GUTHIX_HALO.getSimilarItems()),
    GUTHIX_MITRE(
            ArmourItemRef.GUTHIX_MITRE,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.3,
            ArmourItemRef.GUTHIX_MITRE.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(PRAYER, 40).build()),
    HAM_HOOD(
            ArmourItemRef.HAM_HOOD,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 1, 2, 0, 1),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.HAM_HOOD.getSimilarItems()),
    HARDCORE_GROUP_IRONMAN_HELM(
            ArmourItemRef.HARDCORE_GROUP_IRONMAN_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.HARDCORE_GROUP_IRONMAN_HELM.getSimilarItems()),
    HARDCORE_IRONMAN_HELM(
            ArmourItemRef.HARDCORE_IRONMAN_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.HARDCORE_IRONMAN_HELM.getSimilarItems()),
    HEALER_HAT(
            ArmourItemRef.HEALER_HAT,
            true,
            new AttackBonus(-5, -5, -5, 6, -5),
            new DefenceBonus(6, 8, 10, 7, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.HEALER_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 45).build()),
    HELM_OF_NEITIZNOT(
            ArmourItemRef.HELM_OF_NEITIZNOT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(31, 29, 34, 3, 30),
            new SkillsBonus(3, 0, 0, 3),
            2.267,
            ArmourItemRef.HELM_OF_NEITIZNOT.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_ISLES)
                    .and()
                    .hasLevel(DEFENCE, 55)
                    .build()),
    HELMET_OF_THE_MOON(
            ArmourItemRef.HELMET_OF_THE_MOON,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(6, 7, 5, 3, 6),
            new SkillsBonus(0, 0, 0, 3),
            0.35,
            ArmourItemRef.HELMET_OF_THE_MOON.getSimilarItems()),
    HOOD_OF_DARKNESS(
            ArmourItemRef.HOOD_OF_DARKNESS,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.HOOD_OF_DARKNESS.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 20).build()),
    HOSIDIUS_HOOD(
            ArmourItemRef.HOSIDIUS_HOOD,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.1,
            ArmourItemRef.HOSIDIUS_HOOD.getSimilarItems()),
    HUEYCOATL_HIDE_COIF(
            ArmourItemRef.HUEYCOATL_HIDE_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 5, 8),
            new SkillsBonus(0, 0, 0, 2),
            0.9,
            ArmourItemRef.HUEYCOATL_HIDE_COIF.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    INFINITY_HAT(
            ArmourItemRef.INFINITY_HAT,
            true,
            new AttackBonus(0, 0, 0, 6, 0),
            new DefenceBonus(0, 0, 0, 6, 0),
            new SkillsBonus(0, 0, 1, 0),
            0.453,
            ArmourItemRef.INFINITY_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 50).hasLevel(DEFENCE, 25).build()),
    INITIATE_SALLET(
            ArmourItemRef.INITIATE_SALLET,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(13, 14, 11, -1, 13),
            new SkillsBonus(0, 0, 0, 3),
            2.267,
            ArmourItemRef.INITIATE_SALLET.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.RECRUITMENT_DRIVE)
                    .and()
                    .hasLevel(DEFENCE, 20)
                    .and()
                    .hasLevel(PRAYER, 10)
                    .build()),
    INQUISITORS_GREAT_HELM(
            ArmourItemRef.INQUISITORS_GREAT_HELM,
            true,
            new AttackBonus(-2, -2, 8, -5, -5),
            new DefenceBonus(19, 10, 21, 0, 12),
            new SkillsBonus(4, 0, 0, 1),
            2.721,
            ArmourItemRef.INQUISITORS_GREAT_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(STRENGTH, 70)
                    .hasLevel(DEFENCE, 30)
                    .build()),
    IRON_FULL_HELM(
            ArmourItemRef.IRON_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.IRON_FULL_HELM.getSimilarItems()),
    IRON_MED_HELM(
            ArmourItemRef.IRON_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(4, 5, 3, -1, 4),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.IRON_MED_HELM.getSimilarItems()),
    IRONMAN_HELM(
            ArmourItemRef.IRONMAN_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.IRONMAN_HELM.getSimilarItems()),
    JUSTICIAR_FACEGUARD(
            ArmourItemRef.JUSTICIAR_FACEGUARD,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(60, 63, 59, -6, 67),
            new SkillsBonus(0, 0, 0, 2),
            2.721,
            ArmourItemRef.JUSTICIAR_FACEGUARD.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 75).build()),
    KANDARIN_HEADGEAR_1(
            ArmourItemRef.KANDARIN_HEADGEAR_1,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(4, 5, 3, -1, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.KANDARIN_HEADGEAR_1.getSimilarItems()),
    KANDARIN_HEADGEAR_2(
            ArmourItemRef.KANDARIN_HEADGEAR_2,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.KANDARIN_HEADGEAR_2.getSimilarItems()),
    KANDARIN_HEADGEAR_3(
            ArmourItemRef.KANDARIN_HEADGEAR_3,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.KANDARIN_HEADGEAR_3.getSimilarItems()),
    KANDARIN_HEADGEAR_4(
            ArmourItemRef.KANDARIN_HEADGEAR_4,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(10, 11, 9, -1, 10),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.KANDARIN_HEADGEAR_4.getSimilarItems()),
    KARILS_COIF(
            ArmourItemRef.KARILS_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(6, 9, 12, 6, 10),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.KARILS_COIF.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 70).build()),
    KHAZARD_HELMET(
            ArmourItemRef.KHAZARD_HELMET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(4, 5, 3, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.KHAZARD_HELMET.getSimilarItems()),
    KYATT_HAT(
            ArmourItemRef.KYATT_HAT,
            true,
            new AttackBonus(0, 0, 0, 0, -1),
            new DefenceBonus(4, 5, 3, 0, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.226,
            ArmourItemRef.KYATT_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 52).build()),
    LARUPIA_HAT(
            ArmourItemRef.LARUPIA_HAT,
            true,
            new AttackBonus(0, 0, 0, 0, -1),
            new DefenceBonus(4, 5, 3, 0, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.226,
            ArmourItemRef.LARUPIA_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(HUNTER, 28).build()),
    LEATHER_COWL(
            ArmourItemRef.LEATHER_COWL,
            false,
            new AttackBonus(0, 0, 0, 0, 1),
            new DefenceBonus(2, 3, 4, 2, 3),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.LEATHER_COWL.getSimilarItems()),
    LOVAKENGJ_HOOD(
            ArmourItemRef.LOVAKENGJ_HOOD,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.1,
            ArmourItemRef.LOVAKENGJ_HOOD.getSimilarItems()),
    LUNAR_HELM(
            ArmourItemRef.LUNAR_HELM,
            true,
            new AttackBonus(0, 0, 0, 3, -2),
            new DefenceBonus(8, 7, 10, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.LUNAR_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .started(PaidQuest.LUNAR_DIPLOMACY)
                    .and()
                    .hasLevel(MAGIC, 65)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    MASK_OF_RANUL(
            ArmourItemRef.MASK_OF_RANUL,
            true,
            new AttackBonus(0, 0, 0, 2, 0),
            new DefenceBonus(0, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.35,
            ArmourItemRef.MASK_OF_RANUL.getSimilarItems()),
    MASORI_MASK(
            ArmourItemRef.MASORI_MASK,
            true,
            new AttackBonus(0, 0, 0, -1, 12),
            new DefenceBonus(3, 4, 3, 6, 4),
            new SkillsBonus(0, 2, 0, 0),
            1.0,
            ArmourItemRef.MASORI_MASK.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 80)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    MASORI_MASK_F(
            ArmourItemRef.MASORI_MASK_F,
            true,
            new AttackBonus(0, 0, 0, -1, 12),
            new DefenceBonus(8, 10, 12, 12, 9),
            new SkillsBonus(0, 2, 0, 1),
            1.5,
            ArmourItemRef.MASORI_MASK_F.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 80)
                    .and()
                    .hasLevel(DEFENCE, 80)
                    .build()),
    MIND_HELMET(
            ArmourItemRef.MIND_HELMET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 6, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.113,
            ArmourItemRef.MIND_HELMET.getSimilarItems(),
            new RequirementBuilder().started(PaidQuest.ELEMENTAL_WORKSHOP_II).build()),
    MINING_HELMET(
            ArmourItemRef.MINING_HELMET,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(4, 5, 3, -1, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.MINING_HELMET.getSimilarItems()),
    MITHRIL_FULL_HELM(
            ArmourItemRef.MITHRIL_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(13, 14, 11, -1, 13),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.MITHRIL_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MITHRIL_FULL_HELM_G(
            ArmourItemRef.MITHRIL_FULL_HELM_G,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(13, 14, 11, -1, 13),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.MITHRIL_FULL_HELM_G.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MITHRIL_FULL_HELM_T(
            ArmourItemRef.MITHRIL_FULL_HELM_T,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(13, 14, 11, -1, 13),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.MITHRIL_FULL_HELM_T.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MITHRIL_MED_HELM(
            ArmourItemRef.MITHRIL_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(10, 11, 9, -1, 10),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.MITHRIL_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    MOONCLAN_HAT(
            ArmourItemRef.MOONCLAN_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, -5),
            new DefenceBonus(3, 3, 3, 3, -5),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.MOONCLAN_HAT.getSimilarItems()),
    MOONCLAN_HELM(
            ArmourItemRef.MOONCLAN_HELM,
            true,
            new AttackBonus(0, 0, 0, 3, -5),
            new DefenceBonus(3, 3, 3, 3, -5),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.MOONCLAN_HELM.getSimilarItems()),
    MYRE_SNELM(
            ArmourItemRef.MYRE_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.MYRE_SNELM.getSimilarItems()),
    MYSTIC_HAT(
            ArmourItemRef.MYSTIC_HAT,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.MYSTIC_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(DEFENCE, 20).build()),
    NEITIZNOT_FACEGUARD(
            ArmourItemRef.NEITIZNOT_FACEGUARD,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(36, 34, 38, 3, 34),
            new SkillsBonus(6, 0, 0, 3),
            2.721,
            ArmourItemRef.NEITIZNOT_FACEGUARD.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_EXILES)
                    .and()
                    .hasLevel(DEFENCE, 70)
                    .build()),
    OATHPLATE_HELM(
            ArmourItemRef.OATHPLATE_HELM,
            true,
            new AttackBonus(0, 10, 0, -2, -7),
            new DefenceBonus(50, 72, 45, 0, 50),
            new SkillsBonus(6, 0, 0, 0),
            2.721,
            ArmourItemRef.OATHPLATE_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 78).build()),
    OBSIDIAN_HELMET(
            ArmourItemRef.OBSIDIAN_HELMET,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(25, 23, 26, 0, 24),
            new SkillsBonus(3, 0, 0, 0),
            3.628,
            ArmourItemRef.OBSIDIAN_HELMET.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 60).build()),
    OCHRE_SNELM(
            ArmourItemRef.OCHRE_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.OCHRE_SNELM.getSimilarItems()),
    PINK_HAT(
            ArmourItemRef.PINK_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.PINK_HAT.getSimilarItems()),
    POINTED_BLOODNTAR_SNELM(
            ArmourItemRef.POINTED_BLOODNTAR_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.POINTED_BLOODNTAR_SNELM.getSimilarItems()),
    POINTED_BRUISE_BLUE_SNELM(
            ArmourItemRef.POINTED_BRUISE_BLUE_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.POINTED_BRUISE_BLUE_SNELM.getSimilarItems()),
    POINTED_MYRE_SNELM(
            ArmourItemRef.POINTED_MYRE_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.POINTED_MYRE_SNELM.getSimilarItems()),
    POINTED_OCHRE_SNELM(
            ArmourItemRef.POINTED_OCHRE_SNELM,
            true,
            new AttackBonus(0, 0, 0, -3, -1),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.POINTED_OCHRE_SNELM.getSimilarItems()),
    POTATO_SACK(
            ArmourItemRef.POTATO_SACK,
            true,
            new AttackBonus(-1, -1, -1, -1, -1),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.3,
            ArmourItemRef.POTATO_SACK.getSimilarItems()),
    PROSELYTE_SALLET(
            ArmourItemRef.PROSELYTE_SALLET,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(19, 21, 16, -1, 19),
            new SkillsBonus(0, 0, 0, 4),
            2.267,
            ArmourItemRef.PROSELYTE_SALLET.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_SLUG_MENACE)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .and()
                    .hasLevel(PRAYER, 20)
                    .build()),
    PURPLE_HAT(
            ArmourItemRef.PURPLE_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.PURPLE_HAT.getSimilarItems()),
    RADIANT_OATHPLATE_HELM(
            ArmourItemRef.RADIANT_OATHPLATE_HELM,
            true,
            new AttackBonus(0, 10, 0, -2, -7),
            new DefenceBonus(50, 72, 45, 0, 50),
            new SkillsBonus(6, 0, 0, 0),
            2.721,
            ArmourItemRef.RADIANT_OATHPLATE_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 78).build()),
    RAM_SKULL_HELM(
            ArmourItemRef.RAM_SKULL_HELM,
            true,
            new AttackBonus(0, 0, 0, 0, -2),
            new DefenceBonus(19, 21, 16, 0, 19),
            new SkillsBonus(0, 0, 0, 0),
            3.175,
            ArmourItemRef.RAM_SKULL_HELM.getSimilarItems()),
    RANGER_HAT(
            ArmourItemRef.RANGER_HAT,
            true,
            new AttackBonus(-5, -5, -5, -5, 6),
            new DefenceBonus(7, 10, 11, 5, 8),
            new SkillsBonus(0, 0, 0, 0),
            2.0,
            ArmourItemRef.RANGER_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 45).build()),
    RED_HAT(
            ArmourItemRef.RED_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.RED_HAT.getSimilarItems()),
    REINFORCED_GOGGLES(
            ArmourItemRef.REINFORCED_GOGGLES,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.01,
            ArmourItemRef.REINFORCED_GOGGLES.getSimilarItems()),
    ROBIN_HOOD_HAT(
            ArmourItemRef.ROBIN_HOOD_HAT,
            true,
            new AttackBonus(0, 0, 0, -10, 8),
            new DefenceBonus(4, 6, 8, 4, 4),
            new SkillsBonus(0, 0, 0, 0),
            0.283,
            ArmourItemRef.ROBIN_HOOD_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 40).build()),
    ROCKSHELL_HELM(
            ArmourItemRef.ROCKSHELL_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.ROCKSHELL_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    ROGUE_MASK(
            ArmourItemRef.ROGUE_MASK,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(5, 5, 5, 5, 5),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.ROGUE_MASK.getSimilarItems()),
    RUNE_FULL_HELM(
            ArmourItemRef.RUNE_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.RUNE_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    RUNE_MED_HELM(
            ArmourItemRef.RUNE_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(22, 23, 21, -1, 22),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.RUNE_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    RUNNER_HAT(
            ArmourItemRef.RUNNER_HAT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(30, 32, 27, 1, 30),
            new SkillsBonus(0, 0, 0, 0),
            1.0,
            ArmourItemRef.RUNNER_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 45).build()),
    SAMURAI_KASA(
            ArmourItemRef.SAMURAI_KASA,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(16, 17, 15, 4, 16),
            new SkillsBonus(0, 0, 0, 0),
            0.6,
            ArmourItemRef.SAMURAI_KASA.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 35).build()),
    SANGUINE_TORVA_FULL_HELM(
            ArmourItemRef.SANGUINE_TORVA_FULL_HELM,
            true,
            new AttackBonus(0, 0, 0, -5, -5),
            new DefenceBonus(59, 60, 62, -2, 57),
            new SkillsBonus(8, 0, 0, 1),
            2.721,
            ArmourItemRef.SANGUINE_TORVA_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 80).build()),
    SARADOMIN_COIF(
            ArmourItemRef.SARADOMIN_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 4, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.9,
            ArmourItemRef.SARADOMIN_COIF.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 70)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SARADOMIN_FULL_HELM(
            ArmourItemRef.SARADOMIN_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.SARADOMIN_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    SARADOMIN_HALO(
            ArmourItemRef.SARADOMIN_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.SARADOMIN_HALO.getSimilarItems()),
    SARADOMIN_MITRE(
            ArmourItemRef.SARADOMIN_MITRE,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.3,
            ArmourItemRef.SARADOMIN_MITRE.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 40).hasLevel(PRAYER, 40).build()),
    SEREN_HALO(
            ArmourItemRef.SEREN_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.SEREN_HALO.getSimilarItems()),
    SERPENTINE_HELM_CHARGED(
            ArmourItemRef.SERPENTINE_HELM_CHARGED,
            true,
            new AttackBonus(0, 0, 0, -5, -5),
            new DefenceBonus(52, 55, 58, 0, 50),
            new SkillsBonus(5, 0, 0, 0),
            0.9,
            ArmourItemRef.SERPENTINE_HELM_CHARGED.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 75).build()),
    SHAMAN_MASK(
            ArmourItemRef.SHAMAN_MASK,
            false,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SHAMAN_MASK.getSimilarItems()),
    SHAYZIEN_HELM_1(
            ArmourItemRef.SHAYZIEN_HELM_1,
            true,
            new AttackBonus(0, 0, 0, -5, -2),
            new DefenceBonus(3, 5, 4, -1, 5),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SHAYZIEN_HELM_1.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_HELM_2(
            ArmourItemRef.SHAYZIEN_HELM_2,
            true,
            new AttackBonus(0, 0, 0, -5, -2),
            new DefenceBonus(5, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SHAYZIEN_HELM_2.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_HELM_3(
            ArmourItemRef.SHAYZIEN_HELM_3,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(7, 10, 8, -2, 9),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SHAYZIEN_HELM_3.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_HELM_4(
            ArmourItemRef.SHAYZIEN_HELM_4,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(8, 12, 10, -2, 11),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SHAYZIEN_HELM_4.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SHAYZIEN_HELM(
            ArmourItemRef.SHAYZIEN_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, 4),
            new DefenceBonus(10, 14, 12, -2, 13),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SHAYZIEN_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 20).build()),
    SILLY_JESTER_HAT(
            ArmourItemRef.SILLY_JESTER_HAT,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 5, -5),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SILLY_JESTER_HAT.getSimilarItems()),
    SKELETAL_HELM(
            ArmourItemRef.SKELETAL_HELM,
            true,
            new AttackBonus(0, 0, 0, 2, -2),
            new DefenceBonus(10, 9, 11, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            1.36,
            ArmourItemRef.SKELETAL_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SLAYER_HELM(
            ArmourItemRef.SLAYER_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.SLAYER_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    SLAYER_HELM_I(
            ArmourItemRef.SLAYER_HELM_I,
            true,
            new AttackBonus(0, 0, 0, 3, 3),
            new DefenceBonus(30, 32, 27, 10, 30),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.SLAYER_HELM_I.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 10).build()),
    SNAKESKIN_BANDANA(
            ArmourItemRef.SNAKESKIN_BANDANA,
            true,
            new AttackBonus(0, 0, 0, -5, 4),
            new DefenceBonus(2, 4, 4, 2, 2),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.SNAKESKIN_BANDANA.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 30)
                    .and()
                    .hasLevel(DEFENCE, 30)
                    .build()),
    SPINED_HELM(
            ArmourItemRef.SPINED_HELM,
            true,
            new AttackBonus(-6, -6, -6, -6, 6),
            new DefenceBonus(6, 6, 6, 6, 0),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.SPINED_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(RANGED, 40)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .and()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .build()),
    SPINY_HELMET(
            ArmourItemRef.SPINY_HELMET,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(9, 10, 7, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            2.267,
            ArmourItemRef.SPINY_HELMET.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    SPLITBARK_HELM(
            ArmourItemRef.SPLITBARK_HELM,
            true,
            new AttackBonus(0, 0, 0, 3, -2),
            new DefenceBonus(10, 9, 11, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.SPLITBARK_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    STEEL_FULL_HELM(
            ArmourItemRef.STEEL_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(9, 10, 7, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.STEEL_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    STEEL_MED_HELM(
            ArmourItemRef.STEEL_MED_HELM,
            false,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(7, 8, 6, -1, 7),
            new SkillsBonus(0, 0, 0, 0),
            1.814,
            ArmourItemRef.STEEL_MED_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    SUNFIRE_FANATIC_HELM(
            ArmourItemRef.SUNFIRE_FANATIC_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 6),
            2.267,
            ArmourItemRef.SUNFIRE_FANATIC_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(PRAYER, 60)
                    .and()
                    .hasLevel(DEFENCE, 40)
                    .build()),
    SWAMP_BARK_HELM(
            ArmourItemRef.SWAMP_BARK_HELM,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(13, 11, 14, 5, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.SWAMP_BARK_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 50).hasLevel(DEFENCE, 50).build()),
    TEAL_HAT(
            ArmourItemRef.TEAL_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.TEAL_HAT.getSimilarItems()),
    TORAGS_HELM(
            ArmourItemRef.TORAGS_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(55, 58, 54, -1, 62),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.TORAGS_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    TORVA_FULL_HELM(
            ArmourItemRef.TORVA_FULL_HELM,
            true,
            new AttackBonus(0, 0, 0, -5, -5),
            new DefenceBonus(59, 60, 62, -2, 57),
            new SkillsBonus(8, 0, 0, 1),
            2.721,
            ArmourItemRef.TORVA_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 80).build()),
    TURQUOISE_HAT(
            ArmourItemRef.TURQUOISE_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.TURQUOISE_HAT.getSimilarItems()),
    TWISTED_ANCESTRAL_HAT(
            ArmourItemRef.TWISTED_ANCESTRAL_HAT,
            true,
            new AttackBonus(0, 0, 0, 8, -2),
            new DefenceBonus(12, 11, 13, 5, 0),
            new SkillsBonus(0, 0, 3, 0),
            0.453,
            ArmourItemRef.TWISTED_ANCESTRAL_HAT.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 75).hasLevel(DEFENCE, 65).build()),
    TYRAS_HELM(
            ArmourItemRef.TYRAS_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(9, 10, 7, -1, 9),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.TYRAS_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 5).build()),
    ULTIMATE_IRONMAN_HELM(
            ArmourItemRef.ULTIMATE_IRONMAN_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(6, 7, 5, -1, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.907,
            ArmourItemRef.ULTIMATE_IRONMAN_HELM.getSimilarItems()),
    VERACS_HELM(
            ArmourItemRef.VERACS_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -2),
            new DefenceBonus(55, 58, 54, 0, 56),
            new SkillsBonus(0, 0, 0, 3),
            1.36,
            ArmourItemRef.VERACS_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 70).build()),
    VIRTUS_MASK(
            ArmourItemRef.VIRTUS_MASK,
            true,
            new AttackBonus(0, 0, 0, 8, -3),
            new DefenceBonus(15, 14, 16, 6, 0),
            new SkillsBonus(0, 0, 2, 1),
            1.206,
            ArmourItemRef.VIRTUS_MASK.getSimilarItems(),
            new RequirementBuilder().hasLevel(MAGIC, 78).hasLevel(DEFENCE, 75).build()),
    VOID_MAGE_HELM(
            ArmourItemRef.VOID_MAGE_HELM,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(6, 6, 6, 6, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.VOID_MAGE_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(ATTACK, 42)
                    .hasLevel(STRENGTH, 42)
                    .hasLevel(DEFENCE, 42)
                    .hasLevel(HITPOINTS, 42)
                    .hasLevel(RANGED, 42)
                    .hasLevel(MAGIC, 42)
                    .hasLevel(PRAYER, 22)
                    .build()),
    VOID_MELEE_HELM(
            ArmourItemRef.VOID_MELEE_HELM,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(6, 6, 6, 6, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.VOID_MELEE_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(ATTACK, 42)
                    .hasLevel(STRENGTH, 42)
                    .hasLevel(DEFENCE, 42)
                    .hasLevel(HITPOINTS, 42)
                    .hasLevel(RANGED, 42)
                    .hasLevel(MAGIC, 42)
                    .hasLevel(PRAYER, 22)
                    .build()),
    VOID_RANGER_HELM(
            ArmourItemRef.VOID_RANGER_HELM,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(6, 6, 6, 6, 6),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.VOID_RANGER_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(ATTACK, 42)
                    .hasLevel(STRENGTH, 42)
                    .hasLevel(DEFENCE, 42)
                    .hasLevel(HITPOINTS, 42)
                    .hasLevel(RANGED, 42)
                    .hasLevel(MAGIC, 42)
                    .hasLevel(PRAYER, 22)
                    .build()),
    WARRIOR_HELM(
            ArmourItemRef.WARRIOR_HELM,
            true,
            new AttackBonus(0, 5, 0, -5, -5),
            new DefenceBonus(31, 33, 29, 0, 30),
            new SkillsBonus(0, 0, 0, 0),
            2.721,
            ArmourItemRef.WARRIOR_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.THE_FREMENNIK_TRIALS)
                    .and()
                    .hasLevel(DEFENCE, 45)
                    .build()),
    WHITE_FULL_HELM(
            ArmourItemRef.WHITE_FULL_HELM,
            true,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(12, 13, 10, -1, 12),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.WHITE_FULL_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.WANTED)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    WHITE_MED_HELM(
            ArmourItemRef.WHITE_MED_HELM,
            true,
            new AttackBonus(0, 0, 0, -3, 0),
            new DefenceBonus(9, 10, 8, -1, 9),
            new SkillsBonus(0, 0, 0, 1),
            1.814,
            ArmourItemRef.WHITE_MED_HELM.getSimilarItems(),
            new RequirementBuilder()
                    .finished(PaidQuest.WANTED)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    WIZARD_HAT_BLACK(
            ArmourItemRef.WIZARD_HAT_BLACK,
            false,
            new AttackBonus(0, 0, 0, 2, 0),
            new DefenceBonus(0, 0, 0, 2, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.WIZARD_HAT_BLACK.getSimilarItems()),
    XERICIAN_HAT(
            ArmourItemRef.XERICIAN_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.2,
            ArmourItemRef.XERICIAN_HAT.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 20)
                    .and()
                    .hasLevel(DEFENCE, 10)
                    .build()),
    YELLOW_HAT(
            ArmourItemRef.YELLOW_HAT,
            true,
            new AttackBonus(0, 0, 0, 3, 0),
            new DefenceBonus(0, 0, 0, 3, 0),
            new SkillsBonus(0, 0, 0, 0),
            0.453,
            ArmourItemRef.YELLOW_HAT.getSimilarItems()),
    ZAMORAK_COIF(
            ArmourItemRef.ZAMORAK_COIF,
            true,
            new AttackBonus(0, 0, 0, -1, 7),
            new DefenceBonus(4, 7, 10, 4, 8),
            new SkillsBonus(0, 0, 0, 1),
            0.9,
            ArmourItemRef.ZAMORAK_COIF.getSimilarItems(),
            new RequirementBuilder().hasLevel(RANGED, 70).hasLevel(DEFENCE, 40).build()),
    ZAMORAK_FULL_HELM(
            ArmourItemRef.ZAMORAK_FULL_HELM,
            false,
            new AttackBonus(0, 0, 0, -6, -3),
            new DefenceBonus(30, 32, 27, -1, 30),
            new SkillsBonus(0, 0, 0, 1),
            2.721,
            ArmourItemRef.ZAMORAK_FULL_HELM.getSimilarItems(),
            new RequirementBuilder().hasLevel(DEFENCE, 40).build()),
    ZAMORAK_HALO(
            ArmourItemRef.ZAMORAK_HALO,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(11, 12, 10, 11, -1),
            new SkillsBonus(0, 0, 0, 3),
            0.3,
            ArmourItemRef.ZAMORAK_HALO.getSimilarItems()),
    ZAMORAK_MITRE(
            ArmourItemRef.ZAMORAK_MITRE,
            true,
            new AttackBonus(0, 0, 0, 4, 0),
            new DefenceBonus(0, 0, 0, 4, 0),
            new SkillsBonus(0, 0, 0, 5),
            0.3,
            ArmourItemRef.ZAMORAK_MITRE.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(MAGIC, 40)
                    .and()
                    .hasLevel(PRAYER, 40)
                    .build()),
    ZEALOT_HELM(
            ArmourItemRef.ZEALOT_HELM,
            true,
            new AttackBonus(0, 0, 0, 0, 0),
            new DefenceBonus(0, 0, 0, 0, 0),
            new SkillsBonus(0, 0, 0, 1),
            2.267,
            ArmourItemRef.ZEALOT_HELM.getSimilarItems()),
    ZOMBIE_HELMET(
            ArmourItemRef.ZOMBIE_HELMET,
            true,
            new AttackBonus(0, 0, 8, -4, -2),
            new DefenceBonus(30, 32, 38, 0, 30),
            new SkillsBonus(2, 0, 0, 0),
            2.721,
            ArmourItemRef.ZOMBIE_HELMET.getSimilarItems(),
            new RequirementBuilder()
                    .hasLevel(DEFENCE, 50)
                    .and()
                    .hasLevel(STRENGTH, 50)
                    .build());

    private final EquipmentSlot slot = EquipmentSlot.HAT;
    private final GenericItemRef itemRef;
    private final boolean members;
    private final AttackBonus attackBonus;
    private final DefenceBonus defenceBonus;
    private final SkillsBonus skillsBonus;
    private final double weight;
    private final GenericItemRef[] similarItems;
    private final Requirement requirement;

    HeadSlotRef(
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
                new RequirementBuilder().alwaysTrue().build());
    }
}

package org.dreambot.controllers.bis;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.dreambot.gamedata.combat.AttackBonus;
import org.dreambot.gamedata.combat.DefenceBonus;
import org.dreambot.gamedata.combat.SkillsBonus;
import org.dreambot.gamedata.items.GenericItemRef;
import org.dreambot.gamedata.items.equipment.EquipmentRef;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BestInSlotControllerFallbackTest {

    private final BestInSlotController controller = new BestInSlotController();

    @Test
    void getHighestDamageForMagicDamageUsesAttackMagic() {
        EquipmentRef equipment = mockEquipment(1001, new AttackBonus(0, 0, 0, 37, 0), new SkillsBonus(0, 0, 5, 0));

        int score = controller.getHighestDamage(
                equipment, new BisRequest(BisStat.MAGIC_DAMAGE, HandMode.ONE_HANDED, false));

        assertEquals(37, score);
    }

    @Test
    void getHighestDamageForRangedStrengthUsesAttackRanged() {
        EquipmentRef equipment = mockEquipment(1002, new AttackBonus(0, 0, 0, 0, 54), new SkillsBonus(0, 8, 0, 0));

        int score = controller.getHighestDamage(
                equipment, new BisRequest(BisStat.RANGED_STRENGTH, HandMode.ONE_HANDED, false));

        assertEquals(54, score);
    }

    @Test
    void getHighestDamageForMeleeOffenceUsesMeleeStrength() {
        EquipmentRef equipment = mockEquipment(1003, new AttackBonus(15, 0, 0, 0, 0), new SkillsBonus(31, 0, 0, 0));

        int score = controller.getHighestDamage(
                equipment, new BisRequest(BisStat.ATTACK_SLASH, HandMode.ONE_HANDED, false));

        assertEquals(31, score);
    }

    @Test
    void getHighestDamageForAttackMagicUsesMagicDamageBonus() {
        EquipmentRef equipment = mockEquipment(1004, new AttackBonus(0, 0, 0, 28, 0), new SkillsBonus(0, 0, 9, 0));

        int score = controller.getHighestDamage(
                equipment, new BisRequest(BisStat.ATTACK_MAGIC, HandMode.ONE_HANDED, false));

        assertEquals(9, score);
    }

    @Test
    void rankSlotItemsUsesGetHighestDamageAsThirdFallback() {
        EquipmentRef higherDamage = mockEquipment(2001, new AttackBonus(0, 0, 0, 10, 0), new SkillsBonus(0, 0, 5, 0));
        EquipmentRef lowerDamage = mockEquipment(2002, new AttackBonus(2, 0, 0, 8, 0), new SkillsBonus(0, 0, 5, 0));

        BisRequest request = new BisRequest(BisStat.MAGIC_DAMAGE, HandMode.ONE_HANDED, false);
        List<EquipmentRef> ranked = controller.rankSlotItems(Arrays.asList(lowerDamage, higherDamage), request);

        assertEquals(higherDamage, ranked.get(0));
    }

    private EquipmentRef mockEquipment(int id, AttackBonus attackBonus, SkillsBonus skillsBonus) {
        EquipmentRef equipment = Mockito.mock(EquipmentRef.class);
        GenericItemRef itemRef = Mockito.mock(GenericItemRef.class);

        Mockito.when(itemRef.getId()).thenReturn(id);
        Mockito.when(equipment.getItemRef()).thenReturn(itemRef);
        Mockito.when(equipment.getAttackBonus()).thenReturn(attackBonus);
        Mockito.when(equipment.getDefenceBonus()).thenReturn(new DefenceBonus(0, 0, 0, 0, 0));
        Mockito.when(equipment.getSkillsBonus()).thenReturn(skillsBonus);

        return equipment;
    }
}

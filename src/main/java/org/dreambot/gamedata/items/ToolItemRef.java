package org.dreambot.gamedata.items;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BooleanSupplier;

public enum ToolItemRef implements GenericItemRef {
    NOOSE_WAND(10150),
    DRAGON_AXE(6739, "Woodcutting Axe"),
    DRAGON_FELLING_AXE(28217),
    INFERNAL_AXE(13241, "Infernal Axe"),
    INFERNAL_AXE_OR(25066, "Infernal Axe"),
    INFERNAL_AXE_UNCHARGED(13242, "Infernal Axe"),
    INFERNAL_AXE_OR_UNCHARGED(25371, "Infernal Axe"),
    THIRD_AGE_AXE(20011),
    THIRD_AGE_FELLING_AXE(28226),
    RUNE_AXE(1359, "Woodcutting Axe"),
    ADAMANT_AXE(1357, "Woodcutting Axe"),
    MITHRIL_AXE(1355, "Woodcutting Axe"),
    BLACK_AXE(1361, "Woodcutting Axe"),
    STEEL_AXE(1353, "Woodcutting Axe"),
    IRON_AXE(1349, "Woodcutting Axe"),
    BRONZE_AXE(1351, "Woodcutting Axe"),
    CRYSTAL_PICKAXE_INACTIVE(23682, "Crystal Pickaxe"),
    INFERNAL_PICKAXE(13243, "Infernal Pickaxe"),
    INFERNAL_PICKAXE_UNCHARGED(13244, "Infernal Pickaxe"),
    THIRD_AGE_PICKAXE(20014),
    CRYSTAL_PICKAXE(23680, "Pickaxe"),
    DRAGON_PICKAXE(11920, "Pickaxe"),
    RUNE_PICKAXE(1275, "Pickaxe"),
    RUNE_PICKAXE_NMZ(11719, "Pickaxe"),
    MITHRIL_PICKAXE_NMZ(11720, "Pickaxe"),
    IRON_PICKAXE_NMZ(11721, "Pickaxe"),
    ADAMANT_PICKAXE(1271, "Pickaxe"),
    MITHRIL_PICKAXE(1273, "Pickaxe"),
    BLACK_PICKAXE(12297, "Pickaxe"),
    STEEL_PICKAXE(1269, "Pickaxe"),
    IRON_PICKAXE(1267, "Pickaxe"),
    BRONZE_PICKAXE(1265, "Pickaxe"),
    ECHO_AXE(25110),
    ECHO_PICKAXE(25112),
    ECHO_HARPOON(25114),
    FLY_FISHING_ROD(309),
    KARAMBWAN_VESSEL(3157),
    FISHING_BARREL_CLOSED(25582, "Fishing Barrel"),
    FISHING_BARREL_OPEN(25584, "Fishing Barrel"),
    SAW(8794),
    HAMMER(2347, "Hammer"),
    AMYS_SAW(24880),
    CRYSTAL_AXE(23673),
    CRYSTAL_AXE_INACTIVE(23675, "Crystal Axe"),
    CRYSTAL_FELLING_AXE(28220, "Crystal Felling Axe"),
    CRYSTAL_FELLING_AXE_INACTIVE(28223, "Crystal Felling Axe"),
    IMCANDO_HAMMER(25644),
    IMCANDO_HAMMER_OFFHAND(29775),
    IMCANDO_HAMMER_BROKEN(25633),
    LOBSTER_POT(301),
    HARPOON(311),
    BARBARIAN_ROD(11323),
    DRAGON_HARPOON(21028),
    INFERNAL_HARPOON(21031, "Infernal Harpoon"),
    INFERNAL_HARPOON_UNCHARGED(21033, "Infernal Harpoon"),
    CRYSTAL_HARPOON(23762, "Crystal Harpoon"),
    CRYSTAL_HARPOON_INACTIVE(23764, "Crystal Harpoon"),
    SMALL_FISHING_NET(303),
    BIG_FISHING_NET(305),
    FISHING_ROD(307),
    SPADE(952),
    GARDENING_TROWEL(5325),
    GRICOLLERS_CAN(13353, "Watering Can"),
    CHISEL(1755, "Chisel"),
    KNIFE(946),
    GEM_BAG(12020, "Gem Bag"),
    GEM_BAG_OPEN(24481, "Gem Bag"),
    SEED_BOX(13639, "Seed Box"),
    SEED_BOX_OPEN(24482, "Seed Box"),
    RAKE(5341),
    WATERING_CAN_EMPTY(5331, "Watering Can"),
    WATERING_CAN_1(5333, "Watering Can"),
    WATERING_CAN_2(5334, "Watering Can"),
    WATERING_CAN_3(5335, "Watering Can"),
    WATERING_CAN_4(5336, "Watering Can"),
    WATERING_CAN_5(5337, "Watering Can"),
    WATERING_CAN_6(5338, "Watering Can"),
    WATERING_CAN_7(5339, "Watering Can"),
    WATERING_CAN_8(5340, "Watering Can"),
    SEED_DIBBER(5343),

    FLAMTAER_HAMMER(3678),
    MAGIC_SECATEURS(7409, "Secateurs"),
    MAGIC_SECATEURS_NMZ(11711, "Secateurs"),
    SECATEURS(5329, "Secateurs"),
    ;

    private final int id;
    private final String displayName;
    public final BooleanSupplier meetsRequirements;

    ToolItemRef(int id) {
        this(id, "", () -> true);
    }

    ToolItemRef(int id, String displayName) {
        this(id, displayName, () -> true);
    }

    ToolItemRef(int id, String displayName, BooleanSupplier meetsRequirements) {
        this.id = id;
        this.displayName = displayName;
        this.meetsRequirements = meetsRequirements;
    }

    public boolean matches(String text) {
        return text != null && text.equalsIgnoreCase(displayName);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public boolean getMeetsRequirements() {
        return this.meetsRequirements.getAsBoolean();
    }

    public int[] getIds() {
        if (this.getDisplayName() == null || this.getDisplayName().isEmpty()) {
            return new int[] {this.getId()};
        }
        return Arrays.stream(ToolItemRef.values())
                .filter((item) -> item.getDisplayName() != null)
                .filter(item -> Objects.equals(item.displayName, this.displayName))
                .mapToInt(ToolItemRef::getId)
                .toArray();
    }

    public GenericItemRef[] getSimilarItems() {
        if (this.getDisplayName() == null || this.getDisplayName().isEmpty()) {
            return new ToolItemRef[] {this};
        }
        return Arrays.stream(ToolItemRef.values())
                .filter((item) -> item.getDisplayName() != null)
                .filter(item -> Objects.equals(item.displayName, this.displayName))
                .toArray(ToolItemRef[]::new);
    }
}

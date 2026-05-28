package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import com.simibubi.create.foundation.block.connected.CTType;
import net.createmod.catnip.data.Couple;
import uwu.lopyluna.create_dd.DesiresCreate;


@SuppressWarnings({"all"})
public class DesiresSpriteShifts {

	public static final Couple<CTSpriteShiftEntry>
			SOCKPILE_SIDE = stockpile("side"),
			SOCKPILE_TOP = stockpile("top"),
			SOCKPILE_BOTTOM = stockpile("bottom");


	public static final Couple<CTSpriteShiftEntry>
			KEG_TOP = reservoir("top"),
			KEG_FRONT = reservoir("front"),
			KEG_SIDE = reservoir("side"),
			KEG_BOTTOM = reservoir("bottom");

	public static final CTSpriteShiftEntry
            VERTICAL_FRAMED_SPLIT_GLASS = getCT(AllCTTypes.OMNIDIRECTIONAL, "palettes/vertical_framed_split_glass"),
            HORIZONTAL_FRAMED_SPLIT_GLASS = getCT(AllCTTypes.OMNIDIRECTIONAL, "palettes/horizontal_framed_split_glass"),
            FRAMED_SPLIT_GLASS = getCT(AllCTTypes.OMNIDIRECTIONAL, "palettes/framed_split_glass"),
            ORNATE_IRON_GLASS = getCT(AllCTTypes.OMNIDIRECTIONAL, "palettes/ornate_iron_glass"),
            ORNATE_IRON_GLASS_TOP = getCT(AllCTTypes.OMNIDIRECTIONAL, "palettes/ornate_iron_glass_top"),
            ORNATE_IRON_GLASS_SIDE = getCT(AllCTTypes.OMNIDIRECTIONAL, "palettes/ornate_iron_glass_side", "palettes/ornate_iron_glass_side");

	public static final CTSpriteShiftEntry
			HAZARD_BLOCK = omni("hazard_block"),
			DARK_METAL_PLATING = omni("dark_metal_plating"),
			CREATIVE_CASING = omni("creative_casing"),
            OVERBURDEN_CASING = omni("overburden_casing"),
            BLAZE_GOLD_CASING = omni("blaze_gold_casing"),
            BRICK_CASING = omni("brick_casing"),
            BRONZE_CASING = omni("bronze_casing"),
            ELEMENTIUM_CASING = omni("elementium_casing"),
            MITHRIL_CASING = omni("mithril_casing"),
            MOSSY_ANDESITE_CASING = omni("mossy_andesite_casing"),
            NETHER_BRICK_CASING = omni("nether_brick_casing"),
            NETHERITE_CASING = omni("netherite_casing"),
            OVERCHARGED_CASING = omni("overcharged_casing"),
            REFINED_RADIANCE_CASING = omni("refined_radiance_casing"),
            SHADOW_STEEL_CASING = omni("shadow_steel_casing"),
            STARGAZE_SINGULARITY_CASING = omni("stargaze_singularity_casing"),
            STEEL_CASING = omni("steel_casing"),
            TERRASTEEL_CASING = omni("terrasteel_casing"),
            TIN_CASING = omni("tin_casing"),
            ZINC_CASING = omni("zinc_casing"),
            REINFORCEMENT_PLATING = omni("reinforcement_plating"),

            FAUXVAULT_CASING = omni("fauxvault_casing"),
            TECHBRAIN_CASING = omni("techbrain_casing"),
            FAUX_INDUSTRIAL_BRASS_CASING = omni("faux_industrial_brass_casing"),
            HEAVY_BRASS_CASING = omni("heavy_brass_casing"),
            INDUSTRIAL_BRASS_CASING = omni("industrial_brass_casing"),
			INDUSTRIAL_CASING = omni("industrial_casing"),
			HYDRAULIC_CASING = omni("hydraulic_casing");

	public static final CTSpriteShiftEntry
			CREATIVE_CASING_COGWHEEL_SIDE = vertical("creative_encased_cogwheel_side"),
            OVERBURDEN_CASING_COGWHEEL_SIDE = vertical("overburden_encased_cogwheel_side"),
			INDUSTRIAL_CASING_COGWHEEL_SIDE = vertical("industrial_encased_cogwheel_side"),
			HYDRAULIC_CASING_COGWHEEL_SIDE = vertical("hydraulic_encased_cogwheel_side");

	public static final CTSpriteShiftEntry
			CREATIVE_CASING_COGWHEEL_OTHERSIDE = horizontal("creative_encased_cogwheel_side"),
			OVERBURDEN_CASING_COGWHEEL_OTHERSIDE = horizontal("overburden_encased_cogwheel_side"),
			INDUSTRIAL_CASING_COGWHEEL_OTHERSIDE = horizontal("industrial_encased_cogwheel_side"),
			HYDRAULIC_CASING_COGWHEEL_OTHERSIDE = horizontal("hydraulic_encased_cogwheel_side");

	public static final CTSpriteShiftEntry
			 BLACK_BLUEPRINT_BLOCK = omniBlueprint("black"),
			 WHITE_BLUEPRINT_BLOCK = omniBlueprint("white"),
			 BLUE_BLUEPRINT_BLOCK = omni("blueprint_block"),
			 LIGHT_BLUE_BLUEPRINT_BLOCK = omniBlueprint("light"),
			 RED_BLUEPRINT_BLOCK = omniBlueprint("red"),
			 GREEN_BLUEPRINT_BLOCK = omniBlueprint("green"),
			 LIME_BLUEPRINT_BLOCK = omniBlueprint("lime"),
			 PINK_BLUEPRINT_BLOCK = omniBlueprint("pink"),
			 MAGENTA_BLUEPRINT_BLOCK = omniBlueprint("magenta"),
			 YELLOW_BLUEPRINT_BLOCK = omniBlueprint("yellow"),
			 GRAY_BLUEPRINT_BLOCK = omniBlueprint("gray"),
			 LIGHT_GRAY_BLUEPRINT_BLOCK = omniBlueprint("light_gray"),
			 BROWN_BLUEPRINT_BLOCK = omniBlueprint("brown"),
			 CYAN_BLUEPRINT_BLOCK = omniBlueprint("cyan"),
			 PURPLE_BLUEPRINT_BLOCK = omniBlueprint("purple"),
			 ORANGE_BLUEPRINT_BLOCK = omniBlueprint("orange");



    public static final CTSpriteShiftEntry
            TRAIN_SCAFFOLD = horizontal("train_scaffold"),
            MITHRIL_SCAFFOLD = horizontal("mithril_scaffold"),
            BRONZE_SCAFFOLD = horizontal("bronze_scaffold"),
            STEEL_SCAFFOLD = horizontal("steel_scaffold"),
            ZINC_SCAFFOLD = horizontal("zinc_scaffold"),
            TIN_SCAFFOLD = horizontal("tin_scaffold"),
            NETHERITE_SCAFFOLD = horizontal("netherite_scaffold"),
            MOSSY_ANDESITE_SCAFFOLD = horizontal("mossy_andesite_scaffold"),
            HYDRAULIC_SCAFFOLD = horizontal("hydraulic_scaffold"),
            INDUSTRIAL_SCAFFOLD = horizontal("industrial_scaffold"),
            STARGAZE_SINGULARITY_SCAFFOLD = horizontal("stargaze_singularity_scaffold"),
            BLAZE_GOLD_SCAFFOLD = horizontal("blaze_gold_scaffold"),
            OVERCHARGED_SCAFFOLD = horizontal("overcharged_scaffold"),
            OVERBURDEN_SCAFFOLD = horizontal("overburden_scaffold"),
            SHADOW_STEEL_SCAFFOLD = horizontal("shadow_steel_scaffold"),
            REFINED_RADIANCE_SCAFFOLD = horizontal("refined_radiance_scaffold");

    public static final CTSpriteShiftEntry
            TRAIN_SCAFFOLD_INSIDE = horizontal("train_scaffold_inside"),
            MITHRIL_SCAFFOLD_INSIDE = horizontal("mithril_scaffold_inside"),
            BRONZE_SCAFFOLD_INSIDE = horizontal("bronze_scaffold_inside"),
            STEEL_SCAFFOLD_INSIDE = horizontal("steel_scaffold_inside"),
            ZINC_SCAFFOLD_INSIDE = horizontal("zinc_scaffold_inside"),
            TIN_SCAFFOLD_INSIDE = horizontal("tin_scaffold_inside"),
            NETHERITE_SCAFFOLD_INSIDE = horizontal("netherite_scaffold_inside"),
            MOSSY_ANDESITE_SCAFFOLD_INSIDE = horizontal("mossy_andesite_scaffold_inside"),
            HYDRAULIC_SCAFFOLD_INSIDE = horizontal("hydraulic_scaffold_inside"),
            INDUSTRIAL_SCAFFOLD_INSIDE = horizontal("industrial_scaffold_inside"),
            OVERBURDEN_SCAFFOLD_INSIDE = horizontal("overburden_scaffold_inside"),
            STARGAZE_SINGULARITY_SCAFFOLD_INSIDE = horizontal("stargaze_singularity_scaffold_inside"),
            BLAZE_GOLD_SCAFFOLD_INSIDE = horizontal("blaze_gold_scaffold_inside"),
            OVERCHARGED_SCAFFOLD_INSIDE = horizontal("overcharged_scaffold_inside"),
            SHADOW_STEEL_SCAFFOLD_INSIDE = horizontal("shadow_steel_scaffold_inside"),
            REFINED_RADIANCE_SCAFFOLD_INSIDE = horizontal("refined_radiance_scaffold_inside");

	//public static final Map<DyeColor, SpriteShiftEntry> DYED_RUBBER_BELTS = new EnumMap<>(DyeColor.class),
	//		DYED_OFFSET_RUBBER_BELTS = new EnumMap<>(DyeColor.class), DYED_DIAGONAL_RUBBER_BELTS = new EnumMap<>(DyeColor.class);

	//public static final SpriteShiftEntry
	//	RUBBER_BELT = get("block/belt", "block/rubber_belt_scroll"),
	//	RUBBER_BELT_OFFSET = get("block/rubber_belt_offset", "block/rubber_belt_scroll"),
	//	RUBBER_BELT_DIAGONAL = get("block/rubber_belt_diagonal", "block/rubber_belt_diagonal_scroll"),
	//	ANDESITE_RUBBER_BELT_CASING = get("block/belt/andesite_rubber_belt_casing", "block/belt/andesite_rubber_belt_casing"),
	//	BRASS_RUBBER_BELT_CASING = get("block/belt/brass_rubber_belt_casing", "block/belt/brass_rubber_belt_casing"),
	//	INDUSTRIAL_RUBBER_BELT_CASING = get("block/belt/industrial_rubber_belt_casing", "block/belt/industrial_rubber_belt_casing");

	//static {
	//	populateMaps();
	//}
//
	//private static void populateMaps() {
	//	for (DyeColor color : DyeColor.values()) {
	//		String id = color.getSerializedName();
	//		DYED_RUBBER_BELTS.put(color, get("block/rubber_belt", "block/rubber_belt/" + id + "_scroll"));
	//		DYED_OFFSET_RUBBER_BELTS.put(color, get("block/rubber_belt_offset", "block/rubber_belt/" + id + "_scroll"));
	//		DYED_DIAGONAL_RUBBER_BELTS.put(color, get("block/rubber_belt_diagonal", "block/rubber_belt/" + id + "_diagonal_scroll"));
	//	}
	//}

	private static Couple<CTSpriteShiftEntry> stockpile(String name) {
		final String prefixed = "block/stockpile/stockpile_" + name;
		return Couple.createWithContext(
				medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, DesiresCreate.asResource(prefixed + "_small"),
						DesiresCreate.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
	}

	private static Couple<CTSpriteShiftEntry> reservoir(String name) {
		final String prefixed = "block/reservoir/reservoir_" + name;
		return Couple.createWithContext(
				medium -> CTSpriteShifter.getCT(AllCTTypes.RECTANGLE, DesiresCreate.asResource(prefixed + "_small"),
						DesiresCreate.asResource(medium ? prefixed + "_medium" : prefixed + "_large")));
	}

	private static CTSpriteShiftEntry omniBlueprint(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name + "_blueprint_block");
	}

	private static CTSpriteShiftEntry omni(String name) {
		return getCT(AllCTTypes.OMNIDIRECTIONAL, name);
	}

	private static CTSpriteShiftEntry horizontal(String name) {
		return getCT(AllCTTypes.HORIZONTAL, name);
	}

	private static CTSpriteShiftEntry vertical(String name) {
		return getCT(AllCTTypes.VERTICAL, name);
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName, String connectedTextureName) {
		return CTSpriteShifter.getCT(type, DesiresCreate.asResource("block/" + blockTextureName), DesiresCreate.asResource("block/" + connectedTextureName + "_connected"));
	}

	private static CTSpriteShiftEntry getCT(CTType type, String blockTextureName) {
		return getCT(type, blockTextureName, blockTextureName);
	}

	public static void register(){}
}

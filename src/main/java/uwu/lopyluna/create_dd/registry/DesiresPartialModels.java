package uwu.lopyluna.create_dd.registry;

import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.data.Couple;
import net.minecraft.resources.ResourceLocation;
import uwu.lopyluna.create_dd.DesiresCreate;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"all"})
public class DesiresPartialModels {

	public static final PartialModel

		EMPTY = block("empty"),

		INDUSTRIAL_FAN_POWER = block("industrial_fan/cog"),
		INDUSTRIAL_FAN_INNER = block("industrial_fan/propeller"),

		COG_CRANK_HANDLE = block("cog_crank/handle"),
		COG_CRANK_COG = block("cog_crank/block"),

		HYDRAULIC_PRESS_HEAD = block("hydraulic_press/head"),

        GIANT_GEAR = block("giant_gear/giant_gear"),

        BRONZE_SAW_BLADE_HORIZONTAL_ACTIVE = block("bronze_saw/blade_horizontal_active"),
        BRONZE_SAW_BLADE_HORIZONTAL_INACTIVE = block("bronze_saw/blade_horizontal_inactive"),
        BRONZE_SAW_BLADE_HORIZONTAL_REVERSED = block("bronze_saw/blade_horizontal_reversed"),
        BRONZE_SAW_BLADE_VERTICAL_ACTIVE = block("bronze_saw/blade_vertical_active"),
        BRONZE_SAW_BLADE_VERTICAL_INACTIVE = block("bronze_saw/blade_vertical_inactive"),
        BRONZE_SAW_BLADE_VERTICAL_REVERSED = block("bronze_saw/blade_vertical_reversed"),

        RADIANT_SAW_BLADE_HORIZONTAL_ACTIVE = block("radiant_saw/blade_horizontal_active"),
        RADIANT_SAW_BLADE_HORIZONTAL_INACTIVE = block("radiant_saw/blade_horizontal_inactive"),
        RADIANT_SAW_BLADE_HORIZONTAL_REVERSED = block("radiant_saw/blade_horizontal_reversed"),
        RADIANT_SAW_BLADE_VERTICAL_ACTIVE = block("radiant_saw/blade_vertical_active"),
        RADIANT_SAW_BLADE_VERTICAL_INACTIVE = block("radiant_saw/blade_vertical_inactive"),
        RADIANT_SAW_BLADE_VERTICAL_REVERSED = block("radiant_saw/blade_vertical_reversed"),

        SHADOW_SAW_BLADE_HORIZONTAL_ACTIVE = block("shadow_saw/blade_horizontal_active"),
        SHADOW_SAW_BLADE_HORIZONTAL_INACTIVE = block("shadow_saw/blade_horizontal_inactive"),
        SHADOW_SAW_BLADE_HORIZONTAL_REVERSED = block("shadow_saw/blade_horizontal_reversed"),
        SHADOW_SAW_BLADE_VERTICAL_ACTIVE = block("shadow_saw/blade_vertical_active"),
        SHADOW_SAW_BLADE_VERTICAL_INACTIVE = block("shadow_saw/blade_vertical_inactive"),
        SHADOW_SAW_BLADE_VERTICAL_REVERSED = block("shadow_saw/blade_vertical_reversed"),

        BRONZE_DRILL_HEAD = block("bronze_drill/head"),
        RADIANT_DRILL_HEAD = block("radiant_drill/head"),
        SHADOW_DRILL_HEAD = block("shadow_drill/head"),

        POTATO_TURRET_COG = block("potato_turret/cog"),
        POTATO_TURRET_CONNECTOR = block("potato_turret/connector"),
        POTATO_TURRET_SINGLE_BARREL = block("potato_turret/single_barrel"),

		ENGINE_PISTON = block("furnace_engine/piston"),
		ENGINE_LINKAGE = block("furnace_engine/linkage"),
		ENGINE_CONNECTOR = block("furnace_engine/shaft_connector"),

        TWO_BLADE_FAN = block("2_blade_fan/block"),
        FOUR_BLADE_FAN = block("4_blade_fan/block"),
        EIGHT_BLADE_FAN = block("8_blade_fan/block"),

        TOP_PANEL = block("omni_gearbox/panels/top"),
        BOTTOM_PANEL = block("omni_gearbox/panels/bottom"),
        NORTH_PANEL = block("omni_gearbox/panels/north"),
        EAST_PANEL = block("omni_gearbox/panels/east"),
        SOUTH_PANEL = block("omni_gearbox/panels/south"),
        WEST_PANEL = block("omni_gearbox/panels/west"),

        GOLDEN_MIXER_POLE = block("gold_mixer/pole"),
        GOLDEN_MIXER_HEAD = block("gold_mixer/head"),

        SPUD_BASE = block("spud_sentry/base"),
        SPUD_CANNON = block("spud_sentry/cannon"),
        SPUD_GEAR = block("spud_sentry/gear")
	;

    public static final Map<ResourceLocation, Couple<PartialModel>> FOLDING_DOORS = new HashMap<>();
    static {
        putFoldingDoor("rose_door");
        putFoldingDoor("smoked_door");
        putFoldingDoor("spirit_door");
    }
    private static void putFoldingDoor(String path) {
        FOLDING_DOORS.put(DesiresCreate.asResource(path),
                Couple.create(block(path + "/fold_left"), block(path + "/fold_right")));
    }

	private static PartialModel block(String path) {
		return PartialModel.of(DesiresCreate.asResource("block/" + path));
	}

	//private static PartialModel entity(String path) {
	//	return PartialModel.of(DesiresCreate.asResource("entity/" + path));
	//}

	public static void init() {
		// init static fields
	}

}

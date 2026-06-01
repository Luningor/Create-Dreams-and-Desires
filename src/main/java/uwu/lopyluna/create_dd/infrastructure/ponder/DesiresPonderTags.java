package uwu.lopyluna.create_dd.infrastructure.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllFluids;
import com.simibubi.create.AllItems;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderTagRegistrationHelper;
import net.createmod.ponder.foundation.PonderTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;
import uwu.lopyluna.create_dd.registry.DesiresFluids;
import uwu.lopyluna.create_dd.registry.DesiresItems;

import static com.simibubi.create.infrastructure.ponder.AllCreatePonderTags.*;

public class DesiresPonderTags {

	public static final PonderTag DESIRES = new PonderTag(
			DesiresCreate.asResource("create_dd"),
			null,
			new ItemStack(AllItems.PRECISION_MECHANISM.get()),
			new ItemStack(AllItems.PRECISION_MECHANISM.get())
	);

    public static final PonderTag FAN_HEATER = new PonderTag(
            DesiresCreate.asResource("fan_heater"),
            null,
            new ItemStack(AllItems.PRECISION_MECHANISM.get()),
            new ItemStack(AllItems.PRECISION_MECHANISM.get())
    );

    public static final PonderTag STONE_GENERATION = new PonderTag(
            DesiresCreate.asResource("stone_generation"),
            null,
            new ItemStack(DesiresItems.PONDER_STONE_GENERATION.get()),
            new ItemStack(DesiresItems.PONDER_STONE_GENERATION.get())
    );

    @SuppressWarnings("deprecation")
    public static void register(PonderTagRegistrationHelper<ResourceLocation> helper) {
        PonderTagRegistrationHelper<RegistryEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        helper.addToTag(FAN_HEATER.getId())
                .add(BuiltInRegistries.ITEM.getKey(Items.LAVA_BUCKET))
        ;

        HELPER.addToTag(FAN_HEATER.getId())
                .add(AllBlocks.BLAZE_BURNER)
                .add(DesiresBlocks.SEETHING_SAIL)
        ;

        helper.addToTag(STONE_GENERATION.getId())
                .add(BuiltInRegistries.ITEM.getKey(Items.LAVA_BUCKET))
                .add(BuiltInRegistries.ITEM.getKey(Items.WATER_BUCKET))
                .add(BuiltInRegistries.ITEM.getKey(Items.BLUE_ICE))
                .add(BuiltInRegistries.ITEM.getKey(Items.SOUL_SAND))
                .add(BuiltInRegistries.ITEM.getKey(AllFluids.HONEY.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(AllFluids.CHOCOLATE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.CHROMATIC_WASTE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.SAP.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.SHIMMER.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.VANILLA_MILKSHAKE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.VANILLA.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.CARAMEL.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.CARAMEL_MILKSHAKE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.CHOCOLATE_MILKSHAKE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.HOT_CHOCOLATE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.GLOWBERRY.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.GLOWBERRY_MILKSHAKE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.STRAWBERRY.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.STRAWBERRY_MILKSHAKE.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.CREAM.get().getBucket()))
                .add(BuiltInRegistries.ITEM.getKey(DesiresFluids.CONDENSE_MILK.get().getBucket()))
        ;

        HELPER.addToTag(STONE_GENERATION.getId())
                .add(DesiresItems.PONDER_STONE_GENERATION)
        ;

        HELPER.addToTag(DESIRES.getId())
                .add(DesiresBlocks.INDUSTRIAL_FAN)
                .add(DesiresBlocks.HYDRAULIC_PRESS)
                .add(DesiresBlocks.BRONZE_DRILL)
                .add(DesiresBlocks.SHADOW_DRILL)
                .add(DesiresBlocks.RADIANT_DRILL)
                .add(DesiresBlocks.BRONZE_SAW)
                .add(DesiresBlocks.SHADOW_SAW)
                .add(DesiresBlocks.RADIANT_SAW)
                .add(DesiresBlocks.COG_CRANK)
                .add(DesiresBlocks.ACCELERATOR_MOTOR)
                .add(DesiresBlocks.KINETIC_MOTOR)
                .add(AllBlocks.FLYWHEEL)
                .add(DesiresBlocks.FURNACE_ENGINE)
                .add(DesiresBlocks.INVERSE_BOX)
                .add(DesiresBlocks.BLASTING_SAIL)
                .add(DesiresBlocks.FREEZING_SAIL)
                .add(DesiresBlocks.SMOKING_SAIL)
                .add(DesiresBlocks.SPLASHING_SAIL)
                .add(DesiresBlocks.SEETHING_SAIL)
                .add(DesiresBlocks.HAUNTING_SAIL)
        ;

        HELPER.addToTag(KINETIC_APPLIANCES)
                .add(DesiresBlocks.INDUSTRIAL_FAN)
                .add(DesiresBlocks.HYDRAULIC_PRESS)
                .add(DesiresBlocks.BRONZE_DRILL)
                .add(DesiresBlocks.SHADOW_DRILL)
                .add(DesiresBlocks.RADIANT_DRILL)
                .add(DesiresBlocks.BRONZE_SAW)
                .add(DesiresBlocks.SHADOW_SAW)
                .add(DesiresBlocks.RADIANT_SAW)
        ;

        HELPER.addToTag(CONTRAPTION_ACTOR)
                .add(DesiresBlocks.BRONZE_DRILL)
                .add(DesiresBlocks.SHADOW_DRILL)
                .add(DesiresBlocks.RADIANT_DRILL)
                .add(DesiresBlocks.BRONZE_SAW)
        ;

        HELPER.addToTag(ARM_TARGETS)
                .add(DesiresBlocks.BRONZE_SAW)
        ;

        HELPER.addToTag(KINETIC_SOURCES)
                .add(DesiresBlocks.INDUSTRIAL_FAN)
                .add(DesiresBlocks.COG_CRANK)
                .add(DesiresBlocks.ACCELERATOR_MOTOR)
                .add(DesiresBlocks.KINETIC_MOTOR)
                .add(AllBlocks.FLYWHEEL)
                .add(DesiresBlocks.FURNACE_ENGINE)
        ;

        HELPER.addToTag(KINETIC_RELAYS)
                .add(DesiresBlocks.INVERSE_BOX)
        ;

        HELPER.addToTag(SAILS)
                .add(DesiresBlocks.BLASTING_SAIL)
                .add(DesiresBlocks.FREEZING_SAIL)
                .add(DesiresBlocks.SMOKING_SAIL)
                .add(DesiresBlocks.SPLASHING_SAIL)
                .add(DesiresBlocks.SEETHING_SAIL)
                .add(DesiresBlocks.HAUNTING_SAIL)
        ;

        HELPER.addToTag(REDSTONE)
                .add(DesiresBlocks.SPECTRAL_RUBY_LAMP)
        ;

	}

}

package uwu.lopyluna.create_dd.infrastructure.ponder;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.foundation.ponder.*;
import com.simibubi.create.infrastructure.ponder.AllCreatePonderTags;
import com.simibubi.create.infrastructure.ponder.scenes.*;
import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;
import uwu.lopyluna.create_dd.registry.DesiresItems;

public class DesiresPonderScenes {

    public static void register(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        PonderSceneRegistrationHelper<ItemProviderEntry<?>> HELPER = helper.withKeyFunction(RegistryEntry::getId);

        HELPER.forComponents(DesiresBlocks.HYDRAULIC_PRESS).addStoryBoard("hydraulic_press", DesiresProcessingScenes::bulkPressing, AllCreatePonderTags.KINETIC_APPLIANCES);
        HELPER.forComponents(DesiresBlocks.BRONZE_SAW).addStoryBoard("bronze_saw", DesiresProcessingScenes::processing, AllCreatePonderTags.KINETIC_APPLIANCES);
        HELPER.forComponents(AllBlocks.FLYWHEEL).addStoryBoard("furnace_engine", DesiresProcessingScenes::flywheel);
        HELPER.forComponents(DesiresBlocks.FURNACE_ENGINE).addStoryBoard("furnace_engine", DesiresProcessingScenes::furnaceEngine);
        HELPER.forComponents(DesiresBlocks.BLASTING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.SMOKING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.HAUNTING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.SPLASHING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.SEETHING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.FREEZING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.DRAGON_BREATHING_SAIL).addStoryBoard("fan_sails", DesiresProcessingScenes::fanSails);
        HELPER.forComponents(DesiresBlocks.ACCELERATOR_MOTOR).addStoryBoard("accelerator_motor", DesiresProcessingScenes::motors, AllCreatePonderTags.KINETIC_SOURCES);
        HELPER.forComponents(DesiresBlocks.KINETIC_MOTOR).addStoryBoard("kinetic_motor", DesiresProcessingScenes::motors, AllCreatePonderTags.KINETIC_SOURCES);
        HELPER.forComponents(DesiresBlocks.COG_CRANK).addStoryBoard("cog_crank", DesiresProcessingScenes::cogCrank, AllCreatePonderTags.KINETIC_SOURCES);
        HELPER.forComponents(DesiresBlocks.LARGE_COG_CRANK).addStoryBoard("cog_crank", DesiresProcessingScenes::cogCrank, AllCreatePonderTags.KINETIC_SOURCES);
        HELPER.forComponents(DesiresBlocks.INDUSTRIAL_FAN).addStoryBoard("industrial_fan_source", DesiresProcessingScenes::industrialFanSource, AllCreatePonderTags.KINETIC_SOURCES);

        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/blue_ice", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/caramel", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/caramel_milkshake", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/chocolate", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/chocolate_milk", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/chromatic_waste", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/condence_milk", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/cream", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/glowberry", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/glowberry_milkshake", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/honey", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/hot_chocolate", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/sap", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/shimmer", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/strawberry", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/strawberry_milkshake", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/vanilla", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/vanilla_milkshake", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/water", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());
        HELPER.forComponents(DesiresItems.PONDER_STONE_GENERATION).addStoryBoard("gen/water_chroma", DesiresProcessingScenes::stoneGeneration, DesiresPonderTags.STONE_GENERATION.getId());

        ////////////////////// Create = below |||| Create DD = Above

        HELPER.forComponents(DesiresBlocks.BRONZE_SAW)
                .addStoryBoard(new ResourceLocation("create:mechanical_saw/breaker"), MechanicalSawScenes::treeCutting)
                .addStoryBoard(new ResourceLocation("create:mechanical_saw/contraption"), MechanicalSawScenes::contraption, AllCreatePonderTags.CONTRAPTION_ACTOR);
        HELPER.forComponents(DesiresBlocks.RADIANT_SAW)
                .addStoryBoard(new ResourceLocation("create:mechanical_saw/breaker"), MechanicalSawScenes::treeCutting)
                .addStoryBoard(new ResourceLocation("create:mechanical_saw/contraption"), MechanicalSawScenes::contraption, AllCreatePonderTags.CONTRAPTION_ACTOR);
        HELPER.forComponents(DesiresBlocks.SHADOW_SAW)
                .addStoryBoard(new ResourceLocation("create:mechanical_saw/breaker"), MechanicalSawScenes::treeCutting)
                .addStoryBoard(new ResourceLocation("create:mechanical_saw/contraption"), MechanicalSawScenes::contraption, AllCreatePonderTags.CONTRAPTION_ACTOR);
        HELPER.forComponents(DesiresBlocks.BRONZE_DRILL)
                .addStoryBoard(new ResourceLocation("create:mechanical_drill/breaker"), MechanicalDrillScenes::breaker, AllCreatePonderTags.KINETIC_APPLIANCES)
                .addStoryBoard(new ResourceLocation("create:mechanical_drill/contraption"), MechanicalDrillScenes::contraption, AllCreatePonderTags.CONTRAPTION_ACTOR);
        HELPER.forComponents(DesiresBlocks.RADIANT_DRILL)
                .addStoryBoard(new ResourceLocation("create:mechanical_drill/breaker"), MechanicalDrillScenes::breaker, AllCreatePonderTags.KINETIC_APPLIANCES)
                .addStoryBoard(new ResourceLocation("create:mechanical_drill/contraption"), MechanicalDrillScenes::contraption, AllCreatePonderTags.CONTRAPTION_ACTOR);
        HELPER.forComponents(DesiresBlocks.SHADOW_DRILL)
                .addStoryBoard(new ResourceLocation("create:mechanical_drill/breaker"), MechanicalDrillScenes::breaker, AllCreatePonderTags.KINETIC_APPLIANCES)
                .addStoryBoard(new ResourceLocation("create:mechanical_drill/contraption"), MechanicalDrillScenes::contraption, AllCreatePonderTags.CONTRAPTION_ACTOR);

        HELPER.forComponents(DesiresBlocks.INDUSTRIAL_FAN)
                .addStoryBoard(new ResourceLocation("create:fan/direction"), FanScenes::direction, AllCreatePonderTags.KINETIC_APPLIANCES)
                .addStoryBoard(new ResourceLocation("create:fan/processing"), FanScenes::processing);

        HELPER.forComponents(DesiresBlocks.INVERSE_BOX).addStoryBoard(new ResourceLocation("create:gearshift"), KineticsScenes::gearshift, AllCreatePonderTags.KINETIC_RELAYS);

        HELPER.forComponents(DesiresBlocks.BLASTING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
        HELPER.forComponents(DesiresBlocks.SMOKING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
        HELPER.forComponents(DesiresBlocks.HAUNTING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
        HELPER.forComponents(DesiresBlocks.SPLASHING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
        HELPER.forComponents(DesiresBlocks.SEETHING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
        HELPER.forComponents(DesiresBlocks.FREEZING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
        HELPER.forComponents(DesiresBlocks.DRAGON_BREATHING_SAIL)
                .addStoryBoard(new ResourceLocation("create:sail"), BearingScenes::sail);
    }
}

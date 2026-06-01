package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.*;
import com.simibubi.create.api.behaviour.display.DisplaySource;
import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.simibubi.create.api.contraption.storage.item.MountedItemStorageType;
import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.api.stress.BlockStressValues;
import com.simibubi.create.content.decoration.MetalScaffoldingBlock;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.kinetics.gauge.GaugeGenerator;
import com.simibubi.create.content.kinetics.motor.CreativeMotorGenerator;
import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import com.simibubi.create.foundation.block.ItemUseOverrides;
import com.simibubi.create.foundation.data.*;
import com.simibubi.create.AllTags;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.ForgeSoundType;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.content.blocks.contraptions.bore_block.BoreBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.bore_block.BoreBlockMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.bronze_saw.BronzeSawBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.bronze_saw.BronzeSawMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.bronze.BronzeDrillBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.bronze.BronzeDrillMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant.RadiantDrillBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant.RadiantDrillMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.shadow.ShadowDrillBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.shadow.ShadowDrillMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.radiant_saw.RadiantSawBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.radiant_saw.RadiantSawMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.shadow_saw.ShadowSawBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.shadow_saw.ShadowSawMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.door.YIPPEESlidingDoorBlock;
import uwu.lopyluna.create_dd.content.blocks.fan.eight_blade.EightBladeFanBlock;
import uwu.lopyluna.create_dd.content.blocks.fan.four_blade.FourBladeFanBlock;
import uwu.lopyluna.create_dd.content.blocks.fan.two_blade.TwoBladeFanBlock;
import uwu.lopyluna.create_dd.content.blocks.functional.SpectralRubyLampBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor.AcceleratorMotorBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.creative_gear_motor.CreativeGearMotorBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.golden_mixer.GoldenMixerBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.kinetic_motor.KineticMotorBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.multimeter.MultiMeterBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear.GiantGearBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear.GiantGearBlockItem;
import uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear.GiantGearStructuralBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.hydraulic_press.HydraulicPressBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.industrial_fan_block.IndustrialFanBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank.CogCrankBlock;
import uwu.lopyluna.create_dd.content.blocks.functional.FanSailBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.furnace_engine.FurnaceEngineBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.furnace_engine.FurnaceEngineGenerator;
import uwu.lopyluna.create_dd.content.blocks.kinetics.furnace_engine.PoweredFlywheelBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.omni_gearbox.OmniGearboxBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.omni_speed_controller.OmniSpeedControllerBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.transmission.redstone_divider.RedstoneDividerBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.transmission.InverseBoxBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirCTBehaviour;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirItem;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileCTBehaviour;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileItem;
import uwu.lopyluna.create_dd.content.blocks.magic.*;
import uwu.lopyluna.create_dd.content.blocks.wood.*;
import uwu.lopyluna.create_dd.content.worldgen.Features.RubberTreeGrower;
import uwu.lopyluna.create_dd.registry.helper.BuilderTransgender;

import java.util.function.Consumer;

import static com.simibubi.create.api.behaviour.movement.MovementBehaviour.movementBehaviour;
import static com.simibubi.create.foundation.data.BlockStateGen.simpleBlock;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.*;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;
import static uwu.lopyluna.create_dd.DesiresCreate.REGISTRATE;
import static uwu.lopyluna.create_dd.registry.DesiresPaletteBlocks.rawRubberDecorTag;
import static uwu.lopyluna.create_dd.registry.DesiresPaletteBlocks.rubberDecorTag;

@SuppressWarnings({"unused", "removal", "all"})
public class DesiresBlocks {

    // VALUABLES

    public static final BlockEntry<Block> TIN_ORE = REGISTRATE.block("tin_ore", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(p -> p.mapColor(MapColor.STONE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .properties(p -> p.strength(3f,3f))
            .tag(Tags.Blocks.ORES)
            .tag(AllTags.forgeBlockTag("ores/tin"))
            .lang("Tin Ore")
            .item()
            .tag(Tags.Items.ORES)
            .tag(AllTags.forgeItemTag("ores/tin"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DEEPSLATE_TIN_ORE = REGISTRATE.block("deepslate_tin_ore", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE_GOLD_ORE)
            .properties(p -> p.mapColor(MapColor.DEEPSLATE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .properties(p -> p.strength(4.5f,3f))
            .tag(Tags.Blocks.ORES)
            .tag(AllTags.forgeBlockTag("ores/tin"))
            .lang("Deepslate Tin Ore")
            .item()
            .tag(Tags.Items.ORES)
            .tag(AllTags.forgeItemTag("ores/tin"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> RAW_TIN_BLOCK = REGISTRATE.block("raw_tin_block", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .properties(p -> p.strength(1f,1.6f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/raw_tin"))
            .lang("Block of Raw Tin")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/raw_tin"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> TIN_BLOCK = REGISTRATE.block("tin_block", Block::new)
            .initialProperties(() -> Blocks.STONE)
            .properties(p -> p.mapColor(MapColor.QUARTZ))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.METAL))
            .properties(p -> p.strength(3f,6f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/tin"))
            .lang("Block of Tin")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/raw_tin"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RotatedPillarBlock> SPECTRAL_RUBY_BLOCK = REGISTRATE.block("spectral_ruby_block", RotatedPillarBlock::new)
            .initialProperties(() -> Blocks.AMETHYST_BLOCK)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_MAGENTA)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE))
            .transform(pickaxeOnly())
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SPECTRAL_RUBY_TILES = REGISTRATE.block("spectral_ruby_tiles", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_MAGENTA))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .transform(pickaxeOnly())
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SMALL_SPECTRAL_RUBY_TILES = REGISTRATE.block("small_spectral_ruby_tiles", Block::new)
            .initialProperties(() -> Blocks.DEEPSLATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_MAGENTA))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .transform(pickaxeOnly())
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> LEATHER_BLOCK = REGISTRATE.block("leather_block", Block::new)
            .initialProperties(() -> Blocks.HAY_BLOCK)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .properties(p -> p.sound(SoundType.WOOL))
            .properties(p -> p.strength(0.5f,1f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/leather"))
            .lang("Block of Leather")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/leather"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> MITHRIL_BLOCK = REGISTRATE.block("mithril_block", Block::new)
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.WARPED_NYLIUM))
            .properties(p -> p.sound(new ForgeSoundType(0.75f, .7f, () -> DesiresSoundEvents.MAGICAL_METAL_BREAK.get(),
                    () -> DesiresSoundEvents.MAGICAL_METAL_STEP.get(), () -> DesiresSoundEvents.MAGICAL_METAL_PLACE.get(),
                    () -> DesiresSoundEvents.MAGICAL_METAL_HIT.get(), () -> DesiresSoundEvents.MAGICAL_METAL_FALL.get())))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(16f,48f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/mithril"))
            .lang("Block of Mithril")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/mithril"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> BRONZE_BLOCK = REGISTRATE.block("bronze_block", Block::new)
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .properties(p -> p.strength(12f,10f))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/bronze"))
            .lang("Block of Bronze")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/bronze"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> STEEL_BLOCK = REGISTRATE.block("steel_block", Block::new)
            .initialProperties(SharedProperties::netheriteMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
            .properties(p -> p.strength(6f,16f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/steel"))
            .lang("Block of Steel")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/steel"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> INDUSTRIAL_IRON_BLOCK = REGISTRATE.block("industrial_iron_block", Block::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
            .properties(p -> p.sound(SoundType.NETHERITE_BLOCK))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/industrial_iron"))
            .tag(AllTags.AllBlockTags.WRENCH_PICKUP.tag)
            .transform(pickaxeOnly())
            .lang("Solid Block of Industrial Iron")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/industrial_iron"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> LAPIS_ALLOY_BLOCK = REGISTRATE.block("lapis_alloy_block", Block::new)
            .initialProperties(() -> Blocks.ANDESITE)
            .properties(p -> p.mapColor(MapColor.STONE))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .transform(pickaxeOnly())
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/lapis_alloy"))
            .lang("Block of Lapis Alloy")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/lapis_alloy"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> EMBER_ALLOY_BLOCK = REGISTRATE.block("ember_alloy_block", Block::new)
            .initialProperties(() -> Blocks.BROWN_TERRACOTTA)
            .properties(p -> p.mapColor(MapColor.STONE))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/ember_alloy"))
            .transform(pickaxeOnly())
            .lang("Block of Ember Alloy")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/ember_alloy"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> CHROMATIC_BLOCK = REGISTRATE.block("chromatic_block", Block::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, 1.2f, () -> SoundEvents.POLISHED_DEEPSLATE_BREAK,
                    () -> SoundEvents.POLISHED_DEEPSLATE_STEP, () -> SoundEvents.POLISHED_DEEPSLATE_PLACE,
                    () -> SoundEvents.POLISHED_DEEPSLATE_HIT, () -> SoundEvents.POLISHED_DEEPSLATE_FALL)))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(12f,25f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/chromatic_compound"))
            .transform(pickaxeOnly())
            .lang("Block of Chromatic Compound")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/chromatic_compound"))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RadiantBlock> REFINED_RADIANCE_BLOCK = REGISTRATE.block("refined_radiance_block", RadiantBlock::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.SNOW))
            .properties(p -> p.sound(new ForgeSoundType(1, 1.25f, () -> SoundEvents.AMETHYST_BLOCK_BREAK,
                    () -> SoundEvents.AMETHYST_BLOCK_STEP, () -> SoundEvents.AMETHYST_BLOCK_PLACE,
                    () -> SoundEvents.AMETHYST_BLOCK_HIT, () -> SoundEvents.AMETHYST_BLOCK_FALL)))
            .properties(p -> p.lightLevel($ -> 12))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(16f,48f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/refined_radiance"))
            .transform(pickaxeOnly())
            .lang("Block of Refined Radiance")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/refined_radiance"))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ShadowBlock> SHADOW_STEEL_BLOCK = REGISTRATE.block("shadow_steel_block", ShadowBlock::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .properties(p -> p.sound(new ForgeSoundType(1, .25f, () -> SoundEvents.AMETHYST_CLUSTER_BREAK,
                    () -> SoundEvents.AMETHYST_CLUSTER_STEP, () -> SoundEvents.AMETHYST_CLUSTER_PLACE,
                    () -> SoundEvents.AMETHYST_CLUSTER_HIT, () -> SoundEvents.AMETHYST_CLUSTER_FALL)))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(16f,48f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/shadow_steel"))
            .transform(pickaxeOnly())
            .lang("Block of Shadow Steel")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/shadow_steel"))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<OverchargedAlloyBlock> OVERCHARGED_ALLOY_BLOCK = REGISTRATE.block("overcharged_alloy_block", OverchargedAlloyBlock::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE))
            .properties(p -> p.sound(new ForgeSoundType(1, 1.25f, () -> SoundEvents.AMETHYST_CLUSTER_BREAK,
                    () -> SoundEvents.AMETHYST_CLUSTER_STEP, () -> SoundEvents.AMETHYST_CLUSTER_PLACE,
                    () -> SoundEvents.AMETHYST_CLUSTER_HIT, () -> SoundEvents.AMETHYST_CLUSTER_FALL)))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(12f,32f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/overcharged_alloy"))
            .transform(pickaxeOnly())
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/overcharged_alloy"))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<BlazeGoldBlock> BLAZE_GOLD_BLOCK = REGISTRATE.block("blaze_gold_block", BlazeGoldBlock::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
            .properties(p -> p.sound(new ForgeSoundType(1, 1f, () -> SoundEvents.AMETHYST_CLUSTER_BREAK,
                    () -> SoundEvents.AMETHYST_CLUSTER_STEP, () -> SoundEvents.AMETHYST_CLUSTER_PLACE,
                    () -> SoundEvents.AMETHYST_CLUSTER_HIT, () -> SoundEvents.AMETHYST_CLUSTER_FALL)))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(8f,24f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/blaze_gold"))
            .transform(pickaxeOnly())
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/blaze_gold"))
            .properties(p -> p.rarity(Rarity.UNCOMMON))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<StargazeBlock> STARGAZE_SINGULARITY_BLOCK = REGISTRATE.block("stargaze_singularity_block", StargazeBlock::new)
            .initialProperties(() -> Blocks.NETHERITE_BLOCK)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .properties(p -> p.sound(new ForgeSoundType(1, .75f, () -> SoundEvents.AMETHYST_CLUSTER_BREAK,
                    () -> SoundEvents.AMETHYST_CLUSTER_STEP, () -> SoundEvents.AMETHYST_CLUSTER_PLACE,
                    () -> SoundEvents.AMETHYST_CLUSTER_HIT, () -> SoundEvents.AMETHYST_CLUSTER_FALL)))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .properties(p -> p.strength(32f,512f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/stargaze_singularity"))
            .transform(pickaxeOnly())
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/stargaze_singularity"))
            .properties(p -> p.rarity(Rarity.EPIC))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> MOSSY_ANDESITE_ALLOY_BLOCK = REGISTRATE.block("mossy_andesite_alloy_block", Block::new)
            .initialProperties(() -> Blocks.ANDESITE)
            .properties(p -> p.mapColor(MapColor.STONE))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/mossy_andesite"))
            .transform(pickaxeOnly())
            .lang("Mossy Block of Andesite Alloy")
            .item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/mossy_andesite"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<Block> RAW_RUBBER_BLOCK = REGISTRATE.block("raw_rubber_block", Block::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
			.properties(p -> p.sound(new ForgeSoundType(0.9f, .75f, () -> DesiresSoundEvents.RUBBER_BREAK.get(),
					() -> SoundEvents.STEM_STEP, () -> DesiresSoundEvents.RUBBER_PLACE.get(),
					() -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
			.properties(p -> p.strength(0.5f,1.5f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/raw_rubber"))
			.lang("Block of Raw Rubber")
			.item()
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/raw_rubber"))
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.tag(rawRubberDecorTag)
			.build()
			.register();

	public static final BlockEntry<Block> RUBBER_BLOCK = REGISTRATE.block("rubber_block", Block::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_GRAY))
			.properties(p -> p.sound(new ForgeSoundType(0.9f, .6f, () -> DesiresSoundEvents.RUBBER_BREAK.get(),
					() -> SoundEvents.STEM_STEP, () -> DesiresSoundEvents.RUBBER_PLACE.get(),
					() -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
			.properties(p -> p.strength(0.5f,1.5f))
            .tag(Tags.Blocks.STORAGE_BLOCKS)
            .tag(AllTags.forgeBlockTag("storage_blocks/rubber"))
			.lang("Block of Rubber")
			.item()
            .tag(rubberDecorTag)
            .tag(Tags.Items.STORAGE_BLOCKS)
            .tag(AllTags.forgeItemTag("storage_blocks/rubber"))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.build()
			.register();

    // CASINGS

	public static final BlockEntry<CasingBlock> CREATIVE_CASING = REGISTRATE.block("creative_casing", CasingBlock::new)
			.transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.CREATIVE_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops())
            .properties(p -> p.sound(new ForgeSoundType(0.8f, .8f, () -> DesiresSoundEvents.CREATVEDITE_BREAK.get(),
					() -> DesiresSoundEvents.CREATVEDITE_STEP.get(), () -> DesiresSoundEvents.CREATVEDITE_PLACE.get(),
					() -> DesiresSoundEvents.CREATVEDITE_HIT.get(), () -> DesiresSoundEvents.CREATVEDITE_FALL.get())))
			.transform(pickaxeOnly())
			.properties(p -> p.lightLevel($ -> 5))
			.lang("Creative Casing")
			.item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.properties(p -> p.rarity(Rarity.EPIC))
			.build()
			.register();

    public static final BlockEntry<CasingBlock> MITHRIL_CASING = REGISTRATE.block("mithril_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.MITHRIL_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Mithril Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> BRONZE_CASING = REGISTRATE.block("bronze_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.BRONZE_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Hydraulic Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> ZINC_CASING = REGISTRATE.block("zinc_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.ZINC_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Zinc Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> TIN_CASING = REGISTRATE.block("tin_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.TIN_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_YELLOW)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Tin Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> BLAZE_GOLD_CASING = REGISTRATE.block("blaze_gold_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.BLAZE_GOLD_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Blaze Gold Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> NETHERITE_CASING = REGISTRATE.block("netherite_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.NETHERITE_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Hydraulic Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> OVERCHARGED_CASING = REGISTRATE.block("overcharged_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.OVERCHARGED_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Overcharged Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> REFINED_RADIANCE_CASING = REGISTRATE.block("refined_radiance_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.REFINED_RADIANCE_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Refined Radiance Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> SHADOW_STEEL_CASING = REGISTRATE.block("shadow_steel_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.SHADOW_STEEL_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Shadow Steel Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> STARGAZE_SINGULARITY_CASING = REGISTRATE.block("stargaze_singularity_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.STARGAZE_SINGULARITY_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_LIGHT_BLUE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Stargaze singularity Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> ELEMENTIUM_CASING = REGISTRATE.block("elementium_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.ELEMENTIUM_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_CYAN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Elementium Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> BRICK_CASING = REGISTRATE.block("brick_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.BRICK_CASING))
            .properties(p -> p.mapColor(MapColor.NETHER)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Brick Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> NETHER_BRICK_CASING = REGISTRATE.block("nether_brick_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.NETHER_BRICK_CASING))
            .properties(p -> p.mapColor(MapColor.NETHER)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Nether Brick Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> MOSSY_ANDESITE_CASING = REGISTRATE.block("mossy_andesite_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.MOSSY_ANDESITE_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_GREEN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Mossy Andesite Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> HYDRAULIC_CASING = REGISTRATE.block("hydraulic_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.HYDRAULIC_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Hydraulic Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> INDUSTRIAL_CASING = REGISTRATE.block("industrial_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.INDUSTRIAL_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .lang("Industrial Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> OVERBURDEN_CASING = REGISTRATE.block("overburden_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.OVERBURDEN_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .lang("Overburden Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> STEEL_CASING = REGISTRATE.block("steel_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.STEEL_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_GRAY)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Steel Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> TERRASTEEL_CASING = REGISTRATE.block("terrasteel_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.TERRASTEEL_CASING))
            .properties(p -> p.mapColor(MapColor.COLOR_BROWN)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Terrasteel Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> REINFORCEMENT_PLATING = REGISTRATE.block("reinforcement_plating", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.REINFORCEMENT_PLATING))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Reinforcement Plating")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<CasingBlock> FAUXVAULT_CASING = REGISTRATE.block("fauxvault_casing", CasingBlock::new)
			.transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.FAUXVAULT_CASING))
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
					.requiresCorrectToolForDrops()
					.sound(SoundType.NETHERITE_BLOCK))
			.transform(pickaxeOnly())
			.lang("Faux Vault Casing")
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.build()
			.register();

    public static final BlockEntry<CasingBlock> HEAVY_BRASS_CASING = REGISTRATE.block("heavy_brass_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.HEAVY_BRASS_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .lang("Heavy brass Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> INDUSTRIAL_BRASS_CASING = REGISTRATE.block("industrial_brass_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.INDUSTRIAL_BRASS_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .lang("Industrial brass Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> FAUX_INDUSTRIAL_BRASS_CASING = REGISTRATE.block("faux_industrial_brass_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.FAUX_INDUSTRIAL_BRASS_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .lang("Faux industrial brass Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CasingBlock> TECHBRAIN_CASING = REGISTRATE.block("techbrain_casing", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.TECHBRAIN_CASING))
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.NETHERITE_BLOCK))
            .transform(pickaxeOnly())
            .lang("Techbrain Casing")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    // KINETICS

    public static final BlockEntry<Block> PONDER_LIGHT = REGISTRATE.block("pondering_block_light", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_GRAY))
            .properties(p -> p.sound(new ForgeSoundType(1, 2f, () -> SoundEvents.AMETHYST_BLOCK_BREAK,
                    () -> SoundEvents.SNOW_STEP, () -> SoundEvents.DEEPSLATE_BRICKS_PLACE,
                    () -> SoundEvents.NETHERITE_BLOCK_HIT, () -> SoundEvents.NETHERITE_BLOCK_FALL)))
            .properties(p -> p.strength(1f,5000f))
            .lang("Light pondering block")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> PONDER_DARK = REGISTRATE.block("pondering_block_dark", Block::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_GRAY))
            .properties(p -> p.sound(new ForgeSoundType(1, 2f, () -> SoundEvents.AMETHYST_BLOCK_BREAK,
                    () -> SoundEvents.SNOW_STEP, () -> SoundEvents.DEEPSLATE_BRICKS_PLACE,
                    () -> SoundEvents.NETHERITE_BLOCK_HIT, () -> SoundEvents.NETHERITE_BLOCK_FALL)))
            .properties(p -> p.strength(1f,5000f))
            .lang("Dark pondering block")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<BronzeSawBlock> BRONZE_SAW = REGISTRATE.block("bronze_saw", BronzeSawBlock::new)
            .initialProperties(SharedProperties::stone)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(axeOrPickaxe())
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 12.0))
            .onRegister(movementBehaviour(new BronzeSawMovementBehaviour()))
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<RadiantSawBlock> RADIANT_SAW = REGISTRATE.block("radiant_saw", RadiantSawBlock::new)
            .initialProperties(SharedProperties::stone)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .transform(axeOrPickaxe())
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 12.0))
            .onRegister(movementBehaviour(new RadiantSawMovementBehaviour()))
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ShadowSawBlock> SHADOW_SAW = REGISTRATE.block("shadow_saw", ShadowSawBlock::new)
            .initialProperties(SharedProperties::stone)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(p -> p.mapColor(MapColor.COLOR_BLACK))
            .transform(axeOrPickaxe())
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 12.0))
            .onRegister(movementBehaviour(new ShadowSawMovementBehaviour()))
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<BronzeDrillBlock> BRONZE_DRILL = REGISTRATE.block("bronze_drill", BronzeDrillBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
            .transform(axeOrPickaxe())
            .blockstate(BlockStateGen.directionalBlockProvider(true))
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 12.0))
            .onRegister(movementBehaviour(new BronzeDrillMovementBehaviour()))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
            .transform(customItemModel())
            .register();

    public static final BlockEntry<RadiantDrillBlock> RADIANT_DRILL = REGISTRATE.block("radiant_drill", RadiantDrillBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
            .addLayer(() -> RenderType::translucent)
            .transform(axeOrPickaxe())
            .blockstate(BlockStateGen.directionalBlockProvider(true))
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 16.0))
            .onRegister(movementBehaviour(new RadiantDrillMovementBehaviour()))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
            .transform(customItemModel())
            .register();

    public static final BlockEntry<ShadowDrillBlock> SHADOW_DRILL = REGISTRATE.block("shadow_drill", ShadowDrillBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BLACK))
            .transform(axeOrPickaxe())
            .blockstate(BlockStateGen.directionalBlockProvider(true))
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 16.0))
            .onRegister(movementBehaviour(new ShadowDrillMovementBehaviour()))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .tag(AllTags.AllItemTags.CONTRAPTION_CONTROLLED.tag)
            .transform(customItemModel())
            .register();

    public static final BlockEntry<SpectralRubyLampBlock> SPECTRAL_RUBY_LAMP = REGISTRATE.block("spectral_ruby_lamp", SpectralRubyLampBlock::new)
            .initialProperties(() -> Blocks.REDSTONE_LAMP)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PINK)
                    .noOcclusion()
                    .lightLevel(s -> s.getValue(SpectralRubyLampBlock.POWER)))
            .transform(pickaxeOnly())
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<IndustrialFanBlock> INDUSTRIAL_FAN = REGISTRATE.block("industrial_fan", IndustrialFanBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.noOcclusion()
					.mapColor(MapColor.TERRACOTTA_CYAN)
					.requiresCorrectToolForDrops()
					.sound(SoundType.NETHERITE_BLOCK))
			.blockstate(BlockStateGen.directionalBlockProvider(true))
			.addLayer(() -> RenderType::cutoutMipped)
			.transform(pickaxeOnly())
			.onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 4.0))
			.onRegister(block -> BlockStressValues.CAPACITIES.register(block, () -> 16.0))
			.recipe((c, p) -> {
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 4)
						.pattern("CIP")
						.define('P', AllItems.PROPELLER.get())
						.define('C', AllBlocks.COGWHEEL.get())
						.define('I', INDUSTRIAL_CASING.get())
						.unlockedBy("has_casing", has(INDUSTRIAL_CASING.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName()));
			})
			.lang("Industrial Fan")
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();


	public static final BlockEntry<HydraulicPressBlock> HYDRAULIC_PRESS = REGISTRATE.block("hydraulic_press", HydraulicPressBlock::new)
			.initialProperties(SharedProperties::copperMetal)
			.properties(BlockBehaviour.Properties::noOcclusion)
			.properties(p -> p.noOcclusion().mapColor(MapColor.TERRACOTTA_ORANGE))
			.transform(pickaxeOnly())
			.blockstate(BlockStateGen.horizontalBlockProvider(true))
			.onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 64.0))
			.item(AssemblyOperatorBlockItem::new)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

    public static final BlockEntry<GoldenMixerBlock> GOLDEN_MIXER = REGISTRATE
            .block("gold_mixer", GoldenMixerBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion().mapColor(MapColor.STONE))
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
            .addLayer(() -> RenderType::cutoutMipped)
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
            .recipe((c, p) -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 1)
                    .pattern("A").pattern("B").pattern("C")
                    .define('A', AllItems.PRECISION_MECHANISM.get())
                    .define('B', AllBlocks.BRASS_CASING.get())
                    .define('C', DesiresItems.GOLDEN_WHISK.get())
                    .unlockedBy("has_" + c.getName(), has(c.get()))
                    .save(p, DesiresCreate.asResource("crafting/" + c.getName())))
            .item(AssemblyOperatorBlockItem::new)
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(customItemModel())
            .lang("Golden Mixer")
            .register();

	public static final BlockEntry<BoreBlock> BORE_BLOCK = REGISTRATE.block("bore_block", BoreBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.mapColor(MapColor.STONE))
			.properties(p -> p.sound(new ForgeSoundType(0.9f, 1.25f, () -> SoundEvents.NETHERITE_BLOCK_BREAK,
					() -> SoundEvents.NETHERITE_BLOCK_STEP, () -> SoundEvents.NETHERITE_BLOCK_PLACE,
					() -> SoundEvents.NETHERITE_BLOCK_HIT, () -> SoundEvents.NETHERITE_BLOCK_FALL)))
			.onRegister(movementBehaviour(new BoreBlockMovementBehaviour()))
			.transform(pickaxeOnly())
			.recipe((c, p) -> {
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 4)
						.pattern("AIA")
						.pattern("ICI")
						.pattern("AIA")
						.define('A', AllItems.ANDESITE_ALLOY.get())
						.define('C', AllBlocks.ANDESITE_ALLOY_BLOCK.get())
						.define('I', Items.IRON_INGOT)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName()));
			})
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.build()
			.register();

	public static final BlockEntry<MultiMeterBlock> MULTIMETER = REGISTRATE.block("multimeter", MultiMeterBlock::new)
			.initialProperties(SharedProperties::wooden)
			.properties(p -> p.mapColor(MapColor.PODZOL))
			.transform(axeOrPickaxe())
			.onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0))
			.blockstate(new GaugeGenerator()::generate)
			.transform(DisplaySource.displaySource(AllDisplaySources.KINETIC_SPEED))
			.transform(DisplaySource.displaySource(AllDisplaySources.KINETIC_STRESS))
			.recipe((c, p) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 2)
					.requires(AllBlocks.STRESSOMETER.get())
					.requires(AllBlocks.SPEEDOMETER.get())
					.unlockedBy("has_compass", has(Items.COMPASS))
					.save(p, DesiresCreate.asResource("crafting/multimeter")))
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(ModelGen.customItemModel("gauge", "_", "item"))
			.register();

	public static final BlockEntry<RedstoneDividerBlock> REDSTONE_DIVIDER = REGISTRATE.block("redstone_divider", RedstoneDividerBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.noOcclusion().mapColor(MapColor.PODZOL))
			.addLayer(() -> RenderType::cutoutMipped)
			.onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0))
			.transform(axeOrPickaxe())
			.blockstate((c, p) -> BlockStateGen.axisBlock(c, p, s -> {
			int power = s.getValue(BlockStateProperties.POWER);
				return AssetLookup.partialBaseModel(c, p, "power_" + (
				power == 0 || power == 1 || power == 2 ? 0 :
				power == 3 || power == 4 || power == 5 ? 1 :
				power == 6 || power == 7 || power == 8 ? 2 :
				power == 9 || power == 10 || power == 11 ? 3 : 4));
			}))
			.recipe((c, p) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
					.requires(AllBlocks.ANDESITE_CASING.get())
					.requires(AllBlocks.LARGE_COGWHEEL.get())
					.requires(Items.REDSTONE)
					.unlockedBy("has_cogwheel", has(AllBlocks.COGWHEEL.get()))
					.save(p, DesiresCreate.asResource("crafting/kinetics/redstone_divider")))
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

	public static final BlockEntry<InverseBoxBlock> INVERSE_BOX = REGISTRATE.block("inverse_box", InverseBoxBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.noOcclusion().mapColor(MapColor.PODZOL))
			.addLayer(() -> RenderType::cutoutMipped)
			.onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0))
			.transform(axeOrPickaxe())
			.blockstate(BlockStateGen.axisBlockProvider(true))
			.recipe((c, p) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
					.requires(AllBlocks.ANDESITE_CASING.get())
					.requires(AllBlocks.COGWHEEL.get())
					.unlockedBy("has_cogwheel", has(AllBlocks.COGWHEEL.get()))
					.save(p, DesiresCreate.asResource("crafting/kinetics/inverse_box")))
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

    public static final BlockEntry<OmniGearboxBlock> OMNI_GEARBOX = REGISTRATE
            .block("omni_gearbox", OmniGearboxBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.lightLevel($ -> 2).noOcclusion().mapColor(MapColor.TERRACOTTA_CYAN))
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> simpleBlock(c, p, $ -> AssetLookup.partialBaseModel(c, p)))
            .item()
            .recipe((c, p) -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 2)
                    .pattern(" V ").pattern("HCH").pattern(" V ")
                    .define('V', AllItems.VERTICAL_GEARBOX.get())
                    .define('H', AllBlocks.GEARBOX.get())
                    .define('C', AllBlocks.BRASS_CASING.get())
                    .unlockedBy("has_casing", has(AllBlocks.BRASS_CASING.get()))
                    .save(p, DesiresCreate.asResource("crafting/" + c.getName())))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(customItemModel())
            .register();

    public static final BlockEntry<OmniSpeedControllerBlock> OMNI_SPEED_CONTROLLER = REGISTRATE
            .block("omni_speed_controller", OmniSpeedControllerBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion().mapColor(MapColor.TERRACOTTA_BROWN))
            .addLayer(() -> RenderType::cutoutMipped)
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
            .transform(axeOrPickaxe())
            .blockstate(BlockStateGen.axisBlockProvider(true))
            .recipe((c, p) -> ShapedRecipeBuilder.shaped(RecipeCategory.MISC, c.get(), 1)
                    .pattern("CBC")
                    .define('C', AllBlocks.LARGE_COGWHEEL.get())
                    .define('B', AllBlocks.ROTATION_SPEED_CONTROLLER.get())
                    .unlockedBy("has_" + c.getName(), has(c.get()))
                    .save(p, DesiresCreate.asResource("crafting/" + c.getName())))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(customItemModel())
            .register();

    public static final BlockEntry<KineticMotorBlock> KINETIC_MOTOR = REGISTRATE
			.block("kinetic_motor", KineticMotorBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.mapColor(MapColor.COLOR_GRAY))
			.tag(AllTags.AllBlockTags.SAFE_NBT.tag)
			.transform(axeOrPickaxe())
			.recipe((c, p) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
					.requires(AllBlocks.ANDESITE_CASING.get())
					.requires(DesiresItems.KINETIC_MECHANISM.get())
					.unlockedBy("has_kinetic_mechanism", has(DesiresItems.KINETIC_MECHANISM.get()))
					.save(p, DesiresCreate.asResource("crafting/kinetics/kinetic_motor")))
			.blockstate(new CreativeMotorGenerator()::generate)
			.onRegister(block -> BlockStressValues.CAPACITIES.register(block, () -> 48.0))
			.onRegister(block -> BlockStressValues.RPM.register(block, new BlockStressValues.GeneratedRpm(32, true)))
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

	public static final BlockEntry<AcceleratorMotorBlock> ACCELERATOR_MOTOR = REGISTRATE
			.block("accelerator_motor", AcceleratorMotorBlock::new)
			.initialProperties(SharedProperties::stone)
			.properties(p -> p.mapColor(MapColor.COLOR_YELLOW))
			.tag(AllTags.AllBlockTags.SAFE_NBT.tag)
			.transform(axeOrPickaxe())
			.blockstate(new CreativeMotorGenerator()::generate)
			.onRegister(block -> BlockStressValues.CAPACITIES.register(block, () -> 0.0))
			.onRegister(block -> BlockStressValues.RPM.register(block, new BlockStressValues.GeneratedRpm(256, true)))
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

    public static final BlockEntry<CreativeGearMotorBlock> CREATIVE_GEAR_MOTOR = REGISTRATE
            .block("creative_gear_motor", CreativeGearMotorBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.mapColor(MapColor.COLOR_PURPLE).forceSolidOn())
            .tag(AllTags.AllBlockTags.SAFE_NBT.tag)
            .transform(pickaxeOnly())
            .blockstate(BlockStateGen.directionalBlockProviderIgnoresWaterlogged(true))
            .onRegister(block -> BlockStressValues.CAPACITIES.register(block, () -> 16384.0))
            .onRegister(BlockStressValues.setGeneratorSpeed(256, true))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .properties(p -> p.rarity(Rarity.EPIC))
            .transform(customItemModel())
            .register();

    public static final BlockEntry<CogCrankBlock> COG_CRANK = REGISTRATE.block("cog_crank", CogCrankBlock::new)
			.initialProperties(SharedProperties::wooden)
			.properties(p -> p.mapColor(MapColor.PODZOL))
			.transform(axeOrPickaxe())
			.blockstate(BlockStateGen.directionalBlockProvider(true))
			.onRegister(block -> BlockStressValues.CAPACITIES.register(block, () -> 8.0))
			.onRegister(block -> BlockStressValues.RPM.register(block, new BlockStressValues.GeneratedRpm(32, false)))
			.tag(AllTags.AllBlockTags.BRITTLE.tag)
			.recipe((ctx, prov) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ctx.getEntry(), 1)
					.requires(AllBlocks.HAND_CRANK.get())
					.requires(AllBlocks.COGWHEEL.get())
					.unlockedBy("has_item", RegistrateRecipeProvider.has(ctx.get()))
					.save(prov))
			.onRegister(ItemUseOverrides::addBlock)
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

	public static final BlockEntry<FurnaceEngineBlock> FURNACE_ENGINE = REGISTRATE.block("furnace_engine", FurnaceEngineBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN)
                    .sound(SoundType.NETHERITE_BLOCK))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(pickaxeOnly())
            .tag(AllTags.AllBlockTags.BRITTLE.tag)
            .blockstate(new FurnaceEngineGenerator()::generate)
            .onRegister(block -> BlockStressValues.CAPACITIES.register(block, () -> 256.0))
            .onRegister(block -> BlockStressValues.RPM.register(block, new BlockStressValues.GeneratedRpm(32, true)))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(ModelGen.customItemModel())
            .register();

	public static final BlockEntry<PoweredFlywheelBlock> POWERED_FLYWHEEL = REGISTRATE.block("powered_flywheel", PoweredFlywheelBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.METAL))
            .transform(pickaxeOnly())
            .blockstate(BlockStateGen.axisBlockProvider(false))
            .loot((lt, block) -> lt.dropOther(block, AllBlocks.FLYWHEEL.get()))
            .register();

    public static final BlockEntry<TwoBladeFanBlock> TWO_BLADE_FAN = REGISTRATE.block("2_blade_fan", TwoBladeFanBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(axeOrPickaxe())
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
            .blockstate(BlockStateGen.axisBlockProvider(true))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(customItemModel())
            .register();

    public static final BlockEntry<FourBladeFanBlock> FOUR_BLADE_FAN = REGISTRATE.block("4_blade_fan", FourBladeFanBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(axeOrPickaxe())
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
            .blockstate(BlockStateGen.axisBlockProvider(true))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(customItemModel())
            .register();

    public static final BlockEntry<EightBladeFanBlock> EIGHT_BLADE_FAN = REGISTRATE.block("8_blade_fan", EightBladeFanBlock::new)
            .initialProperties(SharedProperties::softMetal)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_YELLOW))
            .properties(BlockBehaviour.Properties::noOcclusion)
            .transform(axeOrPickaxe())
            .onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
            .blockstate(BlockStateGen.axisBlockProvider(true))
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .transform(customItemModel())
            .register();

	public static final BlockEntry<GiantGearBlock> GIANT_GEAR = REGISTRATE.block("giant_gear", GiantGearBlock::new)
			.initialProperties(SharedProperties::netheriteMetal)
			.properties(p -> p.noOcclusion().sound(SoundType.METAL).mapColor(MapColor.COLOR_YELLOW))
			.transform(pickaxeOnly())
			.onRegister(block -> BlockStressValues.IMPACTS.register(block, () -> 0.0))
			.blockstate(BlockStateGen.axisBlockProvider(true))
			.item(GiantGearBlockItem::new)
			.tab(DesiresCreativeModeTabs.BETA_CREATIVE_TAB.getKey())
			.transform(customItemModel())
			.register();

	public static final BlockEntry<GiantGearStructuralBlock> GIANT_GEAR_STRUCTURAL = REGISTRATE.block("giant_gear_structure", GiantGearStructuralBlock::new)
			.initialProperties(SharedProperties::netheriteMetal)
			.blockstate((c, p) -> p.getVariantBuilder(c.get())
					.forAllStatesExcept(BlockStateGen.mapToAir(p), GiantGearStructuralBlock.FACING))
			.properties(p -> p.noOcclusion().sound(SoundType.METAL).mapColor(MapColor.COLOR_YELLOW))
			.transform(pickaxeOnly())
			.lang("Giant Gear")
			.register();


	public static final BlockEntry<ItemStockpileBlock> ITEM_STOCKPILE = REGISTRATE.block("item_stockpile", ItemStockpileBlock::new)
			.initialProperties(SharedProperties::softMetal)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_BLUE)
					.sound(SoundType.NETHERITE_BLOCK)
					.explosionResistance(1200))
			.transform(pickaxeOnly())
			.blockstate((c, p) -> p.getVariantBuilder(c.get())
					.forAllStates(s -> ConfiguredModel.builder()
							.modelFile(AssetLookup.standardModel(c, p))
							.build()))
			.onRegister(connectedTextures(ItemStockpileCTBehaviour::new))
			.onRegisterAfter(CreateRegistries.MOUNTED_ITEM_STORAGE_TYPE, block ->
					MountedItemStorageType.REGISTRY.register(block, DesiresMountedStorageTypes.ITEM_STOCKPILE.get()))
			.item(ItemStockpileItem::new)
			.recipe((c, p) -> {
				p.stonecutting(DataIngredient.items(AllBlocks.ITEM_VAULT.get()), RecipeCategory.BUILDING_BLOCKS, c::get, 1);
				p.stonecutting(DataIngredient.items(c), RecipeCategory.BUILDING_BLOCKS, AllBlocks.ITEM_VAULT::get, 1);

				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
						.define('B', AllTags.forgeItemTag("plates/iron"))
						.define('C', Tags.Items.BARRELS_WOODEN)
						.pattern("BCB")
						.unlockedBy("has_barrel", has(Tags.Items.BARRELS_WOODEN))
						.save(p, DesiresCreate.asResource("crafting/kinetics/" + c.getName()));
			})
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.build()
			.register();

	public static final BlockEntry<FluidReservoirBlock> FLUID_RESERVOIR = REGISTRATE.block("fluid_reservoir", FluidReservoirBlock::new)
			.initialProperties(SharedProperties::copperMetal)
			.properties(p -> p.noOcclusion().isRedstoneConductor((p1, p2, p3) -> true))
			.transform(pickaxeOnly())
			.blockstate((c, p) -> p.getVariantBuilder(c.get())
					.forAllStates(s -> ConfiguredModel.builder()
							.modelFile(AssetLookup.standardModel(c, p))
							.rotationY(s.getValue(FluidReservoirBlock.HORIZONTAL_AXIS) == Direction.Axis.X ? 90 : 0)
							.build()))
			.onRegister(connectedTextures(FluidReservoirCTBehaviour::new))
			.onRegisterAfter(CreateRegistries.MOUNTED_FLUID_STORAGE_TYPE, block ->
					MountedFluidStorageType.REGISTRY.register(block, DesiresMountedStorageTypes.FLUID_RESERVOIR.get()))
			.item(FluidReservoirItem::new)
			.recipe((c, p) -> {
				p.stonecutting(DataIngredient.items(AllBlocks.FLUID_TANK.get()), RecipeCategory.BUILDING_BLOCKS, c::get, 1);
				p.stonecutting(DataIngredient.items(c.get()), RecipeCategory.BUILDING_BLOCKS, AllBlocks.FLUID_TANK::get, 1);

				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
						.define('B', AllTags.forgeItemTag("plates/copper"))
						.define('C', Tags.Items.BARRELS_WOODEN)
						.pattern("BCB")
						.unlockedBy("has_barrel", has(Tags.Items.BARRELS_WOODEN))
						.save(p, DesiresCreate.asResource("crafting/kinetics/" + c.getName()));
			})
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.build()
			.register();

    // CATALYST SAILS

	public static final BlockEntry<FanSailBlock> SPLASHING_SAIL = REGISTRATE.block("splashing_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(AllTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_SPLASHING.tag)
            .recipe((c, p) -> fanSailCrafting(c.get(), Items.WATER_BUCKET, p, c))
            .lang("Splashing Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<FanSailBlock> HAUNTING_SAIL = REGISTRATE.block("haunting_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .properties(p -> p.lightLevel(s -> 8))
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(AllTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_HAUNTING.tag)
            .recipe((c, p) -> fanSailCrafting(c.get(), Items.SOUL_CAMPFIRE, p, c))
            .lang("Haunting Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<FanSailBlock> SMOKING_SAIL = REGISTRATE.block("smoking_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .properties(p -> p.lightLevel(s -> 8))
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(AllTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_SMOKING.tag)
            .recipe((c, p) -> fanSailCrafting(c.get(), Items.CAMPFIRE, p, c))
            .lang("Smoking Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<FanSailBlock> BLASTING_SAIL = REGISTRATE.block("blasting_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .properties(p -> p.lightLevel(s -> 12))
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(AllTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_BLASTING.tag)
            .recipe((c, p) -> fanSailCrafting(c.get(), Items.LAVA_BUCKET, p, c))
            .lang("Blasting Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<FanSailBlock> SEETHING_SAIL = REGISTRATE.block("seething_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .properties(p -> p.lightLevel(s -> 15))
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(DesiresTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_SEETHING.tag)
            .tag(DesiresTags.AllBlockTags.INDUSTRIAL_FAN_HEATER.tag)
            .lang("Seething Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<FanSailBlock> FREEZING_SAIL = REGISTRATE.block("freezing_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(DesiresTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_FREEZING.tag)
            .recipe((c, p) -> fanSailCrafting(c.get(), Items.POWDER_SNOW_BUCKET, p, c))
            .lang("Freezing Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

	public static final BlockEntry<FanSailBlock> SANDING_SAIL = REGISTRATE.block("sanding_sail", FanSailBlock::sail)
            .initialProperties(SharedProperties::wooden)
            .properties(p -> p.mapColor(MapColor.DIRT))
            .properties(p -> p.sound(SoundType.SCAFFOLDING)
                    .noOcclusion())
            .transform(axeOnly())
            .blockstate(BlockStateGen.directionalBlockProvider(false))
            .tag(AllTags.AllBlockTags.WINDMILL_SAILS.tag)
            .tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag)
            .tag(DesiresTags.AllBlockTags.FAN_PROCESSING_CATALYSTS_SANDING.tag)
            .recipe((c, p) -> fanSailCrafting(c.get(), Items.SAND, p, c))
            .lang("Sanding Catalyst Sail")
            .item()
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .build()
            .register();

    // COBBLES

    public static final BlockEntry<Block> POTASSIC_COBBLE =
            REGISTRATE.block("potassic_cobble", Block::new)
                    .initialProperties(() -> Blocks.DEEPSLATE)
                    .properties(p -> p.destroyTime(2.25f).mapColor(MapColor.TERRACOTTA_BLUE))
                    .properties(p -> p.sound(new ForgeSoundType(0.8f, 0.85f, () -> DesiresSoundEvents.ORE_STONE_BREAK.get(),
                            () -> DesiresSoundEvents.ORE_STONE_STEP.get(), () -> DesiresSoundEvents.ORE_STONE_PLACE.get(),
                            () -> DesiresSoundEvents.ORE_STONE_HIT.get(), () -> DesiresSoundEvents.ORE_STONE_FALL.get())))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .transform(pickaxeOnly())
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> ASURINE_COBBLE =
            REGISTRATE.block("asurine_cobble", Block::new)
                    .initialProperties(() -> Blocks.DEEPSLATE)
                    .properties(p -> p.destroyTime(2.25f).mapColor(MapColor.COLOR_BLUE))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .transform(pickaxeOnly())
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> CRIMSITE_COBBLE =
            REGISTRATE.block("crimsite_cobble", Block::new)
                    .initialProperties(() -> Blocks.DEEPSLATE)
                    .properties(p -> p.destroyTime(2.25f).mapColor(MapColor.COLOR_RED))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .transform(pickaxeOnly())
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> OCHRUM_COBBLE =
            REGISTRATE.block("ochrum_cobble", Block::new)
                    .initialProperties(() -> Blocks.CALCITE)
                    .properties(p -> p.destroyTime(2.25f).mapColor(MapColor.TERRACOTTA_YELLOW))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .transform(pickaxeOnly())
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> VERIDIUM_COBBLE =
            REGISTRATE.block("veridium_cobble", Block::new)
                    .initialProperties(() -> Blocks.TUFF)
                    .properties(p -> p.destroyTime(2.25f).mapColor(MapColor.WARPED_NYLIUM))
                    .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
                    .transform(pickaxeOnly())
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    // SCAFFOLDS

    public static final BlockEntry<MetalScaffoldingBlock> TRAIN_SCAFFOLD = REGISTRATE.block("train_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("train",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("plates/obsidian")), MapColor.COLOR_BLACK,
                    DesiresSpriteShifts.TRAIN_SCAFFOLD, DesiresSpriteShifts.TRAIN_SCAFFOLD_INSIDE, AllSpriteShifts.RAILWAY_CASING))
            .lang("Train Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> HYDRAULIC_SCAFFOLD = REGISTRATE.block("hydraulic_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("hydraulic",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/copper")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.HYDRAULIC_SCAFFOLD, DesiresSpriteShifts.HYDRAULIC_SCAFFOLD_INSIDE, DesiresSpriteShifts.HYDRAULIC_CASING))
            .lang("Hydraulic Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> OVERBURDEN_SCAFFOLD = REGISTRATE.block("overburden_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("overburden",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/lapis_alloy")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.OVERBURDEN_SCAFFOLD, DesiresSpriteShifts.OVERBURDEN_SCAFFOLD_INSIDE, DesiresSpriteShifts.OVERBURDEN_CASING))
            .lang("Overburden Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> INDUSTRIAL_SCAFFOLD = REGISTRATE.block("industrial_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("industrial",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/industrial_iron")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.INDUSTRIAL_SCAFFOLD, DesiresSpriteShifts.INDUSTRIAL_SCAFFOLD_INSIDE, DesiresSpriteShifts.INDUSTRIAL_CASING))
            .lang("Industrial Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> MITHRIL_SCAFFOLD = REGISTRATE.block("mithril_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("mithril",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/mithril")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.MITHRIL_SCAFFOLD, DesiresSpriteShifts.MITHRIL_SCAFFOLD_INSIDE, DesiresSpriteShifts.MITHRIL_CASING))
            .lang("Mithril Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> MOSSY_ANDESITE_SCAFFOLD = REGISTRATE.block("mossy_andesite_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("mossy_andesite",
                    () -> DataIngredient.items(AllItems.ANDESITE_ALLOY.get()),
                    MapColor.STONE, DesiresSpriteShifts.MOSSY_ANDESITE_SCAFFOLD, DesiresSpriteShifts.MOSSY_ANDESITE_SCAFFOLD_INSIDE, DesiresSpriteShifts.MOSSY_ANDESITE_CASING))
            .lang("Mossy Andesite Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> ZINC_SCAFFOLD = REGISTRATE.block("zinc_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("zinc",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/zinc")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.ZINC_SCAFFOLD, DesiresSpriteShifts.ZINC_SCAFFOLD_INSIDE, DesiresSpriteShifts.ZINC_CASING))
            .lang("Zinc Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> TIN_SCAFFOLD = REGISTRATE.block("tin_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("tin",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/tin")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.TIN_SCAFFOLD, DesiresSpriteShifts.TIN_SCAFFOLD_INSIDE, DesiresSpriteShifts.TIN_CASING))
            .lang("Tin Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> BRONZE_SCAFFOLD = REGISTRATE.block("bronze_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("bronze",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/bronze")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.BRONZE_SCAFFOLD, DesiresSpriteShifts.BRONZE_SCAFFOLD_INSIDE, DesiresSpriteShifts.BRONZE_CASING))
            .lang("Bronze Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> STEEL_SCAFFOLD = REGISTRATE.block("steel_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("steel",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/steel")), MapColor.TERRACOTTA_YELLOW,
                    DesiresSpriteShifts.STEEL_SCAFFOLD, DesiresSpriteShifts.STEEL_SCAFFOLD_INSIDE, DesiresSpriteShifts.STEEL_CASING))
            .lang("Steel Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> SHADOW_SCAFFOLD = REGISTRATE.block("shadow_steel_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("shadow_steel",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/shadow_steel")), MapColor.COLOR_BLACK,
                    DesiresSpriteShifts.SHADOW_STEEL_SCAFFOLD, DesiresSpriteShifts.SHADOW_STEEL_SCAFFOLD_INSIDE, DesiresSpriteShifts.SHADOW_STEEL_CASING))
            .lang("Shadow Steel Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> RADIANT_SCAFFOLD = REGISTRATE.block("refined_radiance_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("refined_radiance",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/refined_radiance")), MapColor.SNOW,
                    DesiresSpriteShifts.REFINED_RADIANCE_SCAFFOLD, DesiresSpriteShifts.REFINED_RADIANCE_SCAFFOLD_INSIDE, DesiresSpriteShifts.REFINED_RADIANCE_CASING))
            .lang("Radiant Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> STARGAZE_SINGULARITY_SCAFFOLD = REGISTRATE.block("stargaze_singularity_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("stargaze_singularity",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/stargaze_singularity")), MapColor.TERRACOTTA_BLACK,
                    DesiresSpriteShifts.STARGAZE_SINGULARITY_SCAFFOLD, DesiresSpriteShifts.STARGAZE_SINGULARITY_SCAFFOLD_INSIDE, DesiresSpriteShifts.STARGAZE_SINGULARITY_CASING))
            .lang("Stargaze Singularity Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> BLAZE_GOLD_SCAFFOLD = REGISTRATE.block("blaze_gold_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("blaze_gold",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/blaze_gold")), MapColor.COLOR_RED,
                    DesiresSpriteShifts.BLAZE_GOLD_SCAFFOLD, DesiresSpriteShifts.BLAZE_GOLD_SCAFFOLD_INSIDE, DesiresSpriteShifts.BLAZE_GOLD_CASING))
            .lang("Blaze Gold Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> OVERCHARGED_SCAFFOLD = REGISTRATE.block("overcharged_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("overcharge",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/overcharge")), MapColor.COLOR_LIGHT_BLUE,
                    DesiresSpriteShifts.OVERCHARGED_SCAFFOLD, DesiresSpriteShifts.OVERCHARGED_SCAFFOLD_INSIDE, DesiresSpriteShifts.OVERCHARGED_CASING))
            .lang("Overcharged Scaffolding")
            .register();

    public static final BlockEntry<MetalScaffoldingBlock> NETHERITE_SCAFFOLD = REGISTRATE.block("netherite_scaffolding", MetalScaffoldingBlock::new)
            .transform(BuilderTransformers.scaffold("netherite",
                    () -> DataIngredient.tag(AllTags.forgeItemTag("ingots/netherite")), MapColor.COLOR_LIGHT_BLUE,
                    DesiresSpriteShifts.NETHERITE_SCAFFOLD, DesiresSpriteShifts.NETHERITE_SCAFFOLD_INSIDE, DesiresSpriteShifts.NETHERITE_CASING))
            .lang("Netherite Scaffolding")
            .register();

    // GLASSES

    public static final BlockEntry<GlassBlock> VERTICAL_FRAMED_SPLIT_GLASS = REGISTRATE.block("vertical_framed_split_glass", GlassBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.VERTICAL_FRAMED_SPLIT_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<GlassBlock> HORIZONTAL_FRAMED_SPLIT_GLASS = REGISTRATE.block("horizontal_framed_split_glass", GlassBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.HORIZONTAL_FRAMED_SPLIT_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<GlassBlock> FRAMED_SPLIT_GLASS = REGISTRATE.block("framed_split_glass", GlassBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.FRAMED_SPLIT_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<GlassBlock> ORNATE_IRON_GLASS = REGISTRATE.block("ornate_iron_glass", GlassBlock::new)
            .transform(BuilderTransgender.blockv2(() -> DesiresSpriteShifts.ORNATE_IRON_GLASS, () -> DesiresSpriteShifts.ORNATE_IRON_GLASS_TOP))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ConnectedGlassPaneBlock> VERTICAL_FRAMED_SPLIT_GLASS_PANE = REGISTRATE.block("vertical_framed_split_glass_pane", ConnectedGlassPaneBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.VERTICAL_FRAMED_SPLIT_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ConnectedGlassPaneBlock> HORIZONTAL_FRAMED_SPLIT_GLASS_PANE = REGISTRATE.block("horizontal_framed_split_glass_pane", ConnectedGlassPaneBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.HORIZONTAL_FRAMED_SPLIT_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ConnectedGlassPaneBlock> FRAMED_SPLIT_GLASS_PANE = REGISTRATE.block("framed_split_glass_pane", ConnectedGlassPaneBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.FRAMED_SPLIT_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .properties(BlockBehaviour.Properties::noOcclusion)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ConnectedGlassPaneBlock> ORNATE_IRON_GLASS_PANE = REGISTRATE.block("ornate_iron_glass_pane", ConnectedGlassPaneBlock::new)
            .transform(BuilderTransgender.block(() -> DesiresSpriteShifts.ORNATE_IRON_GLASS))
            .initialProperties(() -> Blocks.GLASS)
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static void fanSailCrafting(ItemLike itemLike, ItemLike cataylst, Consumer<FinishedRecipe> pFinishedRecipeConsumer, DataGenContext c) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, itemLike, 4)
                .pattern("SCS")
                .pattern("CRC")
                .pattern("SCS")
                .define('S', AllBlocks.SAIL_FRAME.get())
                .define('R', DesiresBlocks.RUBBER_BLOCK.get())
                .define('C', cataylst)
                .unlockedBy("has_cataylst", has(cataylst))
                .save(pFinishedRecipeConsumer, DesiresCreate.asResource("crafting/fan_catalyst/" + c.getName()));
    }

    //WOODSET BLOCKS

    //ROSE WOODSET

    public static final BlockEntry<CanBurnRotatedBlockPillar> ROSE_LOG = REGISTRATE.block("rose_log", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.OAK_LOG)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnRotatedBlockPillar> STRIPPED_ROSE_LOG = REGISTRATE.block("stripped_rose_log", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_OAK_LOG)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Stripped Rose Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnRotatedBlockPillar> ROSE_WOOD = REGISTRATE.block("rose_wood", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.OAK_WOOD)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnRotatedBlockPillar> STRIPPED_ROSE_WOOD = REGISTRATE.block("stripped_rose_wood", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_OAK_WOOD)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Stripped Rose Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnBlock> ROSE_PLANKS = REGISTRATE.block("rose_planks", CanBurnBlock::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Planks")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnSlabBlock> ROSE_SLAB = REGISTRATE.block("rose_slab", CanBurnSlabBlock::new)
            .initialProperties(() -> Blocks.OAK_SLAB)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Slab")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<StairBlock> ROSE_STAIRS = REGISTRATE.block("rose_stairs", p -> new StairBlock(DesiresBlocks.ROSE_PLANKS::getDefaultState, p))
            .initialProperties(() -> Blocks.OAK_STAIRS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Stairs")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnFenceBlock> ROSE_FENCE = REGISTRATE.block("rose_fence", CanBurnFenceBlock::new)
            .initialProperties(() -> Blocks.OAK_FENCE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Fence")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnFenceGateBlock> ROSE_FENCE_GATE = REGISTRATE.block("rose_fence_gate", p -> new CanBurnFenceGateBlock(p, WoodType.MANGROVE))
            .initialProperties(() -> Blocks.OAK_FENCE_GATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Fence Gate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<YIPPEESlidingDoorBlock> ROSE_DOOR =
            REGISTRATE.block("rose_door", p -> new YIPPEESlidingDoorBlock(p, YIPPEESlidingDoorBlock.ROSE_SET_TYPE.get(), true))
                    .initialProperties(() -> Blocks.OAK_DOOR)
                    .transform(BuilderTransgender.slidingDoor("rose"))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED)
                            .sound(SoundType.WOOD)
                            .noOcclusion())
                    .register();

    public static final BlockEntry<CanBurnTrapDoorBlock> ROSE_TRAPDOOR = REGISTRATE.block("rose_trapdoor", p -> new CanBurnTrapDoorBlock(p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_TRAPDOOR)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED)
                    .noOcclusion())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Rose Trapdoor")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ButtonBlock> ROSE_BUTTON = REGISTRATE.block("rose_button", p -> new ButtonBlock(p, YIPPEESlidingDoorBlock.ROSE_SET_TYPE.get() , 1 ,true))
            .initialProperties(() -> Blocks.OAK_BUTTON)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Button")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnPressurePlateBlock> ROSE_PRESSURE_PLATE = REGISTRATE.block("rose_pressure_plate", p -> new CanBurnPressurePlateBlock(CanBurnPressurePlateBlock.Sensitivity.EVERYTHING, p, YIPPEESlidingDoorBlock.ROSE_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_PRESSURE_PLATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_RED))
            .lang("Rose Pressure Plate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();



    //SMOKED WOODSET

    public static final BlockEntry<CanBurnRotatedBlockPillar> SMOKED_LOG = REGISTRATE.block("smoked_log", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.OAK_LOG)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnRotatedBlockPillar> STRIPPED_SMOKED_LOG = REGISTRATE.block("stripped_smoked_log", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_OAK_LOG)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Stripped Smoked Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnRotatedBlockPillar> SMOKED_WOOD = REGISTRATE.block("smoked_wood", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.OAK_WOOD)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnRotatedBlockPillar> STRIPPED_SMOKED_WOOD = REGISTRATE.block("stripped_smoked_wood", CanBurnRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_OAK_WOOD)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Stripped Smoked Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnBlock> SMOKED_PLANKS = REGISTRATE.block("smoked_planks", CanBurnBlock::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Planks")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<StairBlock> SMOKED_STAIRS = REGISTRATE.block("smoked_stairs", p -> new StairBlock(DesiresBlocks.SMOKED_PLANKS::getDefaultState, p))
            .initialProperties(() -> Blocks.OAK_STAIRS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Stairs")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnSlabBlock> SMOKED_SLAB = REGISTRATE.block("smoked_slab", CanBurnSlabBlock::new)
            .initialProperties(() -> Blocks.OAK_SLAB)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Slab")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnFenceBlock> SMOKED_FENCE = REGISTRATE.block("smoked_fence", CanBurnFenceBlock::new)
            .initialProperties(() -> Blocks.OAK_FENCE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Fence")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnFenceGateBlock> SMOKED_FENCE_GATE = REGISTRATE.block("smoked_fence_gate", p -> new CanBurnFenceGateBlock(p, WoodType.SPRUCE))
            .initialProperties(() -> Blocks.OAK_FENCE_GATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Fence Gate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<YIPPEESlidingDoorBlock> SMOKED_DOOR =
            REGISTRATE.block("smoked_door", p -> new YIPPEESlidingDoorBlock(p, YIPPEESlidingDoorBlock.SMOKED_SET_TYPE.get(), true))
                    .initialProperties(() -> Blocks.OAK_DOOR)
                    .transform(BuilderTransgender.slidingDoor("smoked"))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)
                            .sound(SoundType.WOOD)
                            .noOcclusion())
                    .register();

    public static final BlockEntry<CanBurnTrapDoorBlock> SMOKED_TRAPDOOR = REGISTRATE.block("smoked_trapdoor", p -> new CanBurnTrapDoorBlock(p, YIPPEESlidingDoorBlock.SMOKED_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_TRAPDOOR)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN)
                    .noOcclusion())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Smoked Trapdoor")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ButtonBlock> SMOKED_BUTTON = REGISTRATE.block("smoked_button", p -> new ButtonBlock(p, YIPPEESlidingDoorBlock.SMOKED_SET_TYPE.get(), 1, true))
            .initialProperties(() -> Blocks.OAK_BUTTON)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Button")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<CanBurnPressurePlateBlock> SMOKED_PRESSURE_PLATE = REGISTRATE.block("smoked_pressure_plate", p -> new CanBurnPressurePlateBlock(CanBurnPressurePlateBlock.Sensitivity.EVERYTHING, p, YIPPEESlidingDoorBlock.SMOKED_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_PRESSURE_PLATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_BROWN))
            .lang("Smoked Pressure Plate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();


    //SPIRIT WOODSET

    public static final BlockEntry<NormalLogRotatedBlockPillar> SPIRIT_LOG = REGISTRATE.block("spirit_log", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.WARPED_STEM)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<NormalLogRotatedBlockPillar> STRIPPED_SPIRIT_LOG = REGISTRATE.block("stripped_spirit_log", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_WARPED_STEM)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Stripped Spirit Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<NormalLogRotatedBlockPillar> SPIRIT_WOOD = REGISTRATE.block("spirit_wood", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.WARPED_HYPHAE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<NormalLogRotatedBlockPillar> STRIPPED_SPIRIT_WOOD = REGISTRATE.block("stripped_spirit_wood", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_WARPED_HYPHAE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Stripped Spirit Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SPIRIT_PLANKS = REGISTRATE.block("spirit_planks", Block::new)
            .initialProperties(() -> Blocks.WARPED_PLANKS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Planks")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<StairBlock> SPIRIT_STAIRS = REGISTRATE.block("spirit_stairs", p -> new StairBlock(DesiresBlocks.SPIRIT_PLANKS::getDefaultState, p))
            .initialProperties(() -> Blocks.WARPED_STAIRS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Stairs")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<SlabBlock> SPIRIT_SLAB = REGISTRATE.block("spirit_slab", SlabBlock::new)
            .initialProperties(() -> Blocks.WARPED_SLAB)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Slab")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<FenceBlock> SPIRIT_FENCE = REGISTRATE.block("spirit_fence", FenceBlock::new)
            .initialProperties(() -> Blocks.WARPED_FENCE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Fence")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<FenceGateBlock> SPIRIT_FENCE_GATE = REGISTRATE.block("spirit_fence_gate", p -> new FenceGateBlock(p, WoodType.WARPED))
            .initialProperties(() -> Blocks.WARPED_FENCE_GATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Fence Gate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<YIPPEESlidingDoorBlock> SPIRIT_DOOR =
            REGISTRATE.block("spirit_door", p -> new YIPPEESlidingDoorBlock(p, YIPPEESlidingDoorBlock.SPIRIT_SET_TYPE.get(), true))
                    .initialProperties(() -> Blocks.WARPED_DOOR)
                    .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                            () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                            () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
                    .transform(BuilderTransgender.slidingDoor("spirit"))
                    .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE)
                            .noOcclusion())
                    .register();

    public static final BlockEntry<TrapDoorBlock> SPIRIT_TRAPDOOR = REGISTRATE.block("spirit_trapdoor", p -> new TrapDoorBlock(p, YIPPEESlidingDoorBlock.SPIRIT_SET_TYPE.get()))
            .initialProperties(() -> Blocks.WARPED_TRAPDOOR)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE)
                    .noOcclusion())
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Spirit Trapdoor")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();


    public static final BlockEntry<ButtonBlock> SPIRIT_BUTTON = REGISTRATE.block("spirit_button", p -> new ButtonBlock(p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get(), 1, true))
            .initialProperties(() -> Blocks.WARPED_BUTTON)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Button")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PressurePlateBlock> SPIRIT_PRESSURE_PLATE = REGISTRATE.block("spirit_pressure_plate", p -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get()))
            .initialProperties(() -> Blocks.WARPED_PRESSURE_PLATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_PURPLE))
            .properties(p -> p.sound(new ForgeSoundType(1, .7f, () -> SoundEvents.WOOD_BREAK,
                    () -> SoundEvents.STEM_STEP, () -> SoundEvents.WOOD_PLACE,
                    () -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
            .lang("Spirit Pressure Plate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();


    //RUBBER WOODSET

    public static final BlockEntry<SaplingBlock> RUBBER_SAPLING = REGISTRATE.block("rubber_sapling", p -> new SaplingBlock(new RubberTreeGrower(), p))
            .initialProperties(() -> Blocks.OAK_SAPLING)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Sapling")
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();


    public static final BlockEntry<RubberLeavesBlock> RUBBER_LEAVES = REGISTRATE.block("rubber_leaves", RubberLeavesBlock::new)
            .initialProperties(() -> Blocks.AZALEA_LEAVES)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Leaves")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();


    public static final BlockEntry<NormalLogRotatedBlockPillar> RUBBER_LOG = REGISTRATE.block("rubber_log", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.OAK_LOG)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<NormalLogRotatedBlockPillar> STRIPPED_RUBBER_LOG = REGISTRATE.block("stripped_rubber_log", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_OAK_LOG)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Stripped Rubber Log")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<NormalLogRotatedBlockPillar> RUBBER_WOOD = REGISTRATE.block("rubber_wood", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.OAK_WOOD)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<NormalLogRotatedBlockPillar> STRIPPED_RUBBER_WOOD = REGISTRATE.block("stripped_rubber_wood", NormalLogRotatedBlockPillar::new)
            .initialProperties(() -> Blocks.STRIPPED_OAK_WOOD)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Stripped Rubber Wood")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> RUBBER_PLANKS = REGISTRATE.block("rubber_planks", Block::new)
            .initialProperties(() -> Blocks.OAK_PLANKS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Planks")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<SlabBlock> RUBBER_SLAB = REGISTRATE.block("rubber_slab", SlabBlock::new)
            .initialProperties(() -> Blocks.OAK_SLAB)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Slab")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<StairBlock> RUBBER_STAIRS = REGISTRATE.block("rubber_stairs", p -> new StairBlock(DesiresBlocks.RUBBER_PLANKS::getDefaultState, p))
            .initialProperties(() -> Blocks.OAK_STAIRS)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Stairs")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<FenceBlock> RUBBER_FENCE = REGISTRATE.block("rubber_fence", FenceBlock::new)
            .initialProperties(() -> Blocks.OAK_FENCE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Fence")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<FenceGateBlock> RUBBER_FENCE_GATE = REGISTRATE.block("rubber_fence_gate", p -> new FenceGateBlock(p, WoodType.ACACIA))
            .initialProperties(() -> Blocks.OAK_FENCE_GATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Fence Gate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<DoorBlock> RUBBER_DOOR = REGISTRATE.block("rubber_door", p -> new DoorBlock(p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_DOOR)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN)
                    .sound(SoundType.WOOD)
                    .noOcclusion())
            .addLayer(() -> RenderType::cutoutMipped)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<TrapDoorBlock> RUBBER_TRAPDOOR = REGISTRATE.block("rubber_trapdoor", p -> new TrapDoorBlock(p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_TRAPDOOR)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN)
                    .noOcclusion())
            .addLayer(() -> RenderType::cutoutMipped)
            .lang("Rubber Trapdoor")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<ButtonBlock> RUBBER_BUTTON = REGISTRATE.block("rubber_button", p -> new ButtonBlock(p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get(), 1, true))
            .initialProperties(() -> Blocks.OAK_BUTTON)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Button")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<PressurePlateBlock> RUBBER_PRESSURE_PLATE = REGISTRATE.block("rubber_pressure_plate", p -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, p, YIPPEESlidingDoorBlock.RUBBER_SET_TYPE.get()))
            .initialProperties(() -> Blocks.OAK_PRESSURE_PLATE)
            .properties(p -> p.mapColor(MapColor.TERRACOTTA_CYAN))
            .lang("Rubber Pressure Plate")
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    // ASPHALTS

    public static final BlockEntry<Block> ANDESITE_ASPHALT_BLOCK = REGISTRATE.block("andesite_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.STONE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> ASURINE_ASPHALT_BLOCK = REGISTRATE.block("asurine_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.COLOR_BLUE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> CALCITE_ASPHALT_BLOCK = REGISTRATE.block("calcite_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_WHITE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.CALCITE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> CRIMSITE_ASPHALT_BLOCK = REGISTRATE.block("crimsite_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.COLOR_RED))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DEEPSLATE_ASPHALT_BLOCK = REGISTRATE.block("deepslate_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.DEEPSLATE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DIORITE_ASPHALT_BLOCK = REGISTRATE.block("diorite_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.QUARTZ))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DRIPSTONE_ASPHALT_BLOCK = REGISTRATE.block("dripstone_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_BROWN))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> GABBRO_ASPHALT_BLOCK = REGISTRATE.block("gabbro_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> GRANITE_ASPHALT_BLOCK = REGISTRATE.block("granite_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_CYAN))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> LIMESTONE_ASPHALT_BLOCK = REGISTRATE.block("limestone_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.SAND))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> OCHRUM_ASPHALT_BLOCK = REGISTRATE.block("ochrum_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_YELLOW))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.CALCITE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> POTASSIC_ASPHALT_BLOCK = REGISTRATE.block("potassic_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_BLUE))
            .properties(p -> p.sound(new ForgeSoundType(0.8f, 0.85f, () -> DesiresSoundEvents.ORE_STONE_BREAK.get(),
                    () -> DesiresSoundEvents.ORE_STONE_STEP.get(), () -> DesiresSoundEvents.ORE_STONE_PLACE.get(),
                    () -> DesiresSoundEvents.ORE_STONE_HIT.get(), () -> DesiresSoundEvents.ORE_STONE_FALL.get())))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .simpleItem()
            .register();

    public static final BlockEntry<Block> AETHERSITE_ASPHALT_BLOCK = REGISTRATE.block("aethersite_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_BLUE))
            .properties(p -> p.sound(new ForgeSoundType(0.8f, 1.5f, () -> DesiresSoundEvents.ORE_STONE_BREAK.get(),
                    () -> DesiresSoundEvents.ORE_STONE_STEP.get(), () -> DesiresSoundEvents.ORE_STONE_PLACE.get(),
                    () -> DesiresSoundEvents.ORE_STONE_HIT.get(), () -> DesiresSoundEvents.ORE_STONE_FALL.get())))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SCORCHIA_ASPHALT_BLOCK = REGISTRATE.block("scorchia_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SCORIA_ASPHALT_BLOCK = REGISTRATE.block("scoria_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.COLOR_BROWN))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> TUFF_ASPHALT_BLOCK = REGISTRATE.block("tuff_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> VERIDIUM_ASPHALT_BLOCK = REGISTRATE.block("veridium_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.WARPED_NYLIUM))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> WEATHERED_LIMESTONE_ASPHALT_BLOCK = REGISTRATE.block("weathered_limestone_asphalt_block", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .speedFactor(1.2F)
                    .jumpFactor(1.2F)
                    .friction(0.6F)
                    .mapColor(MapColor.COLOR_LIGHT_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    // MOSSY VARIANTS

    public static final BlockEntry<Block> ANDESITE_MOSSY_BRICKS = REGISTRATE.block("andesite_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.STONE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> ASURINE_MOSSY_BRICKS = REGISTRATE.block("asurine_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.COLOR_BLUE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> CALCITE_MOSSY_BRICKS = REGISTRATE.block("calcite_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_WHITE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.CALCITE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> CRIMSITE_MOSSY_BRICKS = REGISTRATE.block("crimsite_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.COLOR_RED))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DEEPSLATE_MOSSY_BRICKS = REGISTRATE.block("deepslate_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.DEEPSLATE))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DIORITE_MOSSY_BRICKS = REGISTRATE.block("diorite_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.QUARTZ))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> DRIPSTONE_MOSSY_BRICKS = REGISTRATE.block("dripstone_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_BROWN))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> GABBRO_MOSSY_BRICKS = REGISTRATE.block("gabbro_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_LIGHT_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> GRANITE_MOSSY_BRICKS = REGISTRATE.block("granite_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_CYAN))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> LIMESTONE_MOSSY_BRICKS = REGISTRATE.block("limestone_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.SAND))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> OCHRUM_MOSSY_BRICKS = REGISTRATE.block("ochrum_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_YELLOW))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.CALCITE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> POTASSIC_MOSSY_BRICKS = REGISTRATE.block("potassic_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_BLUE))
            .properties(p -> p.sound(new ForgeSoundType(0.8f, 0.85f, () -> DesiresSoundEvents.ORE_STONE_BREAK.get(),
                    () -> DesiresSoundEvents.ORE_STONE_STEP.get(), () -> DesiresSoundEvents.ORE_STONE_PLACE.get(),
                    () -> DesiresSoundEvents.ORE_STONE_HIT.get(), () -> DesiresSoundEvents.ORE_STONE_FALL.get())))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> AETHERSITE_MOSSY_BRICKS = REGISTRATE.block("aethersite_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_BLUE))
            .properties(p -> p.sound(new ForgeSoundType(0.8f, 1.5f, () -> DesiresSoundEvents.ORE_STONE_BREAK.get(),
                    () -> DesiresSoundEvents.ORE_STONE_STEP.get(), () -> DesiresSoundEvents.ORE_STONE_PLACE.get(),
                    () -> DesiresSoundEvents.ORE_STONE_HIT.get(), () -> DesiresSoundEvents.ORE_STONE_FALL.get())))
            .properties(BlockBehaviour.Properties::requiresCorrectToolForDrops)
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SCORCHIA_MOSSY_BRICKS = REGISTRATE.block("scorchia_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> SCORIA_MOSSY_BRICKS = REGISTRATE.block("scoria_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.COLOR_BROWN))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> TUFF_MOSSY_BRICKS = REGISTRATE.block("tuff_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.TERRACOTTA_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> VERIDIUM_MOSSY_BRICKS = REGISTRATE.block("veridium_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.WARPED_NYLIUM))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.TUFF))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    public static final BlockEntry<Block> WEATHERED_LIMESTONE_MOSSY_BRICKS = REGISTRATE.block("weathered_limestone_mossy_bricks", Block::new)
            .properties(p -> p.destroyTime(1.25f)
                    .mapColor(MapColor.COLOR_LIGHT_GRAY))
            .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.STONE))
            .item()
            .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
            .build()
            .register();

    // TILED AND POLISHED

    public static final BlockEntry<Block> POLISHED_BRONZE_BLOCK =
            REGISTRATE.block("bronze_polished_block", Block::new)
                    .initialProperties(SharedProperties::netheriteMetal)
                    .properties(p -> p.mapColor(MapColor.COLOR_ORANGE))
                    .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
                    .properties(p -> p.strength(6f,5f))
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> POLISHED_BRONZE_STAIRS =
            REGISTRATE.block("bronze_polished_stairs", p -> new StairBlock(DesiresBlocks.POLISHED_BRONZE_BLOCK::getDefaultState, p))
                    .initialProperties(DesiresBlocks.POLISHED_BRONZE_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> POLISHED_BRONZE_SLAB =
            REGISTRATE.block("bronze_polished_slab", SlabBlock::new)
                    .initialProperties(DesiresBlocks.POLISHED_BRONZE_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> TILED_BRONZE_BLOCK =
            REGISTRATE.block("bronze_tiled_block", Block::new)
                    .initialProperties(DesiresBlocks.POLISHED_BRONZE_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> TILED_BRONZE_STAIRS =
            REGISTRATE.block("bronze_tiled_stairs", p -> new StairBlock(DesiresBlocks.TILED_BRONZE_BLOCK::getDefaultState, p))
                    .initialProperties(DesiresBlocks.POLISHED_BRONZE_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> TILED_BRONZE_SLAB =
            REGISTRATE.block("bronze_tiled_slab", SlabBlock::new)
                    .initialProperties(DesiresBlocks.POLISHED_BRONZE_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();


    public static final BlockEntry<Block> POLISHED_STEEL_BLOCK =
            REGISTRATE.block("steel_polished_block", Block::new)
                    .initialProperties(SharedProperties::netheriteMetal)
                    .properties(p -> p.mapColor(MapColor.COLOR_GRAY))
                    .properties(p -> p.requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK))
                    .properties(p -> p.strength(3f,8f))
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> POLISHED_STEEL_STAIRS =
            REGISTRATE.block("steel_polished_stairs", p -> new StairBlock(DesiresBlocks.POLISHED_STEEL_BLOCK::getDefaultState, p))
                    .initialProperties(DesiresBlocks.POLISHED_STEEL_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> POLISHED_STEEL_SLAB =
            REGISTRATE.block("steel_polished_slab", SlabBlock::new)
                    .initialProperties(DesiresBlocks.POLISHED_STEEL_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> TILED_STEEL_BLOCK =
            REGISTRATE.block("steel_tiled_block", Block::new)
                    .initialProperties(DesiresBlocks.POLISHED_STEEL_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> TILED_STEEL_STAIRS =
            REGISTRATE.block("steel_tiled_stairs", p -> new StairBlock(DesiresBlocks.TILED_STEEL_BLOCK::getDefaultState, p))
                    .initialProperties(DesiresBlocks.POLISHED_STEEL_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> TILED_STEEL_SLAB =
            REGISTRATE.block("steel_tiled_slab", SlabBlock::new)
                    .initialProperties(DesiresBlocks.POLISHED_STEEL_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();


    public static final BlockEntry<Block> POLISHED_ZINC_BLOCK =
            REGISTRATE.block("zinc_polished_block", Block::new)
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> POLISHED_ZINC_STAIRS =
            REGISTRATE.block("zinc_polished_stairs", p -> new StairBlock(DesiresBlocks.POLISHED_ZINC_BLOCK::getDefaultState, p))
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> POLISHED_ZINC_SLAB =
            REGISTRATE.block("zinc_polished_slab", SlabBlock::new)
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<Block> TILED_ZINC_BLOCK =
            REGISTRATE.block("zinc_tiled_block", Block::new)
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> TILED_ZINC_STAIRS =
            REGISTRATE.block("zinc_tiled_stairs", p -> new StairBlock(DesiresBlocks.TILED_ZINC_BLOCK::getDefaultState, p))
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> TILED_ZINC_SLAB =
            REGISTRATE.block("zinc_tiled_slab", SlabBlock::new)
                    .initialProperties(() -> Blocks.IRON_BLOCK)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();


    public static final BlockEntry<Block> POLISHED_ANDESITE_ALLOY_BLOCK =
            REGISTRATE.block("andesite_alloy_polished_block", Block::new)
                    .initialProperties(() -> Blocks.ANDESITE)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<StairBlock> POLISHED_ANDESITE_ALLOY_STAIRS =
            REGISTRATE.block("andesite_alloy_polished_stairs", p -> new StairBlock(DesiresBlocks.POLISHED_ANDESITE_ALLOY_BLOCK::getDefaultState, p))
                    .initialProperties(() -> Blocks.ANDESITE)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    public static final BlockEntry<SlabBlock> POLISHED_ANDESITE_ALLOY_SLAB =
            REGISTRATE.block("andesite_alloy_polished_slab", SlabBlock::new)
                    .initialProperties(() -> Blocks.ANDESITE)
                    .item()
                    .tab(DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.getKey())
                    .build()
                    .register();

    // Load this class
	public static void register() {}
}

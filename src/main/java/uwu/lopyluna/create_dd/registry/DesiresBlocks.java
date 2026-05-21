package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllDisplaySources;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.api.behaviour.display.DisplaySource;
import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.simibubi.create.api.contraption.storage.item.MountedItemStorageType;
import com.simibubi.create.api.registry.CreateRegistries;
import com.simibubi.create.api.stress.BlockStressValues;
import com.simibubi.create.content.decoration.encasing.CasingBlock;
import com.simibubi.create.content.kinetics.gauge.GaugeGenerator;
import com.simibubi.create.content.kinetics.motor.CreativeMotorGenerator;
import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import com.simibubi.create.foundation.block.ItemUseOverrides;
import com.simibubi.create.foundation.data.*;
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
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.util.ForgeSoundType;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.content.blocks.contraptions.bore_block.BoreBlock;
import uwu.lopyluna.create_dd.content.blocks.contraptions.bore_block.BoreBlockMovementBehaviour;
import uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor.AcceleratorMotorBlock;
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
//import uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor.AcceleratorMotorBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.transmission.redstone_divider.RedstoneDividerBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.transmission.InverseBoxBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirCTBehaviour;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirItem;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileCTBehaviour;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileItem;

import java.util.function.Consumer;

import static com.simibubi.create.api.behaviour.movement.MovementBehaviour.movementBehaviour;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.*;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;
import static uwu.lopyluna.create_dd.DesiresCreate.REGISTRATE;
import static uwu.lopyluna.create_dd.registry.DesiresPaletteBlocks.rawRubberDecorTag;
import static uwu.lopyluna.create_dd.registry.DesiresPaletteBlocks.rubberDecorTag;

@SuppressWarnings({"unused", "removal", "all"})
public class DesiresBlocks {

	public static final BlockEntry<Block> RAW_RUBBER_BLOCK = REGISTRATE.block("raw_rubber_block", Block::new)
			.properties(p -> p.mapColor(MapColor.TERRACOTTA_WHITE))
			.properties(p -> p.sound(new ForgeSoundType(0.9f, .75f, () -> DesiresSoundEvents.RUBBER_BREAK.get(),
					() -> SoundEvents.STEM_STEP, () -> DesiresSoundEvents.RUBBER_PLACE.get(),
					() -> SoundEvents.STEM_HIT, () -> SoundEvents.STEM_FALL)))
			.properties(p -> p.strength(0.5f,1.5f))
			.lang("Block of Raw Rubber")
			.item()
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
			.lang("Block of Rubber")
			.item()
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.tag(rubberDecorTag)
			.build()
			.register();

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

    public static final BlockEntry<CasingBlock> REINFORCEMENT_PLATING = REGISTRATE.block("reinforcement_plating", CasingBlock::new)
            .transform(BuilderTransformers.casing(() -> DesiresSpriteShifts.REINFORCEMENT_PLATING))
            .properties(p -> p.mapColor(MapColor.COLOR_ORANGE)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.COPPER))
            .transform(pickaxeOnly())
            .lang("Reinforced Plating")
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

	public static final BlockEntry<FurnaceEngineBlock> FURNACE_ENGINE =
			REGISTRATE.block("furnace_engine", FurnaceEngineBlock::new)
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


	public static final BlockEntry<FanSailBlock> SPLASHING_SAIL =
			REGISTRATE.block("splashing_sail", FanSailBlock::sail)
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

	public static final BlockEntry<FanSailBlock> HAUNTING_SAIL =
			REGISTRATE.block("haunting_sail", FanSailBlock::sail)
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

	public static final BlockEntry<FanSailBlock> SMOKING_SAIL =
			REGISTRATE.block("smoking_sail", FanSailBlock::sail)
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

	public static final BlockEntry<FanSailBlock> BLASTING_SAIL =
			REGISTRATE.block("blasting_sail", FanSailBlock::sail)
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

	public static final BlockEntry<FanSailBlock> SEETHING_SAIL =
			REGISTRATE.block("seething_sail", FanSailBlock::sail)
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

	public static final BlockEntry<FanSailBlock> FREEZING_SAIL =
			REGISTRATE.block("freezing_sail", FanSailBlock::sail)
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

	public static final BlockEntry<FanSailBlock> SANDING_SAIL =
			REGISTRATE.block("sanding_sail", FanSailBlock::sail)
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

	// Load this class

	public static void register() {}

}

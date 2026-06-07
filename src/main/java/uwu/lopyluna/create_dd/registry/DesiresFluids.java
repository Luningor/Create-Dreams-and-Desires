package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.tterrag.registrate.builders.FluidBuilder.FluidTypeFactory;
import com.tterrag.registrate.util.entry.FluidEntry;
import net.createmod.catnip.theme.Color;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.SoundActions;
import net.minecraftforge.fluids.FluidInteractionRegistry;
import net.minecraftforge.fluids.FluidInteractionRegistry.InteractionInformation;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import org.joml.Vector3f;
import uwu.lopyluna.create_dd.infrastructure.config.DesiresConfigs;

import javax.annotation.Nullable;
import java.util.function.Supplier;

import static uwu.lopyluna.create_dd.DesiresCreate.REGISTRATE;


public class DesiresFluids {

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CONDENSE_MILK =
            REGISTRATE.standardFluid("condense_milk",
                            SolidRenderedPlaceableFluidType.create(0xfaeccc,
                                    () -> 1f / 4f * DesiresConfigs.client().condense_milkTransparencyMultiplier.getF()))
                    .lang("condense_milk")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.CONDENSE_MILK.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/condense_milk"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CREAM =
            REGISTRATE.standardFluid("cream",
                            SolidRenderedPlaceableFluidType.create(0xfff3cf,
                                    () -> 1f / 4f * DesiresConfigs.client().creamTransparencyMultiplier.getF()))
                    .lang("cream")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.CREAM.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/cream"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> VANILLA =
            REGISTRATE.standardFluid("vanilla",
                            SolidRenderedPlaceableFluidType.create(0xfefff4,
                                    () -> 1f / 4f * DesiresConfigs.client().vanillaTransparencyMultiplier.getF()))
                    .lang("vanilla")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.VANILLA.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/vanilla"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> VANILLA_MILKSHAKE =
            REGISTRATE.standardFluid("vanilla_milkshake",
                            SolidRenderedPlaceableFluidType.create(0xfefff4,
                                    () -> 1f / 4f * DesiresConfigs.client().vanilla_milkshakeTransparencyMultiplier.getF()))
                    .lang("vanilla_milkshake")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.VANILLA_MILKSHAKE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/vanilla_milkshake"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> STRAWBERRY =
            REGISTRATE.standardFluid("strawberry",
                            SolidRenderedPlaceableFluidType.create(0xf898d9,
                                    () -> 1f / 4f * DesiresConfigs.client().strawberryTransparencyMultiplier.getF()))
                    .lang("strawberry")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.STRAWBERRY.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/strawberry"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> STRAWBERRY_MILKSHAKE =
            REGISTRATE.standardFluid("strawberry_milkshake",
                            SolidRenderedPlaceableFluidType.create(0xf48ccc,
                                    () -> 1f / 4f * DesiresConfigs.client().strawberry_milkshakeTransparencyMultiplier.getF()))
                    .lang("strawberry_milkshake")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.STRAWBERRY_MILKSHAKE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/strawberry_milkshake"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> GLOWBERRY =
            REGISTRATE.standardFluid("glowberry",
                            SolidRenderedPlaceableFluidType.create(0xffca79,
                                    () -> 1f / 4f * DesiresConfigs.client().glowberryTransparencyMultiplier.getF()))
                    .lang("glowberry")
                    .properties(b -> b.viscosity(1500)
                            .density(1400)
                            .lightLevel(12))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.GLOWBERRY.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/glowberry"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> GLOWBERRY_MILKSHAKE =
            REGISTRATE.standardFluid("glowberry_milkshake",
                            SolidRenderedPlaceableFluidType.create(0xffdb8a,
                                    () -> 1f / 4f * DesiresConfigs.client().glowberry_milkshakeTransparencyMultiplier.getF()))
                    .lang("glowberry_milkshake")
                    .properties(b -> b.viscosity(1500)
                            .density(1400)
                            .lightLevel(12))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.GLOWBERRY_MILKSHAKE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/glowberry_milkshake"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> PUMPKIN_JUICE =
            REGISTRATE.standardFluid("pumpkin_juice",
                            SolidRenderedPlaceableFluidType.create(0xd17a32,
                                    () -> 1f / 4f * DesiresConfigs.client().pumpkinTransparencyMultiplier.getF()))
                    .lang("pumpkin_juice")
                    .properties(b -> b.viscosity(1000)
                            .density(1400))
                            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                                    .tickRate(10)
                                    .slopeFindDistance(3)
                                    .explosionResistance(100f)
                            )
                            .tag(DesiresTags.AllFluidTags.PUMPKIN_JUICE.tag)
                            .source(ForgeFlowingFluid.Source::new)
                            .block()
                            .build()
                            .bucket()
                            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                            .tag(DesiresTags.forgeItemTag("buckets/pumpkin"))
                            .build()
                            .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> PUMPKIN_MILKSHAKE =
            REGISTRATE.standardFluid("pumpkin_milkshake",
                            SolidRenderedPlaceableFluidType.create(0xda8637,
                                    () -> 1f / 4f * DesiresConfigs.client().pumpkin_milkshakeTransparencyMultiplier.getF()))
                    .lang("pumpkin_milkshake")
                    .properties(b -> b.viscosity(1000)
                            .density(1400))
                            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                                    .tickRate(10)
                                    .slopeFindDistance(3)
                                    .explosionResistance(100f)
                            )
                            .tag(DesiresTags.AllFluidTags.PUMPKIN_MILKSHAKE.tag)
                            .source(ForgeFlowingFluid.Source::new)
                            .block()
                            .build()
                            .bucket()
                            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                            .tag(DesiresTags.forgeItemTag("buckets/pumpkin_milkshake"))
                            .build()
                            .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CARAMEL =
            REGISTRATE.standardFluid("caramel",
                            SolidRenderedPlaceableFluidType.create(0xef9967,
                                    () -> 1f / 4f * DesiresConfigs.client().caramelTransparencyMultiplier.getF()))
                    .lang("caramel")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.CARAMEL.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/caramel"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CARAMEL_MILKSHAKE =
            REGISTRATE.standardFluid("caramel_milkshake",
                            SolidRenderedPlaceableFluidType.create(0xf3a872,
                                    () -> 1f / 4f * DesiresConfigs.client().caramel_milkshakeTransparencyMultiplier.getF()))
                    .lang("caramel_milkshake")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.CARAMEL_MILKSHAKE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/caramel_milkshake"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> HOT_CHOCOLATE =
            REGISTRATE.standardFluid("hot_chocolate",
                            SolidRenderedPlaceableFluidType.create(0x833730,
                                    () -> 1f / 4f * DesiresConfigs.client().hot_chocolateTransparencyMultiplier.getF()))
                    .lang("hot_chocolate")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.HOT_CHOCOLATE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/hot_chocolate"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CHOCOLATE_MILKSHAKE =
            REGISTRATE.standardFluid("chocolate_milkshake",
                            SolidRenderedPlaceableFluidType.create(0x9f493b,
                                    () -> 1f / 4f * DesiresConfigs.client().chocolate_milkshakeTransparencyMultiplier.getF()))
                    .lang("chocolate_milkshake")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.CHOCOLATE_MILKSHAKE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/chocolate_milkshake"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> SAP =
            REGISTRATE.standardFluid("sap",
                            SolidRenderedPlaceableFluidType.create(0xd38c59,
                                    () -> 1f / 4f * DesiresConfigs.client().sapTransparencyMultiplier.getF()))
                    .lang("sap")
                    .properties(b -> b.viscosity(1500)
                            .density(1400))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.SAP.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/sap"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> CHROMATIC_WASTE =
            REGISTRATE.standardFluid("chromatic_waste",
                            SolidRenderedPlaceableFluidType.create(0x6e294e,
                                    () -> 1f / 4f * DesiresConfigs.client().chromatic_wasteTransparencyMultiplier.getF()))
                    .lang("chromatic_waste")
                    .properties(b -> b.viscosity(6000)
                            .density(3000)
                            .lightLevel(8)
                            .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                            .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                            .lightLevel(8))
                    .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(25)
                            .slopeFindDistance(3)
                            .explosionResistance(100f)
                    )
                    .tag(DesiresTags.AllFluidTags.CHROMATIC_WASTE.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/chromatic_waste"))
                    .build()
                    .register();

    public static final FluidEntry<ForgeFlowingFluid.Flowing> SHIMMER =
            REGISTRATE.standardFluid("shimmer",
                            SolidRenderedPlaceableFluidType.create(0x5cfc7a,
                                    () -> 1f / 4f * DesiresConfigs.client().shimmerTransparencyMultiplier.getF()))
                    .lang("shimmer")
                    .properties(b -> b.viscosity(6000)
                            .density(50)
                            .canSwim(false)
                            .canDrown(true)
                            .canHydrate(false)
                            .rarity(Rarity.EPIC)
                            .lightLevel(15)
                            .temperature(-1000)
                            .motionScale(-1.25)
                            .supportsBoating(false)
                            .canExtinguish(false)
                            .canConvertToSource(true)
                            .pathType(BlockPathTypes.LAVA)
                            .sound(SoundActions.BUCKET_FILL, DesiresSoundEvents.SHIMMER_FILL.get())
                            .sound(SoundActions.BUCKET_EMPTY, DesiresSoundEvents.SHIMMER_EMPTY.get())
                            .adjacentPathType(null))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                            .tickRate(20)
                            .slopeFindDistance(0)
                            .explosionResistance(10000f)
                    )
                    .tag(DesiresTags.AllFluidTags.SHIMMER.tag)
                    .source(ForgeFlowingFluid.Source::new)
                    .block()
                    .build()
                    .bucket()
                    .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
                    .tag(DesiresTags.forgeItemTag("buckets/shimmer"))
                    .build()
                    .register();

	// Load this class

	public static void register() {}

	public static void registerFluidInteractions() {
		FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new InteractionInformation(
				SAP.get().getFluidType(),
				fluidState -> {
					if (fluidState.isSource())
						return Blocks.OBSIDIAN.defaultBlockState();
					else
						return DesiresPaletteStoneTypes.GABBRO.getBaseBlock()
								.get()
								.defaultBlockState();
				}
		));

        FluidInteractionRegistry.addInteraction(DesiresFluids.CHROMATIC_WASTE.getType(), new FluidInteractionRegistry.InteractionInformation(
                ForgeMod.WATER_TYPE.get(),
                fluidState -> Blocks.OBSIDIAN.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(DesiresFluids.CHROMATIC_WASTE.getType(), new FluidInteractionRegistry.InteractionInformation(
                ForgeMod.LAVA_TYPE.get(),
                fluidState -> Blocks.CRYING_OBSIDIAN.defaultBlockState()));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                SHIMMER.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresPaletteStoneTypes.AETHERSITE.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                VANILLA.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return AllPaletteStoneTypes.DEEPSLATE.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                VANILLA_MILKSHAKE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresBlocks.POTASSIC_COBBLE.getDefaultState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                STRAWBERRY.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresPaletteStoneTypes.GABBRO.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                STRAWBERRY_MILKSHAKE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresBlocks.CRIMSITE_COBBLE.getDefaultState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                GLOWBERRY.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return AllPaletteStoneTypes.DRIPSTONE.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                GLOWBERRY_MILKSHAKE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresBlocks.OCHRUM_COBBLE.getDefaultState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                PUMPKIN_JUICE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.TERRACOTTA.defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                PUMPKIN_MILKSHAKE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresPaletteStoneTypes.BRECCIA.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                CARAMEL.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.BLACKSTONE.defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                CARAMEL_MILKSHAKE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresBlocks.VERIDIUM_COBBLE.getDefaultState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                CONDENSE_MILK.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return AllPaletteStoneTypes.CALCITE.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                CREAM.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return DesiresBlocks.ASURINE_COBBLE.getDefaultState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                HOT_CHOCOLATE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return AllPaletteStoneTypes.SCORCHIA.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                CHOCOLATE_MILKSHAKE.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return AllPaletteStoneTypes.SCORIA.getBaseBlock().get().defaultBlockState();
                    }}));

        FluidInteractionRegistry.addInteraction(ForgeMod.LAVA_TYPE.get(), new FluidInteractionRegistry.InteractionInformation(
                SAP.get().getFluidType(),
                fluidState -> {
                    if (fluidState.isSource()) {
                        return Blocks.OBSIDIAN.defaultBlockState();
                    } else {
                        return Blocks.BASALT.defaultBlockState();
                    }}));

	}

	@Nullable
	public static BlockState getLavaInteraction(FluidState fluidState) {
		Fluid fluid = fluidState.getType();
		if (fluid.isSame(SAP.get()))
			return DesiresPaletteStoneTypes.GABBRO.getBaseBlock()
				.get()
				.defaultBlockState();
		return null;
	}

    private static class SolidRenderedPlaceableFluidType extends AllFluids.TintedFluidType {

        private Vector3f fogColor;
        private Supplier<Float> fogDistance;

        public static FluidTypeFactory create(int fogColor, Supplier<Float> fogDistance) {
            return (p, s, f) -> {
                DesiresFluids.SolidRenderedPlaceableFluidType fluidType = new DesiresFluids.SolidRenderedPlaceableFluidType(p, s, f);
                fluidType.fogColor = new Color(fogColor, false).asVectorF();
                fluidType.fogDistance = fogDistance;
                return fluidType;
            };
        }

        private SolidRenderedPlaceableFluidType(Properties properties, ResourceLocation stillTexture,
                                                ResourceLocation flowingTexture) {
            super(properties, stillTexture, flowingTexture);
        }

        @Override
        protected int getTintColor(FluidStack stack) {
            return NO_TINT;
        }

        @Override
        public int getTintColor(FluidState state, BlockAndTintGetter world, BlockPos pos) {
            return NO_TINT;
        }

        @Override
        protected Vector3f getCustomFogColor() {
            return fogColor;
        }

        @Override
        protected float getFogDistanceModifier() {
            return fogDistance.get();
        }

    }
}

package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.AllPartialModels;
import com.simibubi.create.content.kinetics.base.*;
import com.simibubi.create.content.kinetics.transmission.SplitShaftRenderer;
import com.simibubi.create.content.kinetics.transmission.SplitShaftVisual;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.bronze_saw.BronzeSawBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.bronze_saw.BronzeSawRenderer;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.bronze_saw.BronzeSawVisual;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.bronze.BronzeDrillBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.bronze.BronzeDrillRenderer;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant.RadiantDrillBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant.RadiantDrillRenderer;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.shadow.ShadowDrillBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.shadow.ShadowDrillRenderer;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.radiant_saw.RadiantSawBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.radiant_saw.RadiantSawRenderer;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.radiant_saw.RadiantSawVisual;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.shadow_saw.ShadowSawBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.shadow_saw.ShadowSawRenderer;
import uwu.lopyluna.create_dd.content.blocks.contraptions.saw.shadow_saw.ShadowSawVisual;
import uwu.lopyluna.create_dd.content.blocks.door.YIPPEESlidingDoorBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.door.YIPPEESlidingDoorRenderer;
import uwu.lopyluna.create_dd.content.blocks.fan.eight_blade.EightBladeFanBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.fan.eight_blade.EightBladeFanBlockRenderer;
import uwu.lopyluna.create_dd.content.blocks.fan.eight_blade.EightBladeFanBlockVisual;
import uwu.lopyluna.create_dd.content.blocks.fan.four_blade.FourBladeFanBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.fan.four_blade.FourBladeFanBlockRenderer;
import uwu.lopyluna.create_dd.content.blocks.fan.four_blade.FourBladeFanBlockVisual;
import uwu.lopyluna.create_dd.content.blocks.fan.two_blade.TwoBladeFanBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.fan.two_blade.TwoBladeFanBlockRenderer;
import uwu.lopyluna.create_dd.content.blocks.fan.two_blade.TwoBladeFanBlockVisual;
import uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor.AcceleratorMotorBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor.AcceleratorMotorRenderer;
import uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank.CogCrankVisual;
import uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear.GiantGearBlockRenderer;
import uwu.lopyluna.create_dd.content.blocks.kinetics.hydraulic_press.HydraulicPressVisual;
import uwu.lopyluna.create_dd.content.blocks.kinetics.industrial_fan_block.IndustrialFanVisual;
import uwu.lopyluna.create_dd.content.blocks.kinetics.kinetic_motor.KineticMotorRenderer;
import uwu.lopyluna.create_dd.content.blocks.kinetics.multimeter.MultiMeterBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear.GiantGearBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.hydraulic_press.HydraulicPressBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.hydraulic_press.HydraulicPressRenderer;
import uwu.lopyluna.create_dd.content.blocks.kinetics.industrial_fan_block.IndustrialFanBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.industrial_fan_block.IndustrialFanRenderer;
import uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank.CogCrankBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank.CogCrankRenderer;
import uwu.lopyluna.create_dd.content.blocks.kinetics.furnace_engine.*;
import uwu.lopyluna.create_dd.content.blocks.kinetics.kinetic_motor.KineticMotorBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.transmission.redstone_divider.RedstoneDividerBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.kinetics.transmission.InverseBoxBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.ponder_box.PonderBoxBlockEntity;
import uwu.lopyluna.create_dd.content.blocks.ponder_box.PonderBoxRenderer;

import static uwu.lopyluna.create_dd.DesiresCreate.REGISTRATE;

public class DesiresBlockEntityTypes {

	public static final BlockEntityEntry<IndustrialFanBlockEntity> INDUSTRIAL_FAN = REGISTRATE
			.blockEntity("industrial_fan", IndustrialFanBlockEntity::new)
			.visual(() -> IndustrialFanVisual::new, false)
			.validBlocks(DesiresBlocks.INDUSTRIAL_FAN)
			.renderer(() -> IndustrialFanRenderer::new)
			.register();

	public static final BlockEntityEntry<HydraulicPressBlockEntity> HYDRAULIC_PRESS = REGISTRATE
			.blockEntity("hydraulic_press", HydraulicPressBlockEntity::new)
			.visual(() -> HydraulicPressVisual::new)
			.validBlocks(DesiresBlocks.HYDRAULIC_PRESS)
			.renderer(() -> HydraulicPressRenderer::new)
			.register();

	public static final BlockEntityEntry<CogCrankBlockEntity> COG_CRANK = REGISTRATE
			.blockEntity("cog_crank", CogCrankBlockEntity::new)
			.visual(() -> CogCrankVisual::new)
			.validBlocks(DesiresBlocks.COG_CRANK)
			.renderer(() -> CogCrankRenderer::new)
			.register();

	public static final BlockEntityEntry<ItemStockpileBlockEntity> ITEM_STOCKPILE = REGISTRATE
			.blockEntity("item_stockpile", ItemStockpileBlockEntity::new)
			.validBlocks(DesiresBlocks.ITEM_STOCKPILE)
			.register();

	public static final BlockEntityEntry<FluidReservoirBlockEntity> FLUID_RESERVOIR = REGISTRATE
			.blockEntity("fluid_reservoir", FluidReservoirBlockEntity::new)
			.validBlocks(DesiresBlocks.FLUID_RESERVOIR)
			.register();

	public static final BlockEntityEntry<FurnaceEngineBlockEntity> FURNACE_ENGINE = REGISTRATE
			.blockEntity("furnace_engine", FurnaceEngineBlockEntity::new)
			.visual(()->FurnaceEngineVisual::new)
			.validBlocks(DesiresBlocks.FURNACE_ENGINE)
			.renderer(()-> FurnaceEngineRenderer::new)
			.register();

    public static final BlockEntityEntry<BronzeSawBlockEntity> BRONZE_SAW = REGISTRATE
            .blockEntity("bronze_saw", BronzeSawBlockEntity::new)
            .visual(() -> BronzeSawVisual::new)
            .validBlocks(DesiresBlocks.BRONZE_SAW)
            .renderer(() -> BronzeSawRenderer::new)
            .register();

    public static final BlockEntityEntry<RadiantSawBlockEntity> RADIANT_SAW = REGISTRATE
            .blockEntity("radiant_saw", RadiantSawBlockEntity::new)
            .visual(() -> RadiantSawVisual::new)
            .validBlocks(DesiresBlocks.RADIANT_SAW)
            .renderer(() -> RadiantSawRenderer::new)
            .register();

    public static final BlockEntityEntry<ShadowSawBlockEntity> SHADOW_SAW = REGISTRATE
            .blockEntity("shadow_saw", ShadowSawBlockEntity::new)
            .visual(() -> ShadowSawVisual::new)
            .validBlocks(DesiresBlocks.SHADOW_SAW)
            .renderer(() -> ShadowSawRenderer::new)
            .register();

    public static final BlockEntityEntry<BronzeDrillBlockEntity> BRONZE_DRILL = REGISTRATE
            .blockEntity("bronze_drill", BronzeDrillBlockEntity::new)
            .validBlocks(DesiresBlocks.BRONZE_DRILL)
            .renderer(() -> BronzeDrillRenderer::new)
            .register();

    public static final BlockEntityEntry<RadiantDrillBlockEntity> RADIANT_DRILL = REGISTRATE
            .blockEntity("radiant_drill", RadiantDrillBlockEntity::new)
            .validBlocks(DesiresBlocks.RADIANT_DRILL)
            .renderer(() -> RadiantDrillRenderer::new)
            .register();

    public static final BlockEntityEntry<ShadowDrillBlockEntity> SHADOW_DRILL = REGISTRATE.blockEntity("shadow_drill", ShadowDrillBlockEntity::new)
            .validBlocks(DesiresBlocks.SHADOW_DRILL)
            .renderer(() -> ShadowDrillRenderer::new)
            .register();

	public static final BlockEntityEntry<PoweredFlywheelBlockEntity> POWERED_FLYWHEEL = REGISTRATE
			.blockEntity("powered_flywheel", PoweredFlywheelBlockEntity::new)
			.visual(() -> PoweredFlywheelVisual::new, false)
			.validBlocks(DesiresBlocks.POWERED_FLYWHEEL)
			.renderer(() -> PoweredFlywheelRenderer::new)
			.register();

	public static final BlockEntityEntry<InverseBoxBlockEntity> INVERSE_BOX = REGISTRATE
			.blockEntity("inverse_box", InverseBoxBlockEntity::new)
			.visual(() -> SplitShaftVisual::new, false)
			.validBlocks(DesiresBlocks.INVERSE_BOX)
			.renderer(() -> SplitShaftRenderer::new)
			.register();

    public static final BlockEntityEntry<KineticMotorBlockEntity> KINETIC_MOTOR = REGISTRATE
            .blockEntity("motor", KineticMotorBlockEntity::new)
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(DesiresBlocks.KINETIC_MOTOR)
            .renderer(() -> KineticMotorRenderer::new).register();

    public static final BlockEntityEntry<AcceleratorMotorBlockEntity> ACCELERATOR_MOTOR = REGISTRATE
            .blockEntity("acc_motor", AcceleratorMotorBlockEntity::new)
            .visual(() -> OrientedRotatingVisual.of(AllPartialModels.SHAFT_HALF), false)
            .validBlocks(DesiresBlocks.ACCELERATOR_MOTOR)
            .renderer(() -> AcceleratorMotorRenderer::new).register();

	public static final BlockEntityEntry<GiantGearBlockEntity> GIANT_GEAR = REGISTRATE
			.blockEntity("giant_gear", GiantGearBlockEntity::new)
			.validBlocks(DesiresBlocks.GIANT_GEAR)
			.renderer(() -> GiantGearBlockRenderer::new)
			.register();

	public static final BlockEntityEntry<MultiMeterBlockEntity> MULTIMETER = REGISTRATE
			.blockEntity("multimeter", MultiMeterBlockEntity::new)
			.visual(() -> ShaftVisual::new)
			.validBlocks(DesiresBlocks.MULTIMETER)
			.renderer(() -> ShaftRenderer::new)
			.register();

	public static final BlockEntityEntry<RedstoneDividerBlockEntity> REDSTONE_DIVIDER = REGISTRATE
			.blockEntity("redstone_divider", RedstoneDividerBlockEntity::new)
			.visual(() -> SplitShaftVisual::new, false)
			.validBlocks(DesiresBlocks.REDSTONE_DIVIDER)
			.renderer(() -> SplitShaftRenderer::new)
			.register();

    public static final BlockEntityEntry<YIPPEESlidingDoorBlockEntity> SLIDING_DOOR = REGISTRATE
            .blockEntity("sliding_door", YIPPEESlidingDoorBlockEntity::new)
            .renderer(() -> YIPPEESlidingDoorRenderer::new)
            .validBlocks(DesiresBlocks.ROSE_DOOR, DesiresBlocks.SMOKED_DOOR, DesiresBlocks.SPIRIT_DOOR)
            .register();

    public static final BlockEntityEntry<PonderBoxBlockEntity> PONDER_IN_A_BOX = REGISTRATE
            .blockEntity("ponder_in_a_box", PonderBoxBlockEntity::new)
            .renderer(() -> PonderBoxRenderer::new)
            .validBlocks(DesiresBlocks.PONDER_IN_A_BOX)
            .register();


    public static final BlockEntityEntry<TwoBladeFanBlockEntity> TWO_BLADE_FAN = REGISTRATE
            .blockEntity("2_blade_fan", TwoBladeFanBlockEntity::new)
            .visual(() -> TwoBladeFanBlockVisual::new)
            .validBlocks(DesiresBlocks.TWO_BLADE_FAN)
            .renderer(() -> TwoBladeFanBlockRenderer::new)
            .register();

    public static final BlockEntityEntry<FourBladeFanBlockEntity> FOUR_BLADE_FAN = REGISTRATE
            .blockEntity("4_blade_fan", FourBladeFanBlockEntity::new)
            .visual(() -> FourBladeFanBlockVisual::new)
            .validBlocks(DesiresBlocks.FOUR_BLADE_FAN)
            .renderer(() -> FourBladeFanBlockRenderer::new)
            .register();

    public static final BlockEntityEntry<EightBladeFanBlockEntity> EIGHT_BLADE_FAN = REGISTRATE
            .blockEntity("8_blade_fan", EightBladeFanBlockEntity::new)
            .visual(() -> EightBladeFanBlockVisual::new)
            .validBlocks(DesiresBlocks.EIGHT_BLADE_FAN)
            .renderer(() -> EightBladeFanBlockRenderer::new)
            .register();

	public static void register() {}
}

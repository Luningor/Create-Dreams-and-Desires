package uwu.lopyluna.create_dd.content.blocks.kinetics.golden_mixer;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.content.processing.basin.BasinBlock;
import com.simibubi.create.foundation.block.IBE;
import net.createmod.catnip.data.Iterate;
import net.createmod.catnip.placement.PlacementHelpers;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.registry.DesiresBlockEntityTypes;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SuppressWarnings("deprecation")
public class GoldenMixerBlock extends KineticBlock implements IBE<GoldenMixerBlockEntity>, ICogWheel {
    private final int placementHelperId;
    private final int integratedCogHelperId;

    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public GoldenMixerBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));

        placementHelperId = PlacementHelpers.register(new GoldenMixerBlockItem.LargeCogHelper());
        integratedCogHelperId = PlacementHelpers.register(new GoldenMixerBlockItem.IntegratedLargeCogHelper());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (!super.canSurvive(state, level, pos))
            return false;

        for (Direction d : Direction.Plane.HORIZONTAL)
            if (level.getBlockState(pos.relative(d)).getBlock() instanceof ICogWheel)
                return false;

        return !BasinBlock.isBasin(level, pos.below());
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        if (context instanceof EntityCollisionContext eContext && eContext.getEntity() instanceof Player) return AllShapes.CASING_14PX.get(Direction.DOWN);
        return AllShapes.MECHANICAL_PROCESSOR_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return false;
    }

    @Override
    public float getParticleTargetRadius() {
        return .85f;
    }

    @Override
    public SpeedLevel getMinimumRequiredSpeedLevel() {
        return SpeedLevel.MEDIUM;
    }

    @Override
    public boolean isLargeCog() {
        return true;
    }

    @Override
    public boolean isSmallCog() {
        return false;
    }

    @Override
    public Class<GoldenMixerBlockEntity> getBlockEntityClass() {
        return GoldenMixerBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends GoldenMixerBlockEntity> getBlockEntityType() {
        return DesiresBlockEntityTypes.GOLDEN_MIXER.get();
    }

    @Override
    @ParametersAreNonnullByDefault
    public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
        return false;
    }

    public static boolean isInvalidCogwheelPosition(boolean large, LevelReader worldIn, BlockPos pos, Direction.Axis cogAxis) {
        for (Direction facing : Iterate.directions) {
            if (facing.getAxis() == cogAxis)
                continue;

            BlockPos offsetPos = pos.relative(facing);
            BlockState blockState = worldIn.getBlockState(offsetPos);
            if (blockState.hasProperty(AXIS) && facing.getAxis() == blockState.getValue(AXIS))
                continue;

            if (ICogWheel.isLargeCog(blockState) || large && ICogWheel.isSmallCog(blockState))
                return true;
        }
        return false;
    }

}

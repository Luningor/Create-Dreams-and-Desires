package uwu.lopyluna.create_dd.content.blocks.logistics.fluid_gauge;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.block.ProperWaterloggedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.registry.DesiresBlockEntityTypes;
import uwu.lopyluna.create_dd.registry.DesiresShapes;

import javax.annotation.ParametersAreNonnullByDefault;

import static net.minecraft.core.Direction.SOUTH;

@ParametersAreNonnullByDefault
@SuppressWarnings("deprecation")
public class FluidGaugeBlock extends HorizontalDirectionalBlock implements IBE<FluidGaugeBlockEntity>, IWrenchable, ProperWaterloggedBlock {

    public FluidGaugeBlock(Properties properties) {
        super(properties);
        registerDefaultState(defaultBlockState().setValue(WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        super.createBlockStateDefinition(pBuilder.add(FACING, WATERLOGGED));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockState state = super.getStateForPlacement(pContext);
        if (state == null) return null;
        if (pContext.getClickedFace().getAxis().isVertical()) return null;
        return withWater(state.setValue(FACING, pContext.getClickedFace().getOpposite()), pContext);
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return DesiresShapes.shape(1, 1., 0, 15, 15, 3).forHorizontal(SOUTH)
                .get(pState.getValue(FACING).getOpposite());
    }

    @Override
    public @NotNull FluidState getFluidState(BlockState pState) {
        return fluidState(pState);
    }

    @Override
    public @NotNull BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        updateWater(pLevel, pState, pPos);
        return pState;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        IBE.onRemove(state, level, pos, newState);
    }

    @Override
    public Class<FluidGaugeBlockEntity> getBlockEntityClass() {
        return FluidGaugeBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends FluidGaugeBlockEntity> getBlockEntityType() {
        return DesiresBlockEntityTypes.FLUID_GAUGE.get();
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
        return false;
    }

}

package uwu.lopyluna.create_dd.content.blocks.kinetics.golden_mixer;

import static com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock.AXIS;

import java.util.List;
import java.util.function.Predicate;

import com.simibubi.create.AllShapes;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.HorizontalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;

import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import net.createmod.catnip.data.Iterate;
import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementHelpers;
import net.createmod.catnip.placement.PlacementOffset;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;

public class GoldenMixerBlockItem extends AssemblyOperatorBlockItem {
    private final int placementHelperId;
    private final int integratedCogHelperId;

    public GoldenMixerBlockItem(GoldenMixerBlock block, Properties builder) {
        super(block, builder);

        placementHelperId = PlacementHelpers.register(new LargeCogHelper());
        integratedCogHelperId = PlacementHelpers.register(new IntegratedLargeCogHelper());
    }

    @Override
    public InteractionResult onItemUseFirst(ItemStack stack, UseOnContext context) {
        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = world.getBlockState(pos);

        IPlacementHelper helper = PlacementHelpers.get(placementHelperId);
        Player player = context.getPlayer();
        BlockHitResult ray = new BlockHitResult(context.getClickLocation(), context.getClickedFace(), pos, true);
        if (helper.matchesState(state) && player != null && !player.isShiftKeyDown()) {
            return helper.getOffset(player, world, state, pos, ray)
                    .placeInWorld(world, this, player, context.getHand(), ray);
        }

        if (integratedCogHelperId != -1) {
            helper = PlacementHelpers.get(integratedCogHelperId);

            if (helper.matchesState(state) && player != null && !player.isShiftKeyDown()) {
                return helper.getOffset(player, world, state, pos, ray)
                        .placeInWorld(world, this, player, context.getHand(), ray);
            }
        }

        return super.onItemUseFirst(stack, context);
    }

    @MethodsReturnNonnullByDefault
    static class LargeCogHelper extends DiagonalCogHelper {

        @Override
        public Predicate<ItemStack> getItemPredicate() {
            return ((Predicate<ItemStack>) ICogWheel::isLargeCogItem).and(ICogWheel::isDedicatedCogItem);
        }

        @Override
        public PlacementOffset getOffset(@NotNull Player player, @NotNull Level world, BlockState state, @NotNull BlockPos pos,
                                         BlockHitResult ray) {
            if (hitOnShaft(state, ray))
                return PlacementOffset.fail();

            if (ICogWheel.isLargeCog(state)) {
                Axis axis = ((IRotate) state.getBlock()).getRotationAxis(state);
                Direction side = IPlacementHelper.orderedByDistanceOnlyAxis(pos, ray.getLocation(), axis)
                        .get(0);
                List<Direction> directions = IPlacementHelper.orderedByDistanceExceptAxis(pos, ray.getLocation(), axis);
                for (Direction dir : directions) {
                    BlockPos newPos = pos.relative(dir)
                            .relative(side);

                    if (GoldenMixerBlock.isInvalidCogwheelPosition(true, world, newPos, dir.getAxis()))
                        continue;

                    if (!world.getBlockState(newPos)
                            .canBeReplaced())
                        continue;

                    return PlacementOffset.success(newPos);
                }

                return PlacementOffset.fail();
            }

            return super.getOffset(player, world, state, pos, ray);
        }
    }

    @MethodsReturnNonnullByDefault
    public abstract static class DiagonalCogHelper implements IPlacementHelper {

        @Override
        public Predicate<BlockState> getStatePredicate() {
            return s -> ICogWheel.isSmallCog(s) || ICogWheel.isLargeCog(s);
        }

        @Override
        public PlacementOffset getOffset(@NotNull Player player, @NotNull Level world, BlockState state, @NotNull BlockPos pos,
                                         BlockHitResult ray) {
            // diagonal gears of different size
            Axis axis = ((IRotate) state.getBlock()).getRotationAxis(state);
            Direction closest = IPlacementHelper.orderedByDistanceExceptAxis(pos, ray.getLocation(), axis)
                    .get(0);
            List<Direction> directions = IPlacementHelper.orderedByDistanceExceptAxis(pos, ray.getLocation(), axis,
                    d -> d.getAxis() != closest.getAxis());

            for (Direction dir : directions) {
                BlockPos newPos = pos.relative(dir)
                        .relative(closest);
                if (!world.getBlockState(newPos)
                        .canBeReplaced())
                    continue;

                if (GoldenMixerBlock.isInvalidCogwheelPosition(ICogWheel.isLargeCog(state), world, newPos, axis))
                    continue;

                return PlacementOffset.success(newPos);
            }

            return PlacementOffset.fail();
        }

        protected boolean hitOnShaft(BlockState state, BlockHitResult ray) {
            return AllShapes.SIX_VOXEL_POLE.get(((IRotate) state.getBlock()).getRotationAxis(state))
                    .bounds()
                    .inflate(0.001)
                    .contains(ray.getLocation()
                            .subtract(ray.getLocation()
                                    .align(Iterate.axisSet)));
        }
    }

    @MethodsReturnNonnullByDefault
    public static class IntegratedLargeCogHelper implements IPlacementHelper {

        @Override
        public Predicate<ItemStack> getItemPredicate() {
            return stack -> stack != null && DesiresBlocks.GOLDEN_MIXER.isIn(stack);
        }

        @Override
        public Predicate<BlockState> getStatePredicate() {
            return state -> state.getBlock() instanceof ICogWheel cog && !cog.isLargeCog();
        }

        @Override
        public PlacementOffset getOffset(@NotNull Player player, @NotNull Level world, BlockState state, @NotNull BlockPos pos,
                                         BlockHitResult ray) {
            Direction face = ray.getDirection();
            Axis newAxis;

            if (state.hasProperty(HorizontalKineticBlock.HORIZONTAL_FACING))
                newAxis = state.getValue(HorizontalKineticBlock.HORIZONTAL_FACING)
                        .getAxis();
            else if (state.hasProperty(DirectionalKineticBlock.FACING))
                newAxis = state.getValue(DirectionalKineticBlock.FACING)
                        .getAxis();
            else if (state.hasProperty(RotatedPillarKineticBlock.AXIS))
                newAxis = state.getValue(RotatedPillarKineticBlock.AXIS);
            else
                newAxis = Axis.Y;

            if (face.getAxis() == newAxis)
                return PlacementOffset.fail();

            List<Direction> directions =
                    IPlacementHelper.orderedByDistanceExceptAxis(pos, ray.getLocation(), face.getAxis(), newAxis);

            for (Direction d : directions) {
                BlockPos newPos = pos.relative(face)
                        .relative(d);

                if (!world.getBlockState(newPos)
                        .canBeReplaced())
                    continue;

                if (GoldenMixerBlock.isInvalidCogwheelPosition(false, world, newPos, newAxis))
                    return PlacementOffset.fail();

                return PlacementOffset.success(newPos);
            }

            return PlacementOffset.fail();
        }

    }
}

package uwu.lopyluna.create_dd.content.blocks.fan.four_blade;

import com.google.common.base.Predicates;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllShapes;
import com.simibubi.create.content.decoration.girder.GirderEncasedShaftBlock;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.RotatedPillarKineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.AbstractSimpleShaftBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ShaftBlock;
import com.simibubi.create.content.kinetics.steamEngine.PoweredShaftBlock;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.placement.PoleHelper;
import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementHelpers;
import net.createmod.catnip.placement.PlacementOffset;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import uwu.lopyluna.create_dd.content.blocks.fan.eight_blade.EightBladeFanBlock;
import uwu.lopyluna.create_dd.registry.DesiresBlockEntityTypes;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Predicate;

import static com.simibubi.create.foundation.block.ProperWaterloggedBlock.WATERLOGGED;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("deprecation")
public class FourBladeFanBlock extends RotatedPillarKineticBlock implements IBE<FourBladeFanBlockEntity> {

    public static final int placementHelperId = PlacementHelpers.register(new FourBladeFanBlock.PlacementHelper());

    public FourBladeFanBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Class<FourBladeFanBlockEntity> getBlockEntityClass() {
        return FourBladeFanBlockEntity.class;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AllShapes.LARGE_GEAR.get(pState.getValue(AXIS));
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public BlockEntityType<? extends FourBladeFanBlockEntity> getBlockEntityType() {
        return DesiresBlockEntityTypes.FOUR_BLADE_FAN.get();
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face.getAxis() == getRotationAxis(state);
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return state.getValue(AXIS);
    }

    @Override
    public float getParticleTargetRadius() {
        return 2f;
    }

    @Override
    public float getParticleInitialRadius() {
        return 1.75f;
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand,
                                 BlockHitResult ray) {
        if (player.isShiftKeyDown() || !player.mayBuild())
            return InteractionResult.PASS;

        ItemStack heldItem = player.getItemInHand(hand);

        if (AllBlocks.METAL_GIRDER.isIn(heldItem) && state.getValue(AXIS) != Direction.Axis.Y) {
            KineticBlockEntity.switchToBlockState(world, pos, AllBlocks.METAL_GIRDER_ENCASED_SHAFT.getDefaultState()
                    .setValue(WATERLOGGED, state.getValue(WATERLOGGED))
                    .setValue(GirderEncasedShaftBlock.HORIZONTAL_AXIS, state.getValue(AXIS) == Direction.Axis.Z ? Direction.Axis.Z : Direction.Axis.X));
            if (!world.isClientSide && !player.isCreative()) {
                heldItem.shrink(1);
                if (heldItem.isEmpty())
                    player.setItemInHand(hand, ItemStack.EMPTY);
            }
            return InteractionResult.SUCCESS;
        }

        IPlacementHelper helper = PlacementHelpers.get(placementHelperId);
        if (helper.matchesItem(heldItem))
            return helper.getOffset(player, world, state, pos, ray)
                    .placeInWorld(world, (BlockItem) heldItem.getItem(), player, hand, ray);

        return InteractionResult.PASS;
    }

    @MethodsReturnNonnullByDefault
    private static class PlacementHelper extends PoleHelper<Direction.Axis> {
        // used for extending a shaft in its axis, like the piston poles. works with
        // shafts and cogs

        private PlacementHelper() {
            super(state -> state.getBlock() instanceof AbstractSimpleShaftBlock
                    || state.getBlock() instanceof PoweredShaftBlock, state -> state.getValue(AXIS), AXIS);
        }

        @Override
        public Predicate<ItemStack> getItemPredicate() {
            return i -> {
                if (!(i.getItem() instanceof BlockItem blockItem))
                    return false;

                var block = blockItem.getBlock();

                return block instanceof AbstractSimpleShaftBlock
                        || block == DesiresBlocks.EIGHT_BLADE_FAN.get()
                        || block == DesiresBlocks.FOUR_BLADE_FAN.get()
                        || block == DesiresBlocks.TWO_BLADE_FAN.get();
            };
        }

        @Override
        public Predicate<BlockState> getStatePredicate() {
            return Predicates.or(
                    state -> state != null && AllBlocks.SHAFT.has(state),
                    state1 -> state1 != null && AllBlocks.POWERED_SHAFT.has(state1),
                    state2 -> state2 != null && DesiresBlocks.EIGHT_BLADE_FAN.has(state2),
                    state3 -> state3 != null && DesiresBlocks.FOUR_BLADE_FAN.has(state3),
                    state4 -> state4 != null && DesiresBlocks.TWO_BLADE_FAN.has(state4)
            );
        }

        @Override
        public PlacementOffset getOffset(Player player, Level world, BlockState state, BlockPos pos,
                                         BlockHitResult ray) {
            PlacementOffset offset = super.getOffset(player, world, state, pos, ray);
            if (offset.isSuccessful())
                offset.withTransform(offset.getTransform()
                        .andThen(s -> world.isClientSide() ? s
                                : ShaftBlock.pickCorrectShaftType(s, world, offset.getBlockPos())));
            return offset;
        }
    }

}

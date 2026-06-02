package uwu.lopyluna.create_dd.content.blocks.kinetics.spud_sentry;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.items.ItemHandlerHelper;
import uwu.lopyluna.create_dd.registry.DesiresBlockEntityTypes;

@SuppressWarnings({"NullableProblems", "deprecation"})
public class SpudSentryBlock extends KineticBlock implements IBE<SpudSentryBlockEntity>, ICogWheel {
    public SpudSentryBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (placer instanceof Player player && !(player instanceof FakePlayer) && level.getBlockEntity(pos) instanceof SpudSentryBlockEntity be) {
            if (be.ownerUUID == null) {
                be.ownerUUID = placer.getUUID();
                be.owner = player;
            }
            be.xRot = be.getDesiredXRot(player);
            be.yRot = be.getDesiredYRot(player);
            be.lerpX.setValue(be.xRot);
            be.lerpX.updateChaseTarget(be.xRot);
            be.lerpY.setValue(be.yRot);
            be.lerpY.updateChaseTarget(be.yRot);
            be.setChanged();
            if (!level.isClientSide) be.notifyUpdate();
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack stack = player.getItemInHand(hand);
        if (!(player instanceof FakePlayer) && level.getBlockEntity(pos) instanceof SpudSentryBlockEntity be) {
            if (be.ownerUUID == null) {
                be.ownerUUID = player.getUUID();
                be.owner = player;
            }
            if (!stack.isEmpty()) {
                var count = stack.getCount();
                be.inputInv.insert(stack);
                if (count != stack.getCount()) {
                    level.playSound(null, player.getX(), player.getY() + 0.5, player.getZ(),
                            SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, ((level.random.nextFloat() - level.random.nextFloat()) * 0.5F + 1.0F) * 2.0F);
                    return InteractionResult.SUCCESS;
                }
            } else {
                var input = be.getInput().copy();
                if (input.isEmpty()) return super.use(state, level, pos, player, hand, hitResult);
                be.inputInv.extractItem(0, input.getCount(), false);
                ItemHandlerHelper.giveItemToPlayer(player, input);
                return InteractionResult.SUCCESS;
            }
        }
        return super.use(state, level, pos, player, hand, hitResult);
    }

    @Override
    public boolean hasShaftTowards(LevelReader world, BlockPos pos, BlockState state, Direction face) {
        return face == Direction.DOWN;
    }

    @Override
    public Direction.Axis getRotationAxis(BlockState state) {
        return Direction.Axis.Y;
    }

    @Override
    public Class<SpudSentryBlockEntity> getBlockEntityClass() {
        return SpudSentryBlockEntity.class;
    }

    @Override
    public BlockEntityType<? extends SpudSentryBlockEntity> getBlockEntityType() {
        return DesiresBlockEntityTypes.SPUD_SENTRY.get();
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}

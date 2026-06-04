package uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;
import uwu.lopyluna.create_dd.registry.DesiresPartialModels;

import java.util.List;

public class CogCrankBlockEntity extends GeneratingKineticBlockEntity {
    public int inUse;
    public boolean backwards;
    public float independentAngle;
    public float chasingVelocity;

    public CogCrankBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean isLarge() {
        return getBlockState().getBlock() instanceof CogCrankBlock block && block.isLarge;
    }

    public BlockEntry<CogCrankBlock> getBlockEntry() {
        return isLarge() ? DesiresBlocks.LARGE_COG_CRANK : DesiresBlocks.COG_CRANK;
    }

    public Direction facing(Direction.Axis axis) {
        return Direction.fromAxisAndDirection(axis, Direction.AxisDirection.POSITIVE);
    }

    public void turn(boolean back) {
        assert level != null;
        var update = getGeneratedSpeed() == 0 || back != backwards;
        inUse = 10;
        backwards = back;
        if (update && !level.isClientSide) updateGeneratedRotation();
    }

    public float getIndependentAngle(float partialTicks) {
        return (independentAngle + partialTicks * chasingVelocity) / 360;
    }

    @Override
    public float getGeneratedSpeed() {
        var state = getBlockState();
        if (state.getBlock() instanceof CogCrankBlock crank)
            return convertToDirection((inUse == 0 ? 0 : clockwise() ? -1 : 1) * crank.getRotationSpeed(), facing(state.getValue(CogCrankBlock.AXIS)));
        return 0;
    }

    protected boolean clockwise() {
        return backwards;
    }

    @Override
    public void write(CompoundTag compound, boolean clientPacket) {
        compound.putInt("InUse", inUse);
        compound.putBoolean("Backwards", backwards);
        super.write(compound, clientPacket);
    }

    @Override
    protected void read(CompoundTag compound, boolean clientPacket) {
        inUse = compound.getInt("InUse");
        backwards = compound.getBoolean("Backwards");
        super.read(compound, clientPacket);
    }

    @Override
    public void tick() {
        super.tick();
        assert level != null;

        var actualSpeed = getSpeed();
        chasingVelocity += ((actualSpeed * 10 / 3f) - chasingVelocity) * .25f;
        independentAngle += chasingVelocity;

        if (inUse > 0 && --inUse == 0 && !level.isClientSide) {
            sequenceContext = null;
            updateGeneratedRotation();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public SuperByteBuffer getRenderedHandle() {
        var blockState = getBlockState();
        var axis = blockState.getOptionalValue(CogCrankBlock.AXIS).orElse(Direction.Axis.Y);
        return CachedBuffers.partialFacing(DesiresPartialModels.COG_CRANK_HANDLE, blockState, facing(axis));
    }

    @OnlyIn(Dist.CLIENT)
    public boolean shouldRenderCog() {
        return true;
    }

    @Override
    protected Block getStressConfigKey() {
        var entry = getBlockEntry();
        return entry.has(getBlockState()) ? entry.get() : AllBlocks.COPPER_VALVE_HANDLE.get();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void tickAudio() {
        super.tickAudio();
        if (inUse > 0 && AnimationTickHolder.getTicks() % 10 == 0) {
            var entry = getBlockEntry();
            if (!entry.has(getBlockState())) return;
            AllSoundEvents.CRANKING.playAt(level, worldPosition, (inUse) / 2.5f, .65f + (10 - inUse) / 10f, true);
        }
    }

    @Override
    protected boolean canPropagateDiagonally(IRotate block, BlockState state) {
        return state.getBlock() instanceof ICogWheel || block instanceof ICogWheel;
    }

    @Override
    public List<BlockPos> addPropagationLocations(IRotate block, BlockState state, List<BlockPos> neighbours) {
        if (!canPropagateDiagonally(block, state))
            return neighbours;

        Direction.Axis axis = block.getRotationAxis(state);
        BlockPos.betweenClosedStream(new BlockPos(-1, -1, -1), new BlockPos(1, 1, 1))
                .forEach(offset -> {
                    if (axis.choose(offset.getX(), offset.getY(), offset.getZ()) != 0)
                        return;
                    if (offset.distSqr(BlockPos.ZERO) != 2)
                        return;
                    neighbours.add(worldPosition.offset(offset));
                });
        return neighbours;
    }
}

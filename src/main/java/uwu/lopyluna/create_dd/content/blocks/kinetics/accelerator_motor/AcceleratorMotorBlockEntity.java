package uwu.lopyluna.create_dd.content.blocks.kinetics.accelerator_motor;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.GeneratingKineticBlockEntity;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.ValueBoxTransform;
import com.simibubi.create.foundation.blockEntity.behaviour.scrollValue.ScrollValueBehaviour;
import java.util.List;

import com.simibubi.create.foundation.utility.CreateLang;
import dev.engine_room.flywheel.lib.transform.TransformStack;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;
import uwu.lopyluna.create_dd.registry.helper.Lang;

public class AcceleratorMotorBlockEntity extends GeneratingKineticBlockEntity {
    public static final int DEFAULT_SPEED = 16;
    public static final int MAX_SPEED = 256;
    protected ScrollValueBehaviour generatedSpeed;

    public AcceleratorMotorBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
        int max = 256;
        this.generatedSpeed = new AcceleratorMotorScrollValueBehaviour(Lang.translateDirect("kinetics.creative_motor.rotation_speed"), this, new MotorValueBox());
        this.generatedSpeed.between(-max, max);
        this.generatedSpeed.value = 16;
        this.generatedSpeed.withCallback((i) -> {
            this.updateGeneratedRotation();
        });
        behaviours.add(this.generatedSpeed);
    }

    public void initialize() {
        super.initialize();
        if (!this.hasSource() || this.getGeneratedSpeed() > this.getTheoreticalSpeed()) {
            this.updateGeneratedRotation();
        }

    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        if (!IRotate.StressImpact.isEnabled())
            return super.addToGoggleTooltip(tooltip, isPlayerSneaking);

        float stressBase = calculateAddedStressCapacity();
        if (Mth.equal(stressBase, 0))
            return super.addToGoggleTooltip(tooltip, isPlayerSneaking);

        Lang.builder()
                .translate("gui.goggles.generator_stats")
                .forGoggles(tooltip);
        Lang.builder()
                .translate("tooltip.capacityProvided")
                .style(ChatFormatting.GRAY)
                .forGoggles(tooltip);


        Lang.builder()
                .add(CreateLang.number(stressBase))
                .translate("generic.unit.stress")
                .style(ChatFormatting.AQUA)
                .space()
                .add(Lang.builder()
                        .translate("gui.goggles.at_current_speed")
                        .style(ChatFormatting.DARK_GRAY))
                .forGoggles(tooltip, 1);

        return true;
    }

    public float getGeneratedSpeed() {
        if (!DesiresBlocks.ACCELERATOR_MOTOR.has(getBlockState()))
            return 0;
        return convertToDirection(generatedSpeed.getValue(), getBlockState().getValue(AcceleratorMotorBlock.FACING));
    }

    static class MotorValueBox extends ValueBoxTransform.Sided {
        MotorValueBox() {
        }

        protected Vec3 getSouthLocation() {
            return VecHelper.voxelSpace(8.0, 8.0, 12.5);
        }

        @Override
        public Vec3 getLocalOffset(LevelAccessor level, BlockPos pos, BlockState state) {
            Direction facing = (Direction)state.getValue(AcceleratorMotorBlock.FACING);
            return super.getLocalOffset(level, pos, state).add(Vec3.atLowerCornerOf(facing.getNormal()).scale(-0.0625));
        }

        @Override
        public void rotate(LevelAccessor level, BlockPos pos, BlockState state, PoseStack ms) {
            super.rotate(level, pos, state, ms);
            Direction facing = state.getValue(AcceleratorMotorBlock.FACING);
            if (facing.getAxis() == Axis.Y)
                return;
            if (getSide() != Direction.UP)
                return;
            TransformStack.of(ms)
                    .rotateZDegrees(-AngleHelper.horizontalAngle(facing) + 180);
        }

        protected boolean isSideActive(BlockState state, Direction direction) {
            Direction facing = (Direction)state.getValue(AcceleratorMotorBlock.FACING);
            if (facing.getAxis() != Axis.Y && direction == Direction.DOWN) {
                return false;
            } else {
                return direction.getAxis() != facing.getAxis();
            }
        }
    }
}

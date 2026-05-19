package uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityVisual;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.render.CachedBuffers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class GiantGearBlockRenderer extends KineticBlockEntityRenderer<GiantGearBlockEntity> {

    public GiantGearBlockRenderer(BlockEntityRendererProvider.Context context) { super(context); }

    @Override
    protected void renderSafe(GiantGearBlockEntity be, float partialTicks, PoseStack ms,
                              MultiBufferSource buffer, int light, int overlay) {

        float angle = GiantGearBlockRenderer.getAngleForBe(be, be.getBlockPos(), be.getBlockState().getValue(GiantGearBlock.AXIS));;
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);

        CachedBuffers.block(be.getBlockState())
                .light(light)
                .rotateCentered(angle, be.getBlockState().getValue(GiantGearBlock.AXIS))
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

    public static float getAngleForBe(KineticBlockEntity be, final BlockPos pos, Direction.Axis axis) {
        float time = AnimationTickHolder.getRenderTime(be.getLevel());
        float offset = getRotationOffsetForPosition(be, pos, axis);
        return ((time * be.getSpeed() * 3f / 10 + offset) % 360) / 180 * (float) Math.PI;
    }

    public static float getRotationOffsetForPosition(KineticBlockEntity be, final BlockPos pos, final Direction.Axis axis) {
        return KineticBlockEntityVisual.rotationOffset(be.getBlockState(), axis, pos) + be.getRotationAngleOffset(axis);
    }
}
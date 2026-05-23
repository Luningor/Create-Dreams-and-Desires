package uwu.lopyluna.create_dd.content.blocks.contraptions.drill.shadow;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.virtualWorld.VirtualRenderWorld;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.contraptions.render.ContraptionMatrices;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.math.VecHelper;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import uwu.lopyluna.create_dd.registry.DesiresPartialModels;

public class ShadowDrillRenderer extends KineticBlockEntityRenderer<ShadowDrillBlockEntity> {

    public ShadowDrillRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(ShadowDrillBlockEntity be, BlockState state) {
        return CachedBuffers.partialFacing(DesiresPartialModels.SHADOW_DRILL_HEAD, state);
    }

    public static void renderInContraption(MovementContext context, VirtualRenderWorld renderWorld,
                                           ContraptionMatrices matrices, MultiBufferSource buffer) {
        BlockState state = context.state;
        SuperByteBuffer superBuffer = CachedBuffers.partial(DesiresPartialModels.SHADOW_DRILL_HEAD, state);
        Direction facing = state.getValue(ShadowDrillBlock.FACING);

        float speed = (float) (context.contraption.stalled
                || !VecHelper.isVecPointingTowards(context.relativeMotion, facing
                .getOpposite()) ? context.getAnimationSpeed() : 0);
        float time = AnimationTickHolder.getRenderTime() / 20;
        float angle = (float) (((time * speed) % 360));

        superBuffer
                .transform(matrices.getModel())
                .center()
                .rotateY(AngleHelper.horizontalAngle(facing))
                .rotateX(AngleHelper.verticalAngle(facing))
                .rotateZ(angle)
                .uncenter()
                .light(LightTexture.FULL_BRIGHT)
                .renderInto(matrices.getViewProjection(), buffer.getBuffer(RenderType.translucent()));
    }

    protected void renderSafe(ShadowDrillBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {

        BlockState state = be.getBlockState();

        SuperByteBuffer superBuffer = CachedBuffers.partialFacing(DesiresPartialModels.SHADOW_DRILL_HEAD, state);

        standardKineticRotationTransform(superBuffer, be, light)
                .center()
                .uncenter()
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

}

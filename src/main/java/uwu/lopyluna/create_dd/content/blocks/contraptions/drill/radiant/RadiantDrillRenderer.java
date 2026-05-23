package uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.foundation.virtualWorld.VirtualRenderWorld;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.contraptions.render.ContraptionMatrices;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import net.createmod.catnip.render.CachedBuffers;
import net.createmod.catnip.render.SuperByteBuffer;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.math.AngleHelper;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import uwu.lopyluna.create_dd.registry.DesiresPartialModels;

public class RadiantDrillRenderer extends KineticBlockEntityRenderer<RadiantDrillBlockEntity> {

    public RadiantDrillRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected SuperByteBuffer getRotatedModel(RadiantDrillBlockEntity be, BlockState state) {
        return CachedBuffers.partialFacing(DesiresPartialModels.RADIANT_DRILL_HEAD, state);
    }

    public static void renderInContraption(MovementContext context, VirtualRenderWorld renderWorld,
                                           ContraptionMatrices matrices, MultiBufferSource buffer) {
        BlockState state = context.state;
        SuperByteBuffer superBuffer = CachedBuffers.partial(DesiresPartialModels.RADIANT_DRILL_HEAD, state);

        Direction facing = state.getValue(RadiantDrillBlock.FACING);

        float speed = (context.contraption.stalled
                || !VecHelper.isVecPointingTowards(context.relativeMotion, facing
                .getOpposite()) ? context.getAnimationSpeed() : 0);
        float time = AnimationTickHolder.getRenderTime() / 20;
        float angle = (((time * speed) % 360));

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

    protected void renderSafe(RadiantDrillBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {

        BlockState state = be.getBlockState();

        SuperByteBuffer superBuffer = CachedBuffers.partialFacing(DesiresPartialModels.RADIANT_DRILL_HEAD, state);

        standardKineticRotationTransform(superBuffer, be, light)
                .center()
                .uncenter()
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

}

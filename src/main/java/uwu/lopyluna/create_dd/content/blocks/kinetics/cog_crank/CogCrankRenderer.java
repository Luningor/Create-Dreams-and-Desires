package uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;

import com.simibubi.create.content.kinetics.base.KineticBlockEntityVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class CogCrankRenderer extends KineticBlockEntityRenderer<CogCrankBlockEntity> {

    public CogCrankRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    public static float getAngleForBe(KineticBlockEntity be, final BlockPos pos, Direction.Axis axis) {
        float time = AnimationTickHolder.getRenderTime(be.getLevel());
        float offset = getRotationOffsetForPosition(be, pos, axis);
        return ((time * be.getSpeed() * 3f / 10 + offset) % 360) / 180 * (float) Math.PI;
    }

    public static float getRotationOffsetForPosition(KineticBlockEntity be, final BlockPos pos, final Direction.Axis axis) {
        return KineticBlockEntityVisual.rotationOffset(be.getBlockState(), axis, pos) + be.getRotationAngleOffset(axis);
    }

    @Override
    protected void renderSafe(CogCrankBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer,
                              int light, int overlay) {
        if (be.shouldRenderCog())
            super.renderSafe(be, partialTicks, ms, buffer, light, overlay);

        if (VisualizationManager.supportsVisualization(be.getLevel()))
            return;

        Direction facing = be.getBlockState()
                .getValue(FACING);
        standardKineticRotationTransform(be.getRenderedHandle(), be, light)
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }

}
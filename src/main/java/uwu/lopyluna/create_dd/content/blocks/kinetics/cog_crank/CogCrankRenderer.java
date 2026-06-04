package uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.kinetics.base.KineticBlockEntityRenderer;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;

public class CogCrankRenderer extends KineticBlockEntityRenderer<CogCrankBlockEntity> {
    public CogCrankRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(CogCrankBlockEntity BlockEntity, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        if (BlockEntity.shouldRenderCog()) super.renderSafe(BlockEntity, partialTicks, ms, buffer, light, overlay);

        if (VisualizationManager.supportsVisualization(BlockEntity.getLevel())) return;
        kineticRotationTransform(BlockEntity.getRenderedHandle(), BlockEntity, BlockEntity.getBlockState().getValue(CogCrankBlock.AXIS), BlockEntity.getIndependentAngle(partialTicks), light)
                .renderInto(ms, buffer.getBuffer(RenderType.solid()));
    }
}
package uwu.lopyluna.create_dd.content.blocks.logistics.fluid_gauge;

import com.mojang.blaze3d.vertex.PoseStack;
import com.simibubi.create.content.fluids.tank.FluidTankBlockEntity;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import net.createmod.catnip.render.CachedBuffers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import uwu.lopyluna.create_dd.registry.DesiresPartialModels;

public class FluidGaugeRenderer extends SmartBlockEntityRenderer<FluidGaugeBlockEntity> {
    public FluidGaugeRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected void renderSafe(FluidGaugeBlockEntity be, float partialTicks, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        super.renderSafe(be, partialTicks, ms, buffer, light, overlay);
        var level = be.getLevel();
        var state = be.getBlockState();
        var facing = state.getValue(FluidGaugeBlock.FACING);
        var vb = buffer.getBuffer(RenderType.cutout());
        ms.pushPose();
        float progress = be.target.getValue(partialTicks);
        float off = -180;

        FluidTankBlockEntity tank = level == null ?
                null : be.getBoiler(level.getBlockEntity(be.getBlockPos().relative(facing)));

        if (tank != null) {
            progress = tank.boiler.gauge.getValue(partialTicks);
            off = -145;
        }


        float dialPivotY = 6f / 16;
        float dialPivotZ = 8f / 16;
        float yRot = -facing.toYRot() - 180;
        var x = switch (facing) {
            case NORTH, EAST -> 0.5f;
            case SOUTH, WEST -> -0.5f;
            default -> 0f;
        };
        var z = switch (facing) {
            case NORTH, WEST -> 0.5f;
            case SOUTH, EAST -> -0.5f;
            default -> 0f;
        };

        CachedBuffers.partial(DesiresPartialModels.GAUGE_NEEDLE, state)
                .rotateYDegrees(yRot)
                .uncenter()
                .translate(x, 0.5f, 0f)
                .translate(0, 0, 1 / 2f - 8 / 16f)
                .translate(dialPivotZ, dialPivotY, z)
                .rotateZDegrees(off * progress + 90)
                .translate(-dialPivotZ, -dialPivotY, 0)
                .light(light)
                .renderInto(ms, vb);
        ms.popPose();
    }
}

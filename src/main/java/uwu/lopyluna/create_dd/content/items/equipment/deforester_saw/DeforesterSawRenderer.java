package uwu.lopyluna.create_dd.content.items.equipment.deforester_saw;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import dev.engine_room.flywheel.lib.transform.TransformStack;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DeforesterSawRenderer extends CustomRenderedItemModelRenderer {
    protected static final PartialModel ITEM = PartialModel.of(DesiresCreate.asResource("item/deforester_saw/item"));
    protected static final PartialModel SHAFT = PartialModel.of(DesiresCreate.asResource("item/deforester_saw/shaft"));
    protected static final PartialModel GEAR = PartialModel.of(DesiresCreate.asResource("item/deforester_saw/gear"));

    private static final Vec3 SHAFT_ROTATION_OFFSET = new Vec3(0, 5.5 / 16f, 0);
    private static final Vec3 GEAR_ROTATION_OFFSET = new Vec3(-3.25 / 16f, -1.5 / 16f, 0);

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer, ItemDisplayContext transformType,
                          PoseStack ms, MultiBufferSource buffer, int light, int overlay) {
        float worldTime = AnimationTickHolder.getRenderTime();

        renderer.render(ITEM.get(), light);

        ms.pushPose();
        float angle = worldTime * .5f % 360;

        ms.translate(GEAR_ROTATION_OFFSET.x, GEAR_ROTATION_OFFSET.y, GEAR_ROTATION_OFFSET.z);
        ms.mulPose(Axis.ZP.rotationDegrees(angle));
        ms.translate(-GEAR_ROTATION_OFFSET.x, -GEAR_ROTATION_OFFSET.y, -GEAR_ROTATION_OFFSET.z);

        renderer.render(GEAR.get(), light);
        ms.popPose();

        ms.pushPose();
        float angleFast = (worldTime * 0.5f % 360) * -32;

        ms.translate(SHAFT_ROTATION_OFFSET.x, SHAFT_ROTATION_OFFSET.y, SHAFT_ROTATION_OFFSET.z);
        ms.mulPose(Axis.ZP.rotationDegrees(angleFast));
        ms.translate(-SHAFT_ROTATION_OFFSET.x, -SHAFT_ROTATION_OFFSET.y, -SHAFT_ROTATION_OFFSET.z);

        renderer.render(SHAFT.get(), light);
        ms.popPose();


    }
}
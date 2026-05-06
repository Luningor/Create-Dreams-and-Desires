package uwu.lopyluna.create_dd.content.items.equipment.excavation_drill;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import dev.engine_room.flywheel.lib.transform.TransformStack;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import uwu.lopyluna.create_dd.DesiresCreate;

public class ExcavationDrillRenderer extends CustomRenderedItemModelRenderer {
    protected static final PartialModel ITEM = PartialModel.of(DesiresCreate.asResource("item/excavation_drill/item"));
    protected static final PartialModel HEAD = PartialModel.of(DesiresCreate.asResource("item/excavation_drill/head"));
    protected static final PartialModel GEAR = PartialModel.of(DesiresCreate.asResource("item/excavation_drill/gear"));

    private static final Vec3 HEAD_ROTATION_OFFSET = new Vec3(0, -4 / 16f, -7 / 16f);
    private static final Vec3 GEAR_ROTATION_OFFSET = new Vec3(0, -3 / 16f, 1 / 16f);

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer,
                          ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer,
                          int light, int overlay) {

        Minecraft mc = Minecraft.getInstance();
        boolean playerHeldAttack = mc.options.keyAttack.isDown();
        boolean playerHeldShift = mc.options.keyShift.isDown();

        float worldTime = AnimationTickHolder.getRenderTime();

        renderer.render(ITEM.get(), light);

        // ===== GEAR =====
        ms.pushPose();
        float angle = worldTime * 0.5f;

        ms.translate(GEAR_ROTATION_OFFSET.x, GEAR_ROTATION_OFFSET.y, GEAR_ROTATION_OFFSET.z);
        ms.mulPose(Axis.ZP.rotationDegrees(angle));
        ms.translate(-GEAR_ROTATION_OFFSET.x, -GEAR_ROTATION_OFFSET.y, -GEAR_ROTATION_OFFSET.z);

        renderer.render(GEAR.get(), light);
        ms.popPose();

        // ===== HEAD =====
        ms.pushPose();
        float angleFast = (worldTime * 0.5f) * (
                playerHeldShift ?
                        (playerHeldAttack ? -64 : -32) :
                        (playerHeldAttack ? -32 : -16)
        );

        ms.translate(HEAD_ROTATION_OFFSET.x, HEAD_ROTATION_OFFSET.y, HEAD_ROTATION_OFFSET.z);
        ms.mulPose(Axis.ZP.rotationDegrees(angleFast));
        ms.translate(-HEAD_ROTATION_OFFSET.x, -HEAD_ROTATION_OFFSET.y, -HEAD_ROTATION_OFFSET.z);

        renderer.render(HEAD.get(), light);
        ms.popPose();
    }
}
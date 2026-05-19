package uwu.lopyluna.create_dd.content.items.equipment.deforester_saw;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModel;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.PartialItemModelRenderer;
import dev.engine_room.flywheel.lib.model.baked.PartialModel;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import uwu.lopyluna.create_dd.DesiresCreate;

public class ForestRavagerRenderer extends CustomRenderedItemModelRenderer {
    protected static final PartialModel ITEM = PartialModel.of(DesiresCreate.asResource("item/forest_ravager/item"));
    protected static final PartialModel GEAR = PartialModel.of(DesiresCreate.asResource("item/forest_ravager/gear"));
    protected static final PartialModel CORE = PartialModel.of(DesiresCreate.asResource("item/forest_ravager/core"));
    protected static final PartialModel CORE_GLOW = PartialModel.of(DesiresCreate.asResource("item/forest_ravager/core_glow/item"));

    //private static final Vec3 SHAFT_ROTATION_OFFSET = new Vec3(0, 0, 0);
    private static final Vec3 GEAR_ROTATION_OFFSET = new Vec3(0, 0, 0);

    @Override
    protected void render(ItemStack stack, CustomRenderedItemModel model, PartialItemModelRenderer renderer,
                          ItemDisplayContext transformType, PoseStack ms, MultiBufferSource buffer, int light, int overlay) {

        int maxLight = 0xF000F0;
        float worldTime = AnimationTickHolder.getRenderTime();

        // Render main item
        renderer.render(ITEM.get(), light);

        // Render glowing core
        renderer.renderSolidGlowing(CORE.get(), maxLight);
        renderer.renderGlowing(CORE_GLOW.get(), maxLight);

        // Render rotating gear
        ms.pushPose();
        float gearAngle = (worldTime * 0.5f) % 360;
        ms.translate(GEAR_ROTATION_OFFSET.x, GEAR_ROTATION_OFFSET.y, GEAR_ROTATION_OFFSET.z);
        ms.mulPose(Axis.YP.rotationDegrees(gearAngle));
        ms.translate(-GEAR_ROTATION_OFFSET.x, -GEAR_ROTATION_OFFSET.y, -GEAR_ROTATION_OFFSET.z);
        renderer.render(GEAR.get(), maxLight);
        ms.popPose();
    }
}
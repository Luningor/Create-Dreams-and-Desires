package uwu.lopyluna.create_dd.content.items.equipment.ore_devastator;

import com.simibubi.create.content.equipment.armor.BacktankUtil;
import com.simibubi.create.foundation.item.CustomArmPoseItem;
import com.simibubi.create.foundation.item.render.SimpleCustomRenderer;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.create_dd.content.items.equipment.BackTankPickaxeItem;
import uwu.lopyluna.create_dd.infrastructure.utility.BoreMining;
import uwu.lopyluna.create_dd.infrastructure.utility.VeinMining;
import uwu.lopyluna.create_dd.registry.DesiresTags;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

import static uwu.lopyluna.create_dd.registry.DesireTiers.Drill;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
@SuppressWarnings({"all"})
public class OreDevastatorItem extends BackTankPickaxeItem implements CustomArmPoseItem {
    private static boolean veinExcavating = false;
    public OreDevastatorItem(Properties pProperties) {
        super(Drill, 5, -2.8F, pProperties);
    }

    public float getDestroySpeed(ItemStack pStack, BlockState pState) {
        return pState.is(DesiresTags.forgeBlockTag("ores")) ? this.speed * 5 * 0.75f : this.speed * 5;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        boolean result = super.mineBlock(stack, level, state, pos, entity);

        if (level.isClientSide) return result;
        if (!(entity instanceof Player player)) return result;

        if (!player.isShiftKeyDown()) {
            level.destroyBlock(pos, true, player);
            return result;
        }
        else {
            if (veinExcavating) return result;
            veinExcavating = true;

            try {
                Vec3 vec = player.getLookAngle();

                if (state.is(DesiresTags.forgeBlockTag("ores"))) VeinMining
                        .findVein(level, pos, DesiresTags.forgeBlockTag("ores"), 64)
                        .destroyBlocks(level, stack, player,
                                (dropPos, item) -> dropItemFromExcavatedVein(level, pos, vec, dropPos, item));
                else if (player instanceof ServerPlayer serverPlayer) BoreMining
                        .findBore(1, pos, serverPlayer)
                        .destroyBlocks(level, stack, player,
                                (dropPos, item) -> dropItemFromExcavatedVein(level, pos, vec, dropPos, item));
            } finally {
                veinExcavating = false;
            }
        }

        return result;
    }

    public static void dropItemFromExcavatedVein(Level world, BlockPos breakingPos, Vec3 fallDirection, BlockPos pos,
                                           ItemStack stack) {
        float distance = (float) Math.sqrt(pos.distSqr(breakingPos));
        Vec3 dropPos = VecHelper.getCenterOf(pos);
        ItemEntity entity = new ItemEntity(world, dropPos.x, dropPos.y, dropPos.z, stack);
        entity.setDeltaMovement(fallDirection.scale(distance / 16f));
        world.addFreshEntity(entity);
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return slotChanged || newStack.getItem() != oldStack.getItem();
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public HumanoidModel.@Nullable ArmPose getArmPose(ItemStack stack, AbstractClientPlayer player, InteractionHand hand) {
        if (!player.swinging) return HumanoidModel.ArmPose.CROSSBOW_HOLD;
        return null;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(SimpleCustomRenderer.create(this, new OreDevastatorRenderer()));
    }

    @Override
    public boolean isBarVisible(@NotNull ItemStack stack) {
        return BacktankUtil.isBarVisible(stack, maxUses());
    }

    @Override
    public int getBarWidth(@NotNull ItemStack stack) {
        return BacktankUtil.getBarWidth(stack, maxUses());
    }

    @Override
    public int getBarColor(@NotNull ItemStack stack) {
        return BacktankUtil.getBarColor(stack, maxUses());
    }

    public static int maxUses() {
        return Drill.getUses();
    }
}

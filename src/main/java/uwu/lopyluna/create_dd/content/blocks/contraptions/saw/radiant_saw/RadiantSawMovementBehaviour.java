package uwu.lopyluna.create_dd.content.blocks.contraptions.saw.radiant_saw;

import com.simibubi.create.content.contraptions.render.ActorVisual;
import com.simibubi.create.foundation.virtualWorld.VirtualRenderWorld;
import com.simibubi.create.content.contraptions.behaviour.MovementContext;
import com.simibubi.create.content.contraptions.mounted.MountedContraption;
import com.simibubi.create.content.contraptions.render.ContraptionMatrices;
import com.simibubi.create.content.kinetics.base.BlockBreakingMovementBehaviour;
import com.simibubi.create.content.trains.entity.CarriageContraption;
import com.simibubi.create.foundation.damageTypes.CreateDamageSources;
import com.simibubi.create.foundation.utility.AbstractBlockBreakQueue;
import com.simibubi.create.content.kinetics.saw.TreeCutter;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.api.visualization.VisualizationManager;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.items.ItemHandlerHelper;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant.RadiantDrillActorVisual;
import uwu.lopyluna.create_dd.content.blocks.contraptions.drill.radiant.RadiantDrillRenderer;

import javax.annotation.Nullable;
import java.util.Optional;

public class RadiantSawMovementBehaviour extends BlockBreakingMovementBehaviour {

    @Override
    public boolean isActive(MovementContext context) {
        return super.isActive(context)
                && !VecHelper.isVecPointingTowards(context.relativeMotion, context.state.getValue(RadiantSawBlock.FACING)
                .getOpposite());
    }

    @Override
    public Vec3 getActiveAreaOffset(MovementContext context) {
        return Vec3.atLowerCornerOf(context.state.getValue(RadiantSawBlock.FACING)
                        .getNormal())
                .scale(.65f);
    }

    @Override
    public boolean disableBlockEntityRendering() {
        return true;
    }

    @Override
    @OnlyIn(value = Dist.CLIENT)
    public void renderInContraption(MovementContext context, VirtualRenderWorld renderWorld,
                                    ContraptionMatrices matrices, MultiBufferSource buffer) {
        if (!VisualizationManager.supportsVisualization(context.world))
            RadiantDrillRenderer.renderInContraption(context, renderWorld, matrices, buffer);
    }

    @Nullable
    @Override
    public ActorVisual createVisual(VisualizationContext visualizationContext, VirtualRenderWorld simulationWorld, MovementContext movementContext) {
        return new RadiantDrillActorVisual(visualizationContext, simulationWorld, movementContext);
    }

    @Override
    public void visitNewPosition(MovementContext context, BlockPos pos) {
        super.visitNewPosition(context, pos);
        Vec3 facingVec = Vec3.atLowerCornerOf(context.state.getValue(RadiantSawBlock.FACING)
                .getNormal());
        facingVec = context.rotation.apply(facingVec);

        Direction closestToFacing = Direction.getNearest(facingVec.x, facingVec.y, facingVec.z);
        if (closestToFacing.getAxis()
                .isVertical() && context.data.contains("BreakingPos")) {
            context.data.remove("BreakingPos");
            context.stall = false;
        }
    }

    @Override
    public boolean canBreak(Level world, BlockPos breakingPos, BlockState state) {
        return super.canBreak(world, breakingPos, state) && RadiantSawBlockEntity.isSawable(state);
    }

    @Override
    protected void onBlockBroken(MovementContext context, BlockPos pos, BlockState brokenState) {
        if (brokenState.is(BlockTags.LEAVES))
            return;

        Optional<AbstractBlockBreakQueue> dynamicTree = TreeCutter.findDynamicTree(brokenState.getBlock(), pos);
        if (dynamicTree.isPresent()) {
            dynamicTree.get()
                    .destroyBlocks(context.world, null, (stack, dropPos) -> dropItemFromCutTree(context, stack, dropPos));
            return;
        }

        TreeCutter.findTree(context.world, pos, brokenState)
                .destroyBlocks(context.world, null, (stack, dropPos) -> dropItemFromCutTree(context, stack, dropPos));
    }

    public void dropItemFromCutTree(MovementContext context, BlockPos pos, ItemStack stack) {
        ItemStack remainder = ItemHandlerHelper.insertItem(context.contraption.getStorage().getAllItems(), stack, false);
        if (remainder.isEmpty())
            return;

        // Drop remainder items
        Level world = context.world;
        Vec3 dropPos = VecHelper.getCenterOf(pos);
        float distance = context.position == null ? 1 : (float) dropPos.distanceTo(context.position);
        ItemEntity entity = new ItemEntity(world, dropPos.x, dropPos.y, dropPos.z, remainder);
        entity.setDeltaMovement(Vec3.ZERO);
        entity.setInvulnerable(true);
        entity.setNoGravity(true);
        world.addFreshEntity(entity);
    }

    @Override
    protected boolean shouldDestroyStartBlock(BlockState stateToBreak) {
        return !TreeCutter.canDynamicTreeCutFrom(stateToBreak.getBlock());
    }

    @Override
    protected DamageSource getDamageSource(Level level) {
        return CreateDamageSources.saw(level);
    }

    @Override
    protected float getBlockBreakingSpeed(MovementContext context) {
        float lowerLimit = 1 / 128f;
        if (context.contraption instanceof MountedContraption)
            lowerLimit = 1f;
        if (context.contraption instanceof CarriageContraption)
            lowerLimit = 2f;
        return Mth.clamp(Math.abs(context.getAnimationSpeed()) / 175f, lowerLimit, 16f);
    }
}

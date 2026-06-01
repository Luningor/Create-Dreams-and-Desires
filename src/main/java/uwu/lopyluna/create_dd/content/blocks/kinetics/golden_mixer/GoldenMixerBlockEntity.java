package uwu.lopyluna.create_dd.content.blocks.kinetics.golden_mixer;

import com.simibubi.create.AllRecipeTypes;
import com.simibubi.create.AllSoundEvents;
import com.simibubi.create.Create;
import com.simibubi.create.content.fluids.FluidFX;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.content.kinetics.press.MechanicalPressBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.content.processing.basin.BasinBlockEntity;
import com.simibubi.create.content.processing.basin.BasinOperatingBlockEntity;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.foundation.advancement.AllAdvancements;
import com.simibubi.create.foundation.advancement.CreateAdvancement;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.recipe.RecipeFinder;
import com.simibubi.create.foundation.recipe.trie.AbstractVariant;
import com.simibubi.create.foundation.recipe.trie.RecipeTrie;
import com.simibubi.create.foundation.recipe.trie.RecipeTrieFinder;
import com.simibubi.create.infrastructure.config.AllConfigs;
import net.createmod.catnip.animation.AnimationTickHolder;
import net.createmod.catnip.math.VecHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.item.crafting.CraftingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.crafting.IShapedRecipe;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.items.IItemHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class GoldenMixerBlockEntity extends BasinOperatingBlockEntity {
    private static final Object shapelessOrMixingRecipesKey = new Object();

    public int counter;
    public int runningTicks;
    public int processingTicks;
    public boolean running;

    public GoldenMixerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public float getRenderedHeadOffset(float partialTicks) {
        int localTick;
        var offset = 0f;
        if (running) {
            if (runningTicks < ticksHigh()) {
                localTick = runningTicks;
                var num = (localTick + partialTicks) / 20f;
                num = ((2 - Mth.cos((float) (num * Math.PI))) / 2);
                offset = num - .5f;
            } else if (runningTicks == ticksHigh()) {
                offset = 1;
            } else {
                localTick = ticksHigh() * 2 - runningTicks;
                var num = (localTick - partialTicks) / 20f;
                num = ((2 - Mth.cos((float) (num * Math.PI))) / 2);
                offset = num - .5f;
            }
        }
        return offset + 7 / 16f;
    }

    public float getRenderedHeadRotationSpeed() {
        var speed = getSpeed() * speedMultiplier();
        if (running) {
            if (runningTicks < 15) return speed;
            if (runningTicks <= ticksHigh()) return speed * 2;
            return speed;
        }
        return speed / 2;
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
        super.addBehaviours(behaviours);
        registerAwardables(behaviours, AllAdvancements.MIXER);
    }

    @Override
    protected AABB createRenderBoundingBox() {
        return new AABB(worldPosition).expandTowards(0, -1.5, 0);
    }

    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        running = compound.getBoolean("Running");
        runningTicks = compound.getInt("Ticks");
        super.read(compound, clientPacket);

        if (clientPacket && hasLevel())
            getBasin().ifPresent(bte -> bte.setAreFluidsMoving(running && runningTicks <= ticksHigh()));
    }

    protected void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        compound.putBoolean("Running", running);
        compound.putInt("Ticks", runningTicks);
        super.write(compound, clientPacket);
    }

    @Override
    public void tick() {
        super.tick();
        counter = ++counter % 3;

        if (runningTicks >= ticksHigh() * 2) {
            running = false;
            runningTicks = 0;
            basinChecker.scheduleUpdate();
            return;
        }
        var speedSpeed = getSpeed();
        var speed = Math.abs(speedSpeed * speedMultiplier());
        if (running && level != null) {
            if (level.isClientSide && runningTicks == ticksHigh()) renderParticles();
            if ((!level.isClientSide || isVirtual()) && runningTicks == ticksHigh()) {
                if (processingTicks < 0) {
                    var recipeSpeed = 1f;
                    if (currentRecipe instanceof ProcessingRecipe) {
                        int t = ((ProcessingRecipe<?>) currentRecipe).getProcessingDuration();
                        if (t != 0)
                            recipeSpeed = t / 100f;
                    }
                    processingTicks = Mth.clamp((Mth.log2((int) (512 / speed))) * Mth.ceil(recipeSpeed * 15) + 1, 1, 512);

                    var basin = getBasin();
                    if (basin.isPresent()) {
                        var tanks = basin.get().getTanks();
                        var soundChanceBound = Math.max(1, Mth.ceil(Math.abs(speedSpeed)));
                        if ((!tanks.getFirst().isEmpty() || !tanks.getSecond().isEmpty()) && level.random.nextInt(soundChanceBound) <= 32)
                            level.playSound(null, worldPosition, SoundEvents.BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, SoundSource.BLOCKS, .75f, speed < 65 ? .75f : 1.5f);
                    }
                } else {
                    processingTicks--;
                    if (processingTicks == 0) {
                        runningTicks++;
                        processingTicks = -1;
                        applyBasinRecipe();
                        sendData();
                    }
                }
            }
            if (runningTicks != ticksHigh()) runningTicks++;
        }
    }

    public void renderParticles() {
        var basin = getBasin();
        if (basin.isEmpty() || level == null) return;

        for (var inv : basin.get().getInvs()) for (int slot = 0; slot < inv.getSlots(); slot++) {
            var stackInSlot = inv.getItem(slot);
            if (stackInSlot.isEmpty()) continue;
            var data = new ItemParticleOption(ParticleTypes.ITEM, stackInSlot);
            spillParticle(level, data);
        }
        for (var behaviour : basin.get().getTanks()) {
            if (behaviour == null) continue;
            for (var tankSegment : behaviour.getTanks()) {
                if (tankSegment.isEmpty(0)) continue;
                spillParticle(level, FluidFX.getFluidParticle(tankSegment.getRenderedFluid()));
            }
        }
    }

    protected void spillParticle(Level level, ParticleOptions data) {
        var angle = level.random.nextFloat() * 360;
        var offset = new Vec3(0, 0, 0.25f);
        offset = VecHelper.rotate(offset, angle, Direction.Axis.Y);
        var target = VecHelper.rotate(offset, getSpeed() > 0 ? 25 : -25, Direction.Axis.Y).add(0, .25f, 0);
        var center = offset.add(VecHelper.getCenterOf(worldPosition));
        target = VecHelper.offsetRandomly(target.subtract(offset), level.random, 1 / 128f);
        level.addParticle(data, center.x, center.y - 1.75f, center.z, target.x, target.y, target.z);
    }

    @SuppressWarnings("all")
    @Override
    protected List<Recipe<?>> getMatchingRecipes() {
        Optional<BasinBlockEntity> $basin = getBasin();
        BasinBlockEntity basin;

        if ($basin.isEmpty() || (basin = $basin.get()).isEmpty())
            return new ArrayList<>();

        assert level != null;
        var matchingRecipes = super.getMatchingRecipes();
        if (!AllConfigs.server().recipes.allowBrewingInMixer.get()) return matchingRecipes;

        if (basin.isEmpty()) return matchingRecipes;
        var basinBlockEntity = basin;
        if (basin.isEmpty()) return matchingRecipes;

        try {
            IItemHandler availableItems = basin.getCapability(ForgeCapabilities.ITEM_HANDLER)
                    .orElse(null);
            IFluidHandler availableFluids = basin.getCapability(ForgeCapabilities.FLUID_HANDLER)
                    .orElse(null);

            // no point even searching, since no recipe will ever match
            if (availableItems == null && availableFluids == null) {
                return matchingRecipes;
            }

            RecipeTrie<?> trie = RecipeTrieFinder.get(getRecipeCacheKey(), level, this::matchStaticFilters);
            Set<AbstractVariant> availableVariants = RecipeTrie.getVariants(availableItems, availableFluids);

            for (Recipe<?> r : trie.lookup(availableVariants))
                if (matchBasinRecipe(r))
                    matchingRecipes.add(r);
        } catch (Exception e) {
            Create.LOGGER.error("Failed to get recipe trie, falling back to slow logic", e);
            matchingRecipes.clear();

            for (Recipe<?> r : RecipeFinder.get(getRecipeCacheKey(), level, this::matchStaticFilters))
                if (matchBasinRecipe(r))
                    matchingRecipes.add(r);
        }
        return matchingRecipes;
    }

    @Override
    public <C extends Container> boolean matchStaticFilters(Recipe<C> recipe) {
        return ((recipe instanceof CraftingRecipe && !(recipe instanceof IShapedRecipe<?>)
                && AllConfigs.server().recipes.allowShapelessInMixer.get() && recipe.getIngredients()
                .size() > 1
                && !MechanicalPressBlockEntity.canCompress(recipe)) && !AllRecipeTypes.shouldIgnoreInAutomation(recipe)
                || recipe.getType() == AllRecipeTypes.MIXING.getType());
    }

    @Override
    public void startProcessingBasin() {
        if (running && runningTicks <= ticksHigh()) return;
        super.startProcessingBasin();
        running = true;
        runningTicks = 0;
    }

    @Override
    public boolean continueWithPreviousRecipe() {
        runningTicks = ticksHigh();
        return true;
    }

    @Override
    protected void onBasinRemoved() {
        if (!running) return;
        runningTicks = ticksHigh() * 2;
        running = false;
    }

    public int ticksHigh() {
        return 20;
    }

    public float speedMultiplier() {
        return 2.5f;
    }

    @Override
    protected Object getRecipeCacheKey() {
        return shapelessOrMixingRecipesKey;
    }

    @Override
    protected boolean isRunning() {
        return running;
    }

    @Override
    protected Optional<CreateAdvancement> getProcessedRecipeTrigger() {
        return Optional.of(AllAdvancements.MIXER);
    }

    @Override
    @OnlyIn(value = Dist.CLIENT)
    public void tickAudio() {
        super.tickAudio();
        var slow = Math.abs(getSpeed() * speedMultiplier()) < 65;
        if (slow && AnimationTickHolder.getTicks() % 2 == 0) return;
        if (runningTicks == ticksHigh()) AllSoundEvents.MIXING.playAt(level, worldPosition, .75f, 1, true);
    }

    @Override
    protected boolean canPropagateDiagonally(IRotate block, BlockState state) {
        return state.getBlock() instanceof ICogWheel || block instanceof ICogWheel;
    }

    @Override
    public List<BlockPos> addPropagationLocations(IRotate block, BlockState state, List<BlockPos> neighbours) {
        for (var offset : BlockPos.betweenClosed(-1, -1, -1, 1, 1, 1)) if (offset.distSqr(BlockPos.ZERO) == 2) neighbours.add(worldPosition.offset(offset));
        return neighbours;
    }
}

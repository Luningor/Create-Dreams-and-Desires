package uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.simibubi.create.api.contraption.storage.SyncedMountedStorage;
import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.simibubi.create.api.contraption.storage.fluid.WrapperMountedFluidStorage;
import com.simibubi.create.content.contraptions.Contraption;
import com.simibubi.create.foundation.utility.CreateCodecs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.create_dd.registry.DesiresMountedStorageTypes;

public class FluidReservoirMountedStorage extends WrapperMountedFluidStorage<FluidReservoirMountedStorage.Handler> implements SyncedMountedStorage {

    public static final Codec<FluidReservoirMountedStorage> CODEC = RecordCodecBuilder.create(i -> i.group(
            net.minecraft.util.ExtraCodecs.NON_NEGATIVE_INT.fieldOf("capacity").forGetter(FluidReservoirMountedStorage::getCapacity),
            CreateCodecs.FLUID_STACK_CODEC.fieldOf("fluid").forGetter(FluidReservoirMountedStorage::getFluid)
    ).apply(i, FluidReservoirMountedStorage::new));

    private boolean dirty;

    protected FluidReservoirMountedStorage(MountedFluidStorageType<?> type, int capacity, FluidStack stack) {
        super(type, new Handler(capacity, stack));
        this.wrapped.onChange = () -> this.dirty = true;
    }

    protected FluidReservoirMountedStorage(int capacity, FluidStack stack) {
        this(DesiresMountedStorageTypes.FLUID_RESERVOIR.get(), capacity, stack);
    }

    @Override
    public void unmount(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity be) {
        if (be instanceof FluidReservoirBlockEntity reservoir && reservoir.isController()) {
            FluidTank inventory = (FluidTank) reservoir.getTankInventory();
            inventory.setFluid(this.wrapped.getFluid());
        }
    }

    public FluidStack getFluid() {
        return this.wrapped.getFluid();
    }

    public int getCapacity() {
        return this.wrapped.getCapacity();
    }

    @Override
    public boolean isDirty() {
        return this.dirty;
    }

    @Override
    public void markClean() {
        this.dirty = false;
    }

    @Override
    public void afterSync(Contraption contraption, BlockPos localPos) {
        BlockEntity be = contraption.getBlockEntityClientSide(localPos);
        if (!(be instanceof FluidReservoirBlockEntity reservoir))
            return;
        FluidTank inv = (FluidTank) reservoir.getTankInventory();
        inv.setFluid(this.getFluid());
    }

    public static FluidReservoirMountedStorage fromReservoir(FluidReservoirBlockEntity reservoir) {
        FluidTank inventory = (FluidTank) reservoir.getTankInventory();
        int capacity = reservoir.getTotalTankSize() * FluidReservoirBlockEntity.getCapacityMultiplier();
        return new FluidReservoirMountedStorage(inventory.getCapacity(), inventory.getFluid().copy());
    }

    public static final class Handler extends FluidTank {
        private Runnable onChange = () -> {};

        public Handler(int capacity, FluidStack stack) {
            super(capacity);
            this.setFluid(stack);
        }

        @Override
        protected void onContentsChanged() {
            this.onChange.run();
        }
    }
}
package uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir;

import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class FluidReservoirMountedStorageType extends MountedFluidStorageType<FluidReservoirMountedStorage> {

    public FluidReservoirMountedStorageType() {
        super(FluidReservoirMountedStorage.CODEC);
    }

    @Override
    @Nullable
    public FluidReservoirMountedStorage mount(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity be) {
        if (be instanceof FluidReservoirBlockEntity reservoir && reservoir.isController()) {
            return FluidReservoirMountedStorage.fromReservoir(reservoir);
        }
        return null;
    }
}
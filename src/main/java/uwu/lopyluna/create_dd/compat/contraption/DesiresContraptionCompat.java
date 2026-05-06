package uwu.lopyluna.create_dd.compat.contraption;

import com.simibubi.create.api.connectivity.ConnectivityHandler;
import com.simibubi.create.api.contraption.BlockMovementChecks;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirBlock;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileBlock;

public class DesiresContraptionCompat {

    public static void register() {
        BlockMovementChecks.registerAttachedCheck((state, world, pos, direction) -> {
            if (state.getBlock() instanceof FluidReservoirBlock || state.getBlock() instanceof ItemStockpileBlock)
                return BlockMovementChecks.CheckResult.of(
                        ConnectivityHandler.isConnected(world, pos, pos.relative(direction))
                );
            return BlockMovementChecks.CheckResult.PASS;
        });
    }
}
package uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile;

import com.simibubi.create.api.contraption.storage.item.MountedItemStorageType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ItemStockpileMountedStorageType extends MountedItemStorageType<ItemStockpileMountedStorage> {

    public ItemStockpileMountedStorageType() {
        super(ItemStockpileMountedStorage.CODEC);
    }

    @Override
    @Nullable
    public ItemStockpileMountedStorage mount(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity be) {
        if (be instanceof ItemStockpileBlockEntity stockpile) {
            return ItemStockpileMountedStorage.fromStockpile(stockpile);
        }
        return null;
    }
}
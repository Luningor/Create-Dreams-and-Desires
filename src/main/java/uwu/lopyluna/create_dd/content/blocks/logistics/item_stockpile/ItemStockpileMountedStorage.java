package uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile;

import com.mojang.serialization.Codec;
import com.simibubi.create.api.contraption.storage.item.MountedItemStorageType;
import com.simibubi.create.api.contraption.storage.item.WrapperMountedItemStorage;
import com.simibubi.create.foundation.utility.CreateCodecs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.create_dd.registry.DesiresMountedStorageTypes;

public class ItemStockpileMountedStorage extends WrapperMountedItemStorage<ItemStackHandler> {

    public static final Codec<ItemStockpileMountedStorage> CODEC = CreateCodecs.ITEM_STACK_HANDLER.xmap(
            ItemStockpileMountedStorage::new, storage -> storage.wrapped
    );

    protected ItemStockpileMountedStorage(MountedItemStorageType<?> type, ItemStackHandler handler) {
        super(type, handler);
    }

    protected ItemStockpileMountedStorage(ItemStackHandler handler) {
        this(DesiresMountedStorageTypes.ITEM_STOCKPILE.get(), handler);
    }

    @Override
    public void unmount(Level level, BlockState state, BlockPos pos, @Nullable BlockEntity be) {
        if (be instanceof ItemStockpileBlockEntity stockpile) {
            stockpile.applyInventoryToBlock(this.wrapped);
        }
    }

    public static ItemStockpileMountedStorage fromStockpile(ItemStockpileBlockEntity stockpile) {
        return new ItemStockpileMountedStorage(copyToItemStackHandler(stockpile.getInventoryOfBlock()));
    }
}
// 3. 注册 type，在你的注册类里
package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.simibubi.create.api.contraption.storage.item.MountedItemStorageType;
import com.simibubi.create.api.registry.CreateRegistries;
import net.minecraft.core.Registry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.content.blocks.logistics.fluid_reservoir.FluidReservoirMountedStorageType;
import uwu.lopyluna.create_dd.content.blocks.logistics.item_stockpile.ItemStockpileMountedStorageType;

public class DesiresMountedStorageTypes {
    public static final DeferredRegister<MountedItemStorageType<?>> REGISTER =
            DeferredRegister.create(CreateRegistries.MOUNTED_ITEM_STORAGE_TYPE, DesiresCreate.MOD_ID);

    public static final RegistryObject<ItemStockpileMountedStorageType> ITEM_STOCKPILE =
            REGISTER.register("item_stockpile", ItemStockpileMountedStorageType::new);

    public static final DeferredRegister<MountedFluidStorageType<?>> FLUID_REGISTER =
            DeferredRegister.create(CreateRegistries.MOUNTED_FLUID_STORAGE_TYPE, DesiresCreate.MOD_ID);

    public static final RegistryObject<FluidReservoirMountedStorageType> FLUID_RESERVOIR =
            FLUID_REGISTER.register("fluid_reservoir", FluidReservoirMountedStorageType::new);

    public static void register(IEventBus bus) {
        REGISTER.register(bus);
        FLUID_REGISTER.register(bus);
    }
}
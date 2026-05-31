package uwu.lopyluna.create_dd.content.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DesiresPlacementModifiers {
    private static final DeferredRegister<PlacementModifierType<?>> REGISTER = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, DesiresCreate.MOD_ID);

    public static final RegistryObject<PlacementModifierType<DesiresConfigPlacementFilter>> CONFIG_FILTER = REGISTER.register("config_filter", () -> () -> DesiresConfigPlacementFilter.CODEC);

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}

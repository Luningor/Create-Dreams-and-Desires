package uwu.lopyluna.create_dd.content.worldgen;

import com.simibubi.create.infrastructure.worldgen.LayeredOreFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.create_dd.DesiresCreate;

public class DesiresFeatures {
    private static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, DesiresCreate.MOD_ID);

    public static final RegistryObject<LayeredOreFeature> LAYERED_ORE = REGISTER.register("layered_ore", LayeredOreFeature::new);

    public static void register(IEventBus modEventBus) {
        REGISTER.register(modEventBus);
    }
}

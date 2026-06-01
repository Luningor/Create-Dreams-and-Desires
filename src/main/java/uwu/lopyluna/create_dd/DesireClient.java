package uwu.lopyluna.create_dd;

import net.createmod.ponder.foundation.PonderIndex;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import uwu.lopyluna.create_dd.infrastructure.ponder.DesiresPonderPlugin;
import uwu.lopyluna.create_dd.registry.DesiresParticleTypes;

public class DesireClient {



    public static void onCtorClient(IEventBus modEventBus, IEventBus forgeEventBus) {
        modEventBus.addListener(DesireClient::clientInit);;
        modEventBus.addListener(DesiresParticleTypes::registerFactories);
        modEventBus.addListener(DesireClient::setup);
    }


    public static void clientInit(final FMLClientSetupEvent event) {
    }

    public static void setup(final FMLClientSetupEvent event) {
        PonderIndex.addPlugin(new DesiresPonderPlugin());
    }
}

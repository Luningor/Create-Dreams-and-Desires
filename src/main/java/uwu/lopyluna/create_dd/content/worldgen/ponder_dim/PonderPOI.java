package uwu.lopyluna.create_dd.content.worldgen.ponder_dim;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;

public class PonderPOI {
    public static final DeferredRegister<PoiType> POI
            = DeferredRegister.create(ForgeRegistries.POI_TYPES, DesiresCreate.MOD_ID);

    public static final RegistryObject<PoiType> ponder_in_a_box =
            POI.register("ponder_in_a_box", () -> new PoiType(
                    ImmutableSet.copyOf(DesiresBlocks.PONDER_IN_A_BOX.get().getStateDefinition().getPossibleStates()),
                    0, 1));


    public static void register(IEventBus eventBus) {
        POI.register(eventBus);
    }
}

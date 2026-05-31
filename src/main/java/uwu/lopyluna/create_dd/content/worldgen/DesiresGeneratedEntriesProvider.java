package uwu.lopyluna.create_dd.content.worldgen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.DesiresCreate;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class DesiresGeneratedEntriesProvider extends DatapackBuiltinEntriesProvider {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, (RegistrySetBuilder.RegistryBootstrap) DesiresConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DesiresPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, DesiresBiomeModifiers::bootstrap);

    public DesiresGeneratedEntriesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DesiresCreate.MOD_ID));
    }

    @Override
    public @NotNull String getName() {
        return DesiresCreate.NAME + " Generated Registry Entries";
    }
}

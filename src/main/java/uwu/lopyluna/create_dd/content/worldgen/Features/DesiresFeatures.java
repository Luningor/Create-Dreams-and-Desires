package uwu.lopyluna.create_dd.content.worldgen.Features;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.PineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;

public class DesiresFeatures {


    public static class TreeConfiguredFeature {

        public static final ResourceKey<ConfiguredFeature<?, ?>> RUBBER_TREE = registerKey("rubber");

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
            register(context, RUBBER_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                    BlockStateProvider.simple(DesiresBlocks.RUBBER_LOG.get()),
                    new FancyTrunkPlacer(6, 12, 0),
                    BlockStateProvider.simple(DesiresBlocks.RUBBER_LEAVES.get()),
                    new PineFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), UniformInt.of(3, 3)),
                    new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
        }


        public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
            return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(DesiresCreate.MOD_ID, name));
        }

        private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                              ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
            context.register(key, new ConfiguredFeature<>(feature, configuration));
        }

    }

}

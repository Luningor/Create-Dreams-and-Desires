package uwu.lopyluna.create_dd.content.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import uwu.lopyluna.create_dd.infrastructure.config.DesiresConfigs;

public class DesiresConfigPlacementFilter extends PlacementFilter {
    public static final DesiresConfigPlacementFilter INSTANCE = new DesiresConfigPlacementFilter();
    public static final Codec<DesiresConfigPlacementFilter> CODEC = Codec.unit(() -> INSTANCE);

    @Override
    protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
        return !DesiresConfigs.common().worldGen.disable.get();
    }

    @Override
    public PlacementModifierType<?> type() {
        return DesiresPlacementModifiers.CONFIG_FILTER.get();
    }
}

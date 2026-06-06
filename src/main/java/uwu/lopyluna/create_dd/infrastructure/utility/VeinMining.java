package uwu.lopyluna.create_dd.infrastructure.utility;

import com.simibubi.create.foundation.utility.AbstractBlockBreakQueue;
import com.simibubi.create.foundation.utility.BlockHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@SuppressWarnings({"all"})
public class VeinMining {
    public static final Vein NO_VEIN = new Vein(Collections.emptyList());

    @Nonnull
    public static Vein findVein(@org.jetbrains.annotations.Nullable BlockGetter reader, BlockPos startPos, TagKey<Block> filterTag, int maxBlocks) {
        if (reader == null) return NO_VEIN;

        List<BlockPos> matchingBlocks = new ArrayList<>();
        Set<BlockPos> visited = new HashSet<>();
        Queue<BlockPos> frontier = new LinkedList<>();

        frontier.add(startPos);
        visited.add(startPos);

        while (!frontier.isEmpty() && matchingBlocks.size() < maxBlocks) {
            var currentPos = frontier.poll();
            if (currentPos == null) continue;

            var currentState = reader.getBlockState(currentPos);
            if (currentState.is(filterTag) && ((Level)reader).getWorldBorder().isWithinBounds(currentPos)) {
                matchingBlocks.add(currentPos);
                for (int dx = -1; dx <= 1; dx++) for (int dy = -1; dy <= 1; dy++) for (int dz = -1; dz <= 1; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) continue;
                    var adjacentPos = currentPos.offset(dx, dy, dz);
                    if (!visited.contains(adjacentPos)) {
                        var adjacentState = reader.getBlockState(adjacentPos);
                        if (adjacentState.is(filterTag)) {
                            visited.add(adjacentPos);
                            frontier.add(adjacentPos);
                        }
                    }
                }
            }
        }
        return new Vein(matchingBlocks);
    }

    public static class Vein extends AbstractBlockBreakQueue {
        private final List<BlockPos> ores;

        public Vein(List<BlockPos> ores) {
            this.ores = ores;
        }

        @Override
        public void destroyBlocks(Level world, ItemStack tool, @org.jetbrains.annotations.Nullable Player player, BiConsumer<BlockPos, ItemStack> dropConsumer) {
            if (player == null) return;
            ores.forEach(makeCallbackFor(world, 0.5f, tool, player, dropConsumer));
            player.causeFoodExhaustion(ores.size() * 0.5f);
        }

        @Override
        protected Consumer<BlockPos> makeCallbackFor(Level level, float effectChance, ItemStack toDamage, @Nullable Player player, BiConsumer<BlockPos, ItemStack> drop) {
            return pos -> {
                var usedTool = toDamage.copy();
                BlockHelper.destroyBlockAs(level, pos, player, toDamage, effectChance, stack -> drop.accept(pos, stack));

                if (player != null && toDamage.isEmpty() && !usedTool.isEmpty())
                    player.broadcastBreakEvent(player.getUsedItemHand());
            };
        }
    }
}
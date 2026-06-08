package uwu.lopyluna.create_dd.content.blocks.contraptions.bore_block;

import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementOffset;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class BoreBlockPlacementHelper implements IPlacementHelper {

    @Override
    public @NotNull Predicate<ItemStack> getItemPredicate() {
        return stack -> {
            Item item = stack.getItem();
            if (!(item instanceof BlockItem blockItem)) return false;
            Block block = blockItem.getBlock();
            return block instanceof BoreBlock;
        };
    }

    @Override
    public @NotNull Predicate<BlockState> getStatePredicate() {
        return state -> state.getBlock() instanceof BoreBlock;
    }

    @Override
    public @NotNull PlacementOffset getOffset(
            @NotNull Player player,
            @NotNull Level level,
            @NotNull BlockState state,
            @NotNull BlockPos pos,
            BlockHitResult ray
    ) {
        Direction face = ray.getDirection();

        if (face == null) return PlacementOffset.fail();

        Vec3 hit = ray.getLocation().subtract(pos.getX(), pos.getY(), pos.getZ());

        double u;
        double v;

        switch (face) {
            case NORTH, SOUTH -> {
                u = hit.x - 0.5;
                v = hit.y - 0.5;
            }
            case EAST, WEST -> {
                u = hit.z - 0.5;
                v = hit.y - 0.5;
            }
            case UP, DOWN -> {
                u = hit.x - 0.5;
                v = hit.z - 0.5;
            }
            default -> {
                return PlacementOffset.fail();
            }
        }

        double deadzone = 0.20;
        Direction resultFace;

        if (Math.abs(u) < deadzone && Math.abs(v) < deadzone)
            resultFace = face;

        else {
            resultFace = getDirection(u, v, face);
            if (resultFace == null) resultFace = face;
        }

        BlockPos target = pos.relative(resultFace);

        if (!level.getBlockState(target).canBeReplaced()) return PlacementOffset.fail();
        return PlacementOffset.success(target);
    }

    private static Direction getDirection(double u, double v, Direction face) {

        boolean horizontal = Math.abs(u) > Math.abs(v);

        if (horizontal) {
            return switch (face) {
                case NORTH, UP, DOWN -> u > 0 ? Direction.EAST : Direction.WEST;
                case SOUTH -> u > 0 ? Direction.WEST : Direction.EAST;
                case EAST  -> u > 0 ? Direction.SOUTH : Direction.NORTH;
                case WEST  -> u > 0 ? Direction.NORTH : Direction.SOUTH;

            };
        }
        else
            return switch (face) {
                case NORTH, SOUTH, WEST, EAST -> v > 0 ? Direction.UP : Direction.DOWN;
                case UP -> v > 0 ? Direction.SOUTH : Direction.NORTH;
                case DOWN -> v > 0 ? Direction.NORTH : Direction.SOUTH;
            };
    }
}

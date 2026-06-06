package uwu.lopyluna.create_dd.infrastructure.utility;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.HitResult;

import java.util.ArrayList;
import java.util.List;

public class BoreMining {
    public static VeinMining.Vein findBore(int range, BlockPos initalBlockPos, ServerPlayer player) {
        List<BlockPos> positions = new ArrayList<>();
        var level = player.level();
        var traceResult = level.clip(new ClipContext(player.getEyePosition(1f),
                (player.getEyePosition(1f).add(player.getViewVector(1f).scale(6f))),
                ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));
        if (traceResult.getType() == HitResult.Type.MISS) return VeinMining.NO_VEIN;
        var axis = traceResult.getDirection().getAxis();
        for(int x = -range; x <= range; x++) for(int y = -range; y <= range; y++) {
            var pos = expandPos(x, y, axis, initalBlockPos);
            if (level.getWorldBorder().isWithinBounds(pos)) positions.add(pos);
        }
        return new VeinMining.Vein(positions.stream().filter(pos -> {
            if (pos == initalBlockPos || !level.isLoaded(pos)) return false;
            var state = level.getBlockState(pos);
            return !state.isAir() && state.getDestroySpeed(level, pos) != -1;
        }).toList());
    }

    public static BlockPos expandPos(int x, int y, Direction.Axis axis, BlockPos initalBlockPos) {
        return switch (axis) {
            case X -> new BlockPos(initalBlockPos.getX(), initalBlockPos.getY() + y, initalBlockPos.getZ() + x);
            case Y -> new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY(), initalBlockPos.getZ() + y);
            case Z -> new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ());
        };
    }
}
package uwu.lopyluna.create_dd.content.blocks.kinetics.giant_gear;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank.CogCrankBlock;
import uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank.CogCrankRenderer;

public class GiantGearBlockEntity extends KineticBlockEntity {
    public GiantGearBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
        super(typeIn, pos, state);
    }

    public float getRotationAngle(float pt) {
        return GiantGearBlockRenderer.getAngleForBe(this, worldPosition, getBlockState().getValue(GiantGearBlock.AXIS));
    }
}

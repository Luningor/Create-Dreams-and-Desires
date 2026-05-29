package uwu.lopyluna.create_dd.content.blocks.wood;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;
import uwu.lopyluna.create_dd.registry.DesiresBlocks;

public class NormalLogRotatedBlockPillar extends RotatedPillarBlock {
    public NormalLogRotatedBlockPillar(Properties pProperties) {
        super(pProperties);
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem) {
            if(state.is(DesiresBlocks.SPIRIT_LOG.get())) {
                return DesiresBlocks.STRIPPED_SPIRIT_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(DesiresBlocks.SPIRIT_WOOD.get())) {
                return DesiresBlocks.STRIPPED_SPIRIT_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(DesiresBlocks.RUBBER_LOG.get())) {
                return DesiresBlocks.STRIPPED_RUBBER_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if(state.is(DesiresBlocks.RUBBER_WOOD.get())) {
                return DesiresBlocks.STRIPPED_RUBBER_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

}

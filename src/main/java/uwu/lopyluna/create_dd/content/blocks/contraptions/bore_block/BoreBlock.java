package uwu.lopyluna.create_dd.content.blocks.contraptions.bore_block;

import net.createmod.catnip.placement.IPlacementHelper;
import net.createmod.catnip.placement.PlacementHelpers;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
@SuppressWarnings("deprecation")
public class BoreBlock extends Block {
    public static final int BORE_PLACEMENT_HELPER = PlacementHelpers.register(new BoreBlockPlacementHelper());

    public BoreBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        IPlacementHelper helper = PlacementHelpers.get(BORE_PLACEMENT_HELPER);
        ItemStack stack = player.getItemInHand(hand);

        // Not a blockItem OR this block's item
        if (!(stack.getItem() instanceof BlockItem blockItem) || !(blockItem.getBlock() instanceof BoreBlock))
            return InteractionResult.PASS;

        return helper.getOffset(player, level, state, pos, hit)
                .placeInWorld(level, blockItem, player, hand, hit);
    }
}

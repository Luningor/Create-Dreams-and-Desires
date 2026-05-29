package uwu.lopyluna.create_dd.content.blocks.wood;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings({"unused", "deprecation"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class HazardBlock extends Block implements IWrenchable {

    private final boolean visible;

    public static HazardBlock deprecated(Properties properties) {
        return new HazardBlock(properties, false);
    }

    public HazardBlock(Properties properties) {
        this(properties, true);
    }

    public HazardBlock(Properties properties, boolean visible) {
        super(properties);
        this.visible = visible;
    }


    @Override
    public InteractionResult onWrenched(BlockState state, UseOnContext context) {
        return InteractionResult.FAIL;
    }

    @NotNull
    public  PushReaction getPistonPushReaction(BlockState pState) {
        return PushReaction.PUSH_ONLY;
    }
}

package uwu.lopyluna.create_dd.content.blocks.functional;

import com.simibubi.create.content.equipment.wrench.IWrenchable;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import javax.annotation.ParametersAreNonnullByDefault;

@SuppressWarnings({"deprecation"})
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class SpectralRubyLampBlock extends Block implements IWrenchable {

    public static final IntegerProperty POWER = BlockStateProperties.POWER;
    public static final BooleanProperty INVERTED = BlockStateProperties.INVERTED;

    public SpectralRubyLampBlock(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(POWER, 0)
                .setValue(INVERTED, Boolean.FALSE));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState();
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    @Override
    public int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return pState.getValue(POWER);
    }

    public static void updateSignalStrength(BlockState state, Level level, BlockPos pos) {
        boolean inverted = state.getValue(INVERTED);
        long time = level.getDayTime() % 24000;

        boolean day = time < 12000;

        int calcPower = 0;
        time %= 12000;

        if (time <= 6000)
            calcPower = Mth.ceil(time / 400.0);
        else
            calcPower = Mth.ceil((12000 - time) / 400.0);

        int power;

        if (inverted)
            power = day ? 0 : calcPower;
        else
            power = day ? calcPower : 0;

        power = Mth.clamp(power, 0, 15);

        if (state.getValue(POWER) != power)
            level.setBlock(pos, state.setValue(POWER, power), 3);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!player.mayBuild())
            return super.use(state, level, pos, player, hand, hit);

        if (level.isClientSide)
            return InteractionResult.SUCCESS;

        BlockState newState = state.cycle(INVERTED);
        level.setBlock(pos, newState, 3);
        level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, newState));

        updateSignalStrength(newState, level, pos);
        return InteractionResult.CONSUME;
    }

    @Override
    public boolean isSignalSource(BlockState pState) {
        return true;
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        updateSignalStrength(state, level, pos);

        int delay = 20 - (int)(level.getGameTime() % 20);
        level.scheduleTick(pos, this, delay);
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);

        if (!level.isClientSide) {
            ServerLevel serverLevel = (ServerLevel) level;
            long delay = 20 - (serverLevel.getGameTime() % 20);
            serverLevel.scheduleTick(pos, this, (int) delay);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(POWER, INVERTED);
    }
}

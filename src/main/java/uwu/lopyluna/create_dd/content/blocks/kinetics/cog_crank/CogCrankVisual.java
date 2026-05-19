package uwu.lopyluna.create_dd.content.blocks.kinetics.cog_crank;

import java.util.function.Consumer;

import org.joml.Quaternionf;

import com.simibubi.create.content.kinetics.base.KineticBlockEntityVisual;

import dev.engine_room.flywheel.api.instance.Instance;
import dev.engine_room.flywheel.api.visual.DynamicVisual;
import dev.engine_room.flywheel.api.visualization.VisualizationContext;
import dev.engine_room.flywheel.lib.instance.InstanceTypes;
import dev.engine_room.flywheel.lib.instance.TransformedInstance;
import dev.engine_room.flywheel.lib.model.Models;
import dev.engine_room.flywheel.lib.visual.SimpleDynamicVisual;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import uwu.lopyluna.create_dd.registry.DesiresPartialModels;

public class CogCrankVisual extends KineticBlockEntityVisual<CogCrankBlockEntity> implements SimpleDynamicVisual {
    private final TransformedInstance cog;
    private final TransformedInstance crank;

    public CogCrankVisual(VisualizationContext context, CogCrankBlockEntity blockEntity, float partialTick) {
        super(context, blockEntity, partialTick);

        cog = instancerProvider().instancer(InstanceTypes.TRANSFORMED, Models.partial(DesiresPartialModels.COG_CRANK_COG))
                .createInstance();

        crank = instancerProvider().instancer(InstanceTypes.TRANSFORMED, Models.partial(DesiresPartialModels.COG_CRANK_HANDLE))
                .createInstance();

        rotateCrank(partialTick);
    }

    @Override
    public void beginFrame(DynamicVisual.Context ctx) {
        rotateCrank(ctx.partialTick());
    }

    private void rotateCrank(float pt) {
        Direction facing = blockState.getValue(BlockStateProperties.FACING);
        float angle = blockEntity.getIndependentAngle(pt);
        float networkAngle = blockEntity.getRotationAngle(pt);

        crank.setIdentityTransform()
                .translate(getVisualPosition())
                .center()
                .rotate(angle, Direction.get(Direction.AxisDirection.POSITIVE, facing.getAxis()))
                .rotate(new Quaternionf().rotateTo(0, 0, -1, facing.getStepX(), facing.getStepY(), facing.getStepZ()))
                .uncenter()
                .setChanged();

        cog.setIdentityTransform()
                .translate(getVisualPosition())
                .center()
                .rotate(networkAngle, Direction.get(Direction.AxisDirection.POSITIVE, facing.getAxis()))
                .rotate(new Quaternionf().rotateTo(0, 0, -1, facing.getStepX(), facing.getStepY(), facing.getStepZ()))
                .uncenter()
                .setChanged();
    }

    @Override
    protected void _delete() {
        crank.delete();
        cog.delete();
    }

    @Override
    public void update(float pt) {
    }

    @Override
    public void updateLight(float partialTick) {
        relight(crank);
        relight(cog);
    }

    @Override
    public void collectCrumblingInstances(Consumer<Instance> consumer) {
        consumer.accept(crank);
        consumer.accept(cog);
    }
}
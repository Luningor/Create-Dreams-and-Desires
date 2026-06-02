package uwu.lopyluna.create_dd.content.blocks.logistics.smart_hopper;

import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.content.blocks.logistics.special.DirtyInventory;

public class HopperInventory extends DirtyInventory<SmartHopperBlockEntity> {
    SmartHopperBlockEntity be;

    public HopperInventory(int slots, SmartHopperBlockEntity be) {
        super(slots, be, 64, true);
        this.be = be;
    }

    @Override
    public void setChanged() {
        var state = be.getBlockState();
        var flag = state.hasProperty(SmartHopperBlock.POWERED) && !state.getValue(SmartHopperBlock.POWERED);
        extractionAllowed = flag;
        insertionAllowed = flag;
    }

    @Override
    public boolean isItemValid(int slot, @NotNull ItemStack stack) {
        if (be.filtering.test(stack)) return super.isItemValid(slot, stack);
        return false;
    }

    @Override
    public void setItem(int slot, @NotNull ItemStack stack) {
        stacks.set(slot, stack);
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int count) {
        return ContainerHelper.removeItem(stacks, slot, count);
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return Container.stillValidBlockEntity(be, player);
    }
}

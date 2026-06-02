package uwu.lopyluna.create_dd.content.blocks.kinetics.spud_sentry;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;

@SuppressWarnings("NullableProblems")
public class SentryItemHandler extends ItemStackHandler {
    public SpudSentryBlockEntity be;
    @Nullable public ServerLevel level;
    public SentryItemHandler(SpudSentryBlockEntity be) {
        super(1);
        this.be = be;
    }

    public boolean set(ItemStack stack) {
        if (level == null) return false;
        if (stack.isEmpty()) return false;
        if (!be.inputInv.isItemValid(0, stack)) return false;
        setStackInSlot(0, stack);
        return true;
    }

    public void set(ItemStack stack, Runnable action) {
        if (set(stack)) action.run();
    }

    public void insert(ItemStack stack) {
        var input = getStackInSlot(0);
        if (input.isEmpty()) set(stack.copy(), () -> stack.setCount(0));
        else if (ItemStack.isSameItem(input, stack)) {
            int insert = stack.getCount();
            int left = input.getMaxStackSize() - input.getCount();
            int add = Math.min(left, insert);
            if (left > 0) {
                input.grow(add);
                stack.shrink(add);
            }
        }
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        if (level == null) return false;
        return be.canInsert(level, stack);
    }

    @Override
    protected void onContentsChanged(int slot) {
        super.onContentsChanged(slot);
        be.notifyUpdate();
    }
}

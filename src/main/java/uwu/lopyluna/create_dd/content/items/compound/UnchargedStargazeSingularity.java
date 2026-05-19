package uwu.lopyluna.create_dd.content.items.compound;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import uwu.lopyluna.create_dd.infrastructure.config.*;
import uwu.lopyluna.create_dd.registry.DesiresItems;

public class UnchargedStargazeSingularity extends Item {
    public UnchargedStargazeSingularity(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean onEntityItemUpdate(ItemStack stack, ItemEntity entity) {
        Level world = entity.level();


        double y = entity.getY();
        int maxHeight = world.getMaxBuildHeight();
        CompoundTag data = entity.getPersistentData();
        float gameTime = world.dayTime() % 24000;
        boolean maxTime = gameTime < DesiresConfigs.server().recipes.stargaze_singularity_max_time.get();
        boolean minTime = gameTime > DesiresConfigs.server().recipes.stargaze_singularity_min_time.get();
        boolean nightTime = maxTime && minTime;

        if (y > (maxHeight / DesiresConfigs.server().recipes.stargaze_singularity_max_height_division.get()) && nightTime && DesiresConfigs.server().recipes.stargaze_singularity_recipe.get()) {
            ItemStack newStack = DesiresItems.STARGAZE_SINGULARITY.asStack();
            newStack.setCount(stack.getCount());
            data.putBoolean("JustCreated", true);
            entity.setItem(newStack);
        }


        return false;
    }
}

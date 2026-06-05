package uwu.lopyluna.create_dd.content.data_recipes;

import static com.simibubi.create.foundation.data.recipe.CommonMetal.ALUMINUM;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.LEAD;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.NICKEL;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.OSMIUM;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.PLATINUM;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.QUICKSILVER;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.SILVER;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.TIN;
import static com.simibubi.create.foundation.data.recipe.CommonMetal.URANIUM;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider;
import com.simibubi.create.foundation.data.recipe.CommonMetal;
import com.simibubi.create.foundation.data.recipe.Mods;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.registry.DesiresItems;
import uwu.lopyluna.create_dd.registry.DesiresRecipeTypes;

import java.util.function.Supplier;

import static com.simibubi.create.api.data.recipe.BaseRecipeProvider.GeneratedRecipe;

@SuppressWarnings({"unused", "deprecation", "all"})
public class DragonBreathingRecipeGen extends DesireProcessingRecipeGen {

    public GeneratedRecipe convert(Block block, Block result) {
        return create(() -> block, b -> b.output(result));
    }

    public GeneratedRecipe convert(Item item, Item result) {
        return create(() -> item, b -> b.output(result));
    }

    public GeneratedRecipe convert(Supplier<ItemLike> item, Supplier<ItemLike> result) {
        return create(item, b -> b.output((ItemLike) result));
    }

    public GeneratedRecipe convert(ItemEntry<Item> item, ItemEntry<Item> result) {
        return create(item::get, b -> b.output(result::get));
    }

    public GeneratedRecipe secondaryRecipe(Supplier<ItemLike> item, Supplier<ItemLike> first, Supplier<ItemLike> secondary,
                                           float secondaryChance) {
        return create(item, b -> b.output(first.get(), 1)
                .output(secondaryChance, secondary.get(), 1));
    }

    public DragonBreathingRecipeGen(PackOutput dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected DesiresRecipeTypes getRecipeType() {
        return DesiresRecipeTypes.DRAGON_BREATHING;
    }

}

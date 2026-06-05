package uwu.lopyluna.create_dd.content.data_recipes;

import com.simibubi.create.AllItems;
import com.simibubi.create.api.data.recipe.BaseRecipeProvider;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.content.processing.recipe.HeatCondition;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.material.Fluids;
import uwu.lopyluna.create_dd.registry.DesiresFluids;
import uwu.lopyluna.create_dd.registry.DesiresPaletteStoneTypes;

import static uwu.lopyluna.create_dd.DesiresCreate.MOD_ID;

@SuppressWarnings("unused")
public final class HydraulicRecipeGen extends HydraulicCompactingRecipeGen {

    BaseRecipeProvider.GeneratedRecipe TUFF = create("tuff", b -> b
            .requiresHeat(HeatCondition.SUPERHEATED)
            .require(Items.GRAVEL)
            .require(Fluids.LAVA, 500)
            .require(Items.DEEPSLATE)
            .require(Items.ANDESITE)
            .output(Items.TUFF, 4)
    );
    BaseRecipeProvider.GeneratedRecipe CALCITE = create("calcite", b -> b
            .requiresHeat(HeatCondition.HEATED)
            .require(Items.BONE_BLOCK)
            .require(Items.DIORITE)
            .output(Items.CALCITE, 2)
    );
    BaseRecipeProvider.GeneratedRecipe NETHERRACK = create("netherrack", b -> b
            .requiresHeat(HeatCondition.HEATED)
            .require(AllItems.CINDER_FLOUR)
            .require(AllItems.CINDER_FLOUR)
            .require(DesiresPaletteStoneTypes.BRECCIA.baseBlock.get())
            .require(DesiresPaletteStoneTypes.BRECCIA.baseBlock.get())
            .output(Items.NETHERRACK, 4)
    );
    BaseRecipeProvider.GeneratedRecipe COBBLE_GEN = create("cobblestone_gen", b -> b
            .require(Fluids.LAVA, 100)
            .require(Fluids.WATER, 500)
            .output(Items.COBBLESTONE, 10)
    );
    BaseRecipeProvider.GeneratedRecipe STONE_GEN = create("stone_gen", b -> b
            .requiresHeat(HeatCondition.HEATED)
            .require(Fluids.LAVA, 100)
            .require(Fluids.WATER, 500)
            .output(Items.STONE, 10)
    );
    BaseRecipeProvider.GeneratedRecipe BASALT_GEN = create("basalt_gen", b -> b
            .requiresHeat(HeatCondition.HEATED)
            .require(Fluids.LAVA, 100)
            .require(Items.BLUE_ICE)
            .require(Items.SOUL_SOIL)
            .output(Items.BASALT, 10)
            .output(Items.BLUE_ICE, 1)
            .output(Items.SOUL_SOIL, 1)
    );
    BaseRecipeProvider.GeneratedRecipe VERIDIUM_GEN = create("veridium_gen", b -> b
            .requiresHeat(HeatCondition.SUPERHEATED)
            .require(Fluids.LAVA, 500)
            .require(DesiresFluids.CHOCOLATE_MILKSHAKE.get(), 100)
            .require(Items.GRANITE)
            .require(Items.GRANITE)
            .output(AllPaletteStoneTypes.VERIDIUM.getBaseBlock().get(), 2)
    );
    BaseRecipeProvider.GeneratedRecipe ASURINE_GEN = create("asurine_gen", b -> b
            .requiresHeat(HeatCondition.SUPERHEATED)
            .require(Fluids.LAVA, 500)
            .require(DesiresFluids.VANILLA_MILKSHAKE.get(), 100)
            .require(Items.SANDSTONE)
            .require(Items.SANDSTONE)
            .output(AllPaletteStoneTypes.ASURINE.getBaseBlock().get(), 2)
    );
    BaseRecipeProvider.GeneratedRecipe CRIMSITE_GEN = create("crimsite_gen", b -> b
            .requiresHeat(HeatCondition.SUPERHEATED)
            .require(Fluids.LAVA, 500)
            .require(DesiresFluids.STRAWBERRY_MILKSHAKE.get(), 100)
            .require(Items.COBBLED_DEEPSLATE)
            .require(Items.COBBLED_DEEPSLATE)
            .output(AllPaletteStoneTypes.CRIMSITE.getBaseBlock().get(), 2)
    );
    BaseRecipeProvider.GeneratedRecipe OCHRUM_GEN = create("ochrum_gen", b -> b
            .requiresHeat(HeatCondition.SUPERHEATED)
            .require(Fluids.LAVA, 500)
            .require(DesiresFluids.GLOWBERRY_MILKSHAKE.get(), 100)
            .require(Items.TERRACOTTA)
            .require(Items.TERRACOTTA)
            .output(AllPaletteStoneTypes.OCHRUM.getBaseBlock().get(), 2)
    );
    /*BaseRecipeProvider.GeneratedRecipe BRECCIA_GEN = create("breccia_gen", b -> b
            .requiresHeat(HeatCondition.SUPERHEATED)
            .require(Fluids.LAVA, 500)
            .require(DesiresFluids.PUMPKIN_MILKSHAKE.get(), 100)
            .require(AllPaletteStoneTypes.SCORCHIA.getBaseBlock().get())
            .require(AllPaletteStoneTypes.SCORCHIA.getBaseBlock().get())
            .output(DesiresStoneTypes.BRECCIA.getBaseBlock().get(), 4)
    );*/

    public HydraulicRecipeGen(PackOutput output) {
        super(output, MOD_ID);
    }

    public static Ingredient items(ItemLike... items) {
        return Ingredient.of(items);
    }
}

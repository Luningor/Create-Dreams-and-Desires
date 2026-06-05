package uwu.lopyluna.create_dd.content.recipes;

import com.simibubi.create.content.processing.basin.BasinRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import uwu.lopyluna.create_dd.registry.DesiresRecipeTypes;

public class HydraulicRecipe extends BasinRecipe {
    public HydraulicRecipe(ProcessingRecipeBuilder.ProcessingRecipeParams params) {
        super(DesiresRecipeTypes.HYDRAULIC_COMPACTING, params);
    }
}

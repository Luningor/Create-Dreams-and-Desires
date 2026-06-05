package uwu.lopyluna.create_dd.content.data_recipes;

import com.simibubi.create.api.data.recipe.ProcessingRecipeGen;
import net.minecraft.data.PackOutput;
import uwu.lopyluna.create_dd.registry.DesiresRecipeTypes;

public class HydraulicCompactingRecipeGen extends ProcessingRecipeGen {

    public HydraulicCompactingRecipeGen(PackOutput output, String defaultNamespace) {
        super(output, defaultNamespace);
    }

    @Override
    protected DesiresRecipeTypes getRecipeType() {
        return DesiresRecipeTypes.HYDRAULIC_COMPACTING;
    }

}

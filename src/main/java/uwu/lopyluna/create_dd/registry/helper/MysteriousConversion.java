package uwu.lopyluna.create_dd.registry.helper;

import com.simibubi.create.compat.jei.ConversionRecipe;
import com.simibubi.create.compat.jei.category.MysteriousItemConversionCategory;
import com.simibubi.create.foundation.gui.AllGuiTextures;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraftforge.fml.ModList;
import uwu.lopyluna.create_dd.infrastructure.config.DesiresConfigs;
import uwu.lopyluna.create_dd.registry.DesiresItems;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;

@ParametersAreNonnullByDefault
public class MysteriousConversion extends MysteriousItemConversionCategory {

    public static final List<ConversionRecipe> RECIPES = new ArrayList<>();

    static {
        if (DesiresConfigs.server().recipes.shadow_steel_recipe.get()) {
            RECIPES.add(ConversionRecipe.create(DesiresItems.CHROMATIC_COMPOUND.asStack(), DesiresItems.SHADOW_STEEL.asStack()));}

        if (DesiresConfigs.server().recipes.refined_radiance_recipe.get()) {
            RECIPES.add(ConversionRecipe.create(DesiresItems.CHROMATIC_COMPOUND.asStack(), DesiresItems.REFINED_RADIANCE.asStack()));}

        if (ModList.get().isLoaded("createaDesiresition")) {
            RECIPES.add(ConversionRecipe.create(DesiresItems.CHROMATIC_COMPOUND.asStack(), DesiresItems.OVERCHARGE_ALLOY.asStack()));}

        if (DesiresConfigs.server().recipes.blaze_gold_recipe.get()) {
            RECIPES.add(ConversionRecipe.create(DesiresItems.CHROMATIC_COMPOUND.asStack(), DesiresItems.BLAZE_GOLD.asStack()));}

        if (DesiresConfigs.server().recipes.stargaze_singularity_recipe.get()) {
            RECIPES.add(ConversionRecipe.create(DesiresItems.FALLEN_STARGAZE_SINGULARITY.asStack(), DesiresItems.STARGAZE_SINGULARITY.asStack()));}


    }

    public MysteriousConversion(Info<ConversionRecipe> info) {
        super(info);
    }
}

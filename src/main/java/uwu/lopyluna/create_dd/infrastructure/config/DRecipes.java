package uwu.lopyluna.create_dd.infrastructure.config;

import net.createmod.catnip.config.ConfigBase;
import org.jetbrains.annotations.NotNull;

public class DRecipes extends ConfigBase {
    int maxHeight = 2048;
    int minHeight = -2048;

	public final ConfigBool hydraulicBulkPressing = b(true, "hydraulicBulkPressing", Comments.hydraulicBulkPressing);
	public final ConfigInt hydraulicLavaDrainPressing = i(250, 1, 1000, "hydraulicLavaDrainPressing", Comments.hydraulicLavaDrainPressing);
	public final ConfigInt hydraulicFluidDrainPressing = i(1000, 1, 1000, "hydraulicFluidDrainPressing", Comments.hydraulicFluidDrainPressing);

    /*public final ConfigGroup compound_recipe = group(1, "recipe", DRecipes.Comments.compound_recipe);*/

    public final ConfigBool blaze_gold_recipe = b(true, "blaze_gold_recipe",
            DRecipes.Comments.blaze_gold_recipe);

    public final ConfigBool refined_radiance_recipe = b(true, "refined_radiance_recipe",
            DRecipes.Comments.refined_radiance_recipe);
    public final ConfigInt refined_radiance_max_height = i(319, minHeight, maxHeight, "refined_radiance_max_height",
            DRecipes.Comments.refined_radiance_max);
    public final ConfigInt refined_radiance_min_height = i(-32, minHeight, maxHeight, "refined_radiance_min_height",
            DRecipes.Comments.refined_radiance_min);
    public final ConfigInt refined_radiance_light_level = i(15, 0, 15, "refined_radiance_light_level",
            DRecipes.Comments.refined_radiance_light_level);

    public final ConfigBool shadow_steel_recipe = b(true, "shadow_steel_recipe",
            DRecipes.Comments.shadow_steel_recipe);
    public final ConfigInt shadow_steel_min_height = i(-10, minHeight, maxHeight, "shadow_steel_min_height",
            DRecipes.Comments.shadow_steel_min);
    public final ConfigBool stargaze_singularity_recipe = b(true, "stargaze_singularity_recipe",
            DRecipes.Comments.stargaze_singularity_recipe);
    public final ConfigInt stargaze_singularity_min_time = i(16000, 0, 24000, "stargaze_singularity_min_time",
            DRecipes.Comments.stargaze_singularity_min_time);
    public final ConfigInt stargaze_singularity_max_time = i(20000, 0, 24000, "stargaze_singularity_max_time",
            DRecipes.Comments.stargaze_singularity_max_time);
    public final ConfigFloat stargaze_singularity_max_height_division = f(1.25f, -256.0f, 256.0f, "stargaze_singularity_max_height_division",
            DRecipes.Comments.stargaze_singularity_max_height_division);


    //public final ConfigBool lumberBulkCutting = b(true, "lumberBulkCutting", Comments.lumberBulkCutting);
	//public final ConfigBool allowShapedSquareInHyPress = b(false, "allowShapedSquareInHyPress", Comments.allowShapedSquareInHyPress);
	//public final ConfigBool allowStonecuttingOnLumberSaw = b(false, "allowStonecuttingOnLumberSaw", Comments.allowStonecuttingOnLumberSaw);
	//public final ConfigBool allowWoodcuttingOnLumberSaw = b(true, "allowWoodcuttingOnLumberSaw", Comments.allowWoodcuttingOnLumberSaw);
	//public final ConfigBool displayLogStrippingRecipes = b(true, "displayLogStrippingRecipes", Comments.displayLogStrippingRecipes);

	@Override
	public @NotNull String getName() {
		return "recipes";
	}

	private static class Comments {
		static String hydraulicBulkPressing = "Allow the Hydraulic Press to process entire stacks at a time.";
		static String hydraulicLavaDrainPressing = "Value Hydraulic Press to drain amount of lava of each bonk.";
		static String hydraulicFluidDrainPressing = "Value Hydraulic Press to drain amount of fluid of each bonk.";

        /*static String compound_recipe = "Compound Recipes";*/
        static String blaze_gold_recipe = "Blaze Brass Recipe";
        static String refined_radiance_recipe = "Refined Radiance Recipe";
        static String refined_radiance_max = "Shadow Steel Recipe Require Max Height";
        static String refined_radiance_min = "Shadow Steel Recipe Require Min Height";
        static String refined_radiance_light_level = "Shadow Steel Recipe Require Light Level";
        static String shadow_steel_recipe = "Shadow Steel Recipe";
        static String shadow_steel_min = "Shadow Steel Recipe Require Min Height";
        static String stargaze_singularity_recipe = "Stargaze Recipe";
        static String stargaze_singularity_min_time = "Stargaze Recipe Require Min Time";
        static String stargaze_singularity_max_time = "Stargaze Recipe Require Max Time";
        static String stargaze_singularity_max_height_division = "Stargaze Recipe Require Min of Max Height Division";

        static String lumberBulkCutting = "Allow the Lumber Saw to process entire stacks at a time.";
		static String allowShapedSquareInHyPress =
			"Allow any single-ingredient 2x2 or 3x3 crafting recipes to be processed by a Mechanical Press + Basin.'This will not be Bulk'";
		static String allowStonecuttingOnLumberSaw =
			"Allow any stonecutting recipes to be processed by a Lumber Saw.";
		static String allowWoodcuttingOnLumberSaw =
			"Allow any Druidcraft woodcutter recipes to be processed by a Lumber Saw.";
		static String displayLogStrippingRecipes = "Display vanilla Log-stripping interactions in JEI.";
	}

}

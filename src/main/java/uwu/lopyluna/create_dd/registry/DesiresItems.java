package uwu.lopyluna.create_dd.registry;

import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.processing.sequenced.SequencedAssemblyItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.item.CombustibleItem;
import com.tterrag.registrate.util.DataIngredient;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import uwu.lopyluna.create_dd.DesiresCreate;
import uwu.lopyluna.create_dd.content.items.compound.*;
import uwu.lopyluna.create_dd.content.items.equipment.NameableRecordItem;
import uwu.lopyluna.create_dd.content.items.equipment.deforester_saw.DeforesterSawItem;
import uwu.lopyluna.create_dd.content.items.equipment.deforester_saw.ForestRavagerItem;
import uwu.lopyluna.create_dd.content.items.equipment.excavation_drill.ExcavationDrillItem;
import uwu.lopyluna.create_dd.content.items.equipment.gilded_rose_tools.*;
import uwu.lopyluna.create_dd.content.items.equipment.magnet.MagnetItem;
import uwu.lopyluna.create_dd.content.items.exp.ExperienceNuggetItemOne;
import uwu.lopyluna.create_dd.content.items.exp.ExperienceNuggetItemTwo;
import uwu.lopyluna.create_dd.content.items.milkshakes.*;
//import uwu.lopyluna.create_dd.registry.ItemProperties.compound.*;
//import uwu.lopyluna.create_dd.registry.ItemProperties.sawtool.ForestRavagerItem;

import static com.tterrag.registrate.providers.RegistrateRecipeProvider.getItemName;
import static com.tterrag.registrate.providers.RegistrateRecipeProvider.has;
import static uwu.lopyluna.create_dd.DesiresCreate.REGISTRATE;
import static uwu.lopyluna.create_dd.registry.DesiresTags.forgeItemTag;
import static uwu.lopyluna.create_dd.registry.DesiresTags.optionalTag;

@SuppressWarnings({"unused", "deprecation", "all"})
public class DesiresItems {

	public static final ItemEntry<SequencedAssemblyItem>
            INCOMPLETE_INTEGRATED_CIRCUIT = sequencedItem("incomplete_integrated_circuit"),
            INCOMPLETE_KINETIC_MECHANISM = sequencedItem("incomplete_kinetic_mechanism"),
            INCOMPLETE_INTEGRATED_MECHANISM = sequencedItem("incomplete_integrated_mechanism"),
            INCOMPLETE_ABSTRUSE_MECHANISM = sequencedItem("incomplete_abstruse_mechanism"),
            INCOMPLETE_CALCULATION_MECHANISM = sequencedItem("incomplete_calculation_mechanism"),
            INCOMPLETE_INFERNAL_MECHANISM = sequencedItem("incomplete_infernal_mechanism"),
            INCOMPLETE_SEALED_MECHANISM = sequencedItem("incomplete_sealed_mechanism");
    ;

    public static final ItemEntry<Item> INTEGRATED_CIRCUIT = REGISTRATE.item("integrated_circuit", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Integrated circuit")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> KINETIC_MECHANISM = REGISTRATE.item("kinetic_mechanism", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Kinetic mechanism")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> INTEGRATED_MECHANISM = REGISTRATE.item("integrated_mechanism", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Integrated mechanism")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> CALCULATION_MECHANISM = REGISTRATE.item("calculation_mechanism", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Calculation mechanism")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> INFERNAL_MECHANISM = REGISTRATE.item("infernal_mechanism", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Infernal mechanism")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> SEALED_MECHANISM = REGISTRATE.item("sealed_mechanism", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Sealed mechanism")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> ABSTRUSE_MECHANISM = REGISTRATE.item("abstruse_mechanism", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Abtruse mechanism")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> MITHRIL_INGOT = REGISTRATE.item("mithril_ingot", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/mithril"))
            .lang("Mithril ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> BRONZE_INGOT = REGISTRATE.item("bronze_ingot", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/strong_bronze"))
            .lang("Bronze ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> STEEL_INGOT = REGISTRATE.item("steel_ingot", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/steel"))
            .lang("Steel ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> TIN_INGOT = REGISTRATE.item("tin_ingot", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/tin"))
            .lang("Tin ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> INDUSTRIAL_IRON_INGOT = REGISTRATE.item("industrial_iron_ingot", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/industrial_iron"))
            .lang("Industrial iron ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> MITHRIL_NUGGET = REGISTRATE.item("mithril_nugget", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("nuggets/mithril"))
            .lang("Mithril nugget")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> BRONZE_NUGGET = REGISTRATE.item("bronze_nugget", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/strong_bronze"))
            .lang("Bronze nugget")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> STEEL_NUGGET = REGISTRATE.item("steel_nugget", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("nuggets/steel"))
            .lang("Steel nugget")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> TIN_NUGGET = REGISTRATE.item("tin_nugget", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("nuggets/tin"))
            .lang("Tin nugget")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> INDUSTRIAL_IRON_NUGGET = REGISTRATE.item("industrial_iron_nugget", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("nuggets/industrial_iron"))
            .lang("Industrial iron nugget")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> MITHRIL_SHEET = REGISTRATE.item("mithril_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/mithril"))
            .lang("Mithril sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> BRONZE_SHEET = REGISTRATE.item("bronze_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/strong_bronze"))
            .lang("Bronze sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> STEEL_SHEET = REGISTRATE.item("steel_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/steel"))
            .lang("Steel sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> INDUSTRIAL_IRON_SHEET = REGISTRATE.item("industrial_iron_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/industrial_iron"))
            .lang("Industrial iron sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> RAW_TIN = REGISTRATE.item("raw_tin", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Raw tin")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> EMBER_ALLOY = REGISTRATE.item("ember_alloy", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/ember_alloy"))
            .lang("Ember alloy")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> LAPIS_ALLOY = REGISTRATE.item("lapis_alloy", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("ingots/lapis_alloy"))
            .lang("Lapis alloy")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> LAPIS_SHEET = REGISTRATE.item("lapis_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/lapis_alloy"))
            .lang("Lapis sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> ANDESITE_SHEET = REGISTRATE.item("andesite_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/andesite_alloy"))
            .lang("Andesite sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> ZINC_SHEET = REGISTRATE.item("zinc_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/zinc"))
            .lang("Zinc sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> TIN_SHEET = REGISTRATE.item("tin_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(forgeItemTag("plates/tin"))
            .lang("Tin sheet")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> SPECTRAL_RUBY = REGISTRATE.item("spectral_ruby", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Mithril ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> POLISHED_SPECTRAL_RUBY = REGISTRATE.item("polished_spectral_ruby", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Mithril ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> COMPOUND_BASE = REGISTRATE.item("compound_base", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Mithril ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> CRYSTALLIZED_SAP = REGISTRATE.item("crystallized_sap", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .lang("Mithril ingot")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

	public static final ItemEntry<Item> RAW_RUBBER = REGISTRATE.item("raw_rubber", Item::new)
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.tag(forgeItemTag("raw_rubbers"))
			.recipe((c, p) -> {
				Item output = DesiresBlocks.RAW_RUBBER_BLOCK.get().asItem();
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
						.pattern("CCC")
						.pattern("CCC")
						.pattern("CCC")
						.define('C', c.get())
						.unlockedBy("has_" + getItemName(output), has(output))
						.save(p, DesiresCreate.asResource("crafting/" + getItemName(output) + "_from_" + c.getName()));
				ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 9)
						.requires(output)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(output)));
			})
			.lang("Raw Rubber")
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<Item> RUBBER = REGISTRATE.item("rubber", Item::new)
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.tag(forgeItemTag("rubbers"), forgeItemTag("crude_rubbers"))
			.recipe((c, p) -> {
				Item output = DesiresBlocks.RUBBER_BLOCK.get().asItem();
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
						.pattern("CCC")
						.pattern("CCC")
						.pattern("CCC")
						.define('C', c.get())
						.unlockedBy("has_" + getItemName(output), has(output))
						.save(p, DesiresCreate.asResource("crafting/" + getItemName(output) + "_from_" + c.getName()));
				ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 9)
						.requires(output)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(output)));

				SimpleCookingRecipeBuilder.smoking(Ingredient.of(RAW_RUBBER.get()),RecipeCategory.BUILDING_BLOCKS , c.get(), 2, 600)
						.unlockedBy("has_" + getItemName(RAW_RUBBER.get()), has(RAW_RUBBER.get()))
						.save(p, DesiresCreate.asResource("smoking/" + c.getId().getPath()));
			})
			.lang("Rubber")
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<Item> BURY_BLEND = REGISTRATE.item("bury_blend", Item::new)
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.tag(forgeItemTag("ingots/bury_blend"), forgeItemTag("ingots"), forgeItemTag("bury_blends"))
			.recipe((c, p) -> ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 2)
					.requires(Items.LAPIS_LAZULI)
					.requires(AllItems.CRUSHED_IRON.get())
					.requires(AllItems.CRUSHED_IRON.get())
					.requires(Items.LAPIS_LAZULI)
					.unlockedBy("has_" + getItemName(Items.LAPIS_LAZULI), has(Items.LAPIS_LAZULI))
					.save(p, DesiresCreate.asResource("crafting/bury_blend")))
			.lang("Bury Blend")
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

    public static final ItemEntry<ChromaticCompound> CHROMATIC_COMPOUND = REGISTRATE.item("chromatic_compound", ChromaticCompound::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<ShadowSteel> SHADOW_STEEL = REGISTRATE.item("shadow_steel", ShadowSteel::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<ShadowSteel> SHADOW_STEEL_SHEET = REGISTRATE.item("shadow_steel_sheet", ShadowSteel::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<RefinedRadiance> REFINED_RADIANCE = REGISTRATE.item("refined_radiance", RefinedRadiance::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<RefinedRadiance> REFINED_RADIANCE_SHEET = REGISTRATE.item("refined_radiance_sheet", RefinedRadiance::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<UnchargedStargazeSingularity> FALLEN_STARGAZE_SINGULARITY = REGISTRATE.item("fallen_stargaze_singularity", UnchargedStargazeSingularity::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<StargazeSingularity> STARGAZE_SINGULARITY = REGISTRATE.item("stargaze_singularity", StargazeSingularity::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.EPIC)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<StargazeSingularity> STARGAZE_SINGULARITY_SHEET = REGISTRATE.item("stargaze_singularity_sheet", StargazeSingularity::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.EPIC)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> BLAZE_GOLD = REGISTRATE.item("blaze_gold", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> BLAZE_GOLD_SHEET = REGISTRATE.item("blaze_gold_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> OVERCHARGE_ALLOY = REGISTRATE.item("overcharge_alloy", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(16)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> OVERCHARGE_ALLOY_SHEET = REGISTRATE.item("overcharge_alloy_sheet", Item::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(12)
                .rarity(Rarity.UNCOMMON)
                .fireResistant())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<ExperienceNuggetItemOne> ONE_EXP_NUGGET = REGISTRATE.item("experience_ingot", ExperienceNuggetItemOne::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(Tags.Items.INGOTS)
            .properties(p -> p.stacksTo(12)
                .rarity(Rarity.UNCOMMON))
            .lang("Ingot of Experience")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<ExperienceNuggetItemTwo> TWO_EXP_NUGGET = REGISTRATE.item("experience_mass", ExperienceNuggetItemTwo::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(12)
                .rarity(Rarity.EPIC)
                .fireResistant())
            .lang("Mass of Experience")
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<Item> LAPIS_LAZULI_SHARD = REGISTRATE.item("lapis_lazuli_shard", Item::new)
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.tag(forgeItemTag("nuggets/lapis"), forgeItemTag("nuggets"))
			.recipe((c, p) -> {
				Item output = Items.LAPIS_LAZULI;
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
						.pattern("CC")
						.pattern("CC")
						.define('C', c.get())
						.unlockedBy("has_" + getItemName(output), has(output))
						.save(p, DesiresCreate.asResource("crafting/" + getItemName(output) + "_from_" + c.getName()));
				ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 4)
						.requires(output)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(output)));
			})
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<Item> DIAMOND_SHARD = REGISTRATE.item("diamond_shard", Item::new)
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.tag(forgeItemTag("nuggets/diamond"), forgeItemTag("nuggets"))
			.recipe((c, p) -> {
				Item output = Items.DIAMOND;
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, output, 1)
					.pattern("CC")
					.pattern("CC")
						.define('C', c.get())
						.unlockedBy("has_" + getItemName(output), has(output))
						.save(p, DesiresCreate.asResource("crafting/" + getItemName(output) + "_from_" + c.getName()));
				ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 4)
						.requires(output)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(output)));
			})
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<CombustibleItem> COAL_PIECE = REGISTRATE.item("coal_piece", CombustibleItem::new)
			.onRegister(i -> i.setBurnTime(200))
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.tag(forgeItemTag("nuggets/coal"), forgeItemTag("nuggets"))
			.recipe((c, p) -> {
				Item output = Items.COAL;
				ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 1)
						.requires(c.get()).requires(c.get())
						.requires(c.get()).requires(c.get())
						.requires(c.get()).requires(c.get())
						.requires(c.get()).requires(c.get())
						.unlockedBy("has_" + getItemName(output), has(output))
						.save(p, DesiresCreate.asResource("crafting/" + getItemName(output) + "_from_" + c.getName()));
				ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, c.get(), 8)
						.requires(output)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/" + c.getName() + "_from_" + getItemName(output)));
			})
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

    public static final ItemEntry<CombustibleItem> SEETHING_ABLAZE_ROD = REGISTRATE.item("seething_ablaze_rod", CombustibleItem::new)
            .tag(AllTags.AllItemTags.BLAZE_BURNER_FUEL_SPECIAL.tag)
            .onRegister(i -> i.setBurnTime(9600))
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/handheld")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .recipe((c, p) -> {
                Item output = DesiresItems.SEETHING_ABLAZE_POWDER.get().asItem();
                ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, output, 2)
                        .requires(c.get())
                        .unlockedBy("has_" + c.getName(), has(c.get()))
                        .save(p, DesiresCreate.asResource("crafting/" + getItemName(output) + "_from_" + c.getName()));
            })
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<CombustibleItem> SEETHING_ABLAZE_POWDER = REGISTRATE.item("seething_ablaze_powder", CombustibleItem::new)
            .onRegister(i -> i.setBurnTime(4800))
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

	public static final ItemEntry<MagnetItem> MAGNET = REGISTRATE.item("magnet", MagnetItem::new)
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/generated")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.recipe((c, p) -> {
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
						.pattern("I I")
						.pattern("B Q")
						.pattern("BNQ")
						.define('Q', AllItems.POLISHED_ROSE_QUARTZ.get())
						.define('B', BURY_BLEND.get())
						.define('I', Items.IRON_INGOT)
						.define('N', Items.NETHERITE_INGOT)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/equipment/flipped_" + c.getName()));
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
						.pattern("I I")
						.pattern("Q B")
						.pattern("QNB")
						.define('Q', AllItems.POLISHED_ROSE_QUARTZ.get())
						.define('B', BURY_BLEND.get())
						.define('I', Items.IRON_INGOT)
						.define('N', Items.NETHERITE_INGOT)
						.unlockedBy("has_" + c.getName(), has(c.get()))
						.save(p, DesiresCreate.asResource("crafting/equipment/" + c.getName()));
			})
			.lang("Magnet")
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<GRSwordItem> GILDED_ROSE_SWORD = REGISTRATE.item("gilded_rose_sword",
					p -> new GRSwordItem(DesireTiers.GILDED_ROSE, 3, -2.4F, p))
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/handheld")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.tag(DesiresTags.AllItemTags.ADDITIONAL_DROPS_TOOL.tag)
			.tag(DesiresTags.AllItemTags.SWORD.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<GRPickaxeItem> GILDED_ROSE_PICKAXE = REGISTRATE.item("gilded_rose_pickaxe",
					p -> new GRPickaxeItem(DesireTiers.GILDED_ROSE, 1, -2.8F, p))
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/handheld")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.tag(DesiresTags.AllItemTags.ADDITIONAL_DROPS_TOOL.tag)
			.tag(DesiresTags.AllItemTags.PICKAXE.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<GRAxeItem> GILDED_ROSE_AXE = REGISTRATE.item("gilded_rose_axe",
					p -> new GRAxeItem(DesireTiers.GILDED_ROSE, 6.0F, -3.0F, p))
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/handheld")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.tag(DesiresTags.AllItemTags.ADDITIONAL_DROPS_TOOL.tag)
			.tag(DesiresTags.AllItemTags.AXE.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<GRShovelItem> GILDED_ROSE_SHOVEL = REGISTRATE.item("gilded_rose_shovel",
					p -> new GRShovelItem(DesireTiers.GILDED_ROSE, 1.5F, -3.0F, p))
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/handheld")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.tag(DesiresTags.AllItemTags.ADDITIONAL_DROPS_TOOL.tag)
			.tag(DesiresTags.AllItemTags.SHOVEL.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<GRHoeItem> GILDED_ROSE_HOE = REGISTRATE.item("gilded_rose_hoe",
					p -> new GRHoeItem(DesireTiers.GILDED_ROSE, -2, -3.0F, p))
			.model((c, p) -> p.withExistingParent(c.getId().getPath(),
					new ResourceLocation("item/handheld")).texture("layer0",
					new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.tag(DesiresTags.AllItemTags.ADDITIONAL_DROPS_TOOL.tag)
			.tag(DesiresTags.AllItemTags.HOE.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<DeforesterSawItem> DEFORESTER_SAW = REGISTRATE.item("deforester_saw", DeforesterSawItem::new)
			.model(AssetLookup.itemModelWithPartials())
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.recipe((c, p) -> {
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
						.pattern(" II")
						.pattern("AKI")
						.pattern(" S ")
						.define('K', KINETIC_MECHANISM.get())
						.define('A', AllItems.ANDESITE_ALLOY.get())
						.define('I', AllTags.forgeItemTag("plates/iron"))
						.define('S', Items.STICK)
						.unlockedBy("has_" + getItemName(KINETIC_MECHANISM.get().asItem()), has(KINETIC_MECHANISM.get()))
						.save(p, DesiresCreate.asResource("crafting/equipment/flipped_" + c.getName()));
				ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, c.get(), 1)
						.pattern("II ")
						.pattern("IKA")
						.pattern(" S ")
						.define('K', KINETIC_MECHANISM.get())
						.define('A', AllItems.ANDESITE_ALLOY.get())
						.define('I', AllTags.forgeItemTag("plates/iron"))
						.define('S', Items.STICK)
						.unlockedBy("has_" + getItemName(KINETIC_MECHANISM.get().asItem()), has(KINETIC_MECHANISM.get()))
						.save(p, DesiresCreate.asResource("crafting/equipment/" + c.getName()));
			})
			.tag(DesiresTags.AllItemTags.AXE.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

    public static final ItemEntry<ForestRavagerItem> FOREST_RAVAGER = REGISTRATE.item("forest_ravager", ForestRavagerItem::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .properties(p -> p.stacksTo(12)
                    .rarity(Rarity.UNCOMMON)
                    .fireResistant())
            .model(AssetLookup.itemModelWithPartials())
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

	public static final ItemEntry<ExcavationDrillItem> EXCAVATION_DRILL = REGISTRATE.item("excavation_drill", ExcavationDrillItem::new)
			.model(AssetLookup.itemModelWithPartials())
			.properties(p -> p.rarity(Rarity.UNCOMMON))
			.tag(DesiresTags.AllItemTags.PICKAXE.tag)
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.register();

	public static final ItemEntry<NameableRecordItem> MUSIC_DISC_WALTZ_OF_THE_FLOWERS = REGISTRATE.item("music_disc_waltz_of_the_flowers",
					p -> new NameableRecordItem(10, DesiresSoundEvents.MUSIC_DISC_WALTZ_OF_THE_FLOWERS, p, 16600, "Tchaikovsky - Waltz of the Flowers"))
			.properties(p -> p.rarity(Rarity.RARE)
					.stacksTo(1))
			.recipe((c, p) -> p.stonecutting(DataIngredient.items(AllItems.ROSE_QUARTZ.get()), RecipeCategory.BUILDING_BLOCKS, c, 1))
			.tag(optionalTag(ForgeRegistries.ITEMS, new ResourceLocation("minecraft", "music_discs")))
			.tag(optionalTag(ForgeRegistries.ITEMS, new ResourceLocation("minecraft", "creeper_drop_music_discs")))
			.tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
			.lang("Music Disc")
			.register();

    public static final ItemEntry<VanillaMilkshake> vanilla_milkshake = REGISTRATE.item("vanilla_milkshake", VanillaMilkshake::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(12))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<StrawberryMilkshake> strawberry_milkshake = REGISTRATE.item("strawberry_milkshake", StrawberryMilkshake::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(12))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<GlowberryMilkshake> glowberry_milkshake = REGISTRATE.item("glowberry_milkshake", GlowberryMilkshake::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(12))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<CaramelMilkshake> caramel_milkshake = REGISTRATE.item("caramel_milkshake", CaramelMilkshake::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(12))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<HotChocolate> hot_chocolate = REGISTRATE.item("hot_chocolate", HotChocolate::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(12))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();

    public static final ItemEntry<ChocolateMilkshake> chocolate_milkshake = REGISTRATE.item("chocolate_milkshake", ChocolateMilkshake::new)
            .model((c, p) -> p.withExistingParent(c.getId().getPath(),
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(DesiresCreate.MOD_ID,"item/" + c.getId().getPath())))
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p.stacksTo(12))
            .tab(DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey())
            .register();


	private static ItemEntry<Item> item(String name) {
		ResourceKey<CreativeModeTab> tab = DesiresCreativeModeTabs.BASE_CREATIVE_TAB.getKey();
		assert tab != null;
		return REGISTRATE.item(name, Item::new)
				.tab(tab)
				.register();
	}

	private static ItemEntry<SequencedAssemblyItem> sequencedItem(String name) {
		return REGISTRATE.item(name, SequencedAssemblyItem::new)
				.register();
	}

    // Load this class
    public static void register() {}

}

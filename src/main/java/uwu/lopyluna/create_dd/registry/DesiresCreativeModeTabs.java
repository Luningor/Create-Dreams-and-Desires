package uwu.lopyluna.create_dd.registry;

import com.tterrag.registrate.util.entry.ItemProviderEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import it.unimi.dsi.fastutil.objects.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.DesiresCreate;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DesiresCreativeModeTabs {
	private static final DeferredRegister<CreativeModeTab> REGISTER =
			DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DesiresCreate.MOD_ID);

	public static final RegistryObject<CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("base",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.create_dd.base"))
					.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
					.icon(DesiresBlocks.COG_CRANK::asStack)
					.displayItems(new DesiresCreativeModeTabs.RegistrateDisplayItemsGenerator(true, DesiresCreativeModeTabs.BASE_CREATIVE_TAB))
					.build());
	public static final RegistryObject<CreativeModeTab> PALETTES_CREATIVE_TAB = REGISTER.register("palettes",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.create_dd.palettes"))
					.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
					.icon(DesiresPaletteBlocks.LIGHT_BLUE_BLUEPRINT_BLOCK::asStack)
					.displayItems(new DesiresCreativeModeTabs.RegistrateDisplayItemsGenerator(true, DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB))
					.build());
	public static final RegistryObject<CreativeModeTab> BETA_CREATIVE_TAB = REGISTER.register("beta",
			() -> CreativeModeTab.builder()
					.title(Component.translatable("itemGroup.create_dd.beta"))
					.withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
					.icon(DesiresBlocks.CREATIVE_CASING::asStack)
					.displayItems(new DesiresCreativeModeTabs.RegistrateDisplayItemsGenerator(true, DesiresCreativeModeTabs.BETA_CREATIVE_TAB))
					.build());


	public static void register(IEventBus modEventBus) {
		REGISTER.register(modEventBus);
	}

	private static class RegistrateDisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
		private static final Predicate<Item> IS_ITEM_3D_PREDICATE;

		static {
			MutableObject<Predicate<Item>> isItem3d = new MutableObject<>(item -> false);
			DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
				isItem3d.setValue(item -> {
					ItemRenderer itemRenderer = Minecraft.getInstance()
							.getItemRenderer();
					BakedModel model = itemRenderer.getModel(new ItemStack(item), null, null, 0);
					return model.isGui3d();
				});
			});
			IS_ITEM_3D_PREDICATE = isItem3d.getValue();
		}

		@OnlyIn(Dist.CLIENT)
		private static Predicate<Item> makeClient3dItemPredicate() {
			return item -> {
				ItemRenderer itemRenderer = Minecraft.getInstance()
						.getItemRenderer();
				BakedModel model = itemRenderer.getModel(new ItemStack(item), null, null, 0);
				return model.isGui3d();
			};
		}

		private final boolean addItems;
		private final RegistryObject<CreativeModeTab> tabFilter;

		public RegistrateDisplayItemsGenerator(boolean addItems, RegistryObject<CreativeModeTab> tabFilter) {
			this.addItems = addItems;
			this.tabFilter = tabFilter;
		}

		@SuppressWarnings({"removal"})
		private static Predicate<Item> makeExclusionPredicate() {
			Set<Item> exclusions = new ReferenceOpenHashSet<>();

			List<ItemProviderEntry<?>> simpleExclusions = List.of(
					DesiresClassicStuffPorting.REVERSED_GEARSHIFT,
					DesiresClassicStuffPorting.inductive_mechanism,
					DesiresClassicStuffPorting.incomplete_inductive_mechanism,
					DesiresItems.INCOMPLETE_KINETIC_MECHANISM,
                    DesiresItems.INCOMPLETE_ABSTRUSE_MECHANISM,
                    DesiresItems.INCOMPLETE_CALCULATION_MECHANISM,
                    DesiresItems.INCOMPLETE_INFERNAL_MECHANISM,
                    DesiresItems.INCOMPLETE_INTEGRATED_CIRCUIT,
                    DesiresItems.INCOMPLETE_INTEGRATED_MECHANISM,
                    DesiresItems.INCOMPLETE_SEALED_MECHANISM
			);

			for (ItemProviderEntry<?> entry : simpleExclusions) {
				exclusions.add(entry.asItem());
			}

            return exclusions::contains;
		}

        @SuppressWarnings({"removal"})
        private static Predicate<Item> makeBaseInclusionPredicate() {
            Set<Item> baseInclusions = new ReferenceOpenHashSet<>();

            List<ItemProviderEntry<?>> simpleBaseInclusions = List.of(
                    DesiresBlocks.TIN_ORE,
                    DesiresBlocks.DEEPSLATE_TIN_ORE,
                    DesiresBlocks.RAW_TIN_BLOCK,
                    DesiresBlocks.TIN_BLOCK,
                    DesiresBlocks.MITHRIL_BLOCK,
                    DesiresBlocks.BRONZE_BLOCK,
                    DesiresBlocks.STEEL_BLOCK,
                    DesiresBlocks.INDUSTRIAL_IRON_BLOCK,
                    DesiresBlocks.LEATHER_BLOCK,
                    DesiresBlocks.LAPIS_ALLOY_BLOCK,
                    DesiresBlocks.EMBER_ALLOY_BLOCK,
                    DesiresBlocks.CHROMATIC_BLOCK,
                    DesiresBlocks.REFINED_RADIANCE_BLOCK,
                    DesiresBlocks.SHADOW_STEEL_BLOCK,
                    DesiresBlocks.OVERCHARGED_ALLOY_BLOCK,
                    DesiresBlocks.BLAZE_GOLD_BLOCK,
                    DesiresBlocks.STARGAZE_SINGULARITY_BLOCK,
                    DesiresBlocks.MOSSY_ANDESITE_ALLOY_BLOCK,
                    DesiresBlocks.CREATIVE_CASING,
                    DesiresBlocks.MITHRIL_CASING,
                    DesiresBlocks.BRONZE_CASING,
                    DesiresBlocks.ZINC_CASING,
                    DesiresBlocks.TIN_CASING,
                    DesiresBlocks.BLAZE_GOLD_CASING,
                    DesiresBlocks.NETHERITE_CASING,
                    DesiresBlocks.OVERCHARGED_CASING,
                    DesiresBlocks.REFINED_RADIANCE_CASING,
                    DesiresBlocks.SHADOW_STEEL_CASING,
                    DesiresBlocks.STARGAZE_SINGULARITY_CASING,
                    DesiresBlocks.ELEMENTIUM_CASING,
                    DesiresBlocks.BRICK_CASING,
                    DesiresBlocks.NETHER_BRICK_CASING,
                    DesiresBlocks.MOSSY_ANDESITE_CASING,
                    DesiresBlocks.HYDRAULIC_CASING,
                    DesiresBlocks.INDUSTRIAL_CASING,
                    DesiresBlocks.OVERBURDEN_CASING,
                    DesiresBlocks.STEEL_CASING,
                    DesiresBlocks.TERRASTEEL_CASING,
                    DesiresBlocks.REINFORCEMENT_PLATING,
                    DesiresBlocks.FAUXVAULT_CASING,
                    DesiresBlocks.HEAVY_BRASS_CASING,
                    DesiresBlocks.INDUSTRIAL_BRASS_CASING,
                    DesiresBlocks.FAUX_INDUSTRIAL_BRASS_CASING,
                    DesiresBlocks.TECHBRAIN_CASING,
                    DesiresBlocks.SPECTRAL_RUBY_LAMP
            );

            for (ItemProviderEntry<?> entry : simpleBaseInclusions) {
                baseInclusions.add(entry.asItem());
            }

            return baseInclusions::contains;
        }

        @SuppressWarnings({"removal"})
        private static Predicate<Item> makePaletteInclusionPredicate() {
            Set<Item> paletteInclusions = new ReferenceOpenHashSet<>();

            List<ItemProviderEntry<?>> simplePaletteInclusions = List.of(
                    DesiresPaletteBlocks.WHITE_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.LIGHT_GRAY_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.GRAY_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.BLACK_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.BROWN_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.RED_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.ORANGE_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.YELLOW_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.LIME_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.GREEN_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.CYAN_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.LIGHT_BLUE_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.BLUE_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.PURPLE_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.MAGENTA_BLUEPRINT_BLOCK,
                    DesiresPaletteBlocks.PINK_BLUEPRINT_BLOCK,
                    DesiresBlocks.POTASSIC_COBBLE,
                    DesiresBlocks.ASURINE_COBBLE,
                    DesiresBlocks.CRIMSITE_COBBLE,
                    DesiresBlocks.OCHRUM_COBBLE,
                    DesiresBlocks.VERIDIUM_COBBLE,
                    DesiresBlocks.PONDER_LIGHT,
                    DesiresBlocks.PONDER_DARK,
                    DesiresBlocks.POLISHED_BRONZE_BLOCK,
                    DesiresBlocks.POLISHED_BRONZE_STAIRS,
                    DesiresBlocks.POLISHED_BRONZE_SLAB,
                    DesiresBlocks.TILED_BRONZE_BLOCK,
                    DesiresBlocks.TILED_BRONZE_STAIRS,
                    DesiresBlocks.TILED_BRONZE_SLAB,
                    DesiresBlocks.POLISHED_STEEL_BLOCK,
                    DesiresBlocks.POLISHED_STEEL_STAIRS,
                    DesiresBlocks.POLISHED_STEEL_SLAB,
                    DesiresBlocks.TILED_STEEL_BLOCK,
                    DesiresBlocks.TILED_STEEL_STAIRS,
                    DesiresBlocks.TILED_STEEL_SLAB,
                    DesiresBlocks.POLISHED_ZINC_BLOCK,
                    DesiresBlocks.POLISHED_ZINC_STAIRS,
                    DesiresBlocks.POLISHED_ZINC_SLAB,
                    DesiresBlocks.TILED_ZINC_BLOCK,
                    DesiresBlocks.TILED_ZINC_STAIRS,
                    DesiresBlocks.TILED_ZINC_SLAB,
                    DesiresBlocks.POLISHED_ANDESITE_ALLOY_BLOCK,
                    DesiresBlocks.POLISHED_ANDESITE_ALLOY_STAIRS,
                    DesiresBlocks.POLISHED_ANDESITE_ALLOY_SLAB,
                    DesiresPaletteBlocks.DARK_METAL_BLOCK,
                    DesiresPaletteBlocks.DARK_METAL_PLATING,
                    DesiresPaletteBlocks.DARK_METAL_SLAB,
                    DesiresPaletteBlocks.DARK_METAL_STAIRS,
                    DesiresPaletteBlocks.DARK_METAL_BRICKS,
                    DesiresPaletteBlocks.DARK_METAL_BRICK_SLAB,
                    DesiresPaletteBlocks.DARK_METAL_BRICK_STAIRS,
                    DesiresBlocks.ANDESITE_ASPHALT_BLOCK,
                    DesiresBlocks.ASURINE_ASPHALT_BLOCK,
                    DesiresBlocks.CALCITE_ASPHALT_BLOCK,
                    DesiresBlocks.CRIMSITE_ASPHALT_BLOCK,
                    DesiresBlocks.DEEPSLATE_ASPHALT_BLOCK,
                    DesiresBlocks.DIORITE_ASPHALT_BLOCK,
                    DesiresBlocks.DRIPSTONE_ASPHALT_BLOCK,
                    DesiresBlocks.GABBRO_ASPHALT_BLOCK,
                    DesiresBlocks.GRANITE_ASPHALT_BLOCK,
                    DesiresBlocks.LIMESTONE_ASPHALT_BLOCK,
                    DesiresBlocks.OCHRUM_ASPHALT_BLOCK,
                    DesiresBlocks.POTASSIC_ASPHALT_BLOCK,
                    DesiresBlocks.AETHERSITE_ASPHALT_BLOCK,
                    DesiresBlocks.SCORCHIA_ASPHALT_BLOCK,
                    DesiresBlocks.SCORIA_ASPHALT_BLOCK,
                    DesiresBlocks.TUFF_ASPHALT_BLOCK,
                    DesiresBlocks.VERIDIUM_ASPHALT_BLOCK,
                    DesiresBlocks.WEATHERED_LIMESTONE_ASPHALT_BLOCK,
                    DesiresBlocks.ANDESITE_MOSSY_BRICKS,
                    DesiresBlocks.ASURINE_MOSSY_BRICKS,
                    DesiresBlocks.CALCITE_MOSSY_BRICKS,
                    DesiresBlocks.CRIMSITE_MOSSY_BRICKS,
                    DesiresBlocks.DEEPSLATE_MOSSY_BRICKS,
                    DesiresBlocks.DIORITE_MOSSY_BRICKS,
                    DesiresBlocks.DRIPSTONE_MOSSY_BRICKS,
                    DesiresBlocks.GABBRO_MOSSY_BRICKS,
                    DesiresBlocks.GRANITE_MOSSY_BRICKS,
                    DesiresBlocks.LIMESTONE_MOSSY_BRICKS,
                    DesiresBlocks.OCHRUM_MOSSY_BRICKS,
                    DesiresBlocks.POTASSIC_MOSSY_BRICKS,
                    DesiresBlocks.AETHERSITE_MOSSY_BRICKS,
                    DesiresBlocks.SCORCHIA_MOSSY_BRICKS,
                    DesiresBlocks.SCORIA_MOSSY_BRICKS,
                    DesiresBlocks.TUFF_MOSSY_BRICKS,
                    DesiresBlocks.VERIDIUM_MOSSY_BRICKS,
                    DesiresBlocks.WEATHERED_LIMESTONE_MOSSY_BRICKS,
                    DesiresBlocks.HYDRAULIC_SCAFFOLD,
                    DesiresBlocks.OVERBURDEN_SCAFFOLD,
                    DesiresBlocks.INDUSTRIAL_SCAFFOLD,
                    DesiresBlocks.MITHRIL_SCAFFOLD,
                    DesiresBlocks.MOSSY_ANDESITE_SCAFFOLD,
                    DesiresBlocks.ZINC_SCAFFOLD,
                    DesiresBlocks.TIN_SCAFFOLD,
                    DesiresBlocks.BRONZE_SCAFFOLD,
                    DesiresBlocks.STEEL_SCAFFOLD,
                    DesiresBlocks.SHADOW_SCAFFOLD,
                    DesiresBlocks.RADIANT_SCAFFOLD,
                    DesiresBlocks.STARGAZE_SINGULARITY_SCAFFOLD,
                    DesiresBlocks.BLAZE_GOLD_SCAFFOLD,
                    DesiresBlocks.OVERCHARGED_SCAFFOLD,
                    DesiresBlocks.NETHERITE_SCAFFOLD,
                    DesiresBlocks.VERTICAL_FRAMED_SPLIT_GLASS,
                    DesiresBlocks.HORIZONTAL_FRAMED_SPLIT_GLASS,
                    DesiresBlocks.FRAMED_SPLIT_GLASS,
                    DesiresBlocks.ORNATE_IRON_GLASS,
                    DesiresBlocks.VERTICAL_FRAMED_SPLIT_GLASS_PANE,
                    DesiresBlocks.HORIZONTAL_FRAMED_SPLIT_GLASS_PANE,
                    DesiresBlocks.FRAMED_SPLIT_GLASS_PANE,
                    DesiresBlocks.ORNATE_IRON_GLASS_PANE,
                    DesiresBlocks.TRAIN_SCAFFOLD,
                    DesiresBlocks.ROSE_LOG,
                    DesiresBlocks.STRIPPED_ROSE_LOG,
                    DesiresBlocks.ROSE_WOOD,
                    DesiresBlocks.STRIPPED_ROSE_WOOD,
                    DesiresBlocks.ROSE_PLANKS,
                    DesiresBlocks.ROSE_SLAB,
                    DesiresBlocks.ROSE_STAIRS,
                    DesiresBlocks.ROSE_FENCE,
                    DesiresBlocks.ROSE_FENCE_GATE,
                    DesiresBlocks.ROSE_DOOR,
                    DesiresBlocks.ROSE_TRAPDOOR,
                    DesiresBlocks.ROSE_BUTTON,
                    DesiresBlocks.ROSE_PRESSURE_PLATE,
                    DesiresBlocks.SMOKED_LOG,
                    DesiresBlocks.STRIPPED_SMOKED_LOG,
                    DesiresBlocks.SMOKED_WOOD,
                    DesiresBlocks.STRIPPED_SMOKED_WOOD,
                    DesiresBlocks.SMOKED_PLANKS,
                    DesiresBlocks.SMOKED_STAIRS,
                    DesiresBlocks.SMOKED_SLAB,
                    DesiresBlocks.SMOKED_FENCE,
                    DesiresBlocks.SMOKED_FENCE_GATE,
                    DesiresBlocks.SMOKED_DOOR,
                    DesiresBlocks.SMOKED_TRAPDOOR,
                    DesiresBlocks.SMOKED_BUTTON,
                    DesiresBlocks.SMOKED_PRESSURE_PLATE,
                    DesiresBlocks.SPIRIT_LOG,
                    DesiresBlocks.STRIPPED_SPIRIT_LOG,
                    DesiresBlocks.SPIRIT_WOOD,
                    DesiresBlocks.STRIPPED_SPIRIT_WOOD,
                    DesiresBlocks.SPIRIT_PLANKS,
                    DesiresBlocks.SPIRIT_STAIRS,
                    DesiresBlocks.SPIRIT_SLAB,
                    DesiresBlocks.SPIRIT_FENCE,
                    DesiresBlocks.SPIRIT_FENCE_GATE,
                    DesiresBlocks.SPIRIT_DOOR,
                    DesiresBlocks.SPIRIT_TRAPDOOR,
                    DesiresBlocks.SPIRIT_BUTTON,
                    DesiresBlocks.SPIRIT_PRESSURE_PLATE,
                    DesiresBlocks.RUBBER_SAPLING,
                    DesiresBlocks.RUBBER_LEAVES,
                    DesiresBlocks.RUBBER_LOG,
                    DesiresBlocks.STRIPPED_RUBBER_LOG,
                    DesiresBlocks.RUBBER_WOOD,
                    DesiresBlocks.STRIPPED_RUBBER_WOOD,
                    DesiresBlocks.RUBBER_PLANKS,
                    DesiresBlocks.RUBBER_SLAB,
                    DesiresBlocks.RUBBER_STAIRS,
                    DesiresBlocks.RUBBER_FENCE,
                    DesiresBlocks.RUBBER_FENCE_GATE,
                    DesiresBlocks.RUBBER_DOOR,
                    DesiresBlocks.RUBBER_TRAPDOOR,
                    DesiresBlocks.RUBBER_BUTTON,
                    DesiresBlocks.RUBBER_PRESSURE_PLATE
            );

            for (ItemProviderEntry<?> entry : simplePaletteInclusions)
                paletteInclusions.add(entry.asItem());

            paletteInclusions.addAll(DesiresPaletteStoneTypes.getAllPaletteItems());

            return paletteInclusions::contains;
        }

        @SuppressWarnings({"removal"})
        private static Predicate<Item> makeBetaInclusionPredicate() {
            Set<Item> betaInclusions = new ReferenceOpenHashSet<>();

            List<ItemProviderEntry<?>> simpleBetaInclusions = List.of(
                    DesiresBlocks.GIANT_GEAR
            );

            for (ItemProviderEntry<?> entry : simpleBetaInclusions) {
                betaInclusions.add(entry.asItem());
            }

            return betaInclusions::contains;
        }

		private static List<RegistrateDisplayItemsGenerator.ItemOrdering> makeOrderings() {
            return new ReferenceArrayList<>();
		}

		private static Function<Item, ItemStack> makeStackFunc() {
			Map<Item, Function<Item, ItemStack>> factories = new Reference2ReferenceOpenHashMap<>();

			return item -> {
				Function<Item, ItemStack> factory = factories.get(item);
                return factory != null ? factory.apply(item) : new ItemStack(item);
			};
		}

		private static Function<Item, CreativeModeTab.TabVisibility> makeVisibilityFunc() {
			Map<Item, CreativeModeTab.TabVisibility> visibilities = new Reference2ObjectOpenHashMap<>();

			return item -> {
				CreativeModeTab.TabVisibility visibility = visibilities.get(item);
				return visibility != null ? visibility : CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS;
			};
		}

		@Override
		public void accept(CreativeModeTab.@NotNull ItemDisplayParameters parameters, CreativeModeTab.@NotNull Output output) {
			Predicate<Item> exclusionPredicate = makeExclusionPredicate();
			List<RegistrateDisplayItemsGenerator.ItemOrdering> orderings = makeOrderings();
			Function<Item, ItemStack> stackFunc = makeStackFunc();
			Function<Item, CreativeModeTab.TabVisibility> visibilityFunc = makeVisibilityFunc();

			List<Item> items = new LinkedList<>();
			if (addItems) {
				items.addAll(collectItems(exclusionPredicate.or(IS_ITEM_3D_PREDICATE.negate())));
			}

			items.addAll(collectBlocks(exclusionPredicate));

            if (addItems) {
				items.addAll(collectItems(exclusionPredicate.or(IS_ITEM_3D_PREDICATE)));
			}

			applyOrderings(items, orderings);
			outputAll(output, items, stackFunc, visibilityFunc);
		}

		private List<Item> collectBlocks(Predicate<Item> exclusionPredicate) {
			List<Item> items = new ReferenceArrayList<>();
            // Make the inclusion lists
            Predicate<Item> baseInclusionPredicate = makeBaseInclusionPredicate();
            Predicate<Item> paletteInclusionPredicate = makePaletteInclusionPredicate();
            Predicate<Item> betaInclusionPredicate = makeBetaInclusionPredicate();

            for (RegistryEntry<Block> entry : DesiresCreate.REGISTRATE.getAll(Registries.BLOCK)) {
                Item item = entry.get().asItem();

                // Glorified switch for non literals
                // Has to be made per entry since item changes every time
                Map<Object, Supplier<Boolean>> isOnTab = Map.of(
                        // Return bool if a. is <input> tab and b. is on inclusion list of said tab
                        DesiresCreativeModeTabs.BASE_CREATIVE_TAB.get(), () -> baseInclusionPredicate.test(item),

                        DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.get(), () -> paletteInclusionPredicate.test(item),

                        DesiresCreativeModeTabs.BETA_CREATIVE_TAB.get(), () -> betaInclusionPredicate.test(item)
                );

                // It's air. Don't add it to the tab.
                if (item == Items.AIR)
					continue;

                // It's on the exclusion list
                if (exclusionPredicate.test(item))
                    continue;

                // If it's on the corresponding tab inclusion list. If the list doesn't exist defaults to false
                if (isOnTab.getOrDefault(tabFilter.get(), () -> false).get())
                    items.add(item);
			}
			items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
			return items;
		}

		private List<Item> collectItems(Predicate<Item> exclusionPredicate) {
			List<Item> items = new ReferenceArrayList<>();
            // Make the inclusion lists
            Predicate<Item> baseInclusionPredicate = makeBaseInclusionPredicate();
            Predicate<Item> paletteInclusionPredicate = makePaletteInclusionPredicate();
            Predicate<Item> betaInclusionPredicate = makeBetaInclusionPredicate();

            for (RegistryEntry<Item> entry : DesiresCreate.REGISTRATE.getAll(Registries.ITEM)) {
                Item item = entry.get().asItem();

                // Glorified switch for non literals
                // Has to be made per entry since item changes every time
                Map<Object, Supplier<Boolean>> isOnTab = Map.of(
                        // Return bool if a. is <input> tab and b. is on inclusion list of said tab
                        DesiresCreativeModeTabs.BASE_CREATIVE_TAB.get(), () -> baseInclusionPredicate.test(item),

                        DesiresCreativeModeTabs.PALETTES_CREATIVE_TAB.get(), () -> paletteInclusionPredicate.test(item),

                        DesiresCreativeModeTabs.BETA_CREATIVE_TAB.get(), () -> betaInclusionPredicate.test(item)
                );

                // It's air. Don't add it to the tab.
                if (item == Items.AIR)
                    continue;

                // It's the item of a block. We already deal with those.
                if (item instanceof BlockItem)
                    continue;

                // It's on the exclusion list
                if (exclusionPredicate.test(item))
                    continue;

                // If it's on the corresponding tab inclusion list. If the list doesn't exist defaults to false
                if (isOnTab.getOrDefault(tabFilter.get(), () -> false).get())
                    items.add(item);
            }
            items = new ReferenceArrayList<>(new ReferenceLinkedOpenHashSet<>(items));
            return items;
		}

		private static void applyOrderings(List<Item> items, List<RegistrateDisplayItemsGenerator.ItemOrdering> orderings) {
			for (RegistrateDisplayItemsGenerator.ItemOrdering ordering : orderings) {
				int anchorIndex = items.indexOf(ordering.anchor());
				if (anchorIndex != -1) {
					Item item = ordering.item();
					int itemIndex = items.indexOf(item);
					if (itemIndex != -1) {
						items.remove(itemIndex);
						if (itemIndex < anchorIndex) {
							anchorIndex--;
						}
					}
					if (ordering.type() == RegistrateDisplayItemsGenerator.ItemOrdering.Type.AFTER) {
						items.add(anchorIndex + 1, item);
					} else {
						items.add(anchorIndex, item);
					}
				}
			}
		}

		private static void outputAll(CreativeModeTab.Output output, List<Item> items, Function<Item, ItemStack> stackFunc, Function<Item, CreativeModeTab.TabVisibility> visibilityFunc) {
			for (Item item : items) {
				output.accept(stackFunc.apply(item), visibilityFunc.apply(item));
			}
		}

		private record ItemOrdering(Item item, Item anchor, RegistrateDisplayItemsGenerator.ItemOrdering.Type type) {
			public static RegistrateDisplayItemsGenerator.ItemOrdering before(Item item, Item anchor) {
				return new RegistrateDisplayItemsGenerator.ItemOrdering(item, anchor, RegistrateDisplayItemsGenerator.ItemOrdering.Type.BEFORE);
			}

			public static RegistrateDisplayItemsGenerator.ItemOrdering after(Item item, Item anchor) {
				return new RegistrateDisplayItemsGenerator.ItemOrdering(item, anchor, RegistrateDisplayItemsGenerator.ItemOrdering.Type.AFTER);
			}

			public enum Type {
				BEFORE,
				AFTER
			}
		}
	}

}

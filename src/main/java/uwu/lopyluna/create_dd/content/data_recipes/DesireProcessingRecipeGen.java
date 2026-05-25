package uwu.lopyluna.create_dd.content.data_recipes;

import com.simibubi.create.api.data.recipe.BaseRecipeProvider;
import com.simibubi.create.content.processing.recipe.ProcessingRecipe;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeBuilder;
import com.simibubi.create.content.processing.recipe.ProcessingRecipeSerializer;
import com.simibubi.create.foundation.recipe.IRecipeTypeInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import uwu.lopyluna.create_dd.DesiresCreate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public abstract class DesireProcessingRecipeGen extends BaseRecipeProvider {

    protected static final List<DesireProcessingRecipeGen> GENERATORS = new ArrayList<>();

    public static void registerAll(DataGenerator gen, PackOutput output) {
        GENERATORS.add(new WashingRecipeGen(output));
        GENERATORS.add(new SandingRecipeGen(output));
        GENERATORS.add(new FreezingRecipeGen(output));
        GENERATORS.add(new SeethingRecipeGen(output));
        GENERATORS.add(new ItemApplicationRecipeGen(output));
        GENERATORS.add(new MixingRecipeGen(output));

        gen.addProvider(true, new DataProvider() {
            @Override
            public @NotNull String getName() {
                return DesiresCreate.NAME + " Processing Recipes";
            }

            @Override
            public @NotNull CompletableFuture<?> run(@NotNull CachedOutput dc) {
                return CompletableFuture.allOf(GENERATORS.stream()
                        .map(gen -> gen.run(dc))
                        .toArray(CompletableFuture[]::new));
            }
        });
    }

    public DesireProcessingRecipeGen(PackOutput generator) {
        super(generator, DesiresCreate.MOD_ID);
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(String namespace,
                                                                     Supplier<ItemLike> singleIngredient,
                                                                     UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        return register(c -> {
            ItemLike itemLike = singleIngredient.get();
            transform.apply(new ProcessingRecipeBuilder<>(serializer.getFactory(),
                            new ResourceLocation(namespace, Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(itemLike.asItem())).getPath()))
                            .withItemIngredients(Ingredient.of(itemLike)))
                    .build(c);
        });
    }

    <T extends ProcessingRecipe<?>> GeneratedRecipe create(Supplier<ItemLike> singleIngredient,
                                                           UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return create(DesiresCreate.MOD_ID, singleIngredient, transform);
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe createWithDeferredId(Supplier<ResourceLocation> name,
                                                                                   UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        ProcessingRecipeSerializer<T> serializer = getSerializer();
        return register(c -> transform.apply(
                new ProcessingRecipeBuilder<>(serializer.getFactory(), name.get())).build(c));
    }

    protected <T extends ProcessingRecipe<?>> GeneratedRecipe create(ResourceLocation name,
                                                                     UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return createWithDeferredId(() -> name, transform);
    }

    <T extends ProcessingRecipe<?>> GeneratedRecipe create(String name,
                                                           UnaryOperator<ProcessingRecipeBuilder<T>> transform) {
        return create(DesiresCreate.asResource(name), transform);
    }

    protected abstract IRecipeTypeInfo getRecipeType();

    protected <T extends ProcessingRecipe<?>> ProcessingRecipeSerializer<T> getSerializer() {
        return getRecipeType().getSerializer();
    }

    protected Supplier<ResourceLocation> idWithSuffix(Supplier<ItemLike> item, String suffix) {
        return () -> {
            ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item.get().asItem());
            assert registryName != null;
            return DesiresCreate.asResource(registryName.getPath() + suffix);
        };
    }
}
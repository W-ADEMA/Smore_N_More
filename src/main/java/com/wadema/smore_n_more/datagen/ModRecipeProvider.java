package com.wadema.smore_n_more.datagen;

import com.wadema.smore_n_more.food.ModFoods;
import com.wadema.smore_n_more.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registeries, RecipeOutput output) {
            return new ModRecipeProvider(registeries, output);
        }

        @Override
        public String getName() {
            return "SmoreNMore Recipies";
        }
    }

    @Override
    protected void buildRecipes() {
        /* ITEMS */

        // Marshmallow on a stick
        shapeless(RecipeCategory.FOOD, ModItems.MARSHMALLOW_ON_A_STICK.get(), 1)
                .requires(ModItems.MARSHMALLOW)
                .requires(Items.STICK)
                .unlockedBy(getHasName(ModItems.MARSHMALLOW.get()), has(ModItems.MARSHMALLOW))
                .group("marshmallow_on_a_stick")
                .save(output);

        /* INGREDIENTS */

        // Marshmallow
        shapeless(RecipeCategory.FOOD, ModItems.MARSHMALLOW.get(), 8)
                .requires(Items.SUGAR)
                .requires(Items.WATER_BUCKET)
                .requires(Items.SLIME_BALL)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .group("marshmallow")
                .save(output);

        // Chocolate
        shapeless(RecipeCategory.FOOD, ModItems.CHOCOLATE.get(), 8)
                .requires(Items.SUGAR)
                .requires(Items.MILK_BUCKET)
                .requires(Items.COCOA_BEANS)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .group("chocolate")
                .save(output);

        // Biscuit
        shaped(RecipeCategory.FOOD, ModItems.BISCUIT.get(), 8)
                .pattern("ABA")
                .define('A', Items.WHEAT)
                .define('B', Items.SUGAR)
                .unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
                .group("biscuit")
                .save(output);

        /* S'MORES */

        // Empty S'more
        shaped(RecipeCategory.FOOD, ModItems.EMPTY_SMORE.get(), 1)
                .pattern("A")
                .pattern("B")
                .pattern("A")
                .define('A', ModItems.BISCUIT.get())
                .define('B', ModItems.CHOCOLATE.get())
                .unlockedBy(getHasName(ModItems.BISCUIT.get()), has(ModItems.BISCUIT))
                .group("smores")
                .save(output);
    }
}

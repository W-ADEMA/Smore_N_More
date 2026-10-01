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
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

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

        // Roasted marshmallow on a stick
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.MARSHMALLOW_ON_A_STICK.get()),
                        RecipeCategory.FOOD,
                        ModItems.ROASTED_MARSHMALLOW_ON_A_STICK.get(),
                        0.35f,
                        600
                )
                .unlockedBy(getHasName(ModItems.MARSHMALLOW_ON_A_STICK.get()), has(ModItems.MARSHMALLOW_ON_A_STICK))
                .save(output);

        // Burnt marshmallow on a stick
        SimpleCookingRecipeBuilder.campfireCooking(
                        Ingredient.of(ModItems.ROASTED_MARSHMALLOW_ON_A_STICK.get()),
                        RecipeCategory.FOOD,
                        ModItems.BURNT_MARSHMALLOW_ON_A_STICK.get(),
                        0.35f,
                        600
                )
                .unlockedBy(getHasName(ModItems.ROASTED_MARSHMALLOW_ON_A_STICK.get()), has(ModItems.ROASTED_MARSHMALLOW_ON_A_STICK))
                .save(output);

        // Burnt marshmallow on a stick --> Charcoal
        shapeless(RecipeCategory.MISC, Items.CHARCOAL, 1)
                .requires(ModItems.BURNT_MARSHMALLOW_ON_A_STICK.get())
                .unlockedBy(getHasName(ModItems.BURNT_MARSHMALLOW_ON_A_STICK.get()), has(ModItems.BURNT_MARSHMALLOW_ON_A_STICK))
                .group("charcoal")
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

        // S'more
        shaped(RecipeCategory.FOOD, ModItems.SMORE.get(), 1)
                .pattern(" A ")
                .pattern("BC ")
                .pattern(" A ")
                .define('A', ModItems.BISCUIT.get())
                .define('B', ModItems.CHOCOLATE.get())
                .define('C', ModItems.ROASTED_MARSHMALLOW_ON_A_STICK.get())
                .unlockedBy(getHasName(ModItems.BISCUIT.get()), has(ModItems.BISCUIT))
                .group("smores")
                .save(output);

        // Burnt s'more
        shaped(RecipeCategory.FOOD, ModItems.BURNT_SMORE.get(), 1)
                .pattern(" A ")
                .pattern("BC ")
                .pattern(" A ")
                .define('A', ModItems.BISCUIT.get())
                .define('B', ModItems.CHOCOLATE.get())
                .define('C', ModItems.BURNT_MARSHMALLOW_ON_A_STICK.get())
                .unlockedBy(getHasName(ModItems.BISCUIT.get()), has(ModItems.BISCUIT))
                .group("smores")
                .save(output);

        // Flaming s'more
        shaped(RecipeCategory.FOOD, ModItems.FLAMING_SMORE.get(), 1)
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" A ")
                .define('A', ModItems.BISCUIT.get())
                .define('B', ModItems.CHOCOLATE.get())
                .define('C', ModItems.ROASTED_MARSHMALLOW_ON_A_STICK.get())
                .define('D', Items.BLAZE_POWDER)
                .unlockedBy(getHasName(ModItems.BISCUIT.get()), has(ModItems.BISCUIT))
                .group("smores")
                .save(output);

        // Wet s'more
        shaped(RecipeCategory.FOOD, ModItems.WET_SMORE.get(), 1)
                .pattern(" A ")
                .pattern("BCD")
                .pattern(" A ")
                .define('A', ModItems.BISCUIT.get())
                .define('B', ModItems.CHOCOLATE.get())
                .define('C', ModItems.ROASTED_MARSHMALLOW_ON_A_STICK.get())
                .define('D', Items.KELP)
                .unlockedBy(getHasName(ModItems.BISCUIT.get()), has(ModItems.BISCUIT))
                .group("smores")
                .save(output);
    }
}

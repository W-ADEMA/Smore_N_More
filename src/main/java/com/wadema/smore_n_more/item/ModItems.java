package com.wadema.smore_n_more.item;

import com.wadema.smore_n_more.SmoreNMore;
import com.wadema.smore_n_more.food.ModFoods;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(SmoreNMore.MODID);

    /* ITEMS */

    // Marshmallow on a stick
    public static final DeferredItem<Item> MARSHMALLOW_ON_A_STICK = ITEMS.registerSimpleItem("marshmallow_on_a_stick");

    // Roasted marshmallow on a stick
    public static final DeferredItem<Item> ROASTED_MARSHMALLOW_ON_A_STICK = ITEMS.registerSimpleItem("roasted_marshmallow_on_a_stick");

    // Roasted marshmallow on a stick
    public static final DeferredItem<Item> BURNT_MARSHMALLOW_ON_A_STICK = ITEMS.registerSimpleItem("burnt_marshmallow_on_a_stick");

    /* INGREDIENTS */

    // Marshmallow
    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.registerItem("marshmallow",
            properties -> new Item(properties.food(ModFoods.MARSHMALLOW, ModFoods.MARSHMALLOW_CONSUMABLE)));

    // Chocolate
    public static final DeferredItem<Item> CHOCOLATE = ITEMS.registerItem("chocolate",
            properties -> new Item(properties.food(ModFoods.CHOCOLATE, ModFoods.CHOCOLATE_CONSUMABLE)));

    // Biscuit
    public static final DeferredItem<Item> BISCUIT = ITEMS.registerItem("biscuit",
            properties -> new Item(properties.food(ModFoods.BISCUIT, ModFoods.BISCUIT_CONSUMABLE)));

    /* S'MORES */

    // S'more
    public static final DeferredItem<Item> SMORE = ITEMS.registerItem("smore",
            properties -> new Item(properties.food(ModFoods.SMORE, ModFoods.SMORE_CONSUMABLE)));

    // Burnt s'more
    public static final DeferredItem<Item> BURNT_SMORE = ITEMS.registerItem("burnt_smore",
            properties -> new Item(properties.food(ModFoods.BURNT_SMORE, ModFoods.BURNT_SMORE_CONSUMABLE)));

    // Flaming s'more
    public static final DeferredItem<Item> FLAMING_SMORE = ITEMS.registerItem("flaming_smore",
            properties -> new Item(properties.food(ModFoods.FLAMING_SMORE, ModFoods.FLAMING_SMORE_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

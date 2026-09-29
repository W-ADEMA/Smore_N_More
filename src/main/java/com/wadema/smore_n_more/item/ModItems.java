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

    // Non Edible item example:
    // public static final DeferredItem<Item> MARSHMALLOW = ITEMS.registerSimpleItem("marshmallow");

    // Marshmallow
    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.registerItem("marshmallow",
            properties -> new Item(properties.food(ModFoods.MARSHMALLOW, ModFoods.MARSHMALLOW_CONSUMABLE)));

    // Chocolate
    public static final DeferredItem<Item> CHOCOLATE = ITEMS.registerItem("chocolate",
            properties -> new Item(properties.food(ModFoods.CHOCOLATE, ModFoods.CHOCOLATE_CONSUMABLE)));

    // S'more
    public static final DeferredItem<Item> SMORE = ITEMS.registerItem("smore",
            properties -> new Item(properties.food(ModFoods.SMORE, ModFoods.SMORE_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

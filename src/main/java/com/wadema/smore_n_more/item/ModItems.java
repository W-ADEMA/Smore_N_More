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

    public static final DeferredItem<Item> MARSHMALLOW = ITEMS.registerSimpleItem("marshmallow");

    public static final DeferredItem<Item> SMORE = ITEMS.registerItem("smore",
            properties -> new Item(properties.food(ModFoods.SMORE, ModFoods.SMORE_CONSUMABLE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

package com.wadema.smore_n_more.creativemodetab;

import com.wadema.smore_n_more.SmoreNMore;
import com.wadema.smore_n_more.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SmoreNMore.MODID);

    public static final Supplier<CreativeModeTab> SMORE_ITEMS_TAB = CREATIVE_MODE_TABS.register("smore_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MARSHMALLOW.get()))
                    .title(Component.translatable("creativetab.smore_n_more.smore_items"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /* ITEMS */

                        output.accept(ModItems.MARSHMALLOW_ON_A_STICK);
                        output.accept(ModItems.ROASTED_MARSHMALLOW_ON_A_STICK);

                        /* INGREDIENTS */

                        output.accept(ModItems.MARSHMALLOW);
                        output.accept(ModItems.CHOCOLATE);
                        output.accept(ModItems.BISCUIT);

                        /* S'MORES */

                        output.accept(ModItems.EMPTY_SMORE);
                        output.accept(ModItems.SMORE);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

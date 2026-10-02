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
                    .title(Component.translatable("creativetab.smore_n_more.smore_items_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /* ITEMS */

                        output.accept(ModItems.MARSHMALLOW_ON_A_STICK);
                        output.accept(ModItems.ROASTED_MARSHMALLOW_ON_A_STICK);
                        output.accept(ModItems.BURNT_MARSHMALLOW_ON_A_STICK);

                        /* INGREDIENTS */

                        output.accept(ModItems.MARSHMALLOW);
                        output.accept(ModItems.CHOCOLATE);
                        output.accept(ModItems.BISCUIT);

                    }).build());

    public static final Supplier<CreativeModeTab> SMORES_TAB = CREATIVE_MODE_TABS.register("smores_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SMORE.get()))
                    .title(Component.translatable("creativetab.smore_n_more.smores_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        /* S'MORES */

                        output.accept(ModItems.SMORE);
                        output.accept(ModItems.BURNT_SMORE);
                        output.accept(ModItems.FLAMING_SMORE);
                        output.accept(ModItems.WET_SMORE);
                        output.accept(ModItems.GOLDEN_SMORE);
                        output.accept(ModItems.ENDER_SMORE);
                        output.accept(ModItems.FISHY_SMORE);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}

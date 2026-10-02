package com.wadema.smore_n_more;

import com.wadema.smore_n_more.datagen.ModModelProvider;
import com.wadema.smore_n_more.datagen.ModRecipeProvider;
import com.wadema.smore_n_more.datagen.ModItemTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = SmoreNMore.MODID)
public class SmoreNMoreDataGen {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new ModModelProvider(packOutput));
        generator.addProvider(true, new ModRecipeProvider.Runner(packOutput, lookupProvider));
        generator.addProvider(true, new ModItemTagsProvider(packOutput, lookupProvider));
    }
}

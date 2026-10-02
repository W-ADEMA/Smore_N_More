package com.wadema.smore_n_more.datagen;

import com.wadema.smore_n_more.SmoreNMore;
import com.wadema.smore_n_more.item.ModItems;
import com.wadema.smore_n_more.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, SmoreNMore.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(ModTags.Items.MARSHMALLOW_REPAIRABLE)
                .add(ModItems.MARSHMALLOW.get());

        tag(ItemTags.SWORDS).add(ModItems.MARSHMALLOW_SWORD.get());
    }
}

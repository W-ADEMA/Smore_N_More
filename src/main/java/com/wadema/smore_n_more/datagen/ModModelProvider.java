package com.wadema.smore_n_more.datagen;

import com.wadema.smore_n_more.SmoreNMore;
import com.wadema.smore_n_more.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, SmoreNMore.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        itemModels.generateFlatItem(ModItems.MARSHMALLOW.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SMORE.get(), ModelTemplates.FLAT_ITEM);
    }
}

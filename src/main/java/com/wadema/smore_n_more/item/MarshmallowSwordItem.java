package com.wadema.smore_n_more.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.extensions.IItemExtension;

public class MarshmallowSwordItem extends Item implements IItemExtension {

    public MarshmallowSwordItem(Properties properties) {
        super(properties);
    }

    @Override
    public boolean supportsEnchantment(
            ItemStack stack,
            Holder<Enchantment> enchantment
    ) {
        return enchantment.is(Enchantments.MENDING)
                || enchantment.is(Enchantments.UNBREAKING)
                || enchantment.is(Enchantments.SWEEPING_EDGE);
    }
}
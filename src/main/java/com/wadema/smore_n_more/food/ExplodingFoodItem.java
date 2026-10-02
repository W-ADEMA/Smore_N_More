package com.wadema.smore_n_more.food;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ExplodingFoodItem extends Item {

    public ExplodingFoodItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack result = super.finishUsingItem(stack, level, entity);

        if (!level.isClientSide()) {
            level.explode(
                    entity,
                    entity.getX(),
                    entity.getY(),
                    entity.getZ(),
                    4.0F,
                    Level.ExplosionInteraction.TNT
            );
        }

        return result;
    }
}
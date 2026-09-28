package com.wadema.smore_n_more.food;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {
    public static final FoodProperties SMORE = new FoodProperties.Builder().nutrition(6).saturationModifier(1.2f).build();

    public static final Consumable SMORE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100))).build();
}

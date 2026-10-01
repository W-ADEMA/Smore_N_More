package com.wadema.smore_n_more.food;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

public class ModFoods {

    /* INGREDIENTS */

    // Marshmallow
    public static final FoodProperties MARSHMALLOW = new FoodProperties.Builder().nutrition(3).saturationModifier(1.2f).build();
    public static final Consumable MARSHMALLOW_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1).build();

    // Chocolate
    public static final FoodProperties CHOCOLATE = new FoodProperties.Builder().nutrition(3).saturationModifier(1.2f).build();
    public static final Consumable CHOCOLATE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1).build();

    // Biscuit
    public static final FoodProperties BISCUIT = new FoodProperties.Builder().nutrition(3).saturationModifier(1.2f).build();
    public static final Consumable BISCUIT_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(1).build();

    /* S'MORES */

    // S'more
    public static final FoodProperties SMORE = new FoodProperties.Builder().nutrition(6).saturationModifier(1.2f).build();
    public static final Consumable SMORE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2).build();

    // Burnt s'more
    public static final FoodProperties BURNT_SMORE = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
    public static final Consumable BURNT_SMORE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.NAUSEA, 200))).build(); // 10 seconds

    // Burnt s'more
    public static final FoodProperties FLAMING_SMORE = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
    public static final Consumable FLAMING_SMORE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400))).build(); // 120 seconds

    // Wet s'more
    public static final FoodProperties WET_SMORE = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
    public static final Consumable WET_SMORE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2).onConsume(new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2400))).build(); // 120 seconds

    // Golden s'more
    public static final FoodProperties GOLDEN_SMORE = new FoodProperties.Builder().nutrition(1).saturationModifier(1).build();
    public static final Consumable GOLDEN_SMORE_CONSUMABLE = Consumables.defaultFood()
            .consumeSeconds(2)
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.REGENERATION, 200, 1) // 10 seconds
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.RESISTANCE, 3000, 0) // 150 seconds
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000, 0) // 150 seconds
            ))
            .onConsume(new ApplyStatusEffectsConsumeEffect(
                    new MobEffectInstance(MobEffects.ABSORPTION, 1200, 3) // 60 seconds
            )).build();
}

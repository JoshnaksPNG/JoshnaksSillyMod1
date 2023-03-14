package net.joshnaks.silly1.item;

import net.joshnaks.silly1.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents
{
    public static final FoodComponent REAL_HAND = (new FoodComponent.Builder()).hunger(1).saturationModifier(0.8F).build();

    public static final FoodComponent IRON_APPLE = (new FoodComponent.Builder()).hunger(0).saturationModifier(-0.3F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 1000, 3), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 1000, 3), 1.0F).alwaysEdible().build();

    public static final FoodComponent PERC_THIRTY = (new FoodComponent.Builder()).hunger(0).saturationModifier(-0.3F).statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 600, 100), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 3), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 3), 1.0F).statusEffect(new StatusEffectInstance(ModEffects.Perced, 600, 3), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 1), 1.0F).alwaysEdible().build();

    public static final FoodComponent ROAST_FLOWER = (new FoodComponent.Builder()).hunger(0).saturationModifier(2.3F).statusEffect(new StatusEffectInstance(ModEffects.FireTrail, 600, 0), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600, 1), 1.0F).alwaysEdible().build();

    public static final FoodComponent DECAYING_FLESH = (new FoodComponent.Builder()).hunger(5).saturationModifier(-0.3F).statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600, 1), 1.0F).statusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 2), 1.0F).statusEffect(new StatusEffectInstance(ModEffects.HuskSlaveSpawn, 1, 1), 1.0F).alwaysEdible().build();

}

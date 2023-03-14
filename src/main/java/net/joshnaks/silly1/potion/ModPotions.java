package net.joshnaks.silly1.potion;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions
{
    public static Potion EINSTEIN_POTION = Registry.register(Registries.POTION, new Identifier(SillyMod1.MOD_ID, "einstein"),
            new Potion(new StatusEffectInstance(ModEffects.Einstein, 201, 0),
                    new StatusEffectInstance(StatusEffects.LEVITATION, 200, 1),
                    new StatusEffectInstance(StatusEffects.NIGHT_VISION, 200, 255)));

    public static Potion registerPotion (String name, StatusEffect statusEffect, int duration, int amp)
    {
        return Registry.register(Registries.POTION, new Identifier(SillyMod1.MOD_ID, name),
                new Potion(new StatusEffectInstance(statusEffect, duration, amp) ));
    }

    public static void registerModPotions()
    {
        SillyMod1.LOGGER.debug("Registering Mod Potions for " + SillyMod1.MOD_ID);
    }
}

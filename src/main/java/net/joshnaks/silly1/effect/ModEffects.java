package net.joshnaks.silly1.effect;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.effect.custom.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects
{
    public static final StatusEffect Perced = registerEffects(new PercedEffect(), "perced");
    public static final StatusEffect Einstein = registerEffects(new EinsteinEffect(), "einstein");

    public static final StatusEffect FireTrail = registerEffects(new FiretrailEffect(), "fire_trail");

    public static final StatusEffect HuskSlaveSpawn = registerEffects(new HuskSlaveSpawnEffect(), "husk_slave_spawn");

    public static final StatusEffect Freddied = registerEffects(new FreddiedEffect(), "freddied");

    public static final StatusEffect Oiled = registerEffects(new CoveredInOilEffect(), "oiled");

    private static StatusEffect registerEffects(StatusEffect statusEffect, String name)
    {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(SillyMod1.MOD_ID, name),
                statusEffect);
    }

    public static void registerModEffects()
    {
        SillyMod1.LOGGER.debug("Registering Mod Effects for " + SillyMod1.MOD_ID);
    }
}

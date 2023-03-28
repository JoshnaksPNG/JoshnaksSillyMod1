package net.joshnaks.silly1.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities
{
    public static final EntityType<IncompetentCreeper> INCOMPETENT_CREEPER = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "incompetent_creeper"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, IncompetentCreeper::new).dimensions(EntityDimensions.fixed(0.75f, 2f)).build()
    );

    public static final EntityType<TrollfaceEntity> TROLLFACE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "trollface"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TrollfaceEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2f)).build()
    );

    public static final EntityType<CursedVillagerEntity> CURSED_VILLAGER = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "cursed_villager"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, CursedVillagerEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2f)).build()
    );

    public static final EntityType<CannonProjectile> CANNON_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "cannon_projectile"),
            FabricEntityTypeBuilder.<CannonProjectile>create(SpawnGroup.MISC, CannonProjectile::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<NaughtigenProjectile> NAUGHTIGEN_PROJECTILE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "naughtigen_projectile"),
            FabricEntityTypeBuilder.<NaughtigenProjectile>create(SpawnGroup.MISC, NaughtigenProjectile::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static final EntityType<TinyMarioEntity> TINY_MARIO = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "tiny_mario"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, TinyMarioEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2f)).build()
    );

    public static final EntityType<HuskSlaveEntity> HUSK_SLAVE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "husk_slave"),
            FabricEntityTypeBuilder.<HuskSlaveEntity>create(SpawnGroup.MISC, HuskSlaveEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2f)).build()
    );

    public static final EntityType<PiglinSlaveEntity> PIGLIN_SLAVE = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(SillyMod1.MOD_ID, "piglin_slave"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, PiglinSlaveEntity::new).dimensions(EntityDimensions.fixed(0.75f, 2f)).build()
    );

    public static void registerModEntities()
    {
        SillyMod1.LOGGER.debug("Registering Mod Entities for " + SillyMod1.MOD_ID);
    }

}

package net.joshnaks.silly1.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.joshnaks.silly1.entity.ModEntities;
import net.minecraft.entity.SpawnGroup;

public class ModEntitySpawn {
    public static void addEntitySpawn()
    {
        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, ModEntities.TROLLFACE,
                25, 1, 3);

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.MONSTER, ModEntities.INCOMPETENT_CREEPER,
                25, 1, 1);

        BiomeModifications.addSpawn(BiomeSelectors.foundInOverworld(), SpawnGroup.CREATURE, ModEntities.TINY_MARIO,
                25, 1, 1);
    }
}

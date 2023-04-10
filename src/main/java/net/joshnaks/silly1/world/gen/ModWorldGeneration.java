package net.joshnaks.silly1.world.gen;

import net.joshnaks.silly1.world.ModFlowerGeneration;

public class ModWorldGeneration
{
    public static void generateModWorldGen()
    {
        ModOreGeneration.generateOres();
        ModEntitySpawn.addEntitySpawn();
        //ModFlowerGeneration.generateFlowers();
    }
}

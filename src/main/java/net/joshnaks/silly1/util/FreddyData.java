package net.joshnaks.silly1.util;

import net.minecraft.nbt.NbtCompound;

public class FreddyData
{
    public static void setFreddy(IEntityDataSaver player, boolean isFreddy)
    {
        NbtCompound nbtCompound = player.getPersistentData();

        nbtCompound.putBoolean("Freddy", isFreddy);

        
    }
}

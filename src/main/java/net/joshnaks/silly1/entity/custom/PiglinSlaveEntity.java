package net.joshnaks.silly1.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.world.World;

public class PiglinSlaveEntity extends PiglinEntity
{
    public PiglinSlaveEntity(EntityType<? extends AbstractPiglinEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void attack(LivingEntity target, float pullProgress) {

    }
}

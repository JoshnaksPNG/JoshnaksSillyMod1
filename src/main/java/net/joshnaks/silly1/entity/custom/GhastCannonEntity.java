package net.joshnaks.silly1.entity.custom;

import net.joshnaks.silly1.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class GhastCannonEntity extends FireballEntity
{
    public GhastCannonEntity(World world, LivingEntity owner, double velocityX, double velocityY, double velocityZ, int explosionPower) {
        super(world, owner, velocityX, velocityY, velocityZ, explosionPower);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        if( holdingCannon(entityHitResult.getEntity().getHandItems()) )
        {
            Entity entity = entityHitResult.getEntity();
            entity.world.createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 10f, World.ExplosionSourceType.NONE);
        }
    }

    private boolean holdingCannon(Iterable<ItemStack> stacks)
    {
        for ( ItemStack stack : stacks )
        {
            if(stack.getItem().equals(ModItems.Ghast_Cannon))
            {
                return true;
            }
        }

        return false;
    }
}

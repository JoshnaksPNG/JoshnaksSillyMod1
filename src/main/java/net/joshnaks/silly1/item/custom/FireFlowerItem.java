package net.joshnaks.silly1.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FireFlowerItem extends Item
{
    public FireFlowerItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        if(!world.isClient)
        {
            double yaw = user.getHeadYaw() * 0.017453292F;

            SmallFireballEntity fireball = new SmallFireballEntity(world, user, 0.0F, 0.0F, 0.0F);
            fireball.setVelocity(user, user.getPitch(), user.getHeadYaw(), 0.0F, 3.0F, 0.0F);
            fireball.setPos(user.getX() - Math.sin(yaw), user.getY() + 1.5F, user.getZ() + Math.cos(yaw));

            world.spawnEntity(fireball);
        }


        return super.use(world, user, hand);
    }
}


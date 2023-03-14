package net.joshnaks.silly1.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.world.World;

public class GoldShieldItem extends ShieldItem
{

    public GoldShieldItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity instanceof LivingEntity livingEntity)
        {
            if(livingEntity.isHolding(this))
            {
                livingEntity.damageShield(3f);
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }
}

package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MetalMarioCapItem extends ArmorItem
{

    public MetalMarioCapItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(entity instanceof LivingEntity livingEntity)
        {
            if(entityIsWearing(livingEntity))
            {
                int d = getMaxDamage();
                livingEntity.damageHelmet(new DamageSource("metal_mario"), 0.3f);
            }
        }
    }

    private boolean entityIsWearing(LivingEntity player)
    {
        for( ItemStack stack : player.getArmorItems() )
        {
            if(stack.getItem() == ModItems.Metal_Mario_Cap)
            {
                return true;
            }
        }

        return false;
    }
}

package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LuigiArmorItem extends ArmorItem
{

    public LuigiArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(entity instanceof LivingEntity livingEntity)
        {
            if(entityIsWearing(livingEntity))
            {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST));
            } else
            {
                if(livingEntity.hasStatusEffect(StatusEffects.JUMP_BOOST))
                {
                    livingEntity.removeStatusEffect(StatusEffects.JUMP_BOOST);
                }
            }
        }
    }

    private boolean entityIsWearing(LivingEntity player)
    {
        for( ItemStack stack : player.getArmorItems() )
        {
            if(!isLuigiItem(stack.getItem()))
            {
                return false;
            }
        }

        return true;
    }

    private boolean isLuigiItem(Item item)
    {
        return item == ModItems.Luigite_Boots || item == ModItems.Luigite_Leggings || item == ModItems.Luigite_Chestplate || item == ModItems.Luigite_Helmet;
    }
}

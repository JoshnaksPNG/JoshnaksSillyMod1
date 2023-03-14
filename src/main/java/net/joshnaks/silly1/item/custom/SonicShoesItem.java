package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.item.ModItems;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import net.minecraft.world.World;

public class SonicShoesItem extends ArmorItem
{


    public SonicShoesItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(entity instanceof PlayerEntity player)
        {
            if(playerIsWearing(player))
            {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 50));



            } else
            {
                player.removeStatusEffect(StatusEffects.SPEED);
            }
        }
    }

    @Override
    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        player.removeStatusEffect(StatusEffects.SPEED);
        return super.onClicked(stack, otherStack, slot, clickType, player, cursorStackReference);
    }

    private boolean playerIsWearing(PlayerEntity player)
    {
        for( ItemStack stack : player.getArmorItems() )
        {
            if(stack.getItem() == ModItems.Sonic_Shoes)
            {
                return true;
            }
        }

        return false;
    }
}

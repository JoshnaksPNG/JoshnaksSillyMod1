package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TatteredArmorItem extends ArmorItem
{
    public TatteredArmorItem(ArmorMaterial material, EquipmentSlot slot, Settings settings)
    {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(entity instanceof PlayerEntity player && inArmorSlot(player))
        {
            player.getInventory().damageArmor(DamageSource.CACTUS, 1, PlayerInventory.ARMOR_SLOTS);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean inArmorSlot(PlayerEntity player)
    {
        for( ItemStack stack : player.getArmorItems() )
        {
            if(stack.getItem() == ModItems.Freddy_Mask)
            {
                return true;
            }
        }

        return false;
    }
}

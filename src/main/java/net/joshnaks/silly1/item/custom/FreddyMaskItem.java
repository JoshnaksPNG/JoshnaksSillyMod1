package net.joshnaks.silly1.item.custom;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.joshnaks.silly1.effect.ModEffects;
import net.joshnaks.silly1.item.ModItems;
import net.joshnaks.silly1.networking.ModMessages;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class FreddyMaskItem extends ArmorItem
{

    public FreddyMaskItem(ArmorMaterial material, EquipmentSlot slot, Settings settings)
    {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(entity instanceof PlayerEntity player)
        {
            if(entityIsWearing(player))
            {
                player.addStatusEffect(new StatusEffectInstance(ModEffects.Freddied, 1));
            }

        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean entityIsWearing(LivingEntity player)
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

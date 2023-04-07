package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.item.ModItems;
import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

public class MetalMarioCapItem extends ArmorItem
{
    private boolean playingMusic = false;

    public MetalMarioCapItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);

        playingMusic = false;
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(entity instanceof LivingEntity livingEntity)
        {
            if(entityIsWearing(livingEntity))
            {
                int d = getMaxDamage();
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 1, 3));
                livingEntity.damageHelmet(new DamageSource("metal_mario"), 1.0f);

                if(!playingMusic)
                {
                    if(livingEntity instanceof PlayerEntity player)
                    {
                        livingEntity.world.playSoundFromEntity(player, player, ModSoundEvents.METAL_MARIO, SoundCategory.MUSIC, 1f, 1f);
                        playingMusic = true;
                    }else
                    {

                    }
                }


            } else
            {
                livingEntity.removeStatusEffect(StatusEffects.SLOWNESS);
                playingMusic = false;
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

package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.item.ModItems;
import net.minecraft.block.AirBlock;
import net.minecraft.block.Blocks;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.ArrayList;

import static java.lang.Math.sqrt;

public class SonicShoesItem extends ArmorItem
{


    public SonicShoesItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(entity instanceof PlayerEntity player && !world.isClient())
        {
            if(playerIsWearing(player))
            {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1, 50));

                Vec3d velocity = player.getVelocity();

                double flatSpeed = sqrt((velocity.getX() * velocity.getX()) + (velocity.getZ() * velocity.getZ()));

                if(true)
                {
                    int xD = 0;
                    int zD = 0;

                    if(velocity.getX() > 0)
                    {
                        xD = 1;
                    } else if(velocity.getX() < 0)
                    {
                        xD = -1;
                    }

                    if(velocity.getZ() > 0)
                    {
                        zD = 1;
                    } else if(velocity.getZ() < 0)
                    {
                        zD = -1;
                    }

                    BlockPos plr = player.getBlockPos();
                    ArrayList<BlockPos> posList = new ArrayList<>();
                    posList.add(new BlockPos(plr.getX() + xD, plr.getY(), plr.getZ()));
                    posList.add(new BlockPos(plr.getX(), plr.getY(), plr.getZ() + zD));
                    posList.add(new BlockPos(plr.getX() + xD, plr.getY(), plr.getZ() + zD));

                    posList.add(new BlockPos(plr.getX() + xD, plr.getY()+1, plr.getZ()));
                    posList.add(new BlockPos(plr.getX(), plr.getY()+1, plr.getZ() + zD));
                    posList.add(new BlockPos(plr.getX() + xD, plr.getY()+1, plr.getZ() + zD));

                    for(int i = 0; i < posList.size(); ++i)
                    {
                        if(world.getBlockState(posList.get(i)) != Blocks.AIR.getDefaultState())
                        {
                            world.breakBlock(posList.get(i), true);
                        }
                    }
                }


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

package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.entity.custom.GhastCannonEntity;
import net.joshnaks.silly1.entity.custom.NaughtigenProjectile;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GhastCannonItem extends BowItem
{
    private boolean charged = false;

    public GhastCannonItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        ItemStack itemStack = user.getStackInHand(hand);
        if(!isCharged(itemStack))
        {
            this.charged = false;
            user.setCurrentHand(hand);
        }


        return super.use(world, user, hand);
    }

    public static boolean isCharged(ItemStack stack) {
        NbtCompound nbtCompound = stack.getNbt();
        return nbtCompound != null && nbtCompound.getBoolean("Charged");
    }

    public static void setCharged(ItemStack stack, boolean charged) {
        NbtCompound nbtCompound = stack.getOrCreateNbt();
        nbtCompound.putBoolean("Charged", charged);
    }

    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks) {
        int i = this.getMaxUseTime(stack) - remainingUseTicks;
        float f = getPullProgress(i);
        if (f >= 1.0F && !isCharged(stack))
        {
            if(!world.isClient)
            {
                double yaw = user.getHeadYaw() * 0.017453292F;

                GhastCannonEntity projectileEntity = new GhastCannonEntity(world, user, 0f, 0f, 0f, 3);
                projectileEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 0.0F);
                projectileEntity.setPos(user.getX() - Math.sin(yaw), user.getY() + 1.5F, user.getZ() + Math.cos(yaw));

                world.spawnEntity(projectileEntity);
            }
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);


    }
}

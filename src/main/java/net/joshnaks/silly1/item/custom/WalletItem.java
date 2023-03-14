package net.joshnaks.silly1.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WalletItem extends BundleItem {

    boolean deez = false;
    boolean dropWallet = false;
    BlockPos pos = new BlockPos(0,0,0);

    public WalletItem(Settings settings) {
        super(settings);
    }


    @Override
    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        pos = player.getBlockPos();
        return super.onStackClicked(stack, slot, clickType, player);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if(deez)
        {
            if(dropWallet)
            {
                stack.decrement(1);
                dropWallet = false;
                deez = false;
            }
            else
            {
                dropWallet = true;
            }
        }


        if(entity instanceof PlayerEntity player)
        {
            if(player.getMainHandStack() == stack)
            {
                pos = player.getBlockPos();
            }

            if(!pos.isWithinDistance(player.getBlockPos(), 5) && !deez && !dropWallet)
            {
                player.dropItem(stack, true, true);
                deez = true;
            }
        }

    }
}

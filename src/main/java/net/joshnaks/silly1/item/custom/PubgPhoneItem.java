package net.joshnaks.silly1.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Predicate;

public class PubgPhoneItem extends Item
{
    public PubgPhoneItem(Settings settings)
    {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient() && (hand == hand.MAIN_HAND || hand == hand.OFF_HAND) )
        {
            boolean has_diamonds = RemoveAllDiamonds(user);

            if (has_diamonds)
            {
                user.sendMessage(Text.literal("<Tencent> Transaction Complete"));
            } else
            {
                user.sendMessage(Text.literal("<Tencent> Transaction Invalid"));
            }

            user.getItemCooldownManager().set(this, 20);
        }

        return super.use(world, user, hand);
    }

    private boolean RemoveAllDiamonds(PlayerEntity user)
    {
        Inventory inv = user.getInventory();
        boolean has_diamonds = false;

        for(int i = 0; i < inv.size(); ++i)
        {
            ItemStack stack = inv.getStack(i);

            if(stack.getItem() == Items.DIAMOND)
            {
                stack.setCount(0);
                has_diamonds = true;
            }
        }

        return has_diamonds;
    }
}

package net.joshnaks.silly1.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WildcardPickItem extends PickaxeItem
{

    public WildcardPickItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner)
    {
        NbtCompound nbtCompound;

        if(stack.hasNbt())
        {
            nbtCompound = stack.getNbt();
        } else
        {
            nbtCompound = new NbtCompound();
        }

        if(!nbtCompound.getKeys().contains("Block"))
        {
            nbtCompound.putInt("Block", Block.getRawIdFromState(state));
        }

        stack.setNbt(nbtCompound);

        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state)
    {
        if(stack.hasNbt())
        {
            if(stack.getNbt().getKeys().contains("Block"))
            {
                if(state.getBlock().equals(Block.getStateFromRawId(stack.getNbt().getInt("Block")).getBlock()))
                {
                    return 100f;
                } else
                {
                    return -0.1f;
                }
            }
        }

        return super.getMiningSpeedMultiplier(stack, state);
    }
}

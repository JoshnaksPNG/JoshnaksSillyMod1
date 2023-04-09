package net.joshnaks.silly1.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UltraPickItem extends PickaxeItem
{
    public UltraPickItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

        for(int i = 0; i < 7; ++i)
        {
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), state.getBlock().asItem().getDefaultStack()));
        }

        return super.postMine(stack, world, state, pos, miner);
    }
}

package net.joshnaks.silly1.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LegoBlock extends CarpetBlock
{
    public LegoBlock(Settings settings)
    {
        super(settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity)
    {
        if(entity instanceof LivingEntity livingEntity)
        {
            livingEntity.damage(DamageSource.CACTUS, 9999.0f);
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {

        if(entity instanceof LivingEntity livingEntity)
        {
            livingEntity.damage(DamageSource.CACTUS, 9999.0f);
        }
        super.onLandedUpon(world, state, pos, entity, fallDistance);
    }

    @Override
    public void onEntityLand(BlockView world, Entity entity) {
        if(entity instanceof LivingEntity livingEntity)
        {
            livingEntity.damage(DamageSource.CACTUS, 9999.0f);
        }
        super.onEntityLand(world, entity);
    }


}

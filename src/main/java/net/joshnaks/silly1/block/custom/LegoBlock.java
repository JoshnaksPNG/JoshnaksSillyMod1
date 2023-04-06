package net.joshnaks.silly1.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class LegoBlock extends GlassBlock
{
    public LegoBlock(Settings settings)
    {
        super(settings);
    }

    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 4.0, 16.0);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        entity.damage(DamageSource.CACTUS, 9999.0F);
    }

    /*@Override
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

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        List<Entity> entities = world.getOtherEntities(null, new Box(pos));

        for( Entity entity : entities )
        {
            if(entity instanceof LivingEntity livingEntity)
            {
                livingEntity.damage(DamageSource.CACTUS, 9999.0f);
            }
        }

        super.randomDisplayTick(state, world, pos, random);
    }*/
}

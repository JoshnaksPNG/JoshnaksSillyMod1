package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.entity.ModEntities;
import net.joshnaks.silly1.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class ScepterItem extends Item
{

    private Box box;

    private double radius = 32d;

    public ScepterItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected)
    {
        if(holdingThis(entity))
        {
            updateBox(entity.getBlockPos());

            List<Entity> entities = world.getOtherEntities(entity, box);

            for(Entity e : entities)
            {
                if(e instanceof PiglinEntity piglinEntity)
                {
                    piglinEntity.convertTo(ModEntities.PIGLIN_SLAVE, true);
                }
            }
        }

        super.inventoryTick(stack, world, entity, slot, selected);
    }

    public boolean holdingThis(Entity entity)
    {
        if(entity instanceof LivingEntity)
        {
            for(ItemStack stack : entity.getHandItems())
            {
                if(stack.getItem() == ModItems.Scepter)
                {
                    return true;
                }
            }
        }

        return false;
    }

    public void updateBox(BlockPos pos)
    {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();


        box = new Box(x + radius, y + radius, z + radius, x- radius, y - radius, z - radius);
    }
}

package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ChorusFruitItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class ClarinetItem extends Item {

    public ClarinetItem(Settings settings) {
        super(settings);
    }

    private Box box;

    private double radius = 16d;

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)
    {
        updateBox(user.getBlockPos());

        List<Entity> entities = world.getOtherEntities(user, box);

        for( Entity entity : entities )
        {
            if(entity instanceof LivingEntity livingEntity)
            {
                livingEntity.kill();
            }
        }

        world.playSound(null, user.getBlockPos(), ModSoundEvents.CLARINET_EVENT, SoundCategory.PLAYERS, 1f, 1f);

        user.getItemCooldownManager().set(this, 100);

        return super.use(world, user, hand);
    }



    public void updateBox(BlockPos pos)
    {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();


        box = new Box(x + radius, y + radius, z + radius, x- radius, y - radius, z - radius);
    }
}

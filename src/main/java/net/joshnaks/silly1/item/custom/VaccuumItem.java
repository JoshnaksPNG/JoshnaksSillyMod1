package net.joshnaks.silly1.item.custom;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.block.JukeboxBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.function.Consumer;

public class VaccuumItem extends Item
{
    public VaccuumItem(Settings settings) {
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
                Vec3d vector = new Vec3d(
                        user.getX() - livingEntity.getX(),
                        user.getY() - livingEntity.getY(),
                        user.getZ() - livingEntity.getZ()
                );

                if(vector.length() < 2.5)
                {
                    livingEntity.kill();
                } else
                {
                    double length = vector.length() * 2;

                    vector.getX();

                    Vec3d usedVector = new Vec3d(
                            vector.getX() / length,
                            vector.getY() / length,
                            vector.getZ() / length
                    );

                    livingEntity.setVelocity(usedVector);
                }
            }

            if(entity instanceof ItemEntity itemEntity)
            {
                Vec3d vector = new Vec3d(
                        user.getX() - itemEntity.getX(),
                        user.getY() - itemEntity.getY(),
                        user.getZ() - itemEntity.getZ()
                );

                double length = vector.length() * 0.75;

                vector.getX();

                Vec3d usedVector = new Vec3d(
                        vector.getX() / length,
                        vector.getY() / length,
                        vector.getZ() / length
                );

                itemEntity.setVelocity(usedVector);

            }
        }


        world.playSound(null, user.getBlockPos(), ModSoundEvents.VACUUM_EVENT, SoundCategory.PLAYERS, 0.75f, 1f);

        if(user.getMainHandStack().getItem().equals(this))
        {
            user.getMainHandStack().damage(1, user, new Consumer<PlayerEntity>() {
                @Override
                public void accept(PlayerEntity player) {

                }
            });
        }

        user.getMainHandStack();
        user.getOffHandStack();

        return super.use(world, user, hand);
    }

    @Override
    public void onStoppedUsing(ItemStack stack, World world, LivingEntity user, int remainingUseTicks)
    {
        //world.playSound(null, user.getBlockPos(), ModSoundEvents.VACUUM_OFF_EVENT, SoundCategory.PLAYERS, 1f, 1f);
        super.onStoppedUsing(stack, world, user, remainingUseTicks);
    }

    public void updateBox(BlockPos pos)
    {
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();


        box = new Box(x + radius, y + radius, z + radius, x- radius, y - radius, z - radius);
    }
}

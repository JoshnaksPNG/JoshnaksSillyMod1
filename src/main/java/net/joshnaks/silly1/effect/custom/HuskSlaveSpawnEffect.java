package net.joshnaks.silly1.effect.custom;

import net.joshnaks.silly1.entity.custom.HuskSlaveEntity;
import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class HuskSlaveSpawnEffect extends StatusEffect
{

    public HuskSlaveSpawnEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, 0xFFACAC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }


    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity player)
        {
            BlockPos pos = new BlockPos(player.getBlockPos().getX(), player.getBlockPos().getY() + 1, player.getBlockPos().getZ());

            player.world.spawnEntity(new HuskSlaveEntity(player.world, player, pos));
        }
    }
}

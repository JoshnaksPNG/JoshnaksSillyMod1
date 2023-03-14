package net.joshnaks.silly1.effect.custom;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.block.AbstractFireBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

public class FiretrailEffect extends StatusEffect
{

    public FiretrailEffect()
    {
        super(StatusEffectCategory.NEUTRAL, 0xFF8800);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier)
    {
        World w = entity.getEntityWorld();
        if(w.canSetBlock(entity.getBlockPos()) && !w.isClient())
        {
            w.setBlockState(entity.getBlockPos(), AbstractFireBlock.getState(w, entity.getBlockPos()));
        }
    }
}

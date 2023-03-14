package net.joshnaks.silly1.effect.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;

public class CoveredInOilEffect extends StatusEffect
{

    public CoveredInOilEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xCCCC00);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if(entity.getWorld().isRaining())
        {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 2, amplifier));
        }

        BlockPos pos = entity.getBlockPos();

        if(entity.world.getBlockState(pos).equals(Blocks.WATER.getDefaultState()))
        {
            entity.setVelocity(entity.getVelocity().x, 6, entity.getVelocity().z);
        }

        if(entity.isOnFire())
        {
            entity.damage(DamageSource.ON_FIRE, 9999);
        }

    }
}

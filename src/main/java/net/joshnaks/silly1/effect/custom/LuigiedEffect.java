package net.joshnaks.silly1.effect.custom;

import net.joshnaks.silly1.effect.ModEffects;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.math.BlockPos;

public class LuigiedEffect extends StatusEffect
{

    public LuigiedEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x00CC00);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        if(!entity.hasStatusEffect(StatusEffects.JUMP_BOOST))
        {
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1000, 1));
        }

        if(!entity.hasStatusEffect(ModEffects.WaterWalk))
        {
            entity.addStatusEffect(new StatusEffectInstance(ModEffects.WaterWalk, 1000, 1));
        }



    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {

        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1000, 1));
        entity.addStatusEffect(new StatusEffectInstance(ModEffects.WaterWalk, 1000, 1));

        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier)
    {
        entity.removeStatusEffect(ModEffects.WaterWalk);
        entity.removeStatusEffect(StatusEffects.JUMP_BOOST);

        super.onRemoved(entity, attributes, amplifier);
    }
}

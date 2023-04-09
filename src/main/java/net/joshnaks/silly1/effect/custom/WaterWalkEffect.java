package net.joshnaks.silly1.effect.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.util.math.BlockPos;

public class WaterWalkEffect extends StatusEffect
{

    public WaterWalkEffect() {
        super(StatusEffectCategory.NEUTRAL, 0x0000CC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {

        BlockPos pos = entity.getBlockPos();
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());

        double hVelocity = Math.sqrt((entity.getVelocity().x * entity.getVelocity().x) + (entity.getVelocity().z * entity.getVelocity().z));

        if( entity.world.getBlockState(pos).equals(Blocks.WATER.getDefaultState()) || entity.isSubmergedInWater())
        {
            if(hVelocity > 0.02)
            {
                if(entity.getVelocity().getY() < 0d)
                {
                    entity.setVelocity(entity.getVelocity().x, 0.2, entity.getVelocity().z);
                }
            }
            //entity.setVelocity(entity.getVelocity().x * 1.2, entity.getVelocity().y, entity.getVelocity().z * 1.2);
        }

    }
}

package net.joshnaks.silly1.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;

public class ForgetStick extends SwordItem
{

    public ForgetStick(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 600, 255));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 10));
        return super.postHit(stack, target, attacker);
    }
}

package net.joshnaks.silly1.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RealHandItem extends SwordItem
{

    public RealHandItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        double knockback_x = attacker.getX() - target.getX();
        double knockback_z = attacker.getZ() - target.getZ();
        target.takeKnockback(200.0F, knockback_x, knockback_z);



        return super.postHit(stack, target, attacker);
    }
}

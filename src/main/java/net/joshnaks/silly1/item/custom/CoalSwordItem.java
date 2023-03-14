package net.joshnaks.silly1.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class CoalSwordItem extends SwordItem
{

    public CoalSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if(target.getHealth() <= 0f)
        {
            //target.setOnFire(true);
            //target.setHealth(1f);
        }
        return super.postHit(stack, target, attacker);
    }


}

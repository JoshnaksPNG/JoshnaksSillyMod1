package net.joshnaks.silly1.item.custom;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.ZombieVillagerEntity;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.village.TradeOfferList;

public class EmeraldSwordItem extends SwordItem {
    public EmeraldSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings)
    {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker)
    {
        if( target instanceof ZombieVillagerEntity zombieVillagerEntity)
        {
            if (!zombieVillagerEntity.world.isClient)
            {
                //zombieVillagerEntity.convertTo(EntityType.VILLAGER, false);
                convert_villager(zombieVillagerEntity.getServer().getOverworld(), zombieVillagerEntity);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    private void convert_villager (ServerWorld world, ZombieVillagerEntity zombieVillagerEntity)
    {
        VillagerEntity villagerEntity = (VillagerEntity)zombieVillagerEntity.convertTo(EntityType.VILLAGER, false);
        EquipmentSlot[] var3 = EquipmentSlot.values();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            EquipmentSlot equipmentSlot = var3[var5];
            ItemStack itemStack = zombieVillagerEntity.getEquippedStack(equipmentSlot);
            if (!itemStack.isEmpty()) {
                if (EnchantmentHelper.hasBindingCurse(itemStack))
                {
                    villagerEntity.getStackReference(equipmentSlot.getEntitySlotId() + 300).set(itemStack);
                } else
                {
                    zombieVillagerEntity.dropStack(itemStack);
                }
            }
        }

        villagerEntity.initialize(world, world.getLocalDifficulty(villagerEntity.getBlockPos()), SpawnReason.CONVERSION, (EntityData)null, (NbtCompound)null);
        villagerEntity.reinitializeBrain(world);

        villagerEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
        if (!zombieVillagerEntity.isSilent()) {
            world.syncWorldEvent((PlayerEntity)null, 1027, zombieVillagerEntity.getBlockPos(), 0);
        }
    }
}

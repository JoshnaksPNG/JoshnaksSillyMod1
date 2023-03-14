package net.joshnaks.silly1.item;

import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ModToolMaterials
{
    public static class ParrotToolMaterial implements ToolMaterial
    {
        public static final ParrotToolMaterial INSTANCE = new ParrotToolMaterial();

        @Override
        public int getDurability()
        {
            return 30;
        }

        @Override
        public float getMiningSpeedMultiplier()
        {
            return 1.0F;
        }

        @Override
        public float getAttackDamage()
        {
            return 0F;
        }

        @Override
        public int getMiningLevel()
        {
            return 1;
        }

        @Override
        public int getEnchantability()
        {
            return 0;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.FEATHER);
        }
    }

    public static class CoalToolMaterial implements ToolMaterial
    {
        public static final ParrotToolMaterial INSTANCE = new ParrotToolMaterial();

        @Override
        public int getDurability()
        {
            return 130;
        }

        @Override
        public float getMiningSpeedMultiplier()
        {
            return 1.0F;
        }

        @Override
        public float getAttackDamage()
        {
            return 0F;
        }

        @Override
        public int getMiningLevel()
        {
            return 1;
        }

        @Override
        public int getEnchantability()
        {
            return 5;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.COAL);
        }
    }

    public static class HandMaterial implements ToolMaterial
    {
        public static final ParrotToolMaterial INSTANCE = new ParrotToolMaterial();

        @Override
        public int getDurability()
        {
            return 450;
        }

        @Override
        public float getMiningSpeedMultiplier()
        {
            return 1.0F;
        }

        @Override
        public float getAttackDamage()
        {
            return 0F;
        }

        @Override
        public int getMiningLevel()
        {
            return 1;
        }

        @Override
        public int getEnchantability()
        {
            return 0;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.ROTTEN_FLESH);
        }
    }

    public static class EmeraldMaterial implements ToolMaterial
    {
        public static final EmeraldMaterial INSTANCE = new EmeraldMaterial();

        @Override
        public int getDurability()
        {
            return 1561;
        }

        @Override
        public float getMiningSpeedMultiplier()
        {
            return 8.0F;
        }

        @Override
        public float getAttackDamage()
        {
            return 0.0F;
        }

        @Override
        public int getMiningLevel()
        {
            return 3;
        }

        @Override
        public int getEnchantability()
        {
            return 15;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.EMERALD);
        }
    }

    public static class TatteredMaterial implements ArmorMaterial
    {
        public static final TatteredMaterial INSTANCE = new TatteredMaterial();


        @Override
        public int getDurability(EquipmentSlot slot)
        {
            return 1;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot)
        {
            return 1;
        }

        @Override
        public int getEnchantability()
        {
            return 22;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.GOLD_NUGGET);
        }

        @Override
        public String getName() {
            return "tattered";
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 0;
        }
    }

    public static class Terraria implements ToolMaterial
    {
        public static final ParrotToolMaterial INSTANCE = new ParrotToolMaterial();

        @Override
        public int getDurability()
        {
            return 550;
        }

        @Override
        public float getMiningSpeedMultiplier()
        {
            return 6.0F;
        }

        @Override
        public float getAttackDamage()
        {
            return 5F;
        }

        @Override
        public int getMiningLevel()
        {
            return 2;
        }

        @Override
        public int getEnchantability()
        {
            return 2;
        }

        @Override
        public Ingredient getRepairIngredient()
        {
            return Ingredient.ofItems(Items.COPPER_INGOT);
        }
    }
}

package net.joshnaks.silly1.item;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class ModArmorMaterials
{
    public static class FreddyArmorMaterial implements ArmorMaterial
    {
        public static FreddyArmorMaterial INSTANCE = new FreddyArmorMaterial();

        @Override
        public int getDurability(EquipmentSlot slot) {
            return 0;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return 0;
        }

        @Override
        public int getEnchantability() {
            return 0;
        }

        @Override
        public SoundEvent getEquipSound() {
            return ModSoundEvents.FREDDY_ON_EVENT;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(new ItemConvertible[]{Items.LEATHER});
        }

        @Override
        public String getName() {
            return "freddy";
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

    public static class MarioiteArmorMaterial implements ArmorMaterial
    {
        public static MarioiteArmorMaterial INSTANCE = new MarioiteArmorMaterial();

        @Override
        public int getDurability(EquipmentSlot slot) {
            return 25;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return 4;
        }

        @Override
        public int getEnchantability() {
            return 4;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(new ItemConvertible[]{ModItems.Marioite});
        }

        @Override
        public String getName() {
            return "marioite";
        }

        @Override
        public float getToughness() {
            return 1f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.3f;
        }
    }

    public static class LuigiteArmorMaterial implements ArmorMaterial
    {
        public static LuigiteArmorMaterial INSTANCE = new LuigiteArmorMaterial();

        @Override
        public int getDurability(EquipmentSlot slot) {
            return 27;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return 3;
        }

        @Override
        public int getEnchantability() {
            return 9;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_LEATHER;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(new ItemConvertible[]{ModItems.Luigite});
        }

        @Override
        public String getName() {
            return "luigite";
        }

        @Override
        public float getToughness() {
            return 1f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.3f;
        }
    }

    public static class TatteredArmorMaterial implements ArmorMaterial
    {
        public static TatteredArmorMaterial INSTANCE = new TatteredArmorMaterial();

        @Override
        public int getDurability(EquipmentSlot slot) {
            return 1;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 35;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_CHAIN;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(new ItemConvertible[]{Items.GOLD_NUGGET});
        }

        @Override
        public String getName() {
            return "tattered_gold";
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

    public static class MetalMarioArmorMaterial implements ArmorMaterial
    {
        public static MetalMarioArmorMaterial INSTANCE = new MetalMarioArmorMaterial();

        @Override
        public int getDurability(EquipmentSlot slot) {
            return 1200;
        }

        @Override
        public int getProtectionAmount(EquipmentSlot slot) {
            return 20;
        }

        @Override
        public int getEnchantability() {
            return 0;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(new ItemConvertible[]{Items.BEDROCK});
        }

        @Override
        public String getName() {
            return "metal_mario";
        }

        @Override
        public float getToughness() {
            return 0;
        }

        @Override
        public float getKnockbackResistance() {
            return 100f;
        }
    }
}

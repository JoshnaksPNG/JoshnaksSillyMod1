package net.joshnaks.silly1.item;

import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

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
            return "diamond";
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
}

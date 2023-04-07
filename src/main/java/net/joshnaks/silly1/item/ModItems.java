package net.joshnaks.silly1.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.ModEntities;
import net.joshnaks.silly1.item.custom.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.joshnaks.silly1.item.ModToolMaterials;

public class ModItems
{
    // Marioite Items
    public static final Item Raw_Marioite = registerItem("raw_marioite",
            new Item (new FabricItemSettings().fireproof().maxCount(64)), ModItemGroup.MARIOITE);

    public static final Item Marioite = registerItem("marioite",
            new Item (new FabricItemSettings().fireproof().maxCount(64)), ModItemGroup.MARIOITE);

    public static final Item Raw_Luigite = registerItem("raw_luigite",
            new Item (new FabricItemSettings().fireproof().maxCount(64)), ModItemGroup.MARIOITE);

    public static final Item Luigite = registerItem("luigite",
            new Item (new FabricItemSettings().fireproof().maxCount(64)), ModItemGroup.MARIOITE);

    // Silly Items
    public static final Item Brain = registerItem("brain",
            new Item (new FabricItemSettings()), ModItemGroup.SILLY_FOOD);

    // Silly Tools
    public static final Item Gold_Shield = registerItem("gold_shield",
            new GoldShieldItem(new Item.Settings().maxDamage(1)), ModItemGroup.SILLY_TOOLS);

    public static final Item Incorrect_parrot = registerItem("incorrect_parrot",
            new SwordItem (ModToolMaterials.ParrotToolMaterial.INSTANCE, 3, -2.4F,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Pubg_Phone = registerItem("pubg_phone",
            new PubgPhoneItem(new FabricItemSettings().maxCount(1)), ModItemGroup.SILLY_TOOLS);

    public static final Item Coal_Sword = registerItem("coal_sword",
            new SwordItem (ModToolMaterials.CoalToolMaterial.INSTANCE, 4, -2.4F,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Real_Hand = registerItem("real_hand",
            new RealHandItem(ModToolMaterials.HandMaterial.INSTANCE, 0, -2.4F,
                    new Item.Settings().food(ModFoodComponents.REAL_HAND)), ModItemGroup.SILLY_TOOLS);

    public static final Item Forget_Stick = registerItem("forget_stick",
            new ForgetStick(ToolMaterials.GOLD, 0, -2.4F,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Emerald_Blade = registerItem("emerald_blade",
            new Item(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Emerald_Sword = registerItem("emerald_sword",
            new EmeraldSwordItem(ModToolMaterials.EmeraldMaterial.INSTANCE, 4, -2.4F,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Paper_Elytra = registerItem("paper_elytra",
            new ElytraItem(new Item.Settings().maxDamage(1)), ModItemGroup.SILLY_TOOLS);

    public static final Item Tattered_Helm = registerItem("tattered_helm",
            new TatteredArmorItem(ModArmorMaterials.TatteredArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Tattered_Chest = registerItem("tattered_chest",
            new TatteredArmorItem(ModArmorMaterials.TatteredArmorMaterial.INSTANCE, EquipmentSlot.CHEST, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Tattered_Leggings = registerItem("tattered_leggings",
            new TatteredArmorItem(ModArmorMaterials.TatteredArmorMaterial.INSTANCE, EquipmentSlot.LEGS, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Tattered_Boots = registerItem("tattered_boots",
            new TatteredArmorItem(ModArmorMaterials.TatteredArmorMaterial.INSTANCE, EquipmentSlot.FEET, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Fire_Flower = registerItem("fire_flower",
            new FireFlowerItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Funny_Cannon = registerItem("funny_cannon",
            new FunnyCannonItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Naughtigen_Cannon = registerItem("naughtigen_cannon",
            new NaughtigenCannonItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Troll_Egg = registerItem("troll_egg",
            new CrossbowItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Wallet = registerItem("wallet",
            new WalletItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Pocket_Greentop = registerItem("pocket_greentop",
            new PocketGreentopItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Pocket_Gravel_Pit = registerItem("pocket_gravel_pit",
            new PocketGravelPitItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Metal_Mario_Cap = registerItem("metal_mario_cap",
            new MetalMarioCapItem(new ModArmorMaterials.MetalMarioArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Vaccuum = registerItem("vaccuum",
            new VaccuumItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Troll_Helmet = registerItem("troll_helmet",
            new TrollHelmetItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Ghast_Cannon = registerItem("ghast_cannon",
            new GhastCannonItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Sonic_Shoes = registerItem("sonic_shoes",
            new SonicShoesItem(ArmorMaterials.LEATHER, EquipmentSlot.FEET, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Ultra_Pick = registerItem("ultra_pick",
            new PickaxeItem(ToolMaterials.DIAMOND, 0, 2, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Coal_Axe = registerItem("coal_axe",
            new AxeItem(ModToolMaterials.CoalToolMaterial.INSTANCE, 4, 1, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Alternatool = registerItem("alternatool",
            new AxeItem(ToolMaterials.DIAMOND, 0, 1, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Wildcard_Pick = registerItem("wildcard_pick",
            new WildcardPickItem(ToolMaterials.IRON, 0, 1, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Freddy_Mask = registerItem("freddy_mask",
            new FreddyMaskItem(ModArmorMaterials.FreddyArmorMaterial.INSTANCE, EquipmentSlot.HEAD, new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Clarinet = registerItem("clarinet",
            new ClarinetItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Scepter = registerItem("scepter",
            new ScepterItem(new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    // Silly Food
    public static final Item Iron_Apple = registerItem("iron_apple",
            new Item(new Item.Settings().food(ModFoodComponents.IRON_APPLE)), ModItemGroup.SILLY_FOOD);

    public static final Item Perc_Thirty = registerItem("perc_thirty",
            new Item(new Item.Settings().food(ModFoodComponents.PERC_THIRTY)), ModItemGroup.SILLY_FOOD);

    public static final Item Roast_Fire_Flower = registerItem("roast_fire_flower",
            new Item(new Item.Settings().food(ModFoodComponents.ROAST_FLOWER)), ModItemGroup.SILLY_FOOD);

    public static final Item Decaying_Flesh = registerItem("decaying_flesh",
            new Item(new Item.Settings().food(ModFoodComponents.DECAYING_FLESH).maxCount(1)), ModItemGroup.SILLY_FOOD);

    public static final Item Spaghetti = registerItem("spaghetti",
            new PastaItem(new Item.Settings().maxCount(1)), ModItemGroup.SILLY_FOOD);

    public static final Item Sauce_Spaghetti = registerItem("sauced_spaghetti",
            new Item(new Item.Settings().food(FoodComponents.BEEF)), ModItemGroup.SILLY_FOOD);

    // Spawn Eggs
    public static final Item Incompetent_Creeper_Spawn_Egg = registerItem("incompetent_spawn_egg",
            new SpawnEggItem(ModEntities.INCOMPETENT_CREEPER, 0x000000, 0x00BB00,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Trollface_Spawn_Egg = registerItem("trollface_spawn_egg",
            new SpawnEggItem(ModEntities.TROLLFACE, 0xFFFFFF, 0x000000,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    public static final Item Tiny_Mario_Spawn_Egg = registerItem("tiny_mario_spawn_egg",
            new SpawnEggItem(ModEntities.TINY_MARIO, 0xBB0000, 0x0000BB,
                    new Item.Settings()), ModItemGroup.SILLY_TOOLS);

    // Trollium Items
    public static final Item Raw_Trollium = registerItem("raw_trollium",
            new Item (new FabricItemSettings().fireproof().maxCount(68)), ModItemGroup.MARIOITE);

    public static final Item Trollium = registerItem("trollium",
            new Item (new FabricItemSettings().fireproof().maxCount(68)), ModItemGroup.MARIOITE);

    // Terraria Tools
    public static final Item Terraria_Pickaxe = registerItem("terraria_pickaxe",
            new PickaxeItem(new ModToolMaterials.Terraria(), 0, -1F, new Item.Settings()),
            ModItemGroup.SILLY_TOOLS);

    public static final Item Terraria_Axe = registerItem("terraria_axe",
            new AxeItem(new ModToolMaterials.Terraria(), 5, -2F, new Item.Settings()),
            ModItemGroup.SILLY_TOOLS);

    public static final Item Terraria_Sword = registerItem("terraria_sword",
            new SwordItem(new ModToolMaterials.Terraria(), 3, -1F, new Item.Settings()),
            ModItemGroup.SILLY_TOOLS);

    public static final Item Terraria_Broadsword = registerItem("terraria_broadsword",
            new SwordItem(new ModToolMaterials.Terraria(), 7, -3F, new Item.Settings()),
            ModItemGroup.SILLY_TOOLS);

    // Marioite Armour
    public static final Item Marioite_Helmet = registerItem("marioite_helmet",
            new ArmorItem(new ModArmorMaterials.MarioiteArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings()),
            ModItemGroup.MARIOITE);

    public static final Item Marioite_Chestplate = registerItem("marioite_chestplate",
            new ArmorItem(new ModArmorMaterials.MarioiteArmorMaterial(), EquipmentSlot.CHEST, new Item.Settings()),
            ModItemGroup.MARIOITE);

    public static final Item Marioite_Leggings = registerItem("marioite_leggings",
            new ArmorItem(new ModArmorMaterials.MarioiteArmorMaterial(), EquipmentSlot.LEGS, new Item.Settings()),
            ModItemGroup.MARIOITE);

    public static final Item Marioite_Boots = registerItem("marioite_boots",
            new ArmorItem(new ModArmorMaterials.MarioiteArmorMaterial(), EquipmentSlot.FEET, new Item.Settings()),
            ModItemGroup.MARIOITE);

    // Luigite Armour
    public static final Item Luigite_Helmet = registerItem("luigite_helmet",
            new LuigiArmorItem(new ModArmorMaterials.LuigiteArmorMaterial(), EquipmentSlot.HEAD, new Item.Settings()),
            ModItemGroup.MARIOITE);

    public static final Item Luigite_Chestplate = registerItem("luigite_chestplate",
            new LuigiArmorItem(new ModArmorMaterials.LuigiteArmorMaterial(), EquipmentSlot.CHEST, new Item.Settings()),
            ModItemGroup.MARIOITE);

    public static final Item Luigite_Leggings = registerItem("luigite_leggings",
            new LuigiArmorItem(new ModArmorMaterials.LuigiteArmorMaterial(), EquipmentSlot.LEGS, new Item.Settings()),
            ModItemGroup.MARIOITE);

    public static final Item Luigite_Boots = registerItem("luigite_boots",
            new LuigiArmorItem(new ModArmorMaterials.LuigiteArmorMaterial(), EquipmentSlot.FEET, new Item.Settings()),
            ModItemGroup.MARIOITE);

    private static Item registerItem (String name, Item item, ItemGroup group)
    {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return Registry.register(Registries.ITEM, new Identifier(SillyMod1.MOD_ID, name), item);
    }

    public static void registerModItems()
    {
        SillyMod1.LOGGER.debug("Registering Mod Items for " + SillyMod1.MOD_ID);
    }
}

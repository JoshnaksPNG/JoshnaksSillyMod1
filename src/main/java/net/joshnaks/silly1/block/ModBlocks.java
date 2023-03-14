package net.joshnaks.silly1.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.block.custom.CursedDoorBlock;
import net.joshnaks.silly1.block.custom.DidYouKnowBlock;
import net.joshnaks.silly1.block.custom.LegoBlock;
import net.joshnaks.silly1.block.custom.TrollGrassBlock;
import net.joshnaks.silly1.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

public class ModBlocks
{
    public static final Block MARIOITE_BLOCK = registerBlock( "marioite_block",
            new Block(FabricBlockSettings.of(Material.STONE).luminance(4).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block RAW_MARIOITE_BLOCK = registerBlock( "raw_marioite_block",
            new Block(FabricBlockSettings.of(Material.STONE).luminance(4).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block LUIGITE_BLOCK = registerBlock( "luigite_block",
            new Block(FabricBlockSettings.of(Material.STONE).luminance(8).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block RAW_LUIGITE_BLOCK = registerBlock( "raw_luigite_block",
            new Block(FabricBlockSettings.of(Material.STONE).luminance(8).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block LUIGITE_ORE = registerBlock( "luigite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).luminance(5).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block MARIOITE_ORE = registerBlock( "marioite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).luminance(5).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block DEEPSLATE_LUIGITE_ORE = registerBlock( "deepslate_luigite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).luminance(5).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block DEEPSLATE_MARIOITE_ORE = registerBlock( "deepslate_marioite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).luminance(5).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block DID_YOU_KNOW_BLOCK = registerBlock("did_you_know_block",
            new DidYouKnowBlock(FabricBlockSettings.of(Material.METAL).luminance(3)), ModItemGroup.SILLY_BLOCKS);

    public static final Block LEGO = registerBlock("lego",
            new LegoBlock(FabricBlockSettings.of(Material.CARPET)), ModItemGroup.SILLY_BLOCKS);

    public static final Block CURSED_DOOR = registerBlock("cursed_door",
            new CursedDoorBlock(FabricBlockSettings.of(Material.WOOD).strength(3.0F).sounds(BlockSoundGroup.WOOD).nonOpaque(), SoundEvents.BLOCK_WOODEN_DOOR_CLOSE, SoundEvents.BLOCK_WOODEN_DOOR_OPEN), ModItemGroup.SILLY_BLOCKS);

    public static final Block TROLLIUM_BLOCK = registerBlock( "trollium_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block RAW_TROLLIUM_BLOCK = registerBlock( "raw_trollium_block",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block TROLLIUM_ORE = registerBlock( "trollium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block DEEPSLATE_trollium_ORE = registerBlock( "deepslate_trollium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()), ModItemGroup.MARIOITE);

    public static final Block TROLL_GRASS = registerBlock("troll_grass",
            new TrollGrassBlock(FabricBlockSettings.of(Material.SOIL)), ModItemGroup.SILLY_BLOCKS);
    private static Block registerBlock(String name, Block block, ItemGroup group)
    {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(SillyMod1.MOD_ID, name), block );
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group)
    {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
        return Registry.register(Registries.ITEM, new Identifier(SillyMod1.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks()
    {
        SillyMod1.LOGGER.debug("Registering Mod Blocks for " + SillyMod1.MOD_ID);
    }
}

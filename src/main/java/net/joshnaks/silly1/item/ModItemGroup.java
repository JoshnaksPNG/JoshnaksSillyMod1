package net.joshnaks.silly1.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup
{
    public static final ItemGroup MARIOITE = FabricItemGroup.builder(new Identifier(SillyMod1.MOD_ID + "_marioite"))
            .displayName(Text.literal("Marioite"))
            .icon(() -> new ItemStack(ModItems.Marioite))
            .build();

    public static final ItemGroup SILLY_TOOLS = FabricItemGroup.builder(new Identifier(SillyMod1.MOD_ID + "_tools"))
            .displayName(Text.literal("Silly Tools"))
            .icon(() -> new ItemStack(ModItems.Pubg_Phone))
            .build();

    public static final ItemGroup SILLY_BLOCKS = FabricItemGroup.builder(new Identifier(SillyMod1.MOD_ID + "_blocks"))
            .displayName(Text.literal("Silly Blocks"))
            .icon(() -> new ItemStack(ModBlocks.DID_YOU_KNOW_BLOCK.asItem()))
            .build();

    public static final ItemGroup SILLY_FOOD = FabricItemGroup.builder(new Identifier(SillyMod1.MOD_ID + "_food"))
            .displayName(Text.literal("Silly Food"))
            .icon(() -> new ItemStack(ModItems.Iron_Apple))
            .build();
}

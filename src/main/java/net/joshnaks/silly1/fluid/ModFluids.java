package net.joshnaks.silly1.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.fluid.custom.GooigiFluid;
import net.joshnaks.silly1.fluid.custom.MarinaraFluid;
import net.joshnaks.silly1.item.ModItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFluids {
    public static FlowableFluid STILL_GOOIGI;
    public static FlowableFluid FLOWING_GOOIGI;
    public static Block GOOIGI_FLUID_BLOCK;
    public static Item GOOIGI_BUCKET;

    public static FlowableFluid STILL_MARINARA;
    public static FlowableFluid FLOWING_MARINARA;
    public static Block MARINARA_FLUID_BLOCK;
    public static Item MARINARA_BUCKET;

    public static void register()
    {
        STILL_GOOIGI = Registry.register(Registries.FLUID,
                new Identifier(SillyMod1.MOD_ID, "gooigi_liquid"), new GooigiFluid.Still());

        FLOWING_GOOIGI = Registry.register(Registries.FLUID,
                new Identifier(SillyMod1.MOD_ID, "flowing_gooigi_liquid"), new GooigiFluid.Flowing());

        GOOIGI_FLUID_BLOCK = Registry.register(Registries.BLOCK, new Identifier(SillyMod1.MOD_ID, "gooigi_liquid_block"),
                new FluidBlock( ModFluids.STILL_GOOIGI, FabricBlockSettings.copyOf(Blocks.WATER)));

        GOOIGI_BUCKET = Registry.register(Registries.ITEM, new Identifier(SillyMod1.MOD_ID, "gooigi_bucket"),
                new BucketItem(ModFluids.STILL_GOOIGI, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SILLY_TOOLS).register(entries -> entries.add(GOOIGI_BUCKET));

        STILL_MARINARA = Registry.register(Registries.FLUID,
                new Identifier(SillyMod1.MOD_ID, "marinara_liquid"), new MarinaraFluid.Still());

        FLOWING_MARINARA = Registry.register(Registries.FLUID,
                new Identifier(SillyMod1.MOD_ID, "flowing_marinara_liquid"), new MarinaraFluid.Flowing());

        MARINARA_FLUID_BLOCK = Registry.register(Registries.BLOCK, new Identifier(SillyMod1.MOD_ID, "marinara_liquid_block"),
                new FluidBlock( ModFluids.STILL_MARINARA, FabricBlockSettings.copyOf(Blocks.WATER)));

        MARINARA_BUCKET = Registry.register(Registries.ITEM, new Identifier(SillyMod1.MOD_ID, "marinara_bucket"),
                new BucketItem(ModFluids.STILL_MARINARA, new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.SILLY_TOOLS).register(entries -> entries.add(MARINARA_BUCKET));
    }
}

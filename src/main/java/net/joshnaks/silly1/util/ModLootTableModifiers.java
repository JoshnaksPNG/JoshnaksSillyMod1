package net.joshnaks.silly1.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.joshnaks.silly1.item.ModItems;
import net.joshnaks.silly1.lootConditions.KilledWithCoalSword;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers
{

    // Entity IDs
    public static final Identifier PARROT_ID
            = new Identifier("minecraft", "entities/parrot");

    public static final Identifier CHICKEN_ID
            = new Identifier("minecraft", "entities/chicken");

    public static final Identifier COW_ID
            = new Identifier("minecraft", "entities/cow");

    public static final Identifier COD_ID
            = new Identifier("minecraft", "entities/cod");

    public static final Identifier PIG_ID
            = new Identifier("minecraft", "entities/pig");

    public static final Identifier SHEEP_ID
            = new Identifier("minecraft", "entities/sheep");

    public static final Identifier SALMON_ID
            = new Identifier("minecraft", "entities/salmon");

    public static final Identifier RABBIT_ID
            = new Identifier("minecraft", "entities/rabbit");

    // Block IDs
    public static final Identifier STONE_ID
            = new Identifier("minecraft", "blocks/stone");

    public static final Identifier OAK_LOG_ID
            = new Identifier("minecraft", "blocks/oak_log");

    public static final Identifier SPRUCE_LOG_ID
            = new Identifier("minecraft", "blocks/spruce_log");

    public static final Identifier BIRCH_LOG_ID
            = new Identifier("minecraft", "blocks/birch_log");

    public static final Identifier JUNGLE_LOG_ID
            = new Identifier("minecraft", "blocks/jungle_log");

    public static final Identifier ACACIA_LOG_ID
            = new Identifier("minecraft", "blocks/acacia_log");

    public static final Identifier DARK_OAK_LOG_ID
            = new Identifier("minecraft", "blocks/dark_oak_log");

    public static final Identifier MANGROVE_LOG_ID
            = new Identifier("minecraft", "blocks/mangrove_log");

    public static final Identifier CHERRY_LOG_ID
            = new Identifier("minecraft", "blocks/cherry_log");

    public static final Identifier CRIMSON_LOG_ID
            = new Identifier("minecraft", "blocks/crimson_stem");

    public static final Identifier WARPED_LOG_ID
            = new Identifier("minecraft", "blocks/warped_stem");

    public static final Identifier STRIPPED_OAK_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_oak_log");

    public static final Identifier STRIPPED_SPRUCE_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_spruce_log");

    public static final Identifier STRIPPED_BIRCH_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_birch_log");

    public static final Identifier STRIPPED_JUNGLE_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_jungle_log");

    public static final Identifier STRIPPED_ACACIA_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_acacia_log");

    public static final Identifier STRIPPED_DARK_OAK_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_dark_oak_log");

    public static final Identifier STRIPPED_MANGROVE_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_mangrove_log");

    public static final Identifier STRIPPED_CHERRY_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_cherry_log");

    public static final Identifier STRIPPED_CRIMSON_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_crimson_stem");

    public static final Identifier STRIPPED_WARPED_LOG_ID
            = new Identifier("minecraft", "blocks/stripped_warped_stem");

    public static final Identifier OAK_WOOD_ID
            = new Identifier("minecraft", "blocks/oak_wood");

    public static final Identifier SPRUCE_WOOD_ID
            = new Identifier("minecraft", "blocks/spruce_wood");

    public static final Identifier BIRCH_WOOD_ID
            = new Identifier("minecraft", "blocks/birch_wood");

    public static final Identifier JUNGLE_WOOD_ID
            = new Identifier("minecraft", "blocks/jungle_wood");

    public static final Identifier ACACIA_WOOD_ID
            = new Identifier("minecraft", "blocks/acacia_wood");

    public static final Identifier DARK_OAK_WOOD_ID
            = new Identifier("minecraft", "blocks/dark_oak_wood");

    public static final Identifier MANGROVE_WOOD_ID
            = new Identifier("minecraft", "blocks/mangrove_wood");

    public static final Identifier CHERRY_WOOD_ID
            = new Identifier("minecraft", "blocks/cherry_wood");

    public static final Identifier CRIMSON_WOOD_ID
            = new Identifier("minecraft", "blocks/crimson_hyphae");

    public static final Identifier WARPED_WOOD_ID
            = new Identifier("minecraft", "blocks/warped_hyphae");

    public static final Identifier STRIPPED_OAK_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_oak_wood");

    public static final Identifier STRIPPED_SPRUCE_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_spruce_wood");

    public static final Identifier STRIPPED_BIRCH_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_birch_wood");

    public static final Identifier STRIPPED_JUNGLE_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_jungle_wood");

    public static final Identifier STRIPPED_ACACIA_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_acacia_wood");

    public static final Identifier STRIPPED_DARK_OAK_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_dark_oak_wood");

    public static final Identifier STRIPPED_MANGROVE_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_mangrove_wood");

    public static final Identifier STRIPPED_CHERRY_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_cherry_wood");

    public static final Identifier STRIPPED_CRIMSON_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_crimson_hyphae");

    public static final Identifier STRIPPED_WARPED_WOOD_ID
            = new Identifier("minecraft", "blocks/stripped_warped_hyphae");




    // Container IDs
    public static final Identifier BONUS_ID
            = new Identifier("minecraft", "chests/spawn_bonus_chest");

    public static void modifyLootTables()
    {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) ->
        {
            if(PARROT_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                    .rolls(ConstantLootNumberProvider.create(1))
                    .conditionally(RandomChanceLootCondition.builder(1.0f)) // Always Drops
                    .with(ItemEntry.builder(ModItems.Incorrect_parrot))
                    .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(CHICKEN_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_CHICKEN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.CHICKEN))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(COW_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_BEEF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.BEEF))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(COD_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_COD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.COD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(PIG_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_PORKCHOP))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.PORKCHOP))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(SHEEP_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_MUTTON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.MUTTON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(SALMON_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_SALMON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.SALMON))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(RABBIT_ID.equals(id))
            {

                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder())
                        //.conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Sword)))
                        .with(ItemEntry.builder(Items.COOKED_RABBIT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(KilledWithCoalSword.builder().invert())
                        .with(ItemEntry.builder(Items.RABBIT))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STONE_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Ultra_Pick)))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Ultra_Pick).enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.ANY))).invert())
                        .with(ItemEntry.builder(Blocks.COBBLESTONE.asItem()))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(63f, 63f)));

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Ultra_Pick).enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.ANY))))
                        .with(ItemEntry.builder(Blocks.STONE.asItem()))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(63f, 63f)));

                tableBuilder.pool(poolBuilder.build());
                tableBuilder.pool(poolBuilder2.build());
            }

            if(BONUS_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(1.0f)) // Always Drops
                        .with(ItemEntry.builder(ModItems.Ultra_Pick))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

            if(OAK_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.OAK_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_OAK_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_OAK_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(ACACIA_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.ACACIA_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_ACACIA_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_ACACIA_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(SPRUCE_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.SPRUCE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_SPRUCE_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_SPRUCE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(BIRCH_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.BIRCH_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_BIRCH_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_BIRCH_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(DARK_OAK_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.DARK_OAK_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_DARK_OAK_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_DARK_OAK_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(MANGROVE_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.MANGROVE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_MANGROVE_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_MANGROVE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(JUNGLE_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.JUNGLE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_JUNGLE_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_JUNGLE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(CHERRY_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.MANGROVE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_CHERRY_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_MANGROVE_LOG))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(CRIMSON_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.CRIMSON_STEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_CRIMSON_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_CRIMSON_STEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(WARPED_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.WARPED_STEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_WARPED_LOG_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_WARPED_STEM))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(OAK_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.OAK_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_OAK_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_OAK_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(ACACIA_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.ACACIA_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_ACACIA_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_ACACIA_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(SPRUCE_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.SPRUCE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_SPRUCE_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_SPRUCE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(BIRCH_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.BIRCH_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_BIRCH_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_BIRCH_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(DARK_OAK_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.DARK_OAK_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_DARK_OAK_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_DARK_OAK_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(MANGROVE_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.MANGROVE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_MANGROVE_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_MANGROVE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(JUNGLE_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.JUNGLE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_JUNGLE_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_JUNGLE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(CHERRY_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.MANGROVE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_CHERRY_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_MANGROVE_WOOD))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(CRIMSON_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.CRIMSON_HYPHAE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_CRIMSON_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_CRIMSON_HYPHAE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(WARPED_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.WARPED_HYPHAE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }

            if(STRIPPED_WARPED_WOOD_ID.equals(id))
            {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)))
                        .with(ItemEntry.builder(Items.CHARCOAL))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());

                LootPool.Builder poolBuilder2 = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1f))
                        .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(ModItems.Coal_Axe)).invert())
                        .with(ItemEntry.builder(Blocks.STRIPPED_WARPED_HYPHAE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1f, 1f)).build());

                tableBuilder.pool(poolBuilder2.build());
            }
        });
    }
}

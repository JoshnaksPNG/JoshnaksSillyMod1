package net.joshnaks.silly1.world;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures
{
    public static final RegistryKey<ConfiguredFeature<?,?>> MARIOITE_ORE_KEY = registerKey("marioite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> LUIGITE_ORE_KEY = registerKey("luigite_ore");
    public static final RegistryKey<ConfiguredFeature<?,?>> TROLL_ORE_KEY = registerKey("troll_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context)
    {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworld_mario_ores =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.MARIOITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_MARIOITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworld_luigi_ores =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.LUIGITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_LUIGITE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworld_troll_ores =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.TROLLIUM_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_trollium_ORE.getDefaultState()));


        register(context, MARIOITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworld_mario_ores, 15));
        register(context, LUIGITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworld_luigi_ores, 15));
        register(context, TROLL_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworld_troll_ores, 15));
    }

    public static RegistryKey<ConfiguredFeature<?,?>> registerKey(String name)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(SillyMod1.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?,?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?,?>> key, F feature, FC configuration)
    {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

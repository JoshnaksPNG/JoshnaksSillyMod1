package net.joshnaks.silly1;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.joshnaks.silly1.block.ModBlocks;
import net.joshnaks.silly1.effect.ModEffects;
import net.joshnaks.silly1.entity.ModEntities;
import net.joshnaks.silly1.entity.custom.*;
import net.joshnaks.silly1.fluid.ModFluids;
import net.joshnaks.silly1.item.ModItems;
import net.joshnaks.silly1.networking.ModMessages;
import net.joshnaks.silly1.painting.ModPaintings;
import net.joshnaks.silly1.potion.ModPotions;
import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.joshnaks.silly1.util.ModLootTableModifiers;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class SillyMod1 implements ModInitializer {
	public static final String MOD_ID = "sillymod1";
	/*public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Identifier LEBRON_ID = new Identifier("sillymod1:lebron");
	public static SoundEvent LEBRON_EVENT = SoundEvent.of(LEBRON_ID);*/


	@Override
	public void onInitialize()
	{
		FabricDefaultAttributeRegistry.register(ModEntities.INCOMPETENT_CREEPER, IncompetentCreeper.createCreeperAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TROLLFACE, TrollfaceEntity.setAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.TINY_MARIO, TinyMarioEntity.createWolfAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.HUSK_SLAVE, HuskSlaveEntity.createZombieAttributes());

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CURSED_DOOR, RenderLayer.getCutout());



		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEffects.registerModEffects();

		ModSoundEvents.registerModSounds();

		ModPotions.registerModPotions();

		ModEntities.registerModEntities();

		ModLootTableModifiers.modifyLootTables();

		ModPaintings.registerPaintings();

		ModFluids.register();

		ModMessages.registerS2CPackets();
		ModMessages.registerC2SPackets();

		GeckoLib.initialize();
	}
}

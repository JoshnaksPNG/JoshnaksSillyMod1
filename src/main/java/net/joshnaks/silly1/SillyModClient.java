package net.joshnaks.silly1;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.joshnaks.silly1.client.FreddyMaskHudOverlay;
import net.joshnaks.silly1.client.render.entity.*;
import net.joshnaks.silly1.entity.ModEntities;
import net.joshnaks.silly1.fluid.ModFluids;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.CreeperEntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class SillyModClient implements ClientModInitializer
{
    public static final EntityModelLayer MODEL_CREEPER_LAYER = new EntityModelLayer(new Identifier(SillyMod1.MOD_ID, "incompetent_creeper"), "main");
    public static final EntityModelLayer MODEL_VILLAGER_LAYER = new EntityModelLayer(new Identifier(SillyMod1.MOD_ID, "cursed_villager"), "main");
    public static final EntityModelLayer MODEL_HUSK_SLAVE_LAYER = new EntityModelLayer(new Identifier(SillyMod1.MOD_ID, "husk_slave"), "main");
    public static final EntityModelLayer MODEL_PIGLIN_SLAVE_LAYER = new EntityModelLayer(new Identifier(SillyMod1.MOD_ID, "piglin_slave"), "main");


    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.INCOMPETENT_CREEPER, (ctx ->
        {
            return new IncompetentCreeperRenderer(ctx);
        }));

        EntityRendererRegistry.register(ModEntities.CURSED_VILLAGER, (ctx ->
        {
            return new CursedVillagerRenderer(ctx);
        }));

        EntityRendererRegistry.register(ModEntities.CANNON_PROJECTILE, (ctx ->
        {
            return new CannonProjectileRenderer(ctx);
        }));

        EntityRendererRegistry.register(ModEntities.NAUGHTIGEN_PROJECTILE, (ctx ->
        {
            return new NaughtigenProjectileRenderer(ctx);
        }));

        EntityRendererRegistry.register(ModEntities.HUSK_SLAVE, (ctx ->
        {
            return new HuskSlaveRenderer(ctx);
        }));

        EntityRendererRegistry.register(ModEntities.PIGLIN_SLAVE, (ctx ->
        {
            return new PiglinSlaveRenderer(ctx);
        }));

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_GOOIGI, ModFluids.FLOWING_GOOIGI,
                new SimpleFluidRenderHandler(
                        new Identifier("sillymod1:block/gooigi_still"),
                        new Identifier("sillymod1:block/gooigi_flow"),
                        0x5533AA33
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_GOOIGI, ModFluids.FLOWING_GOOIGI);

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.STILL_MARINARA, ModFluids.FLOWING_MARINARA,
                new SimpleFluidRenderHandler(
                        new Identifier("sillymod1:block/marinara_still"),
                        new Identifier("sillymod1:block/marinara_flowing"),
                        0x55FFFFFF
                ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(),
                ModFluids.STILL_MARINARA, ModFluids.FLOWING_MARINARA);

        Dilation d = new Dilation(1f);
        EntityModelLayerRegistry.TexturedModelDataProvider p = () -> CreeperEntityModel.getTexturedModelData(d);
        EntityModelLayerRegistry.registerModelLayer(MODEL_CREEPER_LAYER, p);

        //EntityModelLayerRegistry.TexturedModelDataProvider pr = () -> VillagerResemblingModel.getModelData();
        //EntityModelLayerRegistry.registerModelLayer(MODEL_VILLAGER_LAYER, pr);

        EntityRendererRegistry.register(ModEntities.TROLLFACE, TrollfaceRenderer::new);
        EntityRendererRegistry.register(ModEntities.TINY_MARIO, TinyMarioRenderer::new);
        EntityRendererRegistry.register(ModEntities.CANNON_PROJECTILE, CannonProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.NAUGHTIGEN_PROJECTILE, NaughtigenProjectileRenderer::new);

        HudRenderCallback.EVENT.register(new FreddyMaskHudOverlay());
    }
}

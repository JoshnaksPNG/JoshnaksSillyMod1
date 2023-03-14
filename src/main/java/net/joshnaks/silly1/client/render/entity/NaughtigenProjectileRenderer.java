package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.NaughtigenProjectile;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NaughtigenProjectileRenderer extends GeoEntityRenderer<NaughtigenProjectile>
{

    public NaughtigenProjectileRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new NaughtigenProjectileModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(NaughtigenProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/naughtigen_projectile.png");
    }

    @Override
    public RenderLayer getRenderType(NaughtigenProjectile animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {


        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}

package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.CannonProjectile;
import net.joshnaks.silly1.entity.custom.TrollfaceEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CannonProjectileRenderer extends GeoEntityRenderer<CannonProjectile>
{

    public CannonProjectileRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new CannonProjectileModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(CannonProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/cannon_projectile.png");
    }

    @Override
    public RenderLayer getRenderType(CannonProjectile animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {


        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}

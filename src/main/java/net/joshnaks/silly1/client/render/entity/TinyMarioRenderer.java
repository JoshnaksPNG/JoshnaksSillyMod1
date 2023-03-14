package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.TinyMarioEntity;
import net.joshnaks.silly1.entity.custom.TrollfaceEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TinyMarioRenderer extends GeoEntityRenderer<TinyMarioEntity>
{

    public TinyMarioRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TinyMarioModel());
        this.shadowRadius = 0.25f;
    }

    @Override
    public Identifier getTexture(TinyMarioEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/tiny_mario.png");
    }

    @Override
    public RenderLayer getRenderType(TinyMarioEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {


        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}

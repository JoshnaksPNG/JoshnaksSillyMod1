package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.TrollfaceEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class TrollfaceRenderer extends GeoEntityRenderer<TrollfaceEntity>
{

    public TrollfaceRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new TrollfaceModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public Identifier getTexture(TrollfaceEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/troll_face.png");
    }

    @Override
    public RenderLayer getRenderType(TrollfaceEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick) {


        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}

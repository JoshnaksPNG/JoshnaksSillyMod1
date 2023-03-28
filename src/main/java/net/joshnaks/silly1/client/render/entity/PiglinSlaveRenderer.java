package net.joshnaks.silly1.client.render.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.HuskEntityRenderer;
import net.minecraft.client.render.entity.PiglinEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.Identifier;

public class PiglinSlaveRenderer extends PiglinEntityRenderer {

    private static final Identifier TEXTURE = new Identifier("textures/entity/piglin/piglin.png");

    public PiglinSlaveRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, EntityModelLayers.PIGLIN, EntityModelLayers.PIGLIN_INNER_ARMOR, EntityModelLayers.PIGLIN_OUTER_ARMOR, false);
    }

    @Override
    public Identifier getTexture(MobEntity mobEntity) {
        return TEXTURE;
    }
}

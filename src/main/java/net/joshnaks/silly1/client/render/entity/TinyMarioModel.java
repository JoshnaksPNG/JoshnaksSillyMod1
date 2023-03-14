package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.TinyMarioEntity;
import net.joshnaks.silly1.entity.custom.TrollfaceEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TinyMarioModel extends GeoModel<TinyMarioEntity>
{

    @Override
    public Identifier getModelResource(TinyMarioEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "geo/tiny_mario.geo.json");
    }

    @Override
    public Identifier getTextureResource(TinyMarioEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/tiny_mario.png");
    }

    @Override
    public Identifier getAnimationResource(TinyMarioEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "animations/tiny_mario.animation.json");
    }
}

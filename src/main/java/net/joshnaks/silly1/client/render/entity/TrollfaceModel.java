package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.TrollfaceEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class TrollfaceModel  extends GeoModel<TrollfaceEntity>
{

    @Override
    public Identifier getModelResource(TrollfaceEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "geo/troll_face.geo.json");
    }

    @Override
    public Identifier getTextureResource(TrollfaceEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/troll_face.png");
    }

    @Override
    public Identifier getAnimationResource(TrollfaceEntity animatable) {
        return new Identifier(SillyMod1.MOD_ID, "animations/trollface.animation.json");
    }
}

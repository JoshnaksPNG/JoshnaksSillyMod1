package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.CannonProjectile;
import net.joshnaks.silly1.entity.custom.TrollfaceEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class CannonProjectileModel extends GeoModel<CannonProjectile>
{

    @Override
    public Identifier getModelResource(CannonProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "geo/cannon_projectile.geo.json");
    }

    @Override
    public Identifier getTextureResource(CannonProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/cannon_projectile.png");
    }

    @Override
    public Identifier getAnimationResource(CannonProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "animations/cannon_projectile.animation.json");
    }
}

package net.joshnaks.silly1.client.render.entity;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.entity.custom.NaughtigenProjectile;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class NaughtigenProjectileModel extends GeoModel<NaughtigenProjectile>
{

    @Override
    public Identifier getModelResource(NaughtigenProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "geo/naughtigen_projectile.geo.json");
    }

    @Override
    public Identifier getTextureResource(NaughtigenProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "textures/entity/naughtigen_projectile.png");
    }

    @Override
    public Identifier getAnimationResource(NaughtigenProjectile animatable) {
        return new Identifier(SillyMod1.MOD_ID, "animations/naughtigen_projectile.animation.json");
    }
}

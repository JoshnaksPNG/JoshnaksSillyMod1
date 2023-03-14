package net.joshnaks.silly1.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.time.Instant;

public class TinyMarioEntity extends WolfEntity implements GeoEntity
{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.tiny_mario.idle");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.tiny_mario.idle");



    public TinyMarioEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
        this.setTamed(false);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event)
    {
        if(event.isMoving())
        {
            event.getController().setAnimation(WALK);
            return PlayState.CONTINUE;
        }

        event.getController().setAnimation(IDLE);

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        //controllerRegistrar.add(new AnimationController<>(this, "attackController", 0, this::attackPredicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}

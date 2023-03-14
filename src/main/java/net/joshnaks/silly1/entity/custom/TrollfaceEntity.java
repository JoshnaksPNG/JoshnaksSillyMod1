package net.joshnaks.silly1.entity.custom;

import net.joshnaks.silly1.effect.ModEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.InstancedAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import java.time.Instant;

public class TrollfaceEntity extends HostileEntity implements GeoEntity
{
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.troll_face.idle");
    private static final RawAnimation RUN = RawAnimation.begin().thenLoop("animation.troll_face.run");
    private static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.troll_face.idle");
    private static final RawAnimation ATTACK = RawAnimation.begin().thenPlay("animation.troll_face.attack");

    private boolean inAttackAnimation = false;
    private long animationStart = Instant.now().toEpochMilli();


    public TrollfaceEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 40.0)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.0F)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, 5.0F)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3F);
    }

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event)
    {
        if(this.isAttacking() && this.handSwinging && !inAttackAnimation)
        {
            event.getController().setAnimation(ATTACK);
            inAttackAnimation = true;
            return PlayState.CONTINUE;
        }

        if(event.isMoving() && !inAttackAnimation)
        {
            event.getController().setAnimation(RUN);
            return PlayState.CONTINUE;
        }

        if(!inAttackAnimation)
        {
            event.getController().setAnimation(IDLE);
        }

        inAttackAnimation = animationStart + 334 > Instant.now().toEpochMilli();

        return PlayState.CONTINUE;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.75f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));

        this.targetSelector.add(2, new ActiveTargetGoal<>(this, PlayerEntity.class, true));

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar)
    {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
        //controllerRegistrar.add(new AnimationController<>(this, "attackController", 0, this::attackPredicate));
    }

    private <E extends GeoAnimatable> PlayState attackPredicate(AnimationState<E> event)
    {
        if(this.isAttacking())
        {
            event.getController().setAnimation(ATTACK);
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void onAttacking(Entity target)
    {
        if(target instanceof LivingEntity livingEntity)
        {
            livingEntity.addStatusEffect(new StatusEffectInstance(ModEffects.Oiled, 150));
            //livingEntity.getWorld().rain
        }

        super.onAttacking(target);
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}

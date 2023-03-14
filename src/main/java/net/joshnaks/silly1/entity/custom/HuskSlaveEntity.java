package net.joshnaks.silly1.entity.custom;

import net.joshnaks.silly1.entity.ModEntities;
import net.joshnaks.silly1.entity.ai.goal.AttackWithOwnerCustomGoal;
import net.joshnaks.silly1.entity.ai.goal.FollowOwnerCustomGoal;
import net.joshnaks.silly1.entity.ai.goal.TrackOwnerAttackerCustomGoal;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.AbstractSkeletonEntity;
import net.minecraft.entity.mob.HuskEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;
import java.util.UUID;

public class HuskSlaveEntity extends HuskEntity
{
    protected static final TrackedData<Byte> TAMEABLE_FLAGS;
    protected static final TrackedData<Optional<UUID>> OWNER_UUID;


    public HuskSlaveEntity(EntityType<? extends HuskEntity> entityType, World world) {
        super(entityType, world);
        this.setTamed(true);
    }

    public HuskSlaveEntity(World world, PlayerEntity owner, BlockPos pos)
    {
        super(ModEntities.HUSK_SLAVE, world);
        this.setOwner(owner);
        this.setPos(pos.getX(), pos.getY(), pos.getZ());
    }

    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(TAMEABLE_FLAGS, (byte)0);
        this.dataTracker.startTracking(OWNER_UUID, Optional.empty());
    }

    @Nullable
    public UUID getOwnerUuid() {
        return (UUID)((Optional)this.dataTracker.get(OWNER_UUID)).orElse((Object)null);
    }

    public void setOwnerUuid(@Nullable UUID uuid) {
        this.dataTracker.set(OWNER_UUID, Optional.ofNullable(uuid));
    }

    public void setOwner(PlayerEntity player) {
        this.setTamed(true);
        this.setOwnerUuid(player.getUuid());

    }

    @Nullable
    public LivingEntity getOwner() {
        try {
            UUID uUID = this.getOwnerUuid();
            return uUID == null ? null : this.world.getPlayerByUuid(uUID);
        } catch (IllegalArgumentException var2) {
            return null;
        }
    }

    public boolean isTamed() {
        return ((Byte)this.dataTracker.get(TAMEABLE_FLAGS) & 4) != 0;
    }

    public void setTamed(boolean tamed) {
        byte b = (Byte)this.dataTracker.get(TAMEABLE_FLAGS);
        if (tamed) {
            this.dataTracker.set(TAMEABLE_FLAGS, (byte)(b | 4));
        } else {
            this.dataTracker.set(TAMEABLE_FLAGS, (byte)(b & -5));
        }

        this.onTamedChanged();
    }

    protected void onTamedChanged() {
    }

    public void onDeath(DamageSource damageSource) {
        if (!this.world.isClient && this.world.getGameRules().getBoolean(GameRules.SHOW_DEATH_MESSAGES) && this.getOwner() instanceof ServerPlayerEntity) {
            this.getOwner().sendMessage(this.getDamageTracker().getDeathMessage());
        }

        super.onDeath(damageSource);
    }

    public boolean canTarget(LivingEntity target) {
        return this.isOwner(target) ? false : super.canTarget(target);
    }

    public boolean isOwner(LivingEntity entity) {
        return entity == this.getOwner();
    }

    public boolean canAttackWithOwner(LivingEntity target, LivingEntity owner) {
        return true;
    }

    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.0, true));
        this.goalSelector.add(3, new FollowOwnerCustomGoal(this, 1.0, 10.0F, 2.0F, false));
        this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0));
        this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(5, new LookAroundGoal(this));
        this.targetSelector.add(1, new TrackOwnerAttackerCustomGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerCustomGoal(this));
        this.targetSelector.add(3, new UniversalAngerGoal(this, true));
    }

    static {
        TAMEABLE_FLAGS = DataTracker.registerData(TameableEntity.class, TrackedDataHandlerRegistry.BYTE);
        OWNER_UUID = DataTracker.registerData(TameableEntity.class, TrackedDataHandlerRegistry.OPTIONAL_UUID);
    }
}

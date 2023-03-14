package net.joshnaks.silly1.entity.custom;

import net.joshnaks.silly1.entity.ModEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.entity.projectile.ProjectileUtil;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.RegistryKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Iterator;

public class NaughtigenProjectile extends ProjectileEntity implements GeoEntity
{
    private static final TrackedData<? super Byte> PROJECTILE_FLAGS;
    private static final TrackedData<? super Byte> PIERCE_LEVEL;
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    protected boolean inGround;
    protected int inGroundTime;

    private int life;

    private BlockState inBlockState;

    private void fall() {
        this.inGround = false;
        Vec3d vec3d = this.getVelocity();
        this.setVelocity(vec3d.multiply((double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F), (double)(this.random.nextFloat() * 0.2F)));
        this.life = 0;
    }

    private boolean shouldFall() {
        return this.inGround && this.world.isSpaceEmpty((new Box(this.getPos(), this.getPos())).expand(0.06));
    }

    public NaughtigenProjectile(EntityType<? extends NaughtigenProjectile> entityType, World world) {
        super(entityType, world);
    }

    public NaughtigenProjectile(World world, LivingEntity owner) {
        super(ModEntities.NAUGHTIGEN_PROJECTILE,world);
        this.setOwner(owner);
    }

    public static DefaultAttributeContainer.Builder setAttributes()
    {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 1.0);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity entity = entityHitResult.getEntity();

        if(!entity.world.isClient())
        {

            MinecraftServer minecraftServer = entity.getServer();
            RegistryKey<World> registryKey = entity.world.getRegistryKey() == World.END ? World.END : World.END;
            ServerWorld serverWorld2 = minecraftServer.getWorld(registryKey);
            if(serverWorld2 != null)
            {

                //entity.setInNetherPortal(entity.getBlockPos());
                entity.moveToWorld(serverWorld2);
            }

            this.discard();
        }

    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    public byte getPierceLevel() {
        return (Byte)this.dataTracker.get(PIERCE_LEVEL);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(PROJECTILE_FLAGS, (byte)0);
        this.dataTracker.startTracking(PIERCE_LEVEL, (byte)0);
    }

    private void setProjectileFlag(int index, boolean flag) {
        byte b = (Byte)this.dataTracker.get(PROJECTILE_FLAGS);
        if (flag) {
            this.dataTracker.set(PROJECTILE_FLAGS, (byte)(b | index));
        } else {
            this.dataTracker.set(PROJECTILE_FLAGS, (byte)(b & ~index));
        }

    }

    public void setNoClip(boolean noClip) {
        this.noClip = noClip;
        this.setProjectileFlag(2, noClip);
    }

    public boolean isNoClip() {
        if (!this.world.isClient) {
            return this.noClip;
        } else {
            return ((Byte)this.dataTracker.get(PROJECTILE_FLAGS) & 2) != 0;
        }
    }

    public void setVelocityClient(double x, double y, double z) {
        super.setVelocityClient(x, y, z);
    }

    protected void age() {
        ++this.life;
        if (this.life >= 1200) {
            this.discard();
        }

    }

    @Nullable
    protected EntityHitResult getEntityCollision(Vec3d currentPosition, Vec3d nextPosition) {
        return ProjectileUtil.getEntityCollision(this.world, this, currentPosition, nextPosition, this.getBoundingBox().stretch(this.getVelocity()).expand(1.0), this::canHit);
    }

    public void tick() {
        super.tick();
        boolean bl = this.isNoClip();
        Vec3d vec3d = this.getVelocity();
        if (this.prevPitch == 0.0F && this.prevYaw == 0.0F) {
            double d = vec3d.horizontalLength();
            this.setYaw((float)(MathHelper.atan2(vec3d.x, vec3d.z) * 57.2957763671875));
            this.setPitch((float)(MathHelper.atan2(vec3d.y, d) * 57.2957763671875));
            this.prevYaw = this.getYaw();
            this.prevPitch = this.getPitch();
        }

        BlockPos blockPos = this.getBlockPos();
        BlockState blockState = this.world.getBlockState(blockPos);
        Vec3d vec3d2;
        if (!blockState.isAir() && !bl) {
            VoxelShape voxelShape = blockState.getCollisionShape(this.world, blockPos);
            if (!voxelShape.isEmpty()) {
                vec3d2 = this.getPos();
                Iterator var7 = voxelShape.getBoundingBoxes().iterator();

                while(var7.hasNext()) {
                    Box box = (Box)var7.next();
                    if (box.offset(blockPos).contains(vec3d2)) {
                        this.inGround = true;
                        this.discard();
                        break;
                    }
                }
            }
        }

        if (this.isTouchingWaterOrRain() || blockState.isOf(Blocks.POWDER_SNOW)) {
            this.extinguish();
        }

        if (this.inGround && !bl) {
            if (this.inBlockState != blockState && this.shouldFall()) {
                this.fall();
            } else if (!this.world.isClient) {
                this.age();
            }

            ++this.inGroundTime;
        } else {
            this.inGroundTime = 0;
            Vec3d vec3d3 = this.getPos();
            vec3d2 = vec3d3.add(vec3d);
            HitResult hitResult = this.world.raycast(new RaycastContext(vec3d3, vec3d2, RaycastContext.ShapeType.COLLIDER, RaycastContext.FluidHandling.NONE, this));
            if (((HitResult)hitResult).getType() != HitResult.Type.MISS) {
                vec3d2 = ((HitResult)hitResult).getPos();
            }

            while(!this.isRemoved()) {
                EntityHitResult entityHitResult = this.getEntityCollision(vec3d3, vec3d2);
                if (entityHitResult != null) {
                    hitResult = entityHitResult;
                }

                if (hitResult != null && ((HitResult)hitResult).getType() == HitResult.Type.ENTITY) {
                    Entity entity = ((EntityHitResult)hitResult).getEntity();
                    Entity entity2 = this.getOwner();
                    if (entity instanceof PlayerEntity && entity2 instanceof PlayerEntity && !((PlayerEntity)entity2).shouldDamagePlayer((PlayerEntity)entity)) {
                        hitResult = null;
                        entityHitResult = null;
                    }
                }

                if (hitResult != null && !bl) {
                    this.onCollision((HitResult)hitResult);
                    this.velocityDirty = true;
                }

                if (entityHitResult == null || this.getPierceLevel() <= 0) {
                    break;
                }

                hitResult = null;
            }

            vec3d = this.getVelocity();
            double e = vec3d.x;
            double f = vec3d.y;
            double g = vec3d.z;


            double h = this.getX() + e;
            double j = this.getY() + f;
            double k = this.getZ() + g;
            double l = vec3d.horizontalLength();
            if (bl) {
                this.setYaw((float)(MathHelper.atan2(-e, -g) * 57.2957763671875));
            } else {
                this.setYaw((float)(MathHelper.atan2(e, g) * 57.2957763671875));
            }

            this.setPitch((float)(MathHelper.atan2(f, l) * 57.2957763671875));
            this.setPitch(updateRotation(this.prevPitch, this.getPitch()));
            this.setYaw(updateRotation(this.prevYaw, this.getYaw()));
            float m = 0.99F;
            float n = 0.05F;
            if (this.isTouchingWater()) {
                for(int o = 0; o < 4; ++o) {
                    float p = 0.25F;
                    this.world.addParticle(ParticleTypes.BUBBLE, h - e * 0.25, j - f * 0.25, k - g * 0.25, e, f, g);
                }

                m = this.getDragInWater();
            }

            this.setVelocity(vec3d.multiply((double)m));
            if (!this.hasNoGravity() && !bl) {
                Vec3d vec3d4 = this.getVelocity();
                this.setVelocity(vec3d4.x, vec3d4.y - 0.05000000074505806, vec3d4.z);
            }

            this.setPosition(h, j, k);
            this.checkBlockCollision();
        }
    }

    protected float getDragInWater() {
        return 0.6F;
    }

    static {
        PROJECTILE_FLAGS = DataTracker.registerData(PersistentProjectileEntity.class, TrackedDataHandlerRegistry.BYTE);
        PIERCE_LEVEL = DataTracker.registerData(PersistentProjectileEntity.class, TrackedDataHandlerRegistry.BYTE);
    }
}

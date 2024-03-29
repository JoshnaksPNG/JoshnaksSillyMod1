package net.joshnaks.silly1.mixin;

import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class ModEntityDataSaverMixin implements IEntityDataSaver
{
    private NbtCompound persistentData;
    private String dataKey = SillyMod1.MOD_ID + "_data";

    @Override
    public NbtCompound getPersistentData()
    {
        if(this.persistentData ==  null)
        {
            this.persistentData = new NbtCompound();
        }

        return persistentData;
    }

    @Inject(method = "writeNbt", at = @At("HEAD"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if(persistentData != null && ((Entity) (Object) this) instanceof PlayerEntity) {
            nbt.put(dataKey, persistentData);
        }
    }

    @Inject(method = "readNbt", at = @At("HEAD"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains(dataKey, 10) && ((Entity) (Object) this) instanceof PlayerEntity) {
            persistentData = nbt.getCompound(dataKey);
        }
    }
}

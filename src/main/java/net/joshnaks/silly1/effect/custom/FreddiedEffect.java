package net.joshnaks.silly1.effect.custom;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.joshnaks.silly1.entity.custom.HuskSlaveEntity;
import net.joshnaks.silly1.networking.ModMessages;
import net.joshnaks.silly1.sounds.ModSoundEvents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;

public class FreddiedEffect extends StatusEffect
{
    public FreddiedEffect()
    {
        super(StatusEffectCategory.BENEFICIAL, 0xFFACAC);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier)
    {
        return true;
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier)
    {
        /*entity.getEntityWorld().playSound(
                null,
                entity.getBlockPos(),
                ModSoundEvents.FREDDY_ON_EVENT,
                SoundCategory.AMBIENT,
                1f,1f);*/

        if(entity instanceof PlayerEntity player && player.getServer() != null)
        {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBoolean(true);
            ServerPlayNetworking.send((ServerPlayerEntity) player, ModMessages.FREDDY_MASK_ID, buf);
        }


        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if(entity instanceof PlayerEntity player && player.getServer() != null)
        {
            PacketByteBuf buf = PacketByteBufs.create();
            buf.writeBoolean(false);
            ServerPlayNetworking.send((ServerPlayerEntity) player, ModMessages.FREDDY_MASK_ID, buf);
        }
    }
}

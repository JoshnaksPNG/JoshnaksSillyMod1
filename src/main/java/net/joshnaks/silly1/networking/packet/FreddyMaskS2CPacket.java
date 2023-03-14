package net.joshnaks.silly1.networking.packet;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.joshnaks.silly1.item.ModItems;
import net.joshnaks.silly1.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;

public class FreddyMaskS2CPacket {
    public static void recieve(MinecraftClient client, ClientPlayNetworkHandler handler,
                               PacketByteBuf buf, PacketSender responseSender)
    {
        Iterable<ItemStack> armor = client.player.getArmorItems();

        ((IEntityDataSaver) client.player).getPersistentData().putBoolean("Freddy", buf.readBoolean());

    }
}

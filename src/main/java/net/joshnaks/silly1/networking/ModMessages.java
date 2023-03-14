package net.joshnaks.silly1.networking;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.joshnaks.silly1.SillyMod1;
import net.joshnaks.silly1.networking.packet.FreddyMaskS2CPacket;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.util.Identifier;

public class ModMessages
{
    public static final Identifier FREDDY_MASK_ID = new Identifier(SillyMod1.MOD_ID, "freddy_mask");

    public static void registerC2SPackets()
    {}

    public static void registerS2CPackets()
    {
        ClientPlayNetworking.registerGlobalReceiver(FREDDY_MASK_ID, FreddyMaskS2CPacket::recieve);
    }
}

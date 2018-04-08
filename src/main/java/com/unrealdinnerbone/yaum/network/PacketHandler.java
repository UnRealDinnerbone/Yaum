package com.unrealdinnerbone.yaum.network;

import com.unrealdinnerbone.yaum.Yaum;
import com.unrealdinnerbone.yaum.api.event.PacketRegisterEvent;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public class PacketHandler {

    public static SimpleNetworkWrapper INSTANCE;

    public static void registerMessages() {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
        PacketRegisterEvent event = new PacketRegisterEvent(INSTANCE);
        MinecraftForge.EVENT_BUS.post(event);
        Yaum.getInstance().getLogHelper().info("Registed " + event.getId() + " packets");
    }
}
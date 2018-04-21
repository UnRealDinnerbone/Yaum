package com.unrealdinnerbone.yaum.event.register;

import com.unrealdinnerbone.yaum.api.event.PacketRegisterEvent;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.network.PacketSpawnFirework;
import com.unrealdinnerbone.yaum.network.PacketSpawnParticle;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventRegisterPackets
{
    @SubscribeEvent
    public static void registerPackets(PacketRegisterEvent event) {
        event.registerMessage(PacketSpawnParticle.class, PacketSpawnParticle.class, Side.CLIENT);
        event.registerMessage(PacketSpawnFirework.class, PacketSpawnFirework.class, Side.CLIENT);
    }
}

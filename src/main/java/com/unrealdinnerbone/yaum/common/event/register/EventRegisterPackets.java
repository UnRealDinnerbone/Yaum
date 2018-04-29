package com.unrealdinnerbone.yaum.common.event.register;

import com.unrealdinnerbone.yaum.api.event.PacketRegisterEvent;
import com.unrealdinnerbone.yaum.common.network.PacketSpawnFirework;
import com.unrealdinnerbone.yaum.common.network.PacketSpawnParticle;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventRegisterPackets
{
    @SubscribeEvent
    public static void registerPackets(PacketRegisterEvent event) {
        event.registerMessage(PacketSpawnParticle.class, Side.CLIENT);
        event.registerMessage(PacketSpawnFirework.class, Side.CLIENT);
    }
}

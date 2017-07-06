package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.YaumRegistry;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;

public class EventSoundRegister
{
    private final static HashMap<String, EventSoundRegister> eventSoundRegistries = new HashMap<>();


    private final String MOD_ID;

    public EventSoundRegister(String ModID)
    {
        this.MOD_ID = ModID;
        eventSoundRegistries.put(ModID, this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void soundRegisterEvent(RegistryEvent.Register<SoundEvent> event)
    {
        YaumRegistry yaumRegistry = YaumRegistry.getModRegistry(MOD_ID);
        yaum.getLogHelper().info("Starting SoundEvent registering for " + MOD_ID + "...");
        for (SoundEvent sound : yaumRegistry.getRegistereSounds()) {
            yaum.getLogHelper().debug("Registering Sound... " + sound.getSoundName());
            event.getRegistry().registerAll(sound);
        }
        yaum.getLogHelper().info("Finished Sound registering for " + MOD_ID);
    }
}

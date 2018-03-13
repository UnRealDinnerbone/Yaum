package com.unrealdinnerbone.yaum.client.event.registeies;

import com.unrealdinnerbone.yaum.api.Registry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventSoundRegister
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void soundRegisterEvent(RegistryEvent.Register<SoundEvent> event) {
        Registry.getSoundRegister().getWrapperList().forEach(wrapper -> wrapper.getB().register(event.getRegistry(), (wrapper.getA())));
    }
}

package com.unrealdinnerbone.yaum.client.event.registeies;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
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
    public static void soundRegisterEvent(RegistryEvent.Register<SoundEvent> event)
    {
        for(YaumRegistry yaumRegistry: YaumRegistry.getRegistries().values())
        {
            ModContainer container = FMLCommonHandler.instance().findContainerFor(yaumRegistry.getModID());
            event.setModContainer(container);
            yaumRegistry.getLogHelper().info("Starting SoundEvent registering");
            for (SoundEvent sound : yaumRegistry.getResistedSounds()) {
                yaumRegistry.getLogHelper().debug("Registering Sound... " + sound.getSoundName());
                event.getRegistry().register(sound);
            }
            yaumRegistry.getLogHelper().info("Finished Sound registering");
        }
    }
}

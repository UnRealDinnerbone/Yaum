package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.Registry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventItemRegister {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Registry.getItemRegister().getWrapperList().forEach(wrapper -> wrapper.getB().register(event.getRegistry(), wrapper.getA()));
    }
}


package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;
import java.util.Map;


@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class YaumEventRegister {


    @SubscribeEvent
    public static void register(RegistryEvent.Register event) {
        for(List<Map.Entry<IYaumMod, IYaumObject>> entryList: Register.getRegistedObject().values()) {
            for(Map.Entry<IYaumMod, IYaumObject> entry: entryList) {
                if(entry.getValue().get().getRegistryType().toString().equalsIgnoreCase(event.getRegistry().getRegistrySuperType().toString())) {
                    ModContainer pre = Loader.instance().activeModContainer();
                    Loader.instance().setActiveModContainer(entry.getKey().getModContainer());
                    entry.getValue().register(event, entry.getKey());
                    Loader.instance().setActiveModContainer(pre);
                }
            }
        }
    }
}

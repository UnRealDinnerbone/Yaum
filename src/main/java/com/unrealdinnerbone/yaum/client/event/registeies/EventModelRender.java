package com.unrealdinnerbone.yaum.client.event.registeies;

import com.unrealdinnerbone.yaum.api.Registry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventModelRender
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void renderModels(ModelRegistryEvent event) {
        Registry.getBlockRegister().getWrapperList().forEach(wrapper -> wrapper.getB().render(event, wrapper.getA()));
        Registry.getItemRegister().getWrapperList().forEach(wrapper -> wrapper.getB().render(event, wrapper.getA()));
    }
}

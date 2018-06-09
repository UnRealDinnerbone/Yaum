package com.unrealdinnerbone.yaum.client.event.gui;

import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class MouseClickEvent {

    @SubscribeEvent
    public static void mouseClientEvent(GuiScreenEvent.MouseInputEvent event) {
        if(event.getGui() instanceof GuiContainerCreative) {
            GuiContainerCreative containerCreative = (GuiContainerCreative) event.getGui();
//            containerCreative.
        }
    }
}

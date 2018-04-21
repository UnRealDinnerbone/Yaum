package com.unrealdinnerbone.yaum.client.event.rendering;

import com.unrealdinnerbone.yaum.common.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventRenderGameOverlay
{


    @SubscribeEvent
    public static void onGuiOpenEvent(GuiScreenEvent.InitGuiEvent event) {
        if (YaumConfiguration.ClientConfig.Tweaks.disableRecipeBook && event.getButtonList() != null && !event.getButtonList().isEmpty())  {
            for (GuiButton button : event.getButtonList()) {
                if (button.id == 10) {
                    button.enabled = false;
                    button.visible = false;
                }
            }
        }
    }
}

package com.unrealdinnerbone.yaum.client.event.rendering;

import com.unrealdinnerbone.yaum.common.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
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
        if (YaumConfiguration.clientConfig.tweaks.disableRecipeBook && event.getButtonList() != null && !event.getButtonList().isEmpty())  {
            event.getButtonList().stream().filter(button -> button.id == 10).forEach(button -> {
                button.enabled = false;
                button.visible = false;
            });
        }
    }
}

package com.unrealdinnerbone.yaum.client.event.rendering;

import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.helpers.GuiHelper;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventRenderGameOverlay
{

    @SubscribeEvent
    public static void onGameOverlayRenderPost(RenderGameOverlayEvent.Post event) {
        try {
            if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
                if (!GuiHelper.getOverylaysToRender().isEmpty()) {
                    GuiHelper.getOverylaysToRender().get(0).drawOverlay();
                }
            }

        } catch (Exception e) {
            yaum.getRegistry().getLogHelper().error("And error happened while trying to render and GUI Server Overlay : " + e.getMessage());
        }

    }
}

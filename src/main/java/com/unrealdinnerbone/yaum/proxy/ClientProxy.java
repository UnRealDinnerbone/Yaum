package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.client.render.PlayerRenderLayer;
import com.unrealdinnerbone.yaum.libs.helpers.DownloadHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        super.onPreInt(event);
    }

    @Override
    public void onInt(FMLInitializationEvent event) {
        super.onInt(event);
    }

    @Override
    public void onPostInt(FMLPostInitializationEvent event) {
        super.onPostInt(event);
        PlayerRenderLayer layer = new PlayerRenderLayer();
        for (RenderPlayer playerRender : Minecraft.getMinecraft().getRenderManager().getSkinMap().values()) {
            playerRender.addLayer(layer);
        }
    }

    @Override
    public void displayGUIScreen(GuiScreen guiScreen) {
        Minecraft.getMinecraft().displayGuiScreen(guiScreen);
    }
}
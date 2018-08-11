package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.texture.TextureRegister;
import com.unrealdinnerbone.yaum.api.texture.TextureWrapper;
import com.unrealdinnerbone.yaum.client.render.PlayerRenderLayer;
import com.unrealdinnerbone.yaum.libs.Reference;
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
        TextureRegister.registerTextureManager(Reference.MOD_ID, Reference.SUPPORTER_TEXTURE_JSON);
    }

    @Override
    public void onInt(FMLInitializationEvent event) {
        super.onInt(event);
    }

    @Override
    public void onPostInt(FMLPostInitializationEvent event) {
        super.onPostInt(event);
        PlayerRenderLayer layer = new PlayerRenderLayer();
        Minecraft.getMinecraft().getRenderManager().getSkinMap().values().forEach(playerRender -> playerRender.addLayer(layer));
//        TextureLoader.reload();
    }

    @Override
    public void displayGUIScreen(GuiScreen guiScreen) {
        Minecraft.getMinecraft().addScheduledTask(() -> Minecraft.getMinecraft().displayGuiScreen(guiScreen));
    }


    @Override
    public void spawnParticle(int id, boolean shouldIgnoreRange, float x, float y, float z, float xSpeed, float ySpeed, float zSpeed, int dimID) {
        Minecraft.getMinecraft().effectRenderer.spawnEffectParticle(id, x, y, z, xSpeed, ySpeed, zSpeed);
    }
}
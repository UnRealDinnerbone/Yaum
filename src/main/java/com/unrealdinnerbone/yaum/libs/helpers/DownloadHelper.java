package com.unrealdinnerbone.yaum.libs.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class DownloadHelper {

    public static void downloadResourceLocation(String url, ResourceLocation outputResourceLocation, ResourceLocation errorResourceLocation) {
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        ThreadDownloadImageData imageData = (ThreadDownloadImageData) textureManager.getTexture(outputResourceLocation);
        if (imageData == null) {
            imageData = new ThreadDownloadImageData(null, url, errorResourceLocation, null);
            textureManager.loadTexture(outputResourceLocation, imageData);
        }else {
            textureManager.loadTexture(outputResourceLocation, imageData);
        }
    }

}

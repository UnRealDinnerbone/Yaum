package com.unrealdinnerbone.yaum.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.font.TextMeasurer;

public class DownloadHelper {

    @SideOnly(Side.CLIENT)
    public static ResourceLocation downloadResourceLocation(String url, ResourceLocation outputResourceLocation, ResourceLocation errorResourceLocation) {
        downloadResource(url, outputResourceLocation, errorResourceLocation);
        return outputResourceLocation;
    }

    @SideOnly(Side.CLIENT)
    public static ThreadDownloadImageData downloadResource(String url, ResourceLocation outputResourceLocation, ResourceLocation errorResourceLocation) {
        final TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        ThreadDownloadImageData imageData = (ThreadDownloadImageData) textureManager.getTexture(outputResourceLocation);
        if (imageData == null) {
            imageData = new ThreadDownloadImageData(null, url, errorResourceLocation, null);
            textureManager.loadTexture(outputResourceLocation, imageData);
        }
        return imageData;
    }
}

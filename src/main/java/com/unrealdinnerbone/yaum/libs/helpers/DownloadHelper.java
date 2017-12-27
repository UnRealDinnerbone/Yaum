package com.unrealdinnerbone.yaum.libs.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.font.TextMeasurer;

@SideOnly(Side.CLIENT)
public class DownloadHelper {

    public static ResourceLocation downloadResourceLocation(String url, ResourceLocation outputResourceLocation, ResourceLocation errorResourceLocation) {
        downloadResource(url, outputResourceLocation, errorResourceLocation);
        return outputResourceLocation;
    }

    public static ThreadDownloadImageData downloadResource(String url, ResourceLocation outputResourceLocation, ResourceLocation errorResourceLocation) {
        final TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        ThreadDownloadImageData imageData = (ThreadDownloadImageData) textureManager.getTexture(outputResourceLocation);
        if (imageData == null) {
            imageData = new ThreadDownloadImageData(null, url, errorResourceLocation, null);
            textureManager.loadTexture(outputResourceLocation, imageData);
        }else
        {
            textureManager.loadTexture(outputResourceLocation, imageData);
        }
        return imageData;
    }

    public static void a()
    {

        downloadResource("https://github.com/FlatStoneTech/AppliedLogistics/blob/develop/src/main/resources/assets/minecraft/textures/blocks/gold_block.png?raw=true", new ResourceLocation("minecraft", "textures/blocks/gold_block.png"), new ResourceLocation("minecraft", "textures/blocks/iron_block.png"));
    }



}

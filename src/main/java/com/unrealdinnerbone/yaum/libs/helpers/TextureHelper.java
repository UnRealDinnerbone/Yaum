package com.unrealdinnerbone.yaum.libs.helpers;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;

public class TextureHelper
{
    public static void registerItemTexture(Item item, ResourceLocation location) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(location, "inventory"));
    }
    public static void changeTextureLocation(Item item, String newModID, String name) {
        registerItemTexture(item, new ResourceLocation(newModID, name));
    }
}

package com.unrealdinnerbone.yaum.api.texture;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class TextureRegister
{
    private static List<Map.Entry<String, String>> textureManagerList;

    static {
        textureManagerList = new ArrayList<>();
    }

    public static void registerTextureManager(String id, String url) {
        textureManagerList.add(new AbstractMap.SimpleEntry<>(id, url));
    }

    public static List<Map.Entry<String, String>> getTextureManagerList() {
        return textureManagerList;
    }
}

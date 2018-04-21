package com.unrealdinnerbone.yaum.api.texture;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@SideOnly(Side.CLIENT)
public class TextureWrapper
{
    private String modID;
    private List<WebTexture> textures;

    public List<WebTexture> getTextures() {
        return textures == null ? new ArrayList<>() : textures;
    }

    public String getModID() {
        return modID;
    }

    @Nullable
    public WebTexture getTextureByID(String id) {
        return textures.stream().filter(texture -> texture.getId().equalsIgnoreCase(id)).findFirst().orElse(null);
    }
}

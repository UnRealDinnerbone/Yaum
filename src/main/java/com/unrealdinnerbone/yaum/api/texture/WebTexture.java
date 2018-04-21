package com.unrealdinnerbone.yaum.api.texture;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SideOnly(Side.CLIENT)
public class WebTexture
{
    private String id;
    private String url;
    @Nullable
    private String location;

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    @Nonnull
    public ResourceLocation getLocation() {
        return location == null ? new ResourceLocation(id, "textures/download/" + url) : new ResourceLocation(id, "textures/" + url);
    }

}

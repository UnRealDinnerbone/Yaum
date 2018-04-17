package com.unrealdinnerbone.yaum.texture;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

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

    public ResourceLocation getLocation() {
        return location == null ? new ResourceLocation(id, "textures/download") : new ResourceLocation(id, "textures/" + url);
    }

}

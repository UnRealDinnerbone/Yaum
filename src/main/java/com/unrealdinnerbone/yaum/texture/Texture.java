package com.unrealdinnerbone.yaum.texture;

import net.minecraft.util.ResourceLocation;

public class Texture
{
    private String id;
    private String url;
    private ResourceLocation location;


    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public void setLocation(ResourceLocation location) {
        this.location = location;
    }

    public ResourceLocation getLocation() {
        return location;
    }

}

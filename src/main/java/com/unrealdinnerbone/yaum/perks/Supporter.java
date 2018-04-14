package com.unrealdinnerbone.yaum.perks;

import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.proxy.ClientProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

public class Supporter {

    private UUID playerUUID;
    private String playerName;
    private String type;
    private boolean fancyChat;
    private String elytra;
    private String cape;

    public Supporter(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getCapeTexture() {
        ResourceLocation location = Reference.MISSING_CAPE;
        if(ClientProxy.getTextureManager().getWrapper() != null) {
            location = ClientProxy.getTextureManager().getWrapper().getTextureByID(cape).getLocation();
            if (location == null || location == Reference.TEXTURE_404) {
                location = Reference.MISSING_CAPE;
            }
        }
        return location;
    }


    @SideOnly(Side.CLIENT)
    public ResourceLocation getElytraTexture() {
        ResourceLocation location = Reference.MISSING_ELYTRA;
        if(ClientProxy.getTextureManager().getWrapper() != null) {
            location = ClientProxy.getTextureManager().getWrapper().getTextureByID(elytra).getLocation();
            if (location == null || location == Reference.TEXTURE_404) {
                location = Reference.MISSING_ELYTRA;
            }
        }
        return location;
    }

    public boolean hasFancyChat() {
        return fancyChat;
    }

    public String getType() {
        return type;
    }
}

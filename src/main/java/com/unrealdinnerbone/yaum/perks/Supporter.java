package com.unrealdinnerbone.yaum.perks;

import com.unrealdinnerbone.yaum.libs.helpers.DownloadHelper;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

public class Supporter {

    private UUID playerID;
    private String playerName;
    private String type;
    private boolean cape;
    private boolean elytra;
    private boolean fancyChat;
    private String elytraTexture;
    private String capeTexture;

    public Supporter(UUID playerID) {
        this.playerID = playerID;
    }

    public UUID getPlayerID() {
        return this.playerID;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getCapeTexture() {
        return this.capeTexture != null && !this.capeTexture.isEmpty() ? DownloadHelper.downloadResourceLocation(this.capeTexture, new ResourceLocation(Reference.MOD_ID, "cape/" + this.playerID.toString()), Reference.MISSING_CAPE) : null;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getElytraTexture() {
        return this.elytraTexture != null && !this.elytraTexture.isEmpty() ? DownloadHelper.downloadResourceLocation(this.elytraTexture, new ResourceLocation(Reference.MOD_ID, "elytra/" + this.getPlayerID().toString()), Reference.MISSING_ELYTRA) : null;
    }

    public boolean hasCape() {
        return cape;
    }

    public boolean hasElytra() {
        return elytra;
    }

    public boolean hasFancyChat() {
        return fancyChat;
    }
}

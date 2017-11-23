package com.unrealdinnerbone.yaum.perks;

import com.unrealdinnerbone.yaum.libs.helpers.DownloadHelper;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

public class Supporter {

    private final UUID PLAYER_UUID;
    private final boolean CAPE;
    private final boolean ELYTRA;
    private final String ELYTRA_TEXTURE;
    private final String CAPE_TEXTURE;
    private final Boolean FANCY_CHAT;

    public Supporter(UUID playerID, boolean cape, boolean elytra, String elytraTexture, String capeTexture, boolean fancyChat) {
        this.PLAYER_UUID = playerID;
        this.CAPE = cape;
        this.ELYTRA = elytra;
        this.ELYTRA_TEXTURE = elytraTexture;
        this.CAPE_TEXTURE = capeTexture;
        this.FANCY_CHAT = fancyChat;
    }

    public UUID getPlayerID() {

        return this.PLAYER_UUID;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getCapeTexture() {
        return this.CAPE_TEXTURE != null && !this.CAPE_TEXTURE.isEmpty() ? DownloadHelper.downloadResourceLocation(this.CAPE_TEXTURE, new ResourceLocation(Reference.MOD_ID, "cape/" + this.PLAYER_UUID.toString()), Reference.MISSING_CAPE) : null;
    }

    @SideOnly(Side.CLIENT)
    public ResourceLocation getElytraTexture() {

        return this.ELYTRA_TEXTURE != null && !this.ELYTRA_TEXTURE.isEmpty() ? DownloadHelper.downloadResourceLocation(this.ELYTRA_TEXTURE, new ResourceLocation(Reference.MOD_ID, "elytra/" + this.getPlayerID().toString()), Reference.MISSING_ELYTRA) : null;
    }

    public boolean hasCape() {
        return CAPE;
    }

    public boolean hasElytra() {
        return ELYTRA;
    }

    public boolean hasFancyChat() {
        return FANCY_CHAT;
    }
}

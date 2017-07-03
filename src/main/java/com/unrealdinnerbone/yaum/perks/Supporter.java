package com.unrealdinnerbone.yaum.perks;

import com.unrealdinnerbone.yaum.util.DownloadHelper;
import com.unrealdinnerbone.yaum.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

public class Supporter
{
    private static final ResourceLocation MISSING_CAPE = new ResourceLocation(Reference.MOD_ID, "textures/entity/player/cape_error.png");
    private static final ResourceLocation MISSING_ELYTRA = new ResourceLocation(Reference.MOD_ID, "textures/entity/player/elytra_error.png");


        private final UUID PLAYER_UUID;
        private final String TYPE;
        private final boolean cape;
        private final boolean elytra;
        private final String ELYTRA_TEXTURE;
        private final String CAPE_TEXTURE;

        protected Supporter(UUID playerID, boolean cape, boolean elytra, String type, String elytraTexture, String capeTexture) {

            this.PLAYER_UUID = playerID;
            this.TYPE = type;
            this.cape = cape;
            this.elytra = elytra;
            this.ELYTRA_TEXTURE = elytraTexture;
            this.CAPE_TEXTURE = capeTexture;
        }

        public UUID getPlayerID() {

            return this.PLAYER_UUID;
        }

        public String getCapeTextureURL() {

            return this.CAPE_TEXTURE;
        }

        public String getElytraTextureURL() {

            return this.ELYTRA_TEXTURE;
        }

        @SideOnly(Side.CLIENT)
        public ResourceLocation getCapeTexture() {
            return this.CAPE_TEXTURE != null && !this.CAPE_TEXTURE.isEmpty() ? DownloadHelper.downloadResourceLocation(this.CAPE_TEXTURE, new ResourceLocation(Reference.MOD_ID, "cape/" + this.PLAYER_UUID.toString()), MISSING_CAPE, null) : null;
        }

        @SideOnly(Side.CLIENT)
        public ResourceLocation getElytraTexture() {

            return this.ELYTRA_TEXTURE != null && !this.ELYTRA_TEXTURE.isEmpty() ? DownloadHelper.downloadResourceLocation(this.ELYTRA_TEXTURE, new ResourceLocation(Reference.MOD_ID, "elytra/" + this.getPlayerID().toString()), MISSING_ELYTRA, null) : null;
        }

        public String getType() {

            return this.TYPE;
        }
        public boolean getsCape()
        {
            return cape;
        }
        public boolean getElytra()
        {
            return elytra;
        }
}

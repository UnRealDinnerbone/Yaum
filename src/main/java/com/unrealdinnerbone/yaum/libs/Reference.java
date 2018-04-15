package com.unrealdinnerbone.yaum.libs;

import net.minecraft.util.ResourceLocation;

public class Reference {

    public static final String MOD_ID = "yaum";
    public static final String MOD_NAME = "YAUM - (Yet Another util Mod)";
    public static final String VERSION = "4.2.3";
    public static final String MC_VERSION = "1.12.2";
    public static final String GUI_FACTORY_CLASS = "com.unrealdinnerbone.yaum.client.gui.ModConfigGUI";
    public static final String CLIENT_PROXY = "com.unrealdinnerbone.yaum.proxy.ClientProxy";
    public static final String SERVER_PROXY = "com.unrealdinnerbone.yaum.proxy.ServerProxy";
    private static final String DATA_REPO_LOCATION = "https://raw.githubusercontent.com/UnRealDinnerbone/Data/master/Minecraft/";
    public static final String MOD_UPDATE_JSON_URL = DATA_REPO_LOCATION + "Mods/Yaum/Update.json";
    public static final String SUPPORTER_DATA_JSON = DATA_REPO_LOCATION + "Mods/Yaum/Supporters.json";
    public static final String SUPPORTER_TEXTURE_JSON = DATA_REPO_LOCATION + "Mods/Yaum/Textures.json";

    public static final ResourceLocation MISSING_CAPE = new ResourceLocation(MOD_ID, "textures/entity/player/cape_error.png");
    public static final ResourceLocation MISSING_ELYTRA = new ResourceLocation(MOD_ID, "textures/entity/player/elytra_error.png");
    public static final ResourceLocation TEXTURE_404 = new ResourceLocation(MOD_ID, "textures/404.png");
}
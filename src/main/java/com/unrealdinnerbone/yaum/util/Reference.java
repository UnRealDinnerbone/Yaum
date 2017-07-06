package com.unrealdinnerbone.yaum.util;

import net.minecraft.util.ResourceLocation;

public class Reference
{
  public static final String MOD_ID = "yaum";
  public static final String MOD_NAME = "YAUM - (Yet Another Util Mod)";
  public static final String VERSION = "1.1.1";
  public static final String MC_VERSION = "1.12";
  public static final String SERVER_SIDE = "com.unrealdinnerbone.yaum.proxy.ServerProxy";
  public static final String CLIENT_SIDE = "com.unrealdinnerbone.yaum.proxy.ClientProxy";
  public static final String GUI_FACTORY_CLASS = "com.unrealdinnerbone.yaum.client.gui.GuiFactory";
  //Todo ModUpdate Json File
  private static final String DATA_REPO_LOCATION = "https://raw.githubusercontent.com/UnRealDinnerbone/Data/master/Minecraft/";
  public static final String MOD_UPDATE_JSON_URL = DATA_REPO_LOCATION + "Mods/Yaum/Update.json";
  public static final String SUPPORTER_DATA_JSON = DATA_REPO_LOCATION + "Supporters/SupportsPerks.json";

  public static final ResourceLocation MISSING_CAPE = new ResourceLocation(Reference.MOD_ID, "textures/entity/player/cape_error.png");
  public static final ResourceLocation MISSING_ELYTRA = new ResourceLocation(Reference.MOD_ID, "textures/entity/player/elytra_error.png");
}
package com.unrealdinnerbone.yaum;

import com.unrealdinnerbone.yaum.proxy.IProxy;
import com.unrealdinnerbone.yaum.api.YaumRegistry;
import com.unrealdinnerbone.yaum.util.LogHelper;
import com.unrealdinnerbone.yaum.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod
    (
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        guiFactory = Reference.GUI_FACTORY_CLASS,
        updateJSON = Reference.MOD_UPDATE_JSON_URL
    )
public class yaum {

  private static YaumRegistry yaumRegistry;


  @Mod.Instance(Reference.MOD_ID)
  public static yaum instance;

  @SidedProxy(clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE, modId = Reference.MOD_ID)
  public static IProxy proxy;

  private static LogHelper logHelper;

  @Mod.EventHandler
  public static void onPreInt(FMLPreInitializationEvent event)
  {
    logHelper = new LogHelper(Reference.MOD_ID);
    yaumRegistry = new YaumRegistry(Reference.MOD_ID, event);
    proxy.onPreInt(event);
  }
  @Mod.EventHandler
  public void onInt(FMLInitializationEvent event)
  {
    proxy.onInt(event);
  }
  @Mod.EventHandler
  public void onPostInt(FMLPostInitializationEvent event)
  {
    proxy.onPostInt(event);
  }


  public static LogHelper getLogHelper() {
    return logHelper;
  }


  public static YaumRegistry getYaumRegistry() {
    return yaumRegistry;
  }
}

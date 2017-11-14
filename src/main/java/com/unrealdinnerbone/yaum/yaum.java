package com.unrealdinnerbone.yaum;

import com.unrealdinnerbone.yaum.api.YurmCMD;
import com.unrealdinnerbone.yaum.proxy.IProxy;
import com.unrealdinnerbone.yaum.api.YaumRegistry;
import com.unrealdinnerbone.yaum.libs.helpers.LogHelper;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

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

  public static YaumRegistry yaumRegistry;


  @Mod.Instance(Reference.MOD_ID)
  public static yaum instance;

  @SidedProxy(clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE, modId = Reference.MOD_ID)
  public static IProxy proxy;

  public static LogHelper logHelper;

  @Mod.EventHandler
  public static void onPreInt(FMLPreInitializationEvent event)
  {
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

  @Mod.EventHandler
  public void onServerStart(FMLServerStartingEvent event) {
    for (YaumRegistry yaumRegistry : YaumRegistry.getRegistries().values()) {
      if (yaumRegistry.getYarmCommands().size() > 0) {
        event.registerServerCommand(new YurmCMD(yaumRegistry.getModID(), yaumRegistry.getYarmCommands()));
      }
    }
    proxy.onServerStart(event);
  }


  public static LogHelper getLogHelper() {
    return logHelper;
  }


  public static YaumRegistry getRegistry() {
    return yaumRegistry;
  }
}

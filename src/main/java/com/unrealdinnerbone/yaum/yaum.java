package com.unrealdinnerbone.yaum;

import com.unrealdinnerbone.yaum.config.ConfigManger;
import com.unrealdinnerbone.yaum.events.EventEntityJoinWorld;
import com.unrealdinnerbone.yaum.perks.StatsGetter;
import com.unrealdinnerbone.yaum.proxy.IProxy;
import com.unrealdinnerbone.yaum.util.HolidayUtils;
import com.unrealdinnerbone.yaum.util.LogHelper;
import com.unrealdinnerbone.yaum.util.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.File;

@Mod
    (
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        guiFactory = Reference.GUI_FACTORY_CLASS
    )
public class yaum {

  @Mod.Instance(Reference.MOD_ID)
  public static yaum instance;

  @SidedProxy(clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE, modId = Reference.MOD_ID)
  public static IProxy proxy;

  private static LogHelper logHelper;

  @Mod.EventHandler
  public static void commonPreInt(FMLPreInitializationEvent preEvent)
  {
    logHelper = new LogHelper(Reference.MOD_ID);
//    CraftingHelper.register(new ResourceLocation(Reference.MOD_ID+":custom"), new YaumRecipe());
    HolidayUtils.checkDates();
    final File folder = new File(preEvent.getModConfigurationDirectory(), "yaum");
    if (!folder.exists()) {
      folder.mkdir();
    }
    ConfigManger.init();
    ConfigManger.clientConfig(new File(folder, "client.cfg"));
    ConfigManger.generalConfig(new File(folder, "general.cfg"));
  }

  @SideOnly(Side.CLIENT)
  @Mod.EventHandler
  public static void clientPreInt(FMLPreInitializationEvent preEvent)
  {
    EventEntityJoinWorld.init();
  }


  @Mod.EventHandler
  public static void commonInt(FMLInitializationEvent intEvent)
  {
    StatsGetter.ReadPepsData();
  }

  public static LogHelper getLogHelper() {
    return logHelper;
  }
}

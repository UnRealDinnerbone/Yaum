package com.unrealdinnerbone.yaum;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import com.unrealdinnerbone.yaum.api.util.LogHelper;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.proxy.IProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod
    (
        modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION,
        acceptedMinecraftVersions = Reference.MC_VERSION,
        guiFactory = Reference.GUI_FACTORY_CLASS,
        updateJSON = Reference.MOD_UPDATE_JSON_URL
    )
public class Yaum implements IYaumMod {

    private final LogHelper logHelper = new LogHelper(Reference.MOD_ID);
    private final LangHelper langHelper = new LangHelper(Reference.MOD_ID);

    @Mod.Instance(Reference.MOD_ID)
    public static Yaum instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY, modId = Reference.MOD_ID)
    public static IProxy proxy;

    @Mod.EventHandler
    public void onPreInt(FMLPreInitializationEvent event) {
        proxy.onPreInt(event);

    }

    @Mod.EventHandler
    public void onInt(FMLInitializationEvent event) {
        proxy.onInt(event);
    }

    @Mod.EventHandler
    public void onPostInt(FMLPostInitializationEvent event) {
        proxy.onPostInt(event);
    }

    @Mod.EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        proxy.onServerStart(event);
    }

    @Override
    public String getModName() {
        return Reference.MOD_ID;
    }

    public LogHelper getLogHelper() {
        return logHelper;
    }

    public LangHelper getLangHelper() {
        return langHelper;
    }

    public static Yaum getInstance() {
        return instance;
    }

}

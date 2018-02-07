package com.unrealdinnerbone.yaum;

import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import com.unrealdinnerbone.yaum.api.util.LogHelper;
import com.unrealdinnerbone.yaum.proxy.IProxy;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
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
public class Yaum {

    private final static LogHelper logHelper = new LogHelper(Reference.MOD_ID);
    private final static LangHelper langHelper = new LangHelper(Reference.MOD_ID);

    @Mod.Instance(Reference.MOD_ID)
    public static Yaum instance;

    @SidedProxy(clientSide = Reference.CLIENT_SIDE, serverSide = Reference.SERVER_SIDE, modId = Reference.MOD_ID)
    public static IProxy proxy;

    @Mod.EventHandler
    public void onPreInt(FMLPreInitializationEvent event) {
        proxy.onPreInt(event);
    }

    @Mod.EventHandler
    @SideOnly(Side.CLIENT)
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

    public static LogHelper getLogHelper() {
        return logHelper;
    }

    public static LangHelper getLangHelper() {
        return langHelper;
    }

    public static ModContainer getModContainer() {
        return Register.getModContanier(instance);
    }
}

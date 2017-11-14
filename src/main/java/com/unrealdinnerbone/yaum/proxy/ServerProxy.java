package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.YaumRegistry;
import com.unrealdinnerbone.yaum.api.YurmCMD;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ServerProxy extends CommonProxy
{
    @Override
    public void onServerStart(FMLServerStartingEvent event) {
        for (YaumRegistry yaumRegistry : YaumRegistry.getRegistries().values()) {
            if (yaumRegistry.getYarmCommands().size() > 0) {
                event.registerServerCommand(new YurmCMD(yaumRegistry.getModID(), yaumRegistry.getYarmCommands()));
            }
        }

    }
}

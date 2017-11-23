package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.api.command.YurmCMD;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ServerProxy extends CommonProxy
{
    @Override
    public void onServerStart(FMLServerStartingEvent event) {
        for (YaumRegistry yaumRegistry : YaumRegistry.getRegistries().values()) {
            if (yaumRegistry.getResistedCommands().size() > 0) {
                event.registerServerCommand(new YurmCMD(yaumRegistry.getModID(), yaumRegistry));
            }
        }

    }
}

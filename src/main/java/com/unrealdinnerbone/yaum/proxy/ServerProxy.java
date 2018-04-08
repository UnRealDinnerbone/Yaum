package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.command.YaumCommandBase;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ServerProxy extends CommonProxy
{
    @Override
    public void onServerStart(FMLServerStartingEvent event) {
//        Register.getRegisteredCommands().keySet().stream().map(modContainer -> new YaumCommandBase(modContainer.getModId(), Register.getRegisteredCommands().get(modContainer))).forEach(event::registerServerCommand);
    }
}

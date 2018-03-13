package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.Registry;
import com.unrealdinnerbone.yaum.api.command.YaumCommandBase;
import com.unrealdinnerbone.yaum.api.command.YaumSubCommand;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void onPreInt(FMLPreInitializationEvent event) {
        super.onPreInt(event);
    }

    @Override
    public void onInt(FMLInitializationEvent event) {
        super.onInt(event);
    }

    @Override
    public void onPostInt(FMLPostInitializationEvent event) {
        super.onPostInt(event);
        for (ModContainer modContainer : Registry.getRegisteredClientCommandCommands().keySet()) {
            ArrayList<YaumSubCommand> clientCommands = Registry.getRegisteredClientCommandCommands().get(modContainer);
            if (clientCommands != null && clientCommands.size() > 0) {
                ClientCommandHandler.instance.registerCommand(new YaumCommandBase(modContainer.getModId() + "c", clientCommands));
            }
        }
    }

}
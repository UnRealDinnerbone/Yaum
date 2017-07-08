package com.unrealdinnerbone.yaum.proxy;

import com.unrealdinnerbone.yaum.api.YaumRegistry;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ServerProxy extends CommonProxy
{
    @SideOnly(Side.SERVER)
    @Override
    public void onServerStart(FMLServerStartingEvent event) {
    }
}

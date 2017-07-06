package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.IYaumBlock;
import com.unrealdinnerbone.yaum.api.YaumRegistry;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class EventBlockRegister
{
    public static HashMap<String, EventBlockRegister> blockRegisterEvents = new HashMap<>();

    private final String MOD_ID;

    public EventBlockRegister(String ModID)
    {
        this.MOD_ID = ModID;
        blockRegisterEvents.put(ModID, this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        YaumRegistry yaumRegistry = YaumRegistry.getModRegistry(MOD_ID);
        yaum.getLogHelper().info("Starting Block registering for " + MOD_ID + "...");
        for (IYaumBlock iYaumBlock : yaumRegistry.getRegisteredBlocks()) {
            iYaumBlock.getBlock().setUnlocalizedName(iYaumBlock.getBlockName().toLowerCase());
            iYaumBlock.onRegister();
            iYaumBlock.getBlock().setRegistryName(MOD_ID, iYaumBlock.getBlockName());
            yaum.getLogHelper().debug("Registering Block... " + iYaumBlock.getBlockName());
            event.getRegistry().registerAll(iYaumBlock.getBlock());
        }
        yaum.getLogHelper().info("Finished Block registering for " + MOD_ID);
    }
}

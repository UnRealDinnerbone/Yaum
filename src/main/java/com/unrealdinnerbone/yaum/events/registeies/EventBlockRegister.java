package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.registeies.YaumRegistry;
import com.unrealdinnerbone.yaum.block.YaumBlock;
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
        YaumRegistry yaumRegistry = YaumRegistry.getBlockRegistries().get(MOD_ID);
        yaum.getLogHelper().info("Starting Block registering for " + MOD_ID + "...");
        for (YaumBlock block : yaumRegistry.getRegisteredBlocks()) {
            yaum.getLogHelper().debug("Registering Block... " + block.getBlockName());
            event.getRegistry().registerAll(block.setRegistryName(MOD_ID, block.getBlockName()));
        }
        yaum.getLogHelper().info("Finished Block registering for " + MOD_ID);
    }
}

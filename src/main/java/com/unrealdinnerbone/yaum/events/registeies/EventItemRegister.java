package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.item.YaumItem;
import com.unrealdinnerbone.yaum.registeies.YaumRegistry;
import com.unrealdinnerbone.yaum.block.YaumBlock;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;

public class EventItemRegister
{
    public static HashMap<String, EventItemRegister> itemRegisterEvents = new HashMap<>();

    private final String MOD_ID;

    public EventItemRegister(String ModID)
    {
        this.MOD_ID = ModID;
        itemRegisterEvents.put(ModID, this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        YaumRegistry yaumRegistry = YaumRegistry.getBlockRegistries().get(MOD_ID);
        yaum.getLogHelper().info("Starting ItemBlock registering for " + MOD_ID + "...");
        for (YaumBlock block : yaumRegistry.getRegisteredBlocks()) {
            yaum.getLogHelper().debug("Registering ItemBlock... " + block.getBlockName());
            event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        }
        yaum.getLogHelper().info("Finished ItemBlock registering for " + MOD_ID);
        yaum.getLogHelper().info("Starting Item registering for " + MOD_ID + "...");
        for (YaumItem item : yaumRegistry.getRegisteredItems()) {
            yaum.getLogHelper().debug("Registering Item... " + item.getItemName());
            event.getRegistry().register(item.setRegistryName(MOD_ID, item.getItemName()));
        }
        yaum.getLogHelper().info("Finished Item registering for " + MOD_ID);
    }
}

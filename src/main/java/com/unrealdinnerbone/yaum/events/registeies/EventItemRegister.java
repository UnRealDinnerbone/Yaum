package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.IYaumBlock;
import com.unrealdinnerbone.yaum.api.IYaumItem;
import com.unrealdinnerbone.yaum.api.YaumRegistry;
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
        YaumRegistry yaumRegistry = YaumRegistry.getModRegistry(MOD_ID);
        yaum.getLogHelper().info("Starting ItemBlock registering for " + MOD_ID + "...");
        for (IYaumBlock iYaumBlock : yaumRegistry.getRegisteredBlocks()) {
            yaum.getLogHelper().debug("Registering ItemBlock... " + iYaumBlock.getBlockName());
            event.getRegistry().register(new ItemBlock(iYaumBlock.getBlock()).setRegistryName(MOD_ID, iYaumBlock.getBlockName()));
        }
        yaum.getLogHelper().info("Finished ItemBlock registering for " + MOD_ID);
        yaum.getLogHelper().info("Starting Item registering for " + MOD_ID + "...");
        for (IYaumItem iYaumItem : yaumRegistry.getRegisteredItems()) {
            iYaumItem.getItem().setRegistryName(MOD_ID, iYaumItem.getItemName());
            iYaumItem.getItem().setUnlocalizedName(MOD_ID + "." + iYaumItem.getItemName().toLowerCase());
            yaum.getLogHelper().debug("Registering Item... " + iYaumItem.getItemName());
            event.getRegistry().register(iYaumItem.getItem());
        }
        yaum.getLogHelper().info("Finished Item registering for " + MOD_ID);
    }
}

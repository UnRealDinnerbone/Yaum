package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.registeies.EventRegisterHelper;
import com.unrealdinnerbone.yaum.util.Reference;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class YaumRegistry {

    private static HashMap<String, YaumRegistry> registries = new HashMap<>();

    private final ArrayList<IYaumItem> items = new ArrayList<>();

    private final ArrayList<IYaumBlock> blocks = new ArrayList<>();

    private final ArrayList<SoundEvent> soundEvents = new ArrayList<>();

    private final String MOD_ID;

    private final EventRegisterHelper eventRegisterHelper;

    public YaumRegistry(String ModID, FMLPreInitializationEvent event)
    {
        this.MOD_ID = ModID;
        this.eventRegisterHelper = new EventRegisterHelper(ModID, event);
        registries.put(ModID, this);
    }

    public ArrayList<IYaumBlock> getRegisteredBlocks() {
        return blocks;
    }


    public ArrayList<IYaumItem> getRegisteredItems() {
        return items;
    }

    public ArrayList<SoundEvent> getRegistereSounds() {
        return soundEvents;
    }

    public void registerBlock(IYaumBlock iYaumBlock)
    {
        this.blocks.add(iYaumBlock);
    }

    public void registerItem(IYaumItem iYaumItem)
    {
        this.items.add(iYaumItem);
    }

    public void registerSoundEvent(SoundEvent soundEvent)
    {
        soundEvents.add(soundEvent);
    }

    public String getModID() {
        return MOD_ID;
    }

    public static YaumRegistry getModRegistry(String MOD_ID)
    {
        if(registries.containsKey(MOD_ID))
        {
            return registries.get(MOD_ID);
        }else
        {
            return registries.get(Reference.MOD_ID);
        }
    }
}

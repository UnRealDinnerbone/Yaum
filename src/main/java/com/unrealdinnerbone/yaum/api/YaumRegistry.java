package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.registeies.EventRegisterHelper;
import com.unrealdinnerbone.yaum.libs.helpers.LangHelper;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.HashMap;

public class YaumRegistry {

    private static HashMap<String, YaumRegistry> registries = new HashMap<>();

    private final ArrayList<IYaumItem> items = new ArrayList<>();
    private final ArrayList<IYaumBlock> blocks = new ArrayList<>();
    private final ArrayList<SoundEvent> soundEvents = new ArrayList<>();
    private final ArrayList<YarmCommandBase> yarmCommands = new ArrayList<>();
    private final ArrayList<Class <? extends TileEntity>> tileEnities = new ArrayList<>();

    private final String MOD_ID;

    private final EventRegisterHelper eventRegisterHelper;

    private final LangHelper langHelper;

    public YaumRegistry(String ModID, FMLPreInitializationEvent event)
    {
        this.MOD_ID = ModID;
        this.eventRegisterHelper = new EventRegisterHelper(ModID, event);
        this.langHelper = new LangHelper(ModID);
        registries.put(ModID, this);
    }

    public ArrayList<IYaumBlock> getRegisteredBlocks() {
        return blocks;
    }


    public ArrayList<IYaumItem> getRegisteredItems() {
        return items;
    }

    public ArrayList<SoundEvent> getResistedSounds() {
        return soundEvents;
    }

    public ArrayList<Class <? extends TileEntity>> gerRegistedTitleenties() {
        return tileEnities;
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

    public void registerCommand(YarmCommandBase yarmCommandBase)
    {
        yarmCommands.add(yarmCommandBase);
    }

    public void registerTileEntity(Class <? extends TileEntity> tileEntity, String name) {
        GameRegistry.registerTileEntity(tileEntity, MOD_ID + "_" + name);
        tileEnities.add(tileEntity);
    }



    public EventRegisterHelper getEventRegisterHelper()  {
        return eventRegisterHelper;
    }

    public String getModID() {
        return MOD_ID;
    }


    public LangHelper getLangHelper() {
        return langHelper;
    }


    public static HashMap<String, YaumRegistry> getRegistries() {
        return registries;
    }

    public static YaumRegistry getModRegistry(String MOD_ID) {
        if (registries.containsKey(MOD_ID)) {
            return registries.get(MOD_ID);
        } else {
            return registries.get(Reference.MOD_ID);
        }
    }

    public ArrayList<YarmCommandBase> getYarmCommands() {
        return yarmCommands;
    }


}

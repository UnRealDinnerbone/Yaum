package com.unrealdinnerbone.yaum.api.register;

import com.unrealdinnerbone.yaum.api.block.IYaumBlock;
import com.unrealdinnerbone.yaum.api.command.YaumCommandBase;
import com.unrealdinnerbone.yaum.api.item.IYaumItem;
import com.unrealdinnerbone.yaum.api.util.LogHelper;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.ArrayList;
import java.util.HashMap;

public class YaumRegistry {

    private static HashMap<String, YaumRegistry> registries = new HashMap<>();

    private final ArrayList<IYaumItem> resistedItems = new ArrayList<>();
    private final ArrayList<IYaumBlock> resistedBlocks = new ArrayList<>();
    private final ArrayList<SoundEvent> resistedSounds = new ArrayList<>();
    private final ArrayList<YaumCommandBase> resistedCommands = new ArrayList<>();
    private final ArrayList<Class <? extends TileEntity>> registeredTileEntities = new ArrayList<>();

    private final String MOD_ID;

    private final LangHelper langHelper;
    private final LogHelper logHelper;

    public YaumRegistry(String ModID, FMLPreInitializationEvent event) {
        this.MOD_ID = ModID;
        this.langHelper = new LangHelper(ModID);
        this.logHelper = new LogHelper(ModID);
        registries.put(ModID, this);
    }

    public ArrayList<IYaumBlock> getRegisteredBlocks() {
        return resistedBlocks;
    }


    public ArrayList<IYaumItem> getRegisteredItems() {
        return resistedItems;
    }

    public ArrayList<SoundEvent> getResistedSounds() {
        return resistedSounds;
    }

    public ArrayList<Class <? extends TileEntity>> getRegistedTitleenties() {
        return registeredTileEntities;
    }

    public void registerBlock(IYaumBlock iYaumBlock)
    {
        this.resistedBlocks.add(iYaumBlock);
    }

    public void registerItem(IYaumItem iYaumItem)
    {
        this.resistedItems.add(iYaumItem);
    }

    public void registerSoundEvent(SoundEvent soundEvent)
    {
        resistedSounds.add(soundEvent);
    }

    public void registerCommand(YaumCommandBase yarmCommandBase)
    {
        resistedCommands.add(yarmCommandBase);
    }

    public void registerTileEntity(Class <? extends TileEntity> tileEntity, String name) {
        GameRegistry.registerTileEntity(tileEntity, MOD_ID + "_" + name);
        registeredTileEntities.add(tileEntity);
    }

    public LogHelper getLogHelper() {
        return logHelper;
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

    public ArrayList<YaumCommandBase> getResistedCommands() {
        return resistedCommands;
    }


}

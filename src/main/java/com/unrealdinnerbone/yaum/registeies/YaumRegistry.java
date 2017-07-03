package com.unrealdinnerbone.yaum.registeies;

import com.unrealdinnerbone.yaum.block.YaumBlock;
import com.unrealdinnerbone.yaum.item.YaumItem;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class YaumRegistry {

    private static HashMap<String, YaumRegistry> blockRegistries = new HashMap<>();

    private final ArrayList<YaumBlock> blocks = new ArrayList<>();

    private final ArrayList<YaumItem> items = new ArrayList<>();

    private final String MOD_ID;

    private final EventRegisterHelper eventRegisterHelper;

    public YaumRegistry(String ModID, FMLPreInitializationEvent event)
    {
        this.MOD_ID = ModID;
        this.eventRegisterHelper = new EventRegisterHelper(ModID, event);
        blockRegistries.put(ModID, this);
    }

    public ArrayList<YaumBlock> getRegisteredBlocks() {
        return blocks;
    }


    public ArrayList<YaumItem> getRegisteredItems() {
        return items;
    }

    public void registerBlock(YaumBlock yaumBlock)
    {
        blocks.add(yaumBlock);
    }

    public void registerItem(YaumItem yaumItem)
    {
        items.add(yaumItem);
    }

    public String getModID() {
        return MOD_ID;
    }

    public static HashMap<String, YaumRegistry> getBlockRegistries() {
        return blockRegistries;
    }
}

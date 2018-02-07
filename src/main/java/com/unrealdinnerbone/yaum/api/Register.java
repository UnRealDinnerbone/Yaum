package com.unrealdinnerbone.yaum.register;

import com.unrealdinnerbone.yaum.api.block.IYaumBlock;
import com.unrealdinnerbone.yaum.api.command.YaumCommandBase;
import com.unrealdinnerbone.yaum.api.item.IYaumItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;

import java.util.ArrayList;
import java.util.HashMap;

public class Register {


    private final static HashMap<String, ArrayList<IYaumItem>> registeredItems;
    private final static HashMap<String, ArrayList<IYaumBlock>> registeredBlocks;
    private final static HashMap<String, ArrayList<SoundEvent>> registeredSounds;

    static {
        registeredItems = new HashMap<>();
        registeredBlocks = new HashMap<>();
        registeredSounds = new HashMap<>();
    }

    private final static ArrayList<IYaumItem> resistedItems = new ArrayList<>();
    private final static ArrayList<SoundEvent> resistedSounds = new ArrayList<>();
    private final static ArrayList<YaumCommandBase> resistedCommands = new ArrayList<>();
    private final static ArrayList<Class <? extends TileEntity>> registeredTileEntities = new ArrayList<>();


    public static void registerItem(String ModID, IYaumItem IYaumItem) {
        if(!registeredItems.containsKey(ModID)) {
            registeredItems.put(ModID, new ArrayList<>());
        }
        registeredItems.get(ModID).add(IYaumItem);
    }

    public static void registerBlock(String ModID, IYaumBlock IYaumBlock) {
        if(!registeredBlocks.containsKey(ModID)) {
            registeredBlocks.put(ModID, new ArrayList<>());
        }
        registeredBlocks.get(ModID).add(IYaumBlock);
    }

    public static void registerSound(String ModID, SoundEvent soundEvent) {
        if(!registeredSounds.containsKey(ModID)) {
            registeredSounds.put(ModID, new ArrayList<>());
        }
        registeredSounds.get(ModID).add(soundEvent);
    }

}

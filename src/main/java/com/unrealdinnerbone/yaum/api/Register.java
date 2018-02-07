package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.api.block.IYaumBlock;
import com.unrealdinnerbone.yaum.api.command.YaumSubCommand;
import com.unrealdinnerbone.yaum.api.enchantment.IYaumEnchantment;
import com.unrealdinnerbone.yaum.api.item.IYaumItem;
import com.unrealdinnerbone.yaum.api.recipes.IYaumAnvilRecipe;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;

import java.util.ArrayList;
import java.util.HashMap;

public class Register {


    private final static HashMap<ModContainer, ArrayList<IYaumItem>> registeredItems;
    private final static HashMap<ModContainer, ArrayList<IYaumBlock>> registeredBlocks;
    private final static HashMap<ModContainer, ArrayList<SoundEvent>> registeredSounds;
    private final static HashMap<ModContainer, ArrayList<YaumSubCommand>> registeredCommands;
    private final static HashMap<ModContainer, ArrayList<Class <? extends TileEntity>>> registeredTileEnties;
    private final static HashMap<ModContainer, ArrayList<IYaumEnchantment>> registeredEnchantments;
    private final static HashMap<ModContainer, ArrayList<IYaumAnvilRecipe>> registeredAnvilRecpies;

    static {
        registeredItems = new HashMap<>();
        registeredBlocks = new HashMap<>();
        registeredSounds = new HashMap<>();
        registeredCommands = new HashMap<>();
        registeredTileEnties = new HashMap<>();
        registeredEnchantments = new HashMap<>();
        registeredAnvilRecpies = new HashMap<>();
    }

    public static void registerEnchantment(ModContainer modContainer, IYaumEnchantment iYaumEnchantment) {
        if(!registeredEnchantments.containsKey(modContainer)) {
            registeredEnchantments.put(modContainer, new ArrayList<>());
        }
        registeredEnchantments.get(modContainer).add(iYaumEnchantment);
    }

    public static void registerItem(ModContainer modContainer, IYaumItem IYaumItem) {
        if(!registeredItems.containsKey(modContainer)) {
            registeredItems.put(modContainer, new ArrayList<>());
        }
        registeredItems.get(modContainer).add(IYaumItem);
    }

    public static void registerBlock(ModContainer modContainer, IYaumBlock IYaumBlock) {
        if(!registeredBlocks.containsKey(modContainer)) {
            registeredBlocks.put(modContainer, new ArrayList<>());
        }
        registeredBlocks.get(modContainer).add(IYaumBlock);
    }

    public static void registerSound(ModContainer modContainer, SoundEvent soundEvent) {
        if(!registeredSounds.containsKey(modContainer)) {
            registeredSounds.put(modContainer, new ArrayList<>());
        }
        registeredSounds.get(modContainer).add(soundEvent);
    }

    public static void registerCommand(ModContainer modContainer, YaumSubCommand commandBase) {
        if(!registeredCommands.containsKey(modContainer)) {
            registeredCommands.put(modContainer, new ArrayList<>());
        }
        registeredCommands.get(modContainer).add(commandBase);
    }
    public static void registerAnvilRecipe(ModContainer modContainer, IYaumAnvilRecipe anvilRecipe) {
        if(!registeredAnvilRecpies.containsKey(modContainer)) {
            registeredAnvilRecpies.put(modContainer, new ArrayList<>());
        }
        registeredAnvilRecpies.get(modContainer).add(anvilRecipe);
    }

    @Deprecated
    public static void registerTileEnties(ModContainer modContainer, Class <? extends TileEntity> tileEntity) {
        if(!registeredTileEnties.containsKey(modContainer)) {
            registeredTileEnties.put(modContainer, new ArrayList<>());
        }
        registeredTileEnties.get(modContainer).add(tileEntity);
    }

    public static HashMap<ModContainer, ArrayList<Class<? extends TileEntity>>> getRegisteredTileEnties() {
        return registeredTileEnties;
    }

    public static HashMap<ModContainer, ArrayList<IYaumBlock>> getRegisteredBlocks() {
        return registeredBlocks;
    }

    public static HashMap<ModContainer, ArrayList<IYaumItem>> getRegisteredItems() {
        return registeredItems;
    }

    public static HashMap<ModContainer, ArrayList<SoundEvent>> getRegisteredSounds() {
        return registeredSounds;
    }

    public static HashMap<ModContainer, ArrayList<YaumSubCommand>> getRegisteredCommands() {
        return registeredCommands;
    }

    public static HashMap<ModContainer, ArrayList<IYaumEnchantment>> getRegisteredEnchantments() {
        return registeredEnchantments;
    }

    public static ModContainer getModContanier(Object mod) {
        return FMLCommonHandler.instance().findContainerFor(mod);
    }

    public static HashMap<ModContainer, ArrayList<IYaumAnvilRecipe>> getRegisteredAnvilRecpies() {
        return registeredAnvilRecpies;
    }
}

package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.api.handlers.Handler;
import com.unrealdinnerbone.yaum.api.command.YaumSubCommand;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;

import java.util.ArrayList;
import java.util.HashMap;

public class Registry {


    private final static YaumRegister<Block> BLOCK_REGISTER;
    private final static YaumRegister<Item> ITEM_REGISTER;
    private final static YaumRegister<Enchantment> ENCHANTMENT_REGISTER;
    private final static YaumRegister<SoundEvent> SOUND_REGISTER;

    private final static HashMap<ModContainer, ArrayList<YaumSubCommand>> registeredCommands;
    private final static HashMap<ModContainer, ArrayList<YaumSubCommand>> registeredClientCommandCommands;
    private final static HashMap<ModContainer, ArrayList<Class <? extends TileEntity>>> registeredTileEntities;
    private final static ArrayList<ModContainer> registedConfigChangeEventMods;

    static {


        BLOCK_REGISTER = new YaumRegister<>();
        ITEM_REGISTER = new YaumRegister<>();
        ENCHANTMENT_REGISTER = new YaumRegister<>();
        SOUND_REGISTER = new YaumRegister<>();


        registeredCommands = new HashMap<>();
        registeredClientCommandCommands = new HashMap<>();
        registeredTileEntities = new HashMap<>();
        registedConfigChangeEventMods = new ArrayList<>();
    }



    public static void registerEnchantment(IYaumRegisterObject<Enchantment> enchantmentRegisterObject, Handler<Enchantment> enchantmentHandler) {
        ENCHANTMENT_REGISTER.register(enchantmentRegisterObject, enchantmentHandler);
    }

    public static void registerItem(IYaumRegisterObject<Item> itemRegisterObject, Handler<Item> itemHandler) {
        ITEM_REGISTER.register(itemRegisterObject, itemHandler);
    }
    public static void registerSound(IYaumRegisterObject<SoundEvent> soundRegisterObject, Handler<SoundEvent> soundHandler) {
        SOUND_REGISTER.register(soundRegisterObject, soundHandler);
    }

    public static void registerBlock(IYaumRegisterObject<Block> blockRegisterObject, Handler<Block> blockHandler, IYaumRegisterObject<Item> itemRegisterObject, Handler<Item> itemHandler) {
        BLOCK_REGISTER.register(blockRegisterObject, blockHandler);
        ITEM_REGISTER.register(itemRegisterObject, itemHandler);
    }


    public static void registerCommand(ModContainer modContainer, YaumSubCommand commandBase) {
        if(!registeredCommands.containsKey(modContainer)) {
            registeredCommands.put(modContainer, new ArrayList<>());
        }
        registeredCommands.get(modContainer).add(commandBase);
    }
    public static void registerClientCommand(ModContainer modContainer, YaumSubCommand commandBase) {
        if(!registeredClientCommandCommands.containsKey(modContainer)) {
            registeredClientCommandCommands.put(modContainer, new ArrayList<>());
        }
        registeredClientCommandCommands.get(modContainer).add(commandBase);
    }

    @Deprecated
    public static void registerTileEnties(ModContainer modContainer, Class <? extends TileEntity> tileEntity) {
        if(!registeredTileEntities.containsKey(modContainer)) {
            registeredTileEntities.put(modContainer, new ArrayList<>());
        }
        registeredTileEntities.get(modContainer).add(tileEntity);
    }

    public static HashMap<ModContainer, ArrayList<Class<? extends TileEntity>>> getRegisteredTileEntities() {
        return registeredTileEntities;
    }

    public static YaumRegister<Block> getBlockRegister() {
        return BLOCK_REGISTER;
    }

    public static YaumRegister<Item> getItemRegister() {
        return ITEM_REGISTER;
    }

    public static YaumRegister<Enchantment> getEnchantmentRegister() {
        return ENCHANTMENT_REGISTER;
    }

    public static YaumRegister<SoundEvent> getSoundRegister() {
        return SOUND_REGISTER;
    }

    public static HashMap<ModContainer, ArrayList<YaumSubCommand>> getRegisteredCommands() {
        return registeredCommands;
    }


    public static ModContainer getModContanier(Object mod) {
        return FMLCommonHandler.instance().findContainerFor(mod);
    }


    public static HashMap<ModContainer, ArrayList<YaumSubCommand>> getRegisteredClientCommandCommands() {
        return registeredClientCommandCommands;
    }

    public static void regiserConfigChangeEventMod(ModContainer container) {
            registedConfigChangeEventMods.add(container);
    }

    public static ArrayList<ModContainer> getRegistedConfigChangeEventMods() {
        return registedConfigChangeEventMods;
    }
}

package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.block.IYaumBlock;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventBlockRegister
{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        for (ModContainer modContainer : Register.getRegisteredBlocks().keySet()) {
            Register.getRegisteredBlocks().get(modContainer).forEach(yaumBlock -> yaumBlock.registerBlock(event, modContainer));
        }
//        for (ModContainer modContainer : Register.getRegisteredTileEnties().keySet()) {
//            Register.getRegisteredTileEnties().get(modContainer).forEach(te -> GameRegistry.registerTileEntity(te, te.get));
//        }
    }
}

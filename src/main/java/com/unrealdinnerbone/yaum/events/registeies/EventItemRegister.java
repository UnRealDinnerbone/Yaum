package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.block.IYaumBlock;
import com.unrealdinnerbone.yaum.api.item.IYaumItem;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventItemRegister {

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        Register.getRegisteredBlocks().keySet().forEach(modContainer -> {
            Register.getRegisteredBlocks().get(modContainer).forEach(yaumBlock -> yaumBlock.registerItemBlock(event, modContainer));
            Register.getRegisteredItems().get(modContainer).forEach(yaumItem -> yaumItem.registerItem(event, modContainer));
        });
    }
}

package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventItemRegister
{

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for (YaumRegistry yaumRegistry : YaumRegistry.getRegistries().values()) {
            if(yaumRegistry.getRegisteredBlocks() != null && yaumRegistry.getRegisteredBlocks().size() > 0) {
                ModContainer container = FMLCommonHandler.instance().findContainerFor(yaumRegistry.getModID());
                event.setModContainer(container);
                yaumRegistry.getLogHelper().info("Starting ItemBlock Regeneration for " + yaumRegistry.getRegisteredBlocks().size()  + " block(s)");
                yaumRegistry.getRegisteredBlocks().forEach(iYaumBlock -> iYaumBlock.registerItemBlock(event, yaumRegistry));
                yaumRegistry.getLogHelper().info("Finished ItemBlock Regeneration for " + yaumRegistry.getRegisteredBlocks().size()  + " block(s)");
            }
            if(yaumRegistry.getRegisteredItems() != null && yaumRegistry.getRegisteredItems().size() > 0) {
                ModContainer container = FMLCommonHandler.instance().findContainerFor(yaumRegistry.getModID());
                event.setModContainer(container);
                yaumRegistry.getLogHelper().info("Starting Item Regeneration for " + yaumRegistry.getRegisteredItems().size()  + " item(s)");
                yaumRegistry.getRegisteredItems().forEach(iYaumItem -> iYaumItem.registerItem(event, yaumRegistry));
                yaumRegistry.getLogHelper().info("Finished Item Regeneration for " + yaumRegistry.getRegisteredItems().size()  + " item(s)");
            }
        }
    }
}

package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventBlockRegister
{
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) {
        for(YaumRegistry yaumRegistry: YaumRegistry.getRegistries().values()) {
            if (yaumRegistry.getRegisteredBlocks() != null && yaumRegistry.getRegisteredBlocks().size() > 0) {
                yaumRegistry.getLogHelper().info("Starting Block Regeneration for " + yaumRegistry.getRegisteredBlocks().size()  + " block(s)");
                yaumRegistry.getRegisteredBlocks().forEach(iYaumBlock -> iYaumBlock.registerBlock(event, yaumRegistry));
                yaumRegistry.getLogHelper().info("Finished Block Regeneration for " + yaumRegistry.getRegisteredBlocks().size()  + " block(s)");
            }
        }

    }
}

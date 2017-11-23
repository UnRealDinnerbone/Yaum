package com.unrealdinnerbone.yaum.client.event.registeies;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventModelRender
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderModels(ModelRegistryEvent event) {
        for (YaumRegistry yaumRegistry : YaumRegistry.getRegistries().values()) {
            if (yaumRegistry.getRegisteredBlocks() != null && yaumRegistry.getRegisteredBlocks().size() > 0) {
                yaumRegistry.getLogHelper().info("Starting Block rendering for " + yaumRegistry.getRegisteredBlocks().size() + " block(s)");
                yaumRegistry.getRegisteredBlocks().forEach(iYaumBlock -> iYaumBlock.renderBlock(event, yaumRegistry));
                yaumRegistry.getLogHelper().info("Finished Block rendering for " + yaumRegistry.getRegisteredBlocks().size() + " block(s)");
            }
            if (yaumRegistry.getRegisteredItems() != null && yaumRegistry.getRegisteredItems().size() > 0) {
                yaumRegistry.getLogHelper().info("Starting Item rendering for " + yaumRegistry.getRegisteredItems().size() + " item(s)");
                yaumRegistry.getRegisteredItems().forEach(iYaumItem -> iYaumItem.renderItem(event, yaumRegistry));
                yaumRegistry.getLogHelper().info("Finished Item rendering for " + yaumRegistry.getRegisteredItems().size() + " item(s)");
            }
        }
    }
}

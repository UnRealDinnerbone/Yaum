package com.unrealdinnerbone.yaum.client.event.registeies;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventModelRender
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void renderModels(ModelRegistryEvent event) {
        for (YaumRegistry yaumRegistry : YaumRegistry.getRegistries().values()) {
            ModContainer container = FMLCommonHandler.instance().findContainerFor(yaumRegistry.getModID());
            event.setModContainer(container);
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
        if(YaumConfiguration.ClientConfig.Tweaks.changeIronNuggetTexture) {
            ModelLoader.setCustomModelResourceLocation(Items.IRON_NUGGET, 0, new ModelResourceLocation(new ResourceLocation("yaum", "iron_nugget"), "inventory"));
        }

    }
}

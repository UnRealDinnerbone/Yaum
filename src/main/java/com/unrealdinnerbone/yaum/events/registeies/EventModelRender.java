package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.item.YaumItem;
import com.unrealdinnerbone.yaum.registeies.YaumRegistry;
import com.unrealdinnerbone.yaum.block.YaumBlock;
import com.unrealdinnerbone.yaum.yaum;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;

public class EventModelRender
{
    public static HashMap<String, EventModelRender> modelRenderEvents = new HashMap<>();

    private final String MOD_ID;

    public EventModelRender(String ModID)
    {
        this.MOD_ID = ModID;
        modelRenderEvents.put(ModID, this);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderModels(ModelRegistryEvent event)
    {
        YaumRegistry yaumRegistry = YaumRegistry.getBlockRegistries().get(MOD_ID);
        yaum.getLogHelper().info("Starting Block rendering for " + MOD_ID + "...");
        for (YaumBlock block : yaumRegistry.getRegisteredBlocks()) {
            yaum.getLogHelper().debug("Rendering Block... " + block.getBlockName());
            ResourceLocation rl = block.getRegistryName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(rl, "inventory"));
        }
        yaum.getLogHelper().info("Finished Block rendering for " + MOD_ID + "...");
        yaum.getLogHelper().info("Starting Item rendering for " + MOD_ID + "...");
        for (YaumItem item : yaumRegistry.getRegisteredItems()) {
            yaum.getLogHelper().debug("Rendering Item... " + item.getItemName());
            ResourceLocation rl = item.getRegistryName();
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(rl, "inventory"));
        }
        yaum.getLogHelper().info("Finished Block rendering for " + MOD_ID + "...");
    }
}

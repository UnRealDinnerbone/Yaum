package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.Registry;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventBlockRegister
{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        Registry.getBlockRegister().getWrapperList().forEach(wrapper -> wrapper.getB().register(event.getRegistry(), wrapper.getA()));
        //Todo add this back
//        for (ModContainer modContainer : Registry.getRegisteredTileEntities().keySet()) {
//            Registry.getRegisteredTileEntities().get(modContainer).forEach(te -> GameRegistry.registerTileEntity(te, te.get));
//        }
    }
}

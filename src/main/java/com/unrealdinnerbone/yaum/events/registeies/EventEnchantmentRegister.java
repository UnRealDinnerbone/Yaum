package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.enchantment.IYaumEnchantment;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventEnchantmentRegister
{
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Enchantment> event) {
        for(ModContainer modContainer : Register.getRegisteredEnchantments().keySet()) {
            for(IYaumEnchantment iYaumEnchantment: Register.getRegisteredEnchantments().get(modContainer)) {
                iYaumEnchantment.register(modContainer);
                event.getRegistry().register(iYaumEnchantment.getEnchantment());
            }
        }
    }
}

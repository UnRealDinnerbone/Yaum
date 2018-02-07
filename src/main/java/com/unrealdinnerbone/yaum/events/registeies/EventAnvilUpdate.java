package com.unrealdinnerbone.yaum.events.registeies;

import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.recipes.IYaumAnvilRecipe;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventAnvilUpdate
{
    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        System.out.println("Updated");
        for(ModContainer modContainer : Register.getRegisteredAnvilRecpies().keySet()) {
            for(IYaumAnvilRecipe recipe : Register.getRegisteredAnvilRecpies().get(modContainer)) {
                if (recipe.getOutput(event.getLeft(), event.getRight(), event.getName()) != ItemStack.EMPTY) {
                    event.setCost(recipe.getXPCost(event.getLeft(), event.getRight(), event.getName()));
                    event.setMaterialCost(recipe.getMaterialCost(event.getLeft(), event.getRight(), event.getName()));
                    event.setOutput(recipe.getOutput(event.getLeft(), event.getRight(), event.getName()));
                }
            }
        }
    }

}

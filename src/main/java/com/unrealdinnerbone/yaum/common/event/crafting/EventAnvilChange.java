package com.unrealdinnerbone.yaum.event.crafting;

import com.unrealdinnerbone.yaum.api.recipes.YaumAnvilRecipe;
import com.unrealdinnerbone.yaum.event.register.EventRegisterRegistries;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventAnvilChange {
    @SubscribeEvent
    public static void anvilChange(AnvilUpdateEvent event) {
        for (YaumAnvilRecipe recipe : EventRegisterRegistries.getAnvilRecipeRegistry()) {
            if (event.getCost() >= recipe.getXPCost(event.getLeft(), event.getRight(), event.getName())) {
                event.setOutput(recipe.getOutput(event.getLeft(), event.getRight(), event.getName()));
                event.setMaterialCost(recipe.getMaterialCost(event.getLeft(), event.getRight(), event.getName()));
            }
        }
    }
}

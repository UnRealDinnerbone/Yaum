package com.unrealdinnerbone.yaum.event.register;

import com.unrealdinnerbone.yaum.api.recipes.IYaumAnvilRecipe;
import com.unrealdinnerbone.yaum.libs.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class EventRegisterRegistries
{
    private static IForgeRegistry<IYaumAnvilRecipe> anvilRecipeRegistry;

    @SubscribeEvent
    public static void registerRegistries(RegistryEvent.NewRegistry newRegistry) {
        anvilRecipeRegistry = new RegistryBuilder<IYaumAnvilRecipe>().setType(IYaumAnvilRecipe.class).setName(new ResourceLocation(Reference.MOD_ID, "anvilRecipes")).create();

    }

    public static IForgeRegistry<IYaumAnvilRecipe> getAnvilRecipeRegistry() {
        return anvilRecipeRegistry;
    }
}

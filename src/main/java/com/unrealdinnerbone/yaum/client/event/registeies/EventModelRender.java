package com.unrealdinnerbone.yaum.client.event.registeies;

import com.unrealdinnerbone.yaum.api.IYaumMod;
import com.unrealdinnerbone.yaum.api.Register;
import com.unrealdinnerbone.yaum.api.register.IYaumObject;
import com.unrealdinnerbone.yaum.config.YaumConfiguration;
import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.libs.helpers.TextureHelper;
import net.minecraft.init.Items;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
@SideOnly(Side.CLIENT)
public class EventModelRender
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void renderModels(ModelRegistryEvent event) {
        for (List<Map.Entry<IYaumMod, IYaumObject>> entryList : Register.getRegisteredObject().values()) {
            for (Map.Entry<IYaumMod, IYaumObject> iYaumModIYaumObjectEntry : entryList) {
                event.setModContainer(iYaumModIYaumObjectEntry.getKey().getModContainer());
                iYaumModIYaumObjectEntry.getValue().render(event, iYaumModIYaumObjectEntry.getKey());
            }
        }

        //Todo move this to the register
        if(YaumConfiguration.ClientConfig.Tweaks.changeIronNuggetTexture) {
            TextureHelper.changeTextureLocation(Items.IRON_NUGGET, Reference.MOD_ID, "iron_nugget");
        }

    }
}

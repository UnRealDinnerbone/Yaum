package com.unrealdinnerbone.yaum.client.gui;

import com.unrealdinnerbone.yaum.config.ConfigManger;
import com.unrealdinnerbone.yaum.util.LangHelper;
import com.unrealdinnerbone.yaum.util.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.List;

public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen parentScreen) {
        super(parentScreen, getConfigElements(), Reference.MOD_ID, false, false, Reference.MOD_NAME);
    }

    private static List<IConfigElement> getConfigElements() {

        List<IConfigElement> list = new ArrayList<>();

//        list.add(categoryElement(ConfigManger.getClientConfig(), "perks", LangHelper.CONFIG.translateMessage("clientPerks"), LangHelper.TOOLTIP.translateMessage("client.perks")));
        list.add(categoryElement(ConfigManger.getGeneralConfig(), "loggers", LangHelper.CONFIG.translateMessage("loggers"), LangHelper.TOOLTIP.translateMessage("loggers.info")));
        //        list.add(new DummyCategoryElement("New Config thing", "Yarm.config.stuff", YarmConfigs.ClientConfig.class));
        return list;
    }

    private static IConfigElement categoryElement(Configuration configuration, String category, String name, String tooltip_key) {
        return new DummyConfigElement.DummyCategoryElement(name, tooltip_key,
                new ConfigElement(configuration.getCategory(category)).getChildElements());
    }

}
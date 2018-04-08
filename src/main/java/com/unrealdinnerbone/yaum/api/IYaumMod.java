package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.api.util.LangHelper;
import com.unrealdinnerbone.yaum.api.util.LogHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.ModContainer;

public interface IYaumMod
{
    String getModName();

    LogHelper getLogHelper();

    LangHelper getLangHelper();

    default ModContainer getModContainer() {
        return FMLCommonHandler.instance().findContainerFor(getModName());
    }

}

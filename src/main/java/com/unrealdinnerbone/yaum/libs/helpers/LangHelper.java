package com.unrealdinnerbone.yaum.util;

import net.minecraft.util.text.translation.I18n;

public class LangHelper {




    private String MOD_ID;

    public LangHelper(String ModID)
    {
        this.MOD_ID = ModID;
    }

    public String translateMessage(Type type, String message)
    {
        return type.translateMessage(MOD_ID, message);
    }

    public enum Type {
        TAB("tab"),
        Achievement("achievement"),
        Banner("Banner"),
        Block("Block"),
        CONFIG("config"),
        TOOLTIP("tooltip"),
        COMMAND("command");

        private final String name;

        Type(String name)
        {
            this.name = name;
        }

        public String translateMessage(String ModId, String message) {
            if (this.name == "")
                return I18n.translateToLocal(message);

            return I18n.translateToLocal(ModId  + name + message + "");
        }
    }
}
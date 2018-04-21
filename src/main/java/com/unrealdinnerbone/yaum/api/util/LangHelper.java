package com.unrealdinnerbone.yaum.api.util;


import net.minecraft.client.resources.I18n;

public class LangHelper {

    private final String MOD_ID;

    public LangHelper(String ModID) {
        this.MOD_ID = ModID;
    }

    public String translateMessage(Type type, String message) {
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

        public String translateMessage(String modId, String message) {
            return I18n.format(modId + "." + name + "." + message);
        }
    }
}
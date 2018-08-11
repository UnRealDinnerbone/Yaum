package com.unrealdinnerbone.yaum.common.perks;

import com.unrealdinnerbone.yaum.libs.Reference;
import com.unrealdinnerbone.yaum.proxy.ClientProxy;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.UUID;

public class Supporter {

    private UUID playerUUID;
    private String playerName;
    private String type;
    private boolean fancyChat;


    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    public boolean hasFancyChat() {
        return fancyChat;
    }

    public String getType() {
        return type;
    }
}

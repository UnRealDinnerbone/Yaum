package com.unrealdinnerbone.yaum.api.command;

import com.unrealdinnerbone.yaum.api.register.YaumRegistry;
import com.unrealdinnerbone.yaum.api.util.LangHelper;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.command.CommandTreeBase;

import java.util.HashMap;

public class YurmCMD extends CommandTreeBase {

    private static HashMap<String, YurmCMD> yurmCMDs = new HashMap<>();

    private final YaumRegistry yaumRegistry;

    public YurmCMD(String ModId, YaumRegistry yaumRegistry) {
        this.yaumRegistry = yaumRegistry;
        yurmCMDs.put(ModId, this);
        for(YaumCommandBase base: yaumRegistry.getResistedCommands()) {
            addSubcommand(base);
        }
    }

    @Override
    public String getName() {
        return yaumRegistry.getModID();
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean checkPermission(MinecraftServer minecraftServer, ICommandSender sender) {
        return true;
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return yaumRegistry.getLangHelper().translateMessage(LangHelper.Type.COMMAND, "usage.base");
    }

}

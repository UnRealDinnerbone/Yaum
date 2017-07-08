package com.unrealdinnerbone.yaum.api;

import com.unrealdinnerbone.yaum.util.LangHelper;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.command.CommandTreeBase;

import java.util.HashMap;
import java.util.List;

public class YurmCMD extends CommandTreeBase {


    private static HashMap<String, YurmCMD> yurmCMDs = new HashMap<>();

    private final String ModID;

    public YurmCMD(String ModId, List<YarmCommandBase> baseList) {
        this.ModID = ModId;
        yurmCMDs.put(ModId, this);
        for(YarmCommandBase base: baseList)
        {
            addSubcommand(base);
        }
    }

    @Override
    public String getName() {
        return ModID;
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
        return YaumRegistry.getModRegistry(ModID).getLangHelper().translateMessage(LangHelper.Type.COMMAND, "usage.base");
    }

}

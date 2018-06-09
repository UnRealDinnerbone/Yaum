package com.unrealdinnerbone.yaum.api.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.command.CommandTreeBase;

import java.util.List;

public class YaumCommandBase extends CommandTreeBase {


    private final String MOD_ID;

    public YaumCommandBase(String ModId, List<YaumSubCommand> subCommands) {
        this.MOD_ID = ModId;
        subCommands.forEach(this::addSubcommand);
    }

    @Override
    public String getName() {
        return this.MOD_ID;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return this.MOD_ID;
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean checkPermission(MinecraftServer minecraftServer, ICommandSender sender) {
        return true;
    }


}

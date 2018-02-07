package com.unrealdinnerbone.yaum.api.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.server.command.CommandTreeBase;

import java.util.ArrayList;

public class YurmSubCommand extends CommandTreeBase {


    private final String ModId;

    public YurmSubCommand(String ModId, ArrayList<YurmSubCommand> subCommands) {
        this.ModId = ModId;
        subCommands.forEach(subCommand -> addSubcommand(subCommand));
    }

    @Override
    public String getName() {
        return this.ModId;
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return this.ModId;
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

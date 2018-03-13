package com.unrealdinnerbone.yaum.api.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public abstract class YaumSubCommand extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender ics) {
        return getRequiredPermissionLevel() == 0 || !server.isDedicatedServer() || super.checkPermission(server, ics);
    }

    @Override
    public String getUsage(ICommandSender iCommandSender) {
        return '/' + getName();
    }


    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender ics, String[] args, @Nullable BlockPos pos) {
        if (args.length == 0) {
            return Collections.emptyList();
        } else if (isUsernameIndex(args, args.length - 1)) {
            return getListOfStringsMatchingLastWord(args, server.getOnlinePlayerNames());
        }
        return super.getTabCompletions(server, ics, args, pos);
    }

    @Override
    public boolean isUsernameIndex(String[] strings, int i) {
        return false;
    }
}

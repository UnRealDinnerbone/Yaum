package com.unrealdinnerbone.yaum.api.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public abstract class YaumCleintSubCommand extends YaumSubCommand {

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender ics, String[] args, @Nullable BlockPos pos) {
        return Collections.emptyList();
    }

}

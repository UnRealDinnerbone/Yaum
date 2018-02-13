package com.unrealdinnerbone.yaum.command;

import com.unrealdinnerbone.yaum.api.command.YaumSubCommand;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.oredict.OreDictionary;

public class CommandListOres extends YaumSubCommand  {
    @Override
    public String getName() {
        return "listOres";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        for(Item item: Item.REGISTRY) {
//            String oreName = OreDictionary.getOreName(new ItemStack(item)??);
        }
    }
}

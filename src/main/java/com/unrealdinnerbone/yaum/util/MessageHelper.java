package com.unrealdinnerbone.yaum.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageHelper {


    public static void sendChatMessageToPlayer(TextComponentString message, EntityPlayer player)
    {
        player.sendMessage(message);
    }
    public static void sendChatMessageToSender(TextComponentString message, ICommandSender sender)
    {
        sender.sendMessage(message);
    }

    public static void sendChatMessageServerWide(TextComponentString message) {
        for (EntityPlayer player : ServerUtils.getServer().getPlayerList().getPlayers()) {
            player.sendMessage(message);

        }
    }

    @SideOnly(Side.CLIENT)
    public static void sendSpamlessMessage(int messageID, TextComponentString message) {

        final GuiNewChat chat = Minecraft.getMinecraft().ingameGUI.getChatGUI();
        chat.printChatMessageWithOptionalDeletion(message, messageID);
    }
}

package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.libs.utils.ServerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageHelper {


    public static void sendChatMessage(TextComponentString message, EntityPlayer player)
    {
        player.sendMessage(message);
    }
    public static void sendChatMessage(TextComponentString message, ICommandSender sender)
    {
        sender.sendMessage(message);
    }

    public static void sendChatMessageServerWide(TextComponentString message) {
        for (EntityPlayer player : ServerUtil.getServer().getPlayerList().getPlayers()) {
            player.sendMessage(message);

        }
    }

    @SideOnly(Side.CLIENT)
    public static void sendSpamlessMessage(int messageID, TextComponentString message) {
            sendChatMessageServerWide(message);
// final GuiNewChat chat = Minecraft.getMinecraft().ingameGUI.getChatGUI();
//        chat.printChatMessageWithOptionalDeletion(message, messageID);
    }
}

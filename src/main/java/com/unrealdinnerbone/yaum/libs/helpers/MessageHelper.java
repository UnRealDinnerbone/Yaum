package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.libs.utils.ServerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageHelper {


    public static void sendChatMessage(TextComponentString message, ICommandSender sender) {
        sender.sendMessage(message);
    }

    public static void sendChatMessageServerWide(TextComponentString message) {
        ServerUtil.getServer().getPlayerList().getPlayers().forEach(player -> sendChatMessage(message, player));
    }

    @SideOnly(Side.CLIENT)
    public static void sendSpamlessMessage(int messageID, TextComponentString message) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessageWithOptionalDeletion(message, messageID);
    }
}

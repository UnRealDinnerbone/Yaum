package com.unrealdinnerbone.yaum.libs.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public enum ColorUtil {
    
    BLACK("0", true),
    DBLUE("1", true),
    DGREEN("2", true),
    DAQUA("3", true),
    DRED("4", true),
    DPURPLE("5", true),
    GOLD("6", true),
    GRAY("7", true),
    DGRAY("8", true),
    BLUE("9", true),
    GREEN("a", true),
    AQUA("b", true),
    RED("c", true),
    LPURPLE("d", true),
    YELLOW("e", true),
    WHITE("f", true),
    BOLD("l", false),
    SLANT("o", false),
    UNDERLUNE("n", false),
    STRIKE("m", false),
    MAGIC("k", false),
    RESET("r", false);


    private final boolean isVaildColor;
    private static final String MCStyle = "\u00A7";
    private final String color;
    private final String number;

    ColorUtil(String num, boolean isVaildColor) {
        this.number = num;
        this.color = MCStyle + num;
        this.isVaildColor = isVaildColor;
    }

    public static ColorUtil getRandom() {
        List<ColorUtil> colorUtils = Arrays.stream(values()).filter(colorUtil -> colorUtil.isVaildColor).collect(Collectors.toList());
        return colorUtils.get(new Random().nextInt(colorUtils.size()));
    }

    @Override
    public String toString() {
        return this.color;
    }
    public static String format(String string) {
        String newMsg = string;
        for(ColorUtil colorUtils: values()) {
            newMsg = newMsg.replace("&" + colorUtils.number, colorUtils.toString());
        }
        return newMsg;
    }
}


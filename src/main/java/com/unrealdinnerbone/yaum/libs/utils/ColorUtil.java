package com.unrealdinnerbone.yaum.libs.utils;

import java.util.Random;

public enum ColorUtil {
    BLACK("0"),
    DBLUE("1"),
    DGREEN("2"),
    DAQUA("3"),
    DRED("4"),
    DPURPLE("5"),
    GOLD("6"),
    GRAY("7"),
    DGRAY("8"),
    BLUE("9"),
    GREEN("a"),
    AQUA("b"),
    RED("c"),
    LPURPLE("d"),
    YELLOW("e"),
    WHITE("f"),
    BOLD("l"),
    SLANT("o"),
    UNDERLUNE("n"),
    STRIKE("m"),
    MAGIC("k"),
    RESET("r");


    public static final ColorUtil[] VALID_COLORS = {BLACK, DBLUE, DGREEN, DAQUA, DRED, DPURPLE, GOLD, GRAY, DGRAY, BLUE, GREEN, AQUA, RED, LPURPLE, YELLOW, WHITE};
    private static final String MCStyle = "\u00A7";
    private final String color;
    private final String number;

    ColorUtil(String num) {
        this.number = num;
        this.color = MCStyle + num;
    }

    public static ColorUtil getRandom() {
        return VALID_COLORS[new Random().nextInt(VALID_COLORS.length)];
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


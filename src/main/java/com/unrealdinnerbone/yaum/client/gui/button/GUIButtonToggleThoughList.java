package com.unrealdinnerbone.yastm.client.gui;

import com.google.common.collect.Lists;
import net.minecraft.client.gui.GuiButton;

import java.util.ArrayList;
import java.util.List;

public class GUIButtonToggleThoughList extends GuiButton {

    private static int idCount = 4100;
    private List<String> options;
    private String currentString;

    public GUIButtonToggleThoughList(int x, int y, List<String> options) {
        super(idCount++, x, y, options.stream().findFirst().get());
        this.options = options;
    }

    public void goNext() {
        String nextString = getNextObjectForList(options, currentString);
        this.currentString = nextString;
        this.setDisplayString(nextString);
    }

    public void setDisplayString(String string) {
        this.displayString = string;
    }

    public String getDisplayString() {
        return this.displayString;
    }

    public void setCurrentString(String currentString) {
        this.currentString = currentString;
    }

    public void goBack() {
        List<String> reversedOptions = Lists.reverse(new ArrayList<>(options));
        String nextString = getNextObjectForList(reversedOptions, currentString);
        this.currentString = nextString;
        this.setDisplayString(nextString);
    }

    public String getCurrentString() {
        return currentString;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }


    public static <T> T getNextObjectForList(List<T> list, T currentString) {
        boolean isNext = false;
        for(T entry: list) {
            if(isNext) {
                return entry;
            }
            if(entry.equals(currentString)){
                isNext = true;
            }
        }
        return list.stream().findFirst().get();
    }
}

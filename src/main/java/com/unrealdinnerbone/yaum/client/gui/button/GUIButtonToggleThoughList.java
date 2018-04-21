package com.unrealdinnerbone.yaum.client.gui.button;

import com.google.common.collect.Lists;
import com.unrealdinnerbone.yaum.libs.utils.StringUtil;
import net.minecraft.client.gui.GuiButton;

import java.util.ArrayList;
import java.util.List;

public class GUIButtonToggleThoughList extends GuiButton {

    private static int idCount = 4100;
    private List<String> options;

    public GUIButtonToggleThoughList(int x, int y, List<String> options) {
        super(idCount++, x, y, options.stream().findFirst().get());
        this.options = options;
    }

    public void goNext() {
        String nextString = StringUtil.getNextObjectForList(options, displayString);
        this.setDisplayString(nextString);
    }

    public void setDisplayString(String string) {
        this.displayString = string;
    }

    public String getDisplayString() {
        return this.displayString;
    }

    public void setCurrentString(String currentString) {
        this.displayString = currentString;
    }

    public void goBack() {
        List<String> reversedOptions = Lists.reverse(new ArrayList<>(options));
        String nextString = StringUtil.getNextObjectForList(reversedOptions, displayString);
        this.setDisplayString(nextString);
    }


    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }


}

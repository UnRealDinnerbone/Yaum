package com.unrealdinnerbone.yaum.libs.helpers;

import com.unrealdinnerbone.yaum.client.gui.GUIYaumOverlay;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

@SideOnly(Side.CLIENT)
public class GuiHelper
{
    private static ArrayList<GUIYaumOverlay> overylaysToRender = new ArrayList<>();
    private static Timer timer = new Timer();

    public static void displayeGUIOverlay(GUIYaumOverlay gui) {
        timer.schedule(new AddThemLatter(gui), 1000);
    }



    private static class RemoveThemLatter extends TimerTask {
        private GUIYaumOverlay guiYaumOverylay;

        public RemoveThemLatter(GUIYaumOverlay guiYaumOverylay) {
            this.guiYaumOverylay = guiYaumOverylay;
        }

        @Override
        public void run() {
            overylaysToRender.remove(guiYaumOverylay);
        }
    }

    private static class AddThemLatter extends TimerTask {
        private GUIYaumOverlay guiYaumOverylay;

        public AddThemLatter(GUIYaumOverlay guiYaumOverylay) {
            this.guiYaumOverylay = guiYaumOverylay;
        }

        @Override
        public void run() {
            if(overylaysToRender.isEmpty()) {
                overylaysToRender.add(guiYaumOverylay);
                timer.schedule(new RemoveThemLatter(guiYaumOverylay), guiYaumOverylay.getDisplayTime());
            }else {
                timer.schedule(new AddThemLatter(guiYaumOverylay), 1000);
            }
        }
    }

    public static ArrayList<GUIYaumOverlay> getOverylaysToRender() {
        return overylaysToRender;
    }
}

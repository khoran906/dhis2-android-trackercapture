package com.dhis2.utils;

import java.util.List;

import me.toptas.fancyshowcase.FancyShowCaseQueue;
import me.toptas.fancyshowcase.FancyShowCaseView;

/**
 * Created by Administrador on 01/06/2018.
 */

public class HelpManager {

    private static HelpManager instance;
    private List<FancyShowCaseView> help;
    private FancyShowCaseQueue queue;
    private String screen;

    public static HelpManager getInstance() {
        if (instance == null)
            instance = new HelpManager();

        return instance;
    }

    public void setScreenHelp(String screen, List<FancyShowCaseView> steps) {
        help = steps;
        this.screen = screen;
    }

    public void showHelp() {
        if (help != null) {
            queue = new FancyShowCaseQueue();
            for (FancyShowCaseView view : help) {
                queue.add(view);
            }
            queue.show();
        }
    }

    public boolean isTutorialReadyForScreen(String screen){
        return this.screen.equals(screen) && help!=null && !help.isEmpty();
    }
}

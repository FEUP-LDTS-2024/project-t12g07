package com.towerdefense.model.menu;

import java.util.Arrays;
import java.util.List;

public class GameOver {
    private final List<String> title;
    private final String entry;

    public GameOver() {
        this.title = Arrays.asList(
                "  ___   _   __  __ ___    _____   _____ ___   ",
                " / __| /_\\ |  \\/  | __|  / _ \\ \\ / / __| _ \\  ",
                "| (_ |/ _ \\| |\\/| | _|  | (_) \\ V /| _||   /  ",
                " \\___/_/ \\_\\_|  |_|___|  \\___/ \\_/ |___|_|_\\  "
        );
        this.entry = "Press ESC to go back to the menu";
    }
    public String getTitle(int i){
        return title.get(i);
    }
    public int getTitleSize(){
        return this.title.size();
    }
    public String getEntry() {
        return entry;
    }

}
package com.towerdefense.model.menu;

import java.util.Arrays;
import java.util.List;

public class Instructions {
    private final List<String> title;
    private final List<String> entries;
    private final String back;

    public Instructions() {
        this.title = Arrays.asList(
                "  ___ _  _ ___ _____ ___ _   _  ___ _____ ___ ___  _  _ ___ ",
                " |_ _| \\| / __|_   _| _ \\ | | |/ __|_   _|_ _/ _ \\| \\| / __|",
                "  | || .` \\__ \\ | | |   / |_| | (__  | |  | | (_) | .` \\__ \\",
                " |___|_|\\_|___/ |_| |_|_\\\\___/ \\___| |_| |___\\___/|_|\\_|___/"
        );
        this.entries = Arrays.asList("Your castle is in danger!", "Vicious enemies want to steal all your gemstones.",
                "Place defense towers to defeat them before your vault", "is empty.");
        this.back = "Press ESC to go back to the menu";
    }
    public String getTitle(int i){
        return title.get(i);
    }
    public int getTitleSize(){
        return this.title.size();
    }
    public String getEntry(int i) {
        return entries.get(i);
    }
    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getBack() {
        return back;
    }
}
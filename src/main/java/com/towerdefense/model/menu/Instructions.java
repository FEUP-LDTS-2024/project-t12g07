package com.towerdefense.model.menu;

import java.util.Arrays;
import java.util.List;

public class Instructions {
    private final List<String> title;
    private final List<String> entries;

    public Instructions() {
        this.title = Arrays.asList("INSTRUCTIONS:");
        this.entries = Arrays.asList("Your castle is in danger!", "Vicious enemies want to steal all your gemstones.", "Place defense towers to defeat them before your vault", "is empty.");
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
}
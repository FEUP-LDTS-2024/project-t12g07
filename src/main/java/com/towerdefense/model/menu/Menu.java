package com.towerdefense.model.menu;

import java.util.Arrays;
import java.util.List;

public class Menu {
    private final List<String> entries;
    private int currentEntry = 0;
    private final List<String> castle;

    public Menu() {
        this.entries = Arrays.asList("Start", "Instructions", "Exit");
        this.castle = Arrays.asList(
                "                                    |>>>                           ",
                "                                  |                               ",
                "                    |>>>      _  _|_  _         |>>>             ",
                "                    |        |;| |;| |;|        |                ",
                "                _  _|_  _    \\.    .  /    _  _|_  _            ",
                "               |;|_|;|_|;|    \\:. ,  /    |;|_|;|_|;|           ",
                "               \\..      /    ||;   . |    \\.    .  /           ",
                "                \\.  ,  /     ||:  .  |     \\:  .  /            ",
                "                 ||:   |_   _ ||_ . _ | _   _||:   |            ",
                "                 ||:  .|||_|;|_|;|_|;|_|;|_|;||:.  |            ",
                "                 ||:   ||.    .     .      . ||:  .|            ",
                "                 ||: . || .     . .   .  ,   ||:   |         ",
                "                 ||:   ||:  ,  _______   .   ||: , |            ",
                "                 ||:   || .   /+++++++\\    . ||:   |            ",
                "                 ||:   ||.    |+++++++| .    ||: . |            ",
                "              __ ||: . ||: ,  |+++++++|.  . _||_   |            ",
                "     ____--`~    '--~~__|.    |+++++__|----~    ~`---,          ",
                " -~--~                   ~---__|,--~'                  ~~----~~ "
        );
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }


    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedInstructions() {
        return isSelected(1);
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public String getCastle(int i){
        return castle.get(i);
    }
    public int getCastleSize(){
        return this.castle.size();
    }
}

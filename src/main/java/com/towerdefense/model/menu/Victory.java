package com.towerdefense.model.menu;

import java.util.Arrays;
import java.util.List;

public class Victory {
    private final List<String> title;
    private final List<String> castle;
    private final String entry1;
    private final String entry2;

    public Victory() {
        this.title = Arrays.asList(
                " __   _____ ___ _____ ___  _____   __  _ _ _ ",
                " \\ \\ / /_ _/ __|_   _/ _ \\| _ \\ \\ / / | | | |",
                "  \\ V / | | (__  | || (_) |   /\\ V /  |_|_|_|",
                "   \\_/ |___\\___| |_| \\___/|_|_\\ |_|   (_|_|_)"
        );

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

        this.entry1 = "Congratulations! You successfully defended the castle from all the enemies!";
        this.entry2 = "Press ESC to go back to the menu";
    }
    public String getTitle(int i){
        return title.get(i);
    }
    public String getCastle(int i){
        return castle.get(i);
    }
    public int getTitleSize(){
        return this.title.size();
    }
    public int getCastleSize(){
        return this.castle.size();
    }
    public String getEntry1() {
        return entry1;
    }
    public String getEntry2() {
        return entry2;
    }


}
package com.towerdefense.model.game.elements;

import com.towerdefense.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Sea extends Element {
    String[] seaArt;
    public Sea(int x, int y) {
        super(x, y);
        this.seaArt = new String[] {
                " ´ ~ ´",
                " ´´ ~´",
                "~ ´´ ~",
                " ^ ~ ´",
                " ´´ ~´"
        };
    }

    public String[] getSeaArt() {
        return seaArt;}
}

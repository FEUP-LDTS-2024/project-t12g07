package com.towerdefense.model.game.elements;

import com.towerdefense.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Grass extends Element {
    String[] grassArt;
    public Grass(int x, int y) {
        super(x, y);
        this.grassArt = new String[] {
                "  ^ ~ ^ ~",
                " ^ ~ ^  ~",
                "~ ^ ^ ~ ^",
                " ^ ~ ^ ^",
        };
    }

    public String[] getGrassArt() {
        return grassArt;
    }
}

package com.towerdefense.model.game.elements;

public class Grass extends Element {
    String[] grassArt;
    public Grass(int x, int y) {
        super(x, y);
        this.grassArt = new String[] {
                "  ^ ~ ",
                " ^ ~ ^",
                "~ ^ ^ ",
                " ^ ~ ^",
                " ^ ~ ^"
        };
    }

    public String[] getGrassArt() {
        return grassArt;
    }
}

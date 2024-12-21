package com.towerdefense.model.game.elements;

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

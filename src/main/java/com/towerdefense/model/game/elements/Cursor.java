package com.towerdefense.model.game.elements;

public class Cursor extends Element {
    private final String[] cursorArt;
    public Cursor(int x, int y) {
        super(x, y);
        this.cursorArt = new String[] { "X",};
    }

    public String[] getCursorArt() {
        return cursorArt;
    }
}
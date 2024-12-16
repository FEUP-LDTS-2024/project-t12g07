package com.towerdefense.model;

import com.towerdefense.model.game.elements.Element;

public class Cursor extends Element {
    private int x;
    private int y;

    public Cursor(int x, int y) {
        super(x,y);
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
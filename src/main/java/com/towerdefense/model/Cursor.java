package com.towerdefense.model;

public class Cursor {
    private int x;
    private int y;

    public Cursor(int x, int y) {
        this.x = x;
        this.y = y;
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
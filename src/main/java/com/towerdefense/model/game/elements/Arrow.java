package com.towerdefense.model.game.elements;

public class Arrow extends Element{
    private int speed;
    public Arrow(int x, int y) {
        super(x, y);
        this.speed = 20;
    }

    public int getSpeed() {
        return speed;
    }

}

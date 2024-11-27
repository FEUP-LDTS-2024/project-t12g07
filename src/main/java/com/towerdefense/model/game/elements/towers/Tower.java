package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;
import com.towerdefense.model.game.elements.Element;

import java.awt.*;

public abstract class Tower extends Element {
    private int range;
    protected int damage;
    protected int cost;
    String[] towerArt;
    protected TextColor color;


    public Tower(int x, int y) {
        super(x,y);
        this.range = 5; // Default range, since it's the same for all towers
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public String[] getTowerArt() {
        return towerArt;
    }

    public TextColor getColor() {
        return color;
    }

    public int getCost() {
        return cost;
    }

}
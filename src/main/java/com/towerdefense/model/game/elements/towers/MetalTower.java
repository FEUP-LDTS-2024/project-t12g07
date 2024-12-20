package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;

public class MetalTower extends Tower {
    public MetalTower(int x, int y) {
        super(x, y);
        this.damage = 20;
        this.towerArt = new String[] {
                "▲┐┌┐┌▲",
                "├┘└┘└┤",
                "│▲──▲│",
                "││┌┐││",
                "└┘└┘└┘"
        };

        this.color = "#5f767a";
        this.cost = 30;
    }
}

package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;

public class MetalTower extends Tower {
    public MetalTower(int x, int y) {
        super(x, y);
        this.damage = 30;
        this.towerArt = new String[] {
                "▲┐┌┐┌▲",
                "├┘└┘└┤",
                "│x  x│",
                "│▲──▲│",
                "││┌┐││",
                "└┘└┘└┘"
        };

        this.color = TextColor.ANSI.MAGENTA;
        this.cost = 30;
    }
}

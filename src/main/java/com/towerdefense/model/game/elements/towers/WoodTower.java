package com.towerdefense.model.game.elements.towers;
import com.googlecode.lanterna.TextColor;

public class WoodTower extends Tower {
    public WoodTower(int x, int y) {
        super(x, y);
        this.damage = 5;
        this.towerArt = new String[] {
                "┌┐┌┐┌┐",
                "├┘└┘└┤",
                "│x  x│",
                "│ ┌┐ │",
                "└─└┘─┘"
        };

        this.color = "#9e5c2c";
        this.cost = 10;
    }
}

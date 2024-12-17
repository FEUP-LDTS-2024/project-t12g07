package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;

public class StoneTower extends Tower {
    public StoneTower(int x, int y) {
        super(x, y);
        this.damage = 20;
        this.towerArt = new String[] {
                "┌┐┌┐┌┐" ,
                "├┘└┘└┤" ,
                "│▲  ▲│" ,
                "│x┌┐x│" ,
                "└┘└┘└┘"
        };

        this.color = "#b5ada3";
        this.cost = 20;
    }
}
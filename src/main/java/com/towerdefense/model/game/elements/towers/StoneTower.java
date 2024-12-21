package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;

public class StoneTower extends Tower {
    public StoneTower(int x, int y) {
        super(x, y);
        this.damage = 10;
        this.towerArt = new String[] {
                "┌┐┌┐┌┐" ,
                "├┘└┘└┤" ,
                "│▲  ▲│" ,
                "│x┌┐x│" ,
                "└┘└┘└┘"
        };

        this.color = "#454444";
        this.cost = 20;
    }
}
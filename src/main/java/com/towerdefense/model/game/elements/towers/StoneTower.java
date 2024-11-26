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
                "││  ││" ,
                "│x┌┐x│" ,
                "└┘└┘└┘"
        };

        this.color = TextColor.ANSI.YELLOW;
        this.cost = 20;
    }
}
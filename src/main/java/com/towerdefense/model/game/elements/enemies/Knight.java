package com.towerdefense.model.game.elements.enemies;

import com.googlecode.lanterna.TextColor;

public class Knight extends Enemy {

    public Knight(int x, int y) {
        super(x, y);
        this.health = 70;
        this.reward = 20;
        this.sacking = 15;
        this.enemyArt = new String[]{
                "│  ▲  ",
                "┼  O  ",
                "\\ /│\\",
                "  / \\",
                "  ┘ └ "
        }; // ADICIONAR ARTE KNIGHT
        this.color = TextColor.ANSI.BLUE;
    }
}

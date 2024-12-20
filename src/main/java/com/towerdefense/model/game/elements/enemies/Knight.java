package com.towerdefense.model.game.elements.enemies;

public class Knight extends Enemy {

    public Knight(int x, int y) {
        super(x, y);
        this.health = 70;
        this.reward = 15;
        this.sacking = 50;
        this.enemyArt = new String[]{
                "│  ▲  ",
                "┼  O  ",
                "\\ /│\\ ",
                "  / \\ ",
                "  ┘ └ "
        };
    }
}

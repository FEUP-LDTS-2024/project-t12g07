package com.towerdefense.model.game.elements.enemies;

public class Goblin extends Enemy {

    public Goblin(int x, int y) {
        super(x, y);
        this.health = 30;
        this.reward = 5;
        this.sacking = 20;
        this.enemyArt = new String[]{
                "┐   ┌",
                "(OwO)",
                "o/│\\o",
                "_/ \\_",
        };
    }
}

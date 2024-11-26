package com.towerdefense.model.game.elements.enemies;

import com.googlecode.lanterna.TextColor;

public class Goblin extends Enemy {

    public Goblin(int x, int y) {
        super(x, y);
        this.health = 30;
        this.reward = 10;
        this.sacking = 5;
        this.enemyArt = new String[]{ }; // ADICIONAR ARTE GOBLIN
        this.color = TextColor.ANSI.GREEN;
    }
}
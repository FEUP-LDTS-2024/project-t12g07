package com.towerdefense.model.game.elements.enemies;

import com.googlecode.lanterna.TextColor;
import com.towerdefense.model.game.elements.Element;

public abstract class Enemy extends Element {
    public boolean isDead = false;
    protected int reward;
    protected int sacking;
    protected int health;
    String[] enemyArt;
    protected TextColor color;

    public Enemy(int x, int y) {
        super(x,y);
    }

    public String[] getEnemyArt() {
        return enemyArt;
    }

    public TextColor getColor() {
        return color;
    }

    public int getReward() {
        return this.reward;
    }

    public int getHealth() {
        return this.health;
    }

    public int getSacking() {
        return this.sacking;
    }

    public void moveEnemies(Enemy enemy) {

    }

    public boolean isDead() {
        return isDead;
    }
}

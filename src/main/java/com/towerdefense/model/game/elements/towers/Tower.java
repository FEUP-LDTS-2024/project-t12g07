package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;
import com.towerdefense.model.game.elements.Element;
import com.towerdefense.model.game.elements.enemies.Enemy;

import java.awt.*;
import java.util.List;

public abstract class Tower extends Element {
    private int range;
    protected int damage;
    protected int cost;
    String[] towerArt;
    private boolean targeted;
    protected String color;
    private int cooldown;
    private int cooldownTimer;


    public Tower(int x, int y) {
        super(x,y);
        this.range = 6;
        this.cooldown = 0;
        this.cooldownTimer = 0;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public String[] getTowerArt() {
        return towerArt;
    }

    public String getColor() {
        return color;
    }

    public int getCost() {
        return cost;
    }

    public void update(List<Enemy> enemies) {
        if (cooldownTimer <= 0) {
            Enemy target = findTarget(enemies);
            if (target != null) {
                attack(target);
                cooldownTimer = cooldown;
            }
        } else {
            cooldownTimer--;
        }
    }

    private Enemy findTarget(List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (isInRange(enemy)) {
                return enemy;
            }
        }
        return null;
    }

    private boolean isInRange(Enemy enemy) {
        int dx = enemy.getPosition().getX() - this.getPosition().getX();
        int dy = enemy.getPosition().getY() - this.getPosition().getY();
        return Math.sqrt(dx * dx + dy * dy) <= range;
    }

    private void attack(Enemy target) {
        target.takeDamage(damage);
    }

}
package com.towerdefense.model.game.elements.towers;

import com.googlecode.lanterna.TextColor;
import com.towerdefense.model.game.elements.Element;
import com.towerdefense.model.game.elements.enemies.Enemy;

import java.awt.*;

public abstract class Tower extends Element {
    private int range;
    protected int damage;
    protected int cost;
    String[] towerArt;
    private Enemy target;
    private long lastFiredTime;
    private boolean targeted;
    protected String color;


    public Tower(int x, int y) {
        super(x,y);
        this.range = 5; // Default range, since it's the same for all towers
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


    public float findDistance(Enemy enemy) {
        /* float xDistance= Math.abs(enemy.getPosition().getX()-getX());
        float yDistance= Math.abs(enemy.getPosition().getY()-getY());
        return xDistance+yDistance; */
        return 0;
    }

    public void update() throws Exception {
        /* if (target == null || target.isDead() || !isInRange(target)) {
            targeted = false;
            target = acquireTarget(); */
        }

        long currentTime = System.currentTimeMillis();
        //pastTime = currentTime;




        long timeSinceLastFired = currentTime - lastFiredTime;
        /* if (targeted && findDistance(target) < range && timeSinceLastFired >= getFiringSpeed()) {
            shoot(target);
            Projectile novo = new Projectile(getX() + 1, getY() + 1, target, getFiringSpeed(), getDamage());
            projectiles.add(novo);

            lastFiredTime = currentTime;
        }
    } */


}
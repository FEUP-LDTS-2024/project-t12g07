package com.towerdefense.model.game.elements.enemies;

import com.googlecode.lanterna.TextColor;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Element;
import com.towerdefense.model.game.elements.Path;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends Element {
    public boolean isDead = false;
    protected int reward;
    protected int sacking;
    protected int health;
    String[] enemyArt;
    protected String color;
    protected List<Position> path;

    public Enemy(int x, int y) {
        super(x,y);
        this.path = new ArrayList<>();
        this.path.add(new Position(-42,25));
        this.path.add(new Position(-36,25));
        this.path.add(new Position(-30,25));
        this.path.add(new Position(-24,25));
        this.path.add(new Position(-18,25));
        this.path.add(new Position(-12,25));
        this.path.add(new Position(-6,25));
        this.path.add(new Position(0,25));
        this.path.add(new Position(6,25));
        this.path.add(new Position(12,25));
        this.path.add(new Position(12,20));
        this.path.add(new Position(12,15));
        this.path.add(new Position(12,5));
        this.path.add(new Position(18,5));
        this.path.add(new Position(24,5));
        this.path.add(new Position(30,5));
        this.path.add(new Position(36,5));
        this.path.add(new Position(42,5));
        this.path.add(new Position(48,5));
        this.path.add(new Position(54,5));
        this.path.add(new Position(60,5));
        this.path.add(new Position(66,5));
        this.path.add(new Position(72,5));
        this.path.add(new Position(78,5));
        this.path.add(new Position(78,10));
        this.path.add(new Position(78,15));
        this.path.add(new Position(78,20));
        this.path.add(new Position(72,20));
        this.path.add(new Position(66,20));
        this.path.add(new Position(60,20));
        this.path.add(new Position(54,20));
        this.path.add(new Position(54,25));
        this.path.add(new Position(60,30));
        this.path.add(new Position(66,30));
        this.path.add(new Position(72,30));
        this.path.add(new Position(78,30));
        this.path.add(new Position(90,30));

        int sim = 1 + (int) (Math.random() * 3); // Generates 1, 2, or 3
        if (sim == 1) {
            this.color = "#ff0000" ;
        } else if (sim == 2) {
            this.color = "#ab1313";
        } else {
            this.color = "#801818";
        }
    }

    public String[] getEnemyArt() {
        return enemyArt;
    }

    public String getColor() {
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
        switch (enemy.getHealth()) {
            case 150:
                for(int i = 0; i < 1; i++){
                    moveEnemy();
                }
                break;
            case 70, 30:
                for(int i = 0; i < 2; i++){
                    moveEnemy();
                }
                break;
        }
    }

    public void moveEnemy() {
        for (int i = 0; i < path.size() - 1; i++){
            if (this.getPosition().getX() == path.get(i).getX() && this.getPosition().getY() == path.get(i).getY()){
                Position position = new Position(path.get(i + 1).getX(), path.get(i + 1).getY());
                this.setPosition((position));
                i = path.size() - 1;
            }
        }
    }

    public boolean isDead() {
        return isDead;
    }

    public void takeDamage(int towerDamage) {
        this.health -= towerDamage;
        if (health <= 0){
            this.isDead = true;
        }
    }

}

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
    protected TextColor color;
    protected List<Position> path;


    public Enemy(int x, int y) {
        super(x,y);
        this.path = new ArrayList<>();
        this.path.add(new Position(0,25));
        this.path.add(new Position(7,25));
        this.path.add(new Position(14,25));
        this.path.add(new Position(14,20));
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
        switch (enemy.getHealth()) {
            case 150:
                for(int i = 0; i < 1; i++){
                    moveEnemy();
                }
                break;
            case 70:
                for(int i = 0; i < 2; i++){
                    moveEnemy();
                }
                break;
            case 30:
                for(int i = 0; i < 3; i++){
                    moveEnemy();
                }
                break;
        }
    }

    public void moveEnemy() {
        Position currentPosition = this.getPosition();
        int currentIndex = path.indexOf(currentPosition);

        if (currentIndex >= 0 && currentIndex < path.size() - 1) {
            // Move the enemy to the next position in the path
            Position nextPosition = path.get(currentIndex + 1);
            this.setPosition(nextPosition); // Update the position
        } else {
            // If the enemy reached the end of the path
            this.isDead = true;  // The enemy is considered dead
        }
    }

    public boolean isDead() {
        return isDead;
    }
}

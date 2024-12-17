package com.towerdefense.model.game.elements.enemies;

import com.googlecode.lanterna.TextColor;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Element;

public abstract class Enemy extends Element {
    private Board board;
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
        switch (enemy.getClass().getName()) {
            case "Giant":
                for(int i = 0; i < 1; i++){
                    moveEnemy(enemy);
                }
                break;
            case "Knight":
                for(int i = 0; i < 2; i++){
                    moveEnemy(enemy);
                }
                break;
            case "Goblin":
                for(int i = 0; i < 3; i++){
                    moveEnemy(enemy);
                }
                break;
        }
    }

    public void moveEnemy(Enemy enemy){
        Position position = enemy.getPosition();
        for (int i = 0; i < board.getPath().size() - 1; i++){
            if (board.getPath().get(i).getPosition() == position){
                position = new Position(board.getPath().get(i + 1).getPosition().getX(), board.getPath().get(i + 1).getPosition().getY());
            }
        }
    }

    public boolean isDead() {
        return isDead;
    }
}

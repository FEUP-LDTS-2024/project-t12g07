package com.towerdefense.model.game.board;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Castle;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.util.List;

public class Board {
    private final int width;
    private final int height;
    private int coins;

    private Castle castle;

    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Position> path;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Tower> getTowers() {
        return towers;
    }

    public void setTowers(List<Tower> towers) {
        this.towers = towers;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> monsters) {
        this.enemies = monsters;
    }

    public boolean isEnemy(Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public Castle getCastle() {
        return castle;
    }

    public int getCoins() {
        return coins;
    }
}

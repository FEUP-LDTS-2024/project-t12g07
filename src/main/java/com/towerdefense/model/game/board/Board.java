package com.towerdefense.model.game.board;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.*;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int width;
    private final int height;
    private int coins;
    private Castle castle;
    private TowerShop towerShop;
    private List<Tower> towers;
    private List<Enemy> enemies;
    private List<Path> paths;
    private List<Grass> grasses;
    private List<Sea> seas;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.castle = new Castle(90,18);
        this.towerShop = new TowerShop(114, 0);
        this.towers = new ArrayList<>();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    public void setTowers(List<Tower> towers) { this.towers = towers; }

    public List<Tower> getTowers() {
        return towers;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public boolean isEnemy (Position position) {
        for (Enemy enemy : enemies)
            if (enemy.getPosition().equals(position))
                return true;
        return false;
    }

    public Castle getCastle() {
        return castle;
    }

    public int getCoins() { return coins; }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public List<Path> getPath() {
        return paths;
    }

    public void setPath (List<Path> paths) {
        this.paths = paths;
    }

    public List<Grass> getGrass() {
        return grasses;
    }

    public void setGrass (List<Grass> grasses) {
        this.grasses = grasses;
    }

    public List<Sea> getSea() {
        return seas;
    }

    public void setSea (List<Sea> seas) {
        this.seas = seas;
    }

    public TowerShop getTowerShop() {
        return towerShop;
    }

}

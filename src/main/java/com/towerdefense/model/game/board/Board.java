package com.towerdefense.model.game.board;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Castle;
import com.towerdefense.model.game.elements.Grass;
import com.towerdefense.model.game.elements.Path;
import com.towerdefense.model.game.elements.Sea;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int width;
    private final int height;
    private int coins;
    private Castle castle;

    private List<Tower> towers;
    private List<Enemy> enemies;
    private Path path;
    private Grass grass;
    private Sea sea;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.castle = new Castle(90,18);
        this.towers = new ArrayList<>();
        this.grass = new Grass(30,11);
        this.sea = new Sea(5,5);
        this.path = new Path(60,9);
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

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public List<Enemy> getEnemies() {
        return enemies;
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

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    public int getCoins() { return coins; }

    public void setCoins(int coins) {
        this.coins = coins;
    }


    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public Grass getGrass() {
        return grass;
    }

    public void setGrass(Grass grass) {
        this.grass = grass;
    }

    public Sea getSea() {
        return sea;
    }

    public void setSea(Sea sea) {
        this.sea = sea;
    }

}

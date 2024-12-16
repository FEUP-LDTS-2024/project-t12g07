package com.towerdefense.controllers.game;

import com.towerdefense.Game;


import com.towerdefense.gui.GUI;
import com.towerdefense.model.Wave;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.enemies.Enemy;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController{
    public List<Enemy> enemies ;
    private long lastMovement;
    private final Board board;
    private final Wave wave;

    public EnemyController(Board board) {
        super(board);
        this.board = board;
        this.enemies = new ArrayList<>();
        this.lastMovement = 0;
        this.wave= new Wave();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 500) {
            moveEnemies();
            if (enemies.isEmpty()) {
                List<Enemy> newEnemies = wave.getEnemyList();
                board.setEnemies(newEnemies);
                enemies = newEnemies;
            }

            this.lastMovement = time;
        }
    }


    public void moveEnemies() {
        List<Enemy> deadEnemies = new ArrayList<>();
        for (Enemy enemy : enemies) {
            enemy.moveEnemies(enemy);

            if (enemy.isDead()) {
                deadEnemies.add(enemy);
            }
        }
        enemies.removeAll(deadEnemies);
    }
}

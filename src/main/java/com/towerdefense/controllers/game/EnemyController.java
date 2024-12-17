package com.towerdefense.controllers.game;

import com.towerdefense.Game;


import com.towerdefense.gui.GUI;
import com.towerdefense.model.Wave;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.enemies.Enemy;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

public class EnemyController extends GameController {
    private List<Enemy> enemies;
    private long lastMovement;
    private final Board board;
    private final Wave wave;

    public EnemyController(Board board) {
        super(board);
        this.board = board;
        this.enemies = new ArrayList<>();
        this.lastMovement = 0;
        this.wave = new Wave();
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        // Check if enough time has passed (500ms) before moving enemies again
        if (time - lastMovement > 800) {
            moveEnemies();
            wave.updateWave();  // Update the wave's progress
            if (enemies.isEmpty()) {
                // If no enemies are left, spawn new ones for the next wave
                wave.spawn(wave.getWave());
                List<Enemy> newEnemies = wave.getEnemyList();
                board.setEnemies(newEnemies);
                enemies = newEnemies;
            }

            this.lastMovement = time;
        }
    }


    // Move all enemies and remove dead ones
    public void moveEnemies() {
        List<Enemy> deadEnemies = new ArrayList<>();
        for (Enemy enemy : enemies) {
            enemy.moveEnemies(enemy);
            // Move each enemy (no need to pass enemy as argument)

            // If the enemy is dead, add it to the dead list
            if (enemy.isDead()) {
                deadEnemies.add(enemy);
            }
        }
        // Remove dead enemies from the list
        enemies.removeAll(deadEnemies);
    }
}
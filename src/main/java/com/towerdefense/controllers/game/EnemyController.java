package com.towerdefense.controllers.game;

import com.towerdefense.Game;


import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Wave;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Warning;
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
        this.wave = new Wave(140,20);
    }

    void tellWave() {
        String[] messages;

        switch (wave.getWave()) {
            case 1:
                messages = new String[]{ "CURRENT WAVE: " + wave.getWave()," ", "Watch out for the", "goblins!" };
                break;
            case 2:
                messages = new String[]{ "CURRENT WAVE: " + wave.getWave()," ", "Act fast! Knights", "are approaching!" };
                break;
            case 3:
                messages = new String[]{ "CURRENT WAVE: " + wave.getWave()," ", "Giants incoming! Be", "careful!" };
                break;
            default:
                messages = new String[]{ "CURRENT WAVE: " + wave.getWave()," ", "Stay strong!" };
                break;
        }
        Warning warning = new Warning(117, 8, messages, 1500, "#FFFFFF");
        getModel().setWarning(warning);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (time - lastMovement > 800) {
            moveEnemies();

            if (enemies.isEmpty()) {
                wave.updateWave();
                wave.spawn(wave.getWave());
                List<Enemy> newEnemies = wave.getEnemyList();
                board.setEnemies(newEnemies);
                enemies = newEnemies;
                if (wave.getWave()==11) getModel().setVictory(true);
                tellWave();
            }

            this.lastMovement = time;
        }
    }


    public void moveEnemies() {
        List<Enemy> deadEnemies = new ArrayList<>();
        for (Enemy enemy : enemies) {
            enemy.moveEnemies(enemy);

            if (enemy.isDead()) {
                int reward = enemy.getReward();
                getModel().getTowerShop().addReward(reward);
                String[] messages = { "+" + reward };
                Warning warning = new Warning(128, 2, messages, 300, "#3884ff");
                getModel().setWarning(warning);
                deadEnemies.add(enemy);
            }

            if (enemy.getPosition().getX() == 90 && enemy.getPosition().getY() == 30){
                getModel().getCastle().stealing(enemy.getSacking());
                deadEnemies.add(enemy);
            }
        }
        enemies.removeAll(deadEnemies);
    }
}
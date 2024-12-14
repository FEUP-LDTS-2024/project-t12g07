package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.model.Position;
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
    public void step(Game game, WindowInterface.KEY action, long time) throws IOException {
        if (time - lastMovement > 500) {
            moveEnemies();
            level.updateLevel(scoreModel);
            if (enemies.isEmpty()) {

                wave.spawn(level.getLevel());
                List<Enemy> newEnemies=wave.getEnemyList();
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
        for(Enemy enemy: deadEnemies){
            updateScore(enemy);
        }

    }
    public void updateScore(Enemy enemy) {
        Position deathPosition;
        switch (enemy.getEnemySymbol()) {
            case 'S':
                deathPosition = enemy.getDeathPosition();
                if (deathPosition.getX() == 93 && deathPosition.getY() == 5) {
                    getModel().getChest().decreaseLife();
                    break;
                }
                scoreModel.incrementScore(50 );
                getModel().setScore(scoreModel);
                getModel().setCoins(getModel().getCoins() + 10);
                break;
            case 'O':
                deathPosition = enemy.getDeathPosition();
                if (deathPosition.getX() == 91 && deathPosition.getY() == 5) {
                    getModel().getChest().decreaseLife();
                    break;
                }
                scoreModel.incrementScore(75 );
                getModel().setScore(scoreModel);
                getModel().setCoins(getModel().getCoins() + 20);

                break;
            case 'G':
                deathPosition = enemy.getDeathPosition();
                if (deathPosition.getX() == 92 && deathPosition.getY() == 5) {
                    getModel().getChest().decreaseLife();
                    break;
                }
                scoreModel.incrementScore(100 );
                getModel().setScore(scoreModel);
                getModel().setCoins(getModel().getCoins() + 35);

                break;
        }
    }
}

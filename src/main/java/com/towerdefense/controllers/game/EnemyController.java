package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.enemies.Enemy;

import java.io.IOException;

public class EnemyController extends GameController{
    private long lastMovement;

    public EnemyController(Board board) {
        super(board);

        this.lastMovement = 0;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {


    }

    private void moveEnemy(Enemy enemy, Position position) {
        if (getModel().isEmpty(position)) {
            enemy.setPosition(position);
            if (getModel().getHero().getPosition().equals(position))
                getModel().getHero().decreaseEnergy();
        }
    }
}

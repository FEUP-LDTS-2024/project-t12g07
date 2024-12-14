package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.states.GameOverState;
import com.towerdefense.states.MenuState;

import java.io.IOException;

public class BoardController extends GameController{
    private final TowerController towerController;
    private final EnemyController enemyController;

    public BoardController(Board board) {
        super(board);

        this.towerController = new TowerController(board);
        this.enemyController = new EnemyController(board);
    }
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else if (getModel().getCastle().getWealth() == 0)
            game.setState(new GameOverState(new GameOver()));
        else {
            towerController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}

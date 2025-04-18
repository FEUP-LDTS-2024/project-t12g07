package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.states.GameOverState;
import com.towerdefense.states.MenuState;
import com.towerdefense.states.VictoryState;

import java.io.IOException;

public class BoardController extends GameController{
    private final TowerController towerController;
    private final EnemyController enemyController;
    private final TowerShopController towerShopController;
    private final CursorController cursorController;

    public BoardController(Board board) {
        super(board);
        this.towerController = new TowerController(board);
        this.enemyController = new EnemyController(board);
        this.towerShopController = new TowerShopController(board);
        this.cursorController = new CursorController(board);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else if (getModel().getCastle().getWealth() <= 0)
            game.setState(new GameOverState(new GameOver()));
        else if (getModel().getVictory())
            game.setState(new VictoryState(new Victory()));
        else {
            try {
                towerController.step(game, action, time);
                enemyController.step(game, action, time);
                towerShopController.step(game, action, time);
                cursorController.step(game, action, time);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

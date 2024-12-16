package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.states.GameOverState;
import com.towerdefense.states.MenuState;

import java.io.IOException;

public class BoardController extends GameController{
    private final TowerController towerController;
    private final EnemyController enemyController;
    private final TowerShopController towerShopController;

    public BoardController(Board board) {
        super(board);
        this.towerController = new TowerController(board);
        this.enemyController = new EnemyController(board);
        this.towerShopController = new TowerShopController(board);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
        else if (getModel().getCastle().getWealth() == 0)
            game.setState(new GameOverState(new GameOver()));
        else {
            try {
                towerController.step(game, action, time);
                enemyController.step(game, action, time);
                towerShopController.step(game, action, time);
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception or log it
            }
        }
    }
}

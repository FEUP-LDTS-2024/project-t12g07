package com.towerdefense.controllers.game;

import com.towerdefense.gui.GUI;

import java.io.IOException;

public class BoardController extends GameController{
    private final TowerController towerController;
    private final EnemyController enemyController;

    public ArenaController(Board board) {
        super(board);

        this.towerController = new HeroController(board);
        this.enemyController = new MonsterController(board);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new MenuState(new Menu()));
        else {
            towerController.step(game, action, time);
            enemyController.step(game, action, time);
        }
    }
}

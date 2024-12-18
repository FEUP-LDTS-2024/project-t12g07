package com.towerdefense.controllers.menu;
import com.towerdefense.Game;
import com.towerdefense.controllers.Controller;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.states.MenuState;

import java.io.IOException;

public class GameOverController extends Controller<GameOver> {
    public GameOverController(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
    }
}


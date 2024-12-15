package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.controllers.Controller;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.LoaderBoardBuilder;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.states.GameState;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderBoardBuilder(1).createBoard()));
        }
    }
}

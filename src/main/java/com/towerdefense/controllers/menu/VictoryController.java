package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.controllers.Controller;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.states.MenuState;

import java.io.IOException;

public class VictoryController extends Controller<Victory> {
    public VictoryController(Victory victory) {
        super(victory);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
    }
}
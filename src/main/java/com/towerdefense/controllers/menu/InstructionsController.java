package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.controllers.Controller;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.states.MenuState;

import java.io.IOException;

public class InstructionsController extends Controller<Instructions> {
    public InstructionsController(Instructions instructions) {
        super(instructions);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.QUIT)
            game.setState(new MenuState(new Menu()));
    }
}

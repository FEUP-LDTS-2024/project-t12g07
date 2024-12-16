package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.board.LoaderBoardBuilder;
import com.towerdefense.model.game.elements.towers.Tower;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.states.GameState;
import com.towerdefense.states.InstructionsState;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TowerShopController extends GameController {

    public TowerShopController(Board board) {
        super(board);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().getTowerShop().previousEntry();
                break;
            case DOWN:
                getModel().getTowerShop().nextEntry();
                break;
            case SELECT:
                if (getModel().getTowerShop().isSelected1()) {}
                if (getModel().getTowerShop().isSelected2()) {}
                if (getModel().getTowerShop().isSelected3()) {}
        }
    }

}

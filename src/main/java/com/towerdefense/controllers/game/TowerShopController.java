package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.towers.*;
import java.io.IOException;

public class TowerShopController extends GameController {

    public TowerShopController(Board board) {
        super(board);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case TOWER_SELECT:
                getModel().getTowerShop().nextEntry();
                break;
            case SELECT:
                if (getModel().getTowerShop().isSelected1()) { placeTower(new WoodTower(getModel().getCursor().getPosition().getX(), getModel().getCursor().getPosition().getY())); }
                if (getModel().getTowerShop().isSelected2()) { placeTower(new StoneTower(getModel().getCursor().getPosition().getX(), getModel().getCursor().getPosition().getY()));}
                if (getModel().getTowerShop().isSelected3()) { placeTower(new MetalTower(getModel().getCursor().getPosition().getX(), getModel().getCursor().getPosition().getY()));}
        }
    }

    public void placeTower(Tower tower) {
        if (getModel().getTowerShop().purchaseTower(tower)) {
            getModel().getTowers().add(tower);
        }
    }

}

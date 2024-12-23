package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Warning;
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
            default:
                break;
        }
    }

    public void placeTower(Tower tower) {
        if (getModel().isGrass(tower.getPosition())) {
            if (!getModel().isTower(tower.getPosition())) {
                if (getModel().getTowerShop().purchaseTower(tower)) getModel().getTowers().add(tower);
                else {
                    String[] messages = { "Not enough money!" };
                    Warning warning = new Warning(117, 6, messages, 800, "#db1a00");
                    getModel().setWarning(warning);
                }
            }
            else {
                String[] messages = { "There's already a", "tower here!" };
                Warning warning = new Warning(117, 7, messages, 800, "#db1a00");
                getModel().setWarning(warning);
            }
        }
        else {
            String[] messages = { "Can't place towers", "outside the grass!" };
            Warning warning = new Warning(117, 7, messages, 800, "#db1a00");
            getModel().setWarning(warning);
        }
    }
}

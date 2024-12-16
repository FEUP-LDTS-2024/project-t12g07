package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.TowerShop;
import com.towerdefense.model.game.elements.towers.Tower;

public class TowerShopViewer implements ElementViewer<TowerShop> {
    @Override
    public void draw(TowerShop towerShop, GUI gui) {
        gui.drawTowerShop(towerShop.getPosition(), towerShop);
    }

}

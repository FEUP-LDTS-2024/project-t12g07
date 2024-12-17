package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.TowerShop;
import com.towerdefense.model.game.elements.towers.Tower;

public class TowerShopViewer implements ElementViewer<TowerShop> {
    @Override
    public void draw(TowerShop towerShop, GUI gui) {
        gui.drawTowerShop(towerShop.getPosition(), towerShop);

        // Draw the entries and highlight the selected one
        for (int i = 0; i < towerShop.getNumberEntries(); i++) {
            String entryText = towerShop.getEntry(i);
            gui.drawText(
                    new Position(117, 8 + 7*i),
                    entryText,
                    towerShop.isSelected(i) ? "#fcc623" : "#FFFFFF"
            );
        }

        String moneyText = "Money: " + towerShop.getMoney();
        gui.drawText(
                new Position(117, 2),
                moneyText,
                "#FFFFFF"
        );
    }
}

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
            String entryText = towerShop.getEntry(i); // Get the entry text
            gui.drawText(
                    new Position(118, 8 + 8*i), // Position for each entry (adjust as needed)
                    entryText,
                    towerShop.isSelected(i) ? "#fcc623" : "#FFFFFF" // Highlight the selected entry
            );
        }
    }



}

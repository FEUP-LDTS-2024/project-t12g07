package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.towers.Tower;

public class TowerViewer implements ElementViewer<Tower> {
    @Override
    public void draw(Tower tower, GUI gui) {
        gui.drawTower(tower.getPosition(), tower);
    }
}

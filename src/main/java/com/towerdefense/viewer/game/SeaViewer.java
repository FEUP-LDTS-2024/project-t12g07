package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Sea;

public class SeaViewer implements ElementViewer<Sea>{
    @Override
    public void draw(Sea sea, GUI gui) {
        gui.drawSea(sea.getPosition(), sea);
    }
}

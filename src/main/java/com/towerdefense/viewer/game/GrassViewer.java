package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Grass;

public class GrassViewer implements ElementViewer<Grass> {
    @Override
    public void draw(Grass grass, GUI gui) {
        gui.drawGrass(grass.getPosition(), grass);
    }
}

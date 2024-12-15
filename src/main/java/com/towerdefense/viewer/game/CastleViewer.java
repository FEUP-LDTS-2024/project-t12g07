package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Castle;

public class CastleViewer implements ElementViewer<Castle> {
    @Override
    public void draw(Castle castle, GUI gui) {
        gui.drawCastle(castle.getPosition(), castle);
    }

}

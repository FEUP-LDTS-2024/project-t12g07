package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Warning;

public class WarningViewer implements ElementViewer<Warning> {
    @Override
    public void draw(Warning warning, GUI gui) {
        if (warning.isActive()) {
            gui.drawText(
                    new Position(warning.getPosition().getX(), warning.getPosition().getY()),
                    warning.getMessage(),
                    "#FF0000" // Red color for warnings
            );
        }
    }
}
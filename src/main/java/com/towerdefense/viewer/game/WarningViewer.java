package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Warning;

public class WarningViewer implements ElementViewer<Warning> {
    @Override
    public void draw(Warning warning, GUI gui) {
        if (warning.isActive()) {
            int x = warning.getPosition().getX();
            int y = warning.getPosition().getY();

            String[] messages = warning.getMessages();
            for (int i = 0; i < messages.length; i++) {
                gui.drawText(
                        new Position(x, y + i),
                        messages[i],
                        warning.getColor()
                );
            }
        }
    }
}
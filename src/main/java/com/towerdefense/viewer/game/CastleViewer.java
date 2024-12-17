package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Castle;

public class CastleViewer implements ElementViewer<Castle> {
    @Override
    public void draw(Castle castle, GUI gui) {
        gui.drawCastle(castle.getPosition(), castle);
        String wealthText = "Vault: " + castle.getWealth();
        gui.drawText(
                new Position(117,4), // Position below the castle art
                wealthText,
                "#FFFFFF"
        );



        // Draw the wealth bar directly below the wealth text
        int currentWealth = castle.getWealth();
        double wealthRatio = (double) currentWealth / Castle.FULL_VAULT; // Proportion of wealth
        int filledWidth = (int) (wealthRatio * 20); // Number of filled characters

        // Draw the filled part of the bar (green)
        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < filledWidth; i++) {
            bar.append("=");
        }

        gui.drawText(
                new Position(117, 5),
                " " + bar + " ",
                "#00FF00"
        );

        StringBuilder emptyBar = new StringBuilder();
        for (int i = filledWidth; i < 20; i++) {
            emptyBar.append("-");
        }

        gui.drawText(
                new Position(117 + 1 + filledWidth, 5),
                emptyBar.toString(),
                "#FFFFFF"
        );

        // Draw the enclosing brackets
        gui.drawText(
                new Position(117, 5), // Left bracket position
                "[",
                "#FFFFFF"
        );

        gui.drawText(
                new Position(117 + 20, 5), // Right bracket position
                "]",
                "#FFFFFF"
        );
    }
}

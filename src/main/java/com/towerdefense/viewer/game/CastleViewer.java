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
                new Position(117,4),
                wealthText,
                "#FFFFFF"
        );



        int currentWealth = castle.getWealth();
        double wealthRatio = (double) currentWealth / Castle.FULL_VAULT;
        int filledWidth = (int) (wealthRatio * 20);

        String barColor;
        if (wealthRatio <= 1.0 / 6.0) {
            barColor = "#FF0000";
        } else if (wealthRatio <= 1.0 / 3.0) {
            barColor = "#FFA500";
        } else if (wealthRatio <= 2.0 / 3.0) {
            barColor = "#FFFF00";
        } else {
            barColor = "#00FF00";
        }

        StringBuilder bar = new StringBuilder();
        for (int i = 0; i < filledWidth; i++) {
            bar.append("=");
        }

        gui.drawText(
                new Position(117, 5),
                " " + bar + " ",
                barColor
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


        gui.drawText(
                new Position(117, 5),
                "[",
                "#FFFFFF"
        );

        gui.drawText(
                new Position(117 + 20, 5),
                "]",
                "#FFFFFF"
        );
    }
}

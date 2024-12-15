package com.towerdefense.viewer.menu;

import com.googlecode.lanterna.gui2.Window;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.viewer.Viewer;

public class GameOverViewer extends Viewer<GameOver> {
    public GameOverViewer(GameOver gameover) {
        super(gameover);
    }

    @Override
    public void drawElements(GUI gui) {
        for (int i = 0; i < getModel().getTitleSize(); i++)
            gui.drawText(new Position(20,18  + i), getModel().getTitle(i), "RED");
        gui.drawText(new Position(45, 29 ), getModel().getEntry(), "#FFFFFF" );
    }
}

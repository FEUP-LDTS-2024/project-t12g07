package com.towerdefense.viewer.menu;

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
        gui.drawText(new Position(52, 28 ), getModel().getEntry(), "#db1a00" );
        for (int i = 0; i < getModel().getTitleSize(); i++)
            gui.drawText(new Position(45,10  + i), getModel().getTitle(i), "#db1a00");
    }
}

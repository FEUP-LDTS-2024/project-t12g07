package com.towerdefense.viewer.menu;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.viewer.Viewer;

public class VictoryViewer extends Viewer<Victory> {
    public VictoryViewer(Victory victory) {
        super(victory);
    }

    @Override
    public void drawElements(GUI gui) {
        for (int i = 0; i < getModel().getCastleSize(); i++)
            gui.drawText(new Position(72,21  + i), getModel().getCastle(i), "#3884ff");
        gui.drawText(new Position(35, 16 ), getModel().getEntry1(), "#3884ff" );
        gui.drawText(new Position(52, 28 ), getModel().getEntry2(), "#3884ff" );
        for (int i = 0; i < getModel().getTitleSize(); i++)
            gui.drawText(new Position(45,10  + i), getModel().getTitle(i), "#3884ff");
    }
}

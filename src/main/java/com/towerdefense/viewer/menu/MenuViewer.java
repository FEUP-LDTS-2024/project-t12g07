package com.towerdefense.viewer.menu;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) {
        super(menu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(22, 5), "GEMSTONE GUARDIANS", "#07a609");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(22, 7 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#07a609" : "#FFFFFF");
    }
}

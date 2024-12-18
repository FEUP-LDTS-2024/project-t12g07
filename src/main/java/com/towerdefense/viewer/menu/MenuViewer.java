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
        // Each line of the ASCII art is drawn at a different vertical position
        gui.drawText(new Position(25, 6), "   ___ ___ __  __ ___ _____ ___  _  _ ___    ___ _   _  _   ___ ___ ___   _   _  _ ___ ", "#07a609");
        gui.drawText(new Position(25, 7), "  / __| __|  \\/  / __|_   _/ _ \\| \\| | __|  / __| | | |/_\\ | _ \\   \\_ _| /_\\ | \\| / __|", "#07a609");
        gui.drawText(new Position(25, 8), " | (_ | _|| |\\/| \\__ \\ | || (_) | .` | _|  | (_ | |_| / _ \\|   / |) | | / _ \\| .` \\__ \\", "#07a609");
        gui.drawText(new Position(25, 9), "  \\___|___|_|  |_|___/ |_| \\___/|_|\\_|___|  \\___|\\___/_/ \\_\\_|_\\___/___/_/ \\_\\_|\\_|___/", "#07a609");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(60, 15 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#07a609" : "#FFFFFF");
    }
}

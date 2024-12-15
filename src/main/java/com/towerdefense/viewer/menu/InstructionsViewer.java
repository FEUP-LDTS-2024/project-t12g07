package com.towerdefense.viewer.menu;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.viewer.Viewer;

public class InstructionsViewer extends Viewer<Instructions> {


    public InstructionsViewer(Instructions controls) {
        super(controls);
    }

    @Override
    public void drawElements(GUI gui) {
        for (int i = 0; i < getModel().getTitleSize(); i++)
            gui.drawText(new Position(5,2  + i), getModel().getTitle(i), "WHITE");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(new Position(10, 14 + i*5), getModel().getEntry(i),  "#FFD700");
    }
}
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
            gui.drawText(new Position(4,2  + i), getModel().getTitle(i), "#fc9023");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(new Position(6, 10 + i), getModel().getEntry(i),  "#fcc623");
        gui.drawText(new Position(6, 17), getModel().getControlTitle(),  "#fc9023");
        for (int i = 0; i < getModel().getControlEntriesSize(); i++)
            gui.drawText(new Position(6, 18 + i), getModel().getControlEntries(i),  "#fcc623");
        gui.drawText(new Position(55, 28), getModel().getBack(),  "#fc9023");
    }
}
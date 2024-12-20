package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Cursor;

public class CursorViewer implements ElementViewer<Cursor>{
    @Override
    public void draw(Cursor cursor, GUI gui) {
        gui.drawCursor(cursor.getPosition(), cursor);
    }
}

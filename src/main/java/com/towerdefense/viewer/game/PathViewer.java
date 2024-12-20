package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Path;

public class PathViewer implements ElementViewer<Path>{
    @Override
    public void draw(Path path, GUI gui) {
        gui.drawPath(path.getPosition(), path);
    }
}

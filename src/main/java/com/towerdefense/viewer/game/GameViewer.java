package com.towerdefense.viewer.game;

import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Element;
import com.towerdefense.viewer.Viewer;

import java.util.List;

public class GameViewer {
    public GameViewer(Board board) {
        super(board);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getCastle(), new CastleViewer());
        drawElements(gui, getModel().getEnemy(), new EnemyViewer());
        drawElement(gui, getModel().getGrass(), new GrassViewer());
        drawElement(gui, getModel().getPath(), new PathViewer());
        drawElement(gui, getModel().getSea(), new SeaViewer());
        drawElement(gui, getModel().getTower(), new TowerViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

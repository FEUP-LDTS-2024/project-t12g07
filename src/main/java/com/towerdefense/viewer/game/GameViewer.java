package com.towerdefense.viewer.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Element;
import com.towerdefense.model.game.elements.TowerShop;
import com.towerdefense.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Board> {
    public GameViewer(Board board) {
        super(board);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElement(gui, getModel().getCastle(), new CastleViewer());
        drawElements(gui, getModel().getEnemies(), new EnemyViewer());
        drawElements(gui, getModel().getGrass(), new GrassViewer());
        drawElements(gui, getModel().getPath(), new PathViewer());
        drawElements(gui, getModel().getSea(), new SeaViewer());
        drawElements(gui, getModel().getTowers(), new TowerViewer());
        drawElement(gui, getModel().getTowerShop(), new TowerShopViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}

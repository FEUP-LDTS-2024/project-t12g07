package com.towerdefense.viewer.game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}

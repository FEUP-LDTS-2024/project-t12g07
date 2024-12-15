package com.towerdefense.gui;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Castle;
import com.towerdefense.model.game.elements.Grass;
import com.towerdefense.model.game.elements.Path;
import com.towerdefense.model.game.elements.Sea;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawTower(Position position, Tower tower);

    void drawCastle(Position position, Castle castle);

    void drawEnemy(Position position, Enemy enemy);

    void drawPath(Position position, Path path);

    void drawGrass(Position position, Grass grass);

    void drawSea(Position position, Sea sea);

    void drawText(Position position, String text, String color);

    enum ACTION {UP, RIGHT, DOWN, LEFT, TOWER_SELECT, QUIT, SELECT, NONE}

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}

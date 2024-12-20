package com.towerdefense.gui;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.*;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawTower(Position position, Tower tower);

    void drawCastle(Position position, Castle castle);

    void drawEnemy(Position position, Enemy enemy);

    void drawTowerShop(Position position, TowerShop towerShop);

    void drawPath(Position position, Path path);

    void drawGrass(Position position, Grass grass);

    void drawSea(Position position, Sea sea);

    void drawText(Position position, String text, String color);

    void drawCursor(Position position, Cursor cursor);

    enum ACTION {UP, RIGHT, DOWN, LEFT, TOWER_SELECT, QUIT, SELECT, NONE}

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}

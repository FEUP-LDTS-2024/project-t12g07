package com.towerdefense.gui;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawTower(Position position);

    void drawProjectiles(Position position, Window window);

    void drawCastle(Position position);

    void drawEnemy(Position position);

    void drawPath(Position position);

    void drawGrass(Position position);

    void drawOcean(Position position);

    void drawText(Position position, String text, String color);

    enum ACTION {UP, RIGHT, DOWN, LEFT, TOWER_SELECT, QUIT, SELECT}

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}

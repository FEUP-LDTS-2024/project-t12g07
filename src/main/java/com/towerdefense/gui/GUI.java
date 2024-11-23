package com.towerdefense.gui;

import java.io.IOException;

public interface GUI {
    void drawTower(Position position);

    void drawProjectiles(Position position, Window window);

    void drawCastle(Position position);

    void drawEnemy(Position position);

    void drawPath(Position position);

    void drawGrass(Position position);

    void drawOcean(Position position);

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;
}

package com.towerdefense.model.game.elements;

import com.towerdefense.model.Position;

import java.util.ArrayList;
import java.util.List;

public class Path extends Element {
    String[] pathArt;
    public Path(int x, int y) {
        super(x, y);
        this.pathArt = new String[] {
                "█ ░ █ ",
                "░ █ ░ ",
                "█ ░ █ ",
                "░ █ ░ ",
                "█ ░ █ "

        };
    }
    public String[] getPathArt() {
        return pathArt;
    }
}

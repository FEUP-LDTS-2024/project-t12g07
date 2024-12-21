package com.towerdefense.model.game.elements;

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

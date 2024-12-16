package com.towerdefense.model.game.elements;

public class Path extends Element {
    String[] pathArt;
    public Path(int x, int y) {
        super(x, y);
        this.pathArt = new String[] {
                "                T~~",
                "               |",
                "              /\"\\",
                "      T~~     |'| T~~",
                "  T~~ |    T~ WWWW|",
                "  |  /\"\\   |  |  |/\\T~~",
                " /\"\\ WWW  /\"\\ |' |WW|",
                "WWWWW/\\| /   \\|'/\\|/\"\\",
                "|   /__\\/]WWW[\\/__\\WWWW",
                "|\"  WWWW'|I_I|'WWWW'  |",
                "|   |' |/  -  \\|' |'  |",
                "|'  |  |LI=H=LI|' |   |",
                "|   |' | |[_]| |  |'  |",
                "|   |  |_|###|_|  |   |",
                "'---'--'-/___\\-'--'---'"
        };
    }
    public String[] getPathArt() {
        return pathArt;
    }
}

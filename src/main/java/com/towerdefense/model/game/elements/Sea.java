package com.towerdefense.model.game.elements;

public class Sea extends Element {
    String[] seaArt;
    public Sea(int x, int y) {
        super(x, y);
        this.seaArt = new String[] {
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

    public String[] getSeaArt() {
        return seaArt;}
}

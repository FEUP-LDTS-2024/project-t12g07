package com.towerdefense.model.game.elements;

public class Castle extends Element {
    private int gemstones;
    String[] castleArt;
    static public final int FULL_VAULT = 1000;
    public Castle(int x, int y) {
        super(x, y);
        this.gemstones = FULL_VAULT;
        this.castleArt = new String[] {
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

    public int getWealth() {
        return gemstones;
    }

    public String[] getCastleArt() {
        return castleArt;
    }
}
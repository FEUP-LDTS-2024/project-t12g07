package com.towerdefense.model.game.elements.enemies;
import com.googlecode.lanterna.TextColor;

public class Giant extends Enemy {

    public Giant(int x, int y) {
        super(x, y);
        this.health = 150;
        this.reward = 50;
        this.sacking = 100;
        this.enemyArt = new String[]{
                "   ┐ ┌",
                "   (0)",
                "  _/v\\",
                " //   \\\\",
                "\\ \\_ _/ /",
                "  // \\\\",
                "└──   ──┘"
        };
    }
}
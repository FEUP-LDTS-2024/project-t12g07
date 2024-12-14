package com.towerdefense.model.game.board;

import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.towers.Tower;

import java.util.List;

public abstract class BoardBuilder {
    public Board createArena() {
        Board board = new Board(getWidth(), getHeight());

        return board;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

}
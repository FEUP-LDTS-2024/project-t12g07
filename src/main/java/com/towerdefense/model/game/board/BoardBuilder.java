package com.towerdefense.model.game.board;

public abstract class BoardBuilder {
    public Board createArena() {
        Board board = new Board(getWidth(), getHeight());

        return board;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

}
package com.towerdefense.model.game.board;

import com.towerdefense.model.game.elements.Grass;
import com.towerdefense.model.game.elements.Path;
import com.towerdefense.model.game.elements.Sea;

import java.util.List;

public abstract class BoardBuilder {
    public Board createBoard() {
        Board board = new Board(getWidth(), getHeight());

        return board;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Grass> createGrass();

    protected abstract List<Sea> createSea();

    protected abstract List<Path> createPath();
}
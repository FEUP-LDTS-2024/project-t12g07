package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Cursor;
import com.towerdefense.model.game.board.Board;

public class CursorController extends GameController {

    public CursorController(Board board) {
        super(board);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                moveCursor(0, -2);
                break;
            case DOWN:
                moveCursor(0, 2);
                break;
            case LEFT:
                moveCursor(-3, 0);
                break;
            case RIGHT:
                moveCursor(3, 0);
                break;
            default:
                break;
        }
    }

    private void moveCursor(int deltaX, int deltaY) {
        int newX = getModel().getCursor().getPosition().getX() + deltaX;
        int newY = getModel().getCursor().getPosition().getY() + deltaY;

        // Check boundaries to keep cursor within the board
        if (newX >= 0 && newX < getModel().getWidth() && newY >= 0 && newY < getModel().getHeight()) {
            Position newpos = new Position(newX,newY);
            getModel().getCursor().setPosition(newpos);
        }
    }
}
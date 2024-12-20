package com.towerdefense.controllers.game;
import com.towerdefense.controllers.Controller;
import com.towerdefense.model.game.board.Board;

public abstract class GameController extends Controller<Board> {
    public GameController(Board board) {
        super(board);
    }
}

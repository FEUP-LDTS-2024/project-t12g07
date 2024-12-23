package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.game.BoardController;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.game.GameViewer;

public class GameState extends State<Board> {
    public GameState(Board board) {
        super(board);
    }

    @Override
    protected Viewer<Board> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Board> getController() {
        return new BoardController(getModel());
    }
}

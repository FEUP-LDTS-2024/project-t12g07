package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.game.BoardController;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameStateTest {
    private GameState gameState;
    private Board boardModel;

    @BeforeEach
    public void setUp() {
        boardModel = new Board(30,20);
        gameState = new GameState(boardModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<Board> viewer = gameState.getViewer();
        assertNotNull(viewer, "The viewer should not be null");
        assertTrue(viewer instanceof GameViewer, "The viewer should be an instance of GameViewer");
    }

    @Test
    public void testGetController() {
        Controller<Board> controller = gameState.getController();
        assertNotNull(controller, "The controller should not be null");
        assertTrue(controller instanceof BoardController, "The controller should be an instance of BoardController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(gameState.getModel(), "The model should not be null");
        assertTrue(gameState.getModel() instanceof Board, "The model should be an instance of Board");
    }
}

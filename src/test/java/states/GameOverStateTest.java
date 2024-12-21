package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.GameOverController;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOverStateTest {
    private GameOverState gameOverState;
    private GameOver gameOverModel;

    @BeforeEach
    public void setUp() {
        gameOverModel = new GameOver();
        gameOverState = new GameOverState(gameOverModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<GameOver> viewer = gameOverState.getViewer();
        assertNotNull(viewer, "Viewer must not be null");
        assertTrue(viewer instanceof GameOverViewer, "Viewer must be an instance of GameOverViewer");
    }

    @Test
    public void testGetController() {
        Controller<GameOver> controller = gameOverState.getController();
        assertNotNull(controller, "Controller must not be null");
        assertTrue(controller instanceof GameOverController, "Controller must be an instance of GameOverController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(gameOverState.getModel(), "Model must not be null");
        assertTrue(gameOverState.getModel() instanceof GameOver, "Model must be an instance of GameOver");
    }
}

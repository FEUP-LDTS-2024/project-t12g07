package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.GameOverController;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.GameOverViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverStateTest {
    private GameOverState gameOverState;

    @BeforeEach
    public void setUp() {
        GameOver gameOverModel = new GameOver();
        gameOverState = new GameOverState(gameOverModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<GameOver> viewer = gameOverState.getViewer();
        assertNotNull(viewer, "Viewer must not be null");
        assertInstanceOf(GameOverViewer.class, viewer, "Viewer must be an instance of GameOverViewer");
    }

    @Test
    public void testGetController() {
        Controller<GameOver> controller = gameOverState.getController();
        assertNotNull(controller, "Controller must not be null");
        assertInstanceOf(GameOverController.class, controller, "Controller must be an instance of GameOverController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(gameOverState.getModel(), "Model must not be null");
        assertNotNull(gameOverState.getModel(), "Model must be an instance of GameOver");
    }
}

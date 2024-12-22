package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.VictoryController;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.VictoryViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VictoryStateTest {
    private VictoryState victoryState;
    private Victory victoryModel;

    @BeforeEach
    public void setUp() {
        victoryModel = new Victory();
        victoryState = new VictoryState(victoryModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<Victory> viewer = victoryState.getViewer();
        assertNotNull(viewer, "Viewer must not be null");
        assertTrue(viewer instanceof VictoryViewer, "Viewer must be an instance of VictoryViewer");
    }

    @Test
    public void testGetController() {
        Controller<Victory> controller = victoryState.getController();
        assertNotNull(controller, "Controller must not be null");
        assertTrue(controller instanceof VictoryController, "Controller must be an instance of VictoryController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(victoryState.getModel(), "Model must not be null");
        assertTrue(victoryState.getModel() instanceof Victory, "Model must be an instance of Victory");
    }
}

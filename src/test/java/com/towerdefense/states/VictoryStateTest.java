package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.VictoryController;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.VictoryViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VictoryStateTest {
    private VictoryState victoryState;

    @BeforeEach
    public void setUp() {
        Victory victoryModel = new Victory();
        victoryState = new VictoryState(victoryModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<Victory> viewer = victoryState.getViewer();
        assertNotNull(viewer, "Viewer must not be null");
        assertInstanceOf(VictoryViewer.class, viewer, "Viewer must be an instance of VictoryViewer");
    }

    @Test
    public void testGetController() {
        Controller<Victory> controller = victoryState.getController();
        assertNotNull(controller, "Controller must not be null");
        assertInstanceOf(VictoryController.class, controller, "Controller must be an instance of VictoryController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(victoryState.getModel(), "Model must not be null");
        assertInstanceOf(Victory.class, victoryState.getModel(), "Model must be an instance of Victory");
    }
}

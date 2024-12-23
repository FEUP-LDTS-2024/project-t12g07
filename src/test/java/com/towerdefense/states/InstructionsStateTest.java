package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.InstructionsController;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.InstructionsViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InstructionsStateTest {
    private InstructionsState instructionsState;

    @BeforeEach
    public void setUp() {
        Instructions instructionsModel = new Instructions();
        instructionsState = new InstructionsState(instructionsModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<Instructions> viewer = instructionsState.getViewer();
        assertNotNull(viewer, "The viewer should not be null");
        assertInstanceOf(InstructionsViewer.class, viewer, "The viewer should be an instance of InstructionsViewer");
    }

    @Test
    public void testGetController() {
        Controller<Instructions> controller = instructionsState.getController();
        assertNotNull(controller, "The controller should not be null");
        assertInstanceOf(InstructionsController.class, controller, "The controller should be an instance of InstructionsController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(instructionsState.getModel(), "The model should not be null");
        assertInstanceOf(Instructions.class, instructionsState.getModel(), "The model should be an instance of Instructions");
    }
}

package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.MenuController;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuStateTest {
    private MenuState menuState;
    private Menu menuModel;

    @BeforeEach
    public void setUp() {
        menuModel = new Menu();
        menuState = new MenuState(menuModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<Menu> viewer = menuState.getViewer();
        assertNotNull(viewer, "The viewer should not be null");
        assertTrue(viewer instanceof MenuViewer, "The viewer should be an instance of MenuViewer");
    }

    @Test
    public void testGetController() {
        Controller<Menu> controller = menuState.getController();
        assertNotNull(controller, "The controller should not be null");
        assertTrue(controller instanceof MenuController, "The controller should be an instance of MenuController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(menuState.getModel(), "The model should not be null");
        assertTrue(menuState.getModel() instanceof Menu, "The model should be an instance of Menu");
    }
}

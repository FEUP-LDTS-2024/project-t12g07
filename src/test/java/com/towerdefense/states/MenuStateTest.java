package com.towerdefense.states;

import com.towerdefense.controllers.Controller;
import com.towerdefense.controllers.menu.MenuController;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.viewer.Viewer;
import com.towerdefense.viewer.menu.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MenuStateTest {
    private MenuState menuState;

    @BeforeEach
    public void setUp() {
        Menu menuModel = new Menu();
        menuState = new MenuState(menuModel);
    }

    @Test
    public void testGetViewer() {
        Viewer<Menu> viewer = menuState.getViewer();
        assertNotNull(viewer, "The viewer should not be null");
        assertInstanceOf(MenuViewer.class, viewer, "The viewer should be an instance of MenuViewer");
    }

    @Test
    public void testGetController() {
        Controller<Menu> controller = menuState.getController();
        assertNotNull(controller, "The controller should not be null");
        assertInstanceOf(MenuController.class, controller, "The controller should be an instance of MenuController");
    }

    @Test
    public void testModelInitialization() {
        assertNotNull(menuState.getModel(), "The model should not be null");
        assertInstanceOf(Menu.class, menuState.getModel(), "The model should be an instance of Menu");
    }
}

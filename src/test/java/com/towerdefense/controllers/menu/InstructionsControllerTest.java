package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.controllers.menu.InstructionsController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.Instructions;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InstructionsControllerTest {
    @Mock
    private Game game;

    @Mock
    private Instructions instructions;
    private InstructionsController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new InstructionsController(instructions);
    }

    @Test
    void testStepWithQuitAction() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 1000L);
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void testStepWithNonQuitAction() throws IOException {
        controller.step(game, GUI.ACTION.UP, 1000L);
        verify(game, never()).setState(any());
    }

    @Test
    void testGetModel() {
        assertSame(instructions, controller.getModel());
    }

    @Test
    void testMultipleSteps() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 1000L);
        controller.step(game, GUI.ACTION.UP, 1000L);
        controller.step(game, GUI.ACTION.QUIT, 1000L);

        verify(game, times(1)).setState(any(MenuState.class));
    }

    @Test
    void testStepWithNullAction() throws IOException {
        controller.step(game, null, 1000L);
        verify(game, never()).setState(any());
    }

    @Test
    void testMenuStateCreatedWithNewMenu() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 1000L);
        verify(game).setState(argThat(state -> state instanceof MenuState && ((MenuState) state).getModel() != null));
    }
}

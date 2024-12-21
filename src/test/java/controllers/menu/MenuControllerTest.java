package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.states.GameState;
import com.towerdefense.states.InstructionsState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuControllerTest {
    @Mock
    private Game game;

    @Mock
    private Menu menu;
    private MenuController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new MenuController(menu);
    }

    @Test
    void testUpAction() throws IOException {
        controller.step(game, GUI.ACTION.UP, 0);
        verify(menu).previousEntry();
    }

    @Test
    void testDownAction() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, 0);
        verify(menu).nextEntry();
    }

    @Test
    void testSelectActionExit() throws IOException {
        when(menu.isSelectedExit()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(null);
    }

    @Test
    void testSelectActionStart() throws IOException {
        when(menu.isSelectedStart()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(any(GameState.class));
    }

    @Test
    void testSelectActionInstructions() throws IOException {
        when(menu.isSelectedInstructions()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, 0);
        verify(game).setState(any(InstructionsState.class));
    }

    @Test
    void testNonSelectAction() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, 0);
        verify(game, never()).setState(any());
    }

    @Test
    void testMultipleActions() throws IOException {
        controller.step(game, GUI.ACTION.UP, 0);
        controller.step(game, GUI.ACTION.DOWN, 0);
        controller.step(game, GUI.ACTION.UP, 0);

        verify(menu, times(2)).previousEntry();
        verify(menu, times(1)).nextEntry();
    }
}

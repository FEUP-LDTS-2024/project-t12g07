package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.controllers.menu.MenuController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.board.LoaderBoardBuilder;
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
    private Game game;
    private Menu menu;
    private MenuController controller;

    @BeforeEach
    void setUp() {
        menu = mock(Menu.class);
        game = mock(Game.class);
        controller = new MenuController(menu);
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUpAction() throws IOException {
        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        verify(menu).previousEntry();
        verifyNoMoreInteractions(menu);
    }

    @Test
    void testDownAction() throws IOException {
        controller.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        verify(menu).nextEntry();
        verifyNoMoreInteractions(menu);
    }

    @Test
    void testSelectActionExit() throws IOException {
        when(menu.isSelectedExit()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game).setState(null);
        verify(menu).isSelectedExit();
    }

    @Test
    void testSelectActionStart() throws IOException {
        when(menu.isSelectedStart()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game).setState(any(GameState.class));
        verify(menu, times(1)).isSelectedStart();
    }

    @Test
    void testSelectActionInstructions() throws IOException {
        when(menu.isSelectedInstructions()).thenReturn(true);
        controller.step(game, GUI.ACTION.SELECT, System.currentTimeMillis());
        verify(game).setState(any(InstructionsState.class));
    }

    @Test
    void testNonSelectAction() throws IOException {
        controller.step(game, GUI.ACTION.QUIT, System.currentTimeMillis());
        verify(game, never()).setState(any());
    }

    @Test
    void testMultipleActions() throws IOException {
        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());
        controller.step(game, GUI.ACTION.DOWN, System.currentTimeMillis());
        controller.step(game, GUI.ACTION.UP, System.currentTimeMillis());

        verify(menu, times(2)).previousEntry();
        verify(menu, times(1)).nextEntry();
    }
}

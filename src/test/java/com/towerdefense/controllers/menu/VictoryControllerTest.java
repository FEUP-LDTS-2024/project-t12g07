package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.Menu;
import com.towerdefense.model.menu.Victory;
import com.towerdefense.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VictoryControllerTest {
    private VictoryController victoryController;
    private Game game;

    @BeforeEach
    void setUp() {
        Victory victory = new Victory();
        victoryController = new VictoryController(victory);
        game = mock(Game.class);
    }

    @Test
    void testStepWithQuitAction() throws IOException {
        victoryController.step(game, GUI.ACTION.QUIT, 0);

        verify(game).setState(any(MenuState.class));
    }

    @Test
    void testStepWithOtherAction() throws IOException {
        Game originalGame = game;
        victoryController.step(game, GUI.ACTION.UP, 0);
        assertEquals(originalGame, game);
    }
}

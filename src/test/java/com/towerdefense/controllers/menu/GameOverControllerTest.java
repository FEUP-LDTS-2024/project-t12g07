package com.towerdefense.controllers.menu;

import com.towerdefense.Game;
import com.towerdefense.controllers.menu.GameOverController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.menu.GameOver;
import com.towerdefense.states.MenuState;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

class GameOverControllerTest {
    @Test
    void step_WithQuitAction_ShouldSetMenuStateInGame() throws Exception {
        Game game = mock(Game.class);
        GUI.ACTION action = GUI.ACTION.QUIT;
        GameOverController gameOverController = new GameOverController(new GameOver());
        gameOverController.step(game, action, System.currentTimeMillis());
        verify(game).setState(any(MenuState.class));
    }

    @Test
    void step_WithNonQuitAction_ShouldNotSetMenuStateInGame() throws Exception {
        Game game = mock(Game.class);
        GUI.ACTION action = GUI.ACTION.UP;
        GameOverController gameOverController = new GameOverController(new GameOver());
        gameOverController.step(game, action, System.currentTimeMillis());
        verify(game, never()).setState(any(MenuState.class));
    }
}

package controllers.game;

import com.towerdefense.Game;
import com.towerdefense.controllers.game.BoardController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Castle;
import com.towerdefense.states.GameOverState;
import com.towerdefense.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class BoardControllerTest {
    @Mock
    private Board board;

    @Mock
    private Castle castle;

    @Mock
    private Game game;

    private BoardController boardController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        when(board.getCastle()).thenReturn(castle);
        boardController = new BoardController(board);
    }

    @Test
    void testConstructor() {
        assertNotNull(boardController);
    }

    @Test
    void testStepWithQuitAction() throws Exception {
        GUI.ACTION action = GUI.ACTION.QUIT;
        long time = System.currentTimeMillis();

        boardController.step(game, action, time);

        verify(game).setState(any(MenuState.class));
    }

    @Test
    void testStepWithGameOver() throws Exception {
        GUI.ACTION action = GUI.ACTION.UP;
        long time = System.currentTimeMillis();

        when(castle.getWealth()).thenReturn(0);

        boardController.step(game, action, time);

        verify(game).setState(any(GameOverState.class));
    }

    @Test
    void testStepWithNormalGameplay() throws Exception {
        GUI.ACTION action = GUI.ACTION.UP;
        long time = System.currentTimeMillis();

        when(castle.getWealth()).thenReturn(100);

        boardController.step(game, action, time);
    }
}

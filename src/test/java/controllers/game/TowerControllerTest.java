package controllers.game;

import com.towerdefense.Game;
import com.towerdefense.controllers.game.TowerController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.towers.Tower;
import com.towerdefense.model.game.elements.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TowerControllerTest {
    private Board board;
    private TowerController towerController;
    private List<Tower> towers;
    private List<Enemy> enemies;

    @BeforeEach
    void setUp() {
        board = mock(Board.class);
        towers = new ArrayList<>();
        enemies = new ArrayList<>();
        when(board.getTowers()).thenReturn(towers);
        when(board.getEnemies()).thenReturn(enemies);
        towerController = new TowerController(board);
    }

    @Test
    void testStepWithTowers() throws IOException {
        Tower tower = mock(Tower.class);
        towers.add(tower);

        towerController.step(mock(Game.class), GUI.ACTION.NONE, System.currentTimeMillis() + 200);

        verify(tower, times(1)).update(enemies);
    }

    @Test
    void testStepNoTowers() throws IOException {
        towerController.step(mock(Game.class), GUI.ACTION.NONE, System.currentTimeMillis() + 200);

        verifyNoInteractions(board); // No interactions with towers if there are none
    }

    @Test
    void testGetTowerList() {
        assertTrue(towerController.getTowerList().isEmpty());
    }
}
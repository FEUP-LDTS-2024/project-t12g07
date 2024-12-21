package controllers.game;

import com.towerdefense.Game;
import com.towerdefense.controllers.game.EnemyController;
import com.towerdefense.gui.GUI;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Warning;
import com.towerdefense.model.game.elements.Wave;
import com.towerdefense.model.game.elements.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnemyControllerTest {
    private Board board;
    private EnemyController enemyController;
    private Game mockGame;

    @BeforeEach
    void setup() {
        board = mock(Board.class);
        mockGame = mock(Game.class);
        enemyController = new EnemyController(board);
    }

    @Test
    void testInitialization() {
        assertNotNull(enemyController, "EnemyController should be initialized.");
        assertTrue(enemyController.getModel().getEnemies().isEmpty(), "Enemies list should initially be empty.");
    }


    @Test
    void testMoveEnemiesRemovesDeadEnemies() {
        Enemy mockEnemy1 = mock(Enemy.class);
        Enemy mockEnemy2 = mock(Enemy.class);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy1);
        enemies.add(mockEnemy2);

        enemyController.getModel().setEnemies(enemies);

        when(mockEnemy1.isDead()).thenReturn(true);
        when(mockEnemy2.isDead()).thenReturn(false);

        enemyController.moveEnemies();

        assertEquals(1, enemyController.getModel().getEnemies().size(), "Only one enemy should remain after moving enemies.");
        assertFalse(enemyController.getModel().getEnemies().contains(mockEnemy1), "Dead enemy should be removed.");
    }

    @Test
    void testMoveEnemiesReducesCastleHealth() {
        Enemy mockEnemy = mock(Enemy.class);
        List<Enemy> enemies = new ArrayList<>();
        enemies.add(mockEnemy);

        enemyController.getModel().setEnemies(enemies);

        // Mock Position
        Position mockPosition = mock(Position.class);
        when(mockPosition.getX()).thenReturn(90);
        when(mockPosition.getY()).thenReturn(30);
        when(mockEnemy.getPosition()).thenReturn(mockPosition);

        // Call moveEnemies
        enemyController.moveEnemies();

        // Verify castle stealing
        verify(enemyController.getModel().getCastle(), times(1)).stealing(anyInt());
        assertTrue(enemyController.getModel().getEnemies().isEmpty(), "Enemy should be removed after reaching the castle.");
    }

}



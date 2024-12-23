package com.towerdefense.controllers.game;

import com.towerdefense.Game;
import com.towerdefense.controllers.game.EnemyController;
import com.towerdefense.model.Position;
import com.towerdefense.model.game.board.Board;
import com.towerdefense.model.game.elements.Castle;
import com.towerdefense.model.game.elements.enemies.Enemy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EnemyControllerTest {
    private Board mockBoard;
    private EnemyController enemyController;
    private Castle mockCastle;

    @BeforeEach
    void setup() {
        mockBoard = mock(Board.class);
        mockCastle = mock(Castle.class);
        when(mockBoard.getCastle()).thenReturn(mockCastle);

        enemyController = new EnemyController(mockBoard);
    }

    @Test
    void testInitialization() {
        assertNotNull(enemyController, "EnemyController should be initialized.");
        assertTrue(enemyController.getModel().getEnemies().isEmpty(), "Enemies list should initially be empty.");
    }

    @Test
    void testNoEnemiesDoesNotCauseErrors() {
        List<Enemy> emptyList = new ArrayList<>();
        enemyController.getModel().setEnemies(emptyList);

        assertDoesNotThrow(() -> enemyController.moveEnemies(), "Moving enemies with an empty list should not throw exceptions.");
    }
}

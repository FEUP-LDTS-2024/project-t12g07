package com.towerdefense.model.game.elements;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.enemies.Goblin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EnemyTest {
    private Enemy goblin;
    private Path mockPath;

    @BeforeEach
    public void setUp() {
        Enemy goblin = new Goblin(20, 30);
        mockPath = mock(Path.class);
    }

    @Test
    public void testEnemyMovement() {
        when(mockPath.getNextPosition(20, 30)).thenReturn(new Position(20, 40));

        goblin.move(mockPath);

        assertEquals(20, goblin.getPosition().getX());
        assertEquals(40, goblin.getPosition().getY());
        verify(mockPath, times(1)).getNextPosition(20, 30);
    }

    @Test
    public void testEnemyTakesDamage() {
        goblin.takeDamage(30);
        assertEquals(70, goblin.getHealth()); //goblin tem 100 de vida
        assertFalse(goblin.isDead());
    }

    @Test
    public void testEnemyDiesWhenHealthReachesZero() {
        goblin.takeDamage(100);
        assertTrue(goblin.isDead());
        assertEquals(0, goblin.getHealth());
    }
}

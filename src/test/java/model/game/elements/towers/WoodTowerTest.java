package model.game.elements.towers;

import com.towerdefense.model.game.elements.towers.WoodTower;
import com.towerdefense.model.game.elements.towers.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.Position;

import java.util.ArrayList;
import java.util.List;

class WoodTowerTest {
    private Tower tower;
    private List<Enemy> enemies;

    @BeforeEach
    void setUp() {
        tower = new WoodTower(5, 5);
        enemies = new ArrayList<>();
    }

    @Test
    void testConstructor() {
        assertEquals(5, tower.getPosition().getX());
        assertEquals(5, tower.getPosition().getY());
        assertEquals(10, tower.getRange());
    }

    @Test
    void testGetDamage() {
        assertEquals(5, tower.getDamage());
    }

    @Test
    void testGetCost() {
        assertEquals(10, tower.getCost());
    }

    @Test
    void testUpdateWithNoEnemies() {
        tower.update(enemies);
        assertTrue(enemies.isEmpty());
    }

    @Test
    void testUpdateWithEnemyInRange() {
        Enemy enemy = mock(Enemy.class);
        when(enemy.getPosition()).thenReturn(new Position(6, 6));
        enemies.add(enemy);

        tower.update(enemies);

        verify(enemy).takeDamage(anyInt());
    }

    @Test
    void testUpdateWithEnemyOutOfRange() {
        Enemy enemy = mock(Enemy.class);
        when(enemy.getPosition()).thenReturn(new Position(20, 20));
        enemies.add(enemy);

        tower.update(enemies);

        verify(enemy, never()).takeDamage(anyInt());
    }
}

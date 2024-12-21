package model.game.elements.enemies;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.enemies.Giant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiantTest {
    private Enemy enemy;

    @BeforeEach
    void setUp() {
        enemy = new Giant(0, 25);
    }

    @Test
    void testInitialPosition() {
        Position initialPosition = enemy.getPosition();
        assertEquals(0, initialPosition.getX());
        assertEquals(25, initialPosition.getY());
    }

    @Test
    void testColorInitialization() {
        String color = enemy.getColor();
        assertNotNull(color);
        assertTrue(color.equals("#ff0000") || color.equals("#ab1313") || color.equals("#801818"));
    }

    @Test
    void testMoveEnemy() {
        enemy.moveEnemy();
        Position newPosition = enemy.getPosition();
        assertEquals(6, newPosition.getX());
        assertEquals(25, newPosition.getY());
    }

    @Test
    void testTakeDamage() {
        int initialHealth = enemy.getHealth();
        enemy.takeDamage(50);
        assertEquals(initialHealth - 50, enemy.getHealth());
        assertFalse(enemy.isDead());

        enemy.takeDamage(100);
        assertTrue(enemy.isDead());
    }

    @Test
    void testEnemyFollowsPath() {
        Enemy enemy = new Giant(-42, 25);
        for (int i = 0; i < 10; i++) {
            enemy.moveEnemy();
        }
        Position position = enemy.getPosition();
        assertEquals(12, position.getX());
        assertEquals(20, position.getY());
    }

    @Test
    void testEnemyDies() {
        Enemy enemy = new Giant(0, 25);
        enemy.takeDamage(100);
        assertFalse(enemy.isDead());
        enemy.takeDamage(50);
        assertTrue(enemy.isDead());
    }

    @Test
    void testReward() {
        assertEquals(50, enemy.getReward());
    }

    @Test
    void testSacking() {
        assertEquals(100, enemy.getSacking());
    }

    @Test
    void testPathInitialization() {
        Enemy enemy = new Giant(-42, 25);

        assertEquals(-42, enemy.getPosition().getX());
        assertEquals(25, enemy.getPosition().getY());

        for (int i = 0; i < 8; i++) {
            enemy.moveEnemy();
        }
        assertEquals(6, enemy.getPosition().getX());
        assertEquals(25, enemy.getPosition().getY());

        for (int i = 0; i < 5; i++) {
            enemy.moveEnemy();
        }
        assertEquals(18, enemy.getPosition().getX());
        assertEquals(5, enemy.getPosition().getY());

        for (int i = 0; i < 30; i++) {
            enemy.moveEnemy();
        }
        assertEquals(90, enemy.getPosition().getX());
        assertEquals(30, enemy.getPosition().getY());
    }
}

package com.towerdefense.model.game.elements;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EnemyTest {
    @Test
    void testEnemyMovement() {
        Thief thief = new Thief(5, 5); // posição
        Position start = new Position(0, 0);

        assertEquals(5, thief.getPosition().getX());
        assertEquals(5, thief.getPosition().getY());
    }

    @Test
    void testEnemyHealthReduction() {
        Enemy goblin = new Goblin(100, 5); // Health: 100
        goblin.takeDamage(30);

        assertEquals(70, goblin.getHealth());
    }
}

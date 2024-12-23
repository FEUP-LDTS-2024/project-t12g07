package com.towerdefense.model.game.elements;

import com.towerdefense.model.game.elements.Wave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.enemies.Goblin;
import com.towerdefense.model.game.elements.enemies.Knight;
import com.towerdefense.model.game.elements.enemies.Giant;

import java.util.List;

class WaveTest {
    private Wave wave;

    @BeforeEach
    void setUp() {
        wave = new Wave(0, 0);
    }

    @Test
    void testConstructor() {
        assertEquals(0, wave.getWave());
        assertTrue(wave.getEnemyList().isEmpty());
    }

    @Test
    void testSpawnWave1() {
        List<Enemy> enemies = wave.spawn(1);
        assertEquals(4, enemies.size());
        assertTrue(enemies.stream().allMatch(e -> e instanceof Goblin));
    }

    @Test
    void testSpawnWave2() {
        List<Enemy> enemies = wave.spawn(2);
        assertEquals(4, enemies.size());
        assertTrue(enemies.stream().allMatch(e -> e instanceof Knight));
    }

    @Test
    void testSpawnWave3() {
        List<Enemy> enemies = wave.spawn(3);
        assertEquals(4, enemies.size());
        assertTrue(enemies.stream().allMatch(e -> e instanceof Giant));
    }

    @Test
    void testSpawnWave4AndBeyond() {
        List<Enemy> enemies = wave.spawn(4);
        assertEquals(4, enemies.size());
        assertTrue(enemies.stream().allMatch(e -> e instanceof Goblin || e instanceof Knight || e instanceof Giant));
    }

    @Test
    void testUpdateWave() {
        assertEquals(0, wave.getWave());
        wave.updateWave();
        assertEquals(1, wave.getWave());
        wave.updateWave();
        assertEquals(2, wave.getWave());
    }

    @Test
    void testGetEnemyList() {
        assertTrue(wave.getEnemyList().isEmpty());
        wave.spawn(1);
        assertFalse(wave.getEnemyList().isEmpty());
        assertEquals(4, wave.getEnemyList().size());
    }
}

package com.towerdefense.model.game.elements;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.towerdefense.model.game.elements.*;
import com.towerdefense.model.game.elements.enemies.Enemy;
import com.towerdefense.model.game.elements.enemies.Giant;
import com.towerdefense.model.game.elements.towers.MetalTower;
import com.towerdefense.model.game.elements.towers.StoneTower;
import com.towerdefense.model.game.elements.towers.Tower;
import com.towerdefense.model.game.elements.towers.WoodTower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;

public class TowerTest {

    private Tower woodTower;
    private Tower stoneTower;
    private Tower metalTower;

    @Mock
    private Enemy mockEnemy;

    @BeforeEach
    void setup(){
        Enemy giant = new Giant(35, 50);
        woodTower = new WoodTower(50, 50); //torre é criada com uma posição
        stoneTower = new StoneTower(40, 35);
        metalTower = new MetalTower(30, 60);
        mockEnemy = mock(Enemy.class);
        tower.setArrows(Arrays.asList(new Arrow(woodTower.get)))
    }

    @Test
    void testTowerAttributes() {
        assertEquals(50, woodTower.getDamage());
        assertEquals(100, stoneTower.getTowerDamage());
        assertEquals(150, metalTower.getTowerDamage());

        assertEquals(3, woodTower.getRange()); //range igual para todas as torres
    }

    @Test
    void testTowerAttack() {
        Tower woodTower = new WoodTower();
        Enemy goblin = new Goblin(100, 5); //goblin tem 100 de vida
        woodTower.attack(goblin);
        assertEquals(50, goblin.getHealth());
    }
}
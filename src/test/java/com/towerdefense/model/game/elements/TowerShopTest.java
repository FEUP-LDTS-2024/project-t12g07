package com.towerdefense.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TowerShopTest {
    private TowerShopTest towerShop;

    @BeforeEach
    public void setUp() {
        towerShop = new TowerShopTest(20)// Começa com 100 coins
    }

    @Test
    public void testAddMoney() {
        towerShop.addMoney(50);
        assertEquals(150, towerShop.getMoney());
    }

    @Test
    public void testBuyTowerWithSufficientCoins() {
        Tower woodTower = new WoodTower(); // custo da wood tower é 10
        Tower purchasedTower = towerShop.buyTower(woodTower);
        assertNotNull(purchasedTower);
        assertEquals(10, towerShop.getCoin());
    }

    @Test
    public void testBuyTowerWithInsufficientCoins() {
        Tower metalTower = new MetalTower();// custa 30
        Tower purchasedTower = towerShop.buyTower(metalTower);
        assertNull(purchasedTower); // torre não foi comprada
        assertEquals(20, towerShop.getCoin());
    }
}

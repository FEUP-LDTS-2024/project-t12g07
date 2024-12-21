package model.game.elements;

import com.towerdefense.model.game.elements.TowerShop;
import com.towerdefense.model.game.elements.towers.Tower;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

class TowerShopTest {
    private TowerShop towerShop;

    @BeforeEach
    void setUp() {
        towerShop = new TowerShop(0, 0);
    }

    @Test
    void testInitialMoney() {
        assertEquals(30, towerShop.getMoney());
    }

    @Test
    void testPurchaseTower() {
        Tower cheapTower = Mockito.mock(Tower.class);
        Mockito.when(cheapTower.getCost()).thenReturn(10);

        Tower expensiveTower = Mockito.mock(Tower.class);
        Mockito.when(expensiveTower.getCost()).thenReturn(40);

        assertTrue(towerShop.purchaseTower(cheapTower));
        assertEquals(20, towerShop.getMoney());

        assertFalse(towerShop.purchaseTower(expensiveTower));
        assertEquals(20, towerShop.getMoney());
    }

    @Test
    void testAddReward() {
        towerShop.addReward(15);
        assertEquals(45, towerShop.getMoney());
    }

    @Test
    void testNextEntry() {
        assertTrue(towerShop.isSelected1());

        towerShop.nextEntry();
        assertTrue(towerShop.isSelected2());

        towerShop.nextEntry();
        assertTrue(towerShop.isSelected3());

        towerShop.nextEntry();
        assertTrue(towerShop.isSelected1());
    }

    @Test
    void testGetEntry() {
        assertEquals("Wood Tower: 10€", towerShop.getEntry(0));
        assertEquals("Stone Tower: 20€", towerShop.getEntry(1));
        assertEquals("Metal Tower: 30€", towerShop.getEntry(2));
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(3, towerShop.getNumberEntries());
    }

    @Test
    void testGetTowerShopArt() {
        assertNotNull(towerShop.getTowerShopArt1());
        assertNotNull(towerShop.getTowerShopArt2());
        assertNotNull(towerShop.getTowerShopArt3());
        assertEquals(5, towerShop.getTowerShopArt1().length);
        assertEquals(5, towerShop.getTowerShopArt2().length);
        assertEquals(5, towerShop.getTowerShopArt3().length);
    }

    @Test
    void testGetSideBarArt() {
        assertNotNull(towerShop.getSideBarArt());
        assertEquals(40, towerShop.getSideBarArt().length);
    }
}

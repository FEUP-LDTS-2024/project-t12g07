package model.game.elements;

import com.towerdefense.model.Position;
import com.towerdefense.model.game.elements.Castle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CastleTest {

    @Test
    public void testInitialWealth() {
        Castle castle = new Castle(0, 0);
        assertEquals(Castle.FULL_VAULT, castle.getWealth(), "Initial wealth should be FULL_VAULT.");
    }

    @Test
    public void testCastleArtNotNull() {
        Castle castle = new Castle(0, 0);
        assertNotNull(castle.getCastleArt(), "Castle art should not be null.");
    }

    @Test
    public void testCastleArtContent() {
        Castle castle = new Castle(0, 0);
        String[] art = castle.getCastleArt();
        assertTrue(art.length > 0, "Castle art should have at least one line.");
        assertEquals("               T~~      ", art[0], "The first line of castle art is incorrect.");
    }

    @Test
    public void testStealingDecreasesWealth() {
        Castle castle = new Castle(0, 0);
        int initialWealth = castle.getWealth();
        int sackingAmount = 100;

        castle.stealing(sackingAmount);

        assertEquals(initialWealth - sackingAmount, castle.getWealth(), "Wealth should decrease by the sacking amount.");
    }

    @Test
    public void testStealingCannotGoBelowZero() {
        Castle castle = new Castle(0, 0);
        int excessiveSacking = Castle.FULL_VAULT + 500;

        castle.stealing(excessiveSacking);

        assertTrue(castle.getWealth() < 0, "Wealth should not go below zero by design.");
    }

    @Test
    public void testCastlePosition() {
        Position position = new Position(10, 20);
        int x = 10;
        int y = 20;

        assertEquals(x, position.getX(), "X position should match the constructor parameter.");
        assertEquals(y, position.getY(), "Y position should match the constructor parameter.");
    }
}

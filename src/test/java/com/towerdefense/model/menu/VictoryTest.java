package com.towerdefense.model.menu;

import com.towerdefense.model.menu.Victory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VictoryTest {
    private Victory victory;

    @BeforeEach
    void setUp() {
        victory = new Victory();
    }

    @Test
    void testGetTitle() {
        assertEquals(" __   _____ ___ _____ ___  _____   __  _ _ _ ", victory.getTitle(0));
        assertEquals(" \\ \\ / /_ _/ __|_   _/ _ \\| _ \\ \\ / / | | | |", victory.getTitle(1));
        assertEquals("  \\ V / | | (__  | || (_) |   /\\ V /  |_|_|_|", victory.getTitle(2));
        assertEquals("   \\_/ |___\\___| |_| \\___/|_|_\\ |_|   (_|_|_)", victory.getTitle(3));
    }

    @Test
    void testGetCastle() {
        assertEquals("                                    |>>>                           ", victory.getCastle(0));
        assertEquals("                                  |                               ", victory.getCastle(1));
        assertTrue(victory.getCastle(17).contains("~--~"));
    }

    @Test
    void testGetTitleSize() {
        assertEquals(4, victory.getTitleSize());
    }

    @Test
    void testGetCastleSize() {
        assertEquals(18, victory.getCastleSize());
    }

    @Test
    void testGetEntry1() {
        assertEquals("Congratulations! You successfully defended the castle from all the enemies!", victory.getEntry1());
    }

    @Test
    void testGetEntry2() {
        assertEquals("Press ESC to go back to the menu", victory.getEntry2());
    }
}

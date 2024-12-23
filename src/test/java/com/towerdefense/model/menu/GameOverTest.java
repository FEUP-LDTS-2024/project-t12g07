package com.towerdefense.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameOverTest {
    private GameOver gameOver;

    @BeforeEach
    void setUp() {
        gameOver = new GameOver();
    }

    @Test
    void testGetTitle() {
        assertEquals("  ___   _   __  __ ___    _____   _____ ___   ", gameOver.getTitle(0));
        assertEquals(" / __| /_\\ |  \\/  | __|  / _ \\ \\ / / __| _ \\  ", gameOver.getTitle(1));
        assertEquals("| (_ |/ _ \\| |\\/| | _|  | (_) \\ V /| _||   /  ", gameOver.getTitle(2));
        assertEquals(" \\___/_/ \\_\\_|  |_|___|  \\___/ \\_/ |___|_|_\\  ", gameOver.getTitle(3));
    }

    @Test
    void testGetTitleSize() {
        assertEquals(4, gameOver.getTitleSize());
    }

    @Test
    void testGetEntry() {
        assertEquals("Press ESC to go back to the menu", gameOver.getEntry());
    }

    @Test
    void testGetTitleOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> gameOver.getTitle(4));
    }
}

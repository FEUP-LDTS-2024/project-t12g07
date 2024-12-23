package com.towerdefense.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    private Menu menu;

    @BeforeEach
    void setUp() {
        menu = new Menu();
    }

    @Test
    void testInitialState() {
        assertTrue(menu.isSelectedStart());
        assertFalse(menu.isSelectedInstructions());
        assertFalse(menu.isSelectedExit());
    }

    @Test
    void testNextEntry() {
        menu.nextEntry();
        assertTrue(menu.isSelectedInstructions());
        menu.nextEntry();
        assertTrue(menu.isSelectedExit());
        menu.nextEntry();
        assertTrue(menu.isSelectedStart());
    }

    @Test
    void testPreviousEntry() {
        menu.previousEntry();
        assertTrue(menu.isSelectedExit());
        menu.previousEntry();
        assertTrue(menu.isSelectedInstructions());
        menu.previousEntry();
        assertTrue(menu.isSelectedStart());
    }

    @Test
    void testGetEntry() {
        assertEquals("Start", menu.getEntry(0));
        assertEquals("Instructions", menu.getEntry(1));
        assertEquals("Exit", menu.getEntry(2));
    }

    @Test
    void testIsSelected() {
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
        assertFalse(menu.isSelected(2));
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(3, menu.getNumberEntries());
    }

    @Test
    void testGetEntryOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> menu.getEntry(3));
    }
}

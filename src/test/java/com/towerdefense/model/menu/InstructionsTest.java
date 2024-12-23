package com.towerdefense.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InstructionsTest {
    private Instructions instructions;

    @BeforeEach
    void setUp() {
        instructions = new Instructions();
    }

    @Test
    void testGetTitle() {
        assertEquals("  ___ _  _ ___ _____ ___ _   _  ___ _____ ___ ___  _  _ ___ ", instructions.getTitle(0));
        assertEquals(" |_ _| \\| / __|_   _| _ \\ | | |/ __|_   _|_ _/ _ \\| \\| / __|", instructions.getTitle(1));
        assertEquals("  | || .` \\__ \\ | | |   / |_| | (__  | |  | | (_) | .` \\__ \\", instructions.getTitle(2));
        assertEquals(" |___|_|\\_|___/ |_| |_|_\\\\___/ \\___| |_| |___\\___/|_|\\_|___/", instructions.getTitle(3));
    }

    @Test
    void testGetTitleSize() {
        assertEquals(4, instructions.getTitleSize());
    }

    @Test
    void testGetEntry() {
        assertEquals("Your castle is in danger!", instructions.getEntry(0));
        assertEquals("Vicious enemies want to steal all your gemstones.", instructions.getEntry(1));
        assertEquals("Place defense towers to defeat them before your vault", instructions.getEntry(2));
        assertEquals("is empty.", instructions.getEntry(3));
    }

    @Test
    void testGetNumberEntries() {
        assertEquals(4, instructions.getNumberEntries());
    }

    @Test
    void testGetBack() {
        assertEquals("Press ESC to go back to the menu", instructions.getBack());
    }

    @Test
    void testGetControlTitle() {
        assertEquals("Controls:", instructions.getControlTitle());
    }

    @Test
    void testGetControlEntries() {
        assertEquals("Change tower type: T", instructions.getControlEntries(0));
        assertEquals("Place tower: ENTER", instructions.getControlEntries(1));
        assertEquals("Select tower place: UP,DOWN,LEFT,RIGHT", instructions.getControlEntries(2));
    }

    @Test
    void testGetControlEntriesSize() {
        assertEquals(3, instructions.getControlEntriesSize());
    }

    @Test
    void testGetTitleOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> instructions.getTitle(4));
    }

    @Test
    void testGetEntryOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> instructions.getEntry(4));
    }

    @Test
    void testGetControlEntriesOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> instructions.getControlEntries(3));
    }
}

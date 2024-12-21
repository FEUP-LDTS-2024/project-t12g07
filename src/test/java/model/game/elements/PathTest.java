package com.towerdefense.model.game.elements;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {
    @Test
    public void testPathCreation() {
        Path path = new Path(3, 7);

        assertEquals(3, path.getPosition().getX());
        assertEquals(7, path.getPosition().getY());
    }

    @Test
    public void testPathArt() {
        Path path = new Path(0, 0);
        String[] expectedArt = {
                "█ ░ █ ",
                "░ █ ░ ",
                "█ ░ █ ",
                "░ █ ░ ",
                "█ ░ █ "
        };

        assertArrayEquals(expectedArt, path.getPathArt());
    }

    @Test
    public void testPathArtLength() {
        Path path = new Path(0, 0);
        assertEquals(5, path.getPathArt().length);
    }

    @Test
    public void testPathArtContent() {
        Path path = new Path(0, 0);
        String[] pathArt = path.getPathArt();

        for (String line : pathArt) {
            assertTrue(line.matches("[█░ ]+"));
            assertEquals(6, line.length());
        }
    }
}

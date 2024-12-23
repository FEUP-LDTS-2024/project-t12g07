package com.towerdefense.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void testConstructorAndGetters() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testNegativeCoordinates() {
        Position position = new Position(-3, -7);
        assertEquals(-3, position.getX());
        assertEquals(-7, position.getY());
    }

    @Test
    void testZeroCoordinates() {
        Position position = new Position(0, 0);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    void testLargeCoordinates() {
        Position position = new Position(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertEquals(Integer.MAX_VALUE, position.getX());
        assertEquals(Integer.MIN_VALUE, position.getY());
    }
}

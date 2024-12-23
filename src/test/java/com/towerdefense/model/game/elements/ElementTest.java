package com.towerdefense.model.game.elements;

import com.towerdefense.model.game.elements.Element;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.towerdefense.model.Position;

class ElementTest {
    @Test
    void testElementConstructor() {
        Element element = new Element(3, 7);
        Position position = element.getPosition();

        assertNotNull(position);
        assertEquals(3, position.getX());
        assertEquals(7, position.getY());
    }

    @Test
    void testGetPosition() {
        Element element = new Element(5, 10);
        Position position = element.getPosition();

        assertNotNull(position);
        assertEquals(5, position.getX());
        assertEquals(10, position.getY());
    }

    @Test
    void testSetPosition() {
        Element element = new Element(0, 0);
        Position newPosition = new Position(8, 12);

        element.setPosition(newPosition);
        Position updatedPosition = element.getPosition();

        assertNotNull(updatedPosition);
        assertEquals(8, updatedPosition.getX());
        assertEquals(12, updatedPosition.getY());
    }
}

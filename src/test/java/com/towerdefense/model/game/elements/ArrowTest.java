package com.towerdefense.model.game.elements;

import com.towerdefense.model.game.elements.Arrow;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.towerdefense.model.Position;

class ArrowTest {
    @Test
    void testArrowConstructor() {
        Arrow arrow = new Arrow(10, 20);

        assertEquals(10, arrow.getPosition().getX());
        assertEquals(20, arrow.getPosition().getY());
        assertEquals(20, arrow.getSpeed());
    }

    @Test
    void testGetSpeed() {
        Arrow arrow = new Arrow(0, 0);
        assertEquals(20, arrow.getSpeed());
    }
}

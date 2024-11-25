package com.towerdefense.model.game.elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CastleTest {
    private Castle castle;

    @BeforeEach
    public void setUp() {
        castle = new Castle();
        castle.setGemstones(1000); // começa-se com 1000
    }

    @Test
    public void testGetGemstones() {
        assertEquals(1000, castle.getGemstones());
    }

    @Test
    public void testGemstonesAfterTheft() {
        castle.reduceGemstones(50);
        assertEquals(950, castle.getGemstones());
    }
}

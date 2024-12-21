package model.game.elements;

import com.towerdefense.model.game.elements.Warning;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WarningTest {
    @Test
    void testWarningConstructor() {
        String[] messages = {"Warning 1", "Warning 2"};
        long duration = 5000;
        String color = "#FF0000";
        Warning warning = new Warning(10, 20, messages, duration, color);

        assertEquals(10, warning.getPosition().getX());
        assertEquals(20, warning.getPosition().getY());
        assertArrayEquals(messages, warning.getMessages());
        assertEquals(color, warning.getColor());
    }

    @Test
    void testIsActive() {
        Warning warning = new Warning(0, 0, new String[]{"Test"}, 100, "");
        assertTrue(warning.isActive());

        try {
            Thread.sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertFalse(warning.isActive());
    }

    @Test
    void testReset() {
        Warning warning = new Warning(0, 0, new String[]{"Old"}, 1000, "");
        String[] newMessages = {"New 1", "New 2"};
        long newDuration = 2000;

        warning.reset(newMessages, newDuration);

        assertArrayEquals(newMessages, warning.getMessages());
        assertTrue(warning.isActive());
    }

    @Test
    void testGetColor() {
        String color = "#00FF00";
        Warning warning = new Warning(0, 0, new String[]{}, 1000, color);
        assertEquals(color, warning.getColor());
    }
}

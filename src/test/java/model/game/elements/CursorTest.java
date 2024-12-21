package model.game.elements;

import com.towerdefense.model.game.elements.Cursor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CursorTest {
    @Test
    void testCursorConstructor() {
        Cursor cursor = new Cursor(5, 10);

        assertEquals(5, cursor.getPosition().getX());
        assertEquals(10, cursor.getPosition().getY());
    }

    @Test
    void testGetCursorArt() {
        Cursor cursor = new Cursor(0, 0);
        String[] cursorArt = cursor.getCursorArt();

        assertNotNull(cursorArt);
        assertEquals(1, cursorArt.length);
        assertEquals("X", cursorArt[0]);
    }
}

package model.game.elements;

import com.towerdefense.model.game.elements.Grass;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GrassTest {
    @Test
    public void testGrassCreation() {
        Grass grass = new Grass(5, 10);

        assertEquals(5, grass.getPosition().getX());
        assertEquals(10, grass.getPosition().getY());
    }

    @Test
    public void testGrassArt() {
        Grass grass = new Grass(0, 0);
        String[] expectedArt = {
                "  ^ ~ ",
                " ^ ~ ^",
                "~ ^ ^ ",
                " ^ ~ ^",
                " ^ ~ ^"
        };

        assertArrayEquals(expectedArt, grass.getGrassArt());
    }

    @Test
    public void testGrassArtLength() {
        Grass grass = new Grass(0, 0);
        assertEquals(5, grass.getGrassArt().length);
    }
}

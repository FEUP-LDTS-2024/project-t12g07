import com.towerdefense.model.game.elements.Grass;
import com.towerdefense.model.game.elements.Sea;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SeaTest {

    @Test
    void testSeaConstructor() {
        Sea sea = new Sea(5, 10);

        assertEquals(5, sea.getPosition().getX());
        assertEquals(10, sea.getPosition().getY());
    }

    @Test
    void testGetSeaArt() {
        Sea sea = new Sea(0, 0);
        String[] expectedArt = {
                " ´ ~ ´",
                " ´´ ~´",
                "~ ´´ ~",
                " ^ ~ ´",
                " ´´ ~´"
        };

        assertArrayEquals(expectedArt, sea.getSeaArt());
    }
}

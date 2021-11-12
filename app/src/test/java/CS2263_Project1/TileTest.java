package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    @Test
    public void testSetSpent(){
        Tile tile = new Tile("A1", false);
        tile.setSpentStatus();
        assertTrue(tile.isSpent);
    }

    @Test
    public void testConstructor(){
        Tile tile = new Tile("A1", true);
        assertTrue(tile.isSpent);

    }
}

package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TileTest {
    @Test
    public void testSetSafe(){
        Tile tile = new Tile();
        tile.setSafeStatus();
        assertTrue(tile.isSafe);
    }

    @Test
    public void testSetSpent(){
        Tile tile = new Tile();
        tile.setSpentStatus();
        assertTrue(tile.isSpent);
    }
}

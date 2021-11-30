package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 */

public class TileTest {
    /**
     * Test for setSpent method
     */
    @Test
    public void testSetSpent(){
        Tile tile = new Tile("A1", false, null, null, null, null, null, null);
        tile.setSpentStatus();
        assertTrue(tile.isSpent);
    }

    /**
     * Test to see if constructor even works
     */
    @Test
    public void testConstructor(){
        Tile tile = new Tile("A1", true, null, null, null, null, null, null);
        assertTrue(tile.isSpent);

    }
}

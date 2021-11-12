package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testPlaceTile(){
        Board board = new Board();
        Tile t = new Tile("A1", false);
        board.placeTile(t);
        assertTrue(t.isSpent);
    }
}

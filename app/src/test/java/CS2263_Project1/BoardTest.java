package CS2263_Project1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;


/**
 * @author David Hellwig
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoardTest {
    private Board board;

    @BeforeAll
    public void setUp(){
        board = new Board();
    }

    /**
     * test for placeTile method
     */
    @Test
    public void testPlaceTile(){

        Tile t = new Tile("A1", false, null, null, null, null, null, null);
        board.placeTile(t);
        assertTrue(t.isSpent);
    }

    /**
     * test for getCorporation method
     */
    @Test
    public void testGetCorporation(){
        Corporation corporation = board.accessCorporation(1);
        assertEquals(corporation,board.accessCorporation(1));

    }

    /**
     * test for checkEndGame method
     */
    @Test
    public void testCheckEndGame(){
        assertFalse(board.checkEndGame());
    }

    /**
     * test for getGameCanEnd method
     */
    @Test
    public void testGetGameCanEnd(){
        assertFalse(board.getGameCanEnd());
    }


}

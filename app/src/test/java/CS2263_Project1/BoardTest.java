package CS2263_Project1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.mockito.Mockito.*;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BoardTest {
    private Board board;

    @BeforeAll
    public void setUp(){
        board = new Board();
    }

    @Test
    public void testPlaceTile(){

        Tile t = new Tile("A1", false);
        board.placeTile(t);
        assertTrue(t.isSpent);
    }

    @Test
    public void testGetCorporation(){
        Corporation corporation = board.accessCorporation(1);
        assertEquals(corporation,board.accessCorporation(1));

    }

    @Test
    public void testCheckEndGame(){
        assertFalse(board.checkEndGame());
    }

    @Test
    public void testGetGameCanEnd(){
        assertFalse(board.getGameCanEnd());
    }


}

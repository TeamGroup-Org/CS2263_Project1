package CS2263_Project1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * @author David Hellwig
 */


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlayerTest {

    private Player player;
    private Stock stock;
    private Board board;

    @BeforeAll
    public void setUp(){
        board = new Board();

        ArrayList<Tile> hand = new ArrayList<>();

        Tile t1 = new Tile("A1", false);

        Tile t2 = new Tile("A2", false);

        hand.add(t1);

        hand.add(t2);

        ArrayList<Stock> stocks = new ArrayList<>();

        stock = new Stock(100, "test");

        stocks.add(stock);

        player = new Player(1, 1000, hand, stocks);
    }

    /**
     * Does the constructor even work?
     */
    @Test
    public void testConstructor(){
        assertNotNull(player);
    }

    /**
     * test for takeMoney method
     */
    @Test
    public void testTakeMoney(){
        player.takeMoney(50);
        assertEquals(1050, player.getPlayerInfo());
        player.takeMoney(-1);
        assertEquals(1050, player.getPlayerInfo());
    }
    /**
     * test for takeMoney method
     */
    @Test
    public void testSpendMoney(){
        player.spendMoney(50);
        assertEquals(1000, player.getPlayerInfo());
        player.spendMoney(-50);
        assertEquals(1000, player.getPlayerInfo());
    }
    /**
     * test for playTile method
     */
    @Test
    public void testPlayTile(){
        Tile t = new Tile("A1", false);
        player.playTile(board, t);
        assertTrue(t.isSpent);

    }

    /**
     * test for tradeStock method
     */
    @Test
    public void testTradeStock(){
        Stock s = new Stock(0, "test");
        Corporation c = new Corporation(1,"test",true,false,2);
        player.tradeStock(s,c);
        assertEquals(200,s.getValue());
    }

    /**
     * test for sellStock method
     */
    @Test
    public void testSellStock(){
        player.sellStock(0);
        assertEquals(0,player.getPrice().size());
    }

    /**
     * test for found method
     */
    @Test
    public void testFound(){
        Corporation c = new Corporation(1,"test",false,false,0);
        player.foundCorporation(c);
        assertEquals(2,c.getSize());
        assertTrue(c.getInUse());
    }


}

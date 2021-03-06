package CS2263_Project1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

/**
 * @author David Hellwig
 *
 * @version v1.1.0
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

        Tile t1 = new Tile("A1", false, null, null, null, null, null, null);

        Tile t2 = new Tile("A2", false, null, null, null, null, null, null);

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
        assertEquals(1050, player.getWallet());
        player.takeMoney(-1);
        assertEquals(1050, player.getWallet());
    }
    /**
     * test for takeMoney method
     */
    @Test
    public void testSpendMoney(){
        player.spendMoney(50);
        assertEquals(1000, player.getWallet());
        player.spendMoney(-50);
        assertEquals(1000, player.getWallet());
    }

//    /**
//     * test for playTile method
//     */
//    @Test
//    public void testPlayTile(){
//        Tile t = new Tile("A1", false, null, null, null, null, null, null);
//        player.playTile(board, t);
//        assertTrue(t.isSpent);
//    }

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
        assertEquals(0,player.getPortfolio().size());
    }

//    /**
//     * test for found method
//     */
//    @Test
//    public void testFound(){
//        Corporation c = new Corporation(1,"test",false,false,0);
//        player.foundCorporation(c);
//        assertEquals(2,c.getSize());
//        assertTrue(c.getInUse());
//    }

    /**
     * test for getHand method to make sure it is not null
     */
    @Test
    public void testGetHand(){

        assertNotNull(player.getHand());
    }

    /**
     * test for getTileFromHand method
     */
    @Test
    public void testGetTileFromHand(){
        Tile t = player.getTileFromHand(3);

        assertNull(t);

        Tile testTile = player.getTileFromHand(0);

        assertNotNull(testTile);
    }

    /**
     * test for the set hand method
     */
    @Test
    public void testSetHand(){
        Tile t1 = new Tile("A5", false, null, null, null, null, null, null);

        Tile t2 = new Tile("A4", false, null, null, null, null, null, null);
        ArrayList<Tile> test = new ArrayList<>();

        test.add(t1);

        test.add(t2);

        player.setHand(test);

        assertEquals(test, player.getHand());


    }
}

package CS2263_Project1;
/**
 * @author David Hellwig
 *
 * @version v1.1.0
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankerTest {
    private Banker banker;

    private Corporation corporation;

    private Player player;

    private Player player2;

    private Stock stock;

    @BeforeAll
    public void setUp(){

        corporation = new Corporation(1, "test", true, false, 2);

        banker = new Banker();

        ArrayList<Tile> hand = new ArrayList<>();

        Tile t1 = new Tile("A1", false, null, null, null, null, null, null);

        Tile t2 = new Tile("A2", false, null, null, null, null, null, null);

        hand.add(t1);

        hand.add(t2);

        ArrayList<Stock> stocks = new ArrayList<>();

        stock = new Stock(100, "test");

        stocks.add(stock);

        player = new Player(1, 1000, hand, stocks);

        player2 = new Player(2, 1000, hand, stocks);

    }

    /**
     * I know, this is terrible, but if it works for now we can refactor later
     */
    @AfterEach
    public void reset(){
        corporation = new Corporation(1, "test", true, false, 2);

        banker = new Banker();

        ArrayList<Tile> hand = new ArrayList<>();

        Tile t1 = new Tile("A1", false, null, null, null, null, null, null);

        Tile t2 = new Tile("A2", false, null, null, null, null, null, null);

        hand.add(t1);

        hand.add(t2);

        ArrayList<Stock> stocks = new ArrayList<>();

        stock = new Stock(100, "test");

        stocks.add(stock);

        player = new Player(1, 1000, hand, stocks);

        player2 = new Player(2, 4000, hand, stocks);


    }

    /**
     * Test for setStockPrice method
     */
    @Test
    public void testSetStockPrice(){
        banker.setStockPrice(stock, 500);
        assertEquals(500, stock.getValue());
    }

    /**
     * test for calculateReturn method
     */
    @Test
    public void testCalculateReturn(){
        banker.calculateReturn(corporation, player);
        assertEquals(5000, player.getWallet());
    }

    /**
     * test for getWinner method (REFACTOR THIS)
     */
    @Test
    public void testGetWinner(){
        assertEquals(player2, banker.getWinner(player, player2));
        player.takeMoney(5000);
        assertEquals(player, banker.getWinner(player, player2));
    }

    /**
     * test to make sure a placeholder player is the winner if no human player won
     */
    @Test
    public void testNoWinner(){
        Player testPlayer = player2;
        Player p  = banker.getWinner(testPlayer,player2);

        assertEquals(0, p.getWallet());

    }

}

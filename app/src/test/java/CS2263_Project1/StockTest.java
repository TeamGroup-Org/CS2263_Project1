package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 *
 * @version v1.1.0
 */

public class StockTest {
    /**
     * test for getCompany method
     */
    @Test
    public void testGetCompany(){
        Stock stock = new Stock(10, "test");
        assertEquals("test",stock.getCompany());

    }

    /**
     * test for getValue method
     */
    @Test
    public void testGetValue(){
        Stock stock = new Stock(5, "test");
        assertEquals(5,stock.getValue());
    }

    /**
     * test for setValue method
     */
    @Test
    public void testSetValue(){
        Stock stock = new Stock(0, "test");
        stock.setValue(1);
        assertEquals(1,stock.getValue());
    }
}

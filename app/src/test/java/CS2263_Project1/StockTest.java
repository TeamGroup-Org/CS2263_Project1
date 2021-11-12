package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StockTest {
    @Test
    public void testGetCompany(){
        Stock stock = new Stock(10, "test");
        assertEquals("test",stock.getCompany());

    }
    @Test
    public void testGetValue(){
        Stock stock = new Stock(5, "test");
        assertEquals(5,stock.getValue());
    }

    @Test
    public void testSetValue(){
        Stock stock = new Stock(0, "test");
        stock.setPrice(1);
        assertEquals(1,stock.getValue());
    }
}

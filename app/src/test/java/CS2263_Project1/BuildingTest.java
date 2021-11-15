package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 */

public class BuildingTest {
    /**
     * test for getIsType method
     */
    @Test
    public void testGetIsType(){
        Building b = new Building(1, false, "test");
        assertEquals(1, b.getIsType());
    }

    /**
     * test for setIsType method
     */
    @Test
    public void testSetIsType(){
        Building b = new Building(1, false, "test");
        b.setIsType(66);
        assertEquals(66,b.getIsType());

    }
    /**
     * test for IsSpent method
     */
    @Test
    public void testIsSpent(){
        Building b = new Building(1, false, "test");
        assertFalse(b.isSpent);
    }

    /**
     * test for setSpent method
     */
    @Test
    public void testSetSpent(){
        Building b = new Building(1, false, "test");
        b.setSpent(true);
        assertEquals(true,b.isSpent);
    }

    /**
     * test for setLocation method
     */
    @Test
    public void testSetLocation(){
        Building b = new Building(1, false, "test");
        b.setLocation("B5");
        assertEquals("B5", b.getLocation());
    }

    /**
     * test for getLocation method
     */
    @Test
    public void testGetLocation(){
        Building b = new Building(1, false, "test");
        assertEquals("test", b.getLocation());
    }
}

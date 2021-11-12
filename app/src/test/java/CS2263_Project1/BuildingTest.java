package CS2263_Project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuildingTest {
    @Test
    public void testGetIsType(){
        Building b = new Building(1, false, "test");
        assertEquals(1, b.getIsType());
    }

    @Test
    public void testSetIsType(){
        Building b = new Building(1, false, "test");
        b.setIsType(66);
        assertEquals(66,b.getIsType());

    }

    @Test
    public void testIsSpent(){
        Building b = new Building(1, false, "test");
        assertFalse(b.isSpent);
    }

    @Test
    public void testSetSpent(){
        Building b = new Building(1, false, "test");
        b.setSpent(true);
        assertEquals(true,b.isSpent);
    }

    @Test
    public void testSetLocation(){
        Building b = new Building(1, false, "test");
        b.setLocation("B5");
        assertEquals("B5", b.getLocation());
    }

    @Test
    public void testGetLocation(){
        Building b = new Building(1, false, "test");
        assertEquals("test", b.getLocation());
    }
}

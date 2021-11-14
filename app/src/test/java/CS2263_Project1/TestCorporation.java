package CS2263_Project1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;


public class TestCorporation {
    private Corporation c;


    @Test
    public void testGetName(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertEquals("test",c.getName());
    }

    @Test
    public void testGetInUse(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertTrue(c.getInUse());
    }

    @Test
    public void testGetIsSafe(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertFalse(c.getIsSafe());
    }

    @Test
    public void testGetSize(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertEquals(1,c.getSize());
    }

    @Test
    public void testSetName(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setName("headache");
        assertEquals("headache", c.getName());
    }

    @Test
    public void testSetInUse(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setInUse(false);
        assertFalse(c.getInUse());
    }

    @Test
    public void testSetIsSafe(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setIsSafe(true);
        assertTrue(c.getIsSafe());
    }

    @Test
    public void testSetSize(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setSize(15);
        assertEquals(15,c.getSize());
    }

    @Test
    public void testGainTiles(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.gainTiles(15);
        assertEquals(16,c.getSize());
        assertTrue(c.getIsSafe());
    }

    @Test
    public void testGetPrice(){
        Corporation c = new Corporation(1,"test",true,false,2);
        assertEquals(200,c.getPrice());
        c.setSize(15);
        assertEquals(700,c.getPrice());
        c.setSize(6);
        assertEquals(600,c.getPrice());
        c.setSize(21);
        assertEquals(800,c.getPrice());
        c.setSize(31);
        assertEquals(900,c.getPrice());
        c.setSize(41);
        assertEquals(1000,c.getPrice());

    }

    @Test
    public void testGetBonuses(){
        Corporation c = new Corporation(1,"test",true,false,2);
        assertEquals(1000, c.getMinorityBonus());
        assertEquals(2000,c.getMajorityBonus());

    }
}

package CS2263_Project1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 */

public class TestCorporation {
    private Corporation c;



    /**
     * Test for getName method
     */
    @Test
    public void testGetName(){
        Corporation c = new Corporation(1,"test",true,false,2);
        assertEquals("test",c.getName());
    }

    /**
     * Test for getInUse method
     */
    @Test
    public void testGetInUse(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertTrue(c.getInUse());
    }

    /**
     * Test for getIsSafe method
     */
    @Test
    public void testGetIsSafe(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertFalse(c.getIsSafe());
    }

    /**
     * Test for getSize method
     */
    @Test
    public void testGetSize(){
        Corporation c = new Corporation(1,"test",true,false,1);
        assertEquals(1,c.getSize());
    }

    /**
     * Test for set name method
     */
    @Test
    public void testSetName(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setName("headache");
        assertEquals("headache", c.getName());
    }

    /**
     * Test for setInUse method
     */
    @Test
    public void testSetInUse(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setInUse(false);
        assertFalse(c.getInUse());
    }

    /**
     * Test for setIsSafe method
     */
    @Test
    public void testSetIsSafe(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setIsSafe(true);
        assertTrue(c.getIsSafe());
    }

    /**
     * Test for setSize method
     */
    @Test
    public void testSetSize(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.setSize(15);
        assertEquals(15,c.getSize());
    }

    /**
     * Test for gainTiles method
     */
    @Test
    public void testGainTiles(){
        Corporation c = new Corporation(1,"test",true,false,1);
        c.gainTiles(15);
        assertEquals(16,c.getSize());
        assertTrue(c.getIsSafe());
    }

    /**
     * Test for getPrice method (REFACTOR THIS)
     */
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

    /**
     * Test for getBonuses method
     */
    @Test
    public void testGetBonuses(){
        Corporation c = new Corporation(1,"test",true,false,2);
        assertEquals(1000, c.getMinorityBonus());
        assertEquals(2000,c.getMajorityBonus());

    }
    /**
     * Test for found method
     */
    public void testFound(){
        c.setSize(1);
        c.found();
        assertTrue(c.getInUse());
        assertEquals(2, c.getSize());

    }
    /**
     * Test for absorbed method
     */
    @Test
    public void testAbsorbed(){
        Corporation c = new Corporation(1,"test",true,false,2);
        c.absorbed();
        assertFalse(c.getInUse());
        assertEquals(0,c.getSize());


    }
}

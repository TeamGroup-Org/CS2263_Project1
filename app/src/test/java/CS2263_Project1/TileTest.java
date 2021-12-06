package CS2263_Project1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author David Hellwig
 *
 * @version v1.1.0
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TileTest {

    private Tile tile;

    @BeforeAll
    public void setUp(){
        tile = new Tile("A1", false, null, null, null, null, null, null);
    }

    @AfterEach
    public void reset(){
        tile.setId("A1");
        tile.setSpent(false);
        tile.setMemberOf(null);
        tile.setOwner(null);
        tile.setLeft(null);
        tile.setRight(null);
        tile.setUp(null);
        tile.setDown(null);

    }

    /**
     * Test to see if constructor even works
     */
    @Test
    public void testConstructor(){

        assertFalse(tile.isSpent);

    }

    /**
     * test for all getters
     */
    @Test
    public void testGetters(){
        assertEquals("A1", tile.getId());

        assertNull(tile.getMemberOf());

        assertNull(tile.getOwner());

        assertNull(tile.getLeft());

        assertNull(tile.getRight());

        assertNull(tile.getUp());

        assertNull(tile.getDown());




    }

    /**
     * test for testNullCheckedToString method
     */
    @Test
    public void testNullCheckedToString(){
        assertEquals("Tile [id=A1, isSpent=false, memberOf=null, owner=null, left=null, right=null, up=null, down=null]" , tile.nullCheckedToString());

    }

    /**
     * test for testNullCheckedToString method possible branches
     */
    @Test
    public void testNullCheckedToStringBranches(){
        Player p = new Player(1, 0, null, null);

        tile.setId("C5");

        Corporation c = new Corporation(1,"test",true,false,1);

        tile.setMemberOf(c);

        tile.setOwner(p);

        Tile tileA = new Tile("B5", false, null, null, null, null, null, tile);

        Tile tileB = new Tile("C6", false, null, null, tile, null, null, null);

        Tile tileC = new Tile("C4", false, null, null, null, tile, null, null);

        Tile tileD = new Tile("E5", false, null, null, null, null, tile, null);

        tile.setRight(tileB);

        tile.setLeft(tileC);

        tile.setUp(tileA);

        tile.setDown(tileD);

        assertEquals("Tile [id=C5, isSpent=false, memberOf=test, owner=1, left=C4, right=C6, up=B5, down=E5]", tile.nullCheckedToString());


    }



}

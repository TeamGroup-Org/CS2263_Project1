package CS2263_Project1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author David Hellwig
 * @author Noah Owens
 *
 * @version v1.1.0
 */

public class TileTrayTest {

    /**
     * Test for get tray
     */
    @Test
    public void testGetTray() {
        ArrayList<Tile> list = new ArrayList<>();
        Tile tile = new Tile("A1", false, null, null, null, null, null, null);
        list.add(tile);
        TileTray t = new TileTray(list);
        assertNotNull(t.getTray());
    }

    /**
     * Test for set tray
     */
    @Test
    public void testSetTray() {
        ArrayList<Tile> list = new ArrayList<>();
        Tile tile = new Tile("A1", false, null, null, null, null, null, null);
        list.add(tile);
        TileTray t = new TileTray(list);
        ArrayList<Tile> list2 = new ArrayList<>();
        Tile tile2 = new Tile("A1", false, null, null, null, null, null, null);
        list2.add(tile2);
        t.setTray(list2);
        assertEquals(list2, t.getTray());
    }

    /**
     * test to make sure shuffleTray method doesn't destroy the tiletray
     */
    @Test
    public void testShuffleTray(){
        Tile tile = new Tile("A1", false, null, null, null, null, null, null);
        Tile tile2 = new Tile("A3", false, null, null, null, null, null, null);
        Tile tile3 = new Tile("B6", false, null, null, null, null, null, null);
        ArrayList<Tile> list = new ArrayList<>();
        list.add(tile);
        list.add(tile2);
        list.add(tile3);
        TileTray t = new TileTray(list);
        t.shuffleTray();
        assertNotNull(t.getTray());
    }

    /**
     * test for askForTile method
     * @return
     */
    @Test
    public void testAskForTile(){
        Tile tile = new Tile("A1", false, null, null, null, null, null, null);
        Tile tile2 = new Tile("A3", false, null, null, null, null, null, null);
        Tile tile3 = new Tile("B6", false, null, null, null, null, null, null);
        ArrayList<Tile> list = new ArrayList<>();
        list.add(tile);
        list.add(tile2);
        list.add(tile3);
        TileTray t = new TileTray(list);
        Tile test = t.askForTile();
        assertEquals(tile, test);
        t.askForTile();
        Tile test2 = t.askForTile();
        assertEquals(tile3,test2 );
        t.askForTile();

        assertEquals("XX", t.askForTile().getId());
    }

}

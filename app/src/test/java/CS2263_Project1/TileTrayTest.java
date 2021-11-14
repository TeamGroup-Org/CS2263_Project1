package CS2263_Project1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TileTrayTest {
    @Test
    public void testGetTray(){
        ArrayList<Tile> list = new ArrayList<>();
        Tile tile = new Tile("A1", false);
        list.add(tile);
        TileTray t = new TileTray(list);
        assertNotNull(t.getTray());
    }

    @Test
    public void testSetTray(){
        ArrayList<Tile> list = new ArrayList<>();
        Tile tile = new Tile("A1", false);
        list.add(tile);
        TileTray t = new TileTray(list);
        ArrayList<Tile> list2 = new ArrayList<>();
        Tile tile2 = new Tile("A1", false);
        list2.add(tile2);
        t.setTray(list2);
        assertEquals(list2, t.getTray());
    }

//    @Test
//    public void testIsEmpty(){
//        ArrayList<Tile> list = new ArrayList<>();
//        Tile tile = new Tile("A1", false);
//        list.add(tile);
//        TileTray t = new TileTray(list);
//
//        assertEquals(t.isEmpty(), assertNotNull(t.getTray()));
//    }
}

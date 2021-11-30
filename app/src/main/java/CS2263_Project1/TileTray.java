package CS2263_Project1;

import java.util.ArrayList;

/**
 * @author David Hellwig
 * @author Noah Ownes
 * @author Ekow Barlow
 *
 * @version 1.0.0
 */
public class TileTray {
    private ArrayList<Tile> tray = new ArrayList<>();

    public TileTray(ArrayList<CS2263_Project1.Tile> tray) {
        this.tray = tray;
    }

    /**
     * get tray returns all the tiles within the tray
     *
     * @return an ArrayList of type Tile
     */
    public ArrayList<Tile> getTray() {
        if (tray.isEmpty()){
            return null;
        }
        return tray;
    }

    /**
     * Set the tile tray
     *
     * @param tray is the new ArrayList of Tiles being used
     */
    public void setTray(ArrayList<CS2263_Project1.Tile> tray) {
        this.tray = tray;
    }

    public boolean isEmpty() {
        if (tray.size() != 0) {
            return true;
        }
        return false;
    }
}

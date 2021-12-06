package CS2263_Project1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author David Hellwig
 * @author Noah Owens
 * @author Ekow Barlow
 *
 * @version v1.1.0
 */
public class TileTray {
    private ArrayList<Tile> tray;

    /**
     * Constructor
     *
     * @param tray is the ArrayList of Tiles that will be updated during TileTray tasks
     */
    public TileTray(ArrayList<Tile> tray) {
        this.tray = tray;
    }

    /**
     * get tray returns all the tiles within the tray
     *
     * @return an ArrayList of type Tile
     */
    public ArrayList<Tile> getTray() {
        if (tray.isEmpty()) {
            return null;
        }
        return tray;
    }

    /**
     * Set the tile tray
     *
     * @param tray is the new ArrayList of Tiles being used
     */
    public void setTray(ArrayList<Tile> tray) {
        this.tray = tray;
    }

    /**
     * Determines if tray is empty
     *
     * @return true if tray contains no tiles, false otherwise.
     */
    public boolean isEmpty() {
        return tray.size() == 0;
    }

    public void shuffleTray() {
        Collections.shuffle(tray);
    }

    /**
     * Removes the first tile from the tray until empty, at which point it gives out dummy tiles which will appear in the UI as X tiles
     *
     * @return A tile from the ArrayList tray
     */
    public Tile askForTile() {
        if (tray.isEmpty()) {
            // Draws a dummy tile if the bag of tiles is empty, which should ordinarily not happen before game end.
            return new Tile("XX", false, null, null, null, null, null, null);
        }
        else {
            return tray.remove(0);
        }
    }
}

package CS2263_Project1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class TileTray {
    private ArrayList<Tile> tray;

    public ArrayList<Tile> getTray() {
        return this.tray;
    }

    public void addTray(Tile tray) {
        boolean add = this.tray.add(tray);
    }
}

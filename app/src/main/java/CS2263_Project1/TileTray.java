package CS2263_Project1;

import java.util.ArrayList;

public class TileTray {
    private ArrayList<Tile> tray;

    public ArrayList<Tile> getTray() {
        return this.tray;
    }

    public void addTray(Tile tray) {
        this.tray.add(tray);
    }
}

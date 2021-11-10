package CS2263_Project1;

import java.util.ArrayList;


public class TileTray {
    private ArrayList<Tile> tray;

    public TileTray(ArrayList<CS2263_Project1.Tile> tray) {
        this.tray = tray;
    }

    public ArrayList<CS2263_Project1.Tile> getTray() {
        return tray;
    }

    public void setTray(ArrayList<CS2263_Project1.Tile> tray) {
        this.tray = tray;
    }
}

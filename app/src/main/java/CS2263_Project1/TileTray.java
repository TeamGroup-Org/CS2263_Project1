package CS2263_Project1;

import java.util.ArrayList;


public class TileTray {
    private ArrayList<Tile> tray;

    public TileTray(ArrayList<CS2263_Project1.Tile> tray) {
        this.tray = tray;
    }

    public Tile getTray() {
        if (tray.size() != 0){
            return tray.remove(0);
        }
        return null;

    }

    public void setTray(ArrayList<CS2263_Project1.Tile> tray) {
        this.tray = tray;
    }
}

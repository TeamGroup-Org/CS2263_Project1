package CS2263_Project1;

/**
 * @author Noah Owens
 */

import java.util.ArrayList;

public class CorporationTray {
    private ArrayList<Corporation> tray = new ArrayList<>();

    /**
     * Empty Constructor
     */
    public CorporationTray(){
        initCorporationTray();
    }

    /**
     * initCorporationTray() is used at the start of the game to make all 7 hotel chains and place them into an ArrayList
     */
    private void initCorporationTray() {
        tray.add(new Corporation(1, "Worldwide", false, false, 0));
        tray.add(new Corporation(2, "Sackson", false, false, 0));
        tray.add(new Corporation(3, "Festival", false, false, 0));
        tray.add(new Corporation(4, "Imperial", false, false, 0));
        tray.add(new Corporation(5, "American", false, false, 0));
        tray.add(new Corporation(6, "Continental", false, false, 0));
        tray.add(new Corporation(7, "Tower", false, false, 0));
    }
}

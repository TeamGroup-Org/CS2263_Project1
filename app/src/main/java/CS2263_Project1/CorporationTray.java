package CS2263_Project1;

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
    private void initCorporationTray(){
        tray.add(new Corporation("Worldwide", false));
        tray.add(new Corporation("Sackson", false));
        tray.add(new Corporation("Festival", false));
        tray.add(new Corporation("Imperial", false));
        tray.add(new Corporation("American", false));
        tray.add(new Corporation("Continental", false));
        tray.add(new Corporation("Tower", false));
    }
}

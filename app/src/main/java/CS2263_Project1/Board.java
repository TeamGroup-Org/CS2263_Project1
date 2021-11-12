package CS2263_Project1;

import java.util.ArrayList;

/**
 * @author Noah Owens
 */

public class Board {
    public boolean gameCanEnd;
    private String[] boardArray = new String[108];
    private Tile[] tileArray = new Tile[108];
    private ArrayList<Corporation> corporationTray = new ArrayList<>();

    public Board() {
        initBoard();
    }

    /**
     * initBoard() fills boardArray with 108 spaces (From a1 to i12), fills corporation tray with the 7 hotel chains
     * and sets the value of gameCanEnd to false, preparing the game board for play.
     */
    private void initBoard() {
        int tileCoordNum;
        String tileCoordLetter;
        int counter = 0;

        //Create every letter number combination from 1-12 and A-I to fill boardArray;
        for (char y = 'A'; y <= 'I'; y++) {
                tileCoordLetter = String.valueOf(y);

            for (int x = 1; x <= 12; x++) {
                tileCoordNum = x;

                boardArray[counter] = tileCoordLetter + String.valueOf(tileCoordLetter);
                counter++;
            }
        }

        //set gameCanEnd to false
        gameCanEnd = false;

        //create the corporations (should be replaced by a json load I think.)
        initCorporationTray();
    }

    /**
     * initCorporationTray() is used at the start of the game to make all 7 hotel chains and place them into an ArrayList
     */
    private void initCorporationTray() {
        corporationTray.add(new Corporation(1, "Worldwide", false, false, 0));
        corporationTray.add(new Corporation(2, "Sackson", false, false, 0));
        corporationTray.add(new Corporation(3, "Festival", false, false, 0));
        corporationTray.add(new Corporation(4, "Imperial", false, false, 0));
        corporationTray.add(new Corporation(5, "American", false, false, 0));
        corporationTray.add(new Corporation(6, "Continental", false, false, 0));
        corporationTray.add(new Corporation(7, "Tower", false, false, 0));
    }

    /**
     * placeTile should update tileArray by finding the index of the tile's id in the boardArray
     *
     * @param t is the tile being placed onto the board from the player's hand
     */
    public void placeTile(Tile t) {
        t.isSpent = true;
    }

    /**
     * Determines if the game is in a valid end state by iterating through the list of corporations to see if
     * every inUse corporation is also safe, or if there
     */
    public boolean checkEndGame() {
        //game end conditions
        final int sizeCutoff = 41;
        final int safeCutoff = 4;
        //if safeCount exceeds 4, the game can end.
        int safeCount = 0;

        for(int i = 0; i < 7; i++) {
            Corporation corporation = corporationTray.get(i);
            if (corporation.getSize() >= sizeCutoff) {
                return true;
            } else if (corporation.getIsSafe() == true) {
                safeCount++;
            }
        }
        if (safeCount >= safeCutoff) { return true; }
        return false;
    }

    /**
     * Used to get a corporation object from the tray so it can be updated
     *
     * @param id the corporation's integer id within the tray;
     * @return the corporation object being fetched
     */
    public Corporation accessCorporation(int id) {
        //returns id minus 1 so that you can search by corporation.id but get the correct index within the corporation tray.
        return corporationTray.get(id - 1);
    }
}



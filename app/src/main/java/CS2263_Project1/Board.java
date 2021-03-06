package CS2263_Project1;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Board class creates an arraylist representing the acquire board and provides methods for manipulating it.
 *
 * @author Noah Owens
 *
 * @version v1.1.0
 */

@Log4j2
public class Board {
    private boolean gameCanEnd;

    //boardArray stores String representations of each tile, and is drawn from for the player's hand right now
    public ArrayList<String> boardArray = new ArrayList<>();

    //tileArray stores the actual Tile objects and their position related to each other.
    public ArrayList<Tile> tileArray = new ArrayList<>();

    @Getter
    @Setter
    public ArrayList<Corporation> corporationTray = new ArrayList<>();

    /**
     * Board constructor calls init method
     */
    public Board() {
        initBoard();
    }

    /**
     * initBoard() fills boardArray with 108 spaces (From a1 to i12), fills corporation tray with the 7 hotel chains
     * and sets the value of gameCanEnd to false, preparing the game board for play.
     */
    private void initBoard() {
        //Make tileArray and then make the tiles recognize each other
        createTiles();
        linkTiles();

        //set gameCanEnd to false
        gameCanEnd = false;

        //create the corporations (should be replaced by a json load I think.)
        initCorporationTray();
    }

    /**
     * fills boardArray with 108 Tile objects (From a1 to i12)
     */
    private void createTiles() {
        int size = tileArray.size();
        int tileCoordNum;
        String tileCoordLetter;

        //Create every letter number combination from 1-12 and A-I to fill boardArray;
        for (char y = 'A'; y <= 'I'; y++) {
            tileCoordLetter = String.valueOf(y);

            for (int x = 1; x <= 12; x++) {
                tileCoordNum = x;

                boardArray.add(tileCoordLetter + String.valueOf(tileCoordNum));
            }
        }

        for (int i = 0; i < boardArray.size(); i++) {
            Tile tile = new Tile(boardArray.get(i), false, null, null, null, null, null, null);
            tileArray.add(i, tile);
        }
    }

    /**
     * Links tiles to each other by assigning all positional fields (left, right, up, down).
     * Tiles above and below any given tile are found by adding/subtracting 12 from current index.
     *
     * I don't know if a 2 dimensional doubly linked list exists, but I just invented a bad one I think
     */
    public void linkTiles() {
        int rowLength = 12;
        int leftTile = 0;
        int rightTile = rowLength - 1;

        for (int i = 0; i < tileArray.size(); i++) {
            Tile currentTile = tileArray.get(i);
            int rowPosition = i % rowLength;

            //Assign Lefts and Rights
            if (i % rowLength != leftTile && i % rowLength != rightTile) {
                currentTile.setLeft(tileArray.get(i-1));
                currentTile.setRight(tileArray.get(i+1));
            }
            else if (i % rowLength == leftTile) {
                currentTile.setRight(tileArray.get(i+1));
            }
            else if (i % rowLength == rightTile) {
                currentTile.setLeft(tileArray.get(i-1));
            }
            else {
                log.info("Something has gone very very wrong in the linkTiles() method");
            }

            //If not out of bounds, setDown
                try {
                    currentTile.setDown(tileArray.get(i + 12));
                }
                catch (Exception e) {
                    currentTile.setDown(null);
                }
            // If not out of bounds, setUp
                try {
                    currentTile.setUp(tileArray.get(i - 12));
                }
                catch (Exception e){
                    currentTile.setUp(null);
                }
            // log.info("Created tile: " + currentTile.nullCheckedToString());
        }
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
        t.setSpent(true);
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
     * the getter for the game's end status, evaluates game end conditions and returns game end status
     *
     * @return true if legal conditions for game end are met, otherwise false
     */
    public boolean getGameCanEnd() {
        checkEndGame();
        return gameCanEnd;
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

    /**
     * Generates a randomized hand of 6 tiles for a player from the current tileArray, removing as they are drawn
     *
     * @return returns an arraylist of 6 random tiles
     */
    public ArrayList<Tile> generatePlayerHand() {
        ArrayList<Tile> hand = new ArrayList<>();

        for(int i = 0; i<6; i++){
            Random rand = new Random();
            int handRand = rand.nextInt(tileArray.size());

            Tile handTile = tileArray.get(handRand);
            hand.add(handTile);

            tileArray.remove(handTile);
        }
        return hand;
    }

    public void shuffleTray() {
        Collections.shuffle(tileArray);
    }

    public Tile askForTile() {
        if (tileArray.isEmpty()) {
            // Draws a dummy tile if the bag of tiles is empty, which should ordinarily not happen before game end.
            return new Tile("XX", false, null, null, null, null, null, null);
        }
        else {
            return tileArray.remove(0);
        }
    }
}



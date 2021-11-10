package CS2263_Project1;

/**
 * @author Noah Owens
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    public boolean gameCanEnd;
    private String[] boardArray = new String[108];

    public Board() {
        initBoard();
    }

    /**
     * initBoard() fills boardArray with 108 spaces (From a1 to i12) and sets the value of gameCanEnd to false,
     * preparing the game board for play.
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

    }

}



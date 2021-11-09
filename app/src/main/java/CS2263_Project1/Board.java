package CS2263_Project1;

/**
 * @author Noah Owens
 */

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
    public boolean gameCanEnd;
    private Tile[] boardArray = new Tile[108];

    public Board() {
        initBoardArray();
    }

    private void initBoardArray() {
        int tileCoordNum;
        String tileCoordLetter;

        //Create every letter number combination from 1-12 and A-I to fill boardArray;
        for (char y = 'A'; y <= 'I'; y++) {
                tileCoordLetter = String.valueOf(y);

            for (int x = 1; x <= 12; x++) {
                tileCoordNum = x;

                System.out.println(tileCoordNum + tileCoordLetter);
            }
        }
    }
}



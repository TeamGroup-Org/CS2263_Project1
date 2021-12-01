package CS2263_Project1;

import java.util.ArrayList;
import java.util.Random;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import org.checkerframework.checker.units.qual.C;
import java.awt.*;

/**
 * Game Board Controller Class contains all methods used as part of the game UI stage
 *
 * @author Coby Garner
 * @author Noah Owens
 */

public class GameBoardController {

    static Banker banker = new Banker();
    static Board gameBoard = new Board();
    private TileTray tileTray = new TileTray(new ArrayList<Tile>());
    private int playerTurn = 1;
    private static final Player player1 = new Player(1,4000, gameBoard.generatePlayerHand(), new ArrayList<>());
    private static final Player player2 = new Player(2,4000, gameBoard.generatePlayerHand(), new ArrayList<>());


    //TileTray p1TileTray = new TileTray();
    // Player player1 = new Player(1,0, ,)
    @FXML
    public Label turnTracker;
    public HBox TileHolder;
    public Label stockList;
    public GridPane gridPane;
    public Label player1Money;
    public Label player2Money;
    public Button endGame;

    //These buttons are meant to be the Player's hand
    public Button tile1; public Button tile2; public Button tile3;
    public Button tile4; public Button tile5; public Button tile6;

    /**
     * Behaviors in the initialize method will be run when gameBoard.fxml is loaded
     */
    @FXML public void initialize() {
        initGridPane();
        updateMoney();
        createStartingHand();
    }

    /**
     * Updates board relevant features (Money totals, tile colors, stock totals)
     */
    public void updateBoard() {
        updateMoney();

        for (int i = 0; i < gameBoard.tileArray.size(); i++) {
            if (gameBoard.tileArray.get(i).isSpent) {
                //CHANGE BACKGROUND COLOR TO Color.color(47,79,79)
            }
        }
    }

    /**
     * Assigns actual Tiles to the player's hand instead of string representations
     *
     * BUT YOU CAN GET DUPLICATES RIGHT NOW WHICH IS BAD REALLY BAD SO LIKE OOPS I'M GONNA FIX IT THOUGH
     */
    public void createStartingHand() {
        tileTray.shuffleTray();

        // Player 1
        for (int i = 0; i < 6; i++) {
            Tile draw = tileTray.askForTile();
            player1.getHand().add(draw);
        }

        // Player 2
        for (int i = 0; i < 6; i++) {
            Tile draw = tileTray.askForTile();
            player2.getHand().add(draw);
        }

        updatePlayerTiles();
    }

    /**
     * Places a tile into the requesting player's hand then refreshes the displayed tiles (hBox buttons in UI)
     *
     * @param p the player drawing the tile
     */
    public void drawTile(Player p) {
        ArrayList<Tile> playerHand = p.getHand();
        Tile drawnTile = tileTray.askForTile();

        playerHand.add(drawnTile);

        updatePlayerTiles();
    }

    public void updateEndButton() {
        if (gameBoard.getGameCanEnd()) {
            endGame.setTextFill(Color.color(64,60,34));
        }
    }

    public void initGridPane() {
        int tileArrayTracker = 0;
        for (int tile_X = 0; tile_X < 9; tile_X++) {
            for (int tile_Y = 0; tile_Y < 12; tile_Y++) {
                Label tileLabel = new Label();

                tileLabel.setText(gameBoard.boardArray.get(tileArrayTracker));

                gridPane.add(tileLabel,tile_Y,tile_X);
                tileArrayTracker++;
            }
        }
    }

    /**
     *
     */
    public void playTile(Tile playedTile) {

    }

    /**
     *
     */
    public void updateMoney() {
        player1Money.setText(String.valueOf(player1.getWallet()));
        player2Money.setText(String.valueOf(player2.getWallet()));
    }

    /**
     *
     */
    public void updatePlayerTiles(){
        if (playerTurn == 1) {
            tile1.setText(player1.getHand().get(0).id);
            tile2.setText(player1.getHand().get(1).id);
            tile3.setText(player1.getHand().get(2).id);
            tile4.setText(player1.getHand().get(3).id);
            tile5.setText(player1.getHand().get(4).id);
            tile6.setText(player1.getHand().get(5).id);
        }
        else if (playerTurn == 2) {
            tile1.setText(player2.getHand().get(0).id);
            tile2.setText(player2.getHand().get(1).id);
            tile3.setText(player2.getHand().get(2).id);
            tile4.setText(player2.getHand().get(3).id);
            tile5.setText(player2.getHand().get(4).id);
            tile6.setText(player2.getHand().get(5).id);
        }
    }

    /**
     * setPlayerTun updates the text of the turnTracker label in the gameboard scene
     */
    public void setPlayerTurn() {
        if (playerTurn == 1) {
            turnTracker.setText("Player 1's turn");
        }
        else if(playerTurn == 2) {
            turnTracker.setText("Player 2's turn");
        }
    }

    /**
     * endTurn causes the game to move into the next player's turn by refreshing player attributes
     * and editing text on the board.
     */
    public void endTurn() {
        //Player turn moves forward
        nextTurn();

        // Updates
        updatePlayerTiles();
        updateBoard();
    }

    /**
     * nextTurn increments init variable playerTurn by one and then modifies it to return either 1 or 2 using
     * modulo division. Calls setPlayerTurn to update the turn counter on the gameboard.
     *
     * @return integer either 1 or 2
     */
    private void nextTurn() {
        playerTurn = playerTurn++ % 2 + 1;
        setPlayerTurn();
    }

    /**
     * Exit game
     */
    public void quitGame() {
        App.stage1.close();
    }
}



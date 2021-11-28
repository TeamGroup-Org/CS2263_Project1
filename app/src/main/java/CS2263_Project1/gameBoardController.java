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

public class gameBoardController {

    static Board gameBoard = new Board();
    private int playerTurn = 1;
    private static final Player player1 = new Player(1,4000, gameBoard.generatePlayerHand(), new ArrayList<>());
    private static final Player player2 = new Player(2,4000, gameBoard.generatePlayerHand(), new ArrayList<>());


    // TileTray p1TileTray = new TileTray();
    // Player player1 = new Player(1,0, ,)
    @FXML
    public Label turnTracker;
    public HBox TileHolder;
    public Label stockList;
    public GridPane gameboard;
    public Label player1Money;
    public Label player2Money;

    //These buttons are meant to be the Player's hand
    public Button tile1; public Button tile2; public Button tile3;
    public Button tile4; public Button tile5; public Button tile6;

    /**
     *
     */
    public void updateBoard() {
        int tileArrayTracker = 0;
        for (int tile_X = 0; tile_X < 9; tile_X++) {
            for (int tile_Y = 0; tile_Y < 12; tile_Y++) {
                Label tileLabel = new Label();

                tileLabel.setText(gameBoard.boardArray.get(tileArrayTracker));

                if (gameBoard.tileArray.get(tile_X + tile_Y).isSpent) {
                    tileLabel.setTextFill(Color.color(1,0,0));
                }

                gameboard.add(tileLabel,tile_Y,tile_X);
                tileArrayTracker++;
            }
        }
    }

    /**
     *
     */
    public void playTile() {

    }

    /**
     *
     */
    public void updateMoney() {
        player1Money.setText(String.valueOf(player1.getPlayerInfo()));
        player2Money.setText(String.valueOf(player2.getPlayerInfo()));
    }

    /**
     *
     */
    public void updatePlayerTiles(){

        if (playerTurn == 1) {
            tile1.setText(player1.getHand().get(0).id);
            player1.getHand().get(0).setSpentStatus();
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

        // Player specific updates
        updatePlayerTiles();
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
    public void quitGame(){
        App.stage.close();
    }

    public void test() {
        updatePlayerTiles();
        updateBoard();
        updateMoney();
    }
}



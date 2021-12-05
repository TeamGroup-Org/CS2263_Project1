package CS2263_Project1;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import lombok.extern.log4j.Log4j2;

/**
 * Game Board Controller Class contains all methods used as part of the game UI stage
 *
 * @author Coby Garner
 * @author Noah Owens
 */

@Log4j2
public class GameBoardController {

    static Banker banker = new Banker();
    static Board gameBoard = new Board();
    private ArrayList<Tile> spentTileStorage = new ArrayList<>();
    private int playerTurn = 1;
    private static final Player player1 = new Player(1,4000, gameBoard.generatePlayerHand(), new ArrayList<>());
    private static final Player player2 = new Player(2,4000, gameBoard.generatePlayerHand(), new ArrayList<>());


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
        updatePlayerTiles();
    }

    /**
     * Updates board relevant features (Money totals, tile colors, stock totals)
     */
    public void updateBoard() {
        updateMoney();

    }

    /**
     * Places a tile into the requesting player's hand
     *
     * @param p the player drawing the tile
     */
    public void drawTile(Player p) {
        gameBoard.shuffleTray();

        ArrayList<Tile> playerHand = p.getHand();
        Tile drawnTile = gameBoard.askForTile();

        playerHand.add(drawnTile);
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
                GridPane.setHalignment(tileLabel, HPos.CENTER);
                tileArrayTracker++;
            }
        }

        log.info("Grid Pane labels created and centered");
    }

    /**
     *
     */
    public void updateMoney() {
        player1Money.setText(String.valueOf(player1.getWallet()));
        player2Money.setText(String.valueOf(player2.getWallet()));

        log.info("Money Totals Updated");
    }

    /**
     * Sets the button text to the IDs of tiles in player hand
     * Stores Actual Tiles into the buttons to be referenced later using getUserId() Method
     */
    public void updatePlayerTiles(){

        switch (playerTurn) {
            case 1: // Nightmarishly long and awful way to do what coby did with the loop
                    // But I think the loop was causing problems in edge cases and the hardcoded one is easier to read.
                    // I'm leaving the loop in, just commented out because I think it's nice and we can go back to it later
                    tile1.setText(player1.getHand().get(0).id);
                    tile1.setUserData(player1.getHand().get(0));

                    tile2.setText(player1.getHand().get(1).id);
                    tile2.setUserData(player1.getHand().get(1));

                    tile3.setText(player1.getHand().get(2).id);
                    tile3.setUserData(player1.getHand().get(2));

                    tile4.setText(player1.getHand().get(3).id);
                    tile4.setUserData(player1.getHand().get(3));

                    tile5.setText(player1.getHand().get(4).id);
                    tile5.setUserData(player1.getHand().get(4));

                    tile6.setText(player1.getHand().get(5).id);
                    tile6.setUserData(player1.getHand().get(5));

                    break;
            case 2: tile1.setText(player2.getHand().get(0).id);
                    tile1.setUserData(player2.getHand().get(0));

                    tile2.setText(player2.getHand().get(1).id);
                    tile2.setUserData(player2.getHand().get(1));

                    tile3.setText(player2.getHand().get(2).id);
                    tile3.setUserData(player2.getHand().get(2));

                    tile4.setText(player2.getHand().get(3).id);
                    tile4.setUserData(player2.getHand().get(3));

                    tile5.setText(player2.getHand().get(4).id);
                    tile5.setUserData(player2.getHand().get(4));

                    tile6.setText(player2.getHand().get(5).id);
                    tile6.setUserData(player2.getHand().get(5));
                    break;
            default: break;
        }

//        ObservableList<Node> buttonList = TileHolder.getChildren();
//
//        if (playerTurn == 1) {
//            int i = 0;
//            for(Node n : buttonList)
//                if (n instanceof Button) {
//                    ((Button) n).setText(player1.getHand().get(i).id);
//                    n.setUserData(player1.getHand().get(i));
//                    i++;
//                }
//        }
//        else if (playerTurn == 2) {
//            int i = 0;
//            for(Node n : buttonList)
//                if(n instanceof Button) {
//                    ((Button) n).setText(player2.getHand().get(i).id);
//                    n.setUserData(player2.getHand().get(i));
//                    i++;
//                }
//            }

        log.info("TileHolder filled with P" + playerTurn + " hand");
    }

    public Tile placeTile(ActionEvent e){

        Button b = (Button) e.getTarget();
        Tile t = (Tile) b.getUserData();
        int buttonIndex = 0;
        int i = -1;
        log.info("placeTile method called on: " + b + ", containing: " + t.nullCheckedToString());

        switch (playerTurn) {
            case 1: player1.playTile(gameBoard, t);
                    t.setOwner(player1);

                    for (Node n : TileHolder.getChildren()) {
                        if (n instanceof Button ) {
                            i++;
                            if (((Button) n).getText() == t.id) {
                                buttonIndex = i;
                            }
                        }
                    }

                    player1.getTileFromHand(buttonIndex);
                    drawTile(player1);

                    break;
            case 2: player2.playTile(gameBoard, t);
                    t.setOwner(player2);

                    for (Node n : TileHolder.getChildren()) {
                        if (n instanceof Button ) {
                            i++;
                            if (((Button) n).getText() == t.id) {
                                buttonIndex = i;
                            }
                        }
                    }

                    player2.getTileFromHand(buttonIndex);
                    drawTile(player2);

                    break;
        }

        log.info(t.nullCheckedToString() + " has been lost forever");
        updatePlayerTiles();
        return t;
    }

    public void mergeCheck(Tile t) {
        // will check a freshly played tile for possible merges and evaluate results
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



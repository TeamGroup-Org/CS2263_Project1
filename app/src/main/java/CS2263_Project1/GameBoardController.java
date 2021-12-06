package CS2263_Project1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;

/**
 * Game Board Controller Class contains all methods used as part of the game UI stage
 *
 * @author Noah Owens
 * @author Coby Garner
 */

@Log4j2
public class GameBoardController {

    private DataManager dataManager = new DataManager();
    
    static Banker banker = new Banker();
    static Board gameBoard = new Board();

    private ArrayList<Tile> spentTileStorage = new ArrayList<>();
    private ArrayList<Tile> branches;
    private ArrayList<Boolean> branchesChecked;
    private int branchTracker;

    private int playerTurn = 1;
    private int playTileLimit = 1;

    private static final Player player1 = new Player(1,4000, gameBoard.generatePlayerHand(), new ArrayList<>());
    private static final Player player2 = new Player(2,4000, gameBoard.generatePlayerHand(), new ArrayList<>());

    @FXML
    public Label turnTracker;
    public HBox TileHolder;
    public Label stockList;
    public GridPane gridPane;
    public Label player1Money;
    public Label player2Money;
    public Pane systemPane;
    public Label infoLabel;
    public Label alertLabel;
    public Button endGame;
    public Label worldwidePlayer1;
    public Label sacksonPlayer1;
    public Label festivalPlayer1;
    public Label imperialPlayer1;
    public Label americanPlayer1;
    public Label continentalPlayer1;
    public Label towerPlayer1;
    public Label worldwidePlayer2;
    public Label sacksonPlayer2;
    public Label festivalPlayer2;
    public Label imperialPlayer2;
    public Label americanPlayer2;
    public Label continentalPlayer2;
    public Label towerPlayer2;

    //These buttons are meant to be the Player's hand
    public Button tile1; public Button tile2; public Button tile3;
    public Button tile4; public Button tile5; public Button tile6;

    /**
     * Behaviors in the initialize method will be run when gameBoard.fxml is loaded
     */
    @FXML public void initialize() {
        // Load in all fields
        initGridPane();
        updateMoney();
        updatePlayerTiles();

        // Set up first player's turn
        determineStartingPlayer();
        setPlayerTurn();
    }

    /**
     * The closest player to A1 becomes the first person to take their turn.
     *
     * @throws IndexOutOfBoundsException if a tile doesn't have a 3 character long id
     */
    public void determineStartingPlayer() throws IndexOutOfBoundsException {
        Tile p1Closest = playClosest(player1);
        Tile p2Closest = playClosest(player2);
        String p1String = "";
        String p2String = "";
        int p1Int;
        int p2Int;

        clearSystemPane();
        updateSpentOnly();

        if (p1Closest.id.charAt(0) < p2Closest.id.charAt(0)) {
            playerTurn = 1;
            infoLabel.setText("Player 1 goes first with tile " + p1Closest.id);
        }

        else if (p1Closest.id.charAt(0) == p2Closest.id.charAt(0)) {
            try {
                p1String = String.valueOf(p1Closest.id.charAt(1)) + String.valueOf(p1Closest.id.charAt(2));
            }
            catch (IndexOutOfBoundsException e) {
                p1String = String.valueOf(p1Closest.id.charAt(1));
            }
            finally {
                p1Int = Integer.parseInt(p1String);
            }

            try {
                p2String = String.valueOf(p2Closest.id.charAt(1)) + String.valueOf(p2Closest.id.charAt(2));
            }
            catch (IndexOutOfBoundsException e) {
                p2String = String.valueOf(p2Closest.id.charAt(1));
            }
            finally {
                p2Int = Integer.parseInt(p2String);
            }

            if (p1Int < p2Int) {
                playerTurn = 1;
            }
        }
        else {
            playerTurn = 2;
            infoLabel.setText("Player 2 goes first with tile " + p2Closest.id);
        }
    }

    /**
     * Find the tile closest to A1 in a given player's hand and plays it to the board
     * Letter proximity is prioritized (B9 is closer than A2)
     *
     * @throws IndexOutOfBoundsException if a tile doesn't have a 3 character long id
     */
    public Tile playClosest(Player p) throws IndexOutOfBoundsException {
        Tile currentClosest = new Tile("Z12", false, null, null, null, null, null, null);
        Tile spentTile;
        String idString;
        String currentClosestIdString;
        int idNum;
        int currentClosestIdNum;
        int i = 0;

        // Iterate through player 1 hand and find the tile closest to A1
        for (Tile t : p.getHand()) {
            i++;
            // If the letter is closer to A, that becomes the current closest
            if (t.id.charAt(0) < currentClosest.id.charAt(0)) {
                currentClosest = t;
            }

            // If the letters are tied, then consider numbers
            else if (t.id.charAt(0) == currentClosest.id.charAt(0)) {
                try {
                    idString = String.valueOf(t.id.charAt(1)) + String.valueOf(t.id.charAt(2));
                }
                catch (IndexOutOfBoundsException e) {
                    idString = String.valueOf(t.id.charAt(1));
                }

                try {
                    currentClosestIdString = String.valueOf(currentClosest.id.charAt(1)) + String.valueOf(currentClosest.id.charAt(2));
                }
                catch (IndexOutOfBoundsException e) {
                    currentClosestIdString = String.valueOf(currentClosest.id.charAt(1));
                }

                idNum = Integer.parseInt(idString);
                currentClosestIdNum = Integer.parseInt(currentClosestIdString);

                if (idNum < currentClosestIdNum) {
                    currentClosest = t;
                }
            }
        }

        // Plays closest tile from hand and draws again
        log.info("Closest tile for player" + p.playerIdentity + " is " + currentClosest.nullCheckedToString());

        for (int j = 0; j < p.getHand().size(); j++) {
            Tile tile = p.getHand().get(j);
            if (tile == currentClosest) {
                p.playTile(gameBoard, tile);
                tile.setOwner(p);

                p.getTileFromHand(j);
                drawTile(p);

                spentTileStorage.add(tile);
            }
        }
        updatePlayerTiles();
        return currentClosest;
    }

    /**
     * Updates the colors of the most recent tile played
     */
    public void updateBoard() {
        for (int i = 0; i < spentTileStorage.size(); i++) {
            for (Node n : gridPane.getChildren()) {
                if (n instanceof Label) {

                    // Spent but unincorporated tiles
                    if (((Label) n).getText() == spentTileStorage.get(i).id && spentTileStorage.get(i).getMemberOf() == null) {
                        n.setStyle("-fx-background-color: #808080;");
                    }

                    // Incorporated tiles
                    else if (((Label) n).getText() == spentTileStorage.get(i).id && spentTileStorage.get(i).getMemberOf() != null) {
                        int corpId = spentTileStorage.get(i).getMemberOf().getId();

                        switch (corpId) {
                            case 1: n.setStyle("-fx-background-color: #639FAB; -fx-text-fill: #FFFFFF;");
                                break;
                            case 2: n.setStyle("-fx-background-color: #81B29A;");
                                break;
                            case 3: n.setStyle("-fx-background-color: #3D405B; -fx-text-fill: #FFFFFF;");
                                break;
                            case 4: n.setStyle("-fx-background-color: #ECCE8E;");
                                break;
                            case 5: n.setStyle("-fx-background-color: #A99AC1;");
                                break;
                            case 6: n.setStyle("-fx-background-color: #FFBA49;");
                                break;
                            case 7: n.setStyle("-fx-background-color: #AD343E; -fx-text-fill: #FFFFFF;");
                                break;
                            default: break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Ensures that all tiles which are on in spentTileStorage and unincorporated recieve a spent background color
     */
    public void updateSpentOnly() {
        for (int i = 0; i < spentTileStorage.size(); i++) {
            for (Node n : gridPane.getChildren()) {
                if (n instanceof Label) {
                    if (((Label) n).getText() == spentTileStorage.get(i).id && spentTileStorage.get(i).getMemberOf() == null) {
                        n.setStyle("-fx-background-color: #808080;");
                    }
                }
            }
        }
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
     * Updates the UI text with current money amount
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
        // Nightmarishly long and awful way to do what coby did with a loop, but the loop broke things
        // So now it's hardcoded
        switch (playerTurn) {
            case 1:
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
    }

    public void placeTile(ActionEvent e){
        Button b = (Button) e.getTarget();
        Tile t = (Tile) b.getUserData();
        Tile spentTile = new Tile();
        int buttonIndex = 0;
        int i = -1;
        log.info("placeTile method called on: " + b + ", containing: " + t.nullCheckedToString());

        if (playTileLimit > 0) {

            switch (playerTurn) {
                case 1:
                    player1.playTile(gameBoard, t);
                    t.setOwner(player1);

                    for (Node n : TileHolder.getChildren()) {
                        if (n instanceof Button) {
                            i++;
                            if (((Button) n).getText() == t.id) {
                                buttonIndex = i;
                            }
                        }
                    }

                    spentTile = player1.getTileFromHand(buttonIndex);
                    drawTile(player1);

                    break;
                case 2:
                    player2.playTile(gameBoard, t);
                    t.setOwner(player2);

                    for (Node n : TileHolder.getChildren()) {
                        if (n instanceof Button) {
                            i++;
                            if (((Button) n).getText() == t.id) {
                                buttonIndex = i;
                            }
                        }
                    }

                    spentTile = player2.getTileFromHand(buttonIndex);
                    drawTile(player2);

                    break;
                default:
                    break;
            }

            updatePlayerTiles();

            spentTileStorage.add(spentTile);
            boolean incorpNotNeeded = mergeCheck(spentTile);

            if (incorpNotNeeded == false) {
                incorporationCheck(spentTile);
            }

            updateBoard();

            infoLabel.setText("Played tile " + spentTile.id);

            playTileLimit--;
        }
        else {
            alertLabel.setText("You can only play 1 tile per turn!!");
            log.info("You can only play 1 tile per turn!!");
        }
    }

    /**
     * Checks a played tile for possible merges and updates owner field. Merges occur when a tile is placed in a way
     * that fills a gap in between two or more corporations, with all tiles from smaller corporation(s) becoming
     * absorbed into the largest one.
     *
     * Rules on multiple mergers found here: https://www.ultraboardgames.com/acquire/game-rules.php
     *
     * @param t the tile being checked for merges
     * @return true if a merge was performed, false otherwise, since incorporationCheck shouldn't happen if a merge took place
     */
    public boolean mergeCheck(Tile t) {
        Tile left = new Tile();
        Tile right = new Tile();
        Tile up = new Tile();
        Tile down = new Tile();

        boolean tileCanMerge = false;
        boolean mergePerformed = false;

        Corporation currentLargest = new Corporation(8, "dummy", false, false, 0);
        Tile checkTile = new Tile();
        int checkLargestSize = 0;
        int currentLargestSize = 0;

        // Null checks
        if (notNull(t.getLeft())) {left = t.getLeft();}
        if (notNull(t.getRight())) {right = t.getRight();}
        if (notNull(t.getUp())) {up = t.getUp();}
        if (notNull(t.getDown())) {down = t.getDown();}

        ArrayList<Tile> mergePartners = new ArrayList<>();

        if (left.getMemberOf() != null || right.getMemberOf() != null || up.getMemberOf() != null || down.getMemberOf() != null) {

            tileCanMerge = true;

            if (left.getMemberOf() != null) {
                mergePartners.add(left);
            }
            if (right.getMemberOf() != null) {
                mergePartners.add(right);
            }
            if (up.getMemberOf() != null) {
                mergePartners.add(up);
            }
            if (down.getMemberOf() != null) {
                mergePartners.add(down);
            }

        }

        if (tileCanMerge) {
            // Determine largest partner
            for (int i = 0; i < mergePartners.size(); i++) {
                checkTile = mergePartners.get(i);

                if (checkTile.isSpent && checkTile.getMemberOf() != null) {
                    checkLargestSize = checkTile.getMemberOf().getSize();
                    currentLargestSize = currentLargest.getSize();

                    if (checkLargestSize > currentLargestSize) {
                        currentLargest = checkTile.getMemberOf();
                    }
                }
            }

            // Merge played tile into nearby corporation
            currentLargest.gainTiles(1);
            t.setMemberOf(currentLargest);

            mergePerformed = true;

            // Clean up any corporations/tiles that need to be absorbed
            if (mergePartners.size() < 0) {
                for (int j = 0; j < mergePartners.size(); j++) {
                    Tile cleanUpTile = mergePartners.get(j);
                    if (cleanUpTile.getMemberOf() == null) {
                        cleanUpTile.setMemberOf(currentLargest);
                        currentLargest.gainTiles(1);
                    }
                    else if (cleanUpTile.getMemberOf() != null){
                        Corporation deadCorp = mergePartners.get(j).getMemberOf();
                        int absorbedSize = deadCorp.getSize();
                        deadCorp.absorbed();

                        currentLargest.gainTiles(absorbedSize);

                        for (Tile s : spentTileStorage) {
                            if (s.getMemberOf() == deadCorp) {
                                s.setMemberOf(currentLargest);
                            }
                        }
                    }
                }
            }
        }

        if (mergePerformed) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Checks a played tile for possible incorporation (a tile is placed in a way that it is not absorbed into a corporation
     * next to at least one other unincorporated tile.)
     *
     * @param t the tile being checked for incorporation
     */
    public void incorporationCheck(Tile t) {
        Tile left = new Tile();
        Tile right = new Tile();
        Tile up = new Tile();
        Tile down = new Tile();

        ArrayList<Tile> partnersList = new ArrayList<>();
        Corporation dummy = new Corporation(8, "dummy", false, false, 0);
        int numPartners = 0;

        // Null checks
        if (notNull(t.getLeft())) {left = t.getLeft();}
        if (notNull(t.getRight())) {right = t.getRight();}
        if (notNull(t.getUp())) {up = t.getUp();}
        if (notNull(t.getDown())) {down = t.getDown();}

        for (Tile tile : spentTileStorage) {
            String name = tile.getId();
            if (name == left.getId() || name == right.getId() || name == up.getId() || name == down.getId()) {
                partnersList.add(tile);
                numPartners++;
            }
        }

        if (partnersList.size() > 0) {
            Corporation playerChoice = incorporateWindow();

            if (playerChoice != dummy) {
                for (Tile p : partnersList) {
                    p.setMemberOf(playerChoice);

                    // Update info in spent tile storage
                    for (int i = 0; i < spentTileStorage.size(); i++) {
                        if (spentTileStorage.get(i).getId() == p.getId()) {
                            spentTileStorage.remove(i);
                            spentTileStorage.add(p);
                        }
                    }
                }

                t.setMemberOf(playerChoice);

                int founderStockValue = playerChoice.getPrice();
                int startingSize = numPartners + 1;

                switch (playerTurn) {
                    case 1: playerChoice.found(player1, startingSize, founderStockValue, playerChoice.getName());
                        break;
                    case 2: playerChoice.found(player2, startingSize, founderStockValue, playerChoice.getName());
                        break;
                    default: break;
                }
            }
            else {
                alertLabel.setText("All corporations founded! Better luck next time.");
            }
        }
        updateStockPane();
    }

    /**
     * incorporateWindow creates the choice dialog that players use to choose their corporation.
     *
     * @return Corporation that player chooses to create
     * @throws IndexOutOfBoundsException if all 7 corporations are already created.
     */
    public Corporation incorporateWindow() throws IndexOutOfBoundsException {
        ArrayList<String> choices = new ArrayList<>();
        Corporation dummy = new Corporation(8, "dummy", false, false, 0); // mitigates edge case where all 7 corps are on the board
        Corporation selectedCorp = new Corporation();

        try {
            for (Corporation c : gameBoard.corporationTray) {
                if (c.getInUse() != true)
                    choices.add(c.getName());
            }

            ChoiceDialog choiceDialog = new ChoiceDialog(choices.get(0), choices);
            choiceDialog.setTitle(" Incorporate Your Tile");
            choiceDialog.setHeaderText("You have been given the opportunity to incorporate!");
            choiceDialog.setContentText("Select a hotel chain from the possible choices for your new company.");
            choiceDialog.showAndWait();

            for (Corporation c : gameBoard.corporationTray) {
                if (c.getName() == choiceDialog.getSelectedItem()) {
                    selectedCorp = c;
                }
            }

            infoLabel.setText("You have founded: " + choiceDialog.getSelectedItem());
        } catch (IndexOutOfBoundsException e) {
            selectedCorp = dummy;
        } finally {
            log.debug("Corporation " + selectedCorp.toString() + " returned");
            return selectedCorp;
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
        // Player turn moves forward
        nextTurn();

        // Updates and reset tile limit
        playTileLimit = 1;
        clearSystemPane();
        updatePlayerTiles();
        updateBoard();
    }

    /**
     * Removes text from info and alert labels to give the next player a clean slate.
     */
    public void clearSystemPane() {
        for (Node n : systemPane.getChildren()) {
            if (n instanceof Label) {
                ((Label) n).setText("");
            }
        }
    }

    public void buyStockWindow() {
        Dialog dialog = new Dialog();

        dialog.setTitle(" NY Stock Exchange");
        dialog.setHeaderText("So you want to buy some stocks, do ya?");
        dialog.setContentText("That's a shame, the stock exchange is down.");

        dialog.show();
        dialog.setHeight(200);

        dialog.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
    }

    /**
     * Makes the stock pane reflect current player portfolios. I'm not proud of this method and I would appreciate it if
     * you wouldn't look at it. Thanks.
     */
    public void updateStockPane() {
        String name;

        // Just a truly upsetting amount of int variables initialized at 0 for tracking stock totals
        int wP1 = 0;
        int sP1 = 0;
        int fP1 = 0;
        int iP1 = 0;
        int aP1 = 0;
        int cP1 = 0;
        int tP1 = 0;
        int wP2 = 0;
        int sP2 = 0;
        int fP2 = 0;
        int iP2 = 0;
        int aP2 = 0;
        int cP2 = 0;
        int tP2 = 0;

        for (Stock s : player1.getPortfolio()) {
            name = s.getCompany();
            switch (name) {
                case "Worldwide": wP1++;
                    break;
                case "Sackson": sP1++;
                    break;
                case "Festival": fP1++;
                    break;
                case "Imperial": iP1++;
                    break;
                case "American": aP1++;
                    break;
                case "Continental": cP1++;
                    break;
                case "Tower": tP1++;
                    break;
                default: break;
            }
        }

        for (Stock s : player2.getPortfolio()) {
            name = s.getCompany();
            switch (name) {
                case "Worldwide": wP2++;
                    break;
                case "Sackson": sP2++;
                    break;
                case "Festival": fP2++;
                    break;
                case "Imperial": iP2++;
                    break;
                case "American": aP2++;
                    break;
                case "Continental": cP2++;
                    break;
                case "Tower": tP2++;
                    break;
                default: break;
            }
        }

        // Updates the UI labels
        worldwidePlayer1.setText(String.valueOf(wP1));
        worldwidePlayer2.setText(String.valueOf(wP2));
        sacksonPlayer1.setText(String.valueOf(sP1));
        sacksonPlayer2.setText(String.valueOf(sP2));
        festivalPlayer1.setText(String.valueOf(fP1));
        festivalPlayer1.setText(String.valueOf(fP2));
        imperialPlayer1.setText(String.valueOf(iP1));
        imperialPlayer2.setText(String.valueOf(iP2));
        americanPlayer1.setText(String.valueOf(aP1));
        americanPlayer2.setText(String.valueOf(aP2));
        continentalPlayer1.setText(String.valueOf(cP1));
        continentalPlayer2.setText(String.valueOf(cP2));
        towerPlayer1.setText(String.valueOf(tP1));
        towerPlayer2.setText(String.valueOf(tP2));
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
     * A quick null status check for tile objects to cut down on bulk in merge and incorporation methods
     *
     * @param t tile being checked for existence
     * @return true if not null, false otherwise
     */
    private boolean notNull(Tile t) {
        return t != null;
    }

    public void saveAndQuit() {
        dataManager.Write(player1, player2, gameBoard);
        App.stage1.close();
    }

    /**
     * Exit game
     */
    public void quitGame() {
        App.stage1.close();
    }
}
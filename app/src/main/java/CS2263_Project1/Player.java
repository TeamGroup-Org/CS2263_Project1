package CS2263_Project1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Player class creates player object with an ID, money, hand for tiles, and portfolio for stocks
 * as well as methods to update those attributes
 *
 * @author David Hellwig
 * @uathor Ekow Barlow
 * @author Noah Owens
 *
 * @version 1.0.0
 */


public class Player {
    private  final int playerIdentity;
    private int wallet;
    private ArrayList<Tile> playerHand;
    private ArrayList<Stock> portfolio;

    /**
     * Parameterized constructor
     *
     * @param playerIdentity ???
     * @param wallet the money posessed by the player
     * @param playerHand a list for tiles
     * @param portfolio a list for stocks
     */
    public Player(int playerIdentity, int wallet, ArrayList<Tile> playerHand, ArrayList<Stock> portfolio) {
        this.playerIdentity = playerIdentity;
        this.wallet = wallet;
        this.playerHand = playerHand;
        this.portfolio = portfolio;
    }

    /**
     * Adds money to a player's wallet
     *
     * @param money integer to be added to wallet
     */
    public void takeMoney(int money) {
        if (money > 0){
            this.wallet += money;
        }
        else{
            this.wallet +=0;
        }
    }

    /**
     * Subtracts money from a player's wallet
     *
     * @param money integer to be subtracted from wallet
     */
    public void spendMoney(int money) {
        if (money > 0){
            this.wallet = this.wallet - money;
        }
        else{
            this.wallet = this.wallet - 0;
        }
    }

    /**
     * Flags tile from player hand as spent
     *
     * @param b game board in use
     * @param t the tile being removed (returned from getTileFromHand())
     */
    public void playTile(Board b, Tile t) {
        b.placeTile(t);
    }

    //  TRADESTOCK() AND SELLSTOCK() WILL BE MERGED
    public void tradeStock(Stock stock, Corporation corporation) {
        stock.setPrice(corporation.getPrice());
    }
    public void sellStock(int i) {
        Stock stock = portfolio.remove(i);
    }

    /**
     * THIS LOOKS LIKE IT DOES SOMETHING BUT IT DOESN'T DO THE RIGHT THING RIGHT NOW
     * @param corporation
     */
    public void foundCorporation(Corporation corporation) {
        corporation.found();
    }

    /**
     * Removes a tile from the player's hand
     *
     * @param index desired tile (should be a number between 0-5)
     * @return tile at passed index
     */
    public Tile getTileFromHand(int index) {
        if (index < playerHand.size()) {
            return playerHand.remove(index);
        }
        return null;
    }

    public ArrayList<Stock> getPortfolio() {return portfolio;}
    public ArrayList<Tile> getHand() {return playerHand;}
    public int getWallet() {return wallet;}
}

package CS2263_Project1;

import java.util.ArrayList;
import java.util.Collections;

/**
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

    //The "deck" that players will draw from to make their hands
    public TileTray tileTray = new TileTray(new ArrayList<Tile>());

    public Player(int playerIdentity, int wallet, ArrayList<Tile> playerHand, ArrayList<Stock> portfolio) {
        this.playerIdentity = playerIdentity;
        this.wallet = wallet;
        this.playerHand = playerHand;
        this.portfolio = portfolio;
    }

    public void takeMoney(int wallet) {
        if (wallet > 0){
            this.wallet += wallet;
        }
        else{
            this.wallet +=0;
        }
    }

    public void spendMoney(int money) {
        if (money > 0){
            this.wallet = this.wallet - money;
        }
        else{
            this.wallet = this.wallet - 0;
        }
    }
    public void playTile(Board b, Tile t)
    {
        b.placeTile(t);
    }
    public void tradeStock(Stock stock, Corporation corporation)
    {
        stock.setPrice(corporation.getPrice());
    }
    public void sellStock(int i)
    {
        Stock stock = portfolio.remove(i);

    }

    public void updatePlayerAttribute()
    {
        //???
    }

    public void foundCorporation(Corporation corporation)
    {
        corporation.found();
    }

    public Tile askForTile() {
        ArrayList<Tile> tray = tileTray.getTray();
        Collections.shuffle(tray);

        if (tray.get(0) == null) {
            return null;
        }
        else {
            return tray.remove(0);
        }
    }

    public Tile getTileFromHand()
    {
        return playerHand.remove(0);
    }

    public ArrayList<Stock> getPrice()
    {
        return portfolio;
    }

    public ArrayList<Tile> getHand(){
        return playerHand;
    }

    public int getPlayerInfo() {
        return wallet;
    }
}

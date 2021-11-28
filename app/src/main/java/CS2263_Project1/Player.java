package CS2263_Project1;

import java.util.ArrayList;

/**
 * @author David Hellwig
 * @uathor Ekow Barlow
 *
 * @version 1.0.0
 */

public class Player {
    private  final int playerIdentity;
    private int wallet;
    private ArrayList<Tile> playerHand;
    private ArrayList<Stock> portfolio;

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
    public void askForTile(TileTray tileTray)
    {
        tileTray.getTray();
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

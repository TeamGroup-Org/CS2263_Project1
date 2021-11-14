package CS2263_Project1;

import java.util.ArrayList;

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
    public void takeMoney(int wallet)
    {
        this.wallet = wallet;
    }

    public void spendMoney(int money)
    {
        this.wallet = this.wallet - money;
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
    public ArrayList getPrice()
    {
        return portfolio;
    }

    public int getPlayerInfo() {
        return wallet;
    }
}

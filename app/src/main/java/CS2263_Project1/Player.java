package CS2263_Project1;

import java.util.ArrayList;

public class Player {
    private int playerIdentity;
    private int wallet;
    private ArrayList playerHand;
    private ArrayList portfolio;

    public Player(int playerIdentity, int wallet, ArrayList playerHand, ArrayList portfolio) {
        this.playerIdentity = playerIdentity;
        this.wallet = wallet;
        this.playerHand = playerHand;
        this.portfolio = portfolio;
    }
    public void takeMoney(int wallet)
    {
        this.wallet = wallet;
    }

    public void spendMoney(int wallet)
    {
        this.wallet = wallet;
    }
    public void playTile(ArrayList playerHand)
    {
        this.playerHand = playerHand;
    }
    public void tradeStock(ArrayList playerHand)
    {
        this.playerHand = playerHand;
    }
    public void sellStock(ArrayList playerHand)
    {
        this.playerHand = playerHand;
    }
    public void updatePlayerAttribute(ArrayList portfolio)
    {
        this.portfolio = portfolio;
    }
    public void foundCorporation(ArrayList portfolio)
    {
        this.portfolio = portfolio;
    }
    public void askForTile(ArrayList playerHand)
    {
        this.playerHand = playerHand;
    }
    public ArrayList getTileFromHand()
    {
        return playerHand;
    }
    public ArrayList getPrice()
    {
        return portfolio;
    }
}

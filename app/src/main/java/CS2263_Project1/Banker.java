package CS2263_Project1;

public class Banker {
    private int newPrice;

    private Player winner;

    /**
     * Gets a new price from corporation
     * @param c gets price from corporation
     */
    public void getNewPrice(Corporation c){

        newPrice = c.getPrice();


    }

    /**
     * Sets a stocks price
     * @param stock stock whose value will be changed
     * @param value value to change stock value to
     */
    public void setStockPrice(Stock stock,int value){
        stock.setPrice(value);

    }

    /**
     * Gives a player a price
     * @param player player
     * @param c corporation to get price from
     */
    public void giveCard(Player player, Corporation c){
        player.getPrice(c.getPrice());

    }

    /**
     * Calculates a players return given bonuses from Corporation
     * @param c corporation
     * @param player player
     */
    public void calculateReturn(Corporation c, Player player){
        int i = c.getMajorityBonus() + c.getMinorityBonus();
        player.takeMoney(i);

    }

    /**
     * Returns the winner of the game
     * @param player1 player 1
     * @param player2 player 2
     * @return winner
     */
    public Player getWinner(Player player1, Player player2){
        if player1.getPlayerInfo() > player2.getPlayerInfo(){
            setWinner(player1);
        }
        else if player2.getPlayerInfo() > player1.getPlayerInfo(){
            setWinner(player2);
        }
        return winner;

    }

    /**
     * Sets the winner of the game
     * @param player
     */
    public void setWinner(Player player){
        this.winner = player;
    }
}

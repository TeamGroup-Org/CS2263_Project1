package CS2263_Project1;

/**
 * @author David Hellwig
 *
 * @version 1.0.0
 */

public class Banker {
    private int newPrice;

    private Player winner;

    public void getNewPrice(Corporation c){

        newPrice = c.getPrice();


    }

    /**
     * Sets stock price
     * @param stock
     * @param value
     */
    public void setStockPrice(Stock stock,int value){
        stock.setPrice(value);

    }

    /**
     * Calculates end game returns
     * @param c
     * @param player
     */
    public void calculateReturn(Corporation c, Player player){
        int i = player.getPlayerInfo() + c.getMajorityBonus() + c.getMinorityBonus();
        player.takeMoney(i);

    }

    /**
     * Returns the winner of the game, or a special placeholder if nobody one
     * @param player1
     * @param player2
     * @return
     */
    public Player getWinner(Player player1, Player player2){
        if (player1.getPlayerInfo() > player2.getPlayerInfo()){
            setWinner(player1);
        }
        else if (player2.getPlayerInfo() > player1.getPlayerInfo()){
            setWinner(player2);
        }
        else if (player1.getPlayerInfo() == player2.getPlayerInfo()){
            setWinner(new Player(99, 0, null, null));
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

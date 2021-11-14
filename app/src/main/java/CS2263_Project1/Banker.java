package CS2263_Project1;

public class Banker {
    private int newPrice;

    private Player winner;

    public void getNewPrice(Corporation c){

        newPrice = c.getPrice();


    }


    public void setStockPrice(Stock stock,int value){
        stock.setPrice(value);

    }


    public void giveCard(Player player, Corporation c){


    }


    public void calculateReturn(Corporation c, Player player){
        int i = c.getMajorityBonus() + c.getMinorityBonus();
        player.takeMoney(i);

    }


    public Player getWinner(Player player1, Player player2){
        if (player1.getPlayerInfo() > player2.getPlayerInfo()){
            setWinner(player1);
        }
        else if (player2.getPlayerInfo() > player1.getPlayerInfo()){
            setWinner(player2);
        }
        return winner;

    }


    public void setWinner(Player player){
        this.winner = player;
    }
}

package CS2263_Project1;

/**
 * @author Noah Owens and Coby Garner
 */

public class Corporation {
    private int id;
    private String name;
    private Boolean inUse;
    private Boolean isSafe;
    private int size;

    /**
     * Parameterized Constructor
     * @param id number used to reference it inside the corporation tray
     * @param name The name of the corporation
     * @param inUse True means the corporation is on the board, False means it is available to found.
     * @param isSafe True when size > 11, determines if the corporation can be absorbed in a merger
     * @param size The number of tiles associated with the corporation, used to determine shareholder bonuses and safetyStatus
     */
    public Corporation(int id, String name, Boolean inUse, Boolean isSafe, int size){
        this.id = id;
        this.name = name;
        this.inUse = inUse;
        this.isSafe = isSafe;
        this.size = size;
    }

    //Getters and Setters
    public String getName() {return name;}
    public boolean getInUse() {return inUse;}
    public boolean getIsSafe() {return isSafe;}
    public int getSize() {return size;}

    /**
     * setName() does not ever need to be used. There are a predetermined number of corporations with definite names.
     * @param name the new name of a corporation object
     */
    public void setName(String name) {this.name = name;}

    /**
     * setInUse() should get regular use. This is changed to true when the corporation is founded on the board
     * and set to false when the corporation is removed from the board (like when losing a merger)
     * @param inUse
     */
    public void setInUse(boolean inUse) {this.inUse = inUse;}

    /**
     * setIsSafe() should get regular use. This is changed to true when the corporation's size becomes >= 11
     * once safe, it should never be changed back to false.
     * @param isSafe
     */
    public void setIsSafe(boolean isSafe) {this.isSafe = isSafe;}

    /**
     * Sets the size of the corporation. gainTiles() should likely be used to increment size upwards since
     * it allows isSafe to become True. setSize() can be used to reset a corporation's size to zero when absorbed
     * in a merger.
     * @param size
     */
    public void setSize(int size) {this.size = size;}

    /**
     * The preferred method for increasing the size of a corporation
     * @param numTilesGained is the number of tiles absorbed into the corporation
     */
    public void gainTiles(int numTilesGained) {
        size += numTilesGained;

        if(size >= 11) {
            setIsSafe(true);
        }
    }

    /* FROM THIS POINT DOWN ARE METHODS WHICH ARE INCLUDED IN THIS CLASS TEMPORARILY
       the functionality of found() and absorbed() should probably become methods
       called foundCorporation and removeCorporation in the Board(?) class, where their
       function will align more with the single purpose principle.
     */

    /**
     * Sets corporation's values to default values for a corporation which has just been played to the board.
     */
    public void found() {
        size = 2;
        inUse = true;
    }

    /**
     * Sets corporation's values to default values for a corporation which has just been taken off the board.
     */

    public void absorbed() {
        size = 0;
        inUse = false;
    }

    /**
     * Gets the proper selling/buying price of each stock in a corporation according to its ID and
     * the size of the corporation
     * @return price is this formatted price
     */

    public int getPrice(){
        int price = 0;
        int numStocks = this.size;
        int corpID = this.id;

        if (1 < numStocks && numStocks < 6) {
            price = numStocks * 100;
        } else if (5 < numStocks && numStocks < 11) {
            price = 600;
        } else if (10 < numStocks && numStocks < 21) {
            price = 700;
        } else if (20 < numStocks && numStocks < 31) {
            price = 800;
        } else if (30 < numStocks && numStocks < 41) {
            price = 900;
        } else if (40 < numStocks) {
            price = 1000;
        }

        //Corporation ID's > 2 get a $100 increase to their prices, ID's > 5 get a $200 increase
        //C
        if (2 < corpID && corpID < 6) {
            price += 100;
        } else if (corpID > 5) {
            price += 200;
        }

        return price;

    }

    /**
     * Gets the calculated minority bonus according to the price of stocks
     * @return returns the calculated minority bonus
     */

    public int getMinorityBonus() {
        return this.getPrice() * 5;
    }

    /**
     * Gets the calculated majority bonus according to the price of stocks
     * @return returns the calculated majority bonus
     */

    public int getMajorityBonus() {
        return this.getPrice() * 10;
    }

}

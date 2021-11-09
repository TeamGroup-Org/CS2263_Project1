package CS2263_Project1;

/**
 * @author David Hellwig
 */

public class Tile {
    boolean isSafe = false;

    boolean isSpent = false;

    /**
     * Sets safe status to true, indicating is safe
     */
    public void setSafeStatus(){
        isSafe = true;
    }

    /**
     * Sets status to true, indicating that it is placed
     */
    public void setSpentStatus(){
        isSpent = true;
    }

}

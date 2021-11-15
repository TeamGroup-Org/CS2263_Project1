package CS2263_Project1;

/**
 * @author David Hellwig
 *
 * @version 1.0.0
 */

public class Tile {
    String id;
    boolean isSpent;

    /**
     * Parameterized tile constructor
     * @param id the letter-number id which determines tile position (from A1-I12)
     * @param isSpent true if tile is used, false otherwise
     */
    public Tile(String id, boolean isSpent){
        this.id = id;

        this.isSpent = isSpent;
    }

    /**
     * Default tile constructor
     */
    public Tile(){}

    /**
     * Sets status to true, indicating that it is placed
     */
    public void setSpentStatus(){
        isSpent = true;
    }

}

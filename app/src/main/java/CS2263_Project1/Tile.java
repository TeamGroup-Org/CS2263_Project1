package CS2263_Project1;

import lombok.Getter;
import lombok.Setter;

/**
 * @author David Hellwig
 * @author Noah Owens
 *
 * @version 1.0.0
 */

public class Tile {

    @Getter
    @Setter
    public String id;

    @Getter
    @Setter
    public boolean isSpent;

    @Getter
    @Setter
    private Corporation memberOf;

    @Getter
    @Setter
    private Player owner;

    @Getter
    @Setter
    private Tile left;

    @Getter
    @Setter
    private Tile right;

    @Getter
    @Setter
    private Tile up;

    @Getter
    @Setter
    private Tile down;

    /**
     * Parameterized tile constructor
     *
     * @param id the letter-number id which determines tile position (from A1-I12)
     * @param isSpent true if tile is used, false otherwise
     * @param memberOf default Null, changes to the corporation that it is merged into
     * @param owner the player that placed the tile, (may be unneeded)
     * @param left the tile to the left (Null if in column 1)
     * @param right the tile to the right (Null if in column 12)
     * @param up the tile above (Null if in row A)
     * @param down the tile beneath (Null if in row I)
     */
    public Tile(String id, boolean isSpent, Corporation memberOf, Player owner, Tile left, Tile right, Tile up, Tile down) {
        this.id = id;
        this.isSpent = isSpent;
        this.memberOf = memberOf;
        this.owner = owner;
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
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

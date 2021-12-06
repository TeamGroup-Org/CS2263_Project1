package CS2263_Project1;

import lombok.Getter;
import lombok.Setter;

/**
 * @author David Hellwig
 * @author Noah Owens
 *
 * @version v1.1.0
 */

public class Tile {

    @Getter
    @Setter
    public String id;

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

    public void setSpent(boolean b) {
        isSpent = b;
    }

    public String nullCheckedToString() {

        String ncId = id;

        String ncIsSpent = String.valueOf(this.isSpent);

        String ncMemberOf = "null";
        if (memberOf != null) { ncMemberOf = this.memberOf.getName(); }

        String ncOwner = "null";
        if (owner != null) { ncOwner = String.valueOf(this.owner.playerIdentity); }

        String ncLeft = "null";
        if (left != null) { ncLeft = this.left.id; }

        String ncRight = "null";
        if (right != null) { ncRight = this.right.id; }

        String ncUp = "null";
        if (up != null) { ncUp = this.up.id; }

        String ncDown = "null";
        if (down != null) { ncDown = this.down.id; }

        return "Tile [id=" + ncId +
                ", isSpent=" + ncIsSpent +
                ", memberOf=" + ncMemberOf +
                ", owner=" + ncOwner +
                ", left=" + ncLeft +
                ", right=" + ncRight +
                ", up=" + ncUp +
                ", down=" + ncDown + "]";
    }
}

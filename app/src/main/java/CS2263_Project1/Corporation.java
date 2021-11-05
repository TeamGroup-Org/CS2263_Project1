package CS2263_Project1;

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
    public Boolean getInUse() {return inUse;}
    public Boolean getIsSafe() {return isSafe;}
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
    public void setInUse(Boolean inUse) {this.inUse = inUse;}

    /**
     * setIsSafe() should get regular use. This is changed to true when the corporation's size becomes <= 11
     * once safe, it should never be changed back to false.
     * @param isSafe
     */
    public void setIsSafe(Boolean isSafe) {this.isSafe = isSafe;}

    /**
     * Sets the size of the corporation. A different method should likely be used to increment size and check if isSafe
     * should become True.
     * @param size
     */
    public void setSize(int size) {this.size = size;}
}

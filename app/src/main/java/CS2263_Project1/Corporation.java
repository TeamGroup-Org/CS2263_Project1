package CS2263_Project1;

public class Corporation {
    private String name;
    private Boolean inUse;

    /**
     * Parameterized Constructor
     * @param name The name of the corporation
     * @param inUse True means the corporation is on the board, False means it is available to found.
     */
    public Corporation(String name, Boolean inUse){
        this.name = name;
        this.inUse = inUse;
    }

    //Getters and Setters
    /**
     * getName()
     * @return name of corporation object
     */
    public String getName() {return name;}

    /**
     * getInUse()
     * @return use status of corporation object
     */
    public Boolean getInUse() {return inUse;}

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
     * toString() makes a simple string representation of a corporation
     * @return string version of object attributes
     */
    @Override
    public String toString() {
        return "Corporation{" +
                "name='" + name + '\'' +
                ", inUse=" + inUse +
                '}';
    }
}

package CS2263_Project1;

public class Building {
    private int isType;
    boolean isSpent;
    private String location;

    public Building(int isType, boolean isSpent, String location) {
        this.isType = isType;
        this.isSpent = isSpent;
        this.location = location;
    }

    public int getIsType() {
        return isType;
    }

    public void setIsType(int isType) {
        this.isType = isType;
    }

    public boolean isSpent() {
        return isSpent;
    }

    public void setSpent(boolean spent) {
        isSpent = spent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

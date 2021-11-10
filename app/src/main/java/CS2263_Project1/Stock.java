package CS2263_Project1;

/**
 * @author David Hellwig
 */

public class Stock {
    private int value;

    private String company;

    /**
     *
     * @return company name
     */
    public String getCompany(){
        return company;
    }

    /**
     *
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     *
     * @param i sets price of stock
     */
    public void setPrice(int i){
        value = i;
    }
}

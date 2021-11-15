package CS2263_Project1;

/**
 * @author David Hellwig
 *
 * @version 1.0.0
 */

public class Stock {
    public Stock(int value, String companyName){
        this.value = value;
        this.company = companyName;
    }
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

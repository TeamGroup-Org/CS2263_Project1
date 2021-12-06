package CS2263_Project1;

/**
 * @author David Hellwig
 *
 * @version v1.1.0
 */

public class Stock {

    private int value;
    private String company;

    public Stock(int value, String companyName){
        this.value = value;
        this.company = companyName;
    }

    public Stock() {}

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
    public void setValue(int i){
        value = i;
    }
}

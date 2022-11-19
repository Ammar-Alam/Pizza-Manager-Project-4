package pizzaclasses;

import java.util.ArrayList;

/**
 * @author Ammar A
 * @author Nikhil G
 */
public class StoreOrders implements Customizable{
    /**
     * List of orders
     */
    private ArrayList<Order> orders;
    /**
     * Adds an object
     *
     * @param obj Object to add
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        return false;
    }

    /**
     * Removes an object
     *
     * @param obj Object to subtract
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        return false;
    }
}

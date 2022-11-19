package pizzaclasses;

import java.util.ArrayList;

/**
 * @author Ammar A
 * @author Nikhil G
 */
public class Order implements Customizable{
    /**
     * Order Number
     */
    private int orderNum;
    /**
     * List of pizzas to order
     */
    private ArrayList<Pizza> orderItems;
    /**
     * Adds an object
     *
     * @param obj Object to add
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Pizza){
            this.orderItems.add((Pizza) obj);
            return true;
        }
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
        if(obj instanceof Pizza && this.orderItems.contains((((Pizza) obj))){
            this.orderItems.remove(obj);
            return true;
        }
        return false;
    }
}

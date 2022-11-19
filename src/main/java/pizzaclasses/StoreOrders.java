package pizzaclasses;

import java.io.FileWriter;
import java.io.IOException;
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

    /**
     * Provides next available order number, which should be the index of the next empty spot in the list
     * @return Return order number
     */
    public int getNextOrderNumber(){
        return orders.size();
    }

    /**
     * Exports store orders as a text file to public desktop
     * @return True if successful, false otherwise
     */
    public boolean export(){
        String storeOrders = "Today's orders:\n";
        for(Order order : orders){
            storeOrders += order.toString() + "\n\n";
        }
        try {
            FileWriter writer = new FileWriter("storeOrders.txt");
            writer.write(storeOrders);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

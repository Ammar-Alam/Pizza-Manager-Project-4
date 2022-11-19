package pizzaclasses;

import java.util.ArrayList;
import java.util.Objects;

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
     * Constructor for order
     * @param orderNum Order number
     */
    public Order(int orderNum) {
        this.orderNum = orderNum;
    }

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
        if(obj instanceof Pizza && this.orderItems.contains((((Pizza) obj)))){
            this.orderItems.remove(obj);
            return true;
        }
        return false;
    }

    /**
     * Getter for order number
     * @return Return order number
     */
    public int getOrderNum() {
        return orderNum;
    }

    /**
     * Getter for list of pizzas in order
     * @return ArrayList of pizzas
     */
    public ArrayList<Pizza> getOrderItems() {
        return orderItems;
    }

    /**
     * New equals method
     * @param o Object to compare
     * @return Return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderNum == order.orderNum;
    }

    /**
     * Creates string representation of order
     * @return Returns string form of order
     */
    @Override
    public String toString() {
        String output = "Order number " + orderNum;
        for(Pizza pizza : orderItems){
            output += "\t" + pizza.toString();
        }
        return output;
    }
}

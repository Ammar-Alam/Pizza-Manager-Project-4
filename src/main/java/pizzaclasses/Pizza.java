package pizzaclasses;

import java.util.ArrayList;

/**
 * @author Ammar A
 * @author Nikhil G
 */
public abstract class Pizza implements Customizable {
    /**
     * List of toppings
     */
    private ArrayList<Topping> toppings;
    /**
     * Crust type
     */
    private Crust crust;
    /**
     * Pizza size
     */
    private Size size;
    /**
     * Maximum number of toppings any pizza can have
     */
    public static final int MAX_TOPPINGS = 7;

    /**
     * Gives price of Pizza
     * @return Returns price
     */
    public abstract double price();
    /**
     * Adds a topping
     *
     * @param obj Topping to add
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean add(Object obj) {
        if(obj instanceof Topping && this.toppings.size() < MAX_TOPPINGS){
            this.toppings.add((Topping) obj);
        }
        return false;
    }

    /**
     * Removes a Topping
     *
     * @param obj Topping to subtract
     * @return Returns true if successful, false otherwise
     */
    @Override
    public boolean remove(Object obj) {
        if(obj instanceof Topping && this.toppings.contains(obj)){
            this.toppings.remove(obj);
            return true;
        }
        return false;
    }

    /**
     * Get crust type
     * @return Crust type
     */
    public Crust getCrust() {
        return crust;
    }

    /**
     * Setter for crust type
     * @param crust Crust type
     */
    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    /**
     * Getter for size
     * @return Size
     */
    public Size getSize() {
        return size;
    }

    /**
     * Setter for size
     * @param size Size to set to
     */
    public void setSize(Size size) {
        this.size = size;
    }
}


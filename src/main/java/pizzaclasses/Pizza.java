package pizzaclasses;

/**
 * @author Ammar A
 * @author Nikhil G
 */
public abstract class Pizza implements Customizable {
    private ArrayList<Topping> toppings;
    private Crust crust;
    private Size size;
    public abstract double price();
}


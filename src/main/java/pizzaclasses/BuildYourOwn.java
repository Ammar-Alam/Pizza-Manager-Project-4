package pizzaclasses;

public class BuildYourOwn extends Pizza{
    /**
     * Small BYO Pizza Price
     */
    private static final double BYO_SMALL_PRICE = 8.99;
    /**
     * Medium BYO Pizza Price
     */
    private static final double BYO_MED_PRICE = 10.99;
    /**
     * Large BYO Pizza Price
     */
    private static final double BYO_LARGE_PRICE = 12.99;
    /**
     * Price per topping
     */
    private static final double TOPPING_COST = 1.59;
    /**
     * Constructor
     *
     * @param crust Crust type
     * @param size  Pizza size
     */
    public BuildYourOwn(Crust crust, Size size) {
        super(crust, size);
    }
    /**
     * Constructor that sets crust
     * @param crust Crust type
     */
    public BuildYourOwn(Crust crust) {
        super(crust);
    }
    /**
     * Gives price of Pizza
     *
     * @return Returns price
     */
    @Override
    public double price() {
        double toppingsCost = TOPPING_COST * this.numToppings();
        switch (this.getSize()){
            case SMALL:
                return BYO_SMALL_PRICE;
            case MEDIUM:
                return BYO_MED_PRICE;
            case LARGE:
                return BYO_LARGE_PRICE;
        }
        return BYO_SMALL_PRICE;
    }
}

package tests;
import org.junit.jupiter.api.Test;
import pizzaclasses.BuildYourOwn;
import pizzaclasses.Crust;
import pizzaclasses.Size;
import pizzaclasses.Topping;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This is the J-Unit tester for the BuildYourOwn Class. It will compare double values using the assertEquals statement
 * In accordance with Black-box testing, the values tested will be at the price boundaries (upper and lower) as well as in between the boundaries with different toppings
 * @author Ammar A
 * @author Nikhil G
 * */
class BuildYourOwnTest
{
    /**
     * This tests the price of a small BuildYourOwn pizza without any toppings
     */
    @Test
    void validSmallPriceTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.SMALL;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        assertEquals(8.99, byoPizza.price());
    }

    /**
     * This tests the price of a small BuildYourOwn pizza without any toppings. It tests the minimum boundary
     */
    @Test
    void nonValidSmallPriceTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.SMALL;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        assertEquals(false, byoPizza.price() == 8.98);
    }

    /**
     * This tests the price of a medium BuildYourOwn pizza without any toppings
     */
    @Test
    void validMedPriceTotal()
    {
        Crust crustType = Crust.PAN;
        Size sizeType = Size.MEDIUM;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        assertEquals(10.99, byoPizza.price());
    }

    /**
     * This tests the price of a small BuildYourOwn pizza without any toppings. It tests the medium price value.
     */
    @Test
    void nonvalidMedPriceTotal()
    {
        Crust crustType = Crust.PAN;
        Size sizeType = Size.MEDIUM;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        assertEquals(false, byoPizza.price() == 10.98);
    }

    /**
     * This tests the price of a large BuildYourOwn pizza without any toppings
     */
    @Test
    void validLargePriceTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.LARGE;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        assertEquals(12.99, byoPizza.price());
    }

    /**
     * This tests the price of a large BuildYourOwn pizza without any toppings. It tests the large price value
     */
    @Test
    void nonvalidLargePriceTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.LARGE;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        assertEquals(false, byoPizza.price() == 12.98);
    }

    /**
     * This tests the price of a small BuildYourOwn pizza with 7 toppings
     */
    @Test
    void validSmallPriceToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.SMALL;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.BBQ_CHICKEN);
        byoPizza.add(Topping.SAUSAGE);
        byoPizza.add(Topping.ONION);
        byoPizza.add(Topping.PEPPERONI);
        byoPizza.add(Topping.PROVOLONE);
        byoPizza.add(Topping.GREEN_PEPPER);
        byoPizza.add(Topping.HAM);
        assertEquals(20.12, byoPizza.price());
    }

    /**
     * This tests the price of a medium BuildYourOwn pizza with 7 toppings
     */
    @Test
    void validMedPriceToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.MEDIUM;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.BBQ_CHICKEN);
        byoPizza.add(Topping.SAUSAGE);
        byoPizza.add(Topping.ONION);
        byoPizza.add(Topping.PEPPERONI);
        byoPizza.add(Topping.PROVOLONE);
        byoPizza.add(Topping.GREEN_PEPPER);
        byoPizza.add(Topping.HAM);
        assertEquals(22.12, byoPizza.price());
    }

    /**
     * This tests the price of a large BuildYourOwn pizza with 7 toppings
     */
    @Test
    void validLargePriceToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.LARGE;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.BBQ_CHICKEN);
        byoPizza.add(Topping.SAUSAGE);
        byoPizza.add(Topping.ONION);
        byoPizza.add(Topping.PEPPERONI);
        byoPizza.add(Topping.PROVOLONE);
        byoPizza.add(Topping.GREEN_PEPPER);
        byoPizza.add(Topping.HAM);
        assertEquals(24.12, byoPizza.price());
    }

    /**
     * This tests the price of a large BuildYourOwn pizza with 7 toppings. It tests the upper boundary of pizza prices.
     */
    @Test
    void nonvalidLargePriceToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.LARGE;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.BBQ_CHICKEN);
        byoPizza.add(Topping.SAUSAGE);
        byoPizza.add(Topping.ONION);
        byoPizza.add(Topping.PEPPERONI);
        byoPizza.add(Topping.PROVOLONE);
        byoPizza.add(Topping.GREEN_PEPPER);
        byoPizza.add(Topping.HAM);
        assertEquals(false, byoPizza.price()==24.13);
    }

    /**
     * This tests the price of a small BuildYourOwn pizza with 3 toppings. The rounding of the double is accounted for in CurrentOrderController.java
     */
    @Test
    void validSmallPriceThreeToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.SMALL;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.MUSHROOM);
        byoPizza.add(Topping.CHEDDAR);
        byoPizza.add(Topping.BEEF);
        assertEquals(13.76, Math.round(byoPizza.price()*100.0)/100.0);
    }

    /**
     * This tests the price of a medium BuildYourOwn pizza with 3 toppings. The rounding of the double is accounted for in CurrentOrderController.java
     */
    @Test
    void validMedPriceThreeToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.MEDIUM;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.MUSHROOM);
        byoPizza.add(Topping.CHEDDAR);
        byoPizza.add(Topping.BEEF);
        assertEquals(15.76, Math.round(byoPizza.price()*100.0)/100.0);
    }

    /**
     * This tests the price of a large BuildYourOwn pizza with 3 toppings.
     */
    @Test
    void validLargePriceThreeToppingsTotal()
    {
        Crust crustType = Crust.HAND_TOSSED;
        Size sizeType = Size.LARGE;
        BuildYourOwn byoPizza = new BuildYourOwn(crustType,sizeType);
        byoPizza.add(Topping.MUSHROOM);
        byoPizza.add(Topping.CHEDDAR);
        byoPizza.add(Topping.BEEF);
        assertEquals(17.76, byoPizza.price());
    }
}